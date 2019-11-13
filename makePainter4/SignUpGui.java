package makePainter4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SignUpGui extends JFrame implements ActionListener,WindowListener{
	JLabel txtId, txtPw, txtPwcon, txtName;
	JTextField inputId, inputPw, inputPwcon, inputName;
	JButton btnSignup, btnCencel;
	JButton btnChar1, btnChar2, btnChar3, btnChar4;
	
	SignUpGui(){
		super("회원가입");
		
		//Layout 초기화
		setLayout(null);
		
		//컴포넌트 초기화
		btnSignup = new JButton("가입");
		btnCencel = new JButton("취소");
		
		btnChar1 = new JButton();
		btnChar2 = new JButton();
		btnChar3 = new JButton();
		btnChar4 = new JButton();
		
		txtId = new JLabel("아이디");
		txtPw = new JLabel("비밀번호");
		txtPwcon = new JLabel("비밀번호 확인");
		txtName = new JLabel("닉네임");
		
		inputId = new JTextField();
		inputPw = new JTextField();
		inputPwcon = new JTextField();
		inputName = new JTextField();
		
		//컴포넌트 포지션
		btnSignup.setBounds(150,550,140,50);
		btnSignup.addActionListener(this);
		btnCencel.setBounds(300,550,140,50);
		btnCencel.addActionListener(this);
		
		btnChar1.setBounds(80,400,100,120);
		btnChar2.setBounds(190,400,100,120);
		btnChar3.setBounds(300,400,100,120);
		btnChar4.setBounds(410,400,100,120);
		
		txtId.setBounds(200,120,80,30);
		txtPw.setBounds(185,190,80,30);
		txtPwcon.setBounds(155,230,90,30);
		txtName.setBounds(200,300,80,30);
		
		inputId.setBounds(250,120,200,30);
		inputPw.setBounds(250,190,200,30);
		inputPwcon.setBounds(250,230,200,30);
		inputName.setBounds(250,300,200,30);
		
		//기타 Event
		addWindowListener(this);
		
		//컴포넌트  add
		add(btnSignup);
		add(btnCencel);
		
		add(btnChar1);
		add(btnChar2);
		add(btnChar3);
		add(btnChar4);
		
		add(txtId);
		add(txtPw);
		add(txtPwcon);
		add(txtName);
		
		add(inputId);
		add(inputPw);
		add(inputPwcon);
		add(inputName);
		
		//window
		setBounds(100,50,600,700);
		setVisible(true);
		
	}
	//test main ----------------------------------
	public static void main(String[] args) {
		new SignUpGui();
	}//test main end ---------------------------------
	
	//Action Event -----------------------------------
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btnSignup) { //      가입버튼 !!!
			setVisible(false);
			
			
		}else if(obj == btnCencel){ //  취소 버튼 !!
			setVisible(false);
			
		}
	}//Action Event end ---------------------------------
	
	//Window Event ----------------------------------------
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		setVisible(false);
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}// window Event end -------------------------------------------

}
