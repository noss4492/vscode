package day14;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MovingButtonWin extends Frame implements MouseMotionListener {
	final static int WIDTH = 800;
	final static int HEIGHT = 600;
	Button btnY, btnN;
	Label lb;
	Font f = new Font("MyFont", Font.BOLD, 26);
	
	int btnWidth = 100;
	int btnHeight = 50;
	int margin = 50;
	
	MovingButtonWin() {
		super("����� �����̶�� �����Ͻʴϱ�?");
		setLayout(null);
		btnY = new Button("\\( �� ����)/");
		btnN = new Button("T 3T");
		lb = new Label("�� ��");

		
		
		btnY.setBounds(250, 500, btnWidth, btnHeight);
		btnN.setBounds(450, 500, btnWidth, btnHeight);
		lb.setBounds((WIDTH-100)/2, 100, 300, 100);
		btnY.setFont(f);
		btnN.setFont(f);
		lb.setFont(f);
		
		this.addMouseMotionListener(this);
		
//		btnY.setBounds((int)(Math.random()), (int));
		
		add(btnY);
		add(btnN);
		add(lb);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		//set Frame
		setBounds(100, 100, 800, 600);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		MovingButtonWin mbw = new MovingButtonWin();
	}
	
	
	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("���콺 �巡�� ��");
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("���콺 �����̴� ��");
		int mx = e.getX();
		int my = e.getY();
		// ��ư ���� = +btnW/2 +btnH/2, ���콺 ��ǥ�� �������� �ǰ�
		int x = btnY.getX() + btnWidth/2;
		int y = btnN.getY() + btnHeight/2;
		
		System.out.println(btnY.getX()+"|"+btnN.getY());
		System.out.println(x+"|"+y);
		
		// sqrt(diff(x)^2+diff(y)^2)
		double dis = Math.sqrt(Math.pow(Math.abs(mx-x),2)+Math.pow(Math.abs(my-y),2));
		System.out.println(dis);
		if(dis < 150.0 ) {
			int ranX, ranY;
			ranX=(int) (Math.random()*(WIDTH-btnWidth)+btnWidth);
			ranY=(int) (Math.random()*(HEIGHT-btnHeight)+btnHeight);
//			while(true){
//				if( ranX >= e.getX() && ranX <= e.getX()+btnWidth )
//					break;	
//			}
			btnY.setLocation(ranX, ranY);
		}
			
	}
}

//				if(((ranX >= e.getX() && ranX <= e.getX()+btnWidth) && 
//						(ranY >= e.getY() && ranY <= e.getY()+btnHeight)))
//		if( (mx >= x && mx < x+btnWidth) && 
//				(my < y+btnHeight && my >= btnHeight)) {