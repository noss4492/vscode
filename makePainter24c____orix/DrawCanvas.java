package makePainter24c____orix;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

class DrawCanvas extends Canvas { // Serialized Form X
	int x, y; // x, y���� ������ �����ؼ� ����ϴ� ����� ��������.
	int colorFlag = 3;
	int r1=0, g1=0, b1=0;
	boolean sw=false;
	int cnt=0;

	Graphics g; // �⺻������ �׸� �� ���� �׷��Ƚ� ��ü
	Image dbImage; // ���� ���۸� �̹���
	Graphics dbg; // ������۱׷��Ƚ�

	// Graphics ���ڸ� �ܺο��� ���� ����� �����ϱ� ������ �޼��带 �̿��Ѵ�.
	// repaint�� ���� ȣ���.
	// repaint�� update�� ȣ���� �� �� ĵ������ paint��
	public void update(Graphics g) {
		// ���ʿ��� �̷��� ������۸� �̹���(�޸𸮿� ������� �̹���)�� �ʱ�ȭ
		if (dbImage == null) {
			dbImage = createImage(this.getSize().width, this.getSize().height);
			dbg = dbImage.getGraphics(); // Creates a graphics context for drawing to an off-screen image.
			// dbImage : �޸𸮿��� �̹����� �׸��� ���� (ȭ�� ����)dbImage�� �غ�
			// dbg : (ȭ�� �ۿ���)�׸��� ���ؼ� �ʿ��� off-screen drawing graphics ��ü
			// context��°� �������� ���� ��Ÿ���ٰ� �˰� �ִµ� ���⼭�� graphics context(?)�� ��Ȯ�ϰԴ� �𸣰���
		}
		// ȭ�� �ۿ� �����ϱ� �ϴ� �� ���� �ö������ ĵ������ ��׶��� ���� �����ͼ� �����ϰ� (�׳� ������ �����ϴ� ��������)
		dbg.setColor(getForeground());
		myPaint(dbg); // dbg�� �׸��� screen-off(�׳� �޸𸮿�) �׷��� ���̴�.
		// �̰��� �ٽ� �Ϲ����� g�� drawImage�ؼ� ���� ���۸� �̹���(�޸𸮿� �׷����� ��)�� �ٽ� ĵ������ ���̰� �׷��ش�.
		// �޸𸮿� �̸� �׷������ν� ���� �����Ҷ� ���ܼ� ���� �� �ִ� �κ��� ������ ����̴�.
		g.drawImage(dbImage, 0, 0, this);
	}

	public void myPaint(Graphics g) {
		if (colorFlag == 0) { // R
			g.setColor(Color.red);
		} else if (colorFlag == 1) { // G
			g.setColor(Color.green);
		} else if (colorFlag == 2) { // B
			g.setColor(Color.blue);
		} else if (colorFlag == 3) { // Bk
			g.setColor(Color.black);
		} else if (colorFlag == 4) { // ���찳 -> background color
			g.setColor(this.getBackground());
		} else if (colorFlag == 5) { // Y
			g.setColor(Color.yellow);
		} else if (colorFlag == 6) { // special
			g.setColor(new Color(149,54,255));
//			setSuperBrush();
		}
//		} else if (colorFlag == 7) { // AllClear
//			clearAll(g);
//		}
		for(int i = 0 ; i < 3;  i++)	// �߸��̴� ���߿� �����ؼ� ����ϼ���. -> �˰��� ���� �ϰ� ���� ��.�� �ð��� ����
			g.fillOval(x - 5, y - 5, 10, 10);
	}
	// ���� ������������ ����
	// 0. Paint �޼���� ���콺�� �׸��� ȭ�鿡 �׷����� ������ �����Ѵ�.
	// (mouse dragged or mouse click��) ȣ��Ǵ� �κ�.
	// ���ڷ� Graphics g�� �ް� �Ǿ��־ ȣ�� ����� ������ �巯������ �ʴ�.
	// ���������δ� repaint -> update-> myPaint ������ ȣ��ȴ�.

	// 1. ���⿡ ����� �� �ִ� ����å�� ���ù����� ���δ�.
	// (�����ӿ� ���� �������� ��Ģ���� ��� ���� ����)
	// (�������� �Ǻ��Ͽ� �ΰ����� ���� ������ ����)

	// 1-1. ���� �׷��� �� �̰��� ������ �׷����ٰ� ������ �� �ִ°�?
	// ���� �Ϻ��ϰ� ����� ���̶��� �� �� ����.
	// ������� ��Ƽ� �������� �׷��� �켱������ �з� ���μ����� �Ҵ���� ���� paint�Ǵ� ������ �׷����� ���� ���ɼ��� �ִ�.
	// (��ǥ�� �������� ȭ�鿡 ����ϴ� �κп��� ������ �߻��� ���� �ִ�.)
	// (Graphics��� Ŭ������ ���ؼ��� �ڼ��� �𸣰����� ������ �׷��� �ʹ�. ���� �긦 �ڼ��� �˰� ������ �ʴ�.)

	// �׷��� ��ǥ�� ������ ���� ������� ���ӵǾ� �ִ����� üũ�غ��� (�����ð��� ���ݽð������� ��ǥ ���̰�)
	// ���Ἲ�� ���� ���� ���̿��� ���� ���� ���ɼ��� ���ٰ� �Ǵ��Ѵ�.
	// �̷��� ������̶� �����Ǵ� ��쿡����
	// ���� ��ġ�� ���� ��ġ�� (���ӵ��� ����ϴ� n)n����Ͽ� ������ ��ǥ ArrayList�� �߰��Ѵ�.
	// (px + (px-nx)*(i/n), py + (py-ny)*(i/n)), ArrayList.add(���� ������ index, n��е�
	// ��ǥ(i)), i+1~n-1
	// ���� ������ �ϼ��ȴٸ� �̸� �����Ͽ� �ۼ��غ���.
	// (���� ���� ���������� ���ӵ������ε� �� ����� ������ �� ������)

	// �ʹ� edge�� sharp�� ��츦 �Ǵ��ϰ� �̸� �������ְ� �ε巴�� ����� (�ε巴�� �Ϳ��� ���̰�)
	// ���ϰ� ���̴� ���� ����ٸ�.
	// ex) �� A0-A1-A2�� ���� ����� �� ó�� �׷����� �ϸ� A0�� A2�� �̾����� �ϰ� A1�� ���(����)�Ǿ�� �Ѵ�.
	// �׷����� �ִ� ������ �� ��ǥ���� ����� �� �� ���� ���̴�.
	// �̰͵� ���� ���������� �׳� n��� �ؼ� \ ������� ���� ������
	// �츮�� �����ӵ��� �������� ����� \, ���ӵ��� �������� ����� ��� ������ �� �� �ְڴ�.
	// ���� A1 ����(edge)���� �� ���� ���� ���ϴ� ���� �۴ٸ� �̻ڰ� �����ϰ� ���� ���̴�.
	// �ð��� ���´ٸ�? �ð��� �� ������

	// ȭ�� ��ü ����� ���(�̶�� ��������� canvas�� ������ background������ ��üũ�� �簢������ ����׸���)
	public void clearAll(Graphics g) {
		x = -900; y = -500;
		dbg.setColor(getBackground());
		dbg.fillRect(0, 0, this.getSize().width, this.getSize().height);
		repaint();
	}

	public void callClearAll() {
		x = -900; y = -500;
		System.out.println("��ü����� ȣ���");
		clearAll(g);
	}

	public void callChangeColorR() {
		changeColorR(g);
	}

	public void callChangeColorG() {
		changeColorG(g);
	}

	public void callChangeColorB() {
		changeColorB(g);
	}

	public void callChangeColorY() {
		changeColorY(g);
	}

	public void callChangeColorW() {
		changeColorW(g);
	}

	public void callChangeColorBK() {
		changeColorBK(g);
	}

	public void setSuperBrush() {		// �Ҿ����� ����� �Ⱦ��ϴ�. (���� �̻ڱ� �ѵ� ��.��)
		sw=false;
		colorFlag = 5;
		cnt = 0;
		g1=255; b1=255; r1=0;
		new Thread(() -> {
			while ( cnt<10000) { 	// max 100s
				cnt++;
				try {
					Thread.sleep(10);
					// Red -> Blue -> Red -> Blue Gradient
					// init r=0; g=0; b=255;
					// RGB(255,0,0) -> RGB(127, 0 127) -> RGB(0, 0, 100)
//					if(sw == false) {	
//						r1++;
//						if(r1==255)
//							sw=true;
//					}else {
//						r1--;
//						if(r1==0)
//							sw=false;
//					}
//					if(sw==false) {
//						b1--;
//						if(b1==255)
//							sw=true;
//					}else {
//						b1++;
//						if(b1==255)
//							sw=false;
//					}
					
					// ����-�Ķ�-�ϴ� �׶���Ʈ
					// init g1=255; b1=255; r1=0;
					if(sw == false) {	
						r1++;
						if(r1==255)
							sw=true;
					}else {
						r1--;
						if(r1==0)
							sw=false;
					}
					if(sw==false) {
						g1--;
						if(g1==255)
							sw=true;
					}else {
						g1++;
						if(g1==255)
							sw=false;
					}
					// All Random
//					r1 = (int) (Math.random() * 256);
//					g1 = (int) (Math.random() * 256);
//					b1 = (int) (Math.random() * 256);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	public void callChangeColorRGB() { // X
//		new Thread (() -> {
//			while(true) {
//				try {
//					Thread.sleep(100);
//					g.setColor(new Color((int) (Math.random()*256),255,255));
////					Thread.sleep(100);
////					colorFlag=0;	
////					Thread.sleep(100);
////					colorFlag=1;
////					Thread.sleep(100);
////					colorFlag=2;	
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}).start();
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

	public void changeColorW(Graphics g) {
		g.setColor(Color.white);
	}

	public void paintBucket() {
		// Convex Hull(Graham's scan)���� ���� üũ�Ͽ� �� ���θ� ĥ���ִ� ����� ����
		// �ӽý�
	}

	public int getColorFlag() {
		return colorFlag;
	}

	public void setColorFlag(int colorFlag) {
		this.colorFlag = colorFlag;
	}
}
// ������ �ڵ� ����
//		myPaint(g);
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