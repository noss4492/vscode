package day18;
// 인풋스트림리더 아웃풋스트림라이터

import java.io.IOException;

public class IOEx8 {
	// 1. System.in.read()
	// 2. Scanner
	
	public static void main(String[] args) throws IOException {
		System.out.println("입력해요 : (종료 ctrl+z)");
		
		int value=0;
		while( (value = System.in.read()) != -1) {
			System.out.print((char)value);
		}
	}
	
	
	// 키보드로부터 입력받은 값을 화면에 출력
}
