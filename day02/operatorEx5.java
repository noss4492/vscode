package day02;
//��Ʈ������' 3' (&, |, ^(xor), ~(not))
//boolean type : true, false  (������ 1, 0)
//
public class operatorEx5 {
	public static void main(String[] args) {
		byte a = 10; //  1010
		byte b = 20; //1 0100
		
		System.out.println("������"+ (a&b));
		System.out.println("������"+ (a|b));
		System.out.println("������"+ (a^b));
		System.out.println("������"+ ~a+"�÷�"+~b);	//0000 1010 -> 1111 0101    
													//1111 1111 - 1111 0101 = 1010
													// -10 -1 -> -11
		
		// 13 8 5   0000 1101
		// 17 16 1  0001 0001
		// 29       0001 1101
		
		
		// ��Ʈ�� ������ ���� �� �ʿ䰡
		
		boolean x1 = true;
		boolean x2 = false;
		System.out.println(x1&x2);
		System.out.println(x1|x2);

	}
}
