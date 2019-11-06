package day19;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;

public class IOEx13 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// f i s o i s
		File f = new File("z:\\_19_member.txt");

		//PrintStream
		PrintStream ps;
		System.out.println();// ���⿡ out�� PrintStream�̾���. �� '3 ';;
		// public static final PrintStream out�� PrintStream�� ��ü��
		// �׷��� PrintStream �ڼ� ��ü�鿡 print() println()�� �������̵� �Ǿ� �ִ°��� �� �� ��
		// �� PrintOutputStream �ƴϰ� PrintStream����? -> ����� ��
		
		//PrintWriter
		
		// �ڷ����� ���ֹ��� �ʰ� ����ϰ� �ʹٸ� �� ���� ����ϸ� ��.
		
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);

		Object obj = ois.readObject();
		System.out.println(obj);
		
		Member m = (Member)obj;
		
		System.out.printf("id:%s pw:%s name:%s addr:%s email:%s age:%d\n",m.getId(),m.getPw(),m.getName(),m.getAddr(),m.getEmail(),m.getAge());
	}
}
