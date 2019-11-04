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

// 1. 로또
// 2. 로또 이미지 결과
// 3. 잠깐동안 랜덤이미지 돌아가게 출력(111111->222222->33333....)
// 4. 멀티쓰레드 (각각 4 9 13 29 1 -> 3 9 4 10 23 ...)

public class LottoMachine2 extends JFrame implements ActionListener {
	final static int WIDTH = 800;
	final static int HEIGHT = 600;
	final static int B_SIZE = 70;
	Font f = new Font("MyFont", Font.BOLD, 26);
	JButton btnStart;
	static JButton[] jbtn = new JButton[6];
	static ImageIcon[] img = new ImageIcon[45];
	int[] winNum = new int[6];
	ImageIcon qImgIcon = new ImageIcon();
	
	File path = new File("src/images/");
	final String pattern = "ball";
	
	String fileList[] = path.list(new FilenameFilter() {
		@Override
		public boolean accept(File dir, String name) {
			// TODO Auto-generated method stub
			return name.startsWith(pattern);
		}
	});

	LottoMachine2() {
		super("행복복권");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		win = .get();
				
		if(fileList.length > 0){	// 폴더 내 패턴과 일치하는 이미지 파일명 확인
		    for(int i=0; i < fileList.length; i++){
		  System.out.println(fileList[i]) ;
		    }
		}
		
		for(int i = 0; i < 45; i++) {	// 이미지 아이콘 생성(45개의 공 이미지)
			img[i] = new ImageIcon("src/images/"+fileList[i]);
		}
		
		qImgIcon = new ImageIcon("src/images/q.jpg");
		Image qimg = qImgIcon.getImage();
		Image changedImg = qimg.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
		ImageIcon qIcon = new ImageIcon(changedImg);
		
		for (int i = 0; i < 6; i++) {	// user에게 보여줄 슬롯 버튼 배치
//			jbtn[i] = new JButton(img[i]);		// 1. img[i] -> get()해온 인자를 배치
//			jbtn[i] = new JButton(""+winNum[i]);
			jbtn[i] = new JButton(qIcon);
			jbtn[i].setBounds(425-(3-i)*120, HEIGHT/5, B_SIZE, B_SIZE);
			add(jbtn[i]);
		}
		
		btnStart = new JButton("생성");
		btnStart.setBounds(WIDTH/4, 475, WIDTH/2, HEIGHT/10);
		btnStart.addActionListener(this);
		add(btnStart);

		setSize(WIDTH, HEIGHT);
		setLocation(30, 30);
		setVisible(true);
	}

	public static void main(String[] args) {
					
		LottoMachine2 hl = new LottoMachine2();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(btnStart == e.getSource()) {
			System.out.println("생성됨");
			Lotto lot = new Lotto();
			winNum = lot.get();			// 당첨번호 받앙홈
			for(int i = 0; i < 6; i ++) {
				jbtn[i].setIcon(img[winNum[i]]);	//i
			}
		}
	}
}
