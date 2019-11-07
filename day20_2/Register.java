package day20_2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Register extends JFrame implements ActionListener{
	JLabel jlId, jlPw, jlName, jlGender, JlMot;
	JTextField jtfId, jtfPw, jtfName, jtfMot;
	JTextArea jtaMot;
	JButton jbtnRegister;
	JRadioButton jrbGender1, jrbGender2;
	static final int WIDTH = 400;
	static final int HEIGHT = 550;
	static final int OUTTER_MARGIN = 30;
	static final int WIDTH_MARGIN = 30;
	static final int HEIGHT_MARGIN = 30;
	static final int LABEL_WIDTH = 60;
	static final int BOX_WIDTH = 210;
	static final int BOX_HEIGHT = 30;		// LABEL_H = BOX_H
	static final int JTA_HEIGHT = 210;
	static final int BUTTON_WIDTH = 70;
	static final int BUTTON_HEIGHT = 40;
	
	public Register() {
		super("회원가입");
		setLayout(null);
		
		jlId = new JLabel("ID");
		jlPw= new JLabel("PW");
		jlName= new JLabel("name");
		jlGender= new JLabel("성별");
		JlMot= new JLabel("가입동기");
		
		jtfId= new JTextField();
		jtfPw= new JTextField();
		jtfName= new JTextField();
		jtaMot= new JTextArea();
		jbtnRegister= new JButton("등록");
		
		ButtonGroup bgGender = new ButtonGroup();
		jrbGender1 = new JRadioButton("남");
		jrbGender2 = new JRadioButton("여");
	
		jtfId.setBounds(OUTTER_MARGIN, OUTTER_MARGIN+(HEIGHT_MARGIN+BOX_HEIGHT), LABEL_WIDTH, BOX_HEIGHT);
		
		jlId.setBounds(OUTTER_MARGIN, OUTTER_MARGIN, LABEL_WIDTH, BOX_HEIGHT);
		jlPw.setBounds(OUTTER_MARGIN, OUTTER_MARGIN+(HEIGHT_MARGIN+BOX_HEIGHT)*1, LABEL_WIDTH, BOX_HEIGHT);
		jlName.setBounds(OUTTER_MARGIN, OUTTER_MARGIN+(HEIGHT_MARGIN+BOX_HEIGHT)*2, LABEL_WIDTH, BOX_HEIGHT);
		jlGender.setBounds(OUTTER_MARGIN, OUTTER_MARGIN+(HEIGHT_MARGIN+BOX_HEIGHT)*3, LABEL_WIDTH, BOX_HEIGHT);
		JlMot.setBounds(OUTTER_MARGIN, OUTTER_MARGIN+(HEIGHT_MARGIN+BOX_HEIGHT)*4, LABEL_WIDTH, BOX_HEIGHT);
		
        jtfId.setBounds(OUTTER_MARGIN+(LABEL_WIDTH+WIDTH_MARGIN), OUTTER_MARGIN, BOX_WIDTH, BOX_HEIGHT);
        jtfPw.setBounds(OUTTER_MARGIN+(LABEL_WIDTH+WIDTH_MARGIN), OUTTER_MARGIN+(HEIGHT_MARGIN+BOX_HEIGHT)*1, BOX_WIDTH, BOX_HEIGHT);
        jtfName.setBounds(OUTTER_MARGIN+(LABEL_WIDTH+WIDTH_MARGIN), OUTTER_MARGIN+(HEIGHT_MARGIN+BOX_HEIGHT)*2, BOX_WIDTH, BOX_HEIGHT);
        jtaMot.setBounds(OUTTER_MARGIN+(LABEL_WIDTH+WIDTH_MARGIN), OUTTER_MARGIN+(HEIGHT_MARGIN+BOX_HEIGHT)*4, BOX_WIDTH, BOX_HEIGHT*5);
        
        jrbGender1.setBounds(OUTTER_MARGIN+(LABEL_WIDTH+WIDTH_MARGIN), OUTTER_MARGIN+(HEIGHT_MARGIN+BOX_HEIGHT)*3, BOX_WIDTH/2, BOX_HEIGHT);
        jrbGender2.setBounds(OUTTER_MARGIN+(LABEL_WIDTH+WIDTH_MARGIN)+(BOX_WIDTH/2), OUTTER_MARGIN+(HEIGHT_MARGIN+BOX_HEIGHT)*3, BOX_WIDTH/2, BOX_HEIGHT);
        
        jbtnRegister.setBounds(OUTTER_MARGIN, OUTTER_MARGIN+(HEIGHT_MARGIN+BOX_HEIGHT)*4+BOX_HEIGHT*5+HEIGHT_MARGIN, BUTTON_WIDTH, BUTTON_HEIGHT);
        bgGender.add(jrbGender1);
        bgGender.add(jrbGender2);
        this.add(jrbGender1);
        this.add(jrbGender2);
        
        add(jlId); add(jlPw); add(jlName); add(jlGender); add(JlMot); add(jtfId); add(jtfPw);
        add(jtfName); add(jtaMot); add(jbtnRegister); 
		
        
        jbtnRegister.addActionListener(this);
        
        setBounds(100, 100, WIDTH, HEIGHT);
		setVisible(true); //끝나면 인비저블 하고 다른거 비지블로 ㄱㄱ
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == jbtnRegister) {
			
			this.setVisible(false);
			new NewLogin();
		}
	}
}
