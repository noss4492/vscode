package day21_2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.RoomsixDAO;
import day19_2.ChatClient;

public class NewLogin extends JFrame implements ActionListener {
	JLabel jlbId, jlbPw;
	JButton jbtnLogin, jbtnRegister;
	JTextField jtfId;
	JPasswordField jpf;

	NewLogin() {
		setLayout(null);
		jlbId = new JLabel("ID");
		jlbPw = new JLabel("PW");
		jbtnLogin = new JButton("로그인");
		jbtnRegister = new JButton("회원가입");
		jtfId = new JTextField(20);
		jpf = new JPasswordField(20);

		jlbId.setBounds(50, 150, 80, 60);
		jlbPw.setBounds(50, 250, 80, 60);
		add(jlbId);
		add(jlbPw);

		jbtnLogin.setBounds(150, 400, 100, 60);
		jbtnRegister.setBounds(300, 400, 150, 130);
		add(jbtnLogin);
		add(jbtnRegister);

		jtfId.setBounds(150, 150, 300, 60);
		jpf.setBounds(150, 250, 300, 60);
		Font f = new Font("굴림체", Font.PLAIN, 20);
		Font f2 = new Font("굴림체", Font.PLAIN, 25);
		jtfId.setFont(f);
		jpf.setFont(f);
		add(jtfId);
		add(jpf);

		jbtnLogin.addActionListener(this);
		jbtnRegister.addActionListener(this);

		setBounds(100, 100, 500, 600);
		setVisible(true);
	}

	public static void main(String[] args) {
		new NewLogin();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == jbtnLogin) {
			// 사용자의 입력값 가져오기
			String uid = jtfId.getText();
			char[] ch = jpf.getPassword();
			String pw = new String(ch);
			RoomsixDAO dao = new RoomsixDAO();
			boolean isOK = dao.isExists(uid, pw);
			if(isOK) {
				new ChatClient();
				this.setVisible(false);
			}else {
				JOptionPane.showConfirmDialog(this, "너누구", "메롱", JOptionPane.PLAIN_MESSAGE);
			}
			dao.close();
		} else if (obj == jbtnRegister) {
//			StringBuffer sql = new StringBuffer();
			this.setVisible(false);
			new Register(this);
		}
	}
}

//			sql.append("INSERT INTO ROOMSIX ");
//			sql.append("VALUES ('"+jtfId.getText()+"', '"+jtfName.getText()+"', '"")
