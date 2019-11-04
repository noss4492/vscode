package day17;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Racing extends JFrame implements ActionListener { // ����� �����带 ��ӹ޴°�?
	static JButton[] btnHorse = new JButton[3];
	static JButton btnStart;
	ImageIcon img1, img2;

	Racing() {
		super("�渶��");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		img1 = new ImageIcon("src/images/horse.gif");
		img2 = new ImageIcon("src/images/horsestop.gif");

		btnHorse[0] = (JButton) new JButton(img2);
		btnHorse[1] = (JButton) new JButton(img2);
		btnHorse[2] = (JButton) new JButton(img2);
		btnStart = new JButton("����");

		btnHorse[0].setBounds(20, 50, 100, 60);
		btnHorse[1].setBounds(20, 200, 100, 60);
		btnHorse[2].setBounds(20, 350, 100, 60);
		btnStart.setBounds(150, 500, 500, 30);

		btnHorse[0].addActionListener(this);
		btnHorse[1].addActionListener(this);
		btnHorse[2].addActionListener(this);
		btnStart.addActionListener(this);

		add(btnHorse[0]);
		add(btnHorse[1]);
		add(btnHorse[2]);
		add(btnStart);

		setSize(800, 600);
		setLocation(100, 100);
		setVisible(true);
	}

	public static void main(String[] args) {
		Racing r = new Racing();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		Object btnSrc = e.getSource();
		boolean f = false;
		boolean sf = false;
		Horse[] h = null;
		
		
		
		if (cmd == "����") {
			if (h == null) {			//hmm.... �迭�̶� �� �ȵǳ�?
//			if (f == false) {			//hmm....
				h = new Horse[3];
				for (int i = 0; i <= 2; i++) {
					h[i] = new Horse(btnHorse[i], img1, img2, btnSrc);
				}
				h[0].setPriority(Thread.MAX_PRIORITY);
				h[2].setPriority(Thread.MIN_PRIORITY);
				for (int i = 0; i <= 2; i++) {
					h[i].start();
				}
				sf = true;
			}
		}
		
		

//		else if (btnHorse[0] == btnSrc) {	-> ���� �������?
//			int x2 = btnHorse[0].getX();
//			x2 += 10;
//			int y2 = btnHorse[0].getY();
//			btnHorse[0].setLocation(x2+10, y2);
//		}

//		Horse h1 = new Horse(btnHorse[0], img1, img2);
//		Horse h2 = new Horse(btnHorse[1], img1, img2);
//		Horse h3 = new Horse(btnHorse[2], img1, img2);		
//		h1.start();
//		h2.start();
//		h3.start();

	}
}
