package makePainter44;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

// 일단은 수신용 목적으로 만드는 멀티쓰레드 서버
// 서버는 지속적을 동작되고 감시하고 있어야 한다.
public class MainServer {
	ServerSocket ss; // 일단은 서버의 소켓
//	Dequeue<Socket> clientSocket
//	HashMap<Integer, Integer> userinfo = new HashMap<Integer, Integer>(4);	// 유저 정보
//	UserInfo[] userinfo = new UserInfo[8]; // 유저 정보
	ArrayList<Socket> clientSocketList = new ArrayList<Socket>(); // 오히려 어레이 리스트가 더 안좋겠는
	ArrayList<UserInfo> userinfo = new ArrayList<UserInfo>(); // max 8 이것은 직접 검사할 수 밖에 없음
	int examiner = 0; // 출제자 번호 초기값 0번 인덱스

//	Socket[] clientSocket = new Socket[4];
//	ArrayList<MServer> clientList = new ArrayList<MServer>();	// (클라이언트)쓰레드 배열

	// 인자를 Socket,
	int sPort = 5000;
	static int cnt = 0;
	static final int MAX_USER = 4;

	public MainServer() {
		vStart(); // 생성하면 서버의 지속적인 검사가 실행됨
	}

	public static void main(String[] args) {
		MainServer ms = new MainServer();
	}
	// clientSocketList의 index 해당 소켓에 userinfo를 줄 거니까 이때 직렬화해서 하나씩 보내면 됨

	public void vStart() { // chat + game(일단은), // 이것은 서버의 준비단계임. // private?
		try {
			ss = new ServerSocket(sPort); // 서버의 소켓을 준비시킨다

			// 들어오면 비어있는 번호에 유저 번호를 부여한다.
			while (true) {
				// 저쪽에서 클라이언트가 소켓으로 이쪽 ip와 port를 지정하였으면 accept해서 들을 수 있을 것이다.
				// i번째 인덱스에 들어있는 ClientSocket 과 userInfo 짝을 맞춰서 사용할 것
				if (clientSocketList.size() < MAX_USER) { // 일단 지금 연결된 소켓이 7개 이하이면 접속 가능
					// ----------------------- seq 검색 -------------------------
					int min = 0;
					int[] maker = { 0, 0, 0, 0, 0, 0, 0, 0 }; // user seq marker
					// 비어있는 유저의 가장 낮은 번호에 연결하기
					// 비어있는 seq번호 검색 후 가장 낮은 값을 찾는다
					// 1101 0000 -> 한명이 나간 예시
					for (int i = 0; i < clientSocketList.size(); i++) { // list,user,userinfo size
						// clientSocketList.get(i); // 얘는 어차피 소켓 연결만 되면 되는 애니까 뭐 됐고
						maker[userinfo.get(i).getSeq()] = 1;
						// 검사해서 가장 작은 애가 seq
					}
					for (int i = 0; i < MAX_USER; i++) {
						if (maker[i] == 0) { // mark되지 않은 순번을 받기 위함, 낮은것 부터
							min = i;
							break;
						}
					}
					// 연결 & 유저 정보 부여
					// min user seq
					clientSocketList.add(ss.accept());
					if (min == examiner) // 입장자가 출제자순번에 들어오면 userInfo 출제자 flag true
						userinfo.add(new UserInfo(min, true));
					else
						userinfo.add(new UserInfo(min, false));

					// min 이 가장 낮은 seq 이제 여기에다 넣고 연결하면된다.
					// 이렇게 작성하면 user seq가 arrlist와 상관없이 낮은 순으로 입력됨
					// --------------------------------------------------------------

//					int seq = clientSocketList.indexOf(tmpCli); // index는 seq(주어진 번호)
					System.out.println("현재 입장자에게 " + min + "번이 부여되었음");
					System.out.println("현재 입장자에게 유저정보  seq :" + userinfo.get(min).getSeq());
					System.out.println("현재 입장자에게 유저정보  flag:" + userinfo.get(min).isExaminer());
//					System.out.println("유저가 4명을 초과했음"); // 유저 대기(gg) or 입장 무효(현재 기능)
					System.out.println("현재 접속한 유저 소켓" + clientSocketList.get(cnt) + " size:" + userinfo.size());
				} else {
					// 사람 초과하면 접속 안하게 소켓을 끊음
//					clientSocketList.get(MAX_USER).close();
					ss.close();
				}


				// 유저 입장한 순서대로 자리를 부여함.
				// 1번 유저에게는 1번 자리를 할당
				// 유저 나가면 ?

				// 연결되어 있음을 확인
//				boolean connected = (tmpCli.isConnected()) && (!(tmpCli.isClosed()));

			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("[test] 서버 포트가 문제가 있는듯요");
		}
	}
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
}
