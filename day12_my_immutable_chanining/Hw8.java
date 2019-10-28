package day12_my_immutable_chanining;

import java.awt.Frame;

public class Hw8 extends Frame{
	
	Hw8(){
		this.setTitle("Hello AWT World");
		this.setSize(800, 600);
		this.setLocation(50, 50);
		setVisible(true);
	}
	public static void main(String[] args) {
		Hw8 mw3 = new Hw8();
	}
}


/*
8. 
	창의 크기 800,600 
	위치 : 50,50
	타이트부여(Hello AWT World) 

9. 
	창크기 : 800,600
	위치 : 100,100
	타이틀 : 배치관리자테스트
	
	FlowLayout을 사용하여 화면에
	버튼 50개를 생성하여 창에 부착 	
*/