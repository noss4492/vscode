package day03;
//import java.util.Scanner;
import java.io.IOException;



public class statementEx5_2 {
//	
//	static void stdIn() {
//		//Scanner stdIn = new Scanner(System.in);
//		//String n = stdIn.nextLine; //공백 포함 한 라인
//	}

	public static void main(String[] args)throws IOException{
		// 사용자로부터 값을 입력받아 값을 출력
		System.out.print("입룍 몇돤? :");
		/// 표준입력장치로 부터 값을 입력받아 가져오기
		int dan = System.in.read();
		
		dan -= 48;	//0x30 0x41 0x61
		System.out.println("사용자가 입력한 값 "+dan);
		
		for(int i = 1; i<=9; i++) {
			System.out.println(dan+"*"+i+"=\t"+dan*i);
		}
	}
}
