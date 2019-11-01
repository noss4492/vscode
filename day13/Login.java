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
		// ��ġ �����ڸ� ������� ����
		setLayout(null);
		// Component �ʱ�ȭ
		btnLogin = new Button("login");
		btnReset = new Button("reset");
		blId = new Label("id");
		blPw = new Label("pw");
		tfId = new TextField(20);
		tfPw = new TextField(20);
		
		// Component�� ũ��� ��ġ�� ����
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
		// �̺�Ʈ �ҽ� : �α��ι�ư, ���¹�ư
		// �� �̺�Ʈ �ҽ��� �ڵ鷯�� �߰���
		
		Handler4 hd = new Handler4();
		btnLogin.addActionListener(hd);
		btnReset.addActionListener(hd);
		
		// Container�� �߰�
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
	
	
	// Handler4�� ��� Ŭ������ �����
	// ��ø Ŭ����(nested)
	// �Ǵ� inner class
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
				System.out.println("�����մϴ�.");
				System.exit(0);	//��������, 0 �ƴϸ� ����������
			}
		}
	}	// class end
}	// login class end












//class Handler3 implements ActionListener{
//	@Override
//	public void actionPerformed(ActionEvent e) {
//	}
//}