package day18;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// �� �ѱ� ������? ����� �о��µ�?
// FileReaderŬ������ �о���̴� ���Ͽ� ���� ���ڵ� ���� ���� �����ε�?
// BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filepath),"UTF8"));
// FIleReaderŬ������ �о���̴� ������ ���ڵ��� ������ file.encoding���� ������ ������ �߱� ����

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
