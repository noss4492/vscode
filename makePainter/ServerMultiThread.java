package makePainter;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMultiThread extends Thread{
	Socket solver;
	Socket examiners;

	public ServerMultiThread(Socket client) {
		this.solver = solver;
	}
	
	// 동시에 처리할 동작 -> 서버 수신단에서는 계속 퀴즈 출제자의 패널을 수신하고 있어야함.
	// 동시에 처리할 동작 -> 수신 받았다면 서버에서 각 사용자들한테 퀴즈출제자의 패널을 전송(출제자제외)
	
	//일단은 수신받고 있는 것을 구현해보자.
	@Override
	public void run() {
		
		
//		InetAddress inet = client.getInetAddress();
		
		
	}

	
	
}
