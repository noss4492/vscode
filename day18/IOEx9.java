package day18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOEx9 {
	public static void main(String[] args) throws IOException {
		// 얘 System.in ==> byte 게열의 클래스임
		// byte -> char 바꿔주긔
		// 다리역할 잘 써보자

		InputStreamReader isr = new InputStreamReader(System.in);
		// 인자로 Inputstream 매개변수 ㅇㅇ

		BufferedReader br = new BufferedReader(isr);
		// 빠루게

		// 한글을 파일로 저장하려고함
		FileWriter fw = new FileWriter("z:\\ddd.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		

		String str = null;
		while( (str = br.readLine()) != null ) {	//끝이면 null
			bw.write(str+"\n");
			System.out.println(str);
		}
		bw.flush();
	}
}

//		System.out.println("입력하쇼");
//		String str = br.readLine();
//		System.out.println(str);