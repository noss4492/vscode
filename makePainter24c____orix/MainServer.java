package makePainter24c____orix;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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

public class MainServer {
	SimpleDateFormat format2 = new SimpleDateFormat("yyyy/MM/dd  HHH mmM ssS");
	StringBuffer chatLog = new StringBuffer(); // 당신이 쓰는 모든 채팅. 기록되고 있었다.
	private ServerSocket ss; // 서버의 소켓
	private ArrayList<Socket> clientSocketList = new ArrayList<Socket>(); // 연결된 클라이언트 소켓 배열을 담는다.
	static private ArrayList<UserInfo> userinfo = new ArrayList<UserInfo>(); // 위 소켓으로 유저 정보(상태)를 보내기 위해서
	private ArrayList<MServer> msList = new ArrayList<MServer>(); // 클라이언트 담당 쓰레드 ArrayList
	int examiner = 0; // 출제자 번호, 출제자 지정시 사용. 초기값 0번
	int sPort = 5000;
	static int cnt = 0;
	static final int MAX_USER = 4; // 이 노트북이 과연 8명까지 버틸 수 있을까? 일단 8->4->2
	static int interval = 1; // 서버 타임 체크 간격 (꽤 정확해짐)
	final static int MAX_GAME_TIME = 30; // 게임 진행시간
//	final static int INTERVAL_TIME = 10;	// 대기 시간이 있었는데 시간관계상 생략
	public static int srvTimerTime = 0;
	public static int setTimerEndTime = MAX_GAME_TIME; // MAX_GAME_TIME
	public static boolean inGameFlag = true; // now
	public static boolean inGameFlagPrev; // t-1
	public static boolean swCheckFlag;
	public static ArrayList<String> quizDB = new ArrayList<String>();
	public static String ansWord;
	static boolean isAnswerFlag = false;
	static int bufferSeq = 0;
	static int doubleBufferSeq = 0;
	static int minSeq;
	static int maxSeq;

	// 왜인지 모르겠지만 타이머 여러종류 만들어 봤는데 잘 작동이 안됨... 왜죠?
	// 스테틱에 올려두고 쓰기가 좀 꺼림칙한데... 서버에 시계 딱 하나 있는건데 안되나?
	// 머리가 지끈하다. 쓰레드 제어 방법 찾다가 그냥 스태틱에 올려두고 쓰기로..
	static {
		Runnable sesTimer = new Runnable() { // 얘의 flag를 체크하는 쓰레드를 따로 만들어서 다 시 작 성 해 보 자
			@Override
			public void run() {
				inGameFlagPrev = inGameFlag;
				if (inGameFlag == false) { // 게임중이 아니라면 타이머 시작
//					System.out.print("서버시간" + (srvTimerTime) + "|" + inGameFlag);
					srvTimerTime = 0;// 타이머 다시 설정하고
					inGameFlag = true;
					srvTimerTime++;
				} else if (inGameFlag == true) {
//					System.out.print("서버시간" + (srvTimerTime) + "|" + inGameFlag);
					srvTimerTime++;
					if (srvTimerTime == setTimerEndTime) { // 시간 다됨
//						System.out.print("시간다됨");
						inGameFlag = false;
					}
				}
//				System.out.print("서버시간" + (srvTimerTime) + "|" + inGameFlag);
				if (inGameFlagPrev != inGameFlag) {
					swCheckFlag = true;
//					System.out.print("바껴따! swf:" + swCheckFlag + "\n");
				} else {
					swCheckFlag = false;
//					System.out.print("그대로. swf:" + swCheckFlag + "\n");
				}
				if (swCheckFlag == true && inGameFlag == true) { // 해당 조건이면 게임이 시작되었다고 판단함.
				} else if (swCheckFlag == true && inGameFlag == false) { // 해당 조건이면 게임이 끝났다고 판단함.
				}
			}
		};
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		service.scheduleAtFixedRate(sesTimer, 0, interval, TimeUnit.SECONDS);
//		System.out.println("interval = " + interval);
	}

	public MainServer() { // 메인서버 쓰레드에서 유저 입장/퇴장 검사 기능을 수행함.
		dbReceive();
		vStart(); // 단일 쓰레드(소켓 연결 검사를 지속적으로 수행), 생성하면 서버의 지속적인 검사가 실행됨
	}
	public static void main(String[] args) {
		// 서버 타이머는 한개로도 충분하므로 여기에 하나로 생성
		new MainServer(); // 어차피 한번 실행되고 거의 끝까지 종료되지 않는 인스턴스라 참조값을 담지 않았음
//		int timeM = 12000;
//		int timeW = 5000;
	}

	public void dbReceive() {
		CatchMindDAO dao = new CatchMindDAO();
		ArrayList<CatchMindVO> tmpArr = dao.wordSelectAll();
//		System.out.println("size : "+tmpArr.size());// 50

		for (int i = 0; i < tmpArr.size(); i++) {
//			System.out.println("i :"+i+"| word"+tmpArr.get(i).getWord());
			String tmp = tmpArr.get(i).getWord();
			quizDB.add(tmp);
		}
		// DB 완성!
//		System.out.println("완성된DB출력해보기");
		ansWord = quizDB.get((int) (Math.random() * 50)); // 첨문제 랜덤으로 하나 선택함
//		quizDB.remove(quizDB.indexOf(ansWord)); // 해당 단어는 서버의 arraylist에서 삭제됨.
		System.out.println("첫번째 문제 여기서 생성됨, 가지고 있는 리스트에서 삭제" + ansWord); // 다음번 문제는 게임 종료시 생성됨
	}

	public void vStart() {
		ObjectInputStream ois = null;
		try {
			ss = new ServerSocket(sPort); // 서버의 소켓을 준비시킨다.
			// 서버단에서 클라이언트의 종료를 판단하는 패킷이 필요함. 클라이언트에서 closePacket을 받으면 어레이리스트에서 삭제, 쓰레드 free
			while (true) { // 서버는 지속적으로 검사한다.
				// ----------------------------- 클라이언트 접속 구역 시작 -----------------------------
				if (clientSocketList.size() <= MAX_USER + 1) { // size 8 일때 index 9 까지 생기게된다. (안에서 index 9 case는 무시)
					// 추가해줘야한다.
					// userInfo의 유저 순번(seq) 검색과정 | 중간에 나가서 빈 유저 번호가 생기면 그 번호부터 채워서 유저 번호가 매겨진다.
					if (clientSocketList.size() == MAX_USER) {
						Socket imClosedSocket = ss.accept();

						ObjectOutputStream oosToDeny = new ObjectOutputStream(
								new BufferedOutputStream(imClosedSocket.getOutputStream()));
//						ClosePacket a = new ClosePacket();
//						oosToDeny.writeObject(a);
						oosToDeny.writeObject(new ClosePacket());
//						imClosedSocket.close();	// 소프트웨어 에러 발생함. 자원 문제가 있는듯
					} else {
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
						// 여기서 add하는 것이 아니라 뒤에서 클라이언트에서 받은 정보와 다시 합쳐서add함
						if (min == examiner) // 입장자가 출제자순번에 들어오면 userInfo 출제자 flag = true
							wIsExaminer = true;
						else
							wIsExaminer = false;

						// 클라이언트에 대응되는 각 쓰레드 동작을 구현하는 MServer Class
						// 연결될 때 마다 각 클라이언트를 담당하는 쓰레드 MServer를 돌린다. 반대로 종료시 Thread.close()해줄것
						MServer ms = new MServer(tmpSocket);// , userinfo);
						msList.add(ms);
						ms.start();
						// 테스트해보고 삭제 해볼 것.
//						ms.unicastDisplayInfo(tmpSocket); // 이러면 문제 생길 가능성이 다분함. 
						// 테스트해보고 삭제 해볼 것.

						// 1. 일단 유저가 로그인시 보낸 정보를 바탕으로 userinfo에 기입함
						ois = new ObjectInputStream(
								new BufferedInputStream(clientSocketList.get(min).getInputStream()));

						Object obj; // userNickname
						String nickname = null;
						String monType = null;

						try {
							obj = ois.readObject();
							if (obj instanceof UserInitializePacket) {
								// 읽어들인 정보가 해당 클래스(UserNicknamePacket) 타입이라면
								nickname = ((UserInitializePacket) obj).getNickname();
								monType = ((UserInitializePacket) obj).getMonsterType();
								// UserInitializePacket에 유저 접속 허용 X 라는 boolean type의 변수를 추가해서 통신에 쓰는것도 좋을듯
							} else if (obj instanceof DisplayInfoPacket) {
								new Thread(() -> { // Wa..
									ms.broadcastUserInfo();
								});
							}
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}

						// 새로운 유저가 가지게될 완성된 초기 userinfo (위치, 출제자인지, 닉네임, 포인트, 몬스터타입)
						userinfo.add(new UserInfo(min, wIsExaminer, nickname, 0, monType));
						// [의문] 과연 서버가 유저 info 데이터 어레이를 가지고 있을 필요가 있을까? 어차피 게임 시작하면 계속 유저에서 줄텐데?
						
						new Thread(() -> { // 해당 구문은 클라이언트들과 1:1로 연결되어 작동되기 떄문에 브로드캐스팅이 아니라 단일통신인 메서드를 작성하여야함
//							System.out.println("0000000000000000000");
							minSeq = 99;
							maxSeq = -1;
							bufferSeq = minSeq;
							while (true) {
//								System.out.println(swCheckFlag+"|"+inGameFlag);
								try {
									// 여기에 ois로 수신 부분 구현
									// 여기에서 유저 정보가 갱신되면 서버에서 가지고 있는 유저 정보도 같이 갱신되어야함.
									Thread.sleep(1000); // 일정 간격을 두고 타이머를 감시함.
									if (swCheckFlag == true && inGameFlag == true) { // 게임 시작됨
//										System.out.println("----게임이 시작됐구나!");	// 유저 정보가 필요하니까 달라고 요청함
//										broadcastChatting("\n게임이 시작되었습니다.\n");//메세지 통신 기반으로 만들걸 ㅠ.ㅠ
										broadcastWantInfo();
										System.out.println("게임 시작");
//										unicastWantInfo(client);
										// 시작때 단어를 준다? -> 유저들에게 뿌린다
									} else if ((swCheckFlag == true && inGameFlag == false && isAnswerFlag == false) || // <<
									(isAnswerFlag == true)) { // + flag : user correct
										// 유저가 정답이면 무조건 게임 종료 or 타이머종료 논리 성립시 (유저 정답 못 맞추면) // 겹칠 수 있어서 이렇게 작성함
//										synchronized (ms) {
										System.out.println("게임 끝");
										System.out.println("f[sw|ingame|answer]" + swCheckFlag + "|" + inGameFlag + "|"
												+ isAnswerFlag);
										// 유저가 정답 플래그를 보내면. 게임 종료 플래그를 바꾸고 여기서 플래그를 보고 판단함.
										srvTimerTime = 0;
//										System.out.println("----게임이 끝났구나!");	// 끝났으니 유저 정보를 갱신함
										// 게임이 끝나면 유저 정보 다시 갱신
//										broadcastChatting("게임이 끝났습니다.\n\n");//메세지 통신 기반으로 만들걸 ㅠ.ㅠ
										int nowExaminer = 0;
										int nowExamArrIdx = 0;

//											buffer = 
										if (minSeq != bufferSeq) {// 이 러면 바뀐 거라고 인식 할 수 있을듯. 대신 처음 동작이 없기 때문ㅇ ㅔ처음은 true로
											this.wait();
//											wait();
										} // 해야함
//											if(buffer)
										if (userinfo.size() > 1) {
											for (int i = 0; i < userinfo.size(); i++) {
												if (userinfo.get(i).isExaminer() == true) { // 출제자의 seq(유저순서번호)를 가져옴
													nowExaminer = userinfo.get(i).getSeq(); // 배열 안의 seq
													nowExamArrIdx = i;
													maxSeq = userinfo.get(i).getSeq() > maxSeq
															? userinfo.get(i).getSeq()
															: maxSeq;
												}
											}
											System.out.println("maxSeq : " + maxSeq);
//											for (int i = 0; i < userinfo.size(); i++) {
//											} // maxSeq
											if (nowExaminer == userinfo.size() - 1) { // 만약 seq끝번에 있던 유저가 출제자였다면
												userinfo.get(nowExaminer).setExaminer(false); // 해당 유저는 출제자에서 내려오고
												for (int i = 0; i < userinfo.size(); i++) {// 젤 seq 가 낮은 사람이 검색됨
													minSeq = minSeq > userinfo.get(i).getSeq()
															? userinfo.get(i).getSeq()
															: minSeq;
												}
												userinfo.get(minSeq).setExaminer(true); // 젤 seq 낮은 사람이 출제자로
												System.out.println("체크된 출제자 minSeq :" + minSeq);
												/// 여기서 보내야함
											} else {
												for (int i = 0; i < userinfo.size(); i++) {
													if (userinfo.get(i).getSeq() == userinfo.get(nowExaminer).getSeq()
															+ 1) {
														minSeq = i;
														userinfo.get(nowExaminer).setExaminer(false);
														userinfo.get(minSeq).setExaminer(true);
														System.out.println("체크된 출제자 i : " + i);
														break;
													}
												}
											}
											// 여기로 오는 결과값은 minSeq.

											bufferSeq = minSeq;
											doubleBufferSeq = minSeq;

											// 1이던 2이던 minSeq값이 서치된 순서의 유저

											// 이값을 버퍼에 담아놓고
											// 이 값이 이전 버퍼 값이 아니라면 동작 수행을 중단

										}
//										ms.unicastUserInfo(ms.client);
//										ms.unicastDisplayInfo(ms.client);
										broadcastUserInfo();
										broadcastDisplayInfo();
//										}
//										mnicastUserInfo(client);
//										unicastDisplayInfo(client);
//												unicastUserInfo(client, userinfo.get(minSeq));
//												unicastDisplayInfo(client, userinfo.get(minSeq));
//														unicastUserInfo(client, userinfo.get(i));
//														unicastDisplayInfo(client, userinfo.get(minSeq));

//											for (int i = 0; i < userinfo.size(); i++) { // 일반 상황에서
//												if (i != nowExaminer) { // 출제자가 아니었던 유저에게 다시 출제 권한을 부여하기 위함
//													// 내 다음번 seq인 사람에게 가야됨.
//													System.out.println("다음 출제자는 :"+userinfo.get(i).examiner);
//													break;
//													// 유저 정보 갱신되면 다시 소켓 통신으로 뿌려줘야함
//												}
//											}

//										if(nowExaminer == userinfo.size()-1) {
//											for(int i = 0 ; i < userinfo.size(); i++) {
//												minSeq = minSeq > userinfo.get(i).getSeq() ? userinfo.get(i).getSeq() : minSeq;
//											}
//											nowExaminer = minSeq;
//										}
				//userinfo.get(i).getSeq()를 검색 -> ex) 0 4 3 1    0134 << 연속적이지 않다면 스택에 쌓아서..(근데 귀찮음) 
										// seq의 다음 seq 번호를 가져옴 -> Max시 index 0 부터 다시 체크

//										broadcastUserInfo();
//										broadcastDisplayInfo();

										// 다시 리스트에서 랜덤한 워드를 뽑아옴.
										ansWord = quizDB.get((int) (Math.random() * quizDB.size()));
//										quizDB.remove(quizDB.indexOf(ansWord));
										System.out.println("문제 출제됨, 정답 : " + ansWord);
										Thread.sleep(300);

										// 유저에게 뿌린다.
										try {
											for (int i = 0; i < msList.size(); i++) {
												msList.get(i).oos = new ObjectOutputStream(new BufferedOutputStream(
														msList.get(i).client.getOutputStream()));
												QuizWordsPacket qwp = new QuizWordsPacket(ansWord);
												msList.get(i).oos.writeObject(qwp);
												msList.get(i).oos.flush();
											}
										} catch (IOException ioe) {
											ioe.printStackTrace();
										}
										// 다음 게임으로 넘어가니까 다시 유저 정답 플래그를 false로 바꿈
										isAnswerFlag = false;
									}
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						}).start();
						
						// 2. 서버 상태를 반영하여 유저의 userinfo 정보를 업데이트하여 다시 보내줌
						// 이정도는 단일 쓰레드로 돌려도 그렇게 막 느려지거나 그렇진 않겠죠? ' ';;; 살며시 접속시 유저 정보만 소켓으로 보내봄
//						ms.broadcastDisplayInfo();
						// 이 부분은 클라이언트 갯수의 쓰레드에서 각각 보내야함.

						System.out.println("잘 들어가고 있나 한번 확인함\nseq|isExaminer|nickname");
						System.out.println("[순번:" + min + "]|[출제자:" + wIsExaminer + "]|[닉넴:" + nickname + "]");
						System.out.println("현재 입장자에게 " + min + "번이 부여되었음");
						System.out.println("현재 입장자에게 유저정보  seq :" + userinfo.get(min).getSeq());
						System.out.println("현재 입장자에게 유저정보  flag:" + userinfo.get(min).isExaminer());
						System.out.println("현재 접속한 유저 소켓" + clientSocketList.get(min) + " size:" + userinfo.size());
//						ms.broadcastDisplayInfo();	// 여긴듯?
					}
				} else {
					// 별 일 없을 때...
				}
				// 방법1. 소켓 연결을 무시하고(대기하다가 timeout) + 해당 클라이언트로 안내 메세지를 보낸다. (이 블럭에 아무것도 안써놔도 됨)
				// 방법2. 직접 받아서 받자마자 끊는다.
				// 현재는 유저가 들어와 짐. (!!) 무시해도 소용 없음. 저쪽에서 연결한 걸 끊어야함. 여기서도 소켓으로 종료해달라는 패킷을 보내야할듯
//						Socket overedClient = ss.accept();
//						overedClient.close();
//					}
				// clientSocketList.size() == 9 부터 여기로 들어오게 됨
				// 위에서 8일때 더는 생성되지 못하게 로직을 구현하였으므로 이 블럭에 올 일은 없음.
				// clientSockList.remove(MAX_USER+1);
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

				// -------------- 다음 문제로 넘어가기 전 출제자를 바꾸는 방법(완성됨) -----------------------

				// 하드코딩으로 구현하는게 낫지 않을까? case 1, 2, 3 ...
//				switch(case) {
//				}
				// inputstream시 instanceof 로 들어온 데이터 타입을 판별해서 사용한다. (게임 / 채팅)
				// ---------------------- 게임 진행상황에 따른 유저 정보 갱신 구역 끝 ----------------------------
			} // while(true) end
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("[test] 서버 포트에 문제가 있는듯");
//			msList.remove(this);// 문제시 삭제
		} // try to ServerSocket ready end
//		catch(SocketException e) { // 이 예외는 내가 컨트롤할 수 없는 부분에 있음 ㅠ.ㅠ
//			System.out.println("유저나갔으니지워~~");
//		}
	} // vStart() method end
	
	void broadcastUserInfo() { // ArrayList<UserInfo> userinfo 안줘도 되는데 걍 혹시 몰라서 주고있음
		for (int i = 0; i < msList.size(); i++) { // 뭐 msList랑 userinfo랑 짝이니까 사이즈는 상관없음
			try {
//				System.out.println("유저님들에게 유저정보 갱신해서 드림");
				msList.get(i).oos = new ObjectOutputStream(
						new BufferedOutputStream(msList.get(i).client.getOutputStream()));
				UserInfoPacket uip = new UserInfoPacket(userinfo.get(i));
//				System.out.println("UIP 클라이언트 : " + msList.get(i).client + "에게 보낸다" + uip);
				if (uip instanceof UserInfoPacket) {
					msList.get(i).oos.writeObject((UserInfoPacket) uip);
					msList.get(i).oos.flush();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	void broadcastDisplayInfo() { // ArrayList<UserInfo> userinfo아 분리해야하는데 귀찮아 걍 다 보내
		for (int i = 0; i < msList.size(); i++) { // 뭐 msList랑 userinfo랑 짝이니까 사이즈는 상관없음
			try {
//				System.out.println("유저님들에게 화면 정보 전송함");
				msList.get(i).oos = new ObjectOutputStream(
						new BufferedOutputStream(msList.get(i).client.getOutputStream()));
				DisplayInfoPacket dip = new DisplayInfoPacket(userinfo);
//				System.out.println("DIP 클라이언트 : " + msList.get(i).client + "에게 보낸다" + dip);
				if (dip instanceof DisplayInfoPacket) {
					msList.get(i).oos.writeObject((DisplayInfoPacket) dip);
					msList.get(i).oos.flush();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	void broadcastWantInfo() { // ArrayList<UserInfo> userinfo아 분리해야하는데 귀찮아 걍 다 보내
		for (int i = 0; i < msList.size(); i++) { // 뭐 msList랑 userinfo랑 짝이니까 사이즈는 상관없음
			try {
//				System.out.println("클라이언트님들아 유저 정보좀");
				msList.get(i).oos = new ObjectOutputStream(
						new BufferedOutputStream(msList.get(i).client.getOutputStream()));
				ProtocolPacket pp = new ProtocolPacket(1);
//				System.out.println("PP 클라이언트 : " + msList.get(i).client + "에게 보낸다" + pp);
				if (pp instanceof ProtocolPacket) {
					msList.get(i).oos.writeObject((ProtocolPacket) pp);
					msList.get(i).oos.flush();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	class MServer extends Thread {
		Socket client;
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		Object obj;
//		ArrayList<UserInfo> userinfo;	// local tmp  -> X

		public MServer(Socket client) {// , ArrayList<UserInfo> userinfo) {
//			this.userinfo = userinfo;
			this.client = client;
			System.out.println("--------------------------------------");
			System.out.println("client socket :" + client);
			System.out.println("각각의 클라이언트 소켓에 대응되는 쓰레드 :" + this);
			System.out.println("--------------------------------------");
//			synchronized(msList) {
//			}
		}

		@Override
		public void run() {
			// 각 클라이언트들에서 여기로 오는 inputstream들을
			// 여기서 지속적으로 수신 검사 해야함
			while (true) {
				try {
					// JOIN 예상 지점
					ois = new ObjectInputStream(new BufferedInputStream(client.getInputStream()));
//					if (!ois.equals(null)) { // ois에 무언가 담겨있다면
					obj = ois.readObject(); // ois를 읽어들여 객체에 담아서 서버에서 사용한다.
					if (obj instanceof StrokePointPacket) { // 클라이언트에서 보낸 Paint좌표를 담고 있다면
						multicastDrawCanvasMirror(obj); // 서버에서 이를 출제자를 제외한 연결된 모든 클라이언트들에게 뿌려준다.
					} else if (obj instanceof UserInfoPacket) {
						// 유저 정보를 받았을 때 ? 가 필요한가? 어차피 서버에서 유저 정보를 계속 다 가지고 있는데?
						// 서버가 유저 정보를 받아서 리스트에 넣는 부분과 서버가 게임 종료후 유저에게 뿌리는 동작을 추적해보자.
						// 게임 시작시 유저 정보를 받을 필요가 있나? 있다. 생각해보니까 있어! 유저 정보는 지속적으로 게임마다 갱신되고 있으므로 ' ' ;;;
						// 게임 시작시 유저 정보를 받아서 저장하는 구역이 되겠다.

						// 유저 정보를 받아다가 어레이리스트에 넣어서 가지고 있짜
						// 어떻게 할까?
						// clientSocketList.indexOf(client) < 소켓리스트 해당 번째에 있는 유저, 인덱스는 소켓리스트와 유저인포가 짝이니까
						// 짝이 맞는 인덱스 위치에 수신한 패킷 뜯어서 userinfo type 자료를 넣는다.
						userinfo.set(clientSocketList.indexOf(client), ((UserInfoPacket) obj).getInfoBox());
						System.out.println("서버에서 유저 정보를 갱신함.\n --------------------------------------" + "\n|nick    : "
								+ ((UserInfoPacket) obj).getInfoBox().getNickname() + "\n|seq     : "
								+ ((UserInfoPacket) obj).getInfoBox().getSeq() + "\n|isExam  : "
								+ ((UserInfoPacket) obj).getInfoBox().isExaminer() + "\n|point   : "
								+ ((UserInfoPacket) obj).getInfoBox().getPoint() + "\n|montype : "
								+ ((UserInfoPacket) obj).getInfoBox().getMonsterType() + "\n");
					} else if (obj instanceof ChatPacket) {
						// 서버가 유저의 채팅을 받아서 버퍼에 쓰는 부분
						chatLog.append(
								"[" + ((ChatPacket) obj).getSender() + "] : " + ((ChatPacket) obj).getMsg() + "\n");

						System.out.println("-------------[Server Chatting log]-------------");
						System.out.println("[system time :" + format2.format(System.currentTimeMillis()) + "]");
						System.out.println(chatLog);
						System.out.println("-----------------------------------------------");

						if (((ChatPacket) obj).getMsg().equals(ansWord)) { // .contains(ansWord)) { // 만약 유저가 입력한 msg에
																			// 정답이 포함되어 있다면// == +"\n") {
							// 유저가 쓴 메세지가 정답 워드라면
							// 유저가 입력한 msg 가 정답이라면 this.client에게 +1 점 , 게임 종료 플래그 전달,
//							if ( msg == ansWord ) {	// 만약 유저가 입력한 msg가 정답단어라면
//							}
							System.out.println("이 유저 정답이야!!! 게임 끝내고 담겜해!");
							isAnswerFlag = true;
						}
						// 모든 유저에게 채팅로그의 마지막 라인 브로드캐스트
						// 마지막 \n 무시하고 그 전에 있는 \n의 위치부터 끝까지 잡으면 마지막 줄이 된다.
						// 아니면 마지막 전 줄의 \n +1 부터 마지막 줄의 \n 인덱스까지 잡자.
						String msg = null;
						if (chatLog.length() > 0) {
							if (chatLog.lastIndexOf("\n", chatLog.length() - 2) < 0) { // 한줄인 경우, 여기 김밥 한줄이요
								msg = chatLog.substring(0, chatLog.lastIndexOf("\n"));
							} else {
								msg = chatLog.substring(chatLog.lastIndexOf("\n", chatLog.length() - 2),
										chatLog.lastIndexOf("\n"));
							}
						}

						//////////////////////////////////////////
						// 여기에서 유저 메세지 한줄로 존재함
						if (msg != null) {
							broadcastChatting(msg);
						}
					} else if (obj instanceof ProtocolPacket) {
						if (((ProtocolPacket) obj).getDefinedCase() == 999) { // 유저 스크린 클리어 전체 송신
							// multicast all user(자기 자신은 제외)
							multicastAllUserClrScr(obj);
						}
					}
//					}
//					new Thread(() -> {
//						System.out.println("지금 쓰레드 잘도나?");
//					}).start();

				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
//				new Thread(() -> {
//					while(true) {
//						if (swCheckFlag == true && inGameFlag == true) {
//							System.out.println("게임이 시작됐구나!");
//							broadcastUserInfo();
//							broadcastDisplayInfo();
//						} else if (swCheckFlag == true && inGameFlag == false) {
//							System.out.println("게임이 끝났구나!");
//							broadcastWantInfo();
//						}
//					}
//				}).start();
				// 유저가 4명 있다면

				// svrTime|inGameFlag| swCheckFlag
//				서버시간0|true그대로. swf:false
//				서버시간1|true그대로. swf:false
//				서버시간2|true그대로. swf:false
//				서버시간3|true그대로. swf:false
//				서버시간4|true그대로. swf:false
//				서버시간5|true그대로. swf:false
//				서버시간6|true그대로. swf:false
//				서버시간7|true그대로. swf:false
//				서버시간8|true그대로. swf:false
//				서버시간9|true시간다됨 swf:true <<<< 종료 포인트
//			      서버시간10|false바껴따!swf:true <<<< 시작 포인트
//				서버시간1|true그대로. swf:false
//				서버시간2|true그대로. swf:false
//				서버시간3|true그대로. swf:false
//				서버시간4|true그대로. swf:false
//				서버시간5|true그대로. swf:false
//				서버시간6|true그대로. swf:false
//				서버시간7|true그대로. swf:false
//				서버시간8|true그대로. swf:false
//				서버시간9|true시간다됨 swf:true
//				서버시간10|false바껴따! swf:true

				// 아니 왜 안돼 쓰레드라도 더 써봐?
//				new Thread(() -> {
//					System.out.println("잘도니");
//				}).start();
				// 서버가 유저 정보를 클라이언트에 요청
				// 유저 정보를 받아오고
//							broadcastWantInfo();
//					inGameFlag = false; // 타이머 시작(게임 시작)
//					swCheckFlag = true;
//					srvTimerTime = 10; // next time 0 -> 1

//				}).start();

				// sw flag가 on 되면 게임이 끝난 것이다.
				// 또는 유저가 정답을 맞추거나

				// 그러면 다시 서버가 유저 정보를 갱신해서 뿌려준다.(브로드캐스트유저인포 쓰자)

				/// 게임 시작
//				if(inGameFlag == true) {
//					srvTimerTime = 0;
//					setTimerEndTime = 10;
//					inGameFlag = false;
//					System.out.println("게임시작!, 타이머 시간 세팅함 f->t");
//				}else {
//					System.out.println("게임 진행중" + (srvTimerTime)+"|"+inGameFlag);
//					if(srvTimerTime==10) {
//						System.out.println("타이머 시간 다대따");
//						inGameFlag = true;
//					}
//				}
//				
			}
		}

		void multicastDrawCanvasMirror(Object obj) {
			int cnt = 0;
			for (int i = 0; i < msList.size(); i++) {
				try {
					if (msList.get(i).client != this.client) { // 그림 그린 당사자한테는 오지 않음.
						msList.get(i).oos = new ObjectOutputStream(
								new BufferedOutputStream(msList.get(i).client.getOutputStream()));
						if (obj instanceof StrokePointPacket) {
//							System.out.printf("client수신:[c:%3d|x:%3d|y:%3d]\n",
//									((StrokePointPacket) obj).getColorF().get(0),
//									((StrokePointPacket) obj).getPointX().get(0),
//									((StrokePointPacket) obj).getPointY().get(0));
							msList.get(i).oos.writeObject((StrokePointPacket) obj);
							msList.get(i).oos.flush();
						} else {
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} // multicastDrawCanvasMirror Method End

		void broadcastChatting(String msg) {
			for (MServer x : msList) {
//				System.out.println("채팅정보 유저님들한테 공유함");
				try {
					x.oos = new ObjectOutputStream(new BufferedOutputStream(x.client.getOutputStream()));
					ChatPacket cp = new ChatPacket("Server", msg);
					x.oos.writeObject(cp);
					x.oos.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		} //
//---------------------------------------------------- unicast --------------------------------------------------
//		void unicastUserInfo(Socket client) {// 클라이언트 소켓 인자로 전달 받으면 될 듯
//				oos = new ObjectOutputStream(
//						new BufferedOutputStream(client.getOutputStream()));
//				UserInfoPacket uip = new UserInfoPacket(userinfo.get(i))
//		}

		void unicastUserInfo(Socket client) {
			try {
				oos = new ObjectOutputStream(new BufferedOutputStream(client.getOutputStream()));
				UserInfoPacket uip = new UserInfoPacket(userinfo.get(clientSocketList.indexOf(client)));
				oos.writeObject(uip);
				oos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		void unicastWantInfo(Socket client) { // ArrayList<UserInfo> userinfo아 분리해야하는데 귀찮아 걍 다 보내
			try {
				oos = new ObjectOutputStream(new BufferedOutputStream(client.getOutputStream()));
				ProtocolPacket pp = new ProtocolPacket(1); // 찝찝함
				oos.writeObject(pp);
				oos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		void unicastDisplayInfo(Socket client) { // ArrayList<UserInfo> userinfo아 분리해야하는데 귀찮아 걍 다 보내
			try {
				oos = new ObjectOutputStream(new BufferedOutputStream(client.getOutputStream()));
				DisplayInfoPacket dip = new DisplayInfoPacket(userinfo);
				for (int i = 0; i < userinfo.size(); i++)
					System.out.println("[s]dip" + userinfo.get(i).getNickname() + "|" + userinfo.get(i).isExaminer());
				oos.writeObject(dip);
				oos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
//---------------------------------------------------- unicast --------------------------------------------------

//---------------------------------------------------- broadcast --------------------------------------------------
		void broadcastUserInfo() { // ArrayList<UserInfo> userinfo 안줘도 되는데 걍 혹시 몰라서 주고있음
			for (int i = 0; i < msList.size(); i++) { // 뭐 msList랑 userinfo랑 짝이니까 사이즈는 상관없음
				try {
//					System.out.println("유저님들에게 유저정보 갱신해서 드림");
					msList.get(i).oos = new ObjectOutputStream(
							new BufferedOutputStream(msList.get(i).client.getOutputStream()));
					UserInfoPacket uip = new UserInfoPacket(userinfo.get(i));
//					System.out.println("UIP 클라이언트 : " + msList.get(i).client + "에게 보낸다" + uip);
					if (uip instanceof UserInfoPacket) {
						msList.get(i).oos.writeObject((UserInfoPacket) uip);
						msList.get(i).oos.flush();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		void broadcastDisplayInfo() { // ArrayList<UserInfo> userinfo아 분리해야하는데 귀찮아 걍 다 보내
			for (int i = 0; i < msList.size(); i++) { // 뭐 msList랑 userinfo랑 짝이니까 사이즈는 상관없음
				try {
//					System.out.println("유저님들에게 화면 정보 전송함");
					msList.get(i).oos = new ObjectOutputStream(
							new BufferedOutputStream(msList.get(i).client.getOutputStream()));
					DisplayInfoPacket dip = new DisplayInfoPacket(userinfo);
//					System.out.println("DIP 클라이언트 : " + msList.get(i).client + "에게 보낸다" + dip);
					if (dip instanceof DisplayInfoPacket) {
						msList.get(i).oos.writeObject((DisplayInfoPacket) dip);
						msList.get(i).oos.flush();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		void broadcastWantInfo() { // ArrayList<UserInfo> userinfo아 분리해야하는데 귀찮아 걍 다 보내
			for (int i = 0; i < msList.size(); i++) { // 뭐 msList랑 userinfo랑 짝이니까 사이즈는 상관없음
				try {
//					System.out.println("클라이언트님들아 유저 정보좀");
					msList.get(i).oos = new ObjectOutputStream(
							new BufferedOutputStream(msList.get(i).client.getOutputStream()));
					ProtocolPacket pp = new ProtocolPacket(1);
//					System.out.println("PP 클라이언트 : " + msList.get(i).client + "에게 보낸다" + pp);
					if (pp instanceof ProtocolPacket) {
						msList.get(i).oos.writeObject((ProtocolPacket) pp);
						msList.get(i).oos.flush();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
//---------------------------------------------------- broadcast --------------------------------------------------
//---------------------------------------------------- multicast --------------------------------------------------

		void multicastAllUserClrScr(Object obj) { // 나를 제외한 모든 유저에게 클리어 프로토콜을 전송함.
			for (int i = 0; i < msList.size(); i++) {
				try {
					if (msList.get(i).client != this.client) { // 그림 그린 당사자한테는 오지 않음.
						msList.get(i).oos = new ObjectOutputStream(
								new BufferedOutputStream(msList.get(i).client.getOutputStream()));
						if (obj instanceof ProtocolPacket) {
							msList.get(i).oos.writeObject((ProtocolPacket) obj);
							msList.get(i).oos.flush();
						} else {
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

//---------------------------------------------------- multicast --------------------------------------------------

	}
}

//[보완점] 생각해보니 9번 유저도 들어와지긴 할 것이다. 9번 유저가 들어오면 이 구문 안에서 소켓연결 끊는 통신 구문을 하나
//min값에 유저가 들어갈 순번이(가장 낮게 비어있는 곳)이 정해진다. 이제 여기에다 넣고 연결하면된다.
//					System.out.println("입터럽트야");
//					Thread.interrupted();
//						Thread.sleep(2000);
//						System.out.println("2초 후");
//						Thread.interrupted();

//		proPacket
//					UserInfoPacket uip = new UserInfoPacket(userinfo.get(i).getSeq(), userinfo.get(i).isExaminer(), 
//															userinfo.get(i).nickname, userinfo.get(i).getPoint(), 
//															userinfo.get(i).getMonsterType());
//			else if(obj instanceof DisplayInfoPacket) {
//			}
//		
//			for (MServer x : msList) {
//				try {
//					x.oos = new ObjectOutputStream(new BufferedOutputStream(x.client.getOutputStream()));
//					UserInfoPacket uip = new UserInfoPacket(seq, examiner, nickname, point, monsterType);
//					x.oos.writeObject(uip);
//					x.oos.flush();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}

// 죽음의 코드 무덤

// 타이머
// 동작이 이해가 안된다면 이 구문을 돌려보면 동작을 확인해볼 수 있다.
// true상태로 시작하고 ++++++ 해서 setTime 상태에 도달하면 false flag가 된다.
//	static {	
//		Runnable sesTimer = new Runnable() {
//			@Override
//			public void run() {
//				if(srvTimer == 0) {
//					gInProgressFlag = true;
//					System.out.println("t interval : " + (srvTimer++)+"|"+gInProgressFlag);
//				}
//				else if (srvTimer == 10) {
//					gInProgressFlag = false;
//					System.out.println("f interval : " + (srvTimer++)+"|"+gInProgressFlag);
//					srvTimer = 0;
//				} 
//				else {
//					System.out.println("interval : " + (srvTimer++)+"|"+gInProgressFlag);
//				}
//			}
//		};
//		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
//		service.scheduleAtFixedRate(sesTimer, 0, interval, TimeUnit.SECONDS);
//		System.out.println("interval = " + interval);
//	}

//System.out.println("그림을 그린 당사자에게는 브로드캐스트 하지 않음");
//if(chatLog.length() == 0)
//chatLog.append("[" + ((ChatPacket) obj).getSender() + "] : " + ((ChatPacket) obj).getMsg());
//else
//chatLog.append("[" + ((ChatPacket) obj).getSender() + "] : " + ((ChatPacket) obj).getMsg() + "\n");
//		System.out.println(chatLog.toString());
//		System.out.print(chatLog.substring(chatLog.lastIndexOf("\n", chatLog.length()-2), chatLog.lastIndexOf("\n")));
//ois = new
// 각각 대상 클라이언트 소켓을 가진다, vStart에서 생성됨.
//ObjectOutputStream oos = null;

//			람다식은 모르것다. @.@
//			Consumer<MServer> c = msList -> {
//				for(MServer x : msList) {
//					try {
//						x.oos= new ObjectOutputStream(
//									new BufferedOutputStream(
//										x.client.getOutputStream()));
//						x.oos.writeObject(msg);
//						x.oos.flush();
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//			c.accept(msList);

// 마지막 라인 판단. \n이 제일 끝지점에 가 있으면 마지막줄이라고 판단함.
// chatLog.lastIndexOf("\n",chatLog.length()-1) == cathLog.length()   true 마지막줄의 \n
// 제일 밑 줄의 바로 위엣 줄의 \n을 찾는 방법이 필요함. 맨 끝 인덱스부터 검사하는 방식이 필요함
// 어디까지? -> \n을 만날때 까지 . 뒤에서부터 판별하니까 lastIndexOf 메서드를 사용하자.
// lastIndexOf 메서드는 (문자열, 검색할 인덱스 위치 시작점)
// 잘못 생각했다 더 간단한 문제였다. 근데 이 메서드가 없어?
//								int rear = chatLog.length() - 1;
//								int front = chatLog.length() - 1;
//								
// " 별 헤는 밤 \n|  새벽 3시의 코딩이란 제정신이 아니란 말이지... |\n"
//             |                                    fr
//             |                                  f  r
//             |...<<<<<<<<<<...f...<<<<<<<<<<<<<<...r
//             f                                     r
//           f                                       r (탈출)
//								while ((rear = ) == front) {
//									front = rear - 1;
//								}
//								if (rear >= 0) {	// 한줄위험스 (아 아 이 이렇게 할 필요가 없었음 삭제)
//									//f+1 부터 chatLog.length-1 까지 (어차피 \n 안가져갈 것)
//									chatLog.substring(front+1, chatLog.length());
//									
//								}

// 연결되어 있음을 통신없이 확인할 수 있을까?
//	boolean connected = (tmpCli.isConnected()) && (!(tmpCli.isClosed()));
//		BufferedOutputStream bos = null;
//		OutputStream os = null;
//		InputStream is = null;
//		ObjectInputStream ois = null;
//		BufferedInputStream bis = null;

// 여기서도 userinfo ArrayList<UserInfo> 에 접근이 가능함. 내부 클래스라서 말이죠
//
//		InputStream is = null;
//		BufferedInputStream bis = null;
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
//			System.out.println("msList.size가 궁금해" + msList.size());
//							System.out.println("msList.get(" + i + ").client :" + msList.get(i).client);
//							System.out.println("obj : " + obj);
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
//

//if(srvTimerTime == 0) {		
//	inGameFlag = true;		// 게임중 상태로 만들고
//	System.out.println((srvTimerTime)+"|"+inGameFlag);
//	srvTimerTime++;			// 타이머 시간 진행
//}
//else if (srvTimerTime == setTimerEndTime) {	//타이머가 끝까지 갔다면
//	inGameFlag = false;						//게임 진행 아님 상태로 만들고
//	srvTimerTime++;							
//	srvTimerTime = 0;
//} 
//else {
//	System.out.println((srvTimerTime)+"|"+inGameFlag);
//	srvTimerTime++;
//}
//	System.out.println("t interval : " + (setTimerInitTime++)+"|"+gInProgressFlag);
//	System.out.println("f interval : " + (setTimerInitTime++)+"|"+gInProgressFlag);
//	System.out.println("interval : " + (setTimerInitTime++)+"|"+gInProgressFlag);

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
//						System.out.println("현재 연결된 clientSocketList : " + clientSocketList);
//						for (int i = 0; i < clientSocketList.size(); i++) {
//							System.out.println("clientSocketList.get(" + i + ")" + clientSocketList.get(i) + "]");
//						}