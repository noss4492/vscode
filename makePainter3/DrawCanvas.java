package makePainter3;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

class DrawCanvas extends Canvas { // Serialized Form X
	int x, y; // x, y���� ������ �����ؼ� ����ϴ� ����� ��������.

	Graphics g;
	
	// Graphics ���ڸ� �ܺο��� ���� ����� �����ϱ� ������ �޼��带 �̿��Ѵ�.
	// repaint�� ���� ȣ���.
	// repaint�� update�� ȣ���� �� �� ĵ������ paint��
	public void update(Graphics g) {
		myPaint(g);
	}

	// ���� �������� ǥ����. �̸� ������ �մ� �˰����� ���Ŀ�, ������ ���ӵ� �ʿ��ҵ�
	public void myPaint(Graphics g) {
		changeColorR(g);
		g.fillOval(x - 5, y - 5, 10, 10);
	}
	
	public void imitatePaint(int x, int y) {	// x, y ����Ʈ �޾Ƽ� �׸���
		g.fillOval(x-5, y-5, 10, 10);		
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