package myPlayGround;

import java.awt.Button;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BackgroundTest extends JFrame {
	// 이미지를 그린다.
	// The Image to store the background image in.
	
	// paint에서 사용할 이미지
	Image img = getToolkit().createImage("src/images/money_cat.jpeg");
	
	// label iconimg로 들어갈 이미지
	ImageIcon imgIcon= new ImageIcon(img);
	JLabel jl = new JLabel(imgIcon);
	
	Button btn1 = new Button("dd");
	
	public BackgroundTest() {
		setLayout(null);
		this.setContentPane(jl);
		
		btn1.setBounds(100, 100, 200, 200);
		add(btn1);
		
		setSize(500, 500);
		setVisible(true);
	}

//	public void paint(Graphics g) {
//		// Draws the img
//		g.drawImage(img, 0, 0, null);
//	}

	public static void main(String[] args) {
		BackgroundTest g1 = new BackgroundTest();
	}
}