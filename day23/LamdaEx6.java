package day23;

import java.util.ArrayList;

//제네릭도 지원함!

//@FunctionalInterface
//interface MathUtil{
//	int cal(int a, int b);
//}

@FunctionalInterface
interface MathUtil<T> {
	T cal(T a, T b);
}

public class LamdaEx6 {
	public static void main(String[] args) {
		// 별로인 애 주석함
//		MathUtil mu;
//		mu = (a, b) -> {return (a + b);};
//		System.out.println(mu.cal(100, 200));
//		System.out.println("--------------");

		MathUtil<String> mus;
//		mus = (a, b) -> { return (a + b); };
		mus = (a, b) -> a + b;	// 극단적으로 축약해놨는걸;;
		System.out.println(mus.cal("푸른하늘", "은하수")); // 푸른하늘+은하수
		
		MathUtil<Integer> mui;
		mui = (a,b) -> a+b;
		System.out.println(mui.cal(20, 30));
		
		MathUtil<Float> muf;
		muf = (a,b) -> a+b;
		System.out.println(muf.cal(0.24f, 0.36f));
		
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		for(int i = 0; i < 10; i ++)
			a.add(i);
		// a { 0 ~ 9 }
		MathUtil<ArrayList<Integer>> muAl;
	}
}
