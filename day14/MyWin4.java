package day14;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyWin4 extends Frame{// implements WindowListener
	MyWin4(){
		super("종료가능창");
		
		
		
		// 1.
//		HandleAdapter ha = new HandleAdapter();
//		WindowAdapter wa = ha;	//wa가 부모니까 되지 ㅇㅇ
		
		// 2.
		//Parent p = new Child();
//		WindowAdapter wa = new HandleAdapter();	// 한번쓰고 버려질 핸들 어댑터
		/*
		WindowAdapter wa = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}
		addWindowListener(wa);
		*/
		
		// 3. 살짝 예전 시절 스타일? 그래도 이해는 하고 가자
		// 이런게 있다고 함 ....  흠... ?  ㅅ? ??ㅅ???
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		
		//추상클래스니까 실체화불가능, WindowListener interface를 구현한애였음
		
		// 왜 이렇게 하고 있는가?
		// WindowListener가 가지고 있는 메서드가 너무 많음
		// 근데 오버라이드해서 사용하라고 되어 있어서 불편함
		// 예전에는 윈도우어댑터라는 클래스로 우회하여 편법으로 사용하였음.
		
		setBounds(100, 100, 300, 300);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		MyWin4 mw = new MyWin4();
	}
}

	/*
	 *  밑에 이거 쓰기 귀찮은데 어떻게 해결했지?
	 *  사람들이 만듬 -> Class WindowAdapter -> 이제는 이클립스 자동 제너레이터 있음.
	 */
	

	/* 오버라이드 주절주절 메소드들*/

//class HandleAdapter extends WindowAdapter{
//	@Override
//	public void windowClosing(WindowEvent e) {
//		System.exit(0);
//	}
//}