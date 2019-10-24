package day09hw;

public class Homework {
	public static void main(String[] args) {
		Computer c = new Computer();
		PDA p = new PDA();
		
		c.printInfo();	// 이 두 메소드는 인터페이스를 통해 메소드 오버라이딩해서
		p.printInfo();  // 추상메소드화 하면 하나처럼 쓸 수 있음.
		
		System.out.println("\n\n");
		p.callPDA();
		p.powerButton();// 전원버튼은 꺼져있으면 켜지고 켜져있으면 꺼지게 한다.
//		p.comOff();
//		p.comOn();
		p.internetAccessOn();
		p.printInfo();
		
		p.powerButton();
		
	}
}

/*
Hw01.
	Q. 
	class 의 구성요소 3가지에 대해 설명하세요\
	
	A.
	member field(variable, constant)
	member method
	constructor

Hw02.
	Q.
	this, this(), super, super() ???? 
	
	A.
	this는 현재 클래스를 지칭하는 표현(참조변수)
	this()는 현재 클래스의 생성자를 지칭
	super은 부모 클래스를 지칭하는 표현
	super()는 부모 클래스의 생성자를 지칭

Hw03.
	변수명명법과 자바에서 관습적으로 이름을 지정하는 규칙은? 
	클래스명  : 맨앞 영어 대문자, 단어구분은 공백대신 단어 첫 글자 영어대문자 (파스칼케이싱)
	ex.QuickSort
	생성자명  : 클래스명과 동일, ()로 생성자임을 앎
	ex.QuickSort()
	변수명     : 맨앞 영어 소문자, 단어구분법은 위와 상동 (카멜케이싱)
	ex.maxIndexNum
	상수명     : 대문자, 공백 구분은
	ex.INPUT_WIDTH_SIZE
	메서드명  : 맨앞 영어 소문자, 단어 구분은 단어 첫 글자 영어 대문자
	ex.partitionAtoB
	패키지명  : 영어소문자
	ex.day09, io, scanner....
	
Hw04. 

	코드1을 수정하여 다양한 생성자를 추가해봅니다.

코드1)
public class HandPhone{
	String productName;
	String productType;
	int price;
	String phoneNumber;
	
}
Hw05. Computer 객체를 생성할수 있는 클래스를 작성하세요 
	기능 : 켜기(), 끄기()
	
Hw06. Computer 객체를 상속받는 PDA 클래스를 작성하세요 

	PDA p = PDA();

	p.전화하기();
	p.연결하기();
*/