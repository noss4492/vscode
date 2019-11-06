package day19_repeat;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements ActionListener, KeyListener, Runnable{
	// ȭ�� ���� ����
	// �г� 2��
	// 1�� �г�
		// ���̺� 2 �� 2  ���ʤ� 2
	// 2�� �г�
		// ������� 1 ���ʤ� 1 �� 1
	
	// �⺻ ����� ������ ����ϰ� 
	// jp1, jp2 cl, jlbIp jlbPort jbtnLogin jbtnExit jtfIp jtfPort
	// jpSouth jta jtf jsp jbtnSend
	
	JPanel jp1, jp2;
	CardLayout cl;
	JLabel jlbIp, jlbPort;
	JButton jbtnLogin, jbtnExit;	// ��� ���� ��� �ְ�
	JTextField jtfIp, jtfPort;	// ��� ���� ����
	
	JPanel jpSouth;
	JTextArea jta;
	JTextField jtf;
	JScrollPane jsp;
	JButton jbtnSend;
	
	String ip;
	int port;
	Socket svrSo;
	
	// �ʿ��Ѱ� �Ӱ� ����? hmm
	// i/o stream�̴ϱ� 
	// inputstream�� �޾��� �� -> �����ڵ���� -> inpustreamreader-> ���۱��� -> bufferedreader
	// outputstream�� �޾��� �� -> ���������� -> outputstreamWriter -> ���������� -> bufferedWriter
	// ->Printstream���� Ÿ�� ȣȯ���� ���� printwriter
	
	BufferedReader br;
	PrintWriter pw;
	
	
	// i/o stream ó���� ���� 
	// inputstream�� �ޱ� ����(�ѱ۱��� �ǰ� �Ϸ���) inputstreamreader�� ���� ���۵帮���� �ʹ� ���� ���� �� �Ͼ�� ���ַ���
	// outputstream�� ������ ����(�����ϰ� ���� Ÿ�԰� ȣȯ�ǰ� ������ ����) 
	
	// ��߰� ���� �����غ��ٸ� (���Ͽ��� ��Ʈ��(i/o stream)�� ���̰� �Ǵϱ�)
	// inputstream inputstreamreader bufferedreader
	// outputstream outputstreamwriter bufferedwriter printwriter
	
	//�� Ŭ������ ���Ͽ� ���� inputstream, �� ���Ͽ��� ���� outputstream ( �� I/O��Ʈ��+���� ��ü�� ���� ���� ������ �ش�. )
	
	//----------------------------------------------------------------------//
	
	public ChatClient() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// ����� �г� 2��
		jp1 = new JPanel();	// �α��� �г�
		jp2 = new JPanel(); // ä��â �г�
		
		// ī�巹�̾ƿ���ü����
		cl = new CardLayout();
		
		
		// ��ũ���гο� ä��â ��
		
		
		// 1�� �г�(�α���â)
		jp1.setLayout(null);

		jlbIp.setBounds(50, 100, 100, 50);
		jlbPort.setBounds(50, 300, 100, 50);
		jtfIp.setBounds(250, 100, 150, 50);
		jtfPort.setBounds(250, 300, 150, 50);
		jbtnLogin.setBounds(150, 450, 150, 50);
		jbtnExit.setBounds(350, 450, 150, 50);

		jp1.add(jlbIp);
		jp1.add(jlbPort);
		jp1.add(jbtnLogin);
		jp1.add(jbtnExit);
		jp1.add(jtfIp);
		jp1.add(jtfPort);
		
		jlbIp = new JLabel("IP");
		jlbPort = new JLabel("PORT");
		jbtnLogin = new JButton("�α���");
		jbtnExit = new JButton("����");
		jtfIp = new JTextField("192.168.0.35");
		jtfPort = new JTextField("5000");
		
		// 2�� �г�(ä��â) ����

		jpSouth = new JPanel();		// ä��â�� �� ����
		jtf = new JTextField(40);	// ����� ä�� �Է�â
		jta = new JTextArea();		// ä��â
		jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		jp2.setLayout(new BorderLayout());	// ä��â ���̾ƿ��� �������̾ƿ�
		jp2.add(jsp,"Center");
		jp2.add(jpSouth, "South");
		jpSouth.add(jtf);
		jpSouth.add(jbtnSend);
		jbtnSend = new JButton("����");
		
	}
	
	

}
