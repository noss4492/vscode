package makePainter24c__.copy;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameStart extends JFrame {
	JLabel gamestart;

	GameStart() {
		//툴킷
		Toolkit tool = Toolkit.getDefaultToolkit();
        Dimension dmen = tool.getScreenSize();
        double scr_Width = dmen.getWidth();
        double scr_Height = dmen.getHeight();
        int widthX = (int) (scr_Width / 2 - 318 / 2);
        int heightY = (int) (scr_Height / 2 - 290 / 2);
        
		// 컴포넌트 초기화
		gamestart = new JLabel(new ImageIcon("src/images/start.gif"));
		add(gamestart);
		
		// window
		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(widthX, heightY, 300, 250);
		setVisible(true);
	}

	public static void main(String[] args) {
		new GameStart();
	}
}
