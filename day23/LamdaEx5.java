package day23;
// 그렇다면 Merge 인터페이스가 처음부터 람다식을 쓸 수 있는 인터페이스
// 라는 것을 처음 부터 정의할 수 없을까?
@FunctionalInterface //기능적 인터페이스(특정한 기능을 하는 인터페이스)
interface Merge {
	public int add(int a, int b);
	// 람다식을 위한 인터페이스에서 추상 메서드 단 하나여야 한다.
}

public class LamdaEx5 {
	public static void main(String[] args) {
		Merge m;
		
		//1
		m = new Merge() {
			@Override
			public int add(int a, int b) {
				return a+b;
			}
		};
		//2
		m = (a, b) -> {return a + b;};
		//3
		m = (a, b) -> a+b;

		
		System.out.println(m.add(100, 200));

	}
}
