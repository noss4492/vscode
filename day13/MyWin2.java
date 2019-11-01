package day13;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

public class MyWin2 extends Frame {
	// ��ư �ΰ� ����� ȭ�鿡 ���̱�, YES NO
	static int width = 800;
	static int height = 600;
	Button btnY, btnN;
	Label lb;
	
	MyWin2(String title){
		super(title);
		setLayout(null);	//��ġ ������ �Ⱦ�

		//������Ʈ �ʱ�ȭ
		btnY = new Button("YES");
		btnN = new Button("NO");
		lb = new Label("            1000���� ��� ����! (Yes/No)");
		add(btnY);
		add(btnN);
		add(lb);
		btnY.setSize(100, 75);
		btnN.setSize(100, 75);
		btnY.setLocation(width/2-200, height-200);
		btnN.setLocation(width/2+100, height-200);
		lb.setSize(400,50);
		lb.setLocation(width/2-200, height/10);
		lb.setBackground(Color.PINK);
		
		HandlerY hd1 = new HandlerY();
		btnY.addActionListener(hd1);
		btnN.addActionListener(hd1);

		Font f1 = new Font("myFont", 1, 20);
		btnY.setFont(f1);
		btnN.setFont(f1);
		lb.setFont(f1);

		
		
		setSize(width, height);
		setLocation(100, 100);
		setVisible(true);
	}
	public static void main(String[] args) {
		MyWin2 sw = new MyWin2("Chang");
	}
}

class HandlerY implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		System.out.println(cmd);
		if(cmd.equalsIgnoreCase("YES")) {
			System.out.println("yes ��ư ����");
		}else if(cmd.equals("NO")) {
			System.out.println("no ��ư ����");
		}
	}
}


