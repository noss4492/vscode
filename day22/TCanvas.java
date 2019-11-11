package day22;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class TCanvas extends JPanel {
	Image img;
	
	TCanvas(Image img){
		this.img = img;
		System.out.println(img);
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img,  0, 0, this);
	}

	
}
