package myPlayGround;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BackgroundTest extends JFrame {
	// 이미지를 그린다.
	// The Image to store the background image in.
	Image img;
	ImageIcon imgIcon= new ImageIcon("src/images/money_cat.jpeg");
	JLabel jl = new JLabel(imgIcon);

	public BackgroundTest() {
		// Loads the background image and stores in img object.
		this.setContentPane(jl);
		setSize(500, 500);
		setVisible(true);
	}

	public void paint(Graphics g) {
		// Draws the img to the BackgroundPanel.
		g.drawImage(img, 0, 0, null);
	}

	public static void main(String[] args) {
		BackgroundTest g1 = new BackgroundTest();
	}
}
//		img = Toolkit.getDefaultToolkit().createImage("src/images/money_cat.jpeg");