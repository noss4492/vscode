package makePainter4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
	
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	private MainGui gui;

	public void setGui(MainGui gui) {
		this.gui = gui;
	}
	public void setWrite() {
		try {
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			out.writeUTF("OUT>>>>>>>>>>>>>>>>>>>>");
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		out.writeUTF("Ŭ���̾�Ʈ�� ���� �޼���");
//		System.out.println("�޽��� ������ �Ϸ�");
		
	}


	public ChatClient() {
	}
	
	
	public void connet() {
		try {
			socket = new Socket("192.168.0.49",7777);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("���� �����.");
	}
	
	public static void main(String[] args) {
		ChatClient chatCli = new ChatClient();
		chatCli.connet();
		
	}
}
