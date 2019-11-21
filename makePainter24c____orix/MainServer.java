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

public class MainServer {
	SimpleDateFormat format2 = new SimpleDateFormat("yyyy/MM/dd  HHH mmM ssS");
	StringBuffer chatLog = new StringBuffer(); // ����� ���� ��� ä��. ��ϵǰ� �־���.
	private ServerSocket ss; // ������ ����
	private ArrayList<Socket> clientSocketList = new ArrayList<Socket>(); // ����� Ŭ���̾�Ʈ ���� �迭�� ��´�.
	static private ArrayList<UserInfo> userinfo = new ArrayList<UserInfo>(); // �� �������� ���� ����(����)�� ������ ���ؼ�
	private ArrayList<MServer> msList = new ArrayList<MServer>(); // Ŭ���̾�Ʈ ��� ������ ArrayList
	int examiner = 0; // ������ ��ȣ, ������ ������ ���. �ʱⰪ 0��
	int sPort = 5000;
	static int cnt = 0;
	static final int MAX_USER = 4; // �� ��Ʈ���� ���� 8����� ��ƿ �� ������? �ϴ� 8->4->2
	static int interval = 1; // ���� Ÿ�� üũ ���� (�� ��Ȯ����)
	final static int MAX_GAME_TIME = 30; // ���� ����ð�
//	final static int INTERVAL_TIME = 10;	// ��� �ð��� �־��µ� �ð������ ����
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

	// ������ �𸣰����� Ÿ�̸� �������� ����� �ôµ� �� �۵��� �ȵ�... ����?
	// ����ƽ�� �÷��ΰ� ���Ⱑ �� ����Ģ�ѵ�... ������ �ð� �� �ϳ� �ִ°ǵ� �ȵǳ�?
	// �Ӹ��� �����ϴ�. ������ ���� ��� ã�ٰ� �׳� ����ƽ�� �÷��ΰ� �����..
	static {
		Runnable sesTimer = new Runnable() { // ���� flag�� üũ�ϴ� �����带 ���� ���� �� �� �� �� �� �� ��
			@Override
			public void run() {
				inGameFlagPrev = inGameFlag;
				if (inGameFlag == false) { // �������� �ƴ϶�� Ÿ�̸� ����
//					System.out.print("�����ð�" + (srvTimerTime) + "|" + inGameFlag);
					srvTimerTime = 0;// Ÿ�̸� �ٽ� �����ϰ�
					inGameFlag = true;
					srvTimerTime++;
				} else if (inGameFlag == true) {
//					System.out.print("�����ð�" + (srvTimerTime) + "|" + inGameFlag);
					srvTimerTime++;
					if (srvTimerTime == setTimerEndTime) { // �ð� �ٵ�
//						System.out.print("�ð��ٵ�");
						inGameFlag = false;
					}
				}
//				System.out.print("�����ð�" + (srvTimerTime) + "|" + inGameFlag);
				if (inGameFlagPrev != inGameFlag) {
					swCheckFlag = true;
//					System.out.print("�ٲ���! swf:" + swCheckFlag + "\n");
				} else {
					swCheckFlag = false;
//					System.out.print("�״��. swf:" + swCheckFlag + "\n");
				}
				if (swCheckFlag == true && inGameFlag == true) { // �ش� �����̸� ������ ���۵Ǿ��ٰ� �Ǵ���.
				} else if (swCheckFlag == true && inGameFlag == false) { // �ش� �����̸� ������ �����ٰ� �Ǵ���.
				}
			}
		};
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		service.scheduleAtFixedRate(sesTimer, 0, interval, TimeUnit.SECONDS);
//		System.out.println("interval = " + interval);
	}

	public MainServer() { // ���μ��� �����忡�� ���� ����/���� �˻� ����� ������.
		dbReceive();
		vStart(); // ���� ������(���� ���� �˻縦 ���������� ����), �����ϸ� ������ �������� �˻簡 �����
	}
	public static void main(String[] args) {
		// ���� Ÿ�̸Ӵ� �Ѱ��ε� ����ϹǷ� ���⿡ �ϳ��� ����
		new MainServer(); // ������ �ѹ� ����ǰ� ���� ������ ������� �ʴ� �ν��Ͻ��� �������� ���� �ʾ���
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
		// DB �ϼ�!
//		System.out.println("�ϼ���DB����غ���");
		ansWord = quizDB.get((int) (Math.random() * 50)); // ÷���� �������� �ϳ� ������
//		quizDB.remove(quizDB.indexOf(ansWord)); // �ش� �ܾ�� ������ arraylist���� ������.
		System.out.println("ù��° ���� ���⼭ ������, ������ �ִ� ����Ʈ���� ����" + ansWord); // ������ ������ ���� ����� ������
	}

	public void vStart() {
		ObjectInputStream ois = null;
		try {
			ss = new ServerSocket(sPort); // ������ ������ �غ��Ų��.
			// �����ܿ��� Ŭ���̾�Ʈ�� ���Ḧ �Ǵ��ϴ� ��Ŷ�� �ʿ���. Ŭ���̾�Ʈ���� closePacket�� ������ ��̸���Ʈ���� ����, ������ free
			while (true) { // ������ ���������� �˻��Ѵ�.
				// ----------------------------- Ŭ���̾�Ʈ ���� ���� ���� -----------------------------
				if (clientSocketList.size() <= MAX_USER + 1) { // size 8 �϶� index 9 ���� ����Եȴ�. (�ȿ��� index 9 case�� ����)
					// �߰�������Ѵ�.
					// userInfo�� ���� ����(seq) �˻����� | �߰��� ������ �� ���� ��ȣ�� ����� �� ��ȣ���� ä���� ���� ��ȣ�� �Ű�����.
					if (clientSocketList.size() == MAX_USER) {
						Socket imClosedSocket = ss.accept();

						ObjectOutputStream oosToDeny = new ObjectOutputStream(
								new BufferedOutputStream(imClosedSocket.getOutputStream()));
//						ClosePacket a = new ClosePacket();
//						oosToDeny.writeObject(a);
						oosToDeny.writeObject(new ClosePacket());
//						imClosedSocket.close();	// ����Ʈ���� ���� �߻���. �ڿ� ������ �ִµ�
					} else {
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
						// ���⼭ add�ϴ� ���� �ƴ϶� �ڿ��� Ŭ���̾�Ʈ���� ���� ������ �ٽ� ���ļ�add��
						if (min == examiner) // �����ڰ� �����ڼ����� ������ userInfo ������ flag = true
							wIsExaminer = true;
						else
							wIsExaminer = false;

						// Ŭ���̾�Ʈ�� �����Ǵ� �� ������ ������ �����ϴ� MServer Class
						// ����� �� ���� �� Ŭ���̾�Ʈ�� ����ϴ� ������ MServer�� ������. �ݴ�� ����� Thread.close()���ٰ�
						MServer ms = new MServer(tmpSocket);// , userinfo);
						msList.add(ms);
						ms.start();
						// �׽�Ʈ�غ��� ���� �غ� ��.
//						ms.unicastDisplayInfo(tmpSocket); // �̷��� ���� ���� ���ɼ��� �ٺ���. 
						// �׽�Ʈ�غ��� ���� �غ� ��.

						// 1. �ϴ� ������ �α��ν� ���� ������ �������� userinfo�� ������
						ois = new ObjectInputStream(
								new BufferedInputStream(clientSocketList.get(min).getInputStream()));

						Object obj; // userNickname
						String nickname = null;
						String monType = null;

						try {
							obj = ois.readObject();
							if (obj instanceof UserInitializePacket) {
								// �о���� ������ �ش� Ŭ����(UserNicknamePacket) Ÿ���̶��
								nickname = ((UserInitializePacket) obj).getNickname();
								monType = ((UserInitializePacket) obj).getMonsterType();
								// UserInitializePacket�� ���� ���� ��� X ��� boolean type�� ������ �߰��ؼ� ��ſ� ���°͵� ������
							} else if (obj instanceof DisplayInfoPacket) {
								new Thread(() -> { // Wa..
									ms.broadcastUserInfo();
								});
							}
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}

						// ���ο� ������ �����Ե� �ϼ��� �ʱ� userinfo (��ġ, ����������, �г���, ����Ʈ, ����Ÿ��)
						userinfo.add(new UserInfo(min, wIsExaminer, nickname, 0, monType));
						// [�ǹ�] ���� ������ ���� info ������ ��̸� ������ ���� �ʿ䰡 ������? ������ ���� �����ϸ� ��� �������� ���ٵ�?
						
						new Thread(() -> { // �ش� ������ Ŭ���̾�Ʈ��� 1:1�� ����Ǿ� �۵��Ǳ� ������ ��ε�ĳ������ �ƴ϶� ��������� �޼��带 �ۼ��Ͽ�����
//							System.out.println("0000000000000000000");
							minSeq = 99;
							maxSeq = -1;
							bufferSeq = minSeq;
							while (true) {
//								System.out.println(swCheckFlag+"|"+inGameFlag);
								try {
									// ���⿡ ois�� ���� �κ� ����
									// ���⿡�� ���� ������ ���ŵǸ� �������� ������ �ִ� ���� ������ ���� ���ŵǾ����.
									Thread.sleep(1000); // ���� ������ �ΰ� Ÿ�̸Ӹ� ������.
									if (swCheckFlag == true && inGameFlag == true) { // ���� ���۵�
//										System.out.println("----������ ���۵Ʊ���!");	// ���� ������ �ʿ��ϴϱ� �޶�� ��û��
//										broadcastChatting("\n������ ���۵Ǿ����ϴ�.\n");//�޼��� ��� ������� ����� ��.��
										broadcastWantInfo();
										System.out.println("���� ����");
//										unicastWantInfo(client);
										// ���۶� �ܾ �ش�? -> �����鿡�� �Ѹ���
									} else if ((swCheckFlag == true && inGameFlag == false && isAnswerFlag == false) || // <<
									(isAnswerFlag == true)) { // + flag : user correct
										// ������ �����̸� ������ ���� ���� or Ÿ�̸����� �� ������ (���� ���� �� ���߸�) // ��ĥ �� �־ �̷��� �ۼ���
//										synchronized (ms) {
										System.out.println("���� ��");
										System.out.println("f[sw|ingame|answer]" + swCheckFlag + "|" + inGameFlag + "|"
												+ isAnswerFlag);
										// ������ ���� �÷��׸� ������. ���� ���� �÷��׸� �ٲٰ� ���⼭ �÷��׸� ���� �Ǵ���.
										srvTimerTime = 0;
//										System.out.println("----������ ��������!");	// �������� ���� ������ ������
										// ������ ������ ���� ���� �ٽ� ����
//										broadcastChatting("������ �������ϴ�.\n\n");//�޼��� ��� ������� ����� ��.��
										int nowExaminer = 0;
										int nowExamArrIdx = 0;

//											buffer = 
										if (minSeq != bufferSeq) {// �� ���� �ٲ� �Ŷ�� �ν� �� �� ������. ��� ó�� ������ ���� ������ ��ó���� true��
											this.wait();
//											wait();
										} // �ؾ���
//											if(buffer)
										if (userinfo.size() > 1) {
											for (int i = 0; i < userinfo.size(); i++) {
												if (userinfo.get(i).isExaminer() == true) { // �������� seq(����������ȣ)�� ������
													nowExaminer = userinfo.get(i).getSeq(); // �迭 ���� seq
													nowExamArrIdx = i;
													maxSeq = userinfo.get(i).getSeq() > maxSeq
															? userinfo.get(i).getSeq()
															: maxSeq;
												}
											}
											System.out.println("maxSeq : " + maxSeq);
//											for (int i = 0; i < userinfo.size(); i++) {
//											} // maxSeq
											if (nowExaminer == userinfo.size() - 1) { // ���� seq������ �ִ� ������ �����ڿ��ٸ�
												userinfo.get(nowExaminer).setExaminer(false); // �ش� ������ �����ڿ��� ��������
												for (int i = 0; i < userinfo.size(); i++) {// �� seq �� ���� ����� �˻���
													minSeq = minSeq > userinfo.get(i).getSeq()
															? userinfo.get(i).getSeq()
															: minSeq;
												}
												userinfo.get(minSeq).setExaminer(true); // �� seq ���� ����� �����ڷ�
												System.out.println("üũ�� ������ minSeq :" + minSeq);
												/// ���⼭ ��������
											} else {
												for (int i = 0; i < userinfo.size(); i++) {
													if (userinfo.get(i).getSeq() == userinfo.get(nowExaminer).getSeq()
															+ 1) {
														minSeq = i;
														userinfo.get(nowExaminer).setExaminer(false);
														userinfo.get(minSeq).setExaminer(true);
														System.out.println("üũ�� ������ i : " + i);
														break;
													}
												}
											}
											// ����� ���� ������� minSeq.

											bufferSeq = minSeq;
											doubleBufferSeq = minSeq;

											// 1�̴� 2�̴� minSeq���� ��ġ�� ������ ����

											// �̰��� ���ۿ� ��Ƴ���
											// �� ���� ���� ���� ���� �ƴ϶�� ���� ������ �ߴ�

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

//											for (int i = 0; i < userinfo.size(); i++) { // �Ϲ� ��Ȳ����
//												if (i != nowExaminer) { // �����ڰ� �ƴϾ��� �������� �ٽ� ���� ������ �ο��ϱ� ����
//													// �� ������ seq�� ������� ���ߵ�.
//													System.out.println("���� �����ڴ� :"+userinfo.get(i).examiner);
//													break;
//													// ���� ���� ���ŵǸ� �ٽ� ���� ������� �ѷ������
//												}
//											}

//										if(nowExaminer == userinfo.size()-1) {
//											for(int i = 0 ; i < userinfo.size(); i++) {
//												minSeq = minSeq > userinfo.get(i).getSeq() ? userinfo.get(i).getSeq() : minSeq;
//											}
//											nowExaminer = minSeq;
//										}
				//userinfo.get(i).getSeq()�� �˻� -> ex) 0 4 3 1    0134 << ���������� �ʴٸ� ���ÿ� �׾Ƽ�..(�ٵ� ������) 
										// seq�� ���� seq ��ȣ�� ������ -> Max�� index 0 ���� �ٽ� üũ

//										broadcastUserInfo();
//										broadcastDisplayInfo();

										// �ٽ� ����Ʈ���� ������ ���带 �̾ƿ�.
										ansWord = quizDB.get((int) (Math.random() * quizDB.size()));
//										quizDB.remove(quizDB.indexOf(ansWord));
										System.out.println("���� ������, ���� : " + ansWord);
										Thread.sleep(300);

										// �������� �Ѹ���.
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
										// ���� �������� �Ѿ�ϱ� �ٽ� ���� ���� �÷��׸� false�� �ٲ�
										isAnswerFlag = false;
									}
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						}).start();
						
						// 2. ���� ���¸� �ݿ��Ͽ� ������ userinfo ������ ������Ʈ�Ͽ� �ٽ� ������
						// �������� ���� ������� ������ �׷��� �� �������ų� �׷��� �ʰ���? ' ';;; ���� ���ӽ� ���� ������ �������� ������
//						ms.broadcastDisplayInfo();
						// �� �κ��� Ŭ���̾�Ʈ ������ �����忡�� ���� ��������.

						System.out.println("�� ���� �ֳ� �ѹ� Ȯ����\nseq|isExaminer|nickname");
						System.out.println("[����:" + min + "]|[������:" + wIsExaminer + "]|[�г�:" + nickname + "]");
						System.out.println("���� �����ڿ��� " + min + "���� �ο��Ǿ���");
						System.out.println("���� �����ڿ��� ��������  seq :" + userinfo.get(min).getSeq());
						System.out.println("���� �����ڿ��� ��������  flag:" + userinfo.get(min).isExaminer());
						System.out.println("���� ������ ���� ����" + clientSocketList.get(min) + " size:" + userinfo.size());
//						ms.broadcastDisplayInfo();	// �����?
					}
				} else {
					// �� �� ���� ��...
				}
				// ���1. ���� ������ �����ϰ�(����ϴٰ� timeout) + �ش� Ŭ���̾�Ʈ�� �ȳ� �޼����� ������. (�� ���� �ƹ��͵� �Ƚ���� ��)
				// ���2. ���� �޾Ƽ� ���ڸ��� ���´�.
				// ����� ������ ���� ��. (!!) �����ص� �ҿ� ����. ���ʿ��� ������ �� �������. ���⼭�� �������� �����ش޶�� ��Ŷ�� �������ҵ�
//						Socket overedClient = ss.accept();
//						overedClient.close();
//					}
				// clientSocketList.size() == 9 ���� ����� ������ ��
				// ������ 8�϶� ���� �������� ���ϰ� ������ �����Ͽ����Ƿ� �� ���� �� ���� ����.
				// clientSockList.remove(MAX_USER+1);
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

				// -------------- ���� ������ �Ѿ�� �� �����ڸ� �ٲٴ� ���(�ϼ���) -----------------------

				// �ϵ��ڵ����� �����ϴ°� ���� ������? case 1, 2, 3 ...
//				switch(case) {
//				}
				// inputstream�� instanceof �� ���� ������ Ÿ���� �Ǻ��ؼ� ����Ѵ�. (���� / ä��)
				// ---------------------- ���� �����Ȳ�� ���� ���� ���� ���� ���� �� ----------------------------
			} // while(true) end
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("[test] ���� ��Ʈ�� ������ �ִµ�");
//			msList.remove(this);// ������ ����
		} // try to ServerSocket ready end
//		catch(SocketException e) { // �� ���ܴ� ���� ��Ʈ���� �� ���� �κп� ���� ��.��
//			System.out.println("����������������~~");
//		}
	} // vStart() method end
	
	void broadcastUserInfo() { // ArrayList<UserInfo> userinfo ���൵ �Ǵµ� �� Ȥ�� ���� �ְ�����
		for (int i = 0; i < msList.size(); i++) { // �� msList�� userinfo�� ¦�̴ϱ� ������� �������
			try {
//				System.out.println("�����Ե鿡�� �������� �����ؼ� �帲");
				msList.get(i).oos = new ObjectOutputStream(
						new BufferedOutputStream(msList.get(i).client.getOutputStream()));
				UserInfoPacket uip = new UserInfoPacket(userinfo.get(i));
//				System.out.println("UIP Ŭ���̾�Ʈ : " + msList.get(i).client + "���� ������" + uip);
				if (uip instanceof UserInfoPacket) {
					msList.get(i).oos.writeObject((UserInfoPacket) uip);
					msList.get(i).oos.flush();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	void broadcastDisplayInfo() { // ArrayList<UserInfo> userinfo�� �и��ؾ��ϴµ� ������ �� �� ����
		for (int i = 0; i < msList.size(); i++) { // �� msList�� userinfo�� ¦�̴ϱ� ������� �������
			try {
//				System.out.println("�����Ե鿡�� ȭ�� ���� ������");
				msList.get(i).oos = new ObjectOutputStream(
						new BufferedOutputStream(msList.get(i).client.getOutputStream()));
				DisplayInfoPacket dip = new DisplayInfoPacket(userinfo);
//				System.out.println("DIP Ŭ���̾�Ʈ : " + msList.get(i).client + "���� ������" + dip);
				if (dip instanceof DisplayInfoPacket) {
					msList.get(i).oos.writeObject((DisplayInfoPacket) dip);
					msList.get(i).oos.flush();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	void broadcastWantInfo() { // ArrayList<UserInfo> userinfo�� �и��ؾ��ϴµ� ������ �� �� ����
		for (int i = 0; i < msList.size(); i++) { // �� msList�� userinfo�� ¦�̴ϱ� ������� �������
			try {
//				System.out.println("Ŭ���̾�Ʈ�Ե�� ���� ������");
				msList.get(i).oos = new ObjectOutputStream(
						new BufferedOutputStream(msList.get(i).client.getOutputStream()));
				ProtocolPacket pp = new ProtocolPacket(1);
//				System.out.println("PP Ŭ���̾�Ʈ : " + msList.get(i).client + "���� ������" + pp);
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
			System.out.println("������ Ŭ���̾�Ʈ ���Ͽ� �����Ǵ� ������ :" + this);
			System.out.println("--------------------------------------");
//			synchronized(msList) {
//			}
		}

		@Override
		public void run() {
			// �� Ŭ���̾�Ʈ�鿡�� ����� ���� inputstream����
			// ���⼭ ���������� ���� �˻� �ؾ���
			while (true) {
				try {
					// JOIN ���� ����
					ois = new ObjectInputStream(new BufferedInputStream(client.getInputStream()));
//					if (!ois.equals(null)) { // ois�� ���� ����ִٸ�
					obj = ois.readObject(); // ois�� �о�鿩 ��ü�� ��Ƽ� �������� ����Ѵ�.
					if (obj instanceof StrokePointPacket) { // Ŭ���̾�Ʈ���� ���� Paint��ǥ�� ��� �ִٸ�
						multicastDrawCanvasMirror(obj); // �������� �̸� �����ڸ� ������ ����� ��� Ŭ���̾�Ʈ�鿡�� �ѷ��ش�.
					} else if (obj instanceof UserInfoPacket) {
						// ���� ������ �޾��� �� ? �� �ʿ��Ѱ�? ������ �������� ���� ������ ��� �� ������ �ִµ�?
						// ������ ���� ������ �޾Ƽ� ����Ʈ�� �ִ� �κа� ������ ���� ������ �������� �Ѹ��� ������ �����غ���.
						// ���� ���۽� ���� ������ ���� �ʿ䰡 �ֳ�? �ִ�. �����غ��ϱ� �־�! ���� ������ ���������� ���Ӹ��� ���ŵǰ� �����Ƿ� ' ' ;;;
						// ���� ���۽� ���� ������ �޾Ƽ� �����ϴ� ������ �ǰڴ�.

						// ���� ������ �޾ƴٰ� ��̸���Ʈ�� �־ ������ ��¥
						// ��� �ұ�?
						// clientSocketList.indexOf(client) < ���ϸ���Ʈ �ش� ��°�� �ִ� ����, �ε����� ���ϸ���Ʈ�� ���������� ¦�̴ϱ�
						// ¦�� �´� �ε��� ��ġ�� ������ ��Ŷ �� userinfo type �ڷḦ �ִ´�.
						userinfo.set(clientSocketList.indexOf(client), ((UserInfoPacket) obj).getInfoBox());
						System.out.println("�������� ���� ������ ������.\n --------------------------------------" + "\n|nick    : "
								+ ((UserInfoPacket) obj).getInfoBox().getNickname() + "\n|seq     : "
								+ ((UserInfoPacket) obj).getInfoBox().getSeq() + "\n|isExam  : "
								+ ((UserInfoPacket) obj).getInfoBox().isExaminer() + "\n|point   : "
								+ ((UserInfoPacket) obj).getInfoBox().getPoint() + "\n|montype : "
								+ ((UserInfoPacket) obj).getInfoBox().getMonsterType() + "\n");
					} else if (obj instanceof ChatPacket) {
						// ������ ������ ä���� �޾Ƽ� ���ۿ� ���� �κ�
						chatLog.append(
								"[" + ((ChatPacket) obj).getSender() + "] : " + ((ChatPacket) obj).getMsg() + "\n");

						System.out.println("-------------[Server Chatting log]-------------");
						System.out.println("[system time :" + format2.format(System.currentTimeMillis()) + "]");
						System.out.println(chatLog);
						System.out.println("-----------------------------------------------");

						if (((ChatPacket) obj).getMsg().equals(ansWord)) { // .contains(ansWord)) { // ���� ������ �Է��� msg��
																			// ������ ���ԵǾ� �ִٸ�// == +"\n") {
							// ������ �� �޼����� ���� ������
							// ������ �Է��� msg �� �����̶�� this.client���� +1 �� , ���� ���� �÷��� ����,
//							if ( msg == ansWord ) {	// ���� ������ �Է��� msg�� ����ܾ���
//							}
							System.out.println("�� ���� �����̾�!!! ���� ������ �����!");
							isAnswerFlag = true;
						}
						// ��� �������� ä�÷α��� ������ ���� ��ε�ĳ��Ʈ
						// ������ \n �����ϰ� �� ���� �ִ� \n�� ��ġ���� ������ ������ ������ ���� �ȴ�.
						// �ƴϸ� ������ �� ���� \n +1 ���� ������ ���� \n �ε������� ����.
						String msg = null;
						if (chatLog.length() > 0) {
							if (chatLog.lastIndexOf("\n", chatLog.length() - 2) < 0) { // ������ ���, ���� ��� �����̿�
								msg = chatLog.substring(0, chatLog.lastIndexOf("\n"));
							} else {
								msg = chatLog.substring(chatLog.lastIndexOf("\n", chatLog.length() - 2),
										chatLog.lastIndexOf("\n"));
							}
						}

						//////////////////////////////////////////
						// ���⿡�� ���� �޼��� ���ٷ� ������
						if (msg != null) {
							broadcastChatting(msg);
						}
					} else if (obj instanceof ProtocolPacket) {
						if (((ProtocolPacket) obj).getDefinedCase() == 999) { // ���� ��ũ�� Ŭ���� ��ü �۽�
							// multicast all user(�ڱ� �ڽ��� ����)
							multicastAllUserClrScr(obj);
						}
					}
//					}
//					new Thread(() -> {
//						System.out.println("���� ������ �ߵ���?");
//					}).start();

				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
//				new Thread(() -> {
//					while(true) {
//						if (swCheckFlag == true && inGameFlag == true) {
//							System.out.println("������ ���۵Ʊ���!");
//							broadcastUserInfo();
//							broadcastDisplayInfo();
//						} else if (swCheckFlag == true && inGameFlag == false) {
//							System.out.println("������ ��������!");
//							broadcastWantInfo();
//						}
//					}
//				}).start();
				// ������ 4�� �ִٸ�

				// svrTime|inGameFlag| swCheckFlag
//				�����ð�0|true�״��. swf:false
//				�����ð�1|true�״��. swf:false
//				�����ð�2|true�״��. swf:false
//				�����ð�3|true�״��. swf:false
//				�����ð�4|true�״��. swf:false
//				�����ð�5|true�״��. swf:false
//				�����ð�6|true�״��. swf:false
//				�����ð�7|true�״��. swf:false
//				�����ð�8|true�״��. swf:false
//				�����ð�9|true�ð��ٵ� swf:true <<<< ���� ����Ʈ
//			      �����ð�10|false�ٲ���!swf:true <<<< ���� ����Ʈ
//				�����ð�1|true�״��. swf:false
//				�����ð�2|true�״��. swf:false
//				�����ð�3|true�״��. swf:false
//				�����ð�4|true�״��. swf:false
//				�����ð�5|true�״��. swf:false
//				�����ð�6|true�״��. swf:false
//				�����ð�7|true�״��. swf:false
//				�����ð�8|true�״��. swf:false
//				�����ð�9|true�ð��ٵ� swf:true
//				�����ð�10|false�ٲ���! swf:true

				// �ƴ� �� �ȵ� ������� �� ���?
//				new Thread(() -> {
//					System.out.println("�ߵ���");
//				}).start();
				// ������ ���� ������ Ŭ���̾�Ʈ�� ��û
				// ���� ������ �޾ƿ���
//							broadcastWantInfo();
//					inGameFlag = false; // Ÿ�̸� ����(���� ����)
//					swCheckFlag = true;
//					srvTimerTime = 10; // next time 0 -> 1

//				}).start();

				// sw flag�� on �Ǹ� ������ ���� ���̴�.
				// �Ǵ� ������ ������ ���߰ų�

				// �׷��� �ٽ� ������ ���� ������ �����ؼ� �ѷ��ش�.(��ε�ĳ��Ʈ�������� ����)

				/// ���� ����
//				if(inGameFlag == true) {
//					srvTimerTime = 0;
//					setTimerEndTime = 10;
//					inGameFlag = false;
//					System.out.println("���ӽ���!, Ÿ�̸� �ð� ������ f->t");
//				}else {
//					System.out.println("���� ������" + (srvTimerTime)+"|"+inGameFlag);
//					if(srvTimerTime==10) {
//						System.out.println("Ÿ�̸� �ð� �ٴ��");
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
					if (msList.get(i).client != this.client) { // �׸� �׸� ��������״� ���� ����.
						msList.get(i).oos = new ObjectOutputStream(
								new BufferedOutputStream(msList.get(i).client.getOutputStream()));
						if (obj instanceof StrokePointPacket) {
//							System.out.printf("client����:[c:%3d|x:%3d|y:%3d]\n",
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
//				System.out.println("ä������ �����Ե����� ������");
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
//		void unicastUserInfo(Socket client) {// Ŭ���̾�Ʈ ���� ���ڷ� ���� ������ �� ��
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

		void unicastWantInfo(Socket client) { // ArrayList<UserInfo> userinfo�� �и��ؾ��ϴµ� ������ �� �� ����
			try {
				oos = new ObjectOutputStream(new BufferedOutputStream(client.getOutputStream()));
				ProtocolPacket pp = new ProtocolPacket(1); // ������
				oos.writeObject(pp);
				oos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		void unicastDisplayInfo(Socket client) { // ArrayList<UserInfo> userinfo�� �и��ؾ��ϴµ� ������ �� �� ����
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
		void broadcastUserInfo() { // ArrayList<UserInfo> userinfo ���൵ �Ǵµ� �� Ȥ�� ���� �ְ�����
			for (int i = 0; i < msList.size(); i++) { // �� msList�� userinfo�� ¦�̴ϱ� ������� �������
				try {
//					System.out.println("�����Ե鿡�� �������� �����ؼ� �帲");
					msList.get(i).oos = new ObjectOutputStream(
							new BufferedOutputStream(msList.get(i).client.getOutputStream()));
					UserInfoPacket uip = new UserInfoPacket(userinfo.get(i));
//					System.out.println("UIP Ŭ���̾�Ʈ : " + msList.get(i).client + "���� ������" + uip);
					if (uip instanceof UserInfoPacket) {
						msList.get(i).oos.writeObject((UserInfoPacket) uip);
						msList.get(i).oos.flush();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		void broadcastDisplayInfo() { // ArrayList<UserInfo> userinfo�� �и��ؾ��ϴµ� ������ �� �� ����
			for (int i = 0; i < msList.size(); i++) { // �� msList�� userinfo�� ¦�̴ϱ� ������� �������
				try {
//					System.out.println("�����Ե鿡�� ȭ�� ���� ������");
					msList.get(i).oos = new ObjectOutputStream(
							new BufferedOutputStream(msList.get(i).client.getOutputStream()));
					DisplayInfoPacket dip = new DisplayInfoPacket(userinfo);
//					System.out.println("DIP Ŭ���̾�Ʈ : " + msList.get(i).client + "���� ������" + dip);
					if (dip instanceof DisplayInfoPacket) {
						msList.get(i).oos.writeObject((DisplayInfoPacket) dip);
						msList.get(i).oos.flush();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		void broadcastWantInfo() { // ArrayList<UserInfo> userinfo�� �и��ؾ��ϴµ� ������ �� �� ����
			for (int i = 0; i < msList.size(); i++) { // �� msList�� userinfo�� ¦�̴ϱ� ������� �������
				try {
//					System.out.println("Ŭ���̾�Ʈ�Ե�� ���� ������");
					msList.get(i).oos = new ObjectOutputStream(
							new BufferedOutputStream(msList.get(i).client.getOutputStream()));
					ProtocolPacket pp = new ProtocolPacket(1);
//					System.out.println("PP Ŭ���̾�Ʈ : " + msList.get(i).client + "���� ������" + pp);
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

		void multicastAllUserClrScr(Object obj) { // ���� ������ ��� �������� Ŭ���� ���������� ������.
			for (int i = 0; i < msList.size(); i++) {
				try {
					if (msList.get(i).client != this.client) { // �׸� �׸� ��������״� ���� ����.
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

//[������] �����غ��� 9�� ������ �������� �� ���̴�. 9�� ������ ������ �� ���� �ȿ��� ���Ͽ��� ���� ��� ������ �ϳ�
//min���� ������ �� ������(���� ���� ����ִ� ��)�� ��������. ���� ���⿡�� �ְ� �����ϸ�ȴ�.
//					System.out.println("���ͷ�Ʈ��");
//					Thread.interrupted();
//						Thread.sleep(2000);
//						System.out.println("2�� ��");
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

// ������ �ڵ� ����

// Ÿ�̸�
// ������ ���ذ� �ȵȴٸ� �� ������ �������� ������ Ȯ���غ� �� �ִ�.
// true���·� �����ϰ� ++++++ �ؼ� setTime ���¿� �����ϸ� false flag�� �ȴ�.
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

//System.out.println("�׸��� �׸� ����ڿ��Դ� ��ε�ĳ��Ʈ ���� ����");
//if(chatLog.length() == 0)
//chatLog.append("[" + ((ChatPacket) obj).getSender() + "] : " + ((ChatPacket) obj).getMsg());
//else
//chatLog.append("[" + ((ChatPacket) obj).getSender() + "] : " + ((ChatPacket) obj).getMsg() + "\n");
//		System.out.println(chatLog.toString());
//		System.out.print(chatLog.substring(chatLog.lastIndexOf("\n", chatLog.length()-2), chatLog.lastIndexOf("\n")));
//ois = new
// ���� ��� Ŭ���̾�Ʈ ������ ������, vStart���� ������.
//ObjectOutputStream oos = null;

//			���ٽ��� �𸣰ʹ�. @.@
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

// ������ ���� �Ǵ�. \n�� ���� �������� �� ������ ���������̶�� �Ǵ���.
// chatLog.lastIndexOf("\n",chatLog.length()-1) == cathLog.length()   true ���������� \n
// ���� �� ���� �ٷ� ���� ���� \n�� ã�� ����� �ʿ���. �� �� �ε������� �˻��ϴ� ����� �ʿ���
// ������? -> \n�� ������ ���� . �ڿ������� �Ǻ��ϴϱ� lastIndexOf �޼��带 �������.
// lastIndexOf �޼���� (���ڿ�, �˻��� �ε��� ��ġ ������)
// �߸� �����ߴ� �� ������ ��������. �ٵ� �� �޼��尡 ����?
//								int rear = chatLog.length() - 1;
//								int front = chatLog.length() - 1;
//								
// " �� ��� �� \n|  ���� 3���� �ڵ��̶� �������� �ƴ϶� ������... |\n"
//             |                                    fr
//             |                                  f  r
//             |...<<<<<<<<<<...f...<<<<<<<<<<<<<<...r
//             f                                     r
//           f                                       r (Ż��)
//								while ((rear = ) == front) {
//									front = rear - 1;
//								}
//								if (rear >= 0) {	// �������轺 (�� �� �� �̷��� �� �ʿ䰡 ������ ����)
//									//f+1 ���� chatLog.length-1 ���� (������ \n �Ȱ����� ��)
//									chatLog.substring(front+1, chatLog.length());
//									
//								}

// ����Ǿ� ������ ��ž��� Ȯ���� �� ������?
//	boolean connected = (tmpCli.isConnected()) && (!(tmpCli.isClosed()));
//		BufferedOutputStream bos = null;
//		OutputStream os = null;
//		InputStream is = null;
//		ObjectInputStream ois = null;
//		BufferedInputStream bis = null;

// ���⼭�� userinfo ArrayList<UserInfo> �� ������ ������. ���� Ŭ������ ������
//
//		InputStream is = null;
//		BufferedInputStream bis = null;
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
//			System.out.println("msList.size�� �ñ���" + msList.size());
//							System.out.println("msList.get(" + i + ").client :" + msList.get(i).client);
//							System.out.println("obj : " + obj);
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
//

//if(srvTimerTime == 0) {		
//	inGameFlag = true;		// ������ ���·� �����
//	System.out.println((srvTimerTime)+"|"+inGameFlag);
//	srvTimerTime++;			// Ÿ�̸� �ð� ����
//}
//else if (srvTimerTime == setTimerEndTime) {	//Ÿ�̸Ӱ� ������ ���ٸ�
//	inGameFlag = false;						//���� ���� �ƴ� ���·� �����
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
//						System.out.println("���� ����� clientSocketList : " + clientSocketList);
//						for (int i = 0; i < clientSocketList.size(); i++) {
//							System.out.println("clientSocketList.get(" + i + ")" + clientSocketList.get(i) + "]");
//						}