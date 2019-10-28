package day12_my_immutable_chanining;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.util.Random;

public class Hw9 extends Frame{
	final static int WIDTH = 800;
	final static int HEIGHT = 600;
	int width = WIDTH;
	int height = HEIGHT;
	
	Hw9(){
		super();
		this.setSize(width, height);
		this.setLocation(100, 100);
		this.setTitle("배치관리자테스트");
		this.setVisible(true);
		
		FlowLayout fl1 = new FlowLayout();
		setLayout(fl1);
		
		while(true) {
			Button btn[] = new Button[100];
			for(int i = 0; i < btn.length; i ++) {
				long start = 0;
				long end;

				btn[i] = new Button();
				Random gen= new Random();
				
				btn[i].setBackground(Color.getHSBColor(gen.nextInt(256), gen.nextInt(256), gen.nextInt(256)));
				setBackground(Color.DARK_GRAY);
				add(btn[i]);
				
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
				
				if(i%2==0)
					this.setSize(width+1, height+1);
				else
					this.setSize(width-1, height-1);
			}
		}
	}
	public static void timeDelay(long start, long end) {
		long delayTime = 5;
		while( start - end < delayTime )
			start = System.currentTimeMillis();
	}
	
	public static void main(String[] args) {
		Hw9 hw9 = new Hw9();
		
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