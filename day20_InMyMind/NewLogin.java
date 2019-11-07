package day20_InMyMind;

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

public class NewLogin extends JFrame implements ActionListener {
	JLabel jlbId, jlbPw;
	JButton jbtnLogin, jbtnRegister;
	JTextField jtfId;
	JPasswordField jpf;

	NewLogin() {
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		jlbId = new JLabel("ID");
		jlbPw = new JLabel("PW");
		jbtnLogin = new JButton("�α���");
		jbtnRegister = new JButton("ȸ������");
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
		Font f = new Font("����ü", Font.PLAIN, 20);
		Font f2 = new Font("����ü", Font.PLAIN, 25);
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
			// 1. ���� ����
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@192.168.0.35:1521:orcl";
			String user = "scott";
			String password = "tiger";

			Connection conn = null;
			PreparedStatement pstmt = null; // ��ӵǾ��ְ� �غ�Ǿ� �ִ� ����
			ResultSet rs = null;

			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e1) {
				System.out.println("����̹��ε�����");
			} catch (SQLException e1) {
				System.out.println("DB�������");
			}
			// ������� �Է°� ��������
			String uid = jtfId.getText();
			char[] ch = jpf.getPassword();
			String pw = new String(ch);

			// sql���ۼ�
			StringBuffer sb = new StringBuffer();
			sb.append("SELECT * " );
			sb.append("FROM ROOMSIX " );
			sb.append("WHERE ID = ? " );		// ?�� bind ����, �̷��� ������ �Ұ���
			sb.append("AND pwd = ? " );
//			sb.append("WHERE ID = '" + uid + "' ");
//			sb.append("AND pwd = '" + pw + "'");

			try {
				pstmt = conn.prepareStatement(sb.toString());
				pstmt.setString(1, uid);
				pstmt.setString(2, pw);
				rs = pstmt.executeQuery(); // return ResultSet

				boolean isOK = rs.next();
				if (isOK) {
					//rs.next();
					String id = rs.getString("id");
					String name = rs.getString("ename");
					String pwd = rs.getString("pwd");
					System.out.println("id : " + id + " name : " + name + " pwd : " + pwd);
				} else {
					int rsd = JOptionPane.showConfirmDialog(this, "�� ������", "�ƹ�ư Ʋ��", JOptionPane.INFORMATION_MESSAGE);
					if (rsd == 0) {
					} else if (rsd == 1) {
					} else if (rsd == 2) {
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
				//System.out.println("sql�� ���ܰ��ƾƾ�");
			} finally {
				if (rs != null) {
					try {
						rs.close(); // to free~
						if (conn != null)
							conn.close();
						if (pstmt != null)
							pstmt.close();
					} catch (SQLException e2) {
					}
				}
			}
		} else if (obj == jbtnRegister) {
			System.out.println("ȸ������");
			StringBuffer sql = new StringBuffer();
			this.setVisible(false);
			new Register();
		}
	}
}
			
			
//			sql.append("INSERT INTO ROOMSIX ");
//			sql.append("VALUES ('"+jtfId.getText()+"', '"+jtfName.getText()+"', '"")
