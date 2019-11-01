package day13_Hw;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lala extends Frame{
	// 안보고 적어보자 (?)
	Button btn1, btn2, btnExit;
	Label lb[] = new Label[10];
	Handler6 hl = new Handler6();
	static boolean f = false;
	Font f1 = new Font("myFont", 1, 20);
	
	
	Lala(){
		super("make hw again");
		setLayout(null);
		setSize(800,600);
		setLocation(200, 200);
		setVisible(true);
		
		for(int i = 0; i < 10; i++) {
			lb[i] = new Label("\' 3\'");
			lb[i].setSize(200, 50);
			lb[i].setLocation((int)(Math.random()*800),(int)(Math.random()*600));
			lb[i].setFont(f1);
		}
		
		int w = 800;
		int h = 600;
		
		int mw = 800;
		int hw = 0;
		while(true) {
			for(int i = 0; i < 10; i++) {
				long start = System.currentTimeMillis();

				for(int j = 0; j < 10; j ++)
					add(lb[j]);
				
				
				mw -= 1;
				hw += 1;
				if(mw==0)
					mw=(int)(Math.random()*800);
				if(hw==h)
					hw=(int)(Math.random()*600);
				lb[i].setLocation(mw, hw);
				
				
				long end = System.currentTimeMillis();
				timeDelay(start, end);

				for(int j = 0; j < 10; j ++)
					remove(lb[j]);
				
				if(f==true)
					break;
			}
		}
	}
//			btn1 = new Button("hit!");
//			btn1.setSize(50, 50);
//			btn1.setLocation((int)(Math.random()*800),(int)(Math.random()*600));
//			btn1.addActionListener(hl);
	//add(btn1);
//			btnExit = new Button("hit!");
//			btnExit.setSize(50, 50);
//			btnExit.setLocation(400, 500);
//			btnExit.addActionListener(hl);
//			add(btnExit);
	public static void main(String[] args) {
		Lala wh1 = new Lala();
	}
	
	
	class Handler6 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			f = true;
		}
	}
	public static void timeDelay(long start, long end) {
		long delayTime = 300;
		while( start - end < delayTime )
			start = System.currentTimeMillis();
	}
}
