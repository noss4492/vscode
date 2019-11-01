package day15;

import java.util.regex.Pattern;

public class ExceptionEx2 {
	public static void main(String[] args) {
		String a = "" + 10;
		String b = "d" + 20;
		int result = 0;
		
//		p = "[^9-0$]";
		
		try {
			result = sPlus(a, b);
		}catch(NumberFormatException nfe) {
			//String pattern = "(^[0-9]$)";
			//Pattern.matches(pattern, ""+result);
			
			System.out.println("�߸��� ���� ������");
		}
		System.out.printf("a + b = [%3d]\n", result);

		
		
		
		
//		int gcd = GCD(20, 15);
//		System.out.println(gcd);
	}

	public static int plus(int a, int b) {
		return a + b;
	}
	// ���� ����� �޼ҵ带 ���� ��Ȳ�� �°� �ۼ��϶�� ����ó���� �������ѳ��� ��
	public static int sPlus(String a, String b) throws NumberFormatException{
//		return Integer.valueOf(a) + Integer.valueOf(b);
		return Integer.parseInt(a) + Integer.parseInt(b);
	}

	public static int GCD(int a, int b) {
		// 20 12 -> 20*12 -> 12*12 -> 8*8 -> 4*8 | 4*4 4*4 -> GCD is 4
		// 20 7 -> (20-14) -> 7 6 -> 6 1 -> 1 1 -> GCD is 1
		if (a < b) { // set a is bigger
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		if (b >= 1) {
			int c = a / b;
			a = a - b * c;
			GCD(b, a);
		}
		return a;
	}
}
