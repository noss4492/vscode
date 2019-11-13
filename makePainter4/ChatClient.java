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
		
//		out.writeUTF("클라이언트로 보낸 메세지");
//		System.out.println("메시지 보내기 완료");
		
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
		System.out.println("서버 연결됨.");
	}
	
	public static void main(String[] args) {
		ChatClient chatCli = new ChatClient();
		chatCli.connet();
		
	}
}
