package day23;

// 두개의 파라미터와 리턴값이 없는 경우

interface Calculator3 {
	void cal(int a, int b);
}

public class LamdaEx3 {
	public static void main(String[] args) {
		Calculator3 c3;
		c3 = (a, b) -> {System.out.println("-------");
						System.out.println((a+b));};	
		c3.cal(4, 3);
		System.out.println("c3:"+c3);

		
		// 한줄이면 brace 생략 가능
		c3 = (a, b) -> System.out.println((a-b));
		c3.cal(4, 3);
		System.out.println("c3:"+c3);
	}
}
