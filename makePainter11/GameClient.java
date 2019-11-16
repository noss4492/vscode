package makePainter11;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GameClient extends JFrame implements ActionListener, Runnable {
	JButton btnLogIn, btnExit, btnSignup;
	JLabel txtLogIn, txtPw;
	JTextField inputLogIn;
	JPasswordField inputPw;
	UserInfo userinfo;
	Socket server;
	Image backimg;
	JLabel backLabel;
	UserGameGUI ugGui; // 이거 뭐 미러이미지 때문에 참조값 필요해서 넣어둠.
//	ArrayList<Integer> x;
//	ArrayList<Integer> y;

	GameClient() {
		super("로그인");
		System.out.println("GameClient 호출됨");
		// Layout 초기화
		setLayout(null);

		// 해상도 툴킷
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension dmen = tool.getScreenSize();
		double scr_Width = dmen.getWidth();
		double scr_Height = dmen.getHeight();
		int widthX = (int) (scr_Width / 2 - 1280 / 2);
		int heightY = (int) (scr_Height / 2 - 960 / 2);

		// 컴포넌트 초기화

		btnLogIn = new JButton("캐치 !");
		btnSignup = new JButton("회원가입");
		btnExit = new JButton("접속을 종료합니다");

		txtLogIn = new JLabel("아이디");
		txtPw = new JLabel("비밀번호");

		inputLogIn = new JTextField(20);
		inputPw = new JPasswordField(20);

		// 이미지
		backimg = tool.createImage("src/images/LoginBack.jpg");
		backLabel = new JLabel(new ImageIcon(backimg));
		this.setContentPane(backLabel);

		// 컴포넌트 포지션
		btnLogIn.setBounds(490, 620, 300, 40);
		btnLogIn.addActionListener(this);
		btnSignup.setBounds(490, 670, 300, 40);
		btnSignup.addActionListener(this);
		btnExit.setBounds(490, 720, 300, 40);
		btnExit.addActionListener(this);

		txtLogIn.setBounds(490, 460, 70, 30);
		txtPw.setBounds(490, 520, 70, 30);

		inputLogIn.setBounds(490, 485, 300, 30);
		inputPw.setBounds(490, 545, 300, 30);

		// 이미지

		// 컴포넌트 add
		add(btnLogIn);
		add(btnSignup);
		add(btnExit);

		add(txtLogIn);
		add(txtPw);

		add(inputLogIn);
		add(inputPw);
		// window
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(widthX, heightY, 1280, 960);
		setVisible(true);
	}

	// main --------------------------------------------------
	public static void main(String[] args) {
		new GameClient();
	}// test main End-------------------------------------

	/////////////////////////
	/////////////////////

	// Action Event ---------------------------------------
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();

		if (obj == btnLogIn) {
			String userId = inputLogIn.getText();
			char[] pwd = inputPw.getPassword();
			String password = new String(pwd);

			CatchMindDAO dao = new CatchMindDAO();

			boolean isOk = dao.isExists(userId, password);
			if (isOk) {
				JOptionPane.showConfirmDialog(this, "로그인 성공", "check", JOptionPane.PLAIN_MESSAGE);

				setVisible(false); // 로그인창 off

				// 여기서 통신이 일어나야함.
				// 통신 내용은 이 클라이언트가 서버에 연결하는 것
				// 이 부분은 일단 다 때려박아 작성한 후 클래스로 분리해서 이쁘게 정리하던가 함

				String ip = "192.168.0.49";
//				String ip = "192.168.0.22";
//				String ip = "192.168.35.123";
				int port = 5000;
				BufferedOutputStream bos;
				ObjectOutputStream oos = null;
				OutputStream os;

				try {
					server = new Socket(ip, port); // 이러면서버에서 확인해서 연결
					// 연결시의 닉네임 정보를 서버단을 전송
					// 지금은 String 정보 하나(user nickname을 전송하면 됨 )
					// 근데 String으로 받는 정보들은 채팅에 사용될 예정이므로 다른 객체로 보내야함.
					String nickname;
					String monsterType;
					nickname = dao.selectOneNickname(userId);
					monsterType = dao.selectOneMonsterType(userId);

					System.out.println("nickname 받아와서 이거 패킷에 넣을 것임 : " + nickname);
					System.out.println("monsterType 받아와서 이거 패킷에 넣을 것임 : " + monsterType);
					os = server.getOutputStream();
					bos = new BufferedOutputStream(os);
					oos = new ObjectOutputStream(bos);

					UserInitializePacket uip = new UserInitializePacket(nickname, monsterType);
					System.out.println("uip 갑니다  unp hash:" + uip);

					if (uip instanceof UserInitializePacket) {
						oos.writeObject(uip);
						oos.flush();
					}

//					os.close();
//					bos.close();
//					oos.close();

					System.out.println("unp 전송 끝~");
					System.out.println("서버에서 송신하는 정보를 읽기 시작함~");
					////////////////////////////////
					// 다시 서버에서 취합하여 송신한 유저 정보 받는다.

				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 메인 게임창으로 전환. 이거 참조값을 받아서 mainGUI화면도 조정해야 할 것 같은데?
				ugGui = new UserGameGUI(server, oos);
				vGame(); // 이제부터 따로 쓰레드 계속 돌게
//				ClientMainThread cmt = new ClientMainThread(server); // 통신 쓰레드 시작
//				cmt.start();
			} else {
				JOptionPane.showConfirmDialog(this, "아이디, 비밀번호가 다릅니다", "check", JOptionPane.PLAIN_MESSAGE);
			}
		} else if (obj == btnSignup) { // 회원가입 버튼
			new SignUpGUI();

		} else
			System.exit(0);
	}// Action Event End-------------------------------------

	private void vGame() { // 게임관련 통신부
		Thread th = new Thread(this);
		th.start();
	}

	@Override
	public void run() { // 이 부분은 게임이 진행되는 쓰레드임.

		// 여기가 계속 동작되는부분임
		// 소켓객체 생성 / 수신부 / 발신부 / 반복해서 동작 / 몬ㄱ ㅏ 출력함
//				Thread.sleep(2000);
//				System.out.println("target_server : "+server);
		// 서버에서 보낸 좌표를 받자.

		while (true) { // 여기에서부터 게임 시작시 클라이언트의 통신을 시작함
			// 좌표 수신
			ArrayList<Integer> x = new ArrayList<Integer>();
			ArrayList<Integer> y = new ArrayList<Integer>();
			Object obj;
			ObjectInputStream ois = null;
			try {
				ois = new ObjectInputStream(new BufferedInputStream(server.getInputStream()));
				if (!ois.equals(null)) {
					System.out.println("ois에 읽을 정보가 있음");
					obj = ois.readObject();
					System.out.println("서버가보냄:" + obj);
					if (obj instanceof BoxedStrokePoint) {
						x = ((BoxedStrokePoint) obj).getPointX();
						y = ((BoxedStrokePoint) obj).getPointY();
						System.out.println("draw mirror, arr col size :"+x.size());
						DrawMirrorThread mirrorTh = new DrawMirrorThread(ugGui.drawCanvas, x, y);
						mirrorTh.start();	// 미러링 쓰레드 계속 동작해야함.
						for (int i = 0; i < x.size(); i++) {
//							System.out.print(i+"|");
//							System.out.print("*"+x.get(i)+"*");
//							ugGui.drawCanvas.x = x.get(i);
//							ugGui.drawCanvas.y = y.get(i);
//							ugGui.drawCanvas.repaint();
						}
					}
					System.out.println("--- 클라이언트가 서버로부터 수신한 좌표 ---");
					for (int i = 0; i < x.size(); i++) {
						System.out.printf("[user] [x:%3d], [y:%3d]\n", x.get(i), y.get(i));
					}
					// 이 좌표정보로 다시 유저의 화면을 갱신한다.

				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
