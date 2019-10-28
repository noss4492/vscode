package day12_2_awt;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.util.Random;

public class MyWin2 extends Frame {
	Button btn1, btn2;
	final static int WIDTH = 600;
	final static int HEIGHT = 400;
	
	MyWin2(){
		super("EVENT");
		btn1 = new Button("Áß¾Ó");
		btn1.setBounds(200, 100, 200+200, 100+100);
		btn1.setSize(WIDTH, HEIGHT);
		//add(btn1, "Center");
		add(btn1);
		
		setTitle("»ùÇÃ À©µµ¿ì");
		setSize(600, 400);
		setLocation(200, 100);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		MyWin2 mw2 = new MyWin2();
		Random gen= new Random();
		
	    
	    long delayTime = 1000;
	    



		
		for(; ; ) {
			mw2.setBackground(Color.getHSBColor(gen.nextInt(256), gen.nextInt(256), gen.nextInt(256)));
			mw2.btn1.setSize((int)(WIDTH*Math.random()), (int)(HEIGHT*Math.random()));
			//mw2.btn2.setSize((int)(WIDTH*Math.random()), (int)(HEIGHT*Math.random()));
			long saveTime = System.currentTimeMillis();
			long currTime = 0;
			while( currTime - saveTime < delayTime ){
		    	currTime = System.currentTimeMillis();
		    }
		}
	}
}
