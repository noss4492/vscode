package makePainter44;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginGui extends JFrame implements ActionListener {
	JButton btnLogIn, btnExit, btnSignup;
	JLabel txtLogIn, txtPw;
	JTextField inputLogIn;
	JPasswordField inputPw;
	
	Image backimg;
	JLabel backLabel;
	
	LoginGui() {
		super("로그인");
		// Layout 초기화
		setLayout(null);
		
		//해상도 툴킷
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension dmen = tool.getScreenSize();
		double scr_Width = dmen.getWidth();
		double scr_Height = dmen.getHeight();
		int widthX = (int)(scr_Width/2 - 1280/2); 
		int heightY = (int)(scr_Height/2 - 960/2);
		
		// 컴포넌트 초기화
		
		btnLogIn = new JButton("캐치 !");
		btnSignup = new JButton("회원가입");
		btnExit = new JButton("접속을 종료합니다");

		txtLogIn = new JLabel("아이디");
		txtPw = new JLabel("비밀번호");

		inputLogIn = new JTextField(20);
		inputPw = new JPasswordField(20);
		
		
		//이미지
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
		
		//이미지

		
		
		// 컴포넌트 add
		add(btnLogIn);
		add(btnSignup);
		add(btnExit);

		add(txtLogIn);
		add(txtPw);

		add(inputLogIn);
		add(inputPw);
		//window
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(widthX, heightY, 1280, 960);
		setVisible(true);
	}
	
		
	
	// main --------------------------------------------------
	public static void main(String[] args) {
		new LoginGui();
	}// test main End-------------------------------------

	// Action Event ---------------------------------------
	@Override
	public void actionPerformed(ActionEvent arg0) {
Object obj = arg0.getSource();
		
		if(obj == btnLogIn) {
			String userId = inputLogIn.getText();
			char[] pwd = inputPw.getPassword();
			String password = new String(pwd);
			
			CatchMindDAO dao = new CatchMindDAO();
			Socket server;
			
			boolean isOk = dao.isExists(userId, password);
			if(isOk) {
				JOptionPane.showConfirmDialog(
						this, "로그인 성공","check", 
						JOptionPane.PLAIN_MESSAGE);
				
				setVisible(false);	// 로그인창 off
				new MainGui(); // 메인 게임창으로 전환
				
				// 여기서 통신이 일어나야함. 
				// 통신 내용은 이 클라이언트가 서버에 연결하는 것
				// 이 부분은 일단 다 때려박아 작성한 후 클래스로 분리해서 이쁘게 정리하던가 함
				
				// 연결되면 일단 유저 아이디 닉네임 정도는 보내주자 ㅠ.ㅠ
				// 개체 직렬화 필요함...ㅠ.ㅠ
				String ip = "192.168.0.49";
				int port = 5000;
				try {
					server = new Socket(ip,port);	// 이러면서버에서 확인해서 연결
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				
				
				
			} else {
				JOptionPane.showConfirmDialog(
						this, "아이디, 비밀번호가 다릅니다","check", 
						JOptionPane.PLAIN_MESSAGE);
			}
		} else if(obj == btnSignup) {  //회원가입 버튼
			new SignUpGui();	
		
		} else
			System.exit(0);
	}// Action Event End-------------------------------------
}

				
				
				
				
			
