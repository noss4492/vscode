package day23;
// 람다식 ==> 메서드(함수)를 하나의 식으로 표현한 것



interface Oper{
	public int addOne(int a);
}

public class LamdaEx1 {
	// 그립습니다 제임스 고슬링..
	// 익명 중첩 클래스 -> 간결하게 표현 가능
	public static void main(String[] args) {
		Oper add = new Oper() {
			@Override
			public int addOne(int a) {
				return ++a;
			}
		};	//익명 inner Class
		
		System.out.println(add.addOne(10));
		System.out.println("--------------------------");
		
		Oper add2 = (a) -> ++a;
		System.out.println(add2.addOne(10));
		System.out.println("--------------------------");
		
	}
}
