package day13;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
1. �̺�Ʈ �ҽ��� ���� : btn
2. �̺�Ʈ �ҽ��� �����⸦ ���� : �׼Ǹ�����
3. �ڵ鷯�� ����
 */


public class MyWin1 extends Frame {
	Button btn;
	MyWin1(String title){
		super(title);
		btn = new Button("Ŭ����boa");
		add(btn);
		
		Handler hd = new Handler();
		btn.addActionListener(hd);
//		btn.addActionListener(l); (ActionListener ������ü)
//		ActionListener al;
		
		setSize(300, 300);
		setLocation(300, 300);
		// (setLocation) width-(vx), height+vy)
		setVisible(true);
	}
	public static void main(String[] args) {
		MyWin1 sw = new MyWin1("â");
	}
}
// �ڹ��� ���Ͽ��� ���� (~~.java) ==> 1���� Ŭ������ ����
// ���������� �ΰ� �̻��� Ŭ������ ������ ���� ����.
// �׷����� �ݵ�� public class�� 1����. (������ ����)

class Handler implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("��ư ����");
	}
}






