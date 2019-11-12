package myPlayGround;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;

public class __2_PaintSender implements Serializable, Runnable {
	public class member  { // 직렬화 인터페이스로 구현하여 직렬화가능한 객체로

		try {
		Socket s1 = new Socket(ip, port);
		
		BufferedOutputStream bos = new BufferedOutputStream(s1.getOutputStream());// 보통 파일을 인자로 받지만
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		} catch (UnknownHostException e3) {
			e3.printStackTrace();
		} catch (IOException e3) {
			e3.printStackTrace();
		}	
	}
}
