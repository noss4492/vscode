package day18;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Question {
	public static void main(String[] args) throws IOException {
		// 1~2. String �о file1�� ���� �� file2�� �����Ͽ� �����ϱ�
		String str = "Hello noss World �ѱ��ѱ�";	//�ѱ� ������

		File f1 = new File("z:\\Test.txt");
		File f2 = new File("z:\\Test2.txt");
		FileOutputStream fos1 = new FileOutputStream(f1); // to write f1
		FileInputStream fis1 = new FileInputStream(f1); // to read f1
		FileOutputStream fos2 = new FileOutputStream(f2); // to write f2

		System.out.println("fos1 FD : "+fos1.getFD()+" fos1 Ch : "+fos1.getChannel());
		System.out.println("fis1 FD : "+fis1.getFD()+"  fis1 Ch : "+fis1.getChannel());
		System.out.println("fos2 FD : "+fos2.getFD()+" fos2 Ch : "+fos2.getChannel());
		
		byte[] b = str.getBytes();	//�̷��� �־���?

		int value = 0; 
		while (value < str.length())
			fos1.write((byte)str.charAt(value++));
		System.out.println("�� �� �� ��");

		value = 0;
		while ((value = fis1.read()) != -1)
			fos2.write(value);
		System.out.println("�� �� �� ��");

	}
}


//		char[] strArr = str.toCharArray();
//		while (value < strArr.length) {
//			fos1.write(strArr[value++]);