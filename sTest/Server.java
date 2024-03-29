package sTest;

import java.awt.Toolkit;
import java.io.BufferedInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Server {

	final int w = 1280, h = 720;

	final int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2,
			y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;

	JFrame frame;

	// 사용자의 해상도를 받아오고 창생성

	public static void main(String[] args) {

		new Server(); // 클라이언트방식과 똑같이 생성자 호출

	}

	public Server() {

		frame = new JFrame("server");

		frame.setBounds(x, y, w, h);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);

		// 창을 만들고

		ServerSocket socket_s = null;

		Socket socket = null;

		try {

			socket_s = new ServerSocket(12345);

			socket = socket_s.accept();

			System.out.println("클라이언트 연결 완료! - 서버" + socket);

			// 클라이언트와 접속함

			BufferedInputStream bin = new BufferedInputStream(socket.getInputStream());

			// 소켓의 입력스트림을 버퍼스트림으로

			while (true) {

				frame.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(bin)), 0, 0, w, h, frame);

				// 이미지를 받아오는 동시에 화면에 그림

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
