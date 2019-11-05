package day18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOEx11 {
	public static void main(String[] args) throws IOException {
		//test.txt�� hello java io world ������ �����ϱ�
/*���� ����� ���� ����
���ø����̼ǳ� ��Ʈ�� ���ڷ� �����
���Ͽ� ����ִ� �ؽ�Ʈ �о ȭ�鿡 ���
filewriter
bufferedwriter
.write
.flush
filereader
bufferedreader
.read*/
		File f1 = new File("z:\\ioex11.txt");
		FileWriter fw = new FileWriter(f1);
		BufferedWriter bw = new BufferedWriter(fw);
//		BufferedWriter bw = new BufferedWriter(
//							new FileWriter(
//							new File("z:\\ioex11.txt")));
		String msg = "Hello java... IO... World..\n"
				+ "zol ryu yo... zZ zZ �帣��~ ";
		
		bw.write(msg);
		bw.flush();
		
		File f2 = new File("z:\\ioex11.txt");
		FileReader fr = new FileReader(f2);
		BufferedReader br = new BufferedReader(fr);
//		BufferedReader br = new BufferedReader(
//							new FileReader(
//							new File("z:\\ioex11.txt")));
		
		int value = 0;
//		System.out.println((char)br.read());	//H ����

		while( (value = br.read()) != -1 ) {
			System.out.print((char)value);
		}
	}
}
