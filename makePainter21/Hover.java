package makePainter21;

import java.awt.Color;
import java.awt.HeadlessException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;

import makePainter18.SignUpGUI;

public class Hover extends JFrame{
	SignUpGUI signUp  ;
	JToggleButton btn1,btn2,btn3,btn4 ;
	LineBorder hoverOn = new LineBorder(Color.BLACK,2,true);
	LineBorder hoverOff = new LineBorder(Color.white,1,true);
	
	// gif 캐릭터 이미지 초기화
    private ImageIcon gifImg1 = new ImageIcon("src/images/char1.gif");
    ImageIcon gifImg2 = new ImageIcon("src/images/char2.gif");
    ImageIcon gifImg3 = new ImageIcon("src/images/char3.gif");
    ImageIcon gifImg4 = new ImageIcon("src/images/char4.gif");
	
	public Hover(JToggleButton btn1, JToggleButton btn2, JToggleButton btn3, JToggleButton btn4) {
		this.btn1 = btn1;
		this.btn2 = btn2;
		this.btn3 = btn3;
		this.btn4 = btn4;
	}

	public void HoverChar1() {
		btn1.setSelectedIcon(gifImg1);
		btn1.setBorder(hoverOn);
        btn2.setBorder(hoverOff);
        btn3.setBorder(hoverOff);
        btn4.setBorder(hoverOff);
      
	}
	public void HoverChar2() {
		btn2.setSelectedIcon(gifImg2);
		btn1.setBorder(hoverOff);
        btn2.setBorder(hoverOn);
        btn3.setBorder(hoverOff);
        btn4.setBorder(hoverOff);
	}
	public void HoverChar3() {
		btn3.setSelectedIcon(gifImg3);
		btn1.setBorder(hoverOff);
        btn2.setBorder(hoverOff);
        btn3.setBorder(hoverOn);
        btn4.setBorder(hoverOff);
	}
	public void HoverChar4() {
		btn4.setSelectedIcon(gifImg4);
		btn1.setBorder(hoverOff);
        btn2.setBorder(hoverOff);
        btn3.setBorder(hoverOff);
        btn4.setBorder(hoverOn);
	}
}
