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
	
	// ���ÿ� ó���� ���� -> ���� ���Ŵܿ����� ��� ���� �������� �г��� �����ϰ� �־����.
	// ���ÿ� ó���� ���� -> ���� �޾Ҵٸ� �������� �� ����ڵ����� ������������ �г��� ����(����������)
	
	//�ϴ��� ���Źް� �ִ� ���� �����غ���.
	@Override
	public void run() {
		
		
//		InetAddress inet = client.getInetAddress();
		
		
	}

	
	
}
