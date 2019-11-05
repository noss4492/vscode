package day17_3;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class UserViewSlot implements Runnable {
	JButton[][] btnSlot = new JButton[3][3];// 3 3
	ImageIcon[][] img = new ImageIcon[3][9];// 3 9
	int col;
	// 그냥 1차원 배열 포인터로 받을랬는데 안되네 손실이 있어도 그냥 2차원 배열로 받자.
	// 근데 2차원 배열로 받았을 때 배열이 묶여있는(?) 객체면 쓰레드 동작이 안될수도 있지 않을까?
	// 일단 만들어봄
	// 하나만 도네 흠...

	public UserViewSlot(int col, JButton[][] btnSlot, ImageIcon[][] img) {
		super();
		this.btnSlot = btnSlot;
		this.img = img;
		this.col = col;
	}

	// 슬롯은 열끼리 붙어서 움직인다.
	// (img[x][9] : a,b,c,d,e,f,g,h,i)
	// 한칸 움직인다면 : -,a,b,c,d,e,f,g,h / i,a,b,c,d,e,f,g,h

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("테스트중입니다. col : "+this.col);
		int c = 0;
		int k = 0;
		int d = 1;
		double tmpR = 0;
		for (int i = 0; i < (tmpR = Math.random()*300); i++) {
			for (int j = 0; j < 9; j++) {
				c = j;		
				k = j+i;	// k 는 i값에 의해 옆으로 한칸씩 밀림
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
