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

		// �ؿ� ���� �����ڿ� InputStream in �� ���ڷ� ���µ� �� �׷��ĸ�
		// InputStream��ü �Ǵ� �ļ� ��ü (InputStream�� ������ �ڼ� ��ü)
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		// �̷��� bis ��ü�� �ΰ��� ����� �� �� �� ����. ����(+����) �̶�� ������ �־���
		// bis : buffer + file���� ��� �� ��
		
		int value = 0;
		while((value = bis.read()) != -1) {
			bos.write(value);
			System.out.print((char)value);
		}
		// ���۰� ���� ���� �� �о �������ְ� �ϴµ� ���� �ʹ� �����ϱ�...
		// ���� ���ۿ� ���� �� ��ũ�� �о����� ����
		bos.flush();
		
	}
}
