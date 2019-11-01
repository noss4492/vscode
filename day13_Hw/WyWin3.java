package day13_Hw;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WyWin3 extends Frame implements ActionListener, WindowListener{
	Button btn;
	Button btnExit;
	WyWin3(String title){
		super(title);
		setLayout(null);
		
		btn = new Button("OK");
		add(btn);
		
		
		this.addWindowListener(this);
		// �� Ŭ������ ActionListener �������̽��� ������ ��ü ���
		// �Ű������� ���� ����
		btn.addActionListener(this); // l �׼Ǹ����� �������̽��� ������ü ����.
		
		
		//WindowListener
		btnExit = new Button("Exit");
		btnExit.setSize(30,30);
		btnExit.setLocation(100,100);
		btnExit.addActionListener(this);
		add(btnExit);
		
		setSize(300, 300);
		setLocation(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		WyWin3 sw = new WyWin3("â");
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("â�� Ȱ��ȭ �Ǿ��� �� ȣ��");
	}

	@Override
	public void windowClosed(WindowEvent e) {	// �ٸ� ���α׷��� �Ѱ��� ��
		// TODO Auto-generated method stub
		System.out.println("â�� ������ ���� ȣ��");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("â�� �������� �� ȣ��");
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("â�� ��Ȱ��ȭ �Ǿ��� �� ȣ��");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("â�� �������ȭ �Ǿ��� �� ȣ��");
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("â�� ������ȭ �Ǿ��� �� ȣ��");
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("â�� ������ ȣ��");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("�� ư �� �� actionPerformed");
		String cmd = e.getActionCommand();
		if(cmd.equalsIgnoreCase("exit")) {
			System.out.println("��ư ����");
			System.exit(0);	
		}
	}
	
	
	
}


