package day15;

import java.util.Random;

public class ExceptionEx1 {
	public static void main(String[] args) {
		// 1. ERROR     : ġ.��.��. ����
		// 2. EXCEPTION : ������ ����
			// 1. ���� ó��
			// 2. ���� ����
		Random rnd = new Random();
		int a = 100;
		
//Class Throwable
//(direct subclass : Error, Exception)
/*
java.lang.Object
java.lang.Throwable
java.lang.Exception
java.lang.RuntimeException
java.lang.ArithmeticException
*/
		
		for(int i = 0; i < 20; i++)
			try {
				System.out.printf("%4d", a/rnd.nextInt(10));
				System.out.print("����\n");
			}catch (ArithmeticException ae) {
				System.out.println("0���� ������ ������");
				ae.printStackTrace();
			}catch (Exception e) {
				System.out.println("���� ����~");
			}
		
		
		// Exception�� ��� SubException�� ����
		// (ArithmeticException ae) �θ�� �ᵵ ����>>(Exception e)
		// printStackTrace

	}
}
