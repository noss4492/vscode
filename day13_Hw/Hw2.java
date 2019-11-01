package day13_Hw;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

public class Hw2 extends Frame {
	// 버튼 두개 만들고 화면에 붙이기, YES NO
	static int width = 800;
	static int height = 600;
	Label lb;
	Button[] btnN = new Button[8];
	Button btnExit;
	HandlerY2 hd1 = new HandlerY2();
	Font f1 = new Font("myFont", 1, 20);
	
	Hw2(String title){
		super(title);
		setLayout(null);	//배치 관리자 안씀


		
		btnExit = new Button("EXIT");
		btnExit.setSize(50, 50);
		btnExit.setLocation(width/2-50, height-100);
		add(btnExit);
		
		int w = width/2 - 160;		// 40 x 4 | 40 x4
		int bw = w;
		for(int i = 0; i < 8; i++) {
			btnN[i] = new Button(""+(i+2));
			add(btnN[i]);
			btnN[i].setSize(40, 40);
			btnN[i].setLocation(bw, height/2);
			btnN[i].addActionListener(hd1);
			btnN[i].setFont(f1);
			bw += 40;
		}
		
		//컴포넌트 초기화
		lb = new Label("구구단 출력");
		add(lb);
		lb.setSize(400,50);
		lb.setLocation(width/2-200, height/10);
		lb.setBackground(Color.PINK);
		lb.setFont(f1);
		
		setSize(width, height);
		setLocation(100, 100);
		setVisible(true);
	}
	public static void main(String[] args) {
		Hw2 sw = new Hw2("구구단");
	}
	class HandlerY2 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();		
			
			System.out.println(cmd);
			gugudan(cmd);
//		if(cmd.equals("출력"))
			if(cmd.equalsIgnoreCase("exit"))
				System.exit(0);
		}
		public void gugudan(String cmd) {		// parameter : button label
			int a = cmd.charAt(0)-'0';
			// int b = Integer.parseInt(cmd);	// 자릿수가 한자리가 아닐때
			// int b = Integer.valueOf(cmd);
			
			System.out.printf("[%2d단 출력]\n", a);
			for(int i = 2 ; i <= 9; i++)
				System.out.printf("%2dx%2d=%2d\n", a, i, i*a);
		}	//actionPerformed() end
	}	//handler end
}	//hw2 class end

// 아 이거 textbox만들어서 만들기





//		Frame frame1 = new Frame("what");
//		frame1.add(new TextField("displayyyyy"));
//		frame1.add(new TextField("displayyyyy"));
//		frame1.setSize(400, 100);
//		frame1.setLocation(100, 100);
//		frame1.setVisible(true);