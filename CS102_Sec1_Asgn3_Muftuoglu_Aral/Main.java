import java.util.Scanner;

public class Main 
{   
    public static void main(String[] args)
    {
        Scanner input= new Scanner(System.in);

        System.out.print("Team Size:    ");
    
        int a= input.nextInt();

        Simulation s = new Simulation();

        s.initialize(a);
        s.simulate();
    }

}
