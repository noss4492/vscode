package day17;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;

// ������ ������ ������ ���� �ʰ�
// ���� ���ÿ� ������ �� �ְ� ��Ƽ ������ ó��
public class Horse extends Thread{
	JButton jbtn;	// ��ư ������ ���� ��
	ImageIcon img1, img2;	// 1 ����, 2 �޸���
	Object btnSrc;
	
	public Horse(JButton jbtn) {
		super();
		this.jbtn = jbtn;
	}
	
	public Horse(JButton jbtn, ImageIcon img1, ImageIcon img2) {
		super();
		this.jbtn = jbtn;
		this.img1 = img1;
		this.img2 = img2;
	}

	public Horse(JButton jbtn, ImageIcon img1, ImageIcon img2, Object btnSrc) {
		super();
		this.jbtn = jbtn;
		this.img1 = img1;
		this.img2 = img2;
		this.btnSrc = btnSrc;
	}

	@Override
	public void run() {
		super.run();
		this.jbtn.setIcon(img2);
		boolean f = false;
		
		int a = (int) (Math.random()*10)+1;
		while(f==false) {
			int x = jbtn.getX();
			int y = jbtn.getY();
//			Random rnd = new Random();				// �̰� ������
//			int b = rnd.nextInt()*10 + 1; 
//			x += b;
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			x += a;
			
			jbtn.setLocation(x, y);
			if(x >= 690) {
				f = true;
			}
			
//			if(btnSrc)
		
				
				
				
				
				
		}
	}	//���ÿ� ó���� �ڵ�, ��ư�� ���������� �̵���Ű��
	
}
