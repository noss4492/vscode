package day08;

public class testCarMain {

	public static void main(String[] args) {
		Car c;
		// 참조 
		// new : 객체할당 연산자 
		c = new Car();
		// 메모리에 할당된 객체 : instance (실제로 존재하는 애)
		// 하나의 클래스로부터 여러개의 인스턴스를 생성할 수 있다.
		
		// class는 설계도 object는 찍어낸 애(실체화된 애, (메모리에 할당된)인스턴스된 애)
		
		c.전진();
		c.정지();
		
		System.out.println("c : "+c);
		//변수에 접근
		// day08.Car@15db9742

		System.out.println(c.제조사);
		// dot 연산자
		// 참조값 보고 찾아감 (가르키고 있는 메모리에 가서 제조사 변수에 접근)
		// 
		
		System.out.println(c.바퀴);
		
		// c 4byte(스택)
		// new로 힙에 할당
		// 힙(int a int b .. String aa .. method1() .. )
		
		
		Car myCar;
		myCar = new Car();
		myCar.차종 = "붕붕";
		myCar.속도 = 30;	//최대속도?
		
		Car myCar2 = new Car();
		myCar2.차종 = "Porsche";
		myCar2.속도 = 300;
		
		
	}
}
