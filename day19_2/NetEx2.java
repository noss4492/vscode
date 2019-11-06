package day19_2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class NetEx2 {
	public static void main(String[] args) {
		// 특정 서버에 접속해 보기
		// 192.168.0.35 //33,8,49,22
		try {
			Socket s = new Socket("192.168.0.49", 5000);
			System.out.println("s:"+s);
			
			// 서버로 보내기 위한 발신 객체
			//hooo 소켓 객체를 통해서 in/out Stream 객체를 리턴받아서 사용함.
			OutputStream os = s.getOutputStream();	//Returns an output stream for this socket.
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			PrintWriter pw = new PrintWriter(bw);
			
			pw.println("이 편지는 영국에서 시작되었으며");
			pw.flush();
			
			
		} catch (UnknownHostException e) {
			System.out.println("잘못된 IP 주소");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("접속 실패");
			e.printStackTrace();
		}
		
	}
}
