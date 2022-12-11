package lecture13;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;


import javax.swing.JFrame;
import javax.swing.JPanel;

class MyPanel1 extends JPanel {
//    public MyPanel1(){
//        setPreferredSize(new Dimension(500, 200));
//        setBackground(Color.BLUE);
//    }

   
}

public class Act1 {
	
	public static void main(String[] args){
        JFrame f = new JFrame("Java Graphics");
        MyPanel1 p = new MyPanel1();
        f.add(p, BorderLayout.CENTER);
        f.pack();
        
        f.setLocationRelativeTo(null); //place the window in the center of the screen
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit the program when the window is closed
        f.setVisible(true); //show the window
    }

}
