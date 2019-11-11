package day22;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MyWin5 extends JFrame {
	Image img;
	Container panel;
	TCanvas can;

	MyWin5() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension d = tool.getScreenSize();
		
		double width = d.getWidth();
		double height = d.getHeight();
		int x = (int)(width/2 - 800/2);
		int y = (int)(height/2 - 600/2);
		
		
		img = tool.getImage("src/images/money_cat.jpeg");

		can = new TCanvas(img);	// 경로가 전달되서	
		panel = getContentPane();
		panel.add(can);

		setBounds(x, y, 800, 600);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MyWin5();
	}
}
