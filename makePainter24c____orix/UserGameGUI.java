package makePainter24c____orix;

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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

public class UserGameGUI extends JFrame implements ActionListener, KeyListener, MouseMotionListener, MouseListener {
	JButton exit, clean, Aclean, black, blue, red, green, yellow, gradation;
	JTextField time, word;
	JLabel[] jlCharacter = new JLabel[8];
	JLabel[] jlNick = new JLabel[8];
	JTextArea jtaChat;
	JPanel dPanel;
	JLabel questions;

	JTextField inputTxt;

	JScrollPane chatScroll;
	ImageIcon char1Img, char2Img, char3Img, char4Img, exitImg;
	JPanel background;
	JLabel mainImg, txtTranGround, chatTranGround;

//	JButton exit, Lpanel, Rpanel, clean, Aclean, black, blue, red, green;
//	// Lpanel? Rpanel? 너넨 뭐고
//	JTextField time, word;
//	JLabel[] jlCharacter = new JLabel[8];
//	
//	JTextArea jtaChat;
//	//draw 어딨음
//	
//	JPanel Cpanel, Dpanel;
//	// Cpanel 왜 있음
//	// background 없음
//	
//	JLabel top;
//	// top은 왜 있음
//	JButton btnSend;
//	JTextField inputTxt;
//	JScrollPane chatScroll;
//	Image imgchar;

	DrawCanvas drawCanvas;
	UserInfoPacket userinfo;
	Socket server;
	ObjectOutputStream oos;

	ArrayList<Integer> strokePointArrX, strokePointArrY, arrColorF;
	String msg;
	String nickname;

	UserGameGUI(Socket server, ObjectOutputStream oos, String nickname) {
		super("캐치 마인드 !");
		strokePointArrX = new ArrayList<Integer>();
		strokePointArrY = new ArrayList<Integer>();
		arrColorF = new ArrayList<Integer>();
		setResizable(false);
		drawCanvas = new DrawCanvas();
		this.server = server;
		this.oos = oos;
		this.nickname = nickname;

		// 해상도 툴킷
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension dmen = tool.getScreenSize();
		double scr_Width = dmen.getWidth();
		double scr_Height = dmen.getHeight();
		int widthX = (int) (scr_Width / 2 - 1280 / 2);
		int heightY = (int) (scr_Height / 2 - 960 / 2);

		// 이미지
		char1Img = new ImageIcon("src/images/char1.gif");
		char2Img = new ImageIcon("src/images/char2.gif");
		char3Img = new ImageIcon("src/images/char3.gif");
		char4Img = new ImageIcon("src/images/char4.gif");
		mainImg = new JLabel(new ImageIcon("src/images/mainBack.jpg"));
		
		// 컴포넌트 초기화
		for (int i = 4; i < 8; i++) {
			jlCharacter[i] = new JLabel();
		}
		for(int i=0; i<8; i++) {
			jlNick[i] = new JLabel();
		}
		jlCharacter[0] = new JLabel();
		jlCharacter[1] = new JLabel();
		jlCharacter[2] = new JLabel();
		jlCharacter[3] = new JLabel();
		background = new JPanel();
		dPanel = new JPanel();

		exit = new JButton(new ImageIcon("src/images/exit.PNG"));

		black = new JButton();
		blue = new JButton();
		red = new JButton();
		green = new JButton();
		yellow = new JButton();
		gradation = new JButton("G");
		questions = new JLabel(new ImageIcon("src/images/Questions.png"));
		jtaChat = new JTextArea();
		drawCanvas = new DrawCanvas();
		clean = new JButton(new ImageIcon("src/images/Eraser.png"));
		Aclean = new JButton(new ImageIcon("src/images/Aclean.png"));
		time = new JTextField("time");
		word = new JTextField("");

		inputTxt = new JTextField();
		chatScroll = new JScrollPane(jtaChat, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		// Color
		Color purple = new Color(149,54,255);
		black.setBackground(Color.black);
		blue.setBackground(Color.blue);
		red.setBackground(Color.red);
		green.setBackground(Color.green);
		yellow.setBackground(Color.yellow);
		gradation.setBackground(purple);
		questions.setOpaque(true);
		questions.setBackground(Color.orange);

		// -- 투명도
		Color tranX = new Color(0, 0, 0, 0);
		Color tran = new Color(0, 0, 0, 80);
		Color btnFontColor = new Color(3, 61, 88);
		inputTxt.setOpaque(false);
		jtaChat.setOpaque(false);
		chatScroll.getViewport().setOpaque(false);
		chatScroll.setOpaque(false);

		chatTranGround = new JLabel();
		chatTranGround.setOpaque(true);
		chatTranGround.setBackground(tran);
		chatTranGround.setBounds(180, 650, 900, 200);
		add(chatTranGround);
		txtTranGround = new JLabel();
		txtTranGround.setOpaque(true);
		txtTranGround.setBackground(tran);
		txtTranGround.setBounds(180, 860, 900, 40);
		add(txtTranGround);

		// Font
		Font f = new Font("휴먼엑스포", Font.BOLD, 20);
		Font h = new Font("휴먼엑스포", Font.BOLD, 14);
		Font c = new Font("바탕체", Font.PLAIN, 16);
		word.setFont(f);
		questions.setFont(h);
		
		for(int i = 0 ; i < 8; i ++)
			jlNick[i].setFont(new Font("하늘바탕체", Font.CENTER_BASELINE, 17));
		jtaChat.setFont(c);
		inputTxt.setFont(c);
		// 컴포넌트 포지션
		black.setBounds(180, 600, 70, 40);
		blue.setBounds(260, 600, 70, 40);
		red.setBounds(340, 600, 70, 40);
		green.setBounds(420, 600, 70, 40);
		yellow.setBounds(500,600,70,40);
		gradation.setBounds(580, 600, 70, 40);
		
		exit.setBounds(1140, 15, 80, 30);
		time.setBounds(180, 15, 130, 40);
		questions.setBounds(830, 15, 50, 40);
		word.setBounds(880, 15, 180, 40);
		clean.setBounds(900, 600, 50, 40);
		Aclean.setBounds(960, 600, 120, 40);

		drawCanvas.setSize(900, 500);
		dPanel.setBounds(180, 90, 900, 500);
		jtaChat.setSize(900, 200);
		chatScroll.setBounds(180, 650, 900, 200);
		inputTxt.setBounds(180, 860, 900, 40);
		background.setSize(1280, 960);
//				inputTxt.setBounds(r);
		int x1 = 20;
		int y1 = 90;
		int x2 = 1100;
		int y2 = 90;

		for (int i = 0; i < 8; i++) {
			if (i < 4) {
				jlCharacter[i].setBounds(x1, y1, 140, 160);
				jlNick[i].setBounds(x1, y1+162, 140, 30);
				y1 += 200;
			} else {
				jlCharacter[i].setBounds(x2, y2, 140, 160);
				jlNick[i].setBounds(x2, y2+162, 140, 30);
				y2 += 200;
			}
		}

		// Event add
		exit.addActionListener(this);
		inputTxt.addKeyListener(this);

		drawCanvas.addMouseMotionListener(this); // mouse dragged시 위치 감지를 위해
		drawCanvas.addMouseListener(this);

		yellow.addActionListener(this);
		gradation.addActionListener(this);
		black.addActionListener(this);
		blue.addActionListener(this);
		red.addActionListener(this);
		green.addActionListener(this);
		clean.addActionListener(this);
		Aclean.addActionListener(this);

		// Layout 초기화
		setLayout(null);
		dPanel.setLayout(null);

		dPanel.add(drawCanvas);
		add(inputTxt);

		add(exit);
		add(black, Color.WHITE);
		add(red, Color.WHITE);
		add(green, Color.WHITE);
		add(blue, Color.WHITE);
		add(yellow);
		add(gradation);
		
		add(clean);
		add(Aclean);
		add(questions);
		add(word);
		add(time);

		add(chatScroll);
		add(dPanel);

		add(inputTxt);
		for (int i = 0; i < 8; i++) {
			add(jlCharacter[i]);
			add(jlNick[i]);
		}
		background.add(mainImg);
		add(background);

		// window
		jtaChat.setEditable(false);
		inputTxt.requestFocusInWindow();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(widthX, heightY, 1280, 960);
		setVisible(true);
		
		
	}

	public void sendChatMsg() {
		msg = inputTxt.getText();
//		System.out.println(msg+"이거 서버로 보내는 메세지임");
		try {
			oos = new ObjectOutputStream(new BufferedOutputStream(server.getOutputStream()));
			ChatPacket cp = new ChatPacket(nickname, msg);
			oos.writeObject(cp);
			oos.flush();
			inputTxt.setText("");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 페인트 -----------------
	@Override
	public void paint(Graphics g) {
		super.paint(g);

		g.drawLine(23, 100, 1247, 100);

	}// 페인트 end -------------------

	// main ------------------

	// ActionEvent start -----------------------------------------
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();
		if (obj == exit) {
			setVisible(false);
			new GameClient();
		} else if (obj == red) { // r 0 g 1 b 2 bk 3 eraser 4 y 5 s 6 allClear7
			drawCanvas.colorFlag = 0;
//			drawCanvas.repaint();
		} else if (obj == green) {	// 1 g
			drawCanvas.colorFlag = 1;
		} else if (obj == blue) {	// 2 b
			drawCanvas.colorFlag = 2;
		} else if (obj == black) {	// 3 bk
			drawCanvas.colorFlag = 3;
		} else if (obj == clean) {	// 4 eraser
			drawCanvas.colorFlag = 4;
		} else if (obj == yellow) { // 5 yellow
			drawCanvas.colorFlag = 5;
		} else if (obj == gradation) { // 6 special
			drawCanvas.colorFlag = 6;
		} else if (obj == Aclean) { // 이거 올 클리어 호출되면 통신패킷으로 보내야하네 (컬러플래그5면 전체삭제 호출로 바꾸자)
//			drawCanvas.colorFlag = 7;	// 생각해보니 담을 필요가 없는데요... 그냥 메세지 받으면 클라이언 트 화면 
			// -> 이거면 전체 유저한테 다시 송신해야함 
//			drawCanvas.colorFlag = 7;
			drawCanvas.callClearAll();
			drawCanvas.repaint();
			// 이때 보내야...
			try {
				oos = new ObjectOutputStream(new BufferedOutputStream(server.getOutputStream()));
				ProtocolPacket ptp = new ProtocolPacket(999);	// 999 -> clear screen
				oos.writeObject(ptp);
				oos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// yellow, white(지우개??) 추가점
	}

//		else if (obj == btnSend) {	// 있었는데요... 없어졌습니다 일부러 없애신건가 ' '?
//			sendChatMsg();
//		}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == 10) {
			sendChatMsg();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		drawCanvas.x = e.getX();
		drawCanvas.y = e.getY();
		strokePointArrX.add(e.getX());
		strokePointArrY.add(e.getY());
		arrColorF.add(drawCanvas.getColorFlag());
		drawCanvas.repaint();
		for(int i = 0 ; i < 3; i ++) {	// 야매이니 나중에 고치세요.
			StrokePointPacket pp = new StrokePointPacket(arrColorF, strokePointArrX, strokePointArrY);
			try {
				oos = new ObjectOutputStream(new BufferedOutputStream(server.getOutputStream()));
				oos.writeObject(pp);
				oos.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			}
			arrColorF.clear();
			strokePointArrX.clear();
			strokePointArrY.clear();
		}

	@Override
	public void mouseDragged(MouseEvent e) { // 마우스 드래그시 좌표에 점을 찍으면서, 그 좌표 정보를 누적, 서버로 보냄
		drawCanvas.x = e.getX();
		drawCanvas.y = e.getY();
		strokePointArrX.add(e.getX());
		strokePointArrY.add(e.getY());
		arrColorF.add(drawCanvas.getColorFlag());

		// 여기 추가됨 에러 나는 것 의심해볼 것
		drawCanvas.repaint();
		
		for(int i = 0 ; i < 33; i ++) {	// 야매이니 나중에 고치세요.
		StrokePointPacket pp = new StrokePointPacket(arrColorF, strokePointArrX, strokePointArrY);
		try {
			oos = new ObjectOutputStream(new BufferedOutputStream(server.getOutputStream()));
			oos.writeObject(pp);
			oos.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		}
		arrColorF.clear();
		strokePointArrX.clear();
		strokePointArrY.clear();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// 좌표는 보내는데 문제 없었음. 프로세스 자원이 모자르다면 여기에서까지 보내는 동작을 추가로 수행
	}
	// ActionEvent end --------------------------------------------
} // Class end

//try {
//Thread.sleep(1000);
//for(int i = 0 ; i < 200; i ++) {
//	Thread.sleep(10);
//	if(i < 100)
//		setBounds(widthX, heightY, 1280-i*100, 960-i*100);
//	else
//		setBounds(widthX, heightY, 1280-99*100+(i-99)*100, 960-99*100+(i-99)*100);
//}
//} catch (InterruptedException e) {
//// TODO Auto-generated catch block
//e.printStackTrace();
//}
//System.out.print("[Dragged][X,Y]=[" + e.getX() + "," + e.getY() + "]");
//System.out.println("x추가중 "+strokePointArrX);
//System.out.println("y추가중 "+strokePointArrY);
//			System.out.println("BoxedStrokePoint pp : " + pp);
//public void objToServer(Object obj){
//	try {
//		oos = new ObjectOutputStream(new BufferedOutputStream(server.getOutputStream()));
//		oos.writeObject(obj);
//		oos.flush();
//	} catch (IOException e) {
//		e.printStackTrace();
//	}
//}

//System.out.println("try streamout. [data] from UserGameGUI to SERVER");
//System.out.println("연결 대상(서버) ip:"+server.getInetAddress().getHostAddress()+"|포트:"+server.getPort());

//System.out.println("---------------------");
//for(int i = 0; i<strokePointArrX.size(); i++)
//	System.out.println(strokePointArrX.get(i));
//System.out.println("---------------------");

//BufferedOutputStream bos;
//ObjectOutputStream oos;
//OutputStream os;
//	os = server.getOutputStream();
//	bos = new BufferedOutputStream(os);
/////////////////////// 잠깐닫음/////////////
//try {
//	oos = new ObjectOutputStream(new BufferedOutputStream(server.getOutputStream()));
//	BoxedStrokePoint pp = new BoxedStrokePoint(strokePointArrX, strokePointArrY);
//	oos.writeObject(pp);
//	oos.flush();
//	System.out.println("BoxedStrokePoint pp : "+pp);
//	strokePointArrX.clear();
//	strokePointArrY.clear();
//} catch (IOException e1) {
//	e1.printStackTrace();
//}
/////////////////////// 잠깐닫음/////////////

//System.out.print("[Clicked][X,Y]=[" + e.getX() + "," + e.getY() + "]");
//System.out.println("x추가중 "+strokePointArrX);
//System.out.println("y추가중 "+strokePointArrY);