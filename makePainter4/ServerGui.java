package makePainter4;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerGui extends JFrame {
	JTextField inputTxt;
	JTextArea viewTxt;
	JButton send;
	
	ChatServer server = new ChatServer();
	ServerGui(){
		setLayout(null);
		
		inputTxt = new JTextField(25);
		viewTxt = new JTextArea(40,25);
		send = new JButton("send");
		
		inputTxt.setBounds(0,0,500,700);
		viewTxt.setBounds(0,700,400,100);
		send.setBounds(400,700,100,100);
		
		add(inputTxt);
		add(viewTxt);
		add(send);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100,100,500,800);
		setVisible(true);
		
		server.setGui(this);
		server.setting();
	}
	
	
	public static void main(String[] args) {
		new ServerGui();
	}
}