package myPlayGround;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JPanel;

public class __2_PaintSender implements Serializable {	//, 추가예정 Runnable
	String ip = "192.168.0.49";
	int port = 5000;
	
	public __2_PaintSender(JPanel p) {
		
		
		
		
	}
//
//	try
//	{
//		Socket s1 = new Socket(ip, port);
//
//		BufferedOutputStream bos = new BufferedOutputStream(s1.getOutputStream());// 보통 파일을 인자로 받지만
//		ObjectOutputStream oos = new ObjectOutputStream(bos);
//	}catch(
//	UnknownHostException e)
//	{
//		e.printStackTrace();
//	}catch(
//	IOException e)
//	{
//		e.printStackTrace();
//	}
}
