package day19_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class NetEx2_2 {
	public static void main(String[] args) {
		// Ư�� ������ ������ ����
		// 192.168.0.35 //33,8,49,22
		try {
			Socket s = new Socket("192.168.0.35", 5000);
			System.out.println("s:" + s);

			// ������ ������ ���� �߽� ��ü
			// hooo ���� ��ü�� ���ؼ� in/out Stream ��ü�� ���Ϲ޾Ƽ� �����.
			OutputStream os = s.getOutputStream(); // Returns an output stream for this socket.
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			PrintWriter pw = new PrintWriter(bw);

			// pw.println("�� ������ �������� ���۵Ǿ�����");

			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader keyboard = new BufferedReader(isr);

			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

			String data = null;
			System.out.printf("�Է��ؿ�:");
			String svrMsg = null;
			
			pw.flush();
			
			while ((data = keyboard.readLine()) != null) {
				System.out.println(data);
				pw.println(data);
				pw.flush();
				svrMsg = br.readLine();//?
				System.out.println(svrMsg);
			}

		} catch (UnknownHostException e) {
			System.out.println("�߸��� IP �ּ�");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("���� ����");
			e.printStackTrace();
		}

	}
}
