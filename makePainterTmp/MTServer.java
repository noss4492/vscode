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
		// ���� �ȴٸ� �� �κ��� ��� �����Ѵ�.
		// 
		System.out.println("������ ����� IP : "+client.getInetAddress().getHostAddress());
		
			
			// inputstream���� �ް�
			
			// �ٽ� Ŭ���̾�Ʈ�� ����
			
			
	}
}
