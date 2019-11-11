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

public class MyWin3 extends Frame implements ActionListener{
	Button btn;
	int x1, x2, y1, y2;

	MyWin3() {
		btn = new Button("이동");
		x1 = 100;
		x2 = 200;
		y1 = 100;
		y2 = 200;
		add(btn, "South");
		btn.addActionListener(this);
		
		
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
		g.drawLine(x1, y1, x2, y2);
		
	}

	public static void main(String[] args) {
		new MyWin3();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("예스버튼");
		System.out.printf("[x1:%d] [y1%d] [x2:%d] [y2:%d]",x1,y1,x2,y2);
		x1+=1;
		x2+=1;
		repaint();
		// repaint() ==> update()
		// update() ==> 화면 지우고 paint()호출
	}

	@Override
	public void update(Graphics arg0) {
//		super.update(arg0);	// 지우고 paint(g) 메서드 호출하게 되어 있는데
		paint(arg0);
	}
}
