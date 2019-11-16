package makePainter13;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

class DrawCanvas extends Canvas { // Serialized Form X
	int x, y; // x, y���� ������ �����ؼ� ����ϴ� ����� ��������.

	Graphics g;
	Image dbImage;
	Graphics dbg;

	///
//	Toolkit tk = Toolkit.getDefaultToolkit();
//	Image img_buffer = null;
//	Graphics buffer = null;
	///

	// Graphics ���ڸ� �ܺο��� ���� ����� �����ϱ� ������ �޼��带 �̿��Ѵ�.
	// repaint�� ���� ȣ���.
	// repaint�� update�� ȣ���� �� �� ĵ������ paint��
	public void update(Graphics g) {
//		myPaint(g);

		// initialize buffer
		if (dbImage == null) {
			dbImage = createImage(this.getSize().width, this.getSize().height);
			dbg = dbImage.getGraphics();
		}
		// clear screen in background ���߿� ��ũ�� Ŭ����� ���� ������.
//		dbg.setColor(getBackground());
//		dbg.fillRect(0, 0, this.getSize().width, this.getSize().height);

		// draw elements in background
		dbg.setColor(getForeground());
		myPaint(dbg); // ���⼭ update -> myPaint ȣ���

		// draw image on the screen
		g.drawImage(dbImage, 0, 0, this);
	}

	// ���� �������� ǥ����. �̸� ������ �մ� �˰����� ���Ŀ�, ������ ���ӵ� �ʿ��ҵ�
	public void myPaint(Graphics g) {
		g.fillOval( x - 5 , y - 5, 10 , 10 );
	}
//		img_buffer = createImage(900, 500);
//		buffer = img_buffer.getGraphics();
//		buffer.fillOval( x - 5 , y - 5, 10 , 10 );
//		g.fillOval(img_buffer, 0, 0, this);
//		changeColorG(g);
//		g.fillOval(x - 5, y - 5, 10, 10);

//	public void mirrorPaint(ArrayList<Integer> x, ArrayList<Integer> y) { // x, y ����Ʈ �޾Ƽ� �׸���
//		System.out.println("mirrorPaint : ȣ���");
//		System.out.println("size x :" + x.size() + "size y :" + y.size());
//		for (int i = 0; i < x.size(); i++) {
//			System.out.println("�׸����� x : " + x.get(i) + "|�׸����� y : " + y.get(i));
//		}
//		for (int i = 0; i < x.size(); i++) {
//			g.fillOval(x.get(i) - 5, y.get(i) - 5, 10, 10);
//		}
//	}

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