import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Apple implements InteractableDrawing {
    
    private Rectangle apple;

    public int apple_width=10;
    public int apple_height=10;

    public int appleLeft_x;
    public int appleTop_y;


    public Apple(int width,int height)
    {
       
        Random rand = new Random();

        int random_x= width-this.apple_width;   
        int random_y= rand.nextInt(height-this.apple_height);

        this.appleLeft_x= random_x;
        this.appleTop_y=random_y;
        
        apple = new Rectangle(appleLeft_x,appleTop_y,apple_width,apple_height);
        
    }
    
    public boolean intersects(Ship s)
    {
        return apple.intersects(s.getRectangle());
    }


    public boolean moveLeft(int speed)
    {


        this.appleLeft_x=this.appleLeft_x-speed;
        
        int rightSideCoordinate=this.appleLeft_x-this.apple_width;

        if(rightSideCoordinate<0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void interact(Ship s)
    {
        Ship.score++;
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.GREEN);
        g.fillRect(appleLeft_x, appleTop_y, apple_width, apple_height);
        apple = new Rectangle(appleLeft_x,appleTop_y,apple_width,apple_height);

    }

}
