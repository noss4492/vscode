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
		super("ȸ������");
		
		//Layout �ʱ�ȭ
		setLayout(null);
		
		//������Ʈ �ʱ�ȭ
		btnSignup = new JButton("����");
		btnCencel = new JButton("���");
		
		btnChar1 = new JButton();
		btnChar2 = new JButton();
		btnChar3 = new JButton();
		btnChar4 = new JButton();
		
		txtId = new JLabel("���̵�");
		txtPw = new JLabel("��й�ȣ");
		txtPwcon = new JLabel("��й�ȣ Ȯ��");
		txtName = new JLabel("�г���");
		
		inputId = new JTextField();
		inputPw = new JTextField();
		inputPwcon = new JTextField();
		inputName = new JTextField();
		
		//������Ʈ ������
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
		
		//��Ÿ Event
		addWindowListener(this);
		
		//������Ʈ  add
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
		if(obj == btnSignup) { //      ���Թ�ư !!!
			setVisible(false);
			
			
		}else if(obj == btnCencel){ //  ��� ��ư !!
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
