import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener  {
    
   
    public static ArrayList<InteractableDrawing> components= new ArrayList<InteractableDrawing>();

    private String name;
    private int speed;

    private Timer t;
    private int panelWidth;
    private int panelHeight;
    
    private Ship player;
    private JFrame frame_game;

    public GamePanel(GameFrame GameFrame)
    {
        setBackground(Color.BLUE);


        speed=GameFrame.gameSpeed;
        name=GameFrame.playerName;
       
        this.panelHeight=GameFrame.height;
        this.panelWidth=GameFrame.width;

        t= new Timer(10, this);
        t.start();
    
        MouseMotionListener mouseListener = new MoveListener();
        this.addMouseMotionListener(mouseListener);
        
        player = new Ship(name);

        this.frame_game= GameFrame;
        
        frame_game.setTitle("Life: "+Ship.life+"-Score: "+Ship.score);

    }

    class MoveListener implements MouseMotionListener
    {
        public void mouseDragged(MouseEvent event)
        {}
        public void mouseMoved(MouseEvent event)
        {

            Ship.shipLeft_x=event.getX() - 10;
            Ship.shipTop_y=event.getY() - 5;
       
            repaint();
        }
    }
    


    public void actionPerformed(ActionEvent event)
    {
        Random newRand = new Random();
        
        int randomA= newRand.nextInt(10);

        if(randomA==1)
        {
            Apple new_apple = new Apple(panelWidth,panelHeight);
            components.add(new_apple);
            
           
        }
        if(randomA==2)
        {
            Bomb new_bomb= new Bomb(panelWidth,panelHeight);
            components.add(new_bomb); 
        }

        for(int i=0;i<components.size();i++)
        {
            

            boolean intersection= components.get(i).intersects(player);
            
            if(intersection)
            {
                components.get(i).interact(player);
                components.remove(i);
                frame_game.setTitle("Life: "+Ship.life+"-Score: "+Ship.score);
                
                if(Ship.life<=0)
                {
                    t.stop();
                    
                    int option=JOptionPane.showConfirmDialog(this,"Score:" + Ship.score+" ,do you want to play again?","Select an Option",JOptionPane.YES_NO_CANCEL_OPTION);

                    if(option==JOptionPane.YES_OPTION)
                    {
                        
                        t.stop();
                        components.clear();
                        Ship.life=3;
                        Ship.score=0;
                        frame_game.setTitle("Life: "+Ship.life+"-Score: "+Ship.score);

                        t.start();
                        
                    }
                    else
                    {
                        System.exit(0);
                    }
                }
            }
            
            if(components.get(i).moveLeft(speed))
            {
                components.remove(i);
            }
        }
        
        repaint();
    }
    
    @Override 
    public void paintComponent(Graphics g)
    {
       
        player.draw(g);

        for(int i=0;i<components.size();i++)
        {
            components.get(i).draw(g);
        }
    }
    

}

