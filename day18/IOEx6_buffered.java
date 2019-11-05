package day18;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOEx6_buffered {
	public static void main(String[] args) throws IOException {
		File f = new File("z:\\hello.java");
		File f2 = new File("z:\\hello4.java");
		FileInputStream fis = new FileInputStream(f);
		FileOutputStream fos = new FileOutputStream(f2);

		// 밑에 라인 생성자에 InputStream in 이 인자로 오는데 왜 그러냐면
		// InputStream객체 또는 후손 객체 (InputStream을 구현한 자손 객체)
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		// 이러면 bis 객체로 두가지 기능을 다 쓸 수 있음. 권총(+모듈식) 이라는 비유가 있었음
		// bis : buffer + file접근 기능 둘 다
		
		int value = 0;
		while((value = bis.read()) != -1) {
			bos.write(value);
			System.out.print((char)value);
		}
		// 버퍼가 가득 차면 쑉 밀어서 저장해주곤 하는데 아직 너무 적으니까...
		// 아직 버퍼에 있을 뿐 디스크에 밀어주진 않음
		bos.flush();
		
	}
}
