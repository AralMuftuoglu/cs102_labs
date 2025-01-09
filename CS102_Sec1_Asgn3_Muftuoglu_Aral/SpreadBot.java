public class SpreadBot extends Robot
{
    public SpreadBot()
    {
        super.health= (Math.random() * 1)+2;
        super.attack= (Math.random() * 0.5)+0.5;
        super.speed= (Math.random() * 1)+0.5;
        super.name="SpreadBot";
        super.robotId=numberOfRobots;
        super.code="K"+super.robotId;
        numberOfRobots++;

    }

    public void attack(Simulation s)
    {
        Robot[]targets;

        targets= s.getLowestSpeed3(isReadTeam);
        
        
       
            
            for(int i=0;i<targets.length;i++)
            {
                if(targets[i].getHitAndIsDestroyed(super.attack))
                {
                    System.out.println(super.code+" attacks"+targets[i].code);
                    System.out.print(targets[i].code+"receives");
                    System.out.printf(" %.3f",super.attack);
                    System.out.print(" damage-> remaining health: ");
                    System.out.printf("%.3f",targets[i].health);
                    System.out.println();

                    s.removeRobot(targets[i]);
                }
                else
                {
                    System.out.println(super.code+" attacks "+targets[i].code);
                    System.out.print(targets[i].code+"receives");
                    System.out.printf(" %.3f",super.attack);
                    System.out.print(" damage-> remaining health: ");
                    System.out.printf("%.3f",targets[i].health);
                    System.out.println();
                }
                
            }
       
    }           
}