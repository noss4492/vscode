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
		// 내 클래스가 ActionListener 인터페이스를 구현한 객체 라면
		// 매개변수로 전달 가능
		btn.addActionListener(this); // l 액션리스너 인터페이스의 구현객체 였음.
		
		
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
		WyWin3 sw = new WyWin3("창");
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("창이 활성화 되었을 때 호출");
	}

	@Override
	public void windowClosed(WindowEvent e) {	// 다른 프로그램에 넘겨줄 때
		// TODO Auto-generated method stub
		System.out.println("창이 닫히고 나서 호출");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("창이 종료중일 때 호출");
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("창이 비활성화 되었을 때 호출");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("창이 비아이콘화 되었을 때 호추");
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("창이 아이콘화 되었을 때 호출");
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("창이 열릴때 호출");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("버 튼 눌 림 actionPerformed");
		String cmd = e.getActionCommand();
		if(cmd.equalsIgnoreCase("exit")) {
			System.out.println("버튼 눌림");
			System.exit(0);	
		}
	}
	
	
	
}


