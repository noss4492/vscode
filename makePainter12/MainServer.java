package makePainter12;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

// 죽음의 코드 무덤
//	Dequeue<Socket> clientSocket
//	HashMap<Integer, Integer> userinfo = new HashMap<Integer, Integer>(4);	// 유저 정보
//	UserInfo[] userinfo = new UserInfo[8]; // 유저 정보
//	Socket[] clientSocket = new Socket[4];
//	ArrayList<MServer> clientList = new ArrayList<MServer>();	// (클라이언트)쓰레드 배열
//					clientSocketList.get(MAX_USER).close(); // 이거는 arraylist를 9칸으로 만드는 방법으로 구현해야함.(귀찮)
// if(clientSocketList.get(i).isClosed == false) clientSocketList.get(i).close();
//						nowExaminer = userinfo.get(i).getSeq(); // 출제자의 seq(유저순서번호)를 가져옴
//						examiner = userinfo.get(i).getSeq();	//다음 seq인 사람이 출제자가 되어야함
// 출제자 소켓 clientSocketList.get(i)
//							is.close();
//							bis.close();
//							ois.close();
//
//						os = clientSocketList.get(min).getOutputStream();
//						bos = new BufferedOutputStream(os);
//						oos = new ObjectOutputStream(bos);
//
//						oos.writeObject(userinfo.get(min));
//						oos.flush();
//						os.close();
//						oos.close();
//						bos.close();
//		BufferedOutputStream bos = null;
//		ObjectOutputStream oos = null;
//		OutputStream os = null;
/////////////////// error:소켓에 같은 값이 들어가고 있음 구역 시작(아니었음 다른 내부 포트로 잡히고 있었음. 문제가 없었다.)////////////////////
// 문제는 저 밑에 멀티캐스트 좌표 쏴주는 부분에서 뭔 희안하게 5글자인가 get해서 쓰는게 잘못 잡혀 있어서 그랬었다. 
// 덕분에 알수없는 에러로 고통받음... 
// 멀티캐스트 송신에 문제가 있었던 것 이 5글자 찾아서 바꾸는데 7~8시간 걸림
// 교훈 : 백업을 잘하자. 전날에는 분명 잘 돌아가게 만들어놨었었다.
/////////////////// error:소켓에 같은 값이 들어가고 있음 구역 끝////////////////////
//							userinfo.add(new UserInfo(min, true));
//							userinfo.add(new UserInfo(min, false));
//						MServer ms = new MServer(clientSocketList.get(min));
//						System.out.println("Mserver ms에 추가되는 tmpSocket:" + tmpSocket);
//						System.out.println("Mserver ms :" + ms);
//						System.out.println("msList : " + msList);
//						for (int i = 0; i < msList.size(); i++) {
//							System.out.println("msList.get(" + i + ") [" + msList.get(i) + "]");
//						}
//						System.out.println("==================================");
//						clientSocketList.add(ss.accept());

// 일단은 수신용 목적으로 만드는 멀티쓰레드 서버
// 서버는 지속적을 동작되고 감시하고 있어야 한다.
// clientSocketList의 index에 해당되는 소켓에(각 client에) userinfo를 가지고 있을 수 있도록 직렬화해서 하나씩 보낼 예정임. 

// vStart() 메서드에 대한 설명
// 들어오면 비어있는 번호에 유저 번호를 부여한다.
// 일단은 채팅, 페인팅 시의 String, (ArrayList X, Y) 데이터들을 모두 한 소켓에서 받는다.

// 저쪽에서 클라이언트가 소켓으로 이쪽 ip와 port를 지정하였으면 accept해서 들을 수 있을 것이다.
// ClientSocket 과 userInfo는 동일한 인덱스로 짝을 맞춰서 사용할 것

// 비어있는 유저의 가장 낮은 번호에 연결하기
// 비어있는 seq번호 검색 후 가장 낮은 값을 찾는다
// 11010000 -> 한명이 나간 경우 maker의 예시

// min값에 유저가 들어갈 순번이(가장 낮게 비어있는 곳)이 정해진다. 이제 여기에다 넣고 연결하면된다.

public class MainServer {
	private ServerSocket ss; // 서버의 소켓
	private ArrayList<Socket> clientSocketList = new ArrayList<Socket>(); // 연결된 클라이언트 소켓 배열을 담는다.
	private ArrayList<UserInfo> userinfo = new ArrayList<UserInfo>(); // 위 소켓으로 유저 정보(상태)를 보내기 위해서
	private ArrayList<MServer> msList = new ArrayList<MServer>(); // 클라이언트 담당 쓰레드 ArrayList
	int examiner = 0; // 출제자 번호, 출제자 지정시 사용. 초기값 0번
	int sPort = 5000;
	static int cnt = 0;
	static final int MAX_USER = 4; // 이 노트북이 과연 8명까지 버틸 수 있을까? 일단 8->4

	public MainServer() { // 메인서버 쓰레드에서 유저 입장/퇴장 검사 기능을 수행함.
		vStart(); // 단일 쓰레드(소켓 연결 검사를 지속적으로 수행), 생성하면 서버의 지속적인 검사가 실행됨
	}

	public static void main(String[] args) {
		new MainServer(); // 어차피 한번 실행되고 거의 끝까지 종료되지 않는 인스턴스라 참조값을 담지 않았음
	}

	public void vStart() {
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		try {
			ss = new ServerSocket(sPort); // 서버의 소켓을 준비시킨다.
			// 서버단에서 클라이언트의 종료를 판단하는 패킷이 필요함. 클라이언트에서 closePacket을 받으면 어레이리스트에서 삭제, 쓰레드 free
			while (true) { // 서버는 지속적으로 검사한다.
				// ----------------------------- 클라이언트 접속 구역 시작 -----------------------------
				if (clientSocketList.size() <= MAX_USER) { // size 8 일때 index 9 까지 생기게된다. (안에서 index 9 case는 무시)
					// userInfo의 유저 순번(seq) 검색과정 | 중간에 나가서 빈 유저 번호가 생기면 그 번호부터 채워서 유저 번호가 매겨진다.
					if (clientSocketList.size() < 8) {
						int min = 0;
						int[] maker = { 0, 0, 0, 0, 0, 0, 0, 0 }; // user seq marker
						for (int i = 0; i < clientSocketList.size(); i++) {
							maker[userinfo.get(i).getSeq()] = 1; // 현재 userinfo[]에 들어있는 seq번호를 mark해둔다.
						}
						for (int i = 0; i < MAX_USER; i++) {
							if (maker[i] == 0) { // mark되지 않은 순번을 받기 위함, 낮은것 부터
								min = i;
								break;
							}
						}
						// 연결 & 유저 정보 부여
						// 이제 클라이언트 소켓과 연결, 유저 정보를 기입 | 클라이언트 소켓을 향하여 유저 정보를 보낸다.
						boolean wIsExaminer;
						// clientSocketList 인자 8개 까지만 생성되게 제한되어있음
						Socket tmpSocket = ss.accept();
						clientSocketList.add(tmpSocket);
						System.out.println("현재 연결된 clientSocketList : " + clientSocketList);
						for (int i = 0; i < clientSocketList.size(); i++) {
							System.out.println("clientSocketList.get(" + i + ")" + clientSocketList.get(i) + "]");
						}
						if (min == examiner) { // 입장자가 출제자순번에 들어오면 userInfo 출제자 flag = true
							// 여기서 add하는 것이 아니라 뒤에서 클라이언트에서 받은 정보와 다시 합쳐서add함
							wIsExaminer = true;
						} else {
							wIsExaminer = false;
						}

						// 클라이언트에 대응되는 각 쓰레드 동작을 구현하는 MServer Class
						// 연결될 때 마다 각 클라이언트를 담당하는 쓰레드 MServer를 돌린다. 반대로 종료시 Thread.close()해줄것
						MServer ms = new MServer(tmpSocket);
						msList.add(ms);
						ms.start();

						// 1. 일단 유저가 로그인시 보낸 정보를 바탕으로 userinfo에 기입함

						ois = new ObjectInputStream(new BufferedInputStream(clientSocketList.get(min).getInputStream()));
						Object obj; // userNickname
						String nickname = null;
						String monType = null;
						try {
							obj = ois.readObject();
							if (obj instanceof UserInitializePacket) {
								// 읽어들인 정보가 UserInitializePacket type 이라면
								// 바로 또 다시 클라이언트로 보내서 유저가 가지고 있을 정보를 초기화시켜주자.
								nickname = ((UserInitializePacket) obj).getNickname();
								monType = ((UserInitializePacket) obj).getMonsterType();
								// 새로운 유저가 가지게될 완성된 초기 userinfo (위치, 출제자인지, 닉네임, 포인트, 몬스터타입)
								userinfo.add(new UserInfo(min, wIsExaminer, nickname, 0, monType));
								
								UserInitializePacket makeInitUserInfo = new UserInitializePacket(min, wIsExaminer, nickname, 0, monType);
								
								oos = new ObjectOutputStream(new BufferedOutputStream(clientSocketList.get(min).getOutputStream()));
								oos.writeObject(makeInitUserInfo);
								oos.flush();
							}
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}


						System.out.println("잘 들어가고 있나 한번 확인함\nseq|isExaminer|nickname");
						System.out.println("[순번:"+min+"]|[출제자:" + wIsExaminer + "]|[닉넴:" + nickname+"]");

						// 2. 서버 상태를 반영하여 유저의 userinfo 정보를 업데이트하여 다시 보내줌
						// 이정도는 단일 쓰레드로 돌려도 그렇게 막 느려지거나 그렇진 않겠죠? ' ';;; 살며시 접속시 유저 정보만 소켓으로 보내봄

						// 이 부분은 클라이언트 갯수의 쓰레드에서 각각 보내야함.

						System.out.println("현재 입장자에게 " + min + "번이 부여되었음");
						System.out.println("현재 입장자에게 유저정보  seq :" + userinfo.get(min).getSeq());
						System.out.println("현재 입장자에게 유저정보  flag:" + userinfo.get(min).isExaminer());
						System.out.println("현재 접속한 유저 소켓" + clientSocketList.get(cnt) + " size:" + userinfo.size());

					} else {
						System.out.println("접속허용인원 초과");
						// 방법1. 소켓 연결을 무시하고(대기하다가 timeout) + 해당 클라이언트로 안내 메세지를 보낸다. (이 블럭에 아무것도 안써놔도 됨)
						// 방법2. 직접 받아서 받자마자 끊는다.
//						Socket overedClient = ss.accept();
//						overedClient.close();
					}
				} else {
					// clientSocketList.size() == 9 부터 여기로 들어오게 됨
					// 위에서 8일때 더는 생성되지 못하게 로직을 구현하였으므로 이 블럭에 올 일은 없음.
					// clientSockList.remove(MAX_USER+1);
				}
				// ----------------------------- 클라이언트 접속 구역 끝 -----------------------------

				// -------------------------- 클라이언트 연결(종료) 체크 구역 시작 --------------------------
				// 이 방법으로 안됨 ㅠ.ㅠ 클라이언트에서 close()시 서버로 종료단에 몬가 메세지를 write해야 할듯 ㅠ.ㅠ
				// isConnected 메서드는 연결 성공한 적이 있으면 true로 되는 flag같은 성격이 있으므로 isClosed 메서드의 부정과 같이
				// 써서 연결을 판별한다.
				/*
				 * for(int i = 0; i < clientSocketList.size(); i++) {
				 * System.out.println("isConn, !isClosed");
				 * System.out.println(clientSocketList.get(i).isConnected());
				 * System.out.println(!(clientSocketList.get(i).isClosed()));
				 * if(clientSocketList.get(i).isConnected() &&
				 * (!(clientSocketList.get(i).isClosed())) == false) {
				 * System.out.println("유저 접속 종료 발견됨 i:"+i); // 종료가 발견됨 i번째 열을 삭제
				 * clientSocketList.remove(i); userinfo.remove(i); break; } }
				 */
				// -------------------------- 클라이언트 연결(종료) 체크 구역 끝 ----------------------------

				// ---------------------- 게임 진행상황에 따른 유저 정보 갱신 구역 시작 --------------------------
				// 게임 동작을 나눠보자
				// 동시간대 일어나는 동작
				// | 게임이 시작된다 | 카운트가 시작된다 | (지금의) examiner가 true인 사용자가 문제를 출제한다 |

				// ArrayList(BoxedStrokePoint(StrokePointArrX, StrokePointArrY)가 송수신 되는 과정
				// 출제자(examiner가 true인 사용자)의 ArrList 정보를 받아온다. (요기는 이 메인 서버 쓰레드에서?)
				// 다른 클라이언트들에게 전송한다. (요기는 각 클라이언트 담당 쓰레드에서)

				// 여기까지는 그림이 다른 클라이언트들에게 전송되는 과정
				///////////////////////////////////////////

				// 유저의 채팅 정보를 받아온다.
				// 해당 유저의 채팅 정보가 정답과 일치하면
				// (정답인 경우니까)

				// -------------- 다음 문제로 넘어가기 전 출제자를 바꾸는 방법(완성됨) -----------------------
				// 정답인 경우에 출제자를 바꾼다.
				// 여기서부터 말하는 순서는 유저seq가 아니라 위의 socketArrayList 순서임.
				// 유저의 seq정보를 받아서 갱신하는 것이 훨씬 멋있고 좋지만 작성 편의를 위해 이렇게 되었음
				// 이렇게 작성된다면 동작은 먼저 접속한 유저 순으로 출제자 순서가 돌아갈 것임.

//				int nowExaminer = 0;
//				for (int i = 0; i < userinfo.size(); i++) {
//					if (userinfo.get(i).isExaminer() == true) { // 출제자의 seq(유저순서번호)를 가져옴
//						nowExaminer = i; // 그냥 ArrayList에서의 순번을 가져오자
//					}
//				}
//				if (nowExaminer == userinfo.size()) { // 만약 끝번에 있던 유저가 출제자였다면
//					userinfo.get(nowExaminer).setExaminer(false);	// 해당 유저는 출제자에서 내려오고
//					for(int i = 0; i < userinfo.size(); i++) {
//						userinfo.get(i).setExaminer(true);	// 다음 유저가 출제자가 되어야함
//						break;
//					}
//				} else {
//					for (int i = nowExaminer; i < userinfo.size(); i++) {
//						if (i != nowExaminer) { // 출제자가 아니었던 유저에게 다시 출제 권한을 부여하기 위함
//							// 만약에 한번이라도 움직여서 다음 번호로 간다면
//							userinfo.get(nowExaminer).setExaminer(false);
//							userinfo.get(i).setExaminer(true);
//							break;
//							// 유저 정보 갱신되면 다시 소켓 통신으로 뿌려줘야함
//						}
//					}
//				}

				// -------------- 다음 문제로 넘어가기 전 출제자를 바꾸는 방법(완성됨) -----------------------

//				if(nowExaminer == userinfo.size()-1) {
//				}
				// seq의 다음 seq 번호를 가져옴 -> Max시 index 0 부터 다시 체크
//				userinfo.get(i).getSeq()를 검색 -> ex) 0 1 0 3
				// 하드코딩으로 구현하는게 낫지 않을까? case 1, 2, 3 ...
//				switch(case) {
//				}
				// inputstream시 instanceof 로 들어온 데이터 타입을 판별해서 사용한다. (게임 / 채팅)
				// ---------------------- 게임 진행상황에 따른 유저 정보 갱신 구역 끝 ----------------------------
// 연결되어 있음을 확인
//	boolean connected = (tmpCli.isConnected()) && (!(tmpCli.isClosed()));
			} // while(true) end
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("[test] 서버 포트가 문제가 있는듯요");
//			msList.remove(this);// 문제시 삭제
		} // try to ServerSocket ready end
	} // vStart() method end

//		BufferedOutputStream bos = null;
//		OutputStream os = null;
//		InputStream is = null;
//		ObjectInputStream ois = null;
//		BufferedInputStream bis = null;

	// 여기서도 userinfo ArrayList<UserInfo> 에 접근이 가능함. 내부 클래스라서 말이죠
	//
//		InputStream is = null;
//		BufferedInputStream bis = null;
	class MServer extends Thread {
		Socket client;
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		Object obj;

//		ois = new
		// 각각 대상 클라이언트 소켓을 가진다, vStart에서 생성됨.
//		ObjectOutputStream oos = null;
		public MServer(Socket client) {

			this.client = client;
			System.out.println("--------------------------------------");
			System.out.println("각각의 클라이언트가 접속했을때 쓰레드 출력 :" + this);
			System.out.println(client.getInetAddress().getHostAddress());
		}

//			ois = new ObjectInputStream(new BufferedInputStream(client.getInputStream()));
//				ArrayList<Integer> x = new ArrayList<Integer>();
//				ArrayList<Integer> y = new ArrayList<Integer>();
//					System.out.println("----[서버] 유저가 그린 paint좌표 -----------");
//					oos = new ObjectOutputStream(new BufferedOutputStream(client.getOutputStream()));
//							x = ((BoxedStrokePoint) obj).getPointX();
//							y = ((BoxedStrokePoint) obj).getPointY();
//							for (int i = 0; i < ((BoxedStrokePoint) obj).getPointX().size(); i++) {
//								System.out.printf("[server] [x:%3d], [y:%3d]\n",
//										((BoxedStrokePoint) obj).getPointX().get(i),
//										((BoxedStrokePoint) obj).getPointY().get(i));
//							}
//		System.out.println("-------[서버] 좌표 출력----------");
		@Override
		public void run() {
			// 각 클라이언트들에서 여기로 오는 inputstream들을
			// 여기서 지속적으로 수신 검사 해야함
			while (true) {
				try {
					ois = new ObjectInputStream(new BufferedInputStream(client.getInputStream()));
					if (!ois.equals(null)) { // ois에 무언가 담겨있다면
						obj = ois.readObject(); // ois를 읽어들여 객체에 담아서 서버에서 사용한다.
						if (obj instanceof BoxedStrokePoint) { // 클라이언트에서 보낸 Paint좌표를 담고 있다면
							multicastDrawCanvasMirror(obj); // 서버에서 이를 출제자를 제외한 연결된 모든 클라이언트들에게 뿌려준다.
						} else if (obj instanceof UserInfoPacket) { // 수신된 정보가 UserInfo를 담고 있다면
							// 회원 정보를 서버에서 받았을떄 (각 유저에게서)

						}
//						else if (obj instanceof boxedChatMsg~~) {
//							
//						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}

		void multicastDrawCanvasMirror(Object obj) {
			int cnt = 0;
			System.out.println("msList.size가 궁금해" + msList.size());
			for (int i = 0; i < msList.size(); i++) {
				try {
					if (msList.get(i).client != this.client) { // 그림 그린 당사자한테는 오지 않음.
						msList.get(i).oos = new ObjectOutputStream(new BufferedOutputStream(msList.get(i).client.getOutputStream()));
						if (obj instanceof BoxedStrokePoint) {
							System.out.println("msList.get(" + i + ").client :" + msList.get(i).client);
							System.out.println("obj : " + obj);
							msList.get(i).oos.writeObject((BoxedStrokePoint) obj);
							msList.get(i).oos.flush();
						} else {
							System.out.println("그림 그린 당사자에게는 브로드캐스트 하지 않음");
						}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		void broadcastUserInfo() {

		}

	}
}
//			for (MServer x : msList) { // @.@ 이쪽 구문이 처음부터 문제가 없었는데 이상한데를 보고 고치고 있었네....
//					try {
//						System.out.println("x"+x+"| cnt:"+cnt);
//						// 여기 client == (x.clinet)
//						x.oos = new ObjectOutputStream(new BufferedOutputStream(client.getOutputStream()));
//						if(obj instanceof BoxedStrokePoint) {
//							System.out.println("obj : " + obj);
//							x.oos.writeObject((BoxedStrokePoint)obj);
//							x.oos.flush();
//						}
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//					cnt++;
//			}

//			for(int i = 0; i<clientSocketList.size(); i++) {
//				if (msList.get(i).client == this.client) {
//					System.out.println("내가 그렸어 나야나");
//				} else {
//					System.out.println("다른 사람이 그린 좌표를 받았어!");
//					try {
//						oos = new ObjectOutputStream(new BufferedOutputStream(client.getOutputStream()));
//						msList.get(i).oos.writeObject(obj);
//						msList.get(i).flush();
//						System.out.println("모든 유저에게 좌표값을 보낸다. 제발 에러 그만 ㅠ.ㅠ");
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
// 아마도 이럴 것
// x.oos.objectWrite(userinfo.get(i))
// x.oos.flush;

// 이 부분은 클라이언트 갯수의 쓰레드에서 각각 보내야함.
// 유저 정보 broadcast해야함.

//			int nowIndex = 0;
//			for(int i = 0 ; i< clientSocketList.size(); i++) {
//					if(client == clientSocketList.get(i)) {
//						nowIndex = i;
//						break;
//					}
//			}
//			System.out.println(nowIndex);
//			try {
//				oos = new ObjectOutputStream(new BufferedOutputStream(client.getOutputStream()));
//				oos.writeObject(userinfo.get(nowIndex));
//				System.out.println("nowIdx:"+nowIndex+" oos hash:"+oos);
//				System.out.println("userinfo.get(now) :"+userinfo.get(nowIndex));
//				
//				oos.flush();
//				oos.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//				System.out.println("끼요오");
//			}

// 로그인 하는 유저가 있다면. (소켓이 연결된다면)

// 소켓 연결을 성사하고
// 어레이 리스트에 추가

// 방에 몇명인지 계속체크
// 어레이리스트 사이즈 체크

// MAX보다 높으면 연결 비성사
// max-1값일때 비허용 상태로 전환하는 방법을 쓰는게 나을듯

// 유저 퇴장시 논리 작성
// 유저가 퇴장하면 발생하는 이벤트 ? ->
// 유저 퇴장시 해당 소켓 bind()

// 체크한 다음부터 게임이 시작될 것이야

// 여기부터는 게임의 동작 구현부

// ㅠ.ㅠ

// nested inner class
//	class MServer extends Thread { // 여기서 병렬적으로 처리되어야 할 멀티쓰레드 부분을 생성함.
//		Socket client; // 여기서는 인자 하나만 가지고 있겠지
//
//		// 받을때는 list.get 이렇게 client의 인자를 받아야함
//		public MServer(Socket Client) {
//		}
//
//		@Override
//		public void run() {
//			System.out.println("끼욧");
//		}
//
//	}