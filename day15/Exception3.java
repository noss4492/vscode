package day15;

import java.io.IOException;

// ���� �������ϸ� �ʰ� ó���� ' 3';;;
// �޼��忡 throws TT..

public class Exception3 {
	public static void main(String[] args) {// throws IOException {
		System.out.println("�Է�:");
		try {
			int value = System.in.read();
			System.out.println(value);
		}catch(IOException ie) {
			System.out.println("�Է¿����� �ֳ�?@#!@#!$!#$");
			ie.printStackTrace();
		}finally {
			// I/O, network, db
			// ������� �������� ����Ǵ� ��
			System.out.println("�ƹ�ư �� ��µ�");
		}
	}
}
