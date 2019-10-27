package day11;

import day10_3.Dog;

public class TestMain1 {
	public static void main(String[] args) {
		
		
//		int a;
//		Integer b = new Integer(null);
//		Dog g;
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(g);
		
		//초기화 안하면 못 써 ㅠ.ㅠ
		Dog g = null;
		System.out.println(g);
		g.eatting();
//Exception in thread "main" java.lang.NullPointerException
//at day11.TestMain1.main(TestMain1.java:19)
		
		// 객체를 참조할 참조값이 null이기 떄문에 일어나는 에러(예외처리해줌)인듯.
	//	new g();
	}
}
