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

// 중도입장했다면 로그인시에 -> 화면을 서버에서 받아서 그려야함 -> 누적된 좌표를 서버에서 보내기 (자원 소모량이 좀 클 듯. 보류)

public class GameClient extends JFrame implements ActionListener, Runnable, KeyListener {
	private static final long serialVersionUID = 618340375L;

	JButton btnLogIn, btnExit, btnSignup;
	JLabel txtLogIn, txtPw;
	JTextField inputLogIn;
	JPasswordField inputPw;
	Image backimg;
	JLabel backLabel, backID, backPW;

	StringBuffer userChatView;
	UserInfo userinfo; // 게임시 클라이언트가 가지고 있을 유저정보 (계속 갱신되는 정보)
	ArrayList<UserInfo> scrAllUserinfo;
	UserGameGUI ugGui; // 이거 뭐 미러이미지 때문에 참조값 필요해서 넣어둠.
	Socket server;
	String ansWord;
	static final int MAX_TIMER = 60;
	static int timeT = MAX_TIMER*2;

	static {
		Runnable sesTimer = new Runnable() { // 얘의 flag를 체크하는 쓰레드를 따로 만들어서 다 시 작 성 해 보 자
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
		super("로그인");
		// Layout 초기화
		setLayout(null);

		// 해상도 툴킷
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension dmen = tool.getScreenSize();
		double scr_Width = dmen.getWidth();
		double scr_Height = dmen.getHeight();
		int widthX = (int) (scr_Width / 2 - 1280 / 2);
		int heightY = (int) (scr_Height / 2 - 800 / 2);

		// 컴포넌트 초기화

		btnLogIn = new JButton(new ImageIcon("src/images/Login.png"));
		btnSignup = new JButton(new ImageIcon("src/images/loginSignup.png"));
		btnExit = new JButton(new ImageIcon("src/images/LoginExit.png"));

		txtLogIn = new JLabel("아이디");
		txtPw = new JLabel("비밀번호");

		inputLogIn = new JTextField(20);
		inputPw = new JPasswordField(33);

		// 이미지
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

		// 컴포넌트 포지션
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

		// 컴포넌트 add
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
			JOptionPane.showConfirmDialog(this, "로그인 성공", "check", JOptionPane.PLAIN_MESSAGE);
			setVisible(false); // 로그인창 off

//			String ip = "192.168.0.49";
			String ip = "192.168.0.49";
//			String ip = "192.168.0.22";
//			String ip = "192.168.35.123";
			int port = 5000;
			String nickname = null;
			String monsterType = null;
			ObjectOutputStream oos = null;

			try {
				server = new Socket(ip, port); // 이러면 서버에서 확인해서 연결

				nickname = dao.selectOneNickname(userId);
				monsterType = dao.selectOneMonsterType(userId);

				// DB에서 조회해온 유저의 닉네임과 몬스터 타입을 서버로 보낸다. (목적:서버에서 유저 초기 정보를 취합해서 다시 여기로 보내주어 게임 초기
				// 정보를 갖게 하려고)

				oos = new ObjectOutputStream(new BufferedOutputStream(server.getOutputStream()));

				UserInitializePacket uip = new UserInitializePacket(nickname, monsterType);

				oos.writeObject(uip);
				oos.flush();

				try { // 동시성이 너무 불안해서 안정성을 주기 위해서 추가해봄, 일단 대기 시간 안줘도 통신은 완벽하게 작동됨
					for (int i = (int) (2 * Math.random() + 2) * 1; i > 0; i--) { // 3~2초
						System.out.println("입장 대기중 [" + i + "초]");
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
			// 메인 게임창으로 전환.
			ugGui = new UserGameGUI(server, oos, nickname);
			vGame(); // 로그인 완료한 후 시점, 이제부터 게임 진행시 통신을 지속적으로 검사할 쓰레드를 생성
		} else {
			JOptionPane.showConfirmDialog(this, "아이디, 비밀번호가 다릅니다", "check", JOptionPane.PLAIN_MESSAGE);
		}
	}
	// login() method start

	private void vGame() { // 게임관련 통신부
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
	public void run() { // 이 부분은 게임이 진행되는 것을 관찰(검사)하고 있는 쓰레드임.
		while (true) { // (로그인 끝난 후 클라이언트의 통신)
			// 좌표 수신
			Object obj;
			ObjectInputStream ois = null;
			ObjectOutputStream oos = null;
			try {
				ois = new ObjectInputStream(new BufferedInputStream(server.getInputStream()));
				if (!ois.equals(null)) {
					obj = ois.readObject();
					if (obj instanceof StrokePointPacket) { // 미러링 쓰레드 작동
//						System.out.printf("client수신:[c:%3d|x:%3d|y:%3d]\n",((StrokePointPacket) obj).getColorF().get(0),
//								((StrokePointPacket) obj).getPointX().get(0), ((StrokePointPacket) obj).getPointY().get(0));
						new DrawMirrorThread(ugGui.drawCanvas, ((StrokePointPacket) obj).getColorF(),
								((StrokePointPacket) obj).getPointX(), ((StrokePointPacket) obj).getPointY()).start();
					} else if (obj instanceof ClosePacket) {
						// server.close(); 보류
					} else if (obj instanceof ChatPacket) {
						ugGui.jtaChat.append(((ChatPacket) obj).getMsg());
						System.out.println("서버에서 채팅로그 받음");
					} else if (obj instanceof DisplayInfoPacket) {
						ugGui.drawCanvas.callClearAll();
						scrAllUserinfo = ((DisplayInfoPacket) obj).getUserinfo();
						int tmpDip = ((DisplayInfoPacket) obj).getUserinfo().size();
						
						
						
//						for(int i = 0 ; i < tmpDip; i++) {
////							((DisplayInfoPacket) obj).getUserinfo().get(i).getMonsterType();
//							System.out.println("디스플레이패킷 보냈서!!");
//							System.out.println(userinfo.getSeq());
//							System.out.println(ugGui.jlNick[i].getText());
//							ugGui.jlNick[userinfo.getSeq()].setText(((DisplayInfoPacket) obj).getUserinfo().get(userinfo.getSeq()).getNickname());
//							ugGui.jlCharacter[userinfo.getSeq()].setIcon(ugGui.char1Img); // 테스트 해봄걍
////							ugGui.jlNick[userinfo.getSeq()].set(); // 테스트 해봄걍
//						}
//							
//							;
//						if(userinfo.getMonsterType() == "꼬부기")	//userinfo // mon
//							ugGui.jlCharacter[userinfo.getSeq()].setIcon(ugGui.char1Img);

						// 자기 화면에 자기만 나오는 코드임.
//						for (int i = 0; i < tmpDip; i++) {
//							ugGui.jlNick[userinfo.getSeq()].setText(
//									((DisplayInfoPacket) obj).getUserinfo().get(userinfo.getSeq()).getNickname());
//							System.out.println("클라이언트가 DIP를 받음 : ");
//							System.out.println("user seq : "+userinfo.getSeq());
//							System.out.println("nick"+((DisplayInfoPacket) obj).getUserinfo().get(userinfo.getSeq()).getNickname());
//							ugGui.jlCharacter[userinfo.getSeq()].setIcon(ugGui.char1Img);
//						}
						// ' '

						for (int i = 0; i < scrAllUserinfo.size(); i++) {
							ugGui.jlNick[i].setText(scrAllUserinfo.get(i).getNickname());
//							ugGui.jlCharacter[i].setIcon(ugGui.char1Img);
							if (scrAllUserinfo.get(i).getMonsterType().equals("피카츄")) {
								ugGui.jlCharacter[i].setIcon(new ImageIcon("src/images/char1.gif"));
							} else if (scrAllUserinfo.get(i).getMonsterType().equals("푸린")) {
								ugGui.jlCharacter[i].setIcon(new ImageIcon("src/images/char2.gif"));
							} else if (scrAllUserinfo.get(i).getMonsterType().equals("꼬부기")) {
								ugGui.jlCharacter[i].setIcon(new ImageIcon("src/images/char3.gif"));
							} else if (scrAllUserinfo.get(i).getMonsterType().equals("이브이")) {
								ugGui.jlCharacter[i].setIcon(new ImageIcon("src/images/char4.gif"));
							}
						}
						System.out.println("클라이언트에서 displayinfopacket을 수신함");
						System.out.println("서버에서 전체 유저정보 받음");
						System.out.println("이것이 서버에서부터 왔대");
						for (int i = 0; i < scrAllUserinfo.size(); i++) {
							System.out.println("닉넴\t:" + scrAllUserinfo.get(i).getNickname());
							System.out.println("순서\t:" + scrAllUserinfo.get(i).getSeq());
							System.out.println("캐릭터\t:" + scrAllUserinfo.get(i).getMonsterType());
							System.out.println("점수\t:" + scrAllUserinfo.get(i).getPoint());
							System.out.println("출제자인가:" + scrAllUserinfo.get(i).isExaminer());
						}
						for (int i = 0; i < scrAllUserinfo.size(); i++)
							System.out.printf("[닉넴 : %s], [출제자? : %b]", scrAllUserinfo.get(i).getNickname(),
									scrAllUserinfo.get(i).isExaminer());
					} else if (obj instanceof UserInfoPacket) {
						userinfo = ((UserInfoPacket) obj).getInfoBox();
						System.out.println("서버에서 내 다음 유저정보 받음");
						System.out.println(((UserInfoPacket) obj).getInfoBox().getNickname() + "|"
								+ ((UserInfoPacket) obj).getInfoBox().examiner);
					} else if (obj instanceof ProtocolPacket) {
						if (((ProtocolPacket) obj).getDefinedCase() == 1) {
							System.out.println("유저 정보 서버로 송신함");
							// 서버에서 유저에게 정보를 요구함. 송신해주자.
							oos = new ObjectOutputStream(new BufferedOutputStream(server.getOutputStream()));
							oos.writeObject(userinfo);
							oos.flush();
						} else if (((ProtocolPacket) obj).getDefinedCase() == 999) {
							ugGui.drawCanvas.callClearAll();// 방금 추가됨 다시 확인하고 주석 삭제할 것.
						}
					} else if (obj instanceof QuizWordsPacket) { // 요걸로 디스플레이 할 것 (추가시 삭제 할 주석0
						ansWord = ((QuizWordsPacket) obj).getAnsWord();
						// 이때 투명으로 하면?
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
						 * charImage = "피카츄"; btnChar1.setSelectedIcon(gifImg1); } else if (obj ==
						 * btnChar2) { charImage = "푸린"; btnChar2.setSelectedIcon(gifImg2); } else if
						 * (obj == btnChar3) { charImage = "꼬부기"; btnChar3.setSelectedIcon(gifImg3); }
						 * else if (obj == btnChar4) { charImage = "이브이";
						 */
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
//			ugGui.drawCanvas.callChangeColorRGB();
			// ugGui.drawCanvas.clearAllCall(); // 작동됨
		}
	}

	// ActionEvent start ---------------------------------------
	// 로그인 버튼을 누르면 동작 실행(주 이벤트)
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

	// 유저 편의를 위해 그냥 엔터시 로그인 버튼 누른 것으로 이벤트 동작 설정
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

// 죽음의 코드무덤

// 연결시의 닉네임 정보를 서버단을 전송
// 지금은 String 정보 하나(user nickname을 전송하면 됨 )
// 근데 String으로 받는 정보들은 채팅에 사용될 예정이므로 다른 객체로 보내야함.
//System.out.println("nickname 받아와서 이거 패킷에 넣을 것임 : " + nickname);
//System.out.println("monsterType 받아와서 이거 패킷에 넣을 것임 : " + monsterType);

//if (uip instanceof UserInitializePacket) {
//}
//DrawMirrorThread mirrorTh = 
//new DrawMirrorThread(ugGui.drawCanvas,
//((StrokePointPacket) obj).getPointX(), ((StrokePointPacket) obj).getPointY()).start();
//mirrorTh.start(); 
//System.out.println("서버가 클로즈 패킷을 보냄"); 
//System.out.println("채팅 패킷 받았으니 유저 디스플레이 해주자");
//String thName = th.getName();
//boolean status = Thread.interrupted();
//ClientMainThread cmt = new ClientMainThread(server); // 통신 쓰레드 시작
//cmt.start();
//System.out.println("ois에 읽을 정보가 있음");
//System.out.println("서버가보냄:" + obj);

//	public static void clrscr(){
//	    // 않이 system('cls') 어디감;
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
//								System.out.println("--- 대기인원 초과로 종료중 --- [" + i + "초]");
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

// 해당 구역은 다시 쓰레드 클래스로 작성함
// 너무 원시적인 생각이었음
//							System.out.print(i+"|");
//							System.out.print("*"+x.get(i)+"*");
//							ugGui.drawCanvas.x = x.get(i);
//							ugGui.drawCanvas.y = y.get(i);
//							ugGui.drawCanvas.repaint();
//					System.out.println("--- 클라이언트가 서버로부터 수신한 좌표 ---");
//					for (int i = 0; i < xx.size(); i++) {
//						System.out.printf("[user] [x:%3d], [y:%3d]\n", xx.get(i), yy.get(i));
//					}

//					ObjectInputStream ois = null;
//					ois = new ObjectInputStream(new BufferedInputStream(server.getInputStream()));
//					try {
//						for(int i = 2; i > 0; i --) {
//							System.out.println("입장 대기중 ["+i+"초]");
//							Thread.sleep(1000);
//						}
//					} catch (InterruptedException e2) {
//						// TODO Auto-generated catch block
//						e2.printStackTrace();
//					}
//					try {
//						obj = ois.readObject();
//						if(obj instanceof ClosePacket) {
//							System.out.println("서버가 클로즈하래!!!");
//						}
//					} catch (ClassNotFoundException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					try {
//							try {
//								for(int i = 3; i >= 1; i--) {
//									Thread.sleep(100);
//									System.out.println("--- 대기인원 초과로 종료중 --- ["+i+"초]");
//								}
//							} catch (InterruptedException e) {
//								e.printStackTrace();
//							}
//						}
//					} catch (ClassNotFoundException e1) {
//						e1.printStackTrace();
//					}

//					System.out.println("uip 갑니다  unp hash:" + uip);
//					os.close();
//					bos.close();
//					oos.close();
//					System.out.println("unp 전송 끝~");
//					System.out.println("서버에서 송신하는 정보를 읽기 시작함~");
////////////////////////////////
// 다시 서버에서 취합하여 송신한 유저 정보 받는다.