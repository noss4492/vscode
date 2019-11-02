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

public class Hw5 extends Frame implements ActionListener, WindowListener, KeyListener{
	final static int WIDTH = 800;
	final static int HEIGHT = 600;
	final static int ARM_WIDTH = 5;
	final static int ARM_HEIGHT = 10;
	final static int LEG_WIDTH = 5;
	final static int LEG_HEIGHT = 10;
	final static int BODY_WIDTH = 11;	// leg w1 + w2 + m -> 110
	final static int BODY_HEIGHT = 15;
	final static int HEAD_WIDTH = 11;
	final static int HEAD_HEIGHT = 8;
	final static int MARGIN = 1;	// 편의상 m으로 주석에 표기
	
	Button btnHead, btnBody, btnLeftArm, btnRightArm, btnLeftLeg, btnRightLeg;
	Button btnFire;
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
	public Hw5() {
		super("ROBOT1");
		setLayout(null);
		//(x, y is body button point)
		initX = ARM_WIDTH + MARGIN + ARM_WIDTH + BODY_WIDTH + MARGIN + ARM_WIDTH; 
		initY = HEIGHT-(LEG_HEIGHT + MARGIN + BODY_HEIGHT)-10;
		x = initX;
		y = initY;
		cx = x+BODY_WIDTH/2;
		cy = y+BODY_HEIGHT/2;
		
		btnHead = new Button("^ ^");
		btnBody = new Button("BODY");
		btnLeftArm = new Button("L.ARM");
		btnRightArm = new Button("R.ARM");
		btnLeftLeg = new Button("L.Leg");
		btnRightLeg = new Button("R.LEG");
		btnFire = new Button("X");
		
		// 계산 기준은 바디 버튼의 좌측상단 포인트. x, y
		btnHead.setBounds(x, y - MARGIN - HEAD_HEIGHT, HEAD_WIDTH, HEAD_HEIGHT);
		btnBody.setBounds(x, y, BODY_WIDTH, BODY_HEIGHT);
		btnLeftArm.setBounds(x - MARGIN-ARM_WIDTH, y, ARM_WIDTH, ARM_HEIGHT);
		btnRightArm.setBounds(x + BODY_WIDTH + MARGIN, y, ARM_HEIGHT, ARM_WIDTH);
		btnLeftLeg.setBounds(x, y + BODY_HEIGHT + MARGIN, LEG_WIDTH, LEG_HEIGHT);
		btnRightLeg.setBounds(x + BODY_WIDTH-LEG_WIDTH, y + BODY_HEIGHT + MARGIN,LEG_WIDTH, LEG_HEIGHT);
		btnFire.setBounds(WIDTH-50, HEIGHT-50, 40, 40);
		
		btnBody.addKeyListener(this);
		btnHead.addKeyListener(this);
		btnLeftArm.addKeyListener(this);
		btnRightArm.addKeyListener(this);
		btnLeftLeg.addKeyListener(this);
		btnRightLeg.addKeyListener(this);
		
		btnFire.addActionListener(this);
		
		add(btnHead);
		add(btnBody);
		add(btnLeftArm);
		add(btnRightArm);
		add(btnLeftLeg);
		add(btnRightLeg);
		add(btnFire);
		
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
		new Hw5();	// 참조 변수 담을 필요 없이 생성자만 쓰고 있음.
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		System.out.println(code);
		int x = btnBody.getX();
		int y = btnBody.getY();
		int initMoveY = y;
		int ny = 0;
		int speed = 15;
		int vx = 1;
		int vy = 1;
		int a = 0;
		int gy = 1;
		// 37~40 좌상우하
		int cnt = 0;
		int t = 0;
		int pastTime = 0;
		switch(code) {
		case 8:	// backspace test 작동안됨 ㅠ.ㅠ y값이 int로 내려져서 계속 0으로 잡히는듯
			t=0;
			for(int i = 0; i <= 200; i++) {
				if(x>=WIDTH)
					x=initX;
				if(y>=HEIGHT)
					y=HEIGHT-initY;
				if(x<=0)
					x=WIDTH-initX;
				if(y<=0)
					y=initY;
				
				int pastT = t;
				int tmpY=y;
				t++;
				x++;	// 수평 이동속도 조정x = x + vx 
				
				// 이런식으로 하는거 같은데 int 타입이라 안되는듯
				// jump 0,0 -> 200,100 -> 0, 200
				// 이 곡선은 시점에 따라 움직인 그래프가 되어야함 x - t
				// 점프거리(x-WIDTH/8)*2 
				double tmpPy = (-0.02*Math.pow(((x-WIDTH/8)-pastT/8),2)+200);//상수는 제거됨
				double tmpNy = (-0.02*Math.pow(((x-WIDTH/8)-t/8),2)+200);
				y += (int)(tmpNy - tmpPy);
				System.out.printf("[y:%3d][tmpPy:%3.1f][tmpNy:%3.1f],[d:%3.1f]\t"
														,y, tmpPy, tmpNy, tmpPy-tmpNy);
				// diff of y(t) + 시작시 높이
				if(y<=0 || y>=HEIGHT-100) {
					y=tmpY;
					continue;
				}
				
//				System.out.printf("x:%2dy:%2d\n",x,y);
				System.out.printf("적용된 ny:%3d\n",y);
				robotPoint(x, y);
				try {
					Thread.sleep(1,500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			break;

		case 32:			//-100~50 (-3~-1)
			for(int i = -100; i <= 100; i ++) {
				if(i<=35 && i>=-35) {	// 중간에 가속도 낮은 부분 스킵
					continue;	
				}
				a = -(i/30);
				

				if(x>=WIDTH)
					x=initX;
				if(y>=HEIGHT)
					y=HEIGHT-initY;
				if(x<=0)
					x=WIDTH-initX;
				if(y<=0)
					y=initY;
				
				x += vx;
				y -= 1*vy*a;
				
				
				System.out.printf("x:%2dy:%2d\n",x,y);
				robotPoint(x, y);
				try {
					Thread.sleep(1,500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			// 이차함수 써서 어떻게 만듬 ㅠ.ㅠ...
			// y = -k(x-initX)^2+initY
			// y = (int) (-0.002*Math.pow((x-WIDTH/5),2))+HEIGHT/2;
			// 이런식으로 작성하면 x좌표로 한바퀴 돌았을때 문제가 됨.
			// 변하는 값만 필요하니까 a*x^2+b*x^1의 a, b만 필요한데 귀찮음
			
			// 야매
			// x좌표는 점진적으로 증가하고 끝에 도달하면 다시 초기점으로
			// y는 가속도 영향 받아서 떨어지게 2차곡선 수식으로 구하려고 했으나
			// 그냥 가속도에 중점을 둬서 바뀌게 구현하였음. 
			
			
			// Math.abs(Math.sin(10*(x - HEIGHT/2)))
			// y = k*(x-HEIGHT/10)+HEIGHT;
			// a*x^2+b*x -> 원래 이걸로 x 식 세우면 됨
//				y = (int)(100*Math.sin(1*((double)i*3.6-(double)0/4)));
//				if(y>initY) {
//					y = initY;
//					break;
//				}
			
			//btnBody.setLocation(x, y);
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
		System.out.printf("키보드 눌렸을때 [x:%2d, y:%2d]\n", x , y);
		robotPoint(x, y);
	}
	
	public void robotPoint(int x, int y) {
		btnHead.setLocation(x, y - MARGIN - HEAD_HEIGHT);
		btnBody.setLocation(x,y);
		btnLeftArm.setLocation(x - MARGIN-ARM_WIDTH, y);
		btnRightArm.setLocation(x + BODY_WIDTH + MARGIN, y);
		btnLeftLeg.setLocation(x, y + BODY_HEIGHT + MARGIN);
		btnRightLeg.setLocation(x + BODY_WIDTH-LEG_WIDTH, y + BODY_HEIGHT + MARGIN);
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
	public void actionPerformed(ActionEvent e) {	// 작아지니 개쌔짐
		String cmd = e.getActionCommand();
		x = btnRightArm.getX();
		y = btnRightArm.getY();
		if(cmd.equalsIgnoreCase("X")){
			for(int i = -200; i <= 200; i ++) {
				int a = Math.abs(i)/50; //+0~+3 i=0일때 제일 높도록.
				int vx = 1;
				if(i<0)
					x += vx*a;
				else if(i>0)
					x -= vx*a;
				btnRightArm.setLocation(x + BODY_WIDTH + MARGIN, y);
				try {
					Thread.sleep(0, 1);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}



//중점에서 초고속
//a = -(i/30);
//if(i<=50 || i>=-50) {
//	if(i<=35 && i>=-35) {
//		continue;
//	}
//	a = -i/10;
//	System.out.println("a:::"+a);
//}
