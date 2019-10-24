package day10_3;
// 3. 추상화 : 구체적인 사실들을 일반화 시켜 기술한 것
// Object : 사물, class : 설계도, abstract : 조감도
// 추상 클래스
// 추상메서드는 미구현 메서드이고, 이런 메서드를 1개라도
// 가지고 있는 클래스는 반드시 추상 클래스여야 한다.

// 우클 - 소스 제너레이터로 자동 생성 가능함 개이득
public class AnimalTest {
	public static void main(String[] args) {
		Rabbit r = new Rabbit();
		Dog d = new Dog();
		Whale w = new Whale();
		
		r.eatting();
		r.sleeping();
		r.jumping();
		System.out.println("-----------------");
		d.eatting();
		d.sleeping();
		d.running();
		System.out.println("-----------------");
		w.eatting();
		w.sleeping();
		w.swimming();
		
		System.out.println("-----------------");
		
		// 상속 목적으로 개념상 존재하는 클래스
		// 실제 인스턴스화 되는 문제가 발생
		// (Class 포유류 이런거 만들었으면 말이지)
	
		//Animal a = new Animal();	// abstract 클래스는 인스턴스화(실체화)가 불가능.
		//a.eatting();
		
		
		Horse h1 = new Horse();
		h1.eatting();
		h1.sleeping();
		h1.running();
		
	}
	

}
