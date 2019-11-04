package day17;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;

// 각각의 말들이 영향을 받지 않고
// 따로 동시에 동작할 수 있게 멀티 쓰레드 처리
public class Horse extends Thread{
	JButton jbtn;	// 버튼 참조값 담을 애
	ImageIcon img1, img2;	// 1 정지, 2 달리기
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
//			Random rnd = new Random();				// 이게 차이점
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
	}	//동시에 처리할 코드, 버튼을 오른쪽으로 이동시키기
	
}
