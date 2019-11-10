package day21_2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dao.RoomsixDAO;

public class Register extends JFrame implements ActionListener {
	JLabel jlId, jlPw, jlName, jlGender, JlMot;
	JTextField jtfId, jtfPw, jtfName, jtfMot;
	JTextArea jtaMot;
	JButton jbtnRegister;
	JRadioButton jrbGender1, jrbGender2;
	ButtonGroup bgGender = new ButtonGroup();
	JButton jbtnCancel;
	static final int WIDTH = 400;
	static final int HEIGHT = 550;
	static final int OUTTER_MARGIN = 30;
	static final int WIDTH_MARGIN = 30;
	static final int HEIGHT_MARGIN = 30;
	static final int LABEL_WIDTH = 60;
	static final int BOX_WIDTH = 210;
	static final int BOX_HEIGHT = 30; // LABEL_H = BOX_H
	static final int JTA_HEIGHT = 210;
	static final int BUTTON_WIDTH = 70;
	static final int BUTTON_HEIGHT = 40;
	NewLogin nl;
	
	public Register(NewLogin nl) {
		super("회원가입");
		this.nl = nl;
		setLayout(null);

		jlId = new JLabel("ID");
		jlPw = new JLabel("PW");
		jlName = new JLabel("name");
		jlGender = new JLabel("성별");
		JlMot = new JLabel("가입동기");

		jtfId = new JTextField();
		jtfPw = new JTextField();
		jtfName = new JTextField();
		jtaMot = new JTextArea();
		jbtnRegister = new JButton("등록");
		jbtnCancel = new JButton("취소");

		jrbGender1 = new JRadioButton("남", true);
		jrbGender2 = new JRadioButton("여");

		jtfId.setBounds(OUTTER_MARGIN, OUTTER_MARGIN + (HEIGHT_MARGIN + BOX_HEIGHT), LABEL_WIDTH, BOX_HEIGHT);

		jlId.setBounds(OUTTER_MARGIN, OUTTER_MARGIN, LABEL_WIDTH, BOX_HEIGHT);
		jlPw.setBounds(OUTTER_MARGIN, OUTTER_MARGIN + (HEIGHT_MARGIN + BOX_HEIGHT) * 1, LABEL_WIDTH, BOX_HEIGHT);
		jlName.setBounds(OUTTER_MARGIN, OUTTER_MARGIN + (HEIGHT_MARGIN + BOX_HEIGHT) * 2, LABEL_WIDTH, BOX_HEIGHT);
		jlGender.setBounds(OUTTER_MARGIN, OUTTER_MARGIN + (HEIGHT_MARGIN + BOX_HEIGHT) * 3, LABEL_WIDTH, BOX_HEIGHT);
		JlMot.setBounds(OUTTER_MARGIN, OUTTER_MARGIN + (HEIGHT_MARGIN + BOX_HEIGHT) * 4, LABEL_WIDTH, BOX_HEIGHT);

		jtfId.setBounds(OUTTER_MARGIN + (LABEL_WIDTH + WIDTH_MARGIN), OUTTER_MARGIN, BOX_WIDTH, BOX_HEIGHT);
		jtfPw.setBounds(OUTTER_MARGIN + (LABEL_WIDTH + WIDTH_MARGIN), OUTTER_MARGIN + (HEIGHT_MARGIN + BOX_HEIGHT) * 1,
				BOX_WIDTH, BOX_HEIGHT);
		jtfName.setBounds(OUTTER_MARGIN + (LABEL_WIDTH + WIDTH_MARGIN),
				OUTTER_MARGIN + (HEIGHT_MARGIN + BOX_HEIGHT) * 2, BOX_WIDTH, BOX_HEIGHT);
		jtaMot.setBounds(OUTTER_MARGIN + (LABEL_WIDTH + WIDTH_MARGIN), OUTTER_MARGIN + (HEIGHT_MARGIN + BOX_HEIGHT) * 4,
				BOX_WIDTH, BOX_HEIGHT * 5);

		jrbGender1.setBounds(OUTTER_MARGIN + (LABEL_WIDTH + WIDTH_MARGIN),
				OUTTER_MARGIN + (HEIGHT_MARGIN + BOX_HEIGHT) * 3, BOX_WIDTH / 2, BOX_HEIGHT);
		jrbGender2.setBounds(OUTTER_MARGIN + (LABEL_WIDTH + WIDTH_MARGIN) + (BOX_WIDTH / 2),
				OUTTER_MARGIN + (HEIGHT_MARGIN + BOX_HEIGHT) * 3, BOX_WIDTH / 2, BOX_HEIGHT);

		jbtnRegister.setBounds(OUTTER_MARGIN,
				OUTTER_MARGIN + (HEIGHT_MARGIN + BOX_HEIGHT) * 4 + BOX_HEIGHT * 5 + HEIGHT_MARGIN, BUTTON_WIDTH,
				BUTTON_HEIGHT);
		jbtnCancel.setBounds(WIDTH-OUTTER_MARGIN-BUTTON_WIDTH,
				OUTTER_MARGIN + (HEIGHT_MARGIN + BOX_HEIGHT) * 4 + BOX_HEIGHT * 5 + HEIGHT_MARGIN, BUTTON_WIDTH/2,
				BUTTON_HEIGHT/2);
		bgGender.add(jrbGender1);
		bgGender.add(jrbGender2);
		jrbGender1.setActionCommand("남");
		jrbGender2.setActionCommand("여");
		this.add(jrbGender1);
		this.add(jrbGender2);

		add(jlId);
		add(jlPw);
		add(jlName);
		add(jlGender);
		add(JlMot);
		add(jtfId);
		add(jtfPw);
		add(jtfName);
		add(jtaMot);
		add(jbtnRegister);
		add(jbtnCancel);

		jbtnRegister.addActionListener(this);
		jbtnCancel.addActionListener(this);

		setBounds(100, 100, WIDTH, HEIGHT);
		setVisible(true); // 끝나면 인비저블 하고 다른거 비지블로 ㄱㄱ
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == jbtnRegister) {
			// d회원가입 버튼을 누르면 정보를 가져와서 db입력
			// jtfId, jtfPw, jtfName
			String id = jtfId.getText();
			String name = jtfName.getText();
			String pwd = jtfPw.getText();
			
			System.out.println("|"+id+"|"+name+"|"+pwd);
			String txt = jtaMot.getText();
			String gender = bgGender.getSelection().getActionCommand();
//			ButtonModel bm = bgGender.getSelection();
//			String gender = bm.getActionCommand();
// 			버튼그룹에서 선택한 버튼모델 객체를 리턴받는다. 
// 			버튼 모델에서 선택한 버튼의 ActionCommand를 가졍노다.
			System.out.println(jrbGender1);
			System.out.println(jrbGender2);
			Object[] obj2 = jrbGender1.getSelectedObjects();
			for (Object x : obj2) {
				System.out.println(">"+x);
			}
			
//			System.out.println("id : " + jtfId);
//			System.out.println("name : " + jtfName);
//			System.out.println("pwd : " + jtfPw);
//			System.out.println("mot : " + jtaMot);
//			System.out.println("gender : " + bgGender.getSelection().getActionCommand());
			RoomsixDAO dao = new RoomsixDAO();
			dao.insertOne(id, name, pwd, gender, txt);
			JOptionPane.showConfirmDialog(this, "회원가입성공","환영",JOptionPane.PLAIN_MESSAGE);
			dao.close();
			nl.setVisible(true);
			new NewLogin();
			this.setVisible(false);
		}else if(obj == jbtnCancel) {
			setVisible(false);
		}
		

	}
}
