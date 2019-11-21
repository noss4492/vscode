package makePainter23c__;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

// �ߵ������ߴٸ� �α��νÿ� -> ȭ���� �������� �޾Ƽ� �׷����� -> ������ ��ǥ�� �������� ������ (�ڿ� �Ҹ��� �� Ŭ ��. ����)

public class GameClient extends JFrame implements ActionListener, Runnable, KeyListener {
	private static final long serialVersionUID = 618340375L;

	JButton btnLogIn, btnExit, btnSignup;
	JLabel txtLogIn, txtPw;
	JTextField inputLogIn;
	JPasswordField inputPw;
	Image backimg;
	JLabel backLabel, backID, backPW;

	StringBuffer userChatView;
	UserInfo userinfo; // ���ӽ� Ŭ���̾�Ʈ�� ������ ���� �������� (��� ���ŵǴ� ����)
	ArrayList<UserInfo> scrAllUserinfo;
	UserGameGUI ugGui; // �̰� �� �̷��̹��� ������ ������ �ʿ��ؼ� �־��.
	Socket server;
	String ansWord;
	static final int MAX_TIMER = 60;
	static int timeT = MAX_TIMER*2;

	static {
		Runnable sesTimer = new Runnable() { // ���� flag�� üũ�ϴ� �����带 ���� ���� �� �� �� �� �� �� ��
			@Override
			public void run() {
//				System.out.println(timeT);
				timeT--;
			}
		};
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		service.scheduleAtFixedRate(sesTimer, 0, 1, TimeUnit.SECONDS);
//		System.out.println("interval = " + interval);
	}

	GameClient() {
		super("�α���");
		// Layout �ʱ�ȭ
		setLayout(null);

		// �ػ� ��Ŷ
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension dmen = tool.getScreenSize();
		double scr_Width = dmen.getWidth();
		double scr_Height = dmen.getHeight();
		int widthX = (int) (scr_Width / 2 - 1280 / 2);
		int heightY = (int) (scr_Height / 2 - 800 / 2);

		// ������Ʈ �ʱ�ȭ

		btnLogIn = new JButton(new ImageIcon("src/images/Login.png"));
		btnSignup = new JButton(new ImageIcon("src/images/loginSignup.png"));
		btnExit = new JButton(new ImageIcon("src/images/LoginExit.png"));

		txtLogIn = new JLabel("���̵�");
		txtPw = new JLabel("��й�ȣ");

		inputLogIn = new JTextField(20);
		inputPw = new JPasswordField(33);

		// �̹���
		backimg = tool.createImage("src/images/LoginBG1280x800.png");
		backLabel = new JLabel(new ImageIcon(backimg));
		backID = new JLabel();
		backPW = new JLabel();
		this.setContentPane(backLabel);

		// Font
		Color tran = new Color(255, 255, 255, 120);
		Font font = new Font("", Font.BOLD, 17);
		inputLogIn.setOpaque(false);
		inputLogIn.setBorder(null);
		backID.setOpaque(true);
		backID.setBackground(tran);
		inputPw.setOpaque(false);
		inputPw.setBorder(null);
		backPW.setOpaque(true);
		backPW.setBackground(tran);

		txtLogIn.setOpaque(false);
		txtLogIn.setFont(font);
		txtLogIn.setForeground(Color.BLACK);
		txtPw.setOpaque(false);
		txtPw.setFont(font);
		txtPw.setForeground(Color.BLACK);

		// ������Ʈ ������
		btnLogIn.setBounds(500, 540, 280, 50);
		btnLogIn.addActionListener(this);
		btnSignup.setBounds(500, 600, 280, 50);
		btnSignup.addActionListener(this);
		btnExit.setBounds(500, 660, 280, 50);
		btnExit.addActionListener(this);

		txtLogIn.setBounds(500, 410, 280, 30); // 70 30 -> 280 30
		txtPw.setBounds(500, 470, 280, 30);

		inputLogIn.setBounds(500, 435, 280, 30);
		inputLogIn.addKeyListener(this);
		backID.setBounds(500, 435, 280, 30);
		inputPw.setBounds(500, 495, 280, 30);
		inputPw.addKeyListener(this);
		backPW.setBounds(500, 495, 280, 30);

		// ������Ʈ add
		add(btnLogIn);
		add(btnSignup);
		add(btnExit);

		add(txtLogIn);
		add(txtPw);

		add(inputLogIn);
		add(inputPw);
		add(backID);
		add(backPW);
		// window
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(widthX, heightY, 1280, 800);
		setVisible(true);
	}

	// main method start --------------------------------------
	public static void main(String[] args) {
		new GameClient();
	}
	// main method end -----------------------------------------

	// login() method start
	public void login() {
		String userId = inputLogIn.getText();
		char[] pwd = inputPw.getPassword();
		String password = new String(pwd);

		CatchMindDAO dao = new CatchMindDAO();

		boolean isOk = dao.isExists(userId, password);
		if (isOk) {
			JOptionPane.showConfirmDialog(this, "�α��� ����", "check", JOptionPane.PLAIN_MESSAGE);
			setVisible(false); // �α���â off

//			String ip = "192.168.0.49";
			String ip = "192.168.0.49";
//			String ip = "192.168.0.22";
//			String ip = "192.168.35.123";
			int port = 5000;
			String nickname = null;
			String monsterType = null;
			ObjectOutputStream oos = null;

			try {
				server = new Socket(ip, port); // �̷��� �������� Ȯ���ؼ� ����

				nickname = dao.selectOneNickname(userId);
				monsterType = dao.selectOneMonsterType(userId);

				// DB���� ��ȸ�ؿ� ������ �г��Ӱ� ���� Ÿ���� ������ ������. (����:�������� ���� �ʱ� ������ �����ؼ� �ٽ� ����� �����־� ���� �ʱ�
				// ������ ���� �Ϸ���)

				oos = new ObjectOutputStream(new BufferedOutputStream(server.getOutputStream()));

				UserInitializePacket uip = new UserInitializePacket(nickname, monsterType);

				oos.writeObject(uip);
				oos.flush();

				try { // ���ü��� �ʹ� �Ҿ��ؼ� �������� �ֱ� ���ؼ� �߰��غ�, �ϴ� ��� �ð� ���൵ ����� �Ϻ��ϰ� �۵���
					for (int i = (int) (2 * Math.random() + 2) * 1; i > 0; i--) { // 3~2��
						System.out.println("���� ����� [" + i + "��]");
						Thread.sleep(1000);
//						clrscr();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			// ���� ����â���� ��ȯ.
			ugGui = new UserGameGUI(server, oos, nickname);
			vGame(); // �α��� �Ϸ��� �� ����, �������� ���� ����� ����� ���������� �˻��� �����带 ����
		} else {
			JOptionPane.showConfirmDialog(this, "���̵�, ��й�ȣ�� �ٸ��ϴ�", "check", JOptionPane.PLAIN_MESSAGE);
		}
	}
	// login() method start

	private void vGame() { // ���Ӱ��� ��ź�
		Thread gTh = new Thread(this);
		gTh.start();
		new Thread(() -> {
			while(true) {
				try {
					Thread.sleep(1000);
					ugGui.time.setText(""+(timeT/2));
					timeT--;
				} catch (InterruptedException e) {
				}
			}
		}
		).start();
	}

	@Override
	public void run() { // �� �κ��� ������ ����Ǵ� ���� ����(�˻�)�ϰ� �ִ� ��������.
		while (true) { // (�α��� ���� �� Ŭ���̾�Ʈ�� ���)
			// ��ǥ ����
			Object obj;
			ObjectInputStream ois = null;
			ObjectOutputStream oos = null;
			try {
				ois = new ObjectInputStream(new BufferedInputStream(server.getInputStream()));
				if (!ois.equals(null)) {
					obj = ois.readObject();
					if (obj instanceof StrokePointPacket) { // �̷��� ������ �۵�
//						System.out.printf("client����:[c:%3d|x:%3d|y:%3d]\n",((StrokePointPacket) obj).getColorF().get(0),
//								((StrokePointPacket) obj).getPointX().get(0), ((StrokePointPacket) obj).getPointY().get(0));
						new DrawMirrorThread(ugGui.drawCanvas, ((StrokePointPacket) obj).getColorF(),
								((StrokePointPacket) obj).getPointX(), ((StrokePointPacket) obj).getPointY()).start();
					} else if (obj instanceof ClosePacket) {
						// server.close(); ����
					} else if (obj instanceof ChatPacket) {
						ugGui.jtaChat.append(((ChatPacket) obj).getMsg());
						System.out.println("�������� ä�÷α� ����");
					} else if (obj instanceof DisplayInfoPacket) {
						ugGui.drawCanvas.callClearAll();
						scrAllUserinfo = ((DisplayInfoPacket) obj).getUserinfo();
						int tmpDip = ((DisplayInfoPacket) obj).getUserinfo().size();
						
						
						
//						for(int i = 0 ; i < tmpDip; i++) {
////							((DisplayInfoPacket) obj).getUserinfo().get(i).getMonsterType();
//							System.out.println("���÷�����Ŷ ���¼�!!");
//							System.out.println(userinfo.getSeq());
//							System.out.println(ugGui.jlNick[i].getText());
//							ugGui.jlNick[userinfo.getSeq()].setText(((DisplayInfoPacket) obj).getUserinfo().get(userinfo.getSeq()).getNickname());
//							ugGui.jlCharacter[userinfo.getSeq()].setIcon(ugGui.char1Img); // �׽�Ʈ �غ���
////							ugGui.jlNick[userinfo.getSeq()].set(); // �׽�Ʈ �غ���
//						}
//							
//							;
//						if(userinfo.getMonsterType() == "���α�")	//userinfo // mon
//							ugGui.jlCharacter[userinfo.getSeq()].setIcon(ugGui.char1Img);

						// �ڱ� ȭ�鿡 �ڱ⸸ ������ �ڵ���.
//						for (int i = 0; i < tmpDip; i++) {
//							ugGui.jlNick[userinfo.getSeq()].setText(
//									((DisplayInfoPacket) obj).getUserinfo().get(userinfo.getSeq()).getNickname());
//							System.out.println("Ŭ���̾�Ʈ�� DIP�� ���� : ");
//							System.out.println("user seq : "+userinfo.getSeq());
//							System.out.println("nick"+((DisplayInfoPacket) obj).getUserinfo().get(userinfo.getSeq()).getNickname());
//							ugGui.jlCharacter[userinfo.getSeq()].setIcon(ugGui.char1Img);
//						}
						// ' '

						for (int i = 0; i < scrAllUserinfo.size(); i++) {
							ugGui.jlNick[i].setText(scrAllUserinfo.get(i).getNickname());
//							ugGui.jlCharacter[i].setIcon(ugGui.char1Img);
							if (scrAllUserinfo.get(i).getMonsterType().equals("��ī��")) {
								ugGui.jlCharacter[i].setIcon(new ImageIcon("src/images/char1.gif"));
							} else if (scrAllUserinfo.get(i).getMonsterType().equals("Ǫ��")) {
								ugGui.jlCharacter[i].setIcon(new ImageIcon("src/images/char2.gif"));
							} else if (scrAllUserinfo.get(i).getMonsterType().equals("���α�")) {
								ugGui.jlCharacter[i].setIcon(new ImageIcon("src/images/char3.gif"));
							} else if (scrAllUserinfo.get(i).getMonsterType().equals("�̺���")) {
								ugGui.jlCharacter[i].setIcon(new ImageIcon("src/images/char4.gif"));
							}
						}
						System.out.println("Ŭ���̾�Ʈ���� displayinfopacket�� ������");
						System.out.println("�������� ��ü �������� ����");
						System.out.println("�̰��� ������������ �Դ�");
						for (int i = 0; i < scrAllUserinfo.size(); i++) {
							System.out.println("�г�\t:" + scrAllUserinfo.get(i).getNickname());
							System.out.println("����\t:" + scrAllUserinfo.get(i).getSeq());
							System.out.println("ĳ����\t:" + scrAllUserinfo.get(i).getMonsterType());
							System.out.println("����\t:" + scrAllUserinfo.get(i).getPoint());
							System.out.println("�������ΰ�:" + scrAllUserinfo.get(i).isExaminer());
						}
						for (int i = 0; i < scrAllUserinfo.size(); i++)
							System.out.printf("[�г� : %s], [������? : %b]", scrAllUserinfo.get(i).getNickname(),
									scrAllUserinfo.get(i).isExaminer());
					} else if (obj instanceof UserInfoPacket) {
						userinfo = ((UserInfoPacket) obj).getInfoBox();
						System.out.println("�������� �� ���� �������� ����");
						System.out.println(((UserInfoPacket) obj).getInfoBox().getNickname() + "|"
								+ ((UserInfoPacket) obj).getInfoBox().examiner);
					} else if (obj instanceof ProtocolPacket) {
						if (((ProtocolPacket) obj).getDefinedCase() == 1) {
							System.out.println("���� ���� ������ �۽���");
							// �������� �������� ������ �䱸��. �۽�������.
							oos = new ObjectOutputStream(new BufferedOutputStream(server.getOutputStream()));
							oos.writeObject(userinfo);
							oos.flush();
						} else if (((ProtocolPacket) obj).getDefinedCase() == 999) {
							ugGui.drawCanvas.callClearAll();// ��� �߰��� �ٽ� Ȯ���ϰ� �ּ� ������ ��.
						}
					} else if (obj instanceof QuizWordsPacket) { // ��ɷ� ���÷��� �� �� (�߰��� ���� �� �ּ�0
						ansWord = ((QuizWordsPacket) obj).getAnsWord();
						// �̶� �������� �ϸ�?
						timeT = MAX_TIMER*2;
						try {
							Thread.sleep(500);
							if (userinfo.isExaminer()) {
								ugGui.word.setText(ansWord);
								ugGui.inputTxt.setEditable(false);
								//// jlCharacter jlNick char1Img
							} else {
								String starAns = "";
								for (int i = 0; i < ansWord.length(); i++)
									starAns += "*";
								ugGui.word.setText(starAns);
								ugGui.inputTxt.setEditable(true);
							}
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						/*
						 * charImage = "��ī��"; btnChar1.setSelectedIcon(gifImg1); } else if (obj ==
						 * btnChar2) { charImage = "Ǫ��"; btnChar2.setSelectedIcon(gifImg2); } else if
						 * (obj == btnChar3) { charImage = "���α�"; btnChar3.setSelectedIcon(gifImg3); }
						 * else if (obj == btnChar4) { charImage = "�̺���";
						 */
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
//			ugGui.drawCanvas.callChangeColorRGB();
			// ugGui.drawCanvas.clearAllCall(); // �۵���
		}
	}

	// ActionEvent start ---------------------------------------
	// �α��� ��ư�� ������ ���� ����(�� �̺�Ʈ)
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();

		if (obj == btnLogIn)
			login();
		else if (obj == btnSignup)
			new SignUpGUI();
		else
			System.exit(0);
	}

	// ���� ���Ǹ� ���� �׳� ���ͽ� �α��� ��ư ���� ������ �̺�Ʈ ���� ����
	@Override
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_ENTER)
			login();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}
	// ActionEvent end -----------------------------------------
} // GameClient Class end --------------------------------------

// ������ �ڵ幫��

// ������� �г��� ������ �������� ����
// ������ String ���� �ϳ�(user nickname�� �����ϸ� �� )
// �ٵ� String���� �޴� �������� ä�ÿ� ���� �����̹Ƿ� �ٸ� ��ü�� ��������.
//System.out.println("nickname �޾ƿͼ� �̰� ��Ŷ�� ���� ���� : " + nickname);
//System.out.println("monsterType �޾ƿͼ� �̰� ��Ŷ�� ���� ���� : " + monsterType);

//if (uip instanceof UserInitializePacket) {
//}
//DrawMirrorThread mirrorTh = 
//new DrawMirrorThread(ugGui.drawCanvas,
//((StrokePointPacket) obj).getPointX(), ((StrokePointPacket) obj).getPointY()).start();
//mirrorTh.start(); 
//System.out.println("������ Ŭ���� ��Ŷ�� ����"); 
//System.out.println("ä�� ��Ŷ �޾����� ���� ���÷��� ������");
//String thName = th.getName();
//boolean status = Thread.interrupted();
//ClientMainThread cmt = new ClientMainThread(server); // ��� ������ ����
//cmt.start();
//System.out.println("ois�� ���� ������ ����");
//System.out.println("����������:" + obj);

//	public static void clrscr(){
//	    // ���� system('cls') ���;
//	    try {
//	        if (System.getProperty("os.name").contains("Windows"))
//	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
//	        else
//	            Runtime.getRuntime().exec("clear");
//	    } catch (IOException | InterruptedException ex) {}
//	}

//						try {
//							for (int i = 2; i >= 1; i--) {
//								Thread.sleep(1000);
//								System.out.println("--- ����ο� �ʰ��� ������ --- [" + i + "��]");
//							}
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//						try {
//							this.wait(2100);
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						ugGui.hide();
//						ugGui.dispose();
//						ugGui.setVisible(false);
//						server.close();
//						throw new InterruptedException();
//						Thread.interrupted();
//						System.out.println("draw mirror, arr col size :"+xx.size());
//						for (int i = 0; i < xx.size(); i++) {
//						}

// �ش� ������ �ٽ� ������ Ŭ������ �ۼ���
// �ʹ� �������� �����̾���
//							System.out.print(i+"|");
//							System.out.print("*"+x.get(i)+"*");
//							ugGui.drawCanvas.x = x.get(i);
//							ugGui.drawCanvas.y = y.get(i);
//							ugGui.drawCanvas.repaint();
//					System.out.println("--- Ŭ���̾�Ʈ�� �����κ��� ������ ��ǥ ---");
//					for (int i = 0; i < xx.size(); i++) {
//						System.out.printf("[user] [x:%3d], [y:%3d]\n", xx.get(i), yy.get(i));
//					}

//					ObjectInputStream ois = null;
//					ois = new ObjectInputStream(new BufferedInputStream(server.getInputStream()));
//					try {
//						for(int i = 2; i > 0; i --) {
//							System.out.println("���� ����� ["+i+"��]");
//							Thread.sleep(1000);
//						}
//					} catch (InterruptedException e2) {
//						// TODO Auto-generated catch block
//						e2.printStackTrace();
//					}
//					try {
//						obj = ois.readObject();
//						if(obj instanceof ClosePacket) {
//							System.out.println("������ Ŭ�����Ϸ�!!!");
//						}
//					} catch (ClassNotFoundException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					try {
//							try {
//								for(int i = 3; i >= 1; i--) {
//									Thread.sleep(100);
//									System.out.println("--- ����ο� �ʰ��� ������ --- ["+i+"��]");
//								}
//							} catch (InterruptedException e) {
//								e.printStackTrace();
//							}
//						}
//					} catch (ClassNotFoundException e1) {
//						e1.printStackTrace();
//					}

//					System.out.println("uip ���ϴ�  unp hash:" + uip);
//					os.close();
//					bos.close();
//					oos.close();
//					System.out.println("unp ���� ��~");
//					System.out.println("�������� �۽��ϴ� ������ �б� ������~");
////////////////////////////////
// �ٽ� �������� �����Ͽ� �۽��� ���� ���� �޴´�.