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
	â�� ũ�� 800,600 
	��ġ : 50,50
	Ÿ��Ʈ�ο�(Hello AWT World) 

9. 
	âũ�� : 800,600
	��ġ : 100,100
	Ÿ��Ʋ : ��ġ�������׽�Ʈ
	
	FlowLayout�� ����Ͽ� ȭ�鿡
	��ư 50���� �����Ͽ� â�� ���� 	
*/