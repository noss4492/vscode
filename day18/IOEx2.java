package day18;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOEx2{
	public static void main(String[] args) throws IOException{
		byte[] b = {'j','a','v','a'};
		
		File f = new File("z:\\javaout.txt");
		
		// 자바에서 외부로 내보내기 전용 클래스
		// OutputStream
		int value;
		
		FileOutputStream fos = new FileOutputStream(f, true);
		
		fos.write(b);
		
	}
}
