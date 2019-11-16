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

// ������ �ڵ� ����
//	Dequeue<Socket> clientSocket
//	HashMap<Integer, Integer> userinfo = new HashMap<Integer, Integer>(4);	// ���� ����
//	UserInfo[] userinfo = new UserInfo[8]; // ���� ����
//	Socket[] clientSocket = new Socket[4];
//	ArrayList<MServer> clientList = new ArrayList<MServer>();	// (Ŭ���̾�Ʈ)������ �迭
//					clientSocketList.get(MAX_USER).close(); // �̰Ŵ� arraylist�� 9ĭ���� ����� ������� �����ؾ���.(����)
// if(clientSocketList.get(i).isClosed == false) clientSocketList.get(i).close();
//						nowExaminer = userinfo.get(i).getSeq(); // �������� seq(����������ȣ)�� ������
//						examiner = userinfo.get(i).getSeq();	//���� seq�� ����� �����ڰ� �Ǿ����
// ������ ���� clientSocketList.get(i)
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
/////////////////// error:���Ͽ� ���� ���� ���� ���� ���� ����(�ƴϾ��� �ٸ� ���� ��Ʈ�� ������ �־���. ������ ������.)////////////////////
// ������ �� �ؿ� ��Ƽĳ��Ʈ ��ǥ ���ִ� �κп��� �� ����ϰ� 5�����ΰ� get�ؼ� ���°� �߸� ���� �־ �׷�����. 
// ���п� �˼����� ������ �������... 
// ��Ƽĳ��Ʈ �۽ſ� ������ �־��� �� �� 5���� ã�Ƽ� �ٲٴµ� 7~8�ð� �ɸ�
// ���� : ����� ������. �������� �и� �� ���ư��� ������������.
/////////////////// error:���Ͽ� ���� ���� ���� ���� ���� ��////////////////////
//							userinfo.add(new UserInfo(min, true));
//							userinfo.add(new UserInfo(min, false));
//						MServer ms = new MServer(clientSocketList.get(min));
//						System.out.println("Mserver ms�� �߰��Ǵ� tmpSocket:" + tmpSocket);
//						System.out.println("Mserver ms :" + ms);
//						System.out.println("msList : " + msList);
//						for (int i = 0; i < msList.size(); i++) {
//							System.out.println("msList.get(" + i + ") [" + msList.get(i) + "]");
//						}
//						System.out.println("==================================");
//						clientSocketList.add(ss.accept());

// �ϴ��� ���ſ� �������� ����� ��Ƽ������ ����
// ������ �������� ���۵ǰ� �����ϰ� �־�� �Ѵ�.
// clientSocketList�� index�� �ش�Ǵ� ���Ͽ�(�� client��) userinfo�� ������ ���� �� �ֵ��� ����ȭ�ؼ� �ϳ��� ���� ������. 

// vStart() �޼��忡 ���� ����
// ������ ����ִ� ��ȣ�� ���� ��ȣ�� �ο��Ѵ�.
// �ϴ��� ä��, ������ ���� String, (ArrayList X, Y) �����͵��� ��� �� ���Ͽ��� �޴´�.

// ���ʿ��� Ŭ���̾�Ʈ�� �������� ���� ip�� port�� �����Ͽ����� accept�ؼ� ���� �� ���� ���̴�.
// ClientSocket �� userInfo�� ������ �ε����� ¦�� ���缭 ����� ��

// ����ִ� ������ ���� ���� ��ȣ�� �����ϱ�
// ����ִ� seq��ȣ �˻� �� ���� ���� ���� ã�´�
// 11010000 -> �Ѹ��� ���� ��� maker�� ����

// min���� ������ �� ������(���� ���� ����ִ� ��)�� ��������. ���� ���⿡�� �ְ� �����ϸ�ȴ�.

public class MainServer {
	private ServerSocket ss; // ������ ����
	private ArrayList<Socket> clientSocketList = new ArrayList<Socket>(); // ����� Ŭ���̾�Ʈ ���� �迭�� ��´�.
	private ArrayList<UserInfo> userinfo = new ArrayList<UserInfo>(); // �� �������� ���� ����(����)�� ������ ���ؼ�
	private ArrayList<MServer> msList = new ArrayList<MServer>(); // Ŭ���̾�Ʈ ��� ������ ArrayList
	int examiner = 0; // ������ ��ȣ, ������ ������ ���. �ʱⰪ 0��
	int sPort = 5000;
	static int cnt = 0;
	static final int MAX_USER = 4; // �� ��Ʈ���� ���� 8����� ��ƿ �� ������? �ϴ� 8->4

	public MainServer() { // ���μ��� �����忡�� ���� ����/���� �˻� ����� ������.
		vStart(); // ���� ������(���� ���� �˻縦 ���������� ����), �����ϸ� ������ �������� �˻簡 �����
	}

	public static void main(String[] args) {
		new MainServer(); // ������ �ѹ� ����ǰ� ���� ������ ������� �ʴ� �ν��Ͻ��� �������� ���� �ʾ���
	}

	public void vStart() {
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		try {
			ss = new ServerSocket(sPort); // ������ ������ �غ��Ų��.
			// �����ܿ��� Ŭ���̾�Ʈ�� ���Ḧ �Ǵ��ϴ� ��Ŷ�� �ʿ���. Ŭ���̾�Ʈ���� closePacket�� ������ ��̸���Ʈ���� ����, ������ free
			while (true) { // ������ ���������� �˻��Ѵ�.
				// ----------------------------- Ŭ���̾�Ʈ ���� ���� ���� -----------------------------
				if (clientSocketList.size() <= MAX_USER) { // size 8 �϶� index 9 ���� ����Եȴ�. (�ȿ��� index 9 case�� ����)
					// userInfo�� ���� ����(seq) �˻����� | �߰��� ������ �� ���� ��ȣ�� ����� �� ��ȣ���� ä���� ���� ��ȣ�� �Ű�����.
					if (clientSocketList.size() < 8) {
						int min = 0;
						int[] maker = { 0, 0, 0, 0, 0, 0, 0, 0 }; // user seq marker
						for (int i = 0; i < clientSocketList.size(); i++) {
							maker[userinfo.get(i).getSeq()] = 1; // ���� userinfo[]�� ����ִ� seq��ȣ�� mark�صд�.
						}
						for (int i = 0; i < MAX_USER; i++) {
							if (maker[i] == 0) { // mark���� ���� ������ �ޱ� ����, ������ ����
								min = i;
								break;
							}
						}
						// ���� & ���� ���� �ο�
						// ���� Ŭ���̾�Ʈ ���ϰ� ����, ���� ������ ���� | Ŭ���̾�Ʈ ������ ���Ͽ� ���� ������ ������.
						boolean wIsExaminer;
						// clientSocketList ���� 8�� ������ �����ǰ� ���ѵǾ�����
						Socket tmpSocket = ss.accept();
						clientSocketList.add(tmpSocket);
						System.out.println("���� ����� clientSocketList : " + clientSocketList);
						for (int i = 0; i < clientSocketList.size(); i++) {
							System.out.println("clientSocketList.get(" + i + ")" + clientSocketList.get(i) + "]");
						}
						if (min == examiner) { // �����ڰ� �����ڼ����� ������ userInfo ������ flag = true
							// ���⼭ add�ϴ� ���� �ƴ϶� �ڿ��� Ŭ���̾�Ʈ���� ���� ������ �ٽ� ���ļ�add��
							wIsExaminer = true;
						} else {
							wIsExaminer = false;
						}

						// Ŭ���̾�Ʈ�� �����Ǵ� �� ������ ������ �����ϴ� MServer Class
						// ����� �� ���� �� Ŭ���̾�Ʈ�� ����ϴ� ������ MServer�� ������. �ݴ�� ����� Thread.close()���ٰ�
						MServer ms = new MServer(tmpSocket);
						msList.add(ms);
						ms.start();

						// 1. �ϴ� ������ �α��ν� ���� ������ �������� userinfo�� ������

						ois = new ObjectInputStream(new BufferedInputStream(clientSocketList.get(min).getInputStream()));
						Object obj; // userNickname
						String nickname = null;
						String monType = null;
						try {
							obj = ois.readObject();
							if (obj instanceof UserInitializePacket) {
								// �о���� ������ UserInitializePacket type �̶��
								// �ٷ� �� �ٽ� Ŭ���̾�Ʈ�� ������ ������ ������ ���� ������ �ʱ�ȭ��������.
								nickname = ((UserInitializePacket) obj).getNickname();
								monType = ((UserInitializePacket) obj).getMonsterType();
								// ���ο� ������ �����Ե� �ϼ��� �ʱ� userinfo (��ġ, ����������, �г���, ����Ʈ, ����Ÿ��)
								userinfo.add(new UserInfo(min, wIsExaminer, nickname, 0, monType));
								
								UserInitializePacket makeInitUserInfo = new UserInitializePacket(min, wIsExaminer, nickname, 0, monType);
								
								oos = new ObjectOutputStream(new BufferedOutputStream(clientSocketList.get(min).getOutputStream()));
								oos.writeObject(makeInitUserInfo);
								oos.flush();
							}
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}


						System.out.println("�� ���� �ֳ� �ѹ� Ȯ����\nseq|isExaminer|nickname");
						System.out.println("[����:"+min+"]|[������:" + wIsExaminer + "]|[�г�:" + nickname+"]");

						// 2. ���� ���¸� �ݿ��Ͽ� ������ userinfo ������ ������Ʈ�Ͽ� �ٽ� ������
						// �������� ���� ������� ������ �׷��� �� �������ų� �׷��� �ʰ���? ' ';;; ���� ���ӽ� ���� ������ �������� ������

						// �� �κ��� Ŭ���̾�Ʈ ������ �����忡�� ���� ��������.

						System.out.println("���� �����ڿ��� " + min + "���� �ο��Ǿ���");
						System.out.println("���� �����ڿ��� ��������  seq :" + userinfo.get(min).getSeq());
						System.out.println("���� �����ڿ��� ��������  flag:" + userinfo.get(min).isExaminer());
						System.out.println("���� ������ ���� ����" + clientSocketList.get(cnt) + " size:" + userinfo.size());

					} else {
						System.out.println("��������ο� �ʰ�");
						// ���1. ���� ������ �����ϰ�(����ϴٰ� timeout) + �ش� Ŭ���̾�Ʈ�� �ȳ� �޼����� ������. (�� ���� �ƹ��͵� �Ƚ���� ��)
						// ���2. ���� �޾Ƽ� ���ڸ��� ���´�.
//						Socket overedClient = ss.accept();
//						overedClient.close();
					}
				} else {
					// clientSocketList.size() == 9 ���� ����� ������ ��
					// ������ 8�϶� ���� �������� ���ϰ� ������ �����Ͽ����Ƿ� �� ���� �� ���� ����.
					// clientSockList.remove(MAX_USER+1);
				}
				// ----------------------------- Ŭ���̾�Ʈ ���� ���� �� -----------------------------

				// -------------------------- Ŭ���̾�Ʈ ����(����) üũ ���� ���� --------------------------
				// �� ������� �ȵ� ��.�� Ŭ���̾�Ʈ���� close()�� ������ ����ܿ� �� �޼����� write�ؾ� �ҵ� ��.��
				// isConnected �޼���� ���� ������ ���� ������ true�� �Ǵ� flag���� ������ �����Ƿ� isClosed �޼����� ������ ����
				// �Ἥ ������ �Ǻ��Ѵ�.
				/*
				 * for(int i = 0; i < clientSocketList.size(); i++) {
				 * System.out.println("isConn, !isClosed");
				 * System.out.println(clientSocketList.get(i).isConnected());
				 * System.out.println(!(clientSocketList.get(i).isClosed()));
				 * if(clientSocketList.get(i).isConnected() &&
				 * (!(clientSocketList.get(i).isClosed())) == false) {
				 * System.out.println("���� ���� ���� �߰ߵ� i:"+i); // ���ᰡ �߰ߵ� i��° ���� ����
				 * clientSocketList.remove(i); userinfo.remove(i); break; } }
				 */
				// -------------------------- Ŭ���̾�Ʈ ����(����) üũ ���� �� ----------------------------

				// ---------------------- ���� �����Ȳ�� ���� ���� ���� ���� ���� ���� --------------------------
				// ���� ������ ��������
				// ���ð��� �Ͼ�� ����
				// | ������ ���۵ȴ� | ī��Ʈ�� ���۵ȴ� | (������) examiner�� true�� ����ڰ� ������ �����Ѵ� |

				// ArrayList(BoxedStrokePoint(StrokePointArrX, StrokePointArrY)�� �ۼ��� �Ǵ� ����
				// ������(examiner�� true�� �����)�� ArrList ������ �޾ƿ´�. (���� �� ���� ���� �����忡��?)
				// �ٸ� Ŭ���̾�Ʈ�鿡�� �����Ѵ�. (���� �� Ŭ���̾�Ʈ ��� �����忡��)

				// ��������� �׸��� �ٸ� Ŭ���̾�Ʈ�鿡�� ���۵Ǵ� ����
				///////////////////////////////////////////

				// ������ ä�� ������ �޾ƿ´�.
				// �ش� ������ ä�� ������ ����� ��ġ�ϸ�
				// (������ ���ϱ�)

				// -------------- ���� ������ �Ѿ�� �� �����ڸ� �ٲٴ� ���(�ϼ���) -----------------------
				// ������ ��쿡 �����ڸ� �ٲ۴�.
				// ���⼭���� ���ϴ� ������ ����seq�� �ƴ϶� ���� socketArrayList ������.
				// ������ seq������ �޾Ƽ� �����ϴ� ���� �ξ� ���ְ� ������ �ۼ� ���Ǹ� ���� �̷��� �Ǿ���
				// �̷��� �ۼ��ȴٸ� ������ ���� ������ ���� ������ ������ ������ ���ư� ����.

//				int nowExaminer = 0;
//				for (int i = 0; i < userinfo.size(); i++) {
//					if (userinfo.get(i).isExaminer() == true) { // �������� seq(����������ȣ)�� ������
//						nowExaminer = i; // �׳� ArrayList������ ������ ��������
//					}
//				}
//				if (nowExaminer == userinfo.size()) { // ���� ������ �ִ� ������ �����ڿ��ٸ�
//					userinfo.get(nowExaminer).setExaminer(false);	// �ش� ������ �����ڿ��� ��������
//					for(int i = 0; i < userinfo.size(); i++) {
//						userinfo.get(i).setExaminer(true);	// ���� ������ �����ڰ� �Ǿ����
//						break;
//					}
//				} else {
//					for (int i = nowExaminer; i < userinfo.size(); i++) {
//						if (i != nowExaminer) { // �����ڰ� �ƴϾ��� �������� �ٽ� ���� ������ �ο��ϱ� ����
//							// ���࿡ �ѹ��̶� �������� ���� ��ȣ�� ���ٸ�
//							userinfo.get(nowExaminer).setExaminer(false);
//							userinfo.get(i).setExaminer(true);
//							break;
//							// ���� ���� ���ŵǸ� �ٽ� ���� ������� �ѷ������
//						}
//					}
//				}

				// -------------- ���� ������ �Ѿ�� �� �����ڸ� �ٲٴ� ���(�ϼ���) -----------------------

//				if(nowExaminer == userinfo.size()-1) {
//				}
				// seq�� ���� seq ��ȣ�� ������ -> Max�� index 0 ���� �ٽ� üũ
//				userinfo.get(i).getSeq()�� �˻� -> ex) 0 1 0 3
				// �ϵ��ڵ����� �����ϴ°� ���� ������? case 1, 2, 3 ...
//				switch(case) {
//				}
				// inputstream�� instanceof �� ���� ������ Ÿ���� �Ǻ��ؼ� ����Ѵ�. (���� / ä��)
				// ---------------------- ���� �����Ȳ�� ���� ���� ���� ���� ���� �� ----------------------------
// ����Ǿ� ������ Ȯ��
//	boolean connected = (tmpCli.isConnected()) && (!(tmpCli.isClosed()));
			} // while(true) end
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("[test] ���� ��Ʈ�� ������ �ִµ��");
//			msList.remove(this);// ������ ����
		} // try to ServerSocket ready end
	} // vStart() method end

//		BufferedOutputStream bos = null;
//		OutputStream os = null;
//		InputStream is = null;
//		ObjectInputStream ois = null;
//		BufferedInputStream bis = null;

	// ���⼭�� userinfo ArrayList<UserInfo> �� ������ ������. ���� Ŭ������ ������
	//
//		InputStream is = null;
//		BufferedInputStream bis = null;
	class MServer extends Thread {
		Socket client;
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		Object obj;

//		ois = new
		// ���� ��� Ŭ���̾�Ʈ ������ ������, vStart���� ������.
//		ObjectOutputStream oos = null;
		public MServer(Socket client) {

			this.client = client;
			System.out.println("--------------------------------------");
			System.out.println("������ Ŭ���̾�Ʈ�� ���������� ������ ��� :" + this);
			System.out.println(client.getInetAddress().getHostAddress());
		}

//			ois = new ObjectInputStream(new BufferedInputStream(client.getInputStream()));
//				ArrayList<Integer> x = new ArrayList<Integer>();
//				ArrayList<Integer> y = new ArrayList<Integer>();
//					System.out.println("----[����] ������ �׸� paint��ǥ -----------");
//					oos = new ObjectOutputStream(new BufferedOutputStream(client.getOutputStream()));
//							x = ((BoxedStrokePoint) obj).getPointX();
//							y = ((BoxedStrokePoint) obj).getPointY();
//							for (int i = 0; i < ((BoxedStrokePoint) obj).getPointX().size(); i++) {
//								System.out.printf("[server] [x:%3d], [y:%3d]\n",
//										((BoxedStrokePoint) obj).getPointX().get(i),
//										((BoxedStrokePoint) obj).getPointY().get(i));
//							}
//		System.out.println("-------[����] ��ǥ ���----------");
		@Override
		public void run() {
			// �� Ŭ���̾�Ʈ�鿡�� ����� ���� inputstream����
			// ���⼭ ���������� ���� �˻� �ؾ���
			while (true) {
				try {
					ois = new ObjectInputStream(new BufferedInputStream(client.getInputStream()));
					if (!ois.equals(null)) { // ois�� ���� ����ִٸ�
						obj = ois.readObject(); // ois�� �о�鿩 ��ü�� ��Ƽ� �������� ����Ѵ�.
						if (obj instanceof BoxedStrokePoint) { // Ŭ���̾�Ʈ���� ���� Paint��ǥ�� ��� �ִٸ�
							multicastDrawCanvasMirror(obj); // �������� �̸� �����ڸ� ������ ����� ��� Ŭ���̾�Ʈ�鿡�� �ѷ��ش�.
						} else if (obj instanceof UserInfoPacket) { // ���ŵ� ������ UserInfo�� ��� �ִٸ�
							// ȸ�� ������ �������� �޾����� (�� �������Լ�)

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
			System.out.println("msList.size�� �ñ���" + msList.size());
			for (int i = 0; i < msList.size(); i++) {
				try {
					if (msList.get(i).client != this.client) { // �׸� �׸� ��������״� ���� ����.
						msList.get(i).oos = new ObjectOutputStream(new BufferedOutputStream(msList.get(i).client.getOutputStream()));
						if (obj instanceof BoxedStrokePoint) {
							System.out.println("msList.get(" + i + ").client :" + msList.get(i).client);
							System.out.println("obj : " + obj);
							msList.get(i).oos.writeObject((BoxedStrokePoint) obj);
							msList.get(i).oos.flush();
						} else {
							System.out.println("�׸� �׸� ����ڿ��Դ� ��ε�ĳ��Ʈ ���� ����");
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
//			for (MServer x : msList) { // @.@ ���� ������ ó������ ������ �����µ� �̻��ѵ��� ���� ��ġ�� �־���....
//					try {
//						System.out.println("x"+x+"| cnt:"+cnt);
//						// ���� client == (x.clinet)
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
//					System.out.println("���� �׷Ⱦ� ���߳�");
//				} else {
//					System.out.println("�ٸ� ����� �׸� ��ǥ�� �޾Ҿ�!");
//					try {
//						oos = new ObjectOutputStream(new BufferedOutputStream(client.getOutputStream()));
//						msList.get(i).oos.writeObject(obj);
//						msList.get(i).flush();
//						System.out.println("��� �������� ��ǥ���� ������. ���� ���� �׸� ��.��");
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
// �Ƹ��� �̷� ��
// x.oos.objectWrite(userinfo.get(i))
// x.oos.flush;

// �� �κ��� Ŭ���̾�Ʈ ������ �����忡�� ���� ��������.
// ���� ���� broadcast�ؾ���.

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
//				System.out.println("�����");
//			}

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