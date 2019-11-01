package day13;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
1. 이벤트 소스를 결정 : btn
2. 이벤트 소스에 감지기를 부착 : 액션리스터
3. 핸들러를 정의
 */


public class MyWin1 extends Frame {
	Button btn;
	MyWin1(String title){
		super(title);
		btn = new Button("클릭해boa");
		add(btn);
		
		Handler hd = new Handler();
		btn.addActionListener(hd);
//		btn.addActionListener(l); (ActionListener 구현객체)
//		ActionListener al;
		
		setSize(300, 300);
		setLocation(300, 300);
		// (setLocation) width-(vx), height+vy)
		setVisible(true);
	}
	public static void main(String[] args) {
		MyWin1 sw = new MyWin1("창");
	}
}
// 자바의 파일에는 보통 (~~.java) ==> 1개의 클래스만 정의
// 예외적으로 두개 이상의 클래스를 정의할 수도 있음.
// 그렇지만 반드시 public class는 1개만. (주인장 존중)

class Handler implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼 눌림");
	}
}






