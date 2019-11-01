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

public class Hw2_End extends Frame {
	// 버튼 두개 만들고 화면에 붙이기, YES NO
	static int width = 800;
	static int height = 600;
	Label lb;
	Button btnN;
	Button btnExit;
	HandlerHw2 hd1 = new HandlerHw2();
	TextField tfDan;
	Font f1 = new Font("myFont", 1, 20);
	
	Hw2_End(String title){
		super(title);
		setLayout(null);	//배치 관리자 안씀

		tfDan = new TextField(20);
		tfDan.setBounds(260, 150, 280, 60);
		tfDan.setFont(f1);
		add(tfDan);
		
		int w = width/2 - 160;		// 40 x 4 | 40 x4
		int bw = w;
		
		btnN = new Button("PRINT");
		add(btnN);
		btnN.setSize(140, 40);
		btnN.setLocation(bw, height/2);
		btnN.addActionListener(hd1);
		btnN.setFont(f1);
		bw += 200;
		
		btnExit = new Button("EXIT");
		add(btnExit);
		btnExit.setSize(140, 40);
		btnExit.setLocation(bw, height/2);
		btnExit.addActionListener(hd1);
		btnExit.setFont(f1);
		
		//컴포넌트 초기화
		lb = new Label("구구단 출력");
		add(lb);
		lb.setSize(400,50);
		lb.setLocation(width/2-200, height/10);
		lb.setFont(f1);
		
		setSize(width, height);
		setLocation(100, 100);
		setVisible(true);
	}
	public static void main(String[] args) {
		Hw2_End sw = new Hw2_End("구구단");
	}
	class HandlerHw2 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();		
			System.out.println(cmd);
			
			if(cmd.equalsIgnoreCase("print")) {
				String data = tfDan.getText();
				int a = Integer.parseInt(data);	// 자릿수가 한자리가 아닐때

				System.out.printf("[%2d단 출력]\n", a);
				for(int i = 2 ; i <= 9; i++)
					System.out.printf("%2dx%2d=%2d\n", a, i, i*a);
			}
			else if(cmd.equalsIgnoreCase("exit"))
				System.exit(0);
		}
	}	//handler end
}	//hw2 class end






//		Frame frame1 = new Frame("what");
//		frame1.add(new TextField("displayyyyy"));
//		frame1.add(new TextField("displayyyyy"));
//		frame1.setSize(400, 100);
//		frame1.setLocation(100, 100);
//		frame1.setVisible(true);