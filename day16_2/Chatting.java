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

// 패널이 컨테이너 '3'
//borderlayout(이전버튼 기본값) flowlayout(JPanel 기본값)

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
	String[] msg = { "밥은 먹고 다니냐", "졸리냐", "그냥 집에 가냐", "나이스", "달려", "불금임" };
	Random rnd = new Random();

	Chatting() {
		super("채팅촹");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Color myGreen = new Color(50, 200, 50);

		jpCenter = new JPanel();
		jpSouth = new JPanel();
		jta1 = new JTextArea();

		jsp1 = new JScrollPane(jta1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		jbtn = new JButton("전송");
		jtf1 = new JTextField(30);

		jpSouth.add(jtf1);
		jpSouth.add(jbtn);

		// 타자칠때
		jtf1.addKeyListener(this);
		// 버튼 눌렀을 때
		jbtn.addActionListener(this);

		// 사용자가 text Area를 수정하지 못하게
		Font f = new Font("MyFont", Font.PLAIN, 22);
		jta1.setFont(f);
		jta1.setEditable(false);

		jpCenter.setBackground(myGreen);
		jpSouth.setBackground(Color.PINK);

		BorderLayout bl1 = new BorderLayout(); // 레이아웃 설정
		jpCenter.setLayout(bl1);
		jpCenter.add(jsp1);
		// 한번 추가해보는 다음 라인

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
		jta1.append("심심이 : 안녕 반가워~~ \n");
	}

	public static void main(String[] args) {
		Chatting c = new Chatting();

	}

	@Override
	public void actionPerformed(ActionEvent e) {// append로 쓰셈 이렇게 쓰지 말고
		Object obj = e.getSource();
		if (obj == jbtn) {
			String message = "사용자1 : " + jtf1.getText() + "\n";
			jtf1.setText("");
			chatLog += message;
//			chattingLog = chattingLog.append(message);// 스트링버퍼로 하면 더 귀찮아짐
			jta1.setText(chatLog);
		}
	}

//		char ch = e.getKeyChar();
//		System.out.println(ch + " : " + code);
	// 수업중 명명된 변수 message->data
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_ENTER) {
			String message = "사용자1 : " + jtf1.getText() + "\n";
			jta1.append(message + ""); // 이 기능이 훨 성능 좋을듯. 더 편하고. 보기좋고
			jtf1.setText("");

			// 출력 먼저 해주고 밑에 기다리기
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
