package makePainter4;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	private ServerSocket serverSoket;
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	private ServerGui gui;
	
	
	

	public void setGui(ServerGui gui) {
		this.gui = gui;
	}
	
	
	public void setting() {
		try {
			serverSoket = new ServerSocket(7777);
			System.out.println("대기중");
			socket = serverSoket.accept(); // 서버가 요청할때까지 기다림 .
			System.out.println(socket.getInetAddress() + "에서 접속했습니다.");

			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			String msg = in.readUTF();
			System.out.println("수신한 msg :"+msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ChatServer chatser = new ChatServer();
		chatser.setting();
	}
}
