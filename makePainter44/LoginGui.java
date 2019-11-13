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
		super("�α���");
		// Layout �ʱ�ȭ
		setLayout(null);
		
		//�ػ� ��Ŷ
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension dmen = tool.getScreenSize();
		double scr_Width = dmen.getWidth();
		double scr_Height = dmen.getHeight();
		int widthX = (int)(scr_Width/2 - 1280/2); 
		int heightY = (int)(scr_Height/2 - 960/2);
		
		// ������Ʈ �ʱ�ȭ
		
		btnLogIn = new JButton("ĳġ !");
		btnSignup = new JButton("ȸ������");
		btnExit = new JButton("������ �����մϴ�");

		txtLogIn = new JLabel("���̵�");
		txtPw = new JLabel("��й�ȣ");

		inputLogIn = new JTextField(20);
		inputPw = new JPasswordField(20);
		
		
		//�̹���
		backimg = tool.createImage("src/images/LoginBack.jpg");
		backLabel = new JLabel(new ImageIcon(backimg));
		this.setContentPane(backLabel);
		
		// ������Ʈ ������
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
		
		//�̹���

		
		
		// ������Ʈ add
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
						this, "�α��� ����","check", 
						JOptionPane.PLAIN_MESSAGE);
				
				setVisible(false);	// �α���â off
				new MainGui(); // ���� ����â���� ��ȯ
				
				// ���⼭ ����� �Ͼ����. 
				// ��� ������ �� Ŭ���̾�Ʈ�� ������ �����ϴ� ��
				// �� �κ��� �ϴ� �� �����ھ� �ۼ��� �� Ŭ������ �и��ؼ� �̻ڰ� �����ϴ��� ��
				
				// ����Ǹ� �ϴ� ���� ���̵� �г��� ������ �������� ��.��
				// ��ü ����ȭ �ʿ���...��.��
				String ip = "192.168.0.49";
				int port = 5000;
				try {
					server = new Socket(ip,port);	// �̷��鼭������ Ȯ���ؼ� ����
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				
				
				
			} else {
				JOptionPane.showConfirmDialog(
						this, "���̵�, ��й�ȣ�� �ٸ��ϴ�","check", 
						JOptionPane.PLAIN_MESSAGE);
			}
		} else if(obj == btnSignup) {  //ȸ������ ��ư
			new SignUpGui();	
		
		} else
			System.exit(0);
	}// Action Event End-------------------------------------
}

				
				
				
				
			
