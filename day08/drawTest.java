package day08;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.*;

public class drawTest {
	
	
	
	public static void main(String[] args) {
		final int WIDTH = 1920/4;
		final int HEIGHT = 1200/4;
		int width = WIDTH;
		int height = HEIGHT;
		// 그림을 읽어와서 width와 height를 정해도 될 듯.
		// Toolkit.getDefaultToolkit().getImage("C\\Users\\.....png)
		 
		Dimension dim = new Dimension(width, height);


		JFrame frame = new JFrame("Hoooo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(WIDTH,HEIGHT);


		frame.setLocation(300,200);
		frame.setPreferredSize(dim);
		
		DrawPanel drawpanel = new DrawPanel(width, height);
		
		frame.add(drawpanel);
		frame.pack();
		frame.setVisible(true);
	}
}
class DrawPanel extends JPanel
{
	int width;
	int height;
	//@override
	DrawPanel(int width, int height){
		this.width = width;
		this.height = height;
	}
	public static int[] fibonacci(int n) {
		int[] a = new int[n+2];
		//0 1 1 2 3 5 8 13 21 34 55 89 144...
		//    1 2 3 4 5 6  7  
		a[0] = 1;
		a[1] = 1;
		for(int i = 0; i < n; i++) {
			a[i+2] = a[i] + a[i+1];
		}
		return a;
	}
	
	public void paint(Graphics g) {
		
		/*
 어떻게 그릴 것 인가?
 1. 삼각함수로 
	 1. 중심부터
	 	1. 중심부터 구하기
	 2. 바깥부터
	 	1. ???
 2. 호를 그려서
	 1. 중심부터
		 1. 피보나치 수열
	 2. 바깥부터
		 1. 비율로
 
 
		 */
		super.paint(g);
		
		final int N = 10;
		int[] fiboArr = fibonacci(N); //원래N-1 9는 전체 가로 길이 때문에 씀
		int tmpCnt=0;
//		for(int x : fiboArr)
		// r : 1 1 2 3 5 8 13 21
		// w : 1 1 3 8 21   : 34
		// h : 1 2 5 13     : 21
		// h * 21+5+
		
		// 25/34 * width
		int radius = height;
//		int x = (25/34)*width; 
//		int y = (15/21)*height;
		int x = 0;
		int y = 0;
		
		int[] length = new int[N];
		int[] lengthR = new int[N];
		
		int reverseArrIndex=N-1;
		for(int i = 0; i < N; i++) {
			length[i] = fiboArr[i]*(width/fiboArr[N]);
			lengthR[reverseArrIndex--] = fiboArr[i]*(width/fiboArr[N]);
		}
		
		for(int i = 0; i < N-2; i++) {	//use length[7]
			//System.out.printf("f[%2d] = %2d\n", i, fiboArr[i]);
			System.out.printf("length[%2d]/5 = %2d\n", i, length[i]/5);
		}
		for(int i = 0; i <N;) {	//01234567
			int tmp = i;
			if(tmp > 4)	//tmp uses for drawArc angle
				tmp = tmp%4;
			g.drawArc(x, y, length[i], length[i], 90*tmp, 90*4);
			
			
			// width l[7] + l[6]
			// height l[7]
			
			// center point
			// y = -(l[7]/(l[7]+l[6])x
			// y = -(l[7]/(l[8])x
			// 
			// l[7]+l[6],0 to l[7], l[7]
			// y = l[7]/l[6](x+l[7]+l[6])
			// 계산 시러...
			
			// 
			// y = -(21/34)x
			// y = 21/13*(x+34)
			// -(21/34) = 21/13 * (x+34)
			// -13 = 34*(x+34)
			// (x+34) = -13/34
			// x = 34 - 13/34
			// y = 
			
			
			i++;
			if(i==N)
				break;
			if(i%4==1)
				y+=length[i];
			else if(i%4==2)
				x-=length[i];
			else if(i%4==3)
				y-=length[i];
			else if(i%4==0)
				x+=length[i];
		//	switch(i%4) {//y+ x- y- x+
		}
	}
}
		
		
		
//		for(int i = 0; i < 8; i ++) {
//			g.drawArc(0, 0, radius, radius, 90*1, 90*4);	//4 to 1
//		}

		
		//g.drawArc(height/2, 0, radius, radius, 90*1, 90*4);	//4 to 1
		
		
		// h.h에서 시작해서 
		// h.h-
//		g.drawArc(0, 0, radius, radius, 90*1, 90*4);	//4 to 1
//		radius /= 1.618;
//		x = width-height;
//		g.drawArc(x, 0, radius, radius, 90*4, 90*4);	//4 to 1

		
		
		//y -= radius;
//		g.drawArc(x, y, radius, radius, 90*1, 90);	//4 to 1
//		radius /= 1.618;
		//x += radius;
//		g.drawArc(x, y, radius, radius, 90*1, 90);	//4 to 1
//
//		radius /= 1.618;
//		g.drawArc(x, y, radius, radius, 90*1, 90);	//4 to 1
	
		
		//g.drawRect(x, y, radius, radius);
		
		
		
		//g.drawRect(0, 0, height, height);
		//g.drawRect(width-height, 0, width, height);
		// 0.0 is left-up side coordinate
		
		// 1.618
		// h, h point   | r = h       | 0 to 90
		// h-(h/1.618),0| r = h/1.618 | 90 to 180
		// w-h, 0 point | r = w-h | 90 to 180
		// 

