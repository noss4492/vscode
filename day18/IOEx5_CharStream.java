package day18;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOEx5_CharStream {
	public static void main(String[] args) throws IOException {
		File f = new File("z:\\Hello.java");
		File f2 = new File("z:\\Hello3.java");
		
		FileReader fr = new FileReader(f);
		FileWriter fw = new FileWriter(f2);
		
		
//		int value = fr.read();
//		System.out.println(value);
		
		int value = 0;
		while((value = fr.read()) != -1) {
			fw.write(value);
			System.out.print((char)value);
		}
		// buffer
		fw.flush();
	}
}
