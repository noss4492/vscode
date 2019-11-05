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
// �� ���� �� ���Ըӽ��� ���� �ȴ�. 
// �Ƴ��α� ���Ըӽ��� ���� �����Ǿ� ���� ������ ������
// ���Ըӽ��� �� ������ �𸥴�. �ٴ��̾߱�(?)�� �� ���� ��� �ɵ�

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
		super("���Ըӽ�");
		setLayout(null);
		// ����.. ��� ���� open
		File path = new File("src/images/day17_img/");
		File[] fileList = path.listFiles();

		// �̹��� ������ ����, 1�� 9�� x 3
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				img[i][j] = new ImageIcon("" + fileList[j]);
			}
		}
		imgLever = new ImageIcon("src/images/lever1.png");

		// �̹��� ������ ���� (���� �����̶� ���� ���� ����� ������. �ϴ� �������� ���� ���� ������)
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

		// �̹����������� ���ڷ� ��� �̹��� ��ư ����
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
			System.out.println("���Ըӽ� �۵�");

			Runnable[] r = new Runnable[3];
			Thread[] th = new Thread[3];

			for (int i = 0; i < 3; i++) {
				r[i] = new UserViewSlot(i, btnSlot, img);
				th[i] = new Thread(r[i]);
				th[i].start();
				System.out.println("th name : "+th[i].getName()+" col : "+i);
			}
			
			System.out.println("");

			System.out.println("����");
		}
	}
}

//			Runnable r1 = new UserViewSlot(0, btnSlot, img);	// 1��
//			Runnable r2 = new UserViewSlot(1, btnSlot, img);	// 2��
//			Runnable r3 = new UserViewSlot(2, btnSlot, img);
//			Thread th1 = new Thread(r1);
//			Thread th2 = new Thread(r2);
//			Thread th3 = new Thread(r3);
//			th1.start();
//			th2.start();
//			th3.start();
