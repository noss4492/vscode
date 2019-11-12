package myPlayGround;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JPanel;

// 아마 한 패널에 채팅창과 이 페인터를 붙여서 쓴다고 생각해보면 얘도 쓰레드로 구성되어야 할 것이다.
// 근데 일단 패널을 주고 받는 기능을 구현한다면
// 이 패널을 주고 받는 애를 쓰레드로 만들면 될 것이다.

public class __1_SavePainter extends Frame implements MouseMotionListener, 
															MouseListener{	// 아마 러너블 ㄱ
	DrawCanvas drawCanvas; // 내부 중첩 클래스로 할 필요는 없지만
	JPanel jp1;
	Socket server;
	String ip = "192.168.0.49";
	int port = 5000;

	public __1_SavePainter() {
		jp1 = new JPanel();
		setLayout(null);

		drawCanvas = new DrawCanvas();
//		jp1.setLayout(null);
//		jp1.setBounds(0, 0, 400, 400);
//		jp1.add(drawCanvas);

		drawCanvas.setBounds(0, 0, 400, 400);
		drawCanvas.setBackground(Color.GRAY); // 일단 배경색 이걸로 해둠(구분을 위해)
		add(drawCanvas); // 그림판 캔버스 생성함
		
//		jp1.setLocation(500,500);

		drawCanvas.addMouseMotionListener(this); // mouse dragged시 위치 감지를 위해
		drawCanvas.addMouseListener(this);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		drawCanvas.x = e.getX();
		drawCanvas.y = e.getY();
		drawCanvas.repaint();
		// 가속도로 예측점 찍는 기능...추가? (그냥 가속도로 하면 내가 원하지 않는 부분에 찍힐 수 있음.)
		// 이전 단계의 가속도로 이전 선이 연속되지 않았는지를 판별하는 알고리즘이 필요함
		// 가속도가 너무 크면 선이 연속되지 않았다고 보고 이전에 움직인 지점들을 연결해주는 방법이 필요함.
		// 크기 100개정도 되는 큐에 가속도를 구하는 방식으로 만들어야할 듯. 시간 많이 걸릴 듯 하니 나중에 함
	}

	class DrawCanvas extends Canvas { // Serialized Form
		int x, y; // x, y값만 서버에 전달해서 사용하는 방법도 괜찮은듯.

		// Graphics 인자를 외부에서 받을 방법이 없으니까 내부의 메서드를 이용한다.
		// repaint에 의해 호출됨.
		// repaint가 update를 호출할 때 이 캔버스를 paint함
		public void update(Graphics g) {
			myPaint(g);
		}

		// 점의 연속으로 표현함. 이를 선으로 잇는 알고리즘은 추후에
		public void myPaint(Graphics g) {
			changeColorBK(g);
			g.fillOval(x - 5, y - 5, 10, 10);
		}

		public void changeColorR(Graphics g) {
			g.setColor(Color.red);
		}

		public void changeColorG(Graphics g) {
			g.setColor(Color.green);
		}

		public void changeColorB(Graphics g) {
			g.setColor(Color.blue);
		}

		public void changeColorY(Graphics g) {
			g.setColor(Color.yellow);
		}

		public void changeColorBK(Graphics g) {
			g.setColor(Color.black);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// 여기는 드래그시 체크 안되는 상태임.
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		drawCanvas.x = e.getX();
		drawCanvas.y = e.getY();
		drawCanvas.repaint();
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
		System.out.println("이때 전송해!!");
//		try {
//			server = new Socket(ip, port);	// 퀴즈 내는 사람 -> 서버 ==> 유저1,2,3
//		} catch (UnknownHostException e1) {
//			e1.printStackTrace();
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}								
	}
}
