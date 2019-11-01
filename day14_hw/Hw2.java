package day14_hw;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Hw2 extends Frame implements ActionListener, WindowListener, KeyListener{
	final static int WIDTH = 800;
	final static int HEIGHT = 600;
	final static int ARM_WIDTH = 50;
	final static int ARM_HEIGHT = 100;
	final static int LEG_WIDTH = 50;
	final static int LEG_HEIGHT = 100;
	final static int BODY_WIDTH = 110;	// leg w1 + w2 + m -> 110
	final static int BODY_HEIGHT = 150;
	final static int HEAD_WIDTH = 110;
	final static int HEAD_HEIGHT = 80;
	final static int MARGIN = 5;	// 편의상 m으로 주석에 표기
	
//	Button btnHead, btnBody, btnLeftArm, btnRightArm, btnLeftLeg, btnRightLeg;
	Button[] btn = new Button[6]; 	//head body l.arm r.leg l.leg r.leg 
	Font f = new Font("MyFont", Font.BOLD, 26);
	int x, y, cx, cy;
	int initX, initY;
	int xHead, yHead;
	int xBody, yBody;
	int xLeg1, xLeg2, yLeg1, yLeg2;
	int xArm1, xArm2, yArm1, yArm2;
	
// 로봇 객체의 총 너비 /높이
// 손을 내린 정 자세에서의 범위
// 너비 ARM_WIDTH(50) + margin + ARM_WIDTH(50) + BODY_WIDTH(110) + margin ARM_WIDTH(50)
// 높이 HEAD_HEIGHT(80) + margin + BODY_HEIGHT(100) + margin + LEG_HEIGHT(100)
// 오른손 들면
// 너비 ARM_WIDTH(50) + margin + ARM_WIDTH(50) + BODY_WIDTH(110) + margin ARM_HEIGHT(100)
	
	
	//LEG H + M + BODY H = 0 -> 지면에 착지한 높이 (바디 포인트)
	public Hw2() {
		super("ROBOT1");
		setLayout(null);
		//(x, y is body button point)
		initX = ARM_WIDTH + MARGIN + ARM_WIDTH + BODY_WIDTH + MARGIN + ARM_WIDTH; 
		initY = LEG_HEIGHT + MARGIN + BODY_HEIGHT;
		x = initX;
		y = initY;
		cx = x+BODY_WIDTH/2;
		cy = y+BODY_HEIGHT/2;
		
		btn[0] = new Button("^ ^");
		btn[1] = new Button("BODY");
		btn[2] = new Button("L.ARM");
		btn[3] = new Button("R.ARM");
		btn[4] = new Button("L.Leg");
		btn[5] = new Button("R.LEG");
		
		// 계산 기준은 바디 버튼의 좌측상단 포인트. x, y
		btn[0].setBounds(x, y - MARGIN - HEAD_HEIGHT, HEAD_WIDTH, HEAD_HEIGHT);
		btn[1].setBounds(x, y, BODY_WIDTH, BODY_HEIGHT);
		btn[2].setBounds(x - MARGIN-ARM_WIDTH, y, ARM_WIDTH, ARM_HEIGHT);
		btn[3].setBounds(x + BODY_WIDTH + MARGIN, y, ARM_HEIGHT, ARM_WIDTH);
		btn[4].setBounds(x, y + BODY_HEIGHT + MARGIN, LEG_WIDTH, LEG_HEIGHT);
		btn[5].setBounds(x + BODY_WIDTH-LEG_WIDTH, y + BODY_HEIGHT + MARGIN,LEG_WIDTH, LEG_HEIGHT);
		
		for(int i = 0; i < 6; i ++) {
			btn[i].addKeyListener(this);
			add(btn[i]);
		}
		
		// Frame
		setBounds(100, 100, WIDTH, HEIGHT);
		setVisible(true);
				
		// Exit
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) {
		new Hw2();	// 참조 변수 담을 필요 없이 생성자만 쓰고 있음.
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		System.out.println(code);
		int x = btn[1].getX();
		int y = btn[1].getY();
		int speed = 15;
		int vx = 1;
		int vy = 1;
		int a;
		// 37~40 좌상우하
		switch(code) {
//		case 8:
//			for(int i = -200; i < 200; i ++) {
//				a = Math.abs(i+1)/50; //+0~+3 i=0일때 제일 높도록.
//				System.out.printf("%1d", a);
//				if(x >= WIDTH-btnWidth || x <= 0)
//					x = btnWidth;
//				if(i<0) {
//					x += 1*vx*a/1.5;
//					y -= 1*vy*a;
//					btn.setLocation(x,y);
//				}
//				else{
//					x += 1*vx*a/1.5;
//					y += 1*vy*a;
//					btn.setLocation(x,y);
//				}
//				try {
//					Thread.sleep(0, 1);
//				} catch (InterruptedException e1) {
//					e1.printStackTrace();
//				}
//			}
//			break;
		case 32:
			for(int i = -200; i <= 200; i ++) {
				a = Math.abs(i)/50; //+0~+3 i=0일때 제일 높도록.
				System.out.printf("%1d", a);
				if(i<0) {
					y -= 1*vy*a;
					btn[0].setLocation(x, y - MARGIN - HEAD_HEIGHT);
					btn[1].setLocation(x,y);
					btn[2].setLocation(x - MARGIN-ARM_WIDTH, y);
					btn[3].setLocation(x + BODY_WIDTH + MARGIN, y);
					btn[4].setLocation(x, y + BODY_HEIGHT + MARGIN);
					btn[5].setLocation(x + BODY_WIDTH-LEG_WIDTH, y + BODY_HEIGHT + MARGIN);
				}
				else if(i>0){
					y += 1*vy*a;
					btn[0].setLocation(x, y - MARGIN - HEAD_HEIGHT);
					btn[1].setLocation(x,y);
					btn[2].setLocation(x - MARGIN-ARM_WIDTH, y);
					btn[3].setLocation(x + BODY_WIDTH + MARGIN, y);
					btn[4].setLocation(x, y + BODY_HEIGHT + MARGIN);
					btn[5].setLocation(x + BODY_WIDTH-LEG_WIDTH, y + BODY_HEIGHT + MARGIN);
				}
				try {
					Thread.sleep(0, 1);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
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
		btn[0].setLocation(x, y - MARGIN - HEAD_HEIGHT);
		btn[1].setLocation(x,y);
		btn[2].setLocation(x - MARGIN-ARM_WIDTH, y);
		btn[3].setLocation(x + BODY_WIDTH + MARGIN, y);
		btn[4].setLocation(x, y + BODY_HEIGHT + MARGIN);
		btn[5].setLocation(x + BODY_WIDTH-LEG_WIDTH, y + BODY_HEIGHT + MARGIN);
		System.out.println("키보드 눌렸을때"+x+"|"+y);
	}
	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("키보드 땔 때");
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void windowActivated(WindowEvent e) {
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

