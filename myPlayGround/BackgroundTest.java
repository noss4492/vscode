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
	// �̹����� �׸���.
	// The Image to store the background image in.
	
	// paint���� ����� �̹���
	Image img = getToolkit().createImage("src/images/money_cat.jpeg");
	
	// label iconimg�� �� �̹���
	ImageIcon imgIcon= new ImageIcon(img);
	JLabel jl = new JLabel(imgIcon);
	

	public BackgroundTest() {
		this.setContentPane(jl);
		setSize(500, 500);
		setVisible(true);
	}

	public void paint(Graphics g) {
		// Draws the img
		g.drawImage(img, 0, 0, null);
	}

	public static void main(String[] args) {
		BackgroundTest g1 = new BackgroundTest();
	}
}