package day18;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Question {
	public static void main(String[] args) throws IOException {
		// 1~2. String 읽어서 file1에 저장 후 file2에 복사하여 저장하기
		String str = "Hello noss World 한글한글";	//한글 깨지네

		File f1 = new File("z:\\Test.txt");
		File f2 = new File("z:\\Test2.txt");
		FileOutputStream fos1 = new FileOutputStream(f1); // to write f1
		FileInputStream fis1 = new FileInputStream(f1); // to read f1
		FileOutputStream fos2 = new FileOutputStream(f2); // to write f2

		System.out.println("fos1 FD : "+fos1.getFD()+" fos1 Ch : "+fos1.getChannel());
		System.out.println("fis1 FD : "+fis1.getFD()+"  fis1 Ch : "+fis1.getChannel());
		System.out.println("fos2 FD : "+fos2.getFD()+" fos2 Ch : "+fos2.getChannel());
		
		byte[] b = str.getBytes();	//이런게 있었어?

		int value = 0; 
		while (value < str.length())
			fos1.write((byte)str.charAt(value++));
		System.out.println("생 성 완 료");

		value = 0;
		while ((value = fis1.read()) != -1)
			fos2.write(value);
		System.out.println("복 사 완 료");

	}
}


//		char[] strArr = str.toCharArray();
//		while (value < strArr.length) {
//			fos1.write(strArr[value++]);