package day19_2;

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
	
	MTServer(Socket client){
		this.client = client;
	}

	@Override
	public void run() {
		// 서버에서 실행되는 멀티 쓰레드 이니까
		// 여러 사람들과 연결 되어 있어야 함

		// 동시에 처리할 코드
		// 모든 클라이언트와 통신을 담당하는 코드
		
		// 1. 접속 사용자의 IP를 출력
		InetAddress inet = client.getInetAddress();
		String ip = inet.getHostAddress();
		System.out.println("사용자 IP : "+ip);
		
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
//			InputStream is = client.getInputStream();
//			InputStreamReader isr = new InputStreamReader(is);
//			BufferedReader br = new BufferedReader(isr);
			
//			Outputstream os = client.getOutputStream();
//			OutputStreamWriter osw = new OutputStreamWriter(os);
//			BufferedWriter bw = new BufferedWriter(osw);
//			
//			// 다양 자료형 출력
//			PrintWriter pw = new PrintWriter(bw);
			
			br = new BufferedReader(
						new InputStreamReader(
						client.getInputStream()));		// 서버 소켓에 쌓여있는 인풋스트림. 클라이언트에서 온. 아직 못 들어온.
			
			pw = new PrintWriter(
						new BufferedWriter(
						new OutputStreamWriter(
						client.getOutputStream())));	// 클라이언트 소켓으로 보낼 아웃풋스트림. 서버에 아직 쌓여있는. 아직 못 나감
			
			String msg = null;
			
			while( (msg = br.readLine()) != null) {
				System.out.println("["+ip+"]"+msg);
				// 다시 클라이언트에 전송
				pw.println(msg);
				pw.flush();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
