package day18;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOEx2{
	public static void main(String[] args) throws IOException{
		byte[] b = {'j','a','v','a'};
		
		File f = new File("z:\\javaout.txt");
		
		// �ڹٿ��� �ܺη� �������� ���� Ŭ����
		// OutputStream
		int value;
		
		FileOutputStream fos = new FileOutputStream(f, true);
		
		fos.write(b);
		
	}
}
