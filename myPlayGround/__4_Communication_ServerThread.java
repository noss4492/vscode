package myPlayGround;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class __4_Communication_ServerThread extends Thread{
	Socket solver;
	Socket examiners;

	public __4_Communication_ServerThread(Socket client) {
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
