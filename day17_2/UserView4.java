package day17_2;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import day15.Lotto;

public class UserView4 extends Thread {//implements Runnable
	static JButton[] jbtn = new JButton[6];
	static ImageIcon[] img = new ImageIcon[45];
	static int[] viewNum = new int[6];
	
	public UserView4(JButton[] jbtn, ImageIcon[] img) {
		super();
		this.jbtn = jbtn;
		this.img = img;
	}

	@Override
	public void run() {
		int delay = 0;
		// TODO Auto-generated method stub
		System.out.println("»ý¼ºµÊ");
		for (int j = 0; j < 70; j++) {
			Lotto lot = new Lotto();
			for (int i = 0; i < 6; i++) {
				try {
					Thread.sleep(delay);
					lot.shuffle();
					viewNum = lot.get();
					jbtn[i].setIcon(img[viewNum[i]]);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(j<=35)
				continue;
			else
				if(delay<=35)
					delay++;
		}
	}
}