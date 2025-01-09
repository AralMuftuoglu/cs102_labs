public class OneBot extends Robot
{
    public OneBot()
    {
        super.health= (Math.random() * 0.5)+0.5;
        super.attack= (Math.random() * 1)+4;
        super.speed= (Math.random() * 0.5)+0.5;
        super.name="SimpleBot";
        super.robotId=numberOfRobots;
        super.code="O"+super.robotId;
        numberOfRobots++;

    }

    public void attack(Simulation s)
    {
        int index; 

        if(super.isReadTeam)
        {
            index=s.blueTeam.indexOf(s.getLowestHealth(isReadTeam));
        }
        else
        {
            index=s.redTeam.indexOf(s.getLowestHealth(isReadTeam));
        }
        
        if(super.isReadTeam)
        {
            if(s.blueTeam.get(index).getHitAndIsDestroyed(super.attack))
            {
                System.out.println(super.code+" attacks "+s.blueTeam.get(index).code);
                System.out.print(s.blueTeam.get(index).code+" receives");
                System.out.printf(" %.3f",super.attack);
                System.out.print(" damage-> remaining health: ");
                System.out.printf("%.3f",s.blueTeam.get(index).health);
                System.out.println();

                s.removeRobot(s.blueTeam.get(index));
            }
            else{
                System.out.println(super.code+" attacks "+s.blueTeam.get(index).code);
                System.out.print(s.blueTeam.get(index).code+" receives");
                System.out.printf(" %.3f",super.attack);
                System.out.print(" damage-> remaining health: ");
                System.out.printf("%.3f",s.blueTeam.get(index).health);
                System.out.println();

            }
            
        
        }
        else
        {
            if(s.redTeam.get(index).getHitAndIsDestroyed(super.attack))
            {
                System.out.println(super.code+" attacks "+s.redTeam.get(index).code);
                System.out.print(s.redTeam.get(index).code+" receives");
                System.out.printf(" %.3f",super.attack);
                System.out.print(" damage-> remaining health: ");
                System.out.printf("%.3f",s.redTeam.get(index).health);
                System.out.println();

                s.removeRobot(s.redTeam.get(index));
            }
            else
            {
                System.out.println(super.code+" attacks "+s.redTeam.get(index).code);
                System.out.print(s.redTeam.get(index).code+" receives");
                System.out.printf(" %.3f",super.attack);
                System.out.print(" damage-> remaining health: ");
                System.out.printf("%.3f",s.redTeam.get(index).health);
                System.out.println();

            }
            
        }   
     
    }
}
