package day10_3;

public abstract class Mammal {
	int eye, nose, mouth, ear, tail;
	String varity;
	Mammal(){
		this.eye = 2;
		this.nose = 1;
		this.mouth = 1;
		this.ear = 2;
		this.tail = 1;
		this.varity = "";
	}
	
	// 미구현 메서드
	// 추상 메서드 : 메서드 구현부가 없는 메서드
	public abstract void eatting();
	
	public void sleeping() {
		System.out.println("mammal sleep");
	}

}
