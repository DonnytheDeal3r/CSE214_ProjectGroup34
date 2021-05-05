import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import java.awt.Font;


public class Game extends Canvas {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My Drawing");
        Canvas canvas = new Drawing();
        canvas.setSize(800, 600);
        canvas.setBackground(Color.darkGray);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }
     
     public void paint(Graphics g){
          //vervang met Enemy later
          g.setColor(Color.white);
      for(int i = 0; i < 5; i++){
        for(int j = 0; j < 12; j++){
          g.drawRoundRect(100+(j*50),(50)+i*30, 20, 20, 100, 100);
        }
      }
    g.setColor(Color.yellow);
    Font font1 = new Font("SansSerif", Font.BOLD, 20);
    g.setFont(font1);
    g.drawString("Shoot (w)" ,(800-g.getFontMetrics().stringWidth("Press any key"))/2, 270);
    g.drawString("Rotate: Left(a), Stop (s), Right(d)" ,(800-g.getFontMetrics().stringWidth("Press any key"))/2,300);
    g.drawString("Move: Left(z), Stop(x), Right(c)" ,(800-g.getFontMetrics().stringWidth("Press any key"))/2,330);
    g.drawString("Quit(q), Screencap(p)" ,(800-g.getFontMetrics().stringWidth("Press any key"))/2,360);
    }
}          
