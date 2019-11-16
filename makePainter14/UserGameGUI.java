package makePainter14;

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

public class UserGameGUI extends JFrame implements ActionListener, KeyListener, MouseMotionListener, MouseListener {
	JButton exit, Lpanel, Rpanel, clean, Aclean, black, blue, red, green;
	JTextField time, word;
	JLabel[] character = new JLabel[8];
	JTextArea chat;
	JPanel Cpanel, Dpanel;
	JLabel top;
	JButton btnSend;
	JTextField inputTxt;
	UserInfoPacket userinfo;
	JScrollPane chatScroll;
	Image imgchar;

	DrawCanvas drawCanvas;
	Socket server;
	ArrayList<Integer> strokePointArrX, strokePointArrY;
	ObjectOutputStream oos;

	UserGameGUI(Socket server, ObjectOutputStream oos) {
		super("ĳġ ���ε� !");
		strokePointArrX = new ArrayList<Integer>();
		strokePointArrY = new ArrayList<Integer>();
		setResizable(false);
		drawCanvas = new DrawCanvas();
		this.server = server;
		this.oos = oos;

		// �ػ� ��Ŷ
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension dmen = tool.getScreenSize();
		double scr_Width = dmen.getWidth();
		double scr_Height = dmen.getHeight();
		int widthX = (int) (scr_Width / 2 - 1280 / 2);
		int heightY = (int) (scr_Height / 2 - 960 / 2);

		// �̹���
		imgchar = tool.createImage("src/images/char1.gif");

		// ������Ʈ �ʱ�ȭ
		Dpanel = new JPanel();
		Cpanel = new JPanel();

		exit = new JButton("������");
		for (int i = 0; i < 8; i++) {
			character[i] = new JLabel(new ImageIcon(imgchar));
		}

		black = new JButton("black");
		blue = new JButton("blue");
		red = new JButton("red");
		green = new JButton("grean");
		Lpanel = new JButton("����");
		Rpanel = new JButton("������");
		top = new JLabel(" ����");
		chat = new JTextArea();
//		draw = new JTextArea("�׸���");	// �׸��� canvas�� ��ü��
		clean = new JButton("�����");
		Aclean = new JButton("��ü�����");
		time = new JTextField("time");
		word = new JTextField("ĳġ���ε�");
		drawCanvas = new DrawCanvas();

		btnSend = new JButton("����");
		inputTxt = new JTextField();
		chatScroll = new JScrollPane(chat, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		// Color
		black.setBackground(Color.black);
		blue.setBackground(Color.blue);
		red.setBackground(Color.red);
		green.setBackground(Color.green);
		top.setOpaque(true);
		top.setBackground(Color.orange);
		drawCanvas.setBackground(Color.white);

		// Font
		Font f = new Font("�޸տ�����", Font.BOLD, 20);
		Font h = new Font("�޸տ�����", Font.BOLD, 14);
		word.setFont(f);
		top.setFont(h);

		// ������Ʈ ������
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

		drawCanvas.setSize(900, 500);
		Dpanel.setBounds(180, 90, 900, 500);
		chat.setSize(900, 200);
		chatScroll.setSize(900, 200);
		inputTxt.setBounds(180, 860, 810, 40);
		btnSend.setBounds(1000, 860, 80, 40);
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

		drawCanvas.addMouseMotionListener(this); // mouse dragged�� ��ġ ������ ����
		drawCanvas.addMouseListener(this);

		// Layout �ʱ�ȭ
		setLayout(null);
		Cpanel.setLayout(null);
		Dpanel.setLayout(null);

		Cpanel.add(chatScroll);
		Dpanel.add(drawCanvas);
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

	// ����Ʈ -----------------
	@Override
	public void paint(Graphics g) {
		super.paint(g);

		g.drawLine(30, 100, 1355, 100);

	}// ����Ʈ end -------------------

	// main ------------------

	// Action Event -----------------------
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();
		if (obj == exit) {
			setVisible(false);
			new GameClient();
		}
	}// Action Event end -----------------------------

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		drawCanvas.x = e.getX();
		drawCanvas.y = e.getY();
		strokePointArrX.add(e.getX());
		strokePointArrY.add(e.getY());
		System.out.print("[Clicked][X,Y]=[" + e.getX() + "," + e.getY() + "]");
//		System.out.println("x�߰��� "+strokePointArrX);
//		System.out.println("y�߰��� "+strokePointArrY);
		drawCanvas.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("try streamout. [data] from UserGameGUI to SERVER");
//		System.out.println("���� ���(����) ip:"+server.getInetAddress().getHostAddress()+"|��Ʈ:"+server.getPort());

//		System.out.println("---------------------");
//		for(int i = 0; i<strokePointArrX.size(); i++)
//			System.out.println(strokePointArrX.get(i));
//		System.out.println("---------------------");

//		BufferedOutputStream bos;
//		ObjectOutputStream oos;
//		OutputStream os;
//			os = server.getOutputStream();
//			bos = new BufferedOutputStream(os);
		/////////////////////// ������/////////////
//		try {
//			oos = new ObjectOutputStream(new BufferedOutputStream(server.getOutputStream()));
//			BoxedStrokePoint pp = new BoxedStrokePoint(strokePointArrX, strokePointArrY);
//			oos.writeObject(pp);
//			oos.flush();
//			System.out.println("BoxedStrokePoint pp : "+pp);
//			strokePointArrX.clear();
//			strokePointArrY.clear();
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
		/////////////////////// ������/////////////
	}

	@Override
	public void mouseDragged(MouseEvent e) { // ���콺 �巡�׽� ��ǥ ������ ����
		drawCanvas.x = e.getX();
		drawCanvas.y = e.getY();
		strokePointArrX.add(e.getX());
		strokePointArrY.add(e.getY());
		System.out.print("[Dragged][X,Y]=[" + e.getX() + "," + e.getY() + "]");
//		System.out.println("x�߰��� "+strokePointArrX);
//		System.out.println("y�߰��� "+strokePointArrY);
		drawCanvas.repaint();
		try {
			oos = new ObjectOutputStream(new BufferedOutputStream(server.getOutputStream()));
			BoxedStrokePoint pp = new BoxedStrokePoint(strokePointArrX, strokePointArrY);
			oos.writeObject(pp);
			oos.flush();
			System.out.println("BoxedStrokePoint pp : " + pp);
			strokePointArrX.clear();
			strokePointArrY.clear();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}

}