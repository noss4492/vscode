package day12_2_awt;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.util.Random;

public class MyWin extends Frame{
	Button btn;		// is a ���� (x), has a ���� (o) -> ��� ������ ����
	// ��ġ ������
	// ��� �����̳ʴ� ��ġ�����ڰ� �ϳ��� ����
	// Layout Manager : Container�� �⺻ ��ġ �����ڰ� ����
	// Frame : BorderLayout : ���������߾�
	
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
		
		btn1 = new Button("��");
		btn2 = new Button("��");
		btn3 = new Button("��");
		btn4 = new Button("��");
		btn5 = new Button("��");
		add(btn1,"East");
		add(btn2,"West");
		add(btn3,"South");
		add(btn4,"North");
		add(btn5,"Center");
		setSize(width/2, height/2);
		setTitle("H|o||||0|o||'||0|O|��~||��||o||0|o||��|o|||O|||.||o0|O|||0|o||");
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
