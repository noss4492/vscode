package day22;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWin4 extends Frame implements ActionListener, MouseListener {
	Image img;
	int x1, y1, x2, y2, width, height;
// 창을 화면 정중앙에 배치하기

	MyWin4() {
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension d = tool.getScreenSize();
		
		double width = d.getWidth();
		double height = d.getHeight();
		
		System.out.println("현재 모니터 해상도("+width+":"+height+")");
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		int x = (int)width;
		int y = (int)height;
		
		//이미지
		img = tool.getImage("src/images/money_cat.jpeg");
		
		//현재 프레임에 이벤트 처리
		this.addMouseListener(this);
		
		
		//1920 / 2 - width/2
		int frameW = 800;
		int frameH = 600;
		setBounds(x/2-frameW/2, y/2-frameH/2, frameW, frameH);
		setVisible(true);
	}

	@Override
	public void paint(Graphics arg0) {
		super.paint(arg0);
		//arg0.drawImage(img, 10, 10, 800, 600, this);
//		arg0.drawLine(x1, y1, x2, y2);
		
		
//		arg0.drawOval(x1-(x2>x1?x2-x1:x1-x2), y1-(y2>y1?y2-y1:y1-y2),
//				x2>x1?x2-x1:x1-x2, y2>y1?y2-y1:y1-y2);  X
		
		int width = x2-x1;
		height = y2-y1;
		
		arg0.drawOval(x1, y1, width, height);
		
		
	}

	public static void main(String[] args) {
		new MyWin4();
	}





	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();
		width = Math.abs(x1-x2);
		height = Math.abs(y1-y2);
		repaint();
	}


}
