/*
 * Team Max and Seniors
 * Assignment 2
 * Creates a Mondrian painting on startup and when space is pressed
 */

package assignment3;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Assignment3 {

    private static final int FRAME_LENGTH = 1100;
    private static final int FRAME_WIDTH = 600;
	
    private static final int BASE_X = 10;
    private static final int BASE_Y = 10;
    private static final int BASE_LENGTH = 1000;
    private static final int BASE_WIDTH = 500;

    public static void main(String[] Args){

        JFrame frame = new JFrame();
        frame.setSize(FRAME_LENGTH, FRAME_WIDTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //The rectangle that will be used to make Mondrian rectangles
        Rectangle base = new Rectangle(BASE_X, BASE_Y, BASE_LENGTH, BASE_WIDTH);
        
        //Creates the Mondrian rectangles and draws them 
        MondrianRectangle painting = new MondrianRectangle(base);
        painting.makeRectangle(painting.baseRectangle);
        RectangleComponent comp= new RectangleComponent(painting.getPainting());
        frame.setTitle("Composition "+1);
        frame.add(comp);
        frame.setVisible(true);

        //Make a new painting: space bar press
        class SpacebarListener implements KeyListener {

            int frameCount=1;
            
            public void keyReleased(KeyEvent e) {}

            public void keyPressed(KeyEvent e){ 
                
                
                int keybind = e.getKeyCode();
                if (keybind == KeyEvent.VK_SPACE) {
                    frameCount++;
                    MondrianRectangle painting = new MondrianRectangle(base);
                    painting.makeRectangle(painting.baseRectangle);
                    comp.update(painting.getPainting());
                    frame.setTitle("Composition "+frameCount);
                    
                    
                    
                }
            }
            
            public void keyTyped(KeyEvent e){}
            
        }

        SpacebarListener spacebarListener = new SpacebarListener();
        frame.addKeyListener(spacebarListener);
    }

}



