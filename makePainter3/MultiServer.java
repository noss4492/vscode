package makePainter3;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MultiServer { // ������ ������� �޴� ��Ƽ���� Ŭ����
	final static int USER_MAX = 4;
	static int cnt = 0;
	ArrayList<MServerThread> list = new ArrayList<MServerThread>();
	// �� ��� ����Ʈ�� �� ���ϸ��� ������� ���ư�����.
	// �α����� �ȴٸ� �� ������ ������ �ش� ����Ʈ�� ������ ��ü�� ���ڷ� ��Ƽ� �޾ƾ���.
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
		System.out.println("vComm ����");
//		ss = new ServerSocket(5000);
//		while (true) {
//			client[cnt] = ss.accept();
//		}
	}
}
//				for(int i = 0; i < client.length; i++) {
//					if(client[cnt] == client[i])
// �ߺ������� ����
//					else {
//						client[cnt] = new Socket();
//					}
//				}
//			}
//		}

//				if(client) 
//				System.out.println("�����"+client.getLocalAddress().getHostAddress());
//				MServerThread mst = new MServerThread(client);
//				list.add(mst); // ���� �迭�� �߰�
//				mst.start();
//				if(list.size()>=4) {

//					System.out.println("������ �ʹ� ����");
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

// ------------ �� �� �� �� �� �� �� �� �� -----------------------------