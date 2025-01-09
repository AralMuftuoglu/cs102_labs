import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.JComponent;

public class Bomb extends JComponent implements InteractableDrawing  {
    
    private Rectangle bomb;

    public int bomb_width=10;
    public int bomb_height=10;

    public  int bombLeft_x;
    public  int bombTop_y;

    public Bomb(int width,int height)
    {
        Random rand = new Random();

        
        int random_x= width-this.bomb_width;
        int random_y= rand.nextInt(height-this.bomb_height);

        this.bombLeft_x= random_x;
        this.bombTop_y=random_y;

        bomb= new Rectangle(bombLeft_x,bombTop_y,bomb_width,bomb_height);
    }

    public boolean intersects(Ship s)
    {

        return bomb.intersects(s.getRectangle());

    }

    public boolean moveLeft(int speed)
    {
        

        this.bombLeft_x=this.bombLeft_x-speed;
        int rightSideCoordinate=this.bombLeft_x-this.bomb_width;

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
        Ship.life--;
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillRect(bombLeft_x, bombTop_y, bomb_width, bomb_height);
    
        bomb= new Rectangle(bombLeft_x,bombTop_y,bomb_width,bomb_height);

    }

}
