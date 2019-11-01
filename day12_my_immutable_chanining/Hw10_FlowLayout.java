package day12_my_immutable_chanining;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.util.Random;

public class Hw10_FlowLayout extends Frame{
	final static int WIDTH = 800;
	final static int HEIGHT = 600;
	int width = WIDTH;
	int height = HEIGHT;
	
	Hw10_FlowLayout(){
		super();
		this.setSize(width, height);
		this.setLocation(100, 100);
		this.setTitle("배치관리자테스트");
		this.setVisible(true);
		
		FlowLayout fl1 = new FlowLayout();
		setLayout(fl1);
		
		Button btn[];
		btn = new Button[50];	// 초기화 null
		
		System.out.println("btn : "+btn);
		for(int i = 0; i < btn.length; i ++) {
			btn[i] = new Button(""+(i+1));	// 버튼을 만들어서 각 btn[0] [1] 에 넣어주면 참조할게 생김
			System.out.println("btn["+i+"] : "+btn[i]);
			add(btn[i]);
			
			if(i%2==0)
				this.setSize(width+1, height+1);
			else
				this.setSize(width-1, height-1);
		}
	}
	public static void timeDelay(long start, long end) {
		long delayTime = 5;
		while( start - end < delayTime )
			start = System.currentTimeMillis();
	}
	
	public static void main(String[] args) {
		Hw10_FlowLayout hw9 = new Hw10_FlowLayout();
	}
}



/*
btn = new Button[50];
// 다 null 들어잇슴
Button b0 = new Button("0");
Button b1 = new Button("1");
btn[0] = b0;
btn[1] = b1;
// 담아야 참조할게 생김.

 */

/*

9. 
	창크기 : 800,600
	위치 : 100,100
	타이틀 : 배치관리자테스트
	
	FlowLayout을 사용하여 화면에
	버튼 50개를 생성하여 창에 부착 	
*/