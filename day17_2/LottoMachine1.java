package day17_2;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import day15.Lotto;

// 1. �ζ�
// 2. �ζ� �̹��� ���
// 3. ��񵿾� �����̹��� ���ư��� ���(111111->222222->33333....)
// 4. ��Ƽ������ (���� 4 9 13 29 1 -> 3 9 4 10 23 ...)

public class LottoMachine1 extends JFrame implements ActionListener {
	final static int WIDTH = 800;
	final static int HEIGHT = 600;
	final static int B_SIZE = 70;
	Font f = new Font("MyFont", Font.BOLD, 26);
	JButton btnStart;
	static JButton[] jbtn = new JButton[6];
	ImageIcon[] img = new ImageIcon[45];
	ImageIcon qImgIcon = new ImageIcon();
	int[] winNum = new int[6];
	
	File path = new File("src/images/");
	final String pattern = "ball";
	
	String fileList[] = path.list(new FilenameFilter() {
		@Override
		public boolean accept(File dir, String name) {
			// TODO Auto-generated method stub
			return name.startsWith(pattern);
		}
	});

	LottoMachine1() {
		super("�ູ����");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
				
		if(fileList.length > 0){	// ���� �� ���ϰ� ��ġ�ϴ� �̹��� ���ϸ� Ȯ��
		    for(int i=0; i < fileList.length; i++){
		    	System.out.println(fileList[i]);
		    }
		}
		
		for(int i = 0; i < 45; i++) {	// �̹��� ������ ����(45���� �� �̹���)
			img[i] = new ImageIcon("src/images/"+fileList[i]);
		}
		
		for (int i = 0; i < 6; i++) {	// user���� ������ ���� ��ư ��ġ
			jbtn[i] = new JButton();
			jbtn[i].setBounds(425-(3-i)*120, HEIGHT/5, B_SIZE, B_SIZE);
			add(jbtn[i]);
		}
		
		btnStart = new JButton("����");
		btnStart.setBounds(WIDTH/4, 475, WIDTH/2, HEIGHT/10);
		btnStart.addActionListener(this);
		add(btnStart);

		setSize(WIDTH, HEIGHT);
		setLocation(30, 30);
		setVisible(true);
	}

	public static void main(String[] args) {
					
		LottoMachine1 hl = new LottoMachine1();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(btnStart == e.getSource()) {
			System.out.println("������");
			Lotto lot = new Lotto();
			winNum = lot.get();			// ��÷��ȣ �޾�Ȩ
			for(int i = 0; i < 6; i ++) {
				jbtn[i].setLabel(""+winNum[i]);	// why why T.T
			}
		}
		
	}
}
