package day11_2;

import java.awt.Frame;
// import java.lang.*; 는 모두 필수적인 애들이라 포함되어있음.
import java.util.Set;

public class MyWin extends Frame{
	static final int WIDTH=400;
	static final int HEIGHT=300;
	
	/*
	public void ranNum1to100() {
		int[] rNum = null;
		for(int i = 0; i < 100; i++)
			rNum[i] = (int)(Math.random()*100)+1;
	}
	public static int[] fibonacci(int n) {
		int[] a = new int[n+2];
		a[0] = 1;
		a[1] = 1;
		for(int i = 0; i < n; i++)
			a[i+2] = a[i] + a[i+1];
		return a;
	}
	*/
	
	MyWin(){
		super();
		setSize(WIDTH, HEIGHT);
		setLocation(100,100);
		setTitle("HooooooooooooooooooooOOo");
		//setBackground();
		setVisible(true);
	}
	public static void main(String[] args) {	
		MyWin mw = new MyWin();
		
	}
}























/*
		final int N = 8;
		int[] fiboArr = fibonacci(N);
		int tmpCnt=0;
		
		int width = WIDTH;
		int height = HEIGHT;

		int radius = height;
		int x = (25/34)*width+150; 
		int y = (15/21)*height+150;
		
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
		for(int i = 0; i <N-2;) {	//01234567
			int tmp = i;
			g.drawArc(x, y, length[i], length[i], 90*(tmp+2), 90*1);
		}
 */










/*
	MyWin(){
		super();
	}*/