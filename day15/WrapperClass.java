package day15;

import java.util.ArrayList;

public class WrapperClass {
	public static void main(String[] args) {
		int a = 10;
		//Boolean Byte Integer Character ...
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Float.MAX_VALUE);
		int b = Integer.MAX_VALUE;
		int cnt=0;
		for(int i = 0; ; i++) {
			b = b / 2;
			cnt++;
			if(b<=1)
				break;
		}
		System.out.println(cnt);
		
		
		Integer it1 = new Integer(10);
		Integer it2 = new Integer(20);
		String str1 = new String("java");
// ����� �������ϱ� �� �̷��� �����ϰ� �� 
//		Integer it1 = 10;
//		Integer it2 = 20;
//		String str1 = "java";
//		int d = it2.intValue();
//      int d = it2; <<- �䷱���� ��.
		
		Integer it3 = 30; // boxing
		int d = it3;	  // unboxing
		// autoboxing
		
		
		long bb = it1.longValue();
		
		// ������ȯ
		Integer.toBinaryString(10);
		
		int c = Integer.parseInt("300");
		System.out.println(++c);
		
		// byte127 => long�� ������ �ٲٰ� ��
// fm
		byte q = 127;
		Byte qq = new Byte((byte)127);
		long qqq = qq.longValue();
		
// nomal
		Byte e = 127;
		long f = e.longValue();
		System.out.println(f);
		
		
		baseN(15, 2);
	}
	
	static ArrayList<Integer> n = new ArrayList<Integer>();
	static int cnt = 0;
	static void baseN(int N, int b) {
		
		int M = N%2;
//		n.add(cnt++, M);
		System.out.println(M);
		if(N>0)
			baseN(N/2, b);
	}

}
