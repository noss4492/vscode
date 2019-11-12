package myPlayGround;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
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
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;

// �Ƹ� �� �гο� ä��â�� �� �����͸� �ٿ��� ���ٰ� �����غ��� �굵 ������� �����Ǿ�� �� ���̴�.
// �ٵ� �ϴ� �г��� �ְ� �޴� ����� �����Ѵٸ�
// �� �г��� �ְ� �޴� �ָ� ������� ����� �� ���̴�.

public class _1SavePainter extends Frame implements MouseMotionListener, 
															MouseListener, Runnable{
	DrawCanvas drawCanvas; // ���� ��ø Ŭ������ �� �ʿ�� ������
	JPanel mirrorPane;
	Socket server;
	String ip = "192.168.0.49";
	int port = 5000;
	JFrame frame = new JFrame("");
	Container c;

	public _1SavePainter() {
		setLayout(null);

		mirrorPane = new JPanel();
		drawCanvas = new DrawCanvas();
		
		mirrorPane.setLayout(null);
		mirrorPane.setBounds(0, 0, 500, 500);	// is 
		mirrorPane.add(drawCanvas);

		drawCanvas.setBounds(0, 0, 500, 500);
		drawCanvas.setBackground(Color.GRAY); // �ϴ� ���� �̰ɷ� �ص�(������ ����)
		add(drawCanvas); // �׸��� ĵ���� ������

		drawCanvas.addMouseMotionListener(this); // mouse dragged�� ��ġ ������ ����
		drawCanvas.addMouseListener(this);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setSize(500,500);
		setVisible(true);
	}
	
	public void createSendPan(DrawCanvas drawCanvas) {
		mirrorPane = new JPanel();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		drawCanvas.x = e.getX();
		drawCanvas.y = e.getY();
		drawCanvas.repaint();
		// ���ӵ��� ������ ��� ���...�߰�? (�׳� ���ӵ��� �ϸ� ���� ������ �ʴ� �κп� ���� �� ����.)
		// ���� �ܰ��� ���ӵ��� ���� ���� ���ӵ��� �ʾҴ����� �Ǻ��ϴ� �˰����� �ʿ���
		// ���ӵ��� �ʹ� ũ�� ���� ���ӵ��� �ʾҴٰ� ���� ������ ������ �������� �������ִ� ����� �ʿ���.
		// ũ�� 100������ �Ǵ� ť�� ���ӵ��� ���ϴ� ������� �������� ��. �ð� ���� �ɸ� �� �ϴ� ���߿� ��
	}

	class DrawCanvas extends Canvas { // Serialized Form
		int x, y; // x, y���� ������ �����ؼ� ����ϴ� ����� ��������.

		// Graphics ���ڸ� �ܺο��� ���� ����� �����ϱ� ������ �޼��带 �̿��Ѵ�.
		// repaint�� ���� ȣ���.
		// repaint�� update�� ȣ���� �� �� ĵ������ paint��
		public void update(Graphics g) {
			myPaint(g);
		}

		// ���� �������� ǥ����. �̸� ������ �մ� �˰����� ���Ŀ�
		public void myPaint(Graphics g) {
			changeColorR(g);
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
		// ����� �巡�׽� üũ �ȵǴ� ������.
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
		System.out.println("�̶� ������!!");
//		try {
//			server = new Socket(ip, port);	// ���� ���� ��� -> ���� ==> ����1,2,3
//		} catch (UnknownHostException e1) {
//			e1.printStackTrace();
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}						
//		jp1 = new JPanel();
		
		
//		Container conn = this.get
//		OutputStream os = solver.getOutputStream()
//		ObjectOutputStream oos = new ObjectOutputStream();
//		BufferedWriter bw = new BufferedWriter(oos);

		
		Socket solver;
		try {
			solver = new Socket(ip, port);
			BufferedOutputStream bos = new BufferedOutputStream(solver.getOutputStream());
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(this.getFrames());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public _1SavePainter clone() {
		_1SavePainter copy1 = null;
		try {
			copy1 = (_1SavePainter) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return copy1;
	}
	
	
	public static void main(String[] args) {
		_1SavePainter s1 = new _1SavePainter();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
