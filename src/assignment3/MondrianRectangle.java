//Creates Mondrian rectangle objects

package assignment3;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

public class MondrianRectangle {
    
    //chose 110000 pixels to limit the size of rectangles; they have to be “big and strong rectangles to make bold statements of society”- William Urdahl
    private final int MIN_AREA = 110000;

    private Random rng = new Random(); 	//Random colors and sizes
    private int RandomDivide;
    private ArrayList<Rectangle> painting = new ArrayList<>();
    private int direction=0;	//0 is vertical, 1 is horizontal
    Rectangle baseRectangle;	//Not private so Main can use it

    public MondrianRectangle(Rectangle rectangle){

        baseRectangle=rectangle;

    }

    public void makeRectangle(Rectangle rectangle){

	int RandomDivide=rng.nextInt(5)+2;

        if((rectangle.width*rectangle.height)<= MIN_AREA){
            painting.add(rectangle);
        }
        else 
        {
            direction = rng.nextInt(2);
           
            if (direction == 0) 
            {
                makeRectangle(new Rectangle(rectangle.x, rectangle.y, (rectangle.width)/RandomDivide, rectangle.height));

                makeRectangle(new Rectangle(rectangle.x + (rectangle.width)/RandomDivide, rectangle.y, rectangle.width - rectangle.width/RandomDivide, rectangle.height));
            }
            else if (direction == 1) 
            {
                makeRectangle(new Rectangle(rectangle.x, rectangle.y, rectangle.width, (rectangle.height)/RandomDivide));

                makeRectangle(new Rectangle(rectangle.x, rectangle.y + (rectangle.height)/RandomDivide, rectangle.width, rectangle.height - (rectangle.height)/RandomDivide));
            }

        }

    }

    public Rectangle getBaseRectangle() {
        return baseRectangle;
    }

    public ArrayList<Rectangle> getPainting(){
        return painting;
    }

}

