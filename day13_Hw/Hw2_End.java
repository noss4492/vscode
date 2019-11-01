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
	// ��ư �ΰ� ����� ȭ�鿡 ���̱�, YES NO
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
		setLayout(null);	//��ġ ������ �Ⱦ�

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
		
		//������Ʈ �ʱ�ȭ
		lb = new Label("������ ���");
		add(lb);
		lb.setSize(400,50);
		lb.setLocation(width/2-200, height/10);
		lb.setFont(f1);
		
		setSize(width, height);
		setLocation(100, 100);
		setVisible(true);
	}
	public static void main(String[] args) {
		Hw2_End sw = new Hw2_End("������");
	}
	class HandlerHw2 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();		
			System.out.println(cmd);
			
			if(cmd.equalsIgnoreCase("print")) {
				String data = tfDan.getText();
				int a = Integer.parseInt(data);	// �ڸ����� ���ڸ��� �ƴҶ�

				System.out.printf("[%2d�� ���]\n", a);
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