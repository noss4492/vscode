package makePainter44;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UI extends JFrame implements ActionListener {
	JButton exit, Lpanel, Rpanel, clean, Aclean,black,blue,red,green;
	JTextField time,word;
	JButton[] btn = new JButton[8];
	JTextArea chat, draw;
	JPanel Cpanel, Dpanel;
	JLabel top;	


	UI() {
//		String w = ("소방관","강사","컴퓨터");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Dpanel = new JPanel();
		Cpanel = new JPanel();

		exit = new JButton("나가기");
		for (int i = 0; i < 8; i++) {
			btn[i] = new JButton("" + i);
		}
		black = new JButton("black");
		blue = new JButton("blue");
		red = new JButton("red");
		green = new JButton("grean");
		Lpanel = new JButton("왼쪽");
		Rpanel = new JButton("오른쪽");
		top = new JLabel(" 문제");
		chat = new JTextArea("채팅창");
		draw = new JTextArea("그림판");
		clean = new JButton("지우기");
		Aclean = new JButton("전체지우기");
		time = new JTextField("time");
		word = new JTextField("캐치마인드");

		black.setBackground(Color.black);
		blue.setBackground(Color.blue);
		red.setBackground(Color.red);
		green.setBackground(Color.green);
		top.setOpaque(true);
		top.setBackground(Color.orange);

		exit.setBounds(1250, 15, 80, 40);
		time.setBounds(650, 15, 130, 40);
		top.setBounds(940, 15, 40, 40);
		word.setBounds(980, 15, 180, 40);
		draw.setBounds(0, 0, 900, 400);
		chat.setBounds(0, 0, 900, 200);
		Cpanel.setBounds(275, 90, 900, 400);
		Dpanel.setBounds(275, 540, 900, 200);
		black.setBounds(280, 495, 70, 40);
		blue.setBounds(360, 495, 70, 40);
		red.setBounds(440, 495, 70, 40);
		green.setBounds(520, 495, 70, 40);
		clean.setBounds(955, 495, 100, 40);
		Aclean.setBounds(1075, 495, 100, 40);
		
		Font f = new Font("휴먼엑스포",Font.BOLD,20);
		Font h = new Font("휴먼엑스포",Font.BOLD,14);
		word.setFont(f);
		top.setFont(h);

		int x = 100;
		int y = 90;
		int z = 1200;
		int y2 = 90;
		for (int i = 0; i < 8; i++) {

			if (i < 4) {
				btn[i].setBounds(x, y, 150, 150);
				y += 160;
			} else {
				btn[i].setBounds(z, y2, 150, 150);
				y2 += 160;
			}

		}

		exit.addActionListener(this);

		Cpanel.setLayout(null);
		Dpanel.setLayout(null);

		Cpanel.add(draw);
		Dpanel.add(chat);

		add(exit);
		add(Lpanel);
		add(Rpanel);
		add(black, Color.WHITE);
		add(red, Color.WHITE);
		add(green, Color.WHITE);
		add(blue, Color.WHITE);
		add(clean);
		add(Aclean);
		add(top);
		add(word);
		add(time);

		add(Cpanel);
		add(Dpanel);
		for (int i = 0; i < 8; i++) {
			add(btn[i]);
		}

		setBounds(50, 50, 1400, 800);
		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		g.drawLine(107, 100, 1355, 100);

	}

	public static void main(String[] args) {
		new UI();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// Object obj = new Object();
		System.exit(0);

	}

}
