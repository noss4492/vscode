package day15;

import java.io.IOException;

// 예외 전가당하면 너가 처리해 ' 3';;;
// 메서드에 throws TT..

public class Exception3 {
	public static void main(String[] args) {// throws IOException {
		System.out.println("입력:");
		try {
			int value = System.in.read();
			System.out.println(value);
		}catch(IOException ie) {
			System.out.println("입력오류가 있나?@#!@#!$!#$");
			ie.printStackTrace();
		}finally {
			// I/O, network, db
			// 상관없이 마무리로 실행되는 애
			System.out.println("아무튼 난 출력됨");
		}
	}
}
