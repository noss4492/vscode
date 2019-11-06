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
		// �������� ����Ǵ� ��Ƽ ������ �̴ϱ�
		// ���� ������ ���� �Ǿ� �־�� ��

		// ���ÿ� ó���� �ڵ�
		// ��� Ŭ���̾�Ʈ�� ����� ����ϴ� �ڵ�
		
		// 1. ���� ������� IP�� ���
		InetAddress inet = client.getInetAddress();
		String ip = inet.getHostAddress();
		System.out.println("����� IP : "+ip);
		
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
//			// �پ� �ڷ��� ���
//			PrintWriter pw = new PrintWriter(bw);
			
			br = new BufferedReader(
						new InputStreamReader(
						client.getInputStream()));		// ���� ���Ͽ� �׿��ִ� ��ǲ��Ʈ��. Ŭ���̾�Ʈ���� ��. ���� �� ����.
			
			pw = new PrintWriter(
						new BufferedWriter(
						new OutputStreamWriter(
						client.getOutputStream())));	// Ŭ���̾�Ʈ �������� ���� �ƿ�ǲ��Ʈ��. ������ ���� �׿��ִ�. ���� �� ����
			
			String msg = null;
			
			while( (msg = br.readLine()) != null) {
				System.out.println("["+ip+"]"+msg);
				// �ٽ� Ŭ���̾�Ʈ�� ����
				pw.println(msg);
				pw.flush();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
