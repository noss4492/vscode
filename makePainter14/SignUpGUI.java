package makePainter14;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUpGUI extends JFrame implements ActionListener {
	JLabel txtId, txtPw, txtPwcon, txtName;
	JTextField inputId, inputName;
	JPasswordField inputPw, inputPwcon;
	JButton btnSignup, btnCencel;
	JButton btnChar1, btnChar2, btnChar3, btnChar4;

	JPanel background;
	JLabel backImg;
	
	String userId = null;
	char[] pwd = null;
	char[] pwd1 = null;
	String nickName = null;
	String charImage = null;
	CatchMindDAO dao = new CatchMindDAO();
	boolean flag = false;

	SignUpGUI() {
		super("ȸ������");

		// Layout �ʱ�ȭ
		setLayout(null);
		
		//��Ŷ
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension dmen = tool.getScreenSize();
		double scr_Width = dmen.getWidth();
		double scr_Height = dmen.getHeight();
		int widthX = (int)(scr_Width/2 - 610/2); 
		int heightY = (int)(scr_Height/2 - 700/2);

		// ������Ʈ �ʱ�ȭ
		background = new JPanel();
		backImg = new JLabel(new ImageIcon("src/images/signupBack.png"));
		
		btnSignup = new JButton(new ImageIcon("src/images/signup.png"));
		btnCencel = new JButton(new ImageIcon("src/images/cencel.png"));

		btnChar1 = new JButton(new ImageIcon("src/images/char1.gif"));
		btnChar2 = new JButton(new ImageIcon("src/images/char2.gif"));
		btnChar3 = new JButton(new ImageIcon("src/images/char3.gif"));
		btnChar4 = new JButton(new ImageIcon("src/images/char4.gif"));

		txtId = new JLabel("        ���̵�");
		txtPw = new JLabel("      ��й�ȣ");
		txtPwcon = new JLabel(" ��й�ȣ Ȯ��");
		txtName = new JLabel("         �г���");

		inputId = new JTextField();
		inputPw = new JPasswordField();
		inputPwcon = new JPasswordField();
		inputName = new JTextField();

		// ������Ʈ ������
		btnSignup.setBounds(160, 550, 140, 50);
		btnSignup.addActionListener(this);
		btnCencel.setBounds(310, 550, 140, 50);
		btnCencel.addActionListener(this);

		btnChar1.setBounds(10, 370, 140, 160);
		btnChar1.addActionListener(this);
		btnChar2.setBounds(160, 370, 140, 160);
		btnChar2.addActionListener(this);
		btnChar3.setBounds(310, 370, 140, 160);
		btnChar3.addActionListener(this);
		btnChar4.setBounds(460, 370, 140, 160);
		btnChar4.addActionListener(this);

		txtId.setBounds(145, 120, 90, 30);
		txtPw.setBounds(145, 190, 90, 30);
		txtPwcon.setBounds(145, 230, 90, 30);
		txtName.setBounds(145, 300, 90, 30);

		inputId.setBounds(240, 120, 200, 30);
		inputPw.setBounds(240, 190, 200, 30);
		inputPwcon.setBounds(240, 230, 200, 30);
		inputName.setBounds(240, 300, 200, 30);

		background.setSize(610,700);
		// Color
		Color tran = new Color(0, 0, 0, 80);
		txtId.setOpaque(true);
		txtId.setBackground(tran);
		txtId.setForeground(Color.white);
		txtPw.setOpaque(true);
		txtPw.setBackground(tran);
		txtPw.setForeground(Color.white);
		txtPwcon.setOpaque(true);
		txtPwcon.setBackground(tran);
		txtPwcon.setForeground(Color.white);
		txtName.setOpaque(true);
		txtName.setBackground(tran);
		txtName.setForeground(Color.white);
		inputId.setBorder(null);
		inputPw.setBorder(null);
		inputPwcon.setBorder(null);
		inputName.setBorder(null);
		
		// ������Ʈ add
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

		background.add(backImg);
		add(background);
		
		// window
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(widthX, heightY, 610, 700);
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

		// passWordField char�迭�� ����
		// ==> String ��ü�� �ޱ�
		String password = new String(pwd);
		String password1 = new String(pwd1);

		// ĳ���� ����
		if (obj == btnChar1) {
			charImage = btnChar1.getText();
		} else if (obj == btnChar2) {
			charImage = btnChar2.getText();
		} else if (obj == btnChar3) {
			charImage = btnChar3.getText();
		} else if (obj == btnChar4) {
			charImage = btnChar4.getText();
		}
		if (obj == btnSignup) { // ���Թ�ư !!!
			while (true) {
				// ���������� null �ν�
				System.out.println(userId);
				System.out.println(password);
				System.out.println(password1);
				System.out.println(nickName);
				System.out.println(charImage);

				// ���� �˻�
				if (userId.equals("") || nickName.equals("") || charImage == null) {
					JOptionPane.showConfirmDialog(this, "����", "����", JOptionPane.PLAIN_MESSAGE);
					break;
				} // ����˻� end

				// ID �ߺ� �˻�
				boolean isOk1 = dao.isExists1(userId);
				if (isOk1) {
					JOptionPane.showConfirmDialog(this, "ID�� �ߺ��Դϴ�", "�ߺ�", JOptionPane.PLAIN_MESSAGE);
					break;
				} // ID �ߺ��˻� end

				// ��й�ȣ ���ϼ� �˻�
				if (password.equals(password1)) {
					System.out.println("��й�ȣ ����");
				} else {
					JOptionPane.showConfirmDialog(this, "��й�ȣ�� �������� �ʽ��ϴ�", "��й�ȣ", JOptionPane.PLAIN_MESSAGE);
					break;
				} // ��й�ȣ ���ϼ� �˻� end

				// �г��� �ߺ��˻�
				boolean isOk2 = dao.isExists2(nickName);
				if (isOk2) {
					JOptionPane.showConfirmDialog(this, "�г����� �ߺ��Դϴ�", "�ߺ�", JOptionPane.PLAIN_MESSAGE);
					break;
				} // �г��� �ߺ��˻� end

				// ȸ������
				flag = true;
				break;
			} // while end

			// ȸ�� ���� ����
			if (flag == true) {
				dao.insertOne(userId, password, nickName, charImage);
				JOptionPane.showConfirmDialog(this, "ȸ������", "ȸ������", JOptionPane.PLAIN_MESSAGE);
				setVisible(false);

			} // btn_char1 ������ end

			// ��� ��ư !!
			// ��� ��ư !!
		} else if (obj == btnCencel) {
			setVisible(false);
		}
	}// Action Event end ---------------------------------

}
