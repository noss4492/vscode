package myPlayGround;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class __3_PaintReceiver_Server {
public static void main(String[] args) {
		
		ServerSocket ss;
		try {
			ss = new ServerSocket(5000);
			while(true) {
				System.out.println("[server] Ŭ���̾�Ʈ ���� �����");
				Socket client = ss.accept();
				System.out.println("IP: "+client.getInetAddress().getHostAddress());
				
				// ��Ƽ ������ ó��/ ��Ŵ�簴ü
			__4_Communication_ServerThread sTh = new __4_Communication_ServerThread(client);
			sTh.start();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
