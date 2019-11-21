package myPlayGround;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class HelloDukeMain extends JFrame implements Runnable{

    Canvas can;
    Image buffer;
    Image[] duke;
    Toolkit tk;
    boolean repeat = true;
    public HelloDukeMain() {
        tk = Toolkit.getDefaultToolkit();
        initDuke();
        
        this.add(can = new Canvas(){

            @Override
            public void paint(Graphics g) {
                g.drawImage(buffer, 0, 0, this);
            }

            @Override
            public void update(Graphics g) { 
                paint(g);
            }
            
        });
        
        can.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();
                switch(code){
                    case KeyEvent.VK_SPACE:
                        repeat = !repeat;
                        if(repeat)
                            makeThread();
                        break;
                }
            }
            
        });
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        setBounds(300, 100, 400, 400);
        setVisible(true);
        
        makeThread();
    }
    public void makeThread(){
        new Thread(this).start();
    }
    
    public void initDuke(){
        duke = new Image[10];
        
        for(int i=0; i<duke.length; i++){
            duke[i] = tk.getImage(String.format("src/images/safe_image.gif", i+1));
        }
    }
    
    public void bufferPaint(int n){
        buffer = createImage(can.getWidth(), can.getHeight());
        Graphics buffer_g = buffer.getGraphics();
        
        buffer_g.drawImage(duke[n], 30, 30, this);
        
        can.repaint();
    }
    
    
    public static void main(String[] args) {
        new HelloDukeMain();
    }

    @Override
    public void run() {
        while(true){
            for(int i=0; i<duke.length; i++){
                if(!repeat) return;
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {}
                bufferPaint(i);
            }
        }
    }
}
