package myPlayGround;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;

public class __2_PaintSender implements Serializable, Runnable {
	public class member  { // ����ȭ �������̽��� �����Ͽ� ����ȭ������ ��ü��

		try {
		Socket s1 = new Socket(ip, port);
		
		BufferedOutputStream bos = new BufferedOutputStream(s1.getOutputStream());// ���� ������ ���ڷ� ������
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		} catch (UnknownHostException e3) {
			e3.printStackTrace();
		} catch (IOException e3) {
			e3.printStackTrace();
		}	
	}
}
