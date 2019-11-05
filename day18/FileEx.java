package day18;

import java.io.File;
import java.io.IOException;

public class FileEx {
	public static void main(String[] args) throws IOException {
		// I/O ���� Ŭ����
		// File f = new file();

		String str = new String("z:\\HelloIO.java");
		System.out.println(str);
		System.out.println("=================");
//		File f = new File("z:\\HelloIO.java");
		File f = new File(str);

		System.out.print("�����ִ�?" + f.exists());
		System.out.println(f.exists() ? " �־�" : " ����");

		if (!f.exists()) {
			// ����
			// ��а� �������� ���ؼ� ���ܴ� ������
			f.createNewFile();
			System.out.println("������ �����մϴ�.");
		} else {
			System.out.println("������ �̹� ����");
		}
		System.out.println("=================");

		String path = f.getAbsolutePath();
		System.out.println("���� ������ : " + path);

		if (f.isFile()) {
			System.out.println("������");
		}
		if (f.isDirectory()) {
			System.out.println("������");
		}
		
		String str2 = new String("z:\\eclipse");
		File f2 = new File(str2);
		
		if(f2.isDirectory()) {
			System.out.println(str2+"�� ���丮�� �¾ƿ�!\n ���丮 �� ���ϸ��");
			// ���� ���丮�� ���ϸ���� �迭�� ����
			String[] list = f2.list();
			for(String x : list)
				System.out.println(x);
		}
		
		
		
	}// main method end
	
	
	
}

//			try {
//				f.createNewFile();
//			} catch (IOException e) {	// ���� ���ɼ� 1. ��� �߸���
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}