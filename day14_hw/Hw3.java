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

public class Hw3 extends Frame implements ActionListener, WindowListener, KeyListener{
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
	final static int MARGIN = 5;	// ���ǻ� m���� �ּ��� ǥ��
	
	Button btnHead, btnBody, btnLeftArm, btnRightArm, btnLeftLeg, btnRightLeg;
	Button btnFire;
	Font f = new Font("MyFont", Font.BOLD, 26);
	int x, y, cx, cy;
	int initX, initY;
	int xHead, yHead;
	int xBody, yBody;
	int xLeg1, xLeg2, yLeg1, yLeg2;
	int xArm1, xArm2, yArm1, yArm2;
	
// �κ� ��ü�� �� �ʺ� /����
// ���� ���� �� �ڼ������� ����
// �ʺ� ARM_WIDTH(50) + margin + ARM_WIDTH(50) + BODY_WIDTH(110) + margin ARM_WIDTH(50)
// ���� HEAD_HEIGHT(80) + margin + BODY_HEIGHT(100) + margin + LEG_HEIGHT(100)
// ������ ���
// �ʺ� ARM_WIDTH(50) + margin + ARM_WIDTH(50) + BODY_WIDTH(110) + margin ARM_HEIGHT(100)
	
	
	//LEG H + M + BODY H = 0 -> ���鿡 ������ ���� (�ٵ� ����Ʈ)
	public Hw3() {
		super("ROBOT1");
		setLayout(null);
		//(x, y is body button point)
		initX = ARM_WIDTH + MARGIN + ARM_WIDTH + BODY_WIDTH + MARGIN + ARM_WIDTH; 
		initY = LEG_HEIGHT + MARGIN + BODY_HEIGHT;
		x = initX;
		y = initY;
		cx = x+BODY_WIDTH/2;
		cy = y+BODY_HEIGHT/2;
		
		btnHead = new Button("^ ^");
		btnBody = new Button("BODY");
		btnLeftArm = new Button("L.ARM");
		btnRightArm = new Button("R.ARM");
		btnLeftLeg = new Button("L.LEG");
		btnRightLeg = new Button("R.LEG");
		btnFire = new Button("X");
		
		// ��� ������ �ٵ� ��ư�� ������� ����Ʈ. x, y
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
		new Hw3();	// ���� ���� ���� �ʿ� ���� �����ڸ� ���� ����.
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		System.out.println(code);
		int x = btnBody.getX();
		int y = btnBody.getY();
		int speed = 15;
		int vx = 1;
		int vy = 1;
		int a;
		// 37~40 �»����
		switch(code) {
		case 32:
			for(int i = -200; i <= 200; i ++) {
				a = Math.abs(i)/50; //+0~+3 i=0�϶� ���� ������.
				if(i<0)
					y -= 1*vy*a;
				else if(i>0)
					y += 1*vy*a;
				robotPoint(x, y);
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
		System.out.printf("Ű���� �������� [x:%2d, y:%2d]\n", x , y);
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
		System.out.println("Ű���� �� ��");
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
		String cmd = e.getActionCommand();
		if(cmd.equalsIgnoreCase("X")){
			for(int i = -200; i <= 200; i ++) {
				int a = Math.abs(i)/50; //+0~+3 i=0�϶� ���� ������.
				int vx = 1;
				if(i<0)
					x += vx*a;
				else if(i>=0)
					x -= vx*a;
				btnRightArm.setLocation(x + BODY_WIDTH + MARGIN, y);
//				robotPoint(x, y);
				try {
					Thread.sleep(0, 1);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}

