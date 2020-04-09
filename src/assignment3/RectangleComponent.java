//Draws the Mondrian rectangle objects

package assignment3;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;
import javax.swing.*;

public class RectangleComponent extends JComponent {

    Random rng = new Random();

    ArrayList<Rectangle> rectangles;

    Color[] colors = new Color[13];

    Stroke stroke = new BasicStroke(5);

    public RectangleComponent( ArrayList<Rectangle> rectangles) {

        this.rectangles=rectangles;
	  //each color represents the probability out of 13, between white, blue, red, yellow, and black
        colors[0]= new Color(255,255,255);
        colors[1]= new Color(255,255,255);
        colors[2]= new Color(255,255,255);
        colors[3]= new Color(255,255,255);
        colors[4]= new Color(255,255,255);
        colors[5]= new Color(255,255,255);
        colors[6]= new Color(200,0,0);
        colors[7]= new Color(200,0,0);
        colors[8]= new Color(40,20,220);
        colors[9]= new Color(40,20,220);
        colors[10]= new Color (250,255,0);
        colors[11]= new Color(250,255,0);
        colors[12]= new Color(0,0,0);
        
    }
    
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setStroke(stroke);
       

        //for loop to print all of the rectangles
        for(int i=0; i<rectangles.size();i++){

            g2.setColor(colors[rng.nextInt(13)]);

            g2.fill(rectangles.get(i));

            g2.setColor(Color.black);
            
            g2.draw(rectangles.get(i));

        }
          

    }
    
    //eliminates stacking of Paintings; rectangles are redefined each time
    public void update(ArrayList<Rectangle> rectangles){
        this.rectangles=rectangles;
        repaint();
    }
    
}

