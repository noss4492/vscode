package makePainter;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.imageio.ImageIO;

public class MainServer {
	public static void main(String[] args) {

		ServerSocket ss;
		DrawCanvas received;
		BufferedImage copyedImg;
		try {
			ss = new ServerSocket(5000);
			while (true) {
				System.out.println("[server] 클라이언트 접속 대기중");
				Socket client = ss.accept();
				System.out.println("IP: " + client.getInetAddress().getHostAddress());
				BufferedInputStream bis = new BufferedInputStream(client.getInputStream());
//					InputStream is = client.getInputStream();
//					InputStream ois = new ObjectInputStream(bis);
				
				copyedImg = ImageIO.read(bis);
//					Object obj = bis.readObject();
//					copyedImg = (BufferedImage)obj;
				System.out.println(copyedImg);
				
				FileOutputStream fout = new FileOutputStream("z:/testUpload.png");
	            ImageIO.write(copyedImg, "png", fout);
	            fout.close();


//				ServerMultiThread sTh = new ServerMultiThread(client);
//				sTh.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
