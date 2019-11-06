package day19_2;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ChatServer extends JFrame implements ActionListener{
	JTextArea jta;
	JButton jbtnExit;
	JScrollPane jsp;
	Font f = new Font("±¼¸²Ã¼", Font.PLAIN, 22);
	
	public ChatServer() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		jta = new JTextArea();
		jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jbtnExit = new JButton("Á¾·á");
		
		jta.setFont(f);
		add(jsp, "Center");
		add(jbtnExit, "South");
		
		jbtnExit.addActionListener(this);
		
		setBounds(100, 100, 600, 1000);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		ChatServer cs = new ChatServer();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(jbtnExit == obj) {
		}
	}
}
