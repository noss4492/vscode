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

	public MServerThread(Socket client) { // �ش� ����(Ŭ���̾�Ʈ����)�� ����
		this.client = client;
		ip = client.getInetAddress().getHostAddress();
		System.out.println(client+"MStH����");
//		broadcast("���� �����ϼ̽��ϴ�.");
	}

	@Override
	public void run() {
		// ���ÿ� ó���� �ڵ�
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
				System.out.println("���ڴ�!!!");
				System.out.println("obj!!"+obj);
				System.out.println("bsp!!"+bsp);
				System.out.println(bsp.getPointX());
				System.out.println(bsp.getPointY());
				// ���� Ŭ���̾�Ʈ�� ���� ���� �޼����� object(BoxedStrokePoint type)�̸�

				// Ŭ���̾�Ʈ�κ����� ��ǲ (boxedstrokepoint)

				// ��� �����ڿ��� ȭ���� ���� (������ ����)

			}
	}

	private void brodcast(String msg) {
		// arraylist �ȿ� �ִ� ��ü�� �ϳ��� ������ ����

	}

	private void broadcastPointArr() {

	}
}
