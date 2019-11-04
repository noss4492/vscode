package day17_2;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import day15.Lotto;

public class UserView3 extends Thread {// implements Runnable
	static JButton[] jbtn = new JButton[6];
	static ImageIcon[] img = new ImageIcon[45];

	public UserView3(JButton[] jbtn, ImageIcon[] img) {
		super();
		this.jbtn = jbtn;
		this.img = img;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("»ý¼ºµÊ");
		for (int j = 0; j < 2; j++) {
			Lotto lot = new Lotto();
			for (int a = 0; a < 45; a++) {
				for (int k = 0; k < 6; k++) {
					try {
						Thread.sleep(1);
						jbtn[k].setIcon(img[a]); // i
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			Lotto lot2 = new Lotto();
			int[] winArr = lot2.get();
			for (int i = 0; i < 6; i++) {
				jbtn[i].setIcon(img[winArr[i]]); // i
			}
		}
	}
}