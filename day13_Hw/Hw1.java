package day13_Hw;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

public class Hw1 extends Frame {
	// ��ư �ΰ� ����� ȭ�鿡 ���̱�, YES NO
	static int width = 800;
	static int height = 600;
	Label lb;
	Button[] btnN = new Button[8];
	HandlerY hd1 = new HandlerY();
	Font f1 = new Font("myFont", 1, 20);
	
	Hw1(String title){
		super(title);
		setLayout(null);	//��ġ ������ �Ⱦ�

		
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
		
		//������Ʈ �ʱ�ȭ
		lb = new Label("������ ���");
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
		Hw1 sw = new Hw1("������");
	}
}

class HandlerY implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();		
		
		System.out.println(cmd);
		gugudan(cmd);
	}
	public void gugudan(String cmd) {		// parameter : button label
		int a = cmd.charAt(0)-'0';
		// int b = Integer.parseInt(cmd);	// �ڸ����� ���ڸ��� �ƴҶ�
		// int b = Integer.valueOf(cmd);
		
		System.out.printf("[%2d�� ���]\n", a);
		for(int i = 2 ; i <= 9; i++)
			System.out.printf("%2dx%2d=%2d\n", a, i, i*a);
		
		
	}
}




