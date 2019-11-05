package day18;

import java.io.File;
import java.io.IOException;

public class FileEx {
	public static void main(String[] args) throws IOException {
		// I/O 관련 클래스
		// File f = new file();

		String str = new String("z:\\HelloIO.java");
		System.out.println(str);
		System.out.println("=================");
//		File f = new File("z:\\HelloIO.java");
		File f = new File(str);

		System.out.print("파일있니?" + f.exists());
		System.out.println(f.exists() ? " 있어" : " 없어");

		if (!f.exists()) {
			// 생성
			// 당분간 가독성을 위해서 예외는 던져둠
			f.createNewFile();
			System.out.println("파일을 생성합니다.");
		} else {
			System.out.println("파일이 이미 있음");
		}
		System.out.println("=================");

		String path = f.getAbsolutePath();
		System.out.println("파일 절대경로 : " + path);

		if (f.isFile()) {
			System.out.println("파일임");
		}
		if (f.isDirectory()) {
			System.out.println("폴더임");
		}
		
		String str2 = new String("z:\\eclipse");
		File f2 = new File(str2);
		
		if(f2.isDirectory()) {
			System.out.println(str2+"는 디렉토리가 맞아용!\n 디렉토리 내 파일목록");
			// 현재 디렉토리의 파일목록을 배열로 리턴
			String[] list = f2.list();
			for(String x : list)
				System.out.println(x);
		}
		
		
		
	}// main method end
	
	
	
}

//			try {
//				f.createNewFile();
//			} catch (IOException e) {	// 유발 가능성 1. 경로 잘못됨
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}