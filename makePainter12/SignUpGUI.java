package makePainter12;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class SignUpGUI extends JFrame implements ActionListener {
	JLabel txtId, txtPw, txtPwcon, txtName;
	JTextField inputId, inputName;
	JPasswordField inputPw, inputPwcon;
	JButton btnSignup, btnCencel;
	JButton btnChar1, btnChar2, btnChar3, btnChar4;

	String userId = null;
	char[] pwd = null;
	char[] pwd1 = null;
	String nickName = null;
	String charImage = null;
	CatchMindDAO dao = new CatchMindDAO();
	boolean flag = false;
	
	SignUpGUI() {
		super("회원가입");

		// Layout 초기화
		setLayout(null);

		// 컴포넌트 초기화
		btnSignup = new JButton("가입");
		btnCencel = new JButton("취소");

		btnChar1 = new JButton("파이리");
		btnChar2 = new JButton("꼬부기");
		btnChar3 = new JButton("이상해씨");
		btnChar4 = new JButton("피카츄");

		txtId = new JLabel("아이디");
		txtPw = new JLabel("비밀번호");
		txtPwcon = new JLabel("비밀번호 확인");
		txtName = new JLabel("닉네임");

		inputId = new JTextField();
		inputPw = new JPasswordField();
		inputPwcon = new JPasswordField();
		inputName = new JTextField();

		// 컴포넌트 포지션
		btnSignup.setBounds(150, 550, 140, 50);
		btnSignup.addActionListener(this);
		btnCencel.setBounds(300, 550, 140, 50);
		btnCencel.addActionListener(this);

		btnChar1.setBounds(80, 400, 100, 120);
		btnChar1.addActionListener(this);
		btnChar2.setBounds(190, 400, 100, 120);
		btnChar2.addActionListener(this);
		btnChar3.setBounds(300, 400, 100, 120);
		btnChar3.addActionListener(this);
		btnChar4.setBounds(410, 400, 100, 120);
		btnChar4.addActionListener(this);

		txtId.setBounds(200, 120, 80, 30);
		txtPw.setBounds(185, 190, 80, 30);
		txtPwcon.setBounds(155, 230, 90, 30);
		txtName.setBounds(200, 300, 80, 30);

		inputId.setBounds(250, 120, 200, 30);
		inputPw.setBounds(250, 190, 200, 30);
		inputPwcon.setBounds(250, 230, 200, 30);
		inputName.setBounds(250, 300, 200, 30);

		// 컴포넌트 add
		add(btnSignup);
		add(btnCencel);

		add(btnChar1);
		add(btnChar2);
		add(btnChar3);
		add(btnChar4);

		add(txtId);
		add(txtPw);
		add(txtPwcon);
		add(txtName);

		add(inputId);
		add(inputPw);
		add(inputPwcon);
		add(inputName);

		// window
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 50, 600, 700);
		setVisible(true);

	}

	// test main ----------------------------------
	public static void main(String[] args) {
		new GameClient();
	}// test main end ---------------------------------

	// Action Event -----------------------------------
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		userId = inputId.getText();
		pwd = inputPw.getPassword();
		pwd1 = inputPwcon.getPassword();
		nickName = inputName.getText();

		// passWordField char배열로 리턴
		// ==> String 객체로 받기
		String password = new String(pwd);
		String password1 = new String(pwd1);

		// 캐릭터 선택
		if (obj == btnChar1) {
			charImage = btnChar1.getText();
		} else if (obj == btnChar2) {
			charImage = btnChar2.getText();
		} else if (obj == btnChar3) {
			charImage = btnChar3.getText();
		} else if (obj == btnChar4) {
			charImage = btnChar4.getText();
		}
		if (obj == btnSignup) { // 가입버튼 !!!
			while (true) {
				// 전역변수로 null 인식
				System.out.println(userId);
				System.out.println(password);
				System.out.println(password1);
				System.out.println(nickName);
				System.out.println(charImage);

				// 공백 검사
				if (userId.equals("") || nickName.equals("") || charImage == null) {
					JOptionPane.showConfirmDialog(this, "공백", "공백", JOptionPane.PLAIN_MESSAGE);
					break;
				} // 공백검사 end

				// ID 중복 검사
				boolean isOk1 = dao.isExists1(userId);
				if (isOk1) {
					JOptionPane.showConfirmDialog(this, "ID가 중복입니다", "중복", JOptionPane.PLAIN_MESSAGE);
					break;
				} // ID 중복검사 end

				// 비밀번호 동일성 검사
				if (password.equals(password1)) {
					System.out.println("비밀번호 동일");
				} else {
					JOptionPane.showConfirmDialog(this, "비밀번호가 동일하지 않습니다", "비밀번호", JOptionPane.PLAIN_MESSAGE);
					break;
				} // 비밀번호 동일성 검사 end

				// 닉네임 중복검사
				boolean isOk2 = dao.isExists2(nickName);
				if (isOk2) {
					JOptionPane.showConfirmDialog(this, "닉네임이 중복입니다", "중복", JOptionPane.PLAIN_MESSAGE);
					break;
				} // 닉네임 중복검사 end

				// 회원가입
				flag = true;
				break;
			} // while end

			// 회원 가입 성공
			if (flag == true) {
				dao.insertOne(userId, password, nickName, charImage);
				JOptionPane.showConfirmDialog(this, "회원가입", "회원가입", JOptionPane.PLAIN_MESSAGE);
				setVisible(false);

			} // btn_char1 리스너 end

			// 취소 버튼 !!
			// 취소 버튼 !!
		} else if (obj == btnCencel) {
			setVisible(false);
		}
	}// Action Event end ---------------------------------

}
