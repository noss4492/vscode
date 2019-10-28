package day12_2_awt;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.util.Random;

public class MyWin extends Frame{
	Button btn;		// is a 관계 (x), has a 관계 (o) -> 멤버 변수로 들어옴
	// 배치 관리자
	// 모든 컨테이너는 배치관리자가 하나씩 있음
	// Layout Manager : Container는 기본 배치 관리자가 존재
	// Frame : BorderLayout : 동서남북중앙
	
	// FlowLayout
	Button btn1, btn2, btn3, btn4, btn5;
	
	final static int WIDTH = 1920;
	final static int HEIGHT = 1200;
	int width = WIDTH/2;
	int height = HEIGHT/2;
	
	MyWin(){
		super();
		FlowLayout f1 = new FlowLayout();
		setLayout(f1);
		
		btn1 = new Button("동");
		btn2 = new Button("서");
		btn3 = new Button("남");
		btn4 = new Button("북");
		btn5 = new Button("中");
		add(btn1,"East");
		add(btn2,"West");
		add(btn3,"South");
		add(btn4,"North");
		add(btn5,"Center");
		setSize(width/2, height/2);
		setTitle("H|o||||0|o||'||0|O|。~||·||o||0|o||＇|o|||O|||.||o0|O|||0|o||");
		setVisible(true);
		setLocation(50, 50);		//150,150
	}
	
	public static void main(String[] args) {
		
		MyWin mw = new MyWin();
		Random gen= new Random();
//		for(int i; ; )
//			mw.setBackground(Color.getHSBColor(gen.nextInt(256), gen.nextInt(256), gen.nextInt(256)));
//		
		
		
	}
}
