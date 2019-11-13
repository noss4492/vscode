package day23;

// 두개의 파라미터와 리턴값이 없는 경우

interface Printable {
	void print(String msg);
//	void printAll(String msg);
}

public class LamdaEx4 {
	public static void main(String[] args) {
		Printable p;
		
		p = (String s) -> {
			System.out.println(s);
		};
		
		p.print("람다 표현식 1번");
		System.out.println("----------------");
		// {} 문장이 1개라면 {} 생략 가능 ㅇㅇ
		// 대신 리턴값이 없을때만 가능함요
		
		p = (String s) -> System.out.println(s);
		p.print("람다 표현식 2번");
		System.out.println("----------------");
		
		// 매개변수의 정보가 있어서 타입을 유추(추론) 할 수 있다.
		// 자료형을 생략 가능
		p = (s) -> System.out.println(s);
		p.print("람다 표현식 3번");
		System.out.println("----------------");
		
		// 매개변수가 1개만 존재한다면 () 생략 할 수 있음
		p = s -> System.out.println(s);
		p.print("람다 표현식 4번");
		System.out.println("----------------");
		
		
	}
}
