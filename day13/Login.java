package day13;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends Frame{
	static int width = 800;
	static int height = 600;
	Label blId, blPw;
	Button btnLogin, btnReset;
	TextField tfId;
	TextField tfPw;
	String id;
	String pw;

	Login(String title){
		super(title);
		// 배치 관리자를 사용하지 않음
		setLayout(null);
		// Component 초기화
		btnLogin = new Button("login");
		btnReset = new Button("reset");
		blId = new Label("id");
		blPw = new Label("pw");
		tfId = new TextField(20);
		tfPw = new TextField(20);
		
		// Component의 크기와 위치를 지정
		setSize(width, height);
		setLocation(50, 50);
		Color c = new Color(35,200,46);
		Color c2 = new Color(201,48,40);
		
		Font f = new Font("MyFont", Font.BOLD+Font.ITALIC, 26);
	
		btnLogin.setSize(100, 50);
		btnLogin.setLocation(200, 450);
		btnLogin.setBackground(c);
		btnReset.setBounds(400, 450, 100, 50);
		btnReset.setBackground(c2);
		blId.setBounds(150,  150,  80,  60);
		blPw.setBounds(150,  300,  80,  60);
		tfId.setBounds(260, 150, 280, 60);
		tfPw.setBounds(260, 300, 280, 60);
		tfId.setFont(f);
		tfPw.setFont(f);
		tfPw.setEchoChar('*');
		// 이벤트 소스 : 로그인버튼, 리셋버튼
		// 각 이벤트 소스에 핸들러를 추가함
		
		Handler4 hd = new Handler4();
		btnLogin.addActionListener(hd);
		btnReset.addActionListener(hd);
		
		// Container에 추가
		add(blId);
		add(blPw);
		add(btnLogin);
		add(btnReset);
		add(tfId);
		add(tfPw);
		
		setVisible(true);
	}
//	Handler3 hd = new Handler3();
	public static void main(String[] args) {
		Login l = new Login("Login");
	}
	
	
	// Handler4를 멤버 클래스로 만들면
	// 중첩 클래스(nested)
	// 또는 inner class
	class Handler4 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(cmd.equalsIgnoreCase("login")) {
				System.out.println(">>login");
				id = tfId.getText();		
				pw = tfPw.getText();
				System.out.println("id : "+id+" pw : "+pw);
			}else if(cmd.equalsIgnoreCase("reset")) {
//				System.out.println(">>reset");
//				tfId.setText("");
//				tfPw.setText("");
//				id = "";
//				pw = "";
//				System.out.println("id : "+id+" pw : "+pw);
				System.out.println("종료합니다.");
				System.exit(0);	//정상종료, 0 아니면 비정상종료
			}
		}
	}	// class end
}	// login class end












//class Handler3 implements ActionListener{
//	@Override
//	public void actionPerformed(ActionEvent e) {
//	}
//}