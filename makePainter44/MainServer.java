package makePainter44;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

// �ϴ��� ���ſ� �������� ����� ��Ƽ������ ����
// ������ �������� ���۵ǰ� �����ϰ� �־�� �Ѵ�.
public class MainServer {
	ServerSocket ss; // �ϴ��� ������ ����
//	Dequeue<Socket> clientSocket
//	HashMap<Integer, Integer> userinfo = new HashMap<Integer, Integer>(4);	// ���� ����
//	UserInfo[] userinfo = new UserInfo[8]; // ���� ����
	ArrayList<Socket> clientSocketList = new ArrayList<Socket>(); // ������ ��� ����Ʈ�� �� �����ڴ�
	ArrayList<UserInfo> userinfo = new ArrayList<UserInfo>(); // max 8 �̰��� ���� �˻��� �� �ۿ� ����
	int examiner = 0; // ������ ��ȣ �ʱⰪ 0�� �ε���

//	Socket[] clientSocket = new Socket[4];
//	ArrayList<MServer> clientList = new ArrayList<MServer>();	// (Ŭ���̾�Ʈ)������ �迭

	// ���ڸ� Socket,
	int sPort = 5000;
	static int cnt = 0;
	static final int MAX_USER = 4;

	public MainServer() {
		vStart(); // �����ϸ� ������ �������� �˻簡 �����
	}

	public static void main(String[] args) {
		MainServer ms = new MainServer();
	}
	// clientSocketList�� index �ش� ���Ͽ� userinfo�� �� �Ŵϱ� �̶� ����ȭ�ؼ� �ϳ��� ������ ��

	public void vStart() { // chat + game(�ϴ���), // �̰��� ������ �غ�ܰ���. // private?
		try {
			ss = new ServerSocket(sPort); // ������ ������ �غ��Ų��

			// ������ ����ִ� ��ȣ�� ���� ��ȣ�� �ο��Ѵ�.
			while (true) {
				// ���ʿ��� Ŭ���̾�Ʈ�� �������� ���� ip�� port�� �����Ͽ����� accept�ؼ� ���� �� ���� ���̴�.
				// i��° �ε����� ����ִ� ClientSocket �� userInfo ¦�� ���缭 ����� ��
				if (clientSocketList.size() < MAX_USER) { // �ϴ� ���� ����� ������ 7�� �����̸� ���� ����
					// ----------------------- seq �˻� -------------------------
					int min = 0;
					int[] maker = { 0, 0, 0, 0, 0, 0, 0, 0 }; // user seq marker
					// ����ִ� ������ ���� ���� ��ȣ�� �����ϱ�
					// ����ִ� seq��ȣ �˻� �� ���� ���� ���� ã�´�
					// 1101 0000 -> �Ѹ��� ���� ����
					for (int i = 0; i < clientSocketList.size(); i++) { // list,user,userinfo size
						// clientSocketList.get(i); // ��� ������ ���� ���Ḹ �Ǹ� �Ǵ� �ִϱ� �� �ư�
						maker[userinfo.get(i).getSeq()] = 1;
						// �˻��ؼ� ���� ���� �ְ� seq
					}
					for (int i = 0; i < MAX_USER; i++) {
						if (maker[i] == 0) { // mark���� ���� ������ �ޱ� ����, ������ ����
							min = i;
							break;
						}
					}
					// ���� & ���� ���� �ο�
					// min user seq
					clientSocketList.add(ss.accept());
					if (min == examiner) // �����ڰ� �����ڼ����� ������ userInfo ������ flag true
						userinfo.add(new UserInfo(min, true));
					else
						userinfo.add(new UserInfo(min, false));

					// min �� ���� ���� seq ���� ���⿡�� �ְ� �����ϸ�ȴ�.
					// �̷��� �ۼ��ϸ� user seq�� arrlist�� ������� ���� ������ �Էµ�
					// --------------------------------------------------------------

//					int seq = clientSocketList.indexOf(tmpCli); // index�� seq(�־��� ��ȣ)
					System.out.println("���� �����ڿ��� " + min + "���� �ο��Ǿ���");
					System.out.println("���� �����ڿ��� ��������  seq :" + userinfo.get(min).getSeq());
					System.out.println("���� �����ڿ��� ��������  flag:" + userinfo.get(min).isExaminer());
//					System.out.println("������ 4���� �ʰ�����"); // ���� ���(gg) or ���� ��ȿ(���� ���)
					System.out.println("���� ������ ���� ����" + clientSocketList.get(cnt) + " size:" + userinfo.size());
				} else {
					// ��� �ʰ��ϸ� ���� ���ϰ� ������ ����
//					clientSocketList.get(MAX_USER).close();
					ss.close();
				}


				// ���� ������ ������� �ڸ��� �ο���.
				// 1�� �������Դ� 1�� �ڸ��� �Ҵ�
				// ���� ������ ?

				// ����Ǿ� ������ Ȯ��
//				boolean connected = (tmpCli.isConnected()) && (!(tmpCli.isClosed()));

			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("[test] ���� ��Ʈ�� ������ �ִµ��");
		}
	}
	// �α��� �ϴ� ������ �ִٸ�. (������ ����ȴٸ�)

	// ���� ������ �����ϰ�
	// ��� ����Ʈ�� �߰�

	// �濡 ������� ���üũ
	// ��̸���Ʈ ������ üũ

	// MAX���� ������ ���� �񼺻�
	// max-1���϶� ����� ���·� ��ȯ�ϴ� ����� ���°� ������

	// ���� ����� �� �ۼ�
	// ������ �����ϸ� �߻��ϴ� �̺�Ʈ ? ->
	// ���� ����� �ش� ���� bind()

	// üũ�� �������� ������ ���۵� ���̾�

	// ������ʹ� ������ ���� ������

	// ��.��

	// nested inner class
//	class MServer extends Thread { // ���⼭ ���������� ó���Ǿ�� �� ��Ƽ������ �κ��� ������.
//		Socket client; // ���⼭�� ���� �ϳ��� ������ �ְ���
//
//		// �������� list.get �̷��� client�� ���ڸ� �޾ƾ���
//		public MServer(Socket Client) {
//		}
//
//		@Override
//		public void run() {
//			System.out.println("����");
//		}
//
//	}
}
