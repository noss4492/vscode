package myPlayGround;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AAAaaa extends Frame
{
    MyCanvas can;
    public AAAaaa() {
        super("");
        setLayout(new FlowLayout());
        can=new MyCanvas();
        can.setSize(300,300);
        add(can);
        can.setBackground(Color.lightGray);
 
        // 캔버스에 리스너 부착----
        MyHandler my = new MyHandler();
        can.addMouseMotionListener(my);
 
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
 
    }//생성자-----
    class MyHandler extends MouseMotionAdapter
    {
        public void mouseDragged(MouseEvent e) {
            can.x=e.getX();
            can.y=e.getY();
            can.repaint();
        }
    }////////////////
 
    public static void main(String[] args)
    {
    	AAAaaa d = new AAAaaa();
        d.setSize(500, 500);
        d.setVisible(true);
    }
}
 
class MyCanvas extends Canvas
{
    int x=50, y=50;
    public void update(Graphics g) {
        paint(g);
    }
    public void paint(Graphics g) {
        g.setColor(Color.blue);
        g.fillOval(x,y,10,10);
    }
}


