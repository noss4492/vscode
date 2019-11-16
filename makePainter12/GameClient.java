package makePainter12;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GameClient extends JFrame implements ActionListener, Runnable {
	JButton btnLogIn, btnExit, btnSignup;
	JLabel txtLogIn, txtPw;
	JTextField inputLogIn;
	JPasswordField inputPw;
	UserInfo userinfo;
	Socket server;
	Image backimg;
	JLabel backLabel;
	UserGameGUI ugGui; // �̰� �� �̷��̹��� ������ ������ �ʿ��ؼ� �־��.
//	ArrayList<Integer> x;
//	ArrayList<Integer> y;

	GameClient() {
		super("�α���");
		System.out.println("GameClient ȣ���");
		// Layout �ʱ�ȭ
		setLayout(null);

		// �ػ� ��Ŷ
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension dmen = tool.getScreenSize();
		double scr_Width = dmen.getWidth();
		double scr_Height = dmen.getHeight();
		int widthX = (int) (scr_Width / 2 - 1280 / 2);
		int heightY = (int) (scr_Height / 2 - 960 / 2);

		// ������Ʈ �ʱ�ȭ

		btnLogIn = new JButton("ĳġ !");
		btnSignup = new JButton("ȸ������");
		btnExit = new JButton("������ �����մϴ�");

		txtLogIn = new JLabel("���̵�");
		txtPw = new JLabel("��й�ȣ");

		inputLogIn = new JTextField(20);
		inputPw = new JPasswordField(20);

		// �̹���
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

		// �̹���

		// ������Ʈ add
		add(btnLogIn);
		add(btnSignup);
		add(btnExit);

		add(txtLogIn);
		add(txtPw);

		add(inputLogIn);
		add(inputPw);
		// window
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(widthX, heightY, 1280, 960);
		setVisible(true);
	}

	// main --------------------------------------------------
	public static void main(String[] args) {
		new GameClient();
	}// test main End-------------------------------------

	/////////////////////////
	/////////////////////

	// Action Event ---------------------------------------
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();

		if (obj == btnLogIn) {
			String userId = inputLogIn.getText();
			char[] pwd = inputPw.getPassword();
			String password = new String(pwd);

			CatchMindDAO dao = new CatchMindDAO();

			boolean isOk = dao.isExists(userId, password);
			if (isOk) {
				JOptionPane.showConfirmDialog(this, "�α��� ����", "check", JOptionPane.PLAIN_MESSAGE);

				setVisible(false); // �α���â off

				// ���⼭ ����� �Ͼ����.
				// ��� ������ �� Ŭ���̾�Ʈ�� ������ �����ϴ� ��
				// �� �κ��� �ϴ� �� �����ھ� �ۼ��� �� Ŭ������ �и��ؼ� �̻ڰ� �����ϴ��� ��

				String ip = "192.168.0.49";
//				String ip = "192.168.0.22";
//				String ip = "192.168.35.123";
				int port = 5000;
				ObjectOutputStream oos = null;

				try {
					server = new Socket(ip, port); // �̷��鼭������ Ȯ���ؼ� ����
					// ������� �г��� ������ �������� ����
					// ������ String ���� �ϳ�(user nickname�� �����ϸ� �� )
					// �ٵ� String���� �޴� �������� ä�ÿ� ���� �����̹Ƿ� �ٸ� ��ü�� ��������.
					String nickname;
					String monsterType;
					nickname = dao.selectOneNickname(userId);
					monsterType = dao.selectOneMonsterType(userId);

					System.out.println("nickname �޾ƿͼ� �̰� ��Ŷ�� ���� ���� : " + nickname);
					System.out.println("monsterType �޾ƿͼ� �̰� ��Ŷ�� ���� ���� : " + monsterType);
					oos = new ObjectOutputStream(new BufferedOutputStream(server.getOutputStream()));

					UserInitializePacket uip = new UserInitializePacket(nickname, monsterType);

					if (uip instanceof UserInitializePacket) {
						oos.writeObject(uip);
						oos.flush();
					}

//					System.out.println("uip ���ϴ�  unp hash:" + uip);
//					os.close();
//					bos.close();
//					oos.close();

//					System.out.println("unp ���� ��~");
//					System.out.println("�������� �۽��ϴ� ������ �б� ������~");
					////////////////////////////////
					// �ٽ� �������� �����Ͽ� �۽��� ���� ���� �޴´�.

				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// ���� ����â���� ��ȯ. �̰� �������� �޾Ƽ� mainGUIȭ�鵵 �����ؾ� �� �� ������?
				ugGui = new UserGameGUI(server, oos);
				vGame(); // �������� ���� ������ ��� ����
//				ClientMainThread cmt = new ClientMainThread(server); // ��� ������ ����
//				cmt.start();
			} else {
				JOptionPane.showConfirmDialog(this, "���̵�, ��й�ȣ�� �ٸ��ϴ�", "check", JOptionPane.PLAIN_MESSAGE);
			}
		} else if (obj == btnSignup) { // ȸ������ ��ư
			new SignUpGUI();

		} else
			System.exit(0);
	}// Action Event End-------------------------------------

	private void vGame() { // ���Ӱ��� ��ź�
		Thread th = new Thread(this);
		th.start();
	}
//					System.out.println("ois�� ���� ������ ����");
//					System.out.println("����������:" + obj);

	// ���Ⱑ ��� ���۵Ǵºκ���
	// ���ϰ�ü ���� / ���ź� / �߽ź� / �ݺ��ؼ� ���� / �� �� �����
	// �������� ���� ��ǥ�� ����.
	@Override
	public void run() { // �� �κ��� ������ ����Ǵ� ���� ����(�˻�)�ϰ� �ִ� ��������.
		while (true) {  // (�α����� ���� �� ������ ����) ���� ���۽� Ŭ���̾�Ʈ�� ����� ������
			// ��ǥ ����
			Object obj;
			ObjectInputStream ois = null;
			try {
				ois = new ObjectInputStream(new BufferedInputStream(server.getInputStream()));
				if (!ois.equals(null)) {	// Ŭ���̾�Ʈ�� ������ inputStream�� �޾Ƽ� �о���� ������Ʈ�� �Դ�
					obj = ois.readObject();
					if (obj instanceof BoxedStrokePoint) {
						DrawMirrorThread mirrorTh = new DrawMirrorThread(ugGui.drawCanvas, ((BoxedStrokePoint) obj).getPointX(), ((BoxedStrokePoint) obj).getPointY());
						mirrorTh.start();	// �̷��� ������ ��� �����ؾ���.
					} else if(obj instanceof UserInitializePacket) {	// �ʱ����� ���ſ�
						System.out.println("�޾Ҵ�!");
						
					} else if(obj instanceof ChatPacket) {
						
					}
					// �� ��ǥ������ �ٽ� ������ ȭ���� �����Ѵ�.

				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}



//						System.out.println("draw mirror, arr col size :"+xx.size());
//						for (int i = 0; i < xx.size(); i++) {
//						}
// �ش� ������ �ٽ� ������ Ŭ������ �ۼ���
// �ʹ� �������� �����̾���
//							System.out.print(i+"|");
//							System.out.print("*"+x.get(i)+"*");
//							ugGui.drawCanvas.x = x.get(i);
//							ugGui.drawCanvas.y = y.get(i);
//							ugGui.drawCanvas.repaint();
//					System.out.println("--- Ŭ���̾�Ʈ�� �����κ��� ������ ��ǥ ---");
//					for (int i = 0; i < xx.size(); i++) {
//						System.out.printf("[user] [x:%3d], [y:%3d]\n", xx.get(i), yy.get(i));
//					}