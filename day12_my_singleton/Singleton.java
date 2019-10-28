package day12_my_singleton;

public class Singleton {
	private static Singleton singleton = new Singleton();
	// new 연산자로 인스턴스 생성이 불가능해졌음 T.T
	// 그래서 위에서 정적으로 싱글톤 클래스 객체를 선언함.
	private Singleton() {	// private 생성자(오우 특이한데?) -> new 연산자 X 
		System.out.println("Singleton Instance Created.. ");
	}
	public static Singleton getInstance() {
		return singleton;
	}
}
