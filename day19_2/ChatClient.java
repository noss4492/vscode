package day19_2;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements ActionListener, KeyListener, Runnable {
	JPanel jp1, jp2;
	CardLayout cl;
	JLabel jlbIp, jlbPort;
	JButton jbtnLogin, jbtnExit;
	JTextField jtfIp, jtfPort;

	JPanel jpSouth;
	JTextArea jta;
	JTextField jtf;
	JScrollPane jsp;
	JButton jbtnSend;

	String ip;
	int port;
	Socket s; // 연결하고자 하는 애네
	BufferedReader br;
	PrintWriter pw;

	Font f = new Font("굴림체", Font.PLAIN, 22);

	public ChatClient() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		jp1 = new JPanel(); // 로그인화면패널
		jp2 = new JPanel(); // 채팅진행패널

		jpSouth = new JPanel();
		jtf = new JTextField(40);
		jta = new JTextArea();
		jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jp2.setLayout(new BorderLayout());
		jbtnSend = new JButton("전송");
		jpSouth.add(jtf);
		jpSouth.add(jbtnSend);

		jp2.add(jsp, "Center");
		jp2.add(jpSouth, "South");

		jlbIp = new JLabel("IP");
		jlbPort = new JLabel("PORT");
		jbtnLogin = new JButton("로그인");
		jbtnExit = new JButton("종료");
		jtfIp = new JTextField("192.168.0.35");
		jtfPort = new JTextField("5000");
		jta.setFont(f);

		// 첫 번째 로그인 화면으 ㅣ배치관리자를 사용하지 않는다.
		jp1.setLayout(null);

		jlbIp.setBounds(50, 100, 100, 50);
		jlbPort.setBounds(50, 300, 100, 50);
		jtfIp.setBounds(250, 100, 150, 50);
		jtfPort.setBounds(250, 300, 150, 50);
		jbtnLogin.setBounds(150, 450, 150, 50);
		jbtnExit.setBounds(350, 450, 150, 50);

		jp1.add(jlbIp);
		jp1.add(jlbPort);
		jp1.add(jbtnLogin);
		jp1.add(jbtnExit);
		jp1.add(jtfIp);
		jp1.add(jtfPort);

		// 카드레이아웃객체생성
		cl = new CardLayout();
		// 현재 프레임에 배치관리자를 카드레이아웃으로변경
		setLayout(cl);
		setBounds(100, 100, 600, 800);

		jbtnLogin.addActionListener(this);
		jbtnExit.addActionListener(this);
		jbtnSend.addActionListener(this);
		jtf.addKeyListener(this);

		// 현재 프레임을 패널에 부착
		add(jp1, "login");
		add(jp2, "chat");
		// 보여줄패널선택
		cl.show(getContentPane(), "login");
//		cl.show(getContentPane(), "chat");
		setVisible(true);
	}

	public static void main(String[] args) {
		ChatClient cc = new ChatClient();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (jbtnLogin == obj) {
			// login
			ip = jtfIp.getText();
			port = Integer.parseInt(jtfPort.getText());
			// 채팅기능 수행
			VChatting();
			cl.show(getContentPane(), "chat");
			// 두번째 패널로 전환
		} else if (jbtnExit == obj) {
			// exit
			System.out.println("종료합니다");
			System.exit(0);
		} else if (jbtnSend == obj) {
			String msg = jtf.getText();
//			jta.append("me : "+msg+"\n");
			pw.println(msg);
			pw.flush();
			jtf.setText("");
			jtf.requestFocus();
		}
	}

	private void VChatting() {

		// 현재 클라이언트 프로그램을 여러개 띄울 수 있도록
		Thread th = new Thread(this);
		th.start();

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode();
		if (code == 10) {
			String msg = jtf.getText();
//			jta.append("me : "+msg+"\n");
			pw.println(msg);
			pw.flush(); // 요게 리슨에 주는 트리거 인가????? (이거는 아직 추측일 뿐임)
			jtf.setText("");
			jtf.requestFocus();
		}
//		if (code >= '1' && code <= '9') {
//			int size = (code - '0') * 10; // n * 10
//			// / / / / 2 2
//			// / / / / 1 2
//			// / * / *
//			// * /
//			// *
//
//			try {
//				for (int i = 0; i < size * 2; i++) {
//					if (i < size) {
//						for (int j = size - 1; j >= i; j--) {
//							pw.print("*");
//						}
//					} else {
//						for (int j = size; j <i+size; j++) {
//							pw.print("*");
//						}
//					}
//					pw.println("");
//					pw.flush(); // 요게 리슨에 주는 트리거 인가????? (이거는 아직 추측일 뿐임)
//					Thread.sleep(50);
//				}
//			} catch (InterruptedException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}
//			pw.println("");

//		jtf.setText("");
//		jtf.requestFocus();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// 채팅
		// 1소켓객체 생성
		// 2수신부
		// 3발신부
		// 4반복해서 읽기
		// 5화면에 출력
		try {
			s = new Socket(ip, port);
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));

			pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(s.getOutputStream()))); // Returns an output

			String msg = null;
			while (true) { // 그냥 클라 채팅창 텍스트에어리어 유지 시켜주는 구문임. soso
				msg = br.readLine();

				JScrollBar sb = jsp.getVerticalScrollBar();
				int position = sb.getMaximum();
				sb.setValue(position);

				jta.append(msg + "\n"); // 이거는 그냥 클라이언트 화면에 뿌려주는 용도고
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
