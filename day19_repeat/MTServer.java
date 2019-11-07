package day19_repeat;

import java.net.Socket;

public class MTServer extends Thread {
	Socket cliSo;
	
	MTServer(Socket client){
		this.cliSo = client;
	}
}
