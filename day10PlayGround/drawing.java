package day10PlayGround;
import java.awt.*;
import javax.swing.*;

public class drawing {
	public static void main(String[] args) {
		final int WIDTH = 1920/4;
		final int HEIGHT = 1200/4;
		int width = WIDTH;
		int height = HEIGHT;
		// 그림을 읽어와서 width와 height를 정해도 될 듯.
		// Toolkit.getDefaultToolkit().getImage("C\\Users\\.....png)
		 
		Dimension dim = new Dimension(width, height);

		JFrame frame = new JFrame("Hooooooooooo");
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLocationRelativeTo(null);
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
		super.paint(g);
		
		final int N = 8;
		int[] fiboArr = fibonacci(N);
		int tmpCnt=0;

		int radius = height;
		int x = (25/34)*width+150; 
		int y = (15/21)*height+150;
//		int x = 0;
//		int y = 0;
		
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
			
			//g.drawArc(x, y, length[i], length[i], 90*(tmp+2), 90*1);
			//g.drawRect(x, y, (int)(length[i]*(1+Math.cos(i*30))), 
			//		(int)(length[i]*(1+Math.sin(i*30))));	// 안움직이네?
			
			//g.drawRect(x,  y, length[i], length[i]);	
		}
	}
}
			
			
			
			
/*
if(i==N)
	break;
if(tmp > 4)
	tmp = tmp%4;

if(tmp == 0) {
	g.drawLine(x,  y, x+length[i],  y);
}
else if(tmp ==1) {
	g.drawLine(x,  y, x,  y+length[i]);
}
else if(tmp ==2) {
	g.drawLine(x,  y, x-length[i],  y);
}
else if(tmp ==3) {
	g.drawLine(x,  y, x,  y-length[i]);
}
			if(tmp==1) {
				if(i==0)
					y+=length[i];
				else
					y+=length[i-1];
			}
			else if(tmp==2)
				x-=length[i];
			else if(tmp==3)
				y-=length[i];
			else if(tmp==0) {
				if(i==0)
					x+=length[i];
				else
					x+=length[i-1];
			}
			
			i++;
			
		}
		
		
	}
}

*/