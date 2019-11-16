package makePainter13;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

class DrawCanvas extends Canvas { // Serialized Form X
	int x, y; // x, y값만 서버에 전달해서 사용하는 방법도 괜찮은듯.

	Graphics g;
	Image dbImage;
	Graphics dbg;

	///
//	Toolkit tk = Toolkit.getDefaultToolkit();
//	Image img_buffer = null;
//	Graphics buffer = null;
	///

	// Graphics 인자를 외부에서 받을 방법이 없으니까 내부의 메서드를 이용한다.
	// repaint에 의해 호출됨.
	// repaint가 update를 호출할 때 이 캔버스를 paint함
	public void update(Graphics g) {
//		myPaint(g);

		// initialize buffer
		if (dbImage == null) {
			dbImage = createImage(this.getSize().width, this.getSize().height);
			dbg = dbImage.getGraphics();
		}
		// clear screen in background 나중에 스크린 클리어로 쓰면 좋을듯.
//		dbg.setColor(getBackground());
//		dbg.fillRect(0, 0, this.getSize().width, this.getSize().height);

		// draw elements in background
		dbg.setColor(getForeground());
		myPaint(dbg); // 여기서 update -> myPaint 호출됨

		// draw image on the screen
		g.drawImage(dbImage, 0, 0, this);
	}

	// 점의 연속으로 표현함. 이를 선으로 잇는 알고리즘은 추후에, 이전의 가속도 필요할듯
	public void myPaint(Graphics g) {
		g.fillOval( x - 5 , y - 5, 10 , 10 );
	}
//		img_buffer = createImage(900, 500);
//		buffer = img_buffer.getGraphics();
//		buffer.fillOval( x - 5 , y - 5, 10 , 10 );
//		g.fillOval(img_buffer, 0, 0, this);
//		changeColorG(g);
//		g.fillOval(x - 5, y - 5, 10, 10);

//	public void mirrorPaint(ArrayList<Integer> x, ArrayList<Integer> y) { // x, y 리스트 받아서 그리기
//		System.out.println("mirrorPaint : 호출됨");
//		System.out.println("size x :" + x.size() + "size y :" + y.size());
//		for (int i = 0; i < x.size(); i++) {
//			System.out.println("그리는중 x : " + x.get(i) + "|그리는중 y : " + y.get(i));
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