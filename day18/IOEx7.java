package day18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOEx7 {
	public static void main(String[] args) throws IOException {
		File f = new File("z:\\Hello.java");
		File f2 = new File("z:\\Welcome.java");
		
		FileReader fr = new FileReader(f);
		FileWriter fw = new FileWriter(f2);
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = new BufferedWriter(fw);

		int value = 0;
		while( (value = br.read()) != -1 ) {
			bw.write(value);
			System.out.print((char)value);
		}
		bw.flush();
		
		
	}
	
}
