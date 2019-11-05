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
		// Hello.java �о Hello2.java �����

		// ���� �����ؼ� �о����
		// ���� �����ؼ� ����
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

		System.out.println("[���ϸ�] " + path.getFileName());
		System.out.println("[�θ� ���丮��]: " + path.getParent().getFileName());
		System.out.println("��ø ��μ�: " + path.getNameCount());
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
