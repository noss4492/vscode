package makePainter2__Backup1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

class DrawCanvas extends Canvas implements Serializable{ // Serialized Form
	int x, y; // x, y값만 서버에 전달해서 사용하는 방법도 괜찮은듯.

	Graphics g;
	
	// Graphics 인자를 외부에서 받을 방법이 없으니까 내부의 메서드를 이용한다.
	// repaint에 의해 호출됨.
	// repaint가 update를 호출할 때 이 캔버스를 paint함
	public void update(Graphics g) {
		myPaint(g);
	}

	// 점의 연속으로 표현함. 이를 선으로 잇는 알고리즘은 추후에
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