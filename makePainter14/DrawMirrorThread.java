package makePainter14;

import java.util.ArrayList;

// 화면복제기능
// 실은 서버에서 받은 좌표로 다시 화면에 찍어주는 기능을 수행함
// 동작 수행시간이 길 것으로 예상되기 때문에 다른 기능들과는 병렬적으로 동작해야하므로 쓰레드로 생성함
// (원래는 패널에 담아서 통신으로 송수신 하고 싶었지만 
// 하루간 조사해본 결과 패널을 보내는 방법(특히 스윙 클래스 객체 직렬화)은 추천되지 않고 있었다. ㅠ.ㅠ)
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
//			System.out.println("mirror 그리기 종료");
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
