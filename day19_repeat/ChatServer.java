package day19_repeat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	public static void main(String[] args) {
		
		// Create Server Socket
		try {
			ServerSocket svrSo = new ServerSocket(5000);
			while(true) {		//detection
				System.out.println("클라이언트 접속 대기 중");
				Socket clientSo = svrSo.accept(); 	// 얘가 listen해준다.
				// listen이 되는 트리거로는 클라이언트에서의 pw.flush()로 생각된다.
				System.out.println("IP : "+clientSo.getInetAddress().getHostAddress());//클라이언트소켓의주소
				
				// 각 클라이언트(사용자)마다 병렬적으로 동작 처리를 해줘야함
				// 멀티쓰레드로 처리
				// 통신 동작을 담당하는 객체 MTServer
				
//				MTServer ms = new MTServer(clientSo);
//				ms.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

/*
어떻게 만들 것인가?
 멀티쓰레드와 GUI를 이용하여 구현한 다중접속 가능한 채팅 서버-클라이언트 구현


서버에서 클라이언트 동작 처리 부분이 멀티 쓰레드로 구현되어야함.
	간단한 통신기능
	서버 - listen
	클라이언트 - send
	서버 - accept

접속한 유저마다 다른 쓰레드를 구현하여야한다.
서버에서 accept시 접속한 유저의 소켓(객체)를 가지고 구분할 수 있음.
accept해서 연결되었다면 그 이후로는 계속 통신상태가 되어야함.

동작 정리해서 생각

클라이언트에서 텍스트필드에 글을 써서 전송 눌러서 글을 텍스트에어리어에 올리고( 원랜 이 기능을 구현하고자 하는 것이 아님  )
클라이언트에서 텍스트필드에 글을 쓴 다음 전송을 누르면
그 글을 클라이언트에서 outputstream에 담아서 output


카드레이아웃으로 생기는 동작
1번화면
tf1 아이피 담아서
tf2 포트 담아서


이걸 이제 채팅 클라이언트에서 접속 누르면
이 tf1, tf2 정보를 가지고 소켓객체를 생성하여
클라이언트 객체에서 쓰이는 메세지들을 (뭐 화면에 출력하는 자질구레한 설명은 제외하고)
서버에 보내기 위해 (엔터를 누르거나 전송을 누르거나)
메세지(문자열) 을 보내야 한다. 방법은 

br ( s.getInputStream으로 클라이언트 소켓에 쌓인 인풋스트림 데이터를 읽기 위해 만듬 )
pw (                                    아웃풋                                      )
들어와서 쌓여있는 애들
나가려고 쌓여있는 애들

보내려면 메세지 담아서 -> target소켓을 지칭하는 outputstream에 담아서 

s.getInputStream	//이 소켓에서 받는 input stream  .read
s.getOutputStream	//보낼 소켓에 대한 output stream .write

서버( 클라이언트 메세지 받아서 출력, 다시 클라이언트로 전송 )
 
 */