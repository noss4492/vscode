package day11;

import day10_2.Marine;
import day10_3.Horse;

// 다중 상속 처리에 관하여
// 자바에서는 다중상속 받으면 같은 메서드 뭐야 이거 방지함
// 
public class TestMain2 {
	public static void main(String[] args) {
		Horse h1 = new Horse();
		Marine m1 = new Marine();
		
		
		h1.eatting();
		h1.flying();
		
		m1.flying();
		System.out.println("------------------");
		
		Flyable f1;		// 인터페이스도 부모 역할이 가능. (그러네 그루네 하이라이컬 상위)
		f1 = h1;
		f1.flying();
		f1 = m1;
		m1.flying();
		// 다형성
		// 동일한 조작방법으로 동작시키지만
		// 대상에 따라 다른 실행하게 하는 것
		
		/*
		 * Encapsulation
		 * Inheritance
		 * Abstraction
		 * Polymorphism
		 */
	}
}
