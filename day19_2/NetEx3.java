package day19_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class NetEx3 { // �ϳ��� app�� �ϳ��� port�� �����
	public static void main(String[] args) {
		ServerSocket ss;
		try {
			System.out.println("����� ���� ��ٸ�����");
			ss = new ServerSocket(5000);

			while (true) {
				Socket client = ss.accept();
				InetAddress inet = client.getInetAddress();

				System.out.println("Ŭ���̾�Ʈ IP" + inet.getHostAddress());
				System.out.println("Ŭ���̾�Ʈ ���� ����");
				System.out.println();

				InputStream is = client.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
//				String msg = br.readLine();
				String msg = null;

				PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())));

				while ((msg = br.readLine()) != null) {
					System.out.println("Ŭ���̾�Ʈ�� ���� �޼��� :" + msg);
				// msg�� �ٽ� Ŭ���̾�Ʈ���� �����ϱ�
				
					pw.println("�������� ���� �޼��� : "+msg);
					pw.flush();
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
