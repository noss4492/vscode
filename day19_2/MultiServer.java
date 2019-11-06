package day19_2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {
	public static void main(String[] args) {
		
		//������ ���� ����
		try {
			ServerSocket ss = new ServerSocket(5000);
			while(true) {
				System.out.println("Ŭ���̾�Ʈ ���� �����..");
				Socket client = ss.accept();	//accept ��� ���� ����
				System.out.println("IP: "+client.getInetAddress().getHostAddress());
				
				// ��Ƽ������ ó��
				// ��� ��� ��ü --> MTServer
				MTServer ms = new MTServer(client);
				ms.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
