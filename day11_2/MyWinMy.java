package day11_2;
 
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.util.Random;
 
public class MyWinMy extends Frame implements Runnable {
    boolean flag = false;
    Color []colors = {Color.red,Color.BLUE,Color.YELLOW, 
    		Color.BLACK, Color.CYAN, Color.DARK_GRAY, Color.GRAY,
    		Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.WHITE,
    		Color.WHITE, Color.YELLOW};
 
    int i =0;
    
    public void run(){
        while(true){
        try{
            Thread.sleep(100);
        }catch(Exception e){}
        Random r =new Random();
        setBackground(colors[r.nextInt(11)]);
        }
    }
 
    public MyWinMy() {
        setTitle("À©µµ¿ì");
        setLocation(0, 0);
        setSize(300, 300);
        setVisible(true);
//        setBackground(Color.BLUE);
    }
}
/*

*/


