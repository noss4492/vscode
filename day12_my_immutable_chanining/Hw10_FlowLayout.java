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
		this.setTitle("��ġ�������׽�Ʈ");
		this.setVisible(true);
		
		FlowLayout fl1 = new FlowLayout();
		setLayout(fl1);
		
		Button btn[];
		btn = new Button[50];	// �ʱ�ȭ null
		
		System.out.println("btn : "+btn);
		for(int i = 0; i < btn.length; i ++) {
			btn[i] = new Button(""+(i+1));	// ��ư�� ���� �� btn[0] [1] �� �־��ָ� �����Ұ� ����
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
// �� null ����ս�
Button b0 = new Button("0");
Button b1 = new Button("1");
btn[0] = b0;
btn[1] = b1;
// ��ƾ� �����Ұ� ����.

 */

/*

9. 
	âũ�� : 800,600
	��ġ : 100,100
	Ÿ��Ʋ : ��ġ�������׽�Ʈ
	
	FlowLayout�� ����Ͽ� ȭ�鿡
	��ư 50���� �����Ͽ� â�� ���� 	
*/