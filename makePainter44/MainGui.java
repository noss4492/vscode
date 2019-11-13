package makePainter44;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainGui extends JFrame implements ActionListener, KeyListener {
	JButton exit, Lpanel, Rpanel, clean, Aclean, black, blue, red, green;
	JTextField time, word;
	JLabel[] character = new JLabel[8];
	JTextArea chat, draw;
	JPanel Cpanel, Dpanel;
	JLabel top;

	JButton btnSend;
	JTextField inputTxt;
	
	JScrollPane chatScroll;
	Image imgchar;

	MainGui() {
		super("캐치 마인드 !");

		// 해상도 툴킷
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension dmen = tool.getScreenSize();
		double scr_Width = dmen.getWidth();
		double scr_Height = dmen.getHeight();
		int widthX = (int) (scr_Width / 2 - 1280 / 2);
		int heightY = (int) (scr_Height / 2 - 960 / 2);
		
		//이미지
		imgchar = tool.createImage("src/images/char1.gif");
		

		// 컴포넌트 초기화
		Dpanel = new JPanel();
		Cpanel = new JPanel();

		exit = new JButton("나가기");
		for (int i = 0; i < 8; i++) {
			character[i] = new JLabel(new ImageIcon(imgchar));
		}

		black = new JButton("black");
		blue = new JButton("blue");
		red = new JButton("red");
		green = new JButton("grean");
		Lpanel = new JButton("왼쪽");
		Rpanel = new JButton("오른쪽");
		top = new JLabel(" 문제");
		chat = new JTextArea();
		draw = new JTextArea("그림판");
		clean = new JButton("지우기");
		Aclean = new JButton("전체지우기");
		time = new JTextField("time");
		word = new JTextField("캐치마인드");

		btnSend = new JButton("전송");
		inputTxt = new JTextField();
		chatScroll = new JScrollPane(chat,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
				);

		// Color
		black.setBackground(Color.black);
		blue.setBackground(Color.blue);
		red.setBackground(Color.red);
		green.setBackground(Color.green);
		top.setOpaque(true);
		top.setBackground(Color.orange);

		// Font
		Font f = new Font("휴먼엑스포", Font.BOLD, 20);
		Font h = new Font("휴먼엑스포", Font.BOLD, 14);
		word.setFont(f);
		top.setFont(h);

		// 컴포넌트 포지션
		exit.setBounds(1140, 15, 80, 40);
		time.setBounds(180, 15, 130, 40);
		top.setBounds(840, 15, 40, 40);
		word.setBounds(880, 15, 180, 40);
		black.setBounds(180, 600, 70, 40);
		blue.setBounds(260, 600, 70, 40);
		red.setBounds(340, 600, 70, 40);
		green.setBounds(420, 600, 70, 40);
		clean.setBounds(820, 600, 120, 40);
		Aclean.setBounds(960, 600, 120, 40);

		draw.setSize(900, 500);
		Dpanel.setBounds(180, 90, 900, 500);
		chat.setSize(900, 200);
		chatScroll.setSize(900, 200);
		inputTxt.setBounds(180,860,810,40);
		btnSend.setBounds(1000,860,80,40);
		Cpanel.setBounds(180, 650, 900, 200);

//		inputTxt.setBounds(r);
		int x1 = 20;
		int y1 = 90;
		int x2 = 1100;
		int y2 = 90;
		for (int i = 0; i < 8; i++) {

			if (i < 4) {
				character[i].setBounds(x1, y1, 140, 160);
				y1 += 180;
			} else {
				character[i].setBounds(x2, y2, 140, 160);
				y2 += 180;
			}

		}

		// Event add
		exit.addActionListener(this);
		inputTxt.addKeyListener(this);

		// Layout 초기화
		setLayout(null);
		Cpanel.setLayout(null);
		Dpanel.setLayout(null);

		Cpanel.add(chatScroll);
		Dpanel.add(draw);
		add(inputTxt);
		add(btnSend);

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

		add(btnSend);
		add(inputTxt);
		for (int i = 0; i < 8; i++) {
			add(character[i]);
		}

		// window
		chat.setEditable(false);
		inputTxt.requestFocusInWindow();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(widthX, heightY, 1280, 960);
		setVisible(true);
	}

	// 페인트 -----------------
	@Override
	public void paint(Graphics g) {
		super.paint(g);

		g.drawLine(30, 100, 1355, 100);

	}// 페인트 end -------------------

	// main ------------------
	public static void main(String[] args) {
		new MainGui();
	}// main end -------------------

	// Action Event -----------------------
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();
		if (obj == exit) {
			setVisible(false);
			new LoginGui();
		}

	}// Action Event end -----------------------------

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_ENTER) {
			String msg = inputTxt.getText()+"\n";
			chat.append(msg);
			inputTxt.setText("");
		}
	
	}

}