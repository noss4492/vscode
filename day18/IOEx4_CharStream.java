package day18;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// 왜 한글 깨지지? 제대로 읽었는데?
// FileReader클래스의 읽어들이는 파일에 대한 인코딩 설정 문제 때문인듯?
// BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filepath),"UTF8"));
// FIleReader클래스는 읽어들이는 파일의 인코딩을 무조건 file.encoding으로 간주해 읽으려 했기 때문

public class IOEx4_CharStream {
	public static void main(String[] args) throws IOException {
		File f = new File("z:\\Hello.java");
		FileReader fr = new FileReader(f);
		
//		int value = fr.read();
//		System.out.println(value);
		
		int value = 0;
		while((value = fr.read()) != -1) {
			System.out.printf("%c",(char)value);
		}
		
	}
}
