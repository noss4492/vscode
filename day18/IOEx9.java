package day18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOEx9 {
	public static void main(String[] args) throws IOException {
		// �� System.in ==> byte �Կ��� Ŭ������
		// byte -> char �ٲ��ֱ�
		// �ٸ����� �� �Ẹ��

		InputStreamReader isr = new InputStreamReader(System.in);
		// ���ڷ� Inputstream �Ű����� ����

		BufferedReader br = new BufferedReader(isr);
		// �����

		// �ѱ��� ���Ϸ� �����Ϸ�����
		FileWriter fw = new FileWriter("z:\\ddd.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		

		String str = null;
		while( (str = br.readLine()) != null ) {	//���̸� null
			bw.write(str+"\n");
			System.out.println(str);
		}
		bw.flush();
	}
}

//		System.out.println("�Է��ϼ�");
//		String str = br.readLine();
//		System.out.println(str);