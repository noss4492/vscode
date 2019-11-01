package day15;

import java.util.Random;

public class ExceptionEx1 {
	public static void main(String[] args) {
		// 1. ERROR     : 치.명.적. 오류
		// 2. EXCEPTION : 가벼운 오류
			// 1. 예외 처리
			// 2. 예외 전가
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
				System.out.print("성공\n");
			}catch (ArithmeticException ae) {
				System.out.println("0으로 나누기 ㄴㄴ해");
				ae.printStackTrace();
			}catch (Exception e) {
				System.out.println("나도 몰라~");
			}
		
		
		// Exception은 모든 SubException의 조상
		// (ArithmeticException ae) 부모로 써도 되지>>(Exception e)
		// printStackTrace

	}
}
