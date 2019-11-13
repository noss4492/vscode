package makePainterTmp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class MTServer extends Thread{
	Socket client;
	
	public MTServer(Socket client){
		this.client = client;
	}

	@Override
	public void run() {
		// 연결 된다면 이 부분이 계속 동작한다.
		// 
		System.out.println("접속한 사용자 IP : "+client.getInetAddress().getHostAddress());
		
			
			// inputstream으로 받고
			
			// 다시 클라이언트에 전송
			
			
	}
}
