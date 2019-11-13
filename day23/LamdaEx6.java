package day23;

import java.util.ArrayList;

//���׸��� ������!

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
		// ������ �� �ּ���
//		MathUtil mu;
//		mu = (a, b) -> {return (a + b);};
//		System.out.println(mu.cal(100, 200));
//		System.out.println("--------------");

		MathUtil<String> mus;
//		mus = (a, b) -> { return (a + b); };
		mus = (a, b) -> a + b;	// �ش������� ����س��°�;;
		System.out.println(mus.cal("Ǫ���ϴ�", "���ϼ�")); // Ǫ���ϴ�+���ϼ�
		
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
