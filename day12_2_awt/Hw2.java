package day12_2_awt;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.util.Random;
/*
 * Layer같아
 * 
 * Container
 *  |위에 component를 수송
 *    |
 */
public class Hw2 extends Frame{
	Button btn1, btn2;
	
	final static int WIDTH = 300;
	final static int HEIGHT = 300;
	int width = WIDTH;
	int height = HEIGHT;
	
	Hw2(){
		super();
		btn1 = new Button("중");
		btn2 = new Button("하");
		add(btn1,"Center");
		add(btn2,"South");
		setSize(width, height);
		setTitle("H|o||||0|o||'||0|O|。~||·||o||0|o||＇|o|||O|||.||o0|O|||0|o||");
		setVisible(true);
		setLocation(150, 150);
	}
	
	public static void main(String[] args) {
		Hw2 mw = new Hw2();
	}
}
