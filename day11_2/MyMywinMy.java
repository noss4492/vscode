package day11_2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyMywinMy extends JPanel implements Runnable{
private Thread animator;
int x=0, y=0;
private final int DELAY = 50;
    public MyMywinMy(){
        JFrame jf = new JFrame();
        jf.setSize(555,555);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(this);
        jf.setVisible(true);
    }

    @Override
    public void addNotify() {
        super.addNotify();
        animator = new Thread(this);
        animator.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.fillOval(x,y, 55, 55);
        g.dispose();
    }
    public void cycle() {

        x += 1;
        y += 1;
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}