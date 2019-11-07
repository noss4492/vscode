package day19_2;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ChatServer extends JFrame implements ActionListener {
	ArrayList<MServer> list = new ArrayList<MServer>();
	ServerSocket ss;
	PrintWriter pw;
	BufferedReader br;

	JTextArea jta;
	JButton jbtnExit;
	JScrollPane jsp;
	Font f = new Font("굴림체", Font.PLAIN, 22);

	public ChatServer() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		jta = new JTextArea();
		jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jbtnExit = new JButton("종료");

		jta.setFont(f);
		add(jsp, "Center");
		add(jbtnExit, "South");

		jbtnExit.addActionListener(this);

		setBounds(100, 100, 600, 1000);
		setVisible(true);

		vChatStart();
	}

	private void vChatStart() {
		// 서버 소켓 생성
		// 사용자 연결 기다림
		// 연결하고 나서 연결 객체를 ArrayList에 할당
		// 여러 사용자에게 메세지 전달
		// 쫙 뿌려줘야함(브로드캐스트)

		try {
			ss = new ServerSocket(5000);
			while (true) {
				Socket client = ss.accept();
				MServer ms = new MServer(client);
				list.add(ms);
				ms.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			list.remove(this);
		}

	}

	public static void main(String[] args) {
		ChatServer cs = new ChatServer();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("종료함ㅅㄱ");
		System.exit(0);
	}// actionPerformed() end

	// inner class start, why? 이 클래스에서 위 클래스 멤버변수(텍스트에어리어) 접근 가능해야 하니까
	class MServer extends Thread {
		Socket client;
		PrintWriter pw;
		BufferedReader br;
		String ip;

		public MServer(Socket client) {
			this.client = client;
			ip = client.getInetAddress().getHostAddress();
//			broadcast("님이 접속하셨습니다.");

			try {
				pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())));
				br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				list.remove(this);
			}
		}

		@Override
		public void run() {
			// 동시에 처리할 코드
			while (true) {
				String msg = null;
				try {
					// 클라이언트로부터 메세지를 가져와용
					msg = br.readLine();
					System.out.println("list : " + list);
					jta.append("[" + ip + "]" + msg + "\n");

					JScrollBar sb = jsp.getVerticalScrollBar();
					int position = sb.getMaximum();
					sb.setValue(position);
					// 모든 접속자에게 이 메세지를 전달
					brodcast("[" + ip + "]" + msg + "\n");

				} catch (IOException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
					list.remove(this);
				}
			}
		}

		private void brodcast(String msg) {
			// arraylist 안에 있는 객체를 하나씩 꺼내서 전송
			for (MServer x : list) {
				x.pw.print(msg);
				x.pw.flush();
			}
		}

	}// mserver end

}// class end
