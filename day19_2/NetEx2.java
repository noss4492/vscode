package day19_2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class NetEx2 {
	public static void main(String[] args) {
		// Ư�� ������ ������ ����
		// 192.168.0.35 //33,8,49,22
		try {
			Socket s = new Socket("192.168.0.49", 5000);
			System.out.println("s:"+s);
			
			// ������ ������ ���� �߽� ��ü
			//hooo ���� ��ü�� ���ؼ� in/out Stream ��ü�� ���Ϲ޾Ƽ� �����.
			OutputStream os = s.getOutputStream();	//Returns an output stream for this socket.
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			PrintWriter pw = new PrintWriter(bw);
			
			pw.println("�� ������ �������� ���۵Ǿ�����");
			pw.flush();
			
			
		} catch (UnknownHostException e) {
			System.out.println("�߸��� IP �ּ�");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("���� ����");
			e.printStackTrace();
		}
		
	}
}
