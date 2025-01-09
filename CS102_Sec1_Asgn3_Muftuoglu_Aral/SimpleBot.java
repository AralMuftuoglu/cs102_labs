public class SimpleBot extends Robot
{
    public SimpleBot()
    {
        super.health= (Math.random() * 1)+2;
        super.attack= (Math.random() * 1)+1;
        super.speed= (Math.random() * 1)+1;
        super.name="SimpleBot";
        super.robotId=numberOfRobots;
        super.code="S"+super.robotId;
        numberOfRobots++;
    }

    public void attack(Simulation s)
    {
        int index; 

        if(super.isReadTeam)
        {
            index=s.blueTeam.indexOf(s.getRandomTarget(isReadTeam));
        }
        else
        {
            index=s.redTeam.indexOf(s.getRandomTarget(isReadTeam));
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
            else
            {
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

