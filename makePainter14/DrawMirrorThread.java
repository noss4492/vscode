package makePainter14;

import java.util.ArrayList;

// ȭ�麹�����
// ���� �������� ���� ��ǥ�� �ٽ� ȭ�鿡 ����ִ� ����� ������
// ���� ����ð��� �� ������ ����Ǳ� ������ �ٸ� ��ɵ���� ���������� �����ؾ��ϹǷ� ������� ������
// (������ �гο� ��Ƽ� ������� �ۼ��� �ϰ� �;����� 
// �Ϸ簣 �����غ� ��� �г��� ������ ���(Ư�� ���� Ŭ���� ��ü ����ȭ)�� ��õ���� �ʰ� �־���. ��.��)
public class DrawMirrorThread extends Thread { 
	DrawCanvas dc;
	ArrayList<Integer> x;
	ArrayList<Integer> y;
	ArrayList<Integer> color;

	// ugGui.drawCanvas, x, y
	public DrawMirrorThread(DrawCanvas dc, ArrayList<Integer> color, ArrayList<Integer> x, ArrayList<Integer> y) {
		super();
		this.dc = dc;
		this.x = x;
		this.y = y;
		this.color = color;
	}

	@Override
	public void run() {
		if (this.x.size() != 0) {
			int i = 0;
			while (i < x.size()) {
				dc.setColorFlag(color.get(i));
				dc.x = x.get(i);
				dc.y = y.get(i);
				dc.repaint();
				i++;
			}
//			System.out.println("mirror �׸��� ����");
		}
	}

	public DrawCanvas getDc() {
		return dc;
	}

	public void setDc(DrawCanvas dc) {
		this.dc = dc;
	}

	public ArrayList<Integer> getColor() {
		return color;
	}

	public void setColor(ArrayList<Integer> color) {
		this.color = color;
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
