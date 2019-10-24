package Day08HWpreview;

public class ZooKeeper {
//	public static void feed(Tiger t) {
//		System.out.println("feed poo");
//	}
//	public static void feed(Lion l) {
//		System.out.println("feed won");
//	}
	// 새로운 포식자들이 추가될 때 마다 이러한 feed를 계속 추가해줘야하는 불편함이 있음.
	// 그래서 나온 것이 인터페이스이다.
// 인터페이스로 변경 후 (각자 implements Pradator하였고 인터페이스 Pradator를 추가하였음)
	
	/*
	public static void feed(Predator p) {
		System.out.println("feed meat");
	}*/
	
	// 첨에 만들때 Tiger Lion은 Animal 클래스를 상속받아 만들어진 자식 Class였다.
	// 각각 Tiger Lion은 Predator 인터페이스의 객체로 들어가게 된다.
	// 이렇게 객체가 한 개 이상의 자료형 타입을 갖게 되는 특성을 타형성(polymorphism)
	
	// 이제 어떤 육식동물이 추가되던 feed메소드를 추가하는 대신 추가하는 육식동물의 클래스를 Predator 인터페이스를 implement(시행하다, 도구<<)
	
	// 생각이지만 클래스의 구현은 인터페이스를 기준으로 중요 클래스를 작성하여야함. 구현체는 다중 상속이 지원되지 않지만(되는 파이썬은 우선순위를 정해줌)
	// 자바의 경우에는 interface만 다중상속을 지원하기 때문에...
	
	
	//다시 변경되어
	public static void feed(Predator p) {
		System.out.println("feed "+p.getFood());
	}
	
	
	public static void main(String[] args) {
		ZooKeeper zk = new ZooKeeper();
		Tiger t = new Tiger();
		Lion l = new Lion();
		
		ZooKeeper.feed(t);
		ZooKeeper.feed(l);
		
	}
	

}
