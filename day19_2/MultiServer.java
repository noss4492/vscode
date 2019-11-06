package day19_2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {
	public static void main(String[] args) {
		
		//서버쪽 소켓 생성
		try {
			ServerSocket ss = new ServerSocket(5000);
			while(true) {
				System.out.println("클라이언트 접속 대기중..");
				Socket client = ss.accept();	//accept 요게 리슨 해줌
				System.out.println("IP: "+client.getInetAddress().getHostAddress());
				
				// 멀티쓰레드 처리
				// 통신 담당 객체 --> MTServer
				MTServer ms = new MTServer(client);
				ms.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
