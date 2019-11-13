package makePainter3;

import java.awt.Frame;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainServer extends JFrame {
//	static JFrame jf = new JFrame();
//	DrawCanvas received;
//	BufferedImage copyedImg;
//	Frame a;
//	JFrame jf1;
	public static void main(String[] args) {
		BoxedStrokePoint pp4;
		ServerSocket ss;
		InputStream is = null;
		ObjectInputStream ois = null;
		BufferedInputStream bis = null;
		try {
			ss = new ServerSocket(5000);
			while (true) {
				System.out.println("[server] 클라이언트 입장 대기중");
				Socket client = ss.accept();
				System.out.println("Client 입장 IP: " + client.getInetAddress().getHostAddress());
				System.out.println("Port: " + client.getPort());
//				is = client.getInputStream();
//				ois = new ObjectInputStream(is);
				is = client.getInputStream();
				bis = new BufferedInputStream(is);
				ois = new ObjectInputStream(bis);

				
				System.out.println("try");
				try {
					System.out.println("read ois readObject");
					pp4 = (BoxedStrokePoint)ois.readObject();
					ArrayList<Integer> aax = pp4.getPointX();
					ArrayList<Integer> aay = pp4.getPointY();
					System.out.println("0000000000000000000000000000");
					System.out.println("aax|"+aax);
					System.out.println("aay|"+aay);
					
					System.out.println("0000000000000000000000000000");
					for(int t = 0; t < aax.size(); t++) {
						System.out.println(aax.get(t)+"|"+aay.get(t));
					}
					System.out.println("0000000000000000000000000000");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null)
					is.close();
				if (bis != null)
					bis.close();
				if (ois != null)
					ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}

//				BufferedInputStream bis = new BufferedInputStream(client.getInputStream());

//				os = server.getOutputStream();
//				oos = new ObjectOutputStream(os);
//				bos = new BufferedOutputStream(oos);
//				oos.writeObject(this.getFrame());

//				InputStreamImageInputStreamSpi
//					InputStream is = client.getInputStream();
//					InputStream ois = new ObjectInputStream(bis);

//					Object obj = bis.readObject();
//					copyedImg = (BufferedImage)obj;

//				copyedImg = ImageIO.read(bis);
//				System.out.println(copyedImg);
//				FileOutputStream fout = new FileOutputStream("d:/testUpload"+System.currentTimeMillis()/1000000+".png");
//	            ImageIO.write(copyedImg, "png", fout);
//	            fout.close();

//				ServerMultiThread sTh = new ServerMultiThread(client);
//				sTh.start();