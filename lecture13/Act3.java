package lecture13;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
class MyPanel3 extends JPanel{
	BufferedImage image;

    public MyPanel3() {
    	setPreferredSize(new Dimension(300, 360));
       try {                
          image = ImageIO.read(new File("D:\\JavaCode\\JavaTutorial\\src\\lecture13\\pokemon_trainer.png"));
       } catch (IOException ex) {
            System.out.println(ex.getMessage());
       }
    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = image.getWidth();
        int height = image.getHeight();
        int x = (300-width)/2;
        int y = (360-height)/2;
        g.drawImage(image, x, y, this);             
    }
}
public class Act3 {
	public static void main(String[] args) {
		JFrame f = new JFrame("Java Graphics");
        MyPanel3 p = new MyPanel3();
        f.add(p, BorderLayout.CENTER);
        f.pack();
        f.setLocationRelativeTo(null); //place the window in the center of the screen
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit the program when the window is closed
        f.setVisible(true); //show the window
	}
}
