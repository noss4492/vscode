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
	// 화면 구성 생각
	// 패널 2개
	// 1번 패널
		// 레이블 2 벝 2  텏필ㄷ 2
	// 2번 패널
		// 텏에어리어 1 텏필ㄷ 1 벝 1
	
	// 기본 명명은 수업과 비슷하게 
	// jp1, jp2 cl, jlbIp jlbPort jbtnLogin jbtnExit jtfIp jtfPort
	// jpSouth jta jtf jsp jbtnSend
	
	JPanel jp1, jp2;
	CardLayout cl;
	JLabel jlbIp, jlbPort;
	JButton jbtnLogin, jbtnExit;	// 요기 리슨 기능 있고
	JTextField jtfIp, jtfPort;	// 요기 정보 쓰고
	
	JPanel jpSouth;
	JTextArea jta;
	JTextField jtf;
	JScrollPane jsp;
	JButton jbtnSend;
	
	String ip;
	int port;
	Socket svrSo;
	
	// 필요한게 머가 있지? hmm
	// i/o stream이니까 
	// inputstream을 받아줄 것 -> 유니코드까지 -> inpustreamreader-> 버퍼까지 -> bufferedreader
	// outputstream을 받아줄 것 -> 마찬가지로 -> outputstreamWriter -> 마찬가지로 -> bufferedWriter
	// ->Printstream으로 타입 호환성을 높게 printwriter
	
	BufferedReader br;
	PrintWriter pw;
	
	
	// i/o stream 처리를 위해 
	// inputstream을 받기 위해(한글까지 되게 하려고) inputstreamreader을 쓰고 버퍼드리더는 너무 접근 많이 안 일어나게 해주려고
	// outputstream을 보내기 위해(안전하게 여러 타입과 호환되게 보내기 위해) 
	
	// 출발과 끝을 생각해본다면 (소켓에는 스트림(i/o stream)이 쌓이게 되니까)
	// inputstream inputstreamreader bufferedreader
	// outputstream outputstreamwriter bufferedwriter printwriter
	
	//이 클래스의 소켓에 쌓인 inputstream, 이 소켓에서 나갈 outputstream ( 이 I/O스트림+소켓 자체가 버퍼 같은 느낌을 준다. )
	
	//----------------------------------------------------------------------//
	
	public ChatClient() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 사용할 패널 2개
		jp1 = new JPanel();	// 로그인 패널
		jp2 = new JPanel(); // 채팅창 패널
		
		// 카드레이아웃객체생성
		cl = new CardLayout();
		
		
		// 스크롤패널에 채팅창 붙
		
		
		// 1번 패널(로그인창)
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
		jbtnLogin = new JButton("로그인");
		jbtnExit = new JButton("종료");
		jtfIp = new JTextField("192.168.0.35");
		jtfPort = new JTextField("5000");
		
		// 2번 패널(채팅창) 구성

		jpSouth = new JPanel();		// 채팅창이 될 아이
		jtf = new JTextField(40);	// 사용자 채팅 입력창
		jta = new JTextArea();		// 채팅창
		jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		jp2.setLayout(new BorderLayout());	// 채팅창 레이아웃은 보더레이아웃
		jp2.add(jsp,"Center");
		jp2.add(jpSouth, "South");
		jpSouth.add(jtf);
		jpSouth.add(jbtnSend);
		jbtnSend = new JButton("전송");
		
	}
	
	

}
