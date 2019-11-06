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
		System.out.println();// 여기에 out이 PrintStream이었음. 헐 '3 ';;
		// public static final PrintStream out이 PrintStream의 객체래
		// 그래서 PrintStream 자손 객체들에 print() println()이 오버라이드 되어 있는것을 볼 수 있
		// 왜 PrintOutputStream 아니고 PrintStream인지? -> 만든놈 맴
		
		//PrintWriter
		
		// 자료형에 구애받지 않고 출력하고 싶다면 이 둘을 사용하면 됨.
		
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);

		Object obj = ois.readObject();
		System.out.println(obj);
		
		Member m = (Member)obj;
		
		System.out.printf("id:%s pw:%s name:%s addr:%s email:%s age:%d\n",m.getId(),m.getPw(),m.getName(),m.getAddr(),m.getEmail(),m.getAge());
	}
}
