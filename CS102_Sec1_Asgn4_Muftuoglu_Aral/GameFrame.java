import javax.swing.JFrame;
import javax.swing.JPanel;


public class GameFrame extends JFrame
{
    public final static int width=500;
    public final static int height=400;
    
    public String playerName;
    public int gameSpeed;

    public GameFrame( String a, int b)
    {

        this.playerName=a;
        
        this.gameSpeed=b;
        
        setSize(width, height);

        createPanel();
    }

    private void createPanel()
    {
       JPanel game_panel= new GamePanel(this);
   
       add(game_panel);
    }
}
