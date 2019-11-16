package makePainter14;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

class DrawCanvas extends Canvas { // Serialized Form X
	int x, y; // x, y���� ������ �����ؼ� ����ϴ� ����� ��������.

	Graphics g;			// �⺻������ �׸� �� ���� �׷��Ƚ� ��ü
	Image dbImage;		// ���� ���۸� �̹���
	Graphics dbg;		// ������۱׷��Ƚ�

	// Graphics ���ڸ� �ܺο��� ���� ����� �����ϱ� ������ �޼��带 �̿��Ѵ�.
	// repaint�� ���� ȣ���.
	// repaint�� update�� ȣ���� �� �� ĵ������ paint��
	public void update(Graphics g) {
		// ���ʿ��� �̷��� ������۸� �̹���(�޸𸮿� ������� �̹���)�� �ʱ�ȭ
		if (dbImage == null) {
			dbImage = createImage(this.getSize().width, this.getSize().height);
			dbg = dbImage.getGraphics();	// Creates a graphics context for drawing to an off-screen image.
			// dbImage : �޸𸮿��� �̹����� �׸��� ���� (ȭ�� ����)dbImage�� �غ�
			// dbg : (ȭ�� �ۿ���)�׸��� ���ؼ� �ʿ��� off-screen drawing graphics ��ü
			// context��°� �������� ���� ��Ÿ���ٰ� �˰� �ִµ� ���⼭�� graphics context(?)�� ��Ȯ�ϰԴ� �𸣰���
		}
		// ȭ�� �ۿ� �����ϱ� �ϴ� �� ���� �ö������ ĵ������ ��׶��� ���� �����ͼ� �����ϰ� (�׳� ������ �����ϴ� ��������)
		dbg.setColor(getForeground());
		myPaint(dbg);	//dbg�� �׸��� screen-off(�׳� �޸𸮿�) �׷��� ���̴�.
		// �̰��� �ٽ� �Ϲ����� g�� drawImage�ؼ� ���� ���۸� �̹���(�޸𸮿� �׷����� ��)�� �ٽ� ĵ������ ���̰� �׷��ش�.
		// �޸𸮿� �̸� �׷������ν� ���� �����Ҷ� ���ܼ� ���� �� �ִ� �κ��� ������ ����̴�.
		g.drawImage(dbImage, 0, 0, this);
	}
	
	public void myPaint(Graphics g) {
		g.fillOval( x - 5 , y - 5, 10 , 10 );
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
	// ���� ��ġ�� ���� ��ġ��  (���ӵ��� ����ϴ� n)n����Ͽ� ������ ��ǥ ArrayList�� �߰��Ѵ�.
	// (px + (px-nx)*(i/n), py + (py-ny)*(i/n)), ArrayList.add(���� ������ index, n��е� ��ǥ(i)), i+1~n-1
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
	public void clearALL(Graphics g) {
		dbg.setColor(getBackground());
		dbg.fillRect(0, 0, this.getSize().width, this.getSize().height);
	}

	public void paintBucket() {
		// Convex Hull(Graham's scan)���� ���� üũ�Ͽ� �� ���θ� ĥ���ִ� ����� ���� 
		// �ӽý�
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