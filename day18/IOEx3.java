package day18;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class IOEx3 {
	public static void main(String[] args) throws IOException {
		// Hello.java 읽어서 Hello2.java 만들기

		// 파일 접근해서 읽어오긱
		// 파일 접근해서 쓰긱
		File f = new File("z:\\Hello.java");
		File f2 = new File("z:\\Hello2.java");
		FileInputStream fis = new FileInputStream(f);
		FileOutputStream fos = new FileOutputStream(f2);

		int value = 0;
		while ((value = fis.read()) != -1) {
			fos.write(value);
			System.out.print((char) value);
		}

		Path path = Paths.get("z:", "ioTest", "dir1", "NEWTEST.txt");

		System.out.println("[파일명] " + path.getFileName());
		System.out.println("[부모 디렉토리명]: " + path.getParent().getFileName());
		System.out.println("중첩 경로수: " + path.getNameCount());
		System.out.println();

		for (int i = 0; i < path.getNameCount(); i++) {
			System.out.println(path.getName(i));
		}

		System.out.println();
		Iterator<Path> iterator = path.iterator();
		while (iterator.hasNext()) {
			Path temp = iterator.next();
			System.out.println(temp.getFileName());
		}

		fis.close();
		fos.close();
	}// main method end
}// class end
