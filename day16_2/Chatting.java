package day16_2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//enter 10+13 // line feed, carriage return

// �г��� �����̳� '3'
//borderlayout(������ư �⺻��) flowlayout(JPanel �⺻��)

public class Chatting extends JFrame implements ActionListener, KeyListener {
	int width = 600;
	int height = 600;
	JPanel jpCenter, jpSouth;
	JScrollPane jsp1;
	JTextArea jta1 = new JTextArea();
	JTextField jtf1 = new JTextField();
	JButton jbtn;
	String chatLog = "";
	StringBuffer chattingLog;
	String[] msg = { "���� �԰� �ٴϳ�", "������", "�׳� ���� ����", "���̽�", "�޷�", "�ұ���" };
	Random rnd = new Random();

	Chatting() {
		super("ä����");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Color myGreen = new Color(50, 200, 50);

		jpCenter = new JPanel();
		jpSouth = new JPanel();
		jta1 = new JTextArea();

		jsp1 = new JScrollPane(jta1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		jbtn = new JButton("����");
		jtf1 = new JTextField(30);

		jpSouth.add(jtf1);
		jpSouth.add(jbtn);

		// Ÿ��ĥ��
		jtf1.addKeyListener(this);
		// ��ư ������ ��
		jbtn.addActionListener(this);

		// ����ڰ� text Area�� �������� ���ϰ�
		Font f = new Font("MyFont", Font.PLAIN, 22);
		jta1.setFont(f);
		jta1.setEditable(false);

		jpCenter.setBackground(myGreen);
		jpSouth.setBackground(Color.PINK);

		BorderLayout bl1 = new BorderLayout(); // ���̾ƿ� ����
		jpCenter.setLayout(bl1);
		jpCenter.add(jsp1);
		// �ѹ� �߰��غ��� ���� ����

		add(jpCenter, "Center");
		add(jpSouth, "South");

		setBounds(100, 100, width, height);
		setVisible(true);

		jtf1.requestFocusInWindow();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jta1.append("�ɽ��� : �ȳ� �ݰ���~~ \n");
	}

	public static void main(String[] args) {
		Chatting c = new Chatting();

	}

	@Override
	public void actionPerformed(ActionEvent e) {// append�� ���� �̷��� ���� ����
		Object obj = e.getSource();
		if (obj == jbtn) {
			String message = "�����1 : " + jtf1.getText() + "\n";
			jtf1.setText("");
			chatLog += message;
//			chattingLog = chattingLog.append(message);// ��Ʈ�����۷� �ϸ� �� ��������
			jta1.setText(chatLog);
		}
	}

//		char ch = e.getKeyChar();
//		System.out.println(ch + " : " + code);
	// ������ ���� ���� message->data
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_ENTER) {
			String message = "�����1 : " + jtf1.getText() + "\n";
			jta1.append(message + ""); // �� ����� �� ���� ������. �� ���ϰ�. ��������
			jtf1.setText("");

			// ��� ���� ���ְ� �ؿ� ��ٸ���
			int pos = rnd.nextInt(msg.length);

//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException ea) {
//				ea.printStackTrace();
//			}

			long delayTime = 1000;
			long saveTime = System.currentTimeMillis();
			long currTime = 0;
			while (currTime - saveTime < delayTime) {
				currTime = System.currentTimeMillis();
			}
			
			
			jta1.append(msg[pos] + "\n");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

//	public static JPanel drawPanel() {
//		JPanel Panel = new JPanel();
//		Image background = 
//				Toolkit.getDefaultToolkit().createImage("src/images/money_cat.jpeg");
//		Panel.drawImage(background,0,0,null);
//		return Panel;
//	}
}
