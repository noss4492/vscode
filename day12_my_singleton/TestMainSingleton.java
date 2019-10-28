package day12_my_singleton;

public class TestMainSingleton {
	public static void main(String[] args) {
		Normal n1 = new Normal();
		Normal n2 = new Normal();
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		
		if(n1 == n2)
			System.out.println("n1 == n2");
		else
			System.out.println("n1 != n2");
		
		if(s1 == s2)
			System.out.println("s1 == s2");
		else
			System.out.println("s1 != s2");
		
// 싱글톤 사용 목적
// 1. 고정된 메모리 영역을 사용하도록 단 한번 new 연산자로 인스턴스를 얻어온다. (메모리 낭비 줄임)
// 2. 전역변수로 선언되고 전역메서드로 호출하기 때문에 다른 클래스에서 사용하기 쉬움. (편의성)
// 3. 공통된 객체를 사용하여야 하는 코딩에서 매번 객체를 생성하지 않고 같은 객체를 사용하도록 함 (성능 좋음)
		
// 싱글톤 만드는 방법
// 1. private 생성자로 new 실행 금지
// 2. 유일한 단일 객체 반환을 위해 정적 메소드
// 3. 유일한 단일 객체를 참조할 정적 참조변수
	}
}
