import java.util.*;

public class oddEven
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        pickOddEven(input);
    }

    public static void pickOddEven(Scanner input)
    {

        System.out.println("Let's play a game called \"Odds and Evens\"");
        System.out.print("What is your name? ");
        String name = input.next();
        System.out.print("Hi "+name+", Which do you choose? (O)dds or (E)vens ");
        char ch = input.next().charAt(0);
        String humanChoice = null;
        String compChoice = null;
        while(ch=='O' || ch=='E')
        {
            if(ch=='O')
            {
                humanChoice = "odds";
                compChoice = "evens";
                break;
            }
            else if(ch=='E')
            {
                humanChoice = "evens";
                compChoice = "odds";
                break;
            }
            else
            {
                System.out.print("Hi "+name+", Which do you choose? (O)dds or (E)vens ");
                ch = input.next().charAt(0);
            }
        }

        System.out.println(name+" has picked "+humanChoice+"! The computer will be "+compChoice+".");
        for(int i=0;i<40;i++)
            System.out.print("-");

        playGame(input,ch,name);
    }

    public static void playGame(Scanner input,char ch,String name)
    {
        System.out.print("\n\nHow may \"fingers\" do you put out? ");
        int noFingers = input.nextInt();

        Random rand = new Random();
        int computer = rand.nextInt(6);
        System.out.println("The computer plays "+computer+" \"fingers\".");

        for(int i=0;i<40;i++)
            System.out.print("-");

        int sum = noFingers+computer;
        System.out.println("\n\n"+noFingers+" + "+computer+" = "+sum);

        String winner;
        if(ch == 'O')
        {
            if(sum/2==0)
            {
                System.out.println(sum + " is ...even!");
                System.out.println("That means computer wins!");
            }
            else
            {
                System.out.println(sum+" is ...odd!");
                System.out.println("That means "+name+" wins! :)");
            }
        }

        else
        {
            if(sum/2==0)
            {
                System.out.print(sum+" is ...even!");
                System.out.println("That means "+name+" wins! :)");
            }
            else
            {
                System.out.print(sum+" is ...odd!");
                System.out.println("That means computer wins!");
            }
        }

        for(int i=0;i<40;i++)
            System.out.print("-");
    }
}