package day10_3;

import day11.Flyable;

public class Horse extends Mammal implements Flyable{	//Flyable ��� �ް� ���� -> ����? -> ����å
	int footgoop;
	
	public Horse(){
		super();
	}
	
	@Override
	public void eatting() {
		System.out.println("��ٸӰ�");
	}
	public void running() {
		System.out.println("�ٱ��� �ٱ���");
	}

	@Override
	public void flying() {
		System.out.println("����?");
	}
	
	
}
