package day18;
// Wa! I/O! Wa! Java중급!
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.stream.FileImageInputStream;

public class IOEx1 {
	public static void main(String[] args) throws IOException{
		// InputStream : System.in : 키보드
		// 한 글자의 ascii
//		int value0 = System.in.read();
		
		File f = new File("z:\\Hello.java");
		FileInputStream fis = new FileInputStream(f);
		
		//InputStream의 추상메서드 read를 override된
		int value = fis.read();	// 파일에 접근해서 1바이트 읽어온걸
		char ch = (char)value;	// 변수에 담아서 형변환
		System.out.print(ch);	//package의 p
		
		// descriptor -> file descriptor
		
		
		
		// FileInputStream의 read() EOF를 만나면 -1을 리턴함
		value = 0;
		
		while((value = fis.read()) != -1){	// fis.read()가 EOF가 아니면
			System.out.print((char)value);
		}
		
		
	}
}
