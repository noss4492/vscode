package day18_hw;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Hw5Plus3 {
	public static void main(String[] args) throws IOException {
		// system.in.read�� ������
		System.out.println("�Է����");
		System.out.println("EXIT : ctrl+z");

		File f9 = new File("z:\\hw4.txt");
		FileOutputStream fos = new FileOutputStream(f9);

		int value = 0;

		while ((value = System.in.read()) != -1) {
			if (value == 13) // ���� �÷�
				break;
			System.out.printf("��ȯ�� : [%c] ��ȯ�� : [%c]\n", value, value + 3);
			fos.write((char)(value + 3));
		}

	}
}
