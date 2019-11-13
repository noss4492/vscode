package makePainter3;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MServerThread extends Thread {
	Socket client;
	String ip;

	public MServerThread(Socket client) { // 해당 소켓(클라이언트소켓)에 연결
		this.client = client;
		ip = client.getInetAddress().getHostAddress();
		System.out.println(client+"MStH실행");
//		broadcast("님이 접속하셨습니다.");
	}

	@Override
	public void run() {
		// 동시에 처리할 코드
		System.out.println("runrun");

		//
		ServerSocket ss;
		BoxedStrokePoint bsp;
		InputStream is = null;
		ObjectInputStream ois = null;
		BufferedInputStream bis = null;
		Object obj = null;
		
		try {
			is = client.getInputStream();
			bis = new BufferedInputStream(is);
			ois = new ObjectInputStream(bis);
			obj = ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(i+"|"+list.get(i));
//		}
		
		bsp = (BoxedStrokePoint)obj;
			if (bsp instanceof BoxedStrokePoint) {
				System.out.println("인자다!!!");
				System.out.println("obj!!"+obj);
				System.out.println("bsp!!"+bsp);
				System.out.println(bsp.getPointX());
				System.out.println(bsp.getPointY());
				// 만약 클라이언트로 부터 받은 메세지가 object(BoxedStrokePoint type)이면

				// 클라이언트로부터의 인풋 (boxedstrokepoint)

				// 모든 접속자에게 화면을 전달 (출제자 제외)

			}
	}

	private void brodcast(String msg) {
		// arraylist 안에 있는 객체를 하나씩 꺼내서 전송

	}

	private void broadcastPointArr() {

	}
}
