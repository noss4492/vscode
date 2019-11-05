package day17_3;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/*
src\images\day17_img\Apple.jpg
src\images\day17_img\bell.jpg
src\images\day17_img\Cherry.jpg
src\images\day17_img\Crown.jpg
src\images\day17_img\Diamond.jpg
src\images\day17_img\Seven.jpg
src\images\day17_img\star.jpg
src\images\day17_img\Strawberry.jpg
src\images\day17_img\Watermeron.jpg
*/
// 이 행이 곧 슬롯머신의 열이 된다. 
// 아날로그 슬롯머신은 열이 고정되어 있을 것으로 생각됨
// 슬롯머신을 안 뜯어봐서 모른다. 바다이야기(?)면 열 고정 없어도 될듯

public class Hw5_SlotMachine extends JFrame implements ActionListener {
	final static int WIDTH = 800; // Frame W
	final static int HEIGHT = 600; // Frame H
	final static int B_SIZE = 100; // button size
	final static int MARGIN = 5; // each button margin
	final static int INTERVAL = 100;// INTERVAL must bigger than B_SIZE
	final static int H_PAD = 50; // slot machine screen padding

	Font f = new Font("MyFont", Font.BOLD, 26);
	ImageIcon[][] img = new ImageIcon[3][9];
	ImageIcon imgLever = new ImageIcon();
	JButton btnStart;
	JButton btnSlot[][] = new JButton[3][3];

	Hw5_SlotMachine() {
		super("슬롯머신");
		setLayout(null);
		// 귀찮.. 모든 파일 open
		File path = new File("src/images/day17_img/");
		File[] fileList = path.listFiles();

		// 이미지 아이콘 생성, 1열 9행 x 3
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				img[i][j] = new ImageIcon("" + fileList[j]);
			}
		}
		imgLever = new ImageIcon("src/images/lever1.png");

		// 이미지 사이즈 조절 (위에 구문이랑 같이 쓰게 만들면 좋지만. 일단 가독성을 위해 따로 구분함)
		ImageIcon tmpImgIcon[][] = new ImageIcon[3][9];
		ImageIcon tmpIcon[][] = new ImageIcon[3][9];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				tmpImgIcon[i][j] = new ImageIcon("" + fileList[j]);
				Image tmpimg = tmpImgIcon[i][j].getImage();
				Image changedImg = tmpimg.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
				tmpIcon[i][j] = new ImageIcon(changedImg);
				img[i][j] = tmpIcon[i][j];
			}
		}

		// 이미지아이콘을 인자로 삼아 이미지 버튼 생성
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				btnSlot[i][j] = new JButton(img[i][j]); // (img[i][j]);
				btnSlot[i][j].setBounds(WIDTH / 2 - ((1 - i) * INTERVAL) - B_SIZE / 2, j * 100 + H_PAD, B_SIZE, B_SIZE);
				add(btnSlot[i][j]);
			}
		}
		// 400+100 -> 500
		btnStart = new JButton(imgLever);
		btnStart.setBounds(WIDTH / 2 + 1 * INTERVAL + B_SIZE, H_PAD, B_SIZE / 2, B_SIZE * 3);
		btnStart.addActionListener(this);
		add(btnStart);

		setSize(WIDTH, HEIGHT);
		setLocation(60, 60);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (btnStart == e.getSource()) {
			System.out.println("슬롯머신 작동");

			Runnable[] r = new Runnable[3];
			Thread[] th = new Thread[3];

			for (int i = 0; i < 3; i++) {
				r[i] = new UserViewSlot(i, btnSlot, img);
				th[i] = new Thread(r[i]);
				th[i].start();
				System.out.println("th name : "+th[i].getName()+" col : "+i);
			}
			
			System.out.println("");

			System.out.println("끝남");
		}
	}
}

//			Runnable r1 = new UserViewSlot(0, btnSlot, img);	// 1열
//			Runnable r2 = new UserViewSlot(1, btnSlot, img);	// 2열
//			Runnable r3 = new UserViewSlot(2, btnSlot, img);
//			Thread th1 = new Thread(r1);
//			Thread th2 = new Thread(r2);
//			Thread th3 = new Thread(r3);
//			th1.start();
//			th2.start();
//			th3.start();
