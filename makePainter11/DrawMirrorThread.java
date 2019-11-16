package makePainter11;

import java.util.ArrayList;

public class DrawMirrorThread extends Thread {
	DrawCanvas dc;
	ArrayList<Integer> x;
	ArrayList<Integer> y;

	// ugGui.drawCanvas, x, y
	public DrawMirrorThread(DrawCanvas dc, ArrayList<Integer> x, ArrayList<Integer> y) {
		super();
		this.dc = dc;
		this.x = x;
		this.y = y;
	}

	@Override
	public void run() {
		if (this.x.size() != 0) {
			int i = 0;
			while (i < x.size()) {
				dc.x = x.get(i);
				dc.y = y.get(i);
				dc.repaint();
				i++;
			}
			System.out.println("mirror 그리기 종료");
		}
	}

	public DrawCanvas getDc() {
		return dc;
	}

	public void setDc(DrawCanvas dc) {
		this.dc = dc;
	}

	public ArrayList<Integer> getX() {
		return x;
	}

	public void setX(ArrayList<Integer> x) {
		this.x = x;
	}

	public ArrayList<Integer> getY() {
		return y;
	}

	public void setY(ArrayList<Integer> y) {
		this.y = y;
	}
}
