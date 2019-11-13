package makePainter3;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MultiServer { // 연결을 쓰레드로 받는 멀티서버 클래스
	final static int USER_MAX = 4;
	static int cnt = 0;
	ArrayList<MServerThread> list = new ArrayList<MServerThread>();
	// 이 어레이 리스트가 각 소켓마다 쓰레드로 돌아가야함.
	// 로그인이 된다면 각 소켓의 정보를 해당 리스트의 쓰레드 객체의 인자로 삼아서 받아야함.
	ServerSocket ss;
	Socket[] client = new Socket[4];
//	ArrayList<Socket> client = new ArrayList<Socket>();

	public MultiServer() {
		vCommPaint();
	}

	public static void main(String[] args) {
		MultiServer ms = new MultiServer();
	}

	public void vCommPaint() {
		System.out.println("vComm 실행");
//		ss = new ServerSocket(5000);
//		while (true) {
//			client[cnt] = ss.accept();
//		}
	}
}
//				for(int i = 0; i < client.length; i++) {
//					if(client[cnt] == client[i])
// 중복접속자 있음
//					else {
//						client[cnt] = new Socket();
//					}
//				}
//			}
//		}

//				if(client) 
//				System.out.println("연결됨"+client.getLocalAddress().getHostAddress());
//				MServerThread mst = new MServerThread(client);
//				list.add(mst); // 소켓 배열에 추가
//				mst.start();
//				if(list.size()>=4) {

//					System.out.println("유저가 너무 많음");
//					list.remove(this);
//				}
//			}
//		}catch(
//
//	IOException e)
//	{
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//		list.remove(this);
//	}
//}}

//		ServerSocket ss2 = new ServerSocket(5000);
//		try {
////		Socket client = ss.accept();
////		MServerThread msth = new MServerThread(client);
////		list.add(msth);
////		msth.start();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			list.remove(this);
//		}
//
//		}

// ------------ 쓰 레 드 로 돌 아 갈 부 분 -----------------------------