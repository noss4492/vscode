package day14;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ButtonControl extends Frame implements KeyListener {
	Button btn;
	final static int WIDTH = 800;
	final static int HEIGHT = 600;
	final static int btnWidth = 100;
	final static int btnHeight = 100;
	Font f = new Font("MyFont", Font.BOLD, 26);
	
	public ButtonControl() {
		btn = new Button("^3^");
		setLayout(null);
		btn.setBounds(200, 400, 100, 100);
		btn.addKeyListener(this);
		btn.setFont(f);
		add(btn);
				
		
		//exit
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		
		
		setBounds(100, 100, WIDTH, HEIGHT);
		setVisible(true);
	}
	public static void main(String[] args) {
		// ButtonControl bc=  참조변수 안 담아도 됨
		new ButtonControl();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		System.out.println(code);
		int x = btn.getX();
		int y = btn.getY();
		int speed = 15;
		int vx = 1;
		int vy = 1;
		int a;
		// 37~40 좌상우하
		switch(code) {
		case 8:
			for(int i = -200; i < 200; i ++) {
				a = Math.abs(i+1)/50; //+0~+3 i=0일때 제일 높도록.
				System.out.printf("%1d", a);
//				btn.setLocation(x+(int)(Math.random()*WIDTH/100), 
//						y+(int)(Math.random()*HEIGHT/100));
				if(x >= WIDTH-btnWidth || x <= 0)
					x = btnWidth;
				if(i<0) {
					x += 1*vx*a/1.5;
					y -= 1*vy*a;
					btn.setLocation(x,y);
				}
				else{
					x += 1*vx*a/1.5;
					y += 1*vy*a;
					btn.setLocation(x,y);
				}
				try {
					Thread.sleep(0, 1);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			break;
		case 32:
			for(int i = -200; i < 200; i ++) {
				a = Math.abs(i+1)/50; //+0~+3 i=0일때 제일 높도록.
				System.out.printf("%1d", a);
//				btn.setLocation(x+(int)(Math.random()*WIDTH/100), 
//						y+(int)(Math.random()*HEIGHT/100));
				if(i<0) {
					y -= 1*vy*a;
					btn.setLocation(x,y);
				}
				else{
					y += 1*vy*a;
					btn.setLocation(x,y);
				}
				try {
					Thread.sleep(0, 1);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				/*				
				long delay = 10;
				long start = System.currentTimeMillis();
				// <- 딜레이 줄  동작 코드 부분
				long end = System.currentTimeMillis();
				while( start - end < delay )
					start = System.currentTimeMillis();  */
			}
			break;
		case 37:
			x-=speed;
			break;
		case 38:
			y-=speed;
			break;
		case 39:
			x+=speed;
			break;
		case 40:
			y+=speed;
			break;
		}
		
		btn.setLocation(x, y);
//		if((btn.getX() <= WIDTH-btnWidth && btn.getX() >= 0+btnWidth) &&
//				(btn.getY() <= HEIGHT-btnHeight && btn.getY() >= 0+btnHeight))
//			btn.setLocation(x, y);
//		else
//			btn.setLocation(50,400);
			
		// 이전 실행 단계로 원복 해줘야함.
		
		
		
		
		System.out.println("키보드 눌렸을때");
	}
	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("키보드 땔 때");
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
}
