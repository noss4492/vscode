package day18;
// Wa! I/O! Wa! Java�߱�!
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.stream.FileImageInputStream;

public class IOEx1 {
	public static void main(String[] args) throws IOException{
		// InputStream : System.in : Ű����
		// �� ������ ascii
//		int value0 = System.in.read();
		
		File f = new File("z:\\Hello.java");
		FileInputStream fis = new FileInputStream(f);
		
		//InputStream�� �߻�޼��� read�� override��
		int value = fis.read();	// ���Ͽ� �����ؼ� 1����Ʈ �о�°�
		char ch = (char)value;	// ������ ��Ƽ� ����ȯ
		System.out.print(ch);	//package�� p
		
		// descriptor -> file descriptor
		
		
		
		// FileInputStream�� read() EOF�� ������ -1�� ������
		value = 0;
		
		while((value = fis.read()) != -1){	// fis.read()�� EOF�� �ƴϸ�
			System.out.print((char)value);
		}
		
		
	}
}
