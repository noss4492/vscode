package day22;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class MyWin2 extends Frame implements ActionListener {
	Button btn1;
	Random rnd = new Random();

	MyWin2() {
		btn1 = new Button("시작");
		add(btn1, "South");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setBounds(100, 100, 800, 600);
		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// 랜덤 선
		for (int i = 0; i < 200; i++) {
			try {
				Thread.sleep(1, 1);
//				int x1 = 0;
//				int y1 = 0;
//				int x2 = rnd.nextInt(100)+700;
//				int y2 = rnd.nextInt(100)+500;
				int x1 = rnd.nextInt(800);
				int x2 = rnd.nextInt(800);
				int y1 = rnd.nextInt(800);
				int y2 = rnd.nextInt(800);
				
				Color c = new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255));
				g.setColor(c);
				g.drawLine(x1, y1, x2, y2);
				g.drawOval(x1, y1, x2, y2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		btn1.addActionListener(this);
		
		
	}

	public static void main(String[] args) {
		new MyWin2();
	}

	// awt는 큐방식
	// repaint -> update() (지우고 paint() 호출) -> paint()
	
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		Object obj = new Object();
		if(e.getSource() == btn1) {
			
		}
	}
}
