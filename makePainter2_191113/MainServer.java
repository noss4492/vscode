package makePainter2_191113;

import java.awt.Frame;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainServer extends JFrame {
	static JFrame jf = new JFrame();
//	DrawCanvas received;
	BufferedImage copyedImg;
	Frame a;
	JFrame jf1;
	
	public MainServer() {
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		ServerSocket ss;
		JPanel copyedGlassPane;
		PaintPacket pp3;
//		JLayeredPane copyedGlassPane;

		InputStream is = null;
		ObjectInputStream ois = null;
		BufferedInputStream bis = null;

		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jf.setLayout(null);
		jf.setSize(500, 500);
		jf.setVisible(true);
		try {
			ss = new ServerSocket(5000);
			while (true) {
				System.out.println("[server] 클라이언트 입장 대기중");
				Socket client = ss.accept();
				System.out.println("IP: " + client.getInetAddress().getHostAddress());
				is = client.getInputStream();
				bis = new BufferedInputStream(is);
				ois = new ObjectInputStream(bis);

//				this.setGlassPane();

				try {
//					a = (Frame) ois.readObject();	// frame은 직렬화 가능
					pp3 = new PaintPacket((PaintPacket) ois.readObject());
					ois.readObject();

//					copyedGlassPane = (JPanel) ois.readObject();


//					copyedGlassPane = pp3.getJp();
//					jf = new JFrame();
//					jf.setLocation(100, 100);
//					jf.setSize(500, 500);
//
//					copyedGlassPane.setLayout(null);
//					copyedGlassPane.add(new JLabel("되나"));
//					copyedGlassPane.setVisible(true);
//					jf.add(copyedGlassPane);
//					System.out.println("a hash" + copyedGlassPane);

//					copyedGlassPane = (JLayeredPane) ois.readObject();
//					jf.setLayeredPane(copyedGlassPane);

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