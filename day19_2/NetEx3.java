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

public class NetEx3 { // 하나의 app은 하나의 port만 써야함
	public static void main(String[] args) {
		ServerSocket ss;
		try {
			System.out.println("사용자 접속 기다리는중");
			ss = new ServerSocket(5000);

			while (true) {
				Socket client = ss.accept();
				InetAddress inet = client.getInetAddress();

				System.out.println("클라이언트 IP" + inet.getHostAddress());
				System.out.println("클라이언트 접속 성공");
				System.out.println();

				InputStream is = client.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
//				String msg = br.readLine();
				String msg = null;

				PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())));

				while ((msg = br.readLine()) != null) {
					System.out.println("클라이언트가 보낸 메세지 :" + msg);
				// msg를 다시 클라이언트에게 전송하기
				
					pw.println("서버에서 보낸 메세지 : "+msg);
					pw.flush();
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
