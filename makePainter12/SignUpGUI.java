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
		super("ȸ������");

		// Layout �ʱ�ȭ
		setLayout(null);

		// ������Ʈ �ʱ�ȭ
		btnSignup = new JButton("����");
		btnCencel = new JButton("���");

		btnChar1 = new JButton("���̸�");
		btnChar2 = new JButton("���α�");
		btnChar3 = new JButton("�̻��ؾ�");
		btnChar4 = new JButton("��ī��");

		txtId = new JLabel("���̵�");
		txtPw = new JLabel("��й�ȣ");
		txtPwcon = new JLabel("��й�ȣ Ȯ��");
		txtName = new JLabel("�г���");

		inputId = new JTextField();
		inputPw = new JPasswordField();
		inputPwcon = new JPasswordField();
		inputName = new JTextField();

		// ������Ʈ ������
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
