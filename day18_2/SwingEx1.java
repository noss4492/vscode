package day18_2;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

//AWT ==> 1.1 ==> 1.2 ==> swing(�淮ȭ�Ǿ�����. ���� �ڹٱ���� �̷���)
//Frame                   JFrame
public class SwingEx1 extends JFrame {
	final static int WIDTH = 600;
	final static int HEIGHT = 700;
	JButton btn;

	public SwingEx1() {
		super("�޸���");
		ImageIcon img1 = new ImageIcon("src/images/money_cat.jpeg");
		btn = new JButton(img1);
		
		add(btn);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, WIDTH, HEIGHT);
		setVisible(true);
	}

	public static void main(String[] args) {
		SwingEx1 mj1 = new SwingEx1();
	}
}
