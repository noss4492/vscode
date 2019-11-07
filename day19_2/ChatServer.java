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
	Font f = new Font("����ü", Font.PLAIN, 22);

	public ChatServer() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		jta = new JTextArea();
		jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jbtnExit = new JButton("����");

		jta.setFont(f);
		add(jsp, "Center");
		add(jbtnExit, "South");

		jbtnExit.addActionListener(this);

		setBounds(100, 100, 600, 1000);
		setVisible(true);

		vChatStart();
	}

	private void vChatStart() {
		// ���� ���� ����
		// ����� ���� ��ٸ�
		// �����ϰ� ���� ���� ��ü�� ArrayList�� �Ҵ�
		// ���� ����ڿ��� �޼��� ����
		// �� �ѷ������(��ε�ĳ��Ʈ)

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
		System.out.println("�����Ԥ���");
		System.exit(0);
	}// actionPerformed() end

	// inner class start, why? �� Ŭ�������� �� Ŭ���� �������(�ؽ�Ʈ�����) ���� �����ؾ� �ϴϱ�
	class MServer extends Thread {
		Socket client;
		PrintWriter pw;
		BufferedReader br;
		String ip;

		public MServer(Socket client) {
			this.client = client;
			ip = client.getInetAddress().getHostAddress();
//			broadcast("���� �����ϼ̽��ϴ�.");

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
			// ���ÿ� ó���� �ڵ�
			while (true) {
				String msg = null;
				try {
					// Ŭ���̾�Ʈ�κ��� �޼����� �����Ϳ�
					msg = br.readLine();
					System.out.println("list : " + list);
					jta.append("[" + ip + "]" + msg + "\n");

					JScrollBar sb = jsp.getVerticalScrollBar();
					int position = sb.getMaximum();
					sb.setValue(position);
					// ��� �����ڿ��� �� �޼����� ����
					brodcast("[" + ip + "]" + msg + "\n");

				} catch (IOException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
					list.remove(this);
				}
			}
		}

		private void brodcast(String msg) {
			// arraylist �ȿ� �ִ� ��ü�� �ϳ��� ������ ����
			for (MServer x : list) {
				x.pw.print(msg);
				x.pw.flush();
			}
		}

	}// mserver end

}// class end
