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
		
		//�ʱ�ȭ ���ϸ� �� �� ��.��
		Dog g = null;
		System.out.println(g);
		g.eatting();
//Exception in thread "main" java.lang.NullPointerException
//at day11.TestMain1.main(TestMain1.java:19)
		
		// ��ü�� ������ �������� null�̱� ������ �Ͼ�� ����(����ó������)�ε�.
	//	new g();
	}
}
