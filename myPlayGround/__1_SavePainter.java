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

// �Ƹ� �� �гο� ä��â�� �� �����͸� �ٿ��� ���ٰ� �����غ��� �굵 ������� �����Ǿ�� �� ���̴�.
// �ٵ� �ϴ� �г��� �ְ� �޴� ����� �����Ѵٸ�
// �� �г��� �ְ� �޴� �ָ� ������� ����� �� ���̴�.

public class __1_SavePainter extends Frame implements MouseMotionListener, 
															MouseListener{	// �Ƹ� ���ʺ� ��
	DrawCanvas drawCanvas; // ���� ��ø Ŭ������ �� �ʿ�� ������
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
		drawCanvas.setBackground(Color.GRAY); // �ϴ� ���� �̰ɷ� �ص�(������ ����)
		add(drawCanvas); // �׸��� ĵ���� ������
		
//		jp1.setLocation(500,500);

		drawCanvas.addMouseMotionListener(this); // mouse dragged�� ��ġ ������ ����
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
	}
}
