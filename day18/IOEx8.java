package day18;
// ��ǲ��Ʈ������ �ƿ�ǲ��Ʈ��������

import java.io.IOException;

public class IOEx8 {
	// 1. System.in.read()
	// 2. Scanner
	
	public static void main(String[] args) throws IOException {
		System.out.println("�Է��ؿ� : (���� ctrl+z)");
		
		int value=0;
		while( (value = System.in.read()) != -1) {
			System.out.print((char)value);
		}
	}
	
	
	// Ű����κ��� �Է¹��� ���� ȭ�鿡 ���
}
