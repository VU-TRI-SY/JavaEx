package lecture13;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class MyPanel2 extends JPanel {
     public MyPanel2(){
         setPreferredSize(new Dimension(450, 450));
         setBackground(Color.RED);
     }

    public void paintComponent(Graphics g) {
//        
    	 g.setColor(Color.RED);
         g.fillOval(0, 0,450, 450);
         int x = (450 - 110) / 2;
         int y = (450 - 300) / 2;
         
         int w = 110;
         int h = 300;
         g.setColor(Color.WHITE);
         g.fillRect(y, x , h, w);
         
         g.setColor(Color.WHITE);
         g.fillRect(x, y , w, h);
    }
}
public class Act2 {
    public static void main(String[] args){
        JFrame f = new JFrame("Java Graphics");
        MyPanel2 p = new MyPanel2();
        f.add(p, BorderLayout.CENTER);
        f.pack();
        
        f.setLocationRelativeTo(null); //place the window in the center of the screen
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit the program when the window is closed
        f.setVisible(true); //show the window
    }
}
