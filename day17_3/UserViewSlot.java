package day17_3;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class UserViewSlot implements Runnable {
	JButton[][] btnSlot = new JButton[3][3];// 3 3
	ImageIcon[][] img = new ImageIcon[3][9];// 3 9
	int col;
	// �׳� 1���� �迭 �����ͷ� �������µ� �ȵǳ� �ս��� �־ �׳� 2���� �迭�� ����.
	// �ٵ� 2���� �迭�� �޾��� �� �迭�� �����ִ�(?) ��ü�� ������ ������ �ȵɼ��� ���� ������?
	// �ϴ� ����
	// �ϳ��� ���� ��...

	public UserViewSlot(int col, JButton[][] btnSlot, ImageIcon[][] img) {
		super();
		this.btnSlot = btnSlot;
		this.img = img;
		this.col = col;
	}

	// ������ ������ �پ �����δ�.
	// (img[x][9] : a,b,c,d,e,f,g,h,i)
	// ��ĭ �����δٸ� : -,a,b,c,d,e,f,g,h / i,a,b,c,d,e,f,g,h

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("�׽�Ʈ���Դϴ�. col : "+this.col);
		int c = 0;
		int k = 0;
		int d = 1;
		double tmpR = 0;
		for (int i = 0; i < (tmpR = Math.random()*300); i++) {
			for (int j = 0; j < 9; j++) {
				c = j;		
				k = j+i;	// k �� i���� ���� ������ ��ĭ�� �и�
				// c : 012012012 012012012 012012012 012012012 012012012
				// k : 012345678 123456780 234567801 345678012 456780123
				if(j+i>=9)
					k = (j+i)%9;
				if(j>=3)
					c = j%3;
				try {
					Thread.sleep(d);
					btnSlot[col][c].setIcon(img[col][k]);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if(i <= 50)
				continue;
			else {
				if(i >= (int)tmpR-50)
					d=d++;		// 0 -> 20ms
			}
				
		}
	}
}
