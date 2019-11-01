package day13_2;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.util.Random;

public class Hw9_2 extends Frame{
	final static int WIDTH = 800;
	final static int HEIGHT = 600;
	int width = WIDTH;
	int height = HEIGHT;
	int x = 0;
	int y = 0;
	int vx = 1;
	int vy = 1;
	
	Hw9_2(){
		super();
		this.setSize(width, height);
		this.setLocation(100, 100);
		this.setTitle("배치관리자테스트");
		this.setVisible(true);
		
		x = width;
		
		FlowLayout fl1 = new FlowLayout();
		setLayout(fl1);
		
		while(true) {
			Button btn[] = new Button[100];
			for(int i = 0; i < btn.length; i ++) {
				long start = 0;
				long end;

				btn[i] = new Button(""+(i+1));
				Random gen= new Random();
				
				btn[i].setBackground(Color.getHSBColor(gen.nextInt(256), gen.nextInt(256), gen.nextInt(256)));
				setBackground(Color.DARK_GRAY);
				add(btn[i]);
				
				x -= vx;
				y += vy;
				if(y <= 0)
					y = height;
				if(x >= width)
					x = 0;
				btn[i].setLocation(width/2 - vx, height/2 + y);
				
				if(i == btn.length-1) {
					start = 0;
					for(int j = btn.length-1; j >=0 ; j--) {
						end = System.currentTimeMillis();
						timeDelay(start, end);
						remove(btn[j]);
					}
				}
				
				end = System.currentTimeMillis();
				timeDelay(start, end);
				
//				Button temp;
//				temp = btn[i];
//				int a = (int)(Math.random()*btn.length);
//				btn[i] = btn[a];
//				btn[a] = temp;
//				System.out.println(i+"<->"+a);
				
				if(i%2==0)
					this.setSize(width+1, height+1);
				else
					this.setSize(width-1, height-1);
			}
		}
	}
	public static void timeDelay(long start, long end) {
		long delayTime = 10;
		while( start - end < delayTime )
			start = System.currentTimeMillis();
	}
	
	public static void main(String[] args) {
		Hw9_2 hw9 = new Hw9_2();
		
	}

}

/*

9. 
	창크기 : 800,600
	위치 : 100,100
	타이틀 : 배치관리자테스트
	
	FlowLayout을 사용하여 화면에
	버튼 50개를 생성하여 창에 부착 	
*/