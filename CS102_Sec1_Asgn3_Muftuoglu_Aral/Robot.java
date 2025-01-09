public abstract class Robot{

    public static int numberOfRobots=0;
    
    public int robotId;
    public double health;
    public double attack;
    public double speed;
    public String name;
    public boolean isReadTeam;
    public String code;
    

    public abstract void attack(Simulation s);

    public boolean getHitAndIsDestroyed(double damage)
    {
        this.health=this.health-damage;


        if(this.health<=0)
        {
            this.health=0;
            return true;
        }
        else
        {
            return false;
        }
    }
    
}