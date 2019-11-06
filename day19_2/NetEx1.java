package day19_2;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetEx1 {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress inet = InetAddress.getLocalHost();
		System.out.println(inet.getHostAddress());
		System.out.println(inet.getHostName());
		
		InetAddress[] inet2 = InetAddress.getAllByName("www.naver.com");
		for(InetAddress x : inet2) {
			System.out.println(x.getHostAddress());
			System.out.println(x.getHostName());
		}

//		InetAddress inet3 = InetAddress.getByAddress("221.138.182.51:2288");
//		System.out.println(inet3.getHostAddress());
//		System.out.println(inet3.getHostName());
		
	}

}
