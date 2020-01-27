import java.util.Random;
import java.util.Scanner;

public class BattleShips
{
    public static final int NUM_SHIPS = 5;
    public static int PLAYER_SHIPS = 5;
    public static int COMPUTER_SHIPS = 5;

    public static void main(String[] args)
    {
        char[][] grid = new char[12][14];

        Scanner input = new Scanner(System.in);

        oceanMap(grid);

        System.out.println();

        playerShips(input, grid);
        computerShips(grid);

        System.out.println();

        while (PLAYER_SHIPS!=0 || COMPUTER_SHIPS!=0)
        {
            playersGame(input,grid);
            computersGame(grid);

            if(PLAYER_SHIPS==2 || COMPUTER_SHIPS==2)
            {
                System.out.println("Do you want a status of your game?");
                System.out.print("Enter Y(yes)/N(no): ");
                String status = input.next();

                if(status.equals("Y"))
                {
                    checkStatus(grid);
                }
            }
        }

        System.out.println("\nYour ships: "+PLAYER_SHIPS+" | Computer ships: "+COMPUTER_SHIPS+"\n");

        if(COMPUTER_SHIPS==0)
        {
            checkStatus(grid);
            System.out.println("Hooray! You win the battle :)");
        }
        else
        {
            checkStatus(grid);
            System.out.println("You loose :(");
        }
    }

    public static void oceanMap(char[][] grid)
    {
        System.out.println("\n\n\t\t\t\t\t**** Welcome to Battle Ships game ****\n");
        System.out.println("Right now, the sea is empty.\n");

        for (int row=0; row<grid.length; row++)
        {
            for (int col=0; col<grid[row].length; col++)
            {
                if(row==0 || row==11)
                {
                    if(col<2 || col>11 && col<14)
                    {
                        grid[row][col] = ' ';
                    }

                    else
                    {
                        grid[row][col] = (char)((col-2)+'0');
                    }

                }

                else if(col==0 || col==13)
                {
                    grid[row][col] = (char)((row-1)+'0');
                }

                else if(col==1 || col==12)
                {
                    grid[row][col] = '|';
                }

                else
                    grid[row][col] = ' ';

                System.out.print(grid[row][col]);
            }
            System.out.println();
        }

    }

    public static void playerShips(Scanner input, char[][] newGrid)
    {
        System.out.print("Deploy your ships: \n\n");
        int[] x = new int[NUM_SHIPS];
        int[] y = new int[NUM_SHIPS];

        for(int i=0; i<NUM_SHIPS;i++)
        {
            System.out.print("Enter X coordinate for your "+(i+1)+". ship: ");
            x[i] = input.nextInt();

            System.out.print("Enter Y coordinate for your "+(i+1)+". ship: ");
            y[i] = input.nextInt();

            System.out.println();

            while(x[i]<0 || x[i]>10 || y[i]<0 || y[i]>9)
            {
                System.out.println("Coordinates for "+(i+1)+" ship not accepted. Enter the correct coordinates:");

                System.out.print("Enter X coordinate for your "+(i+1)+". ship: ");
                x[i] = input.nextInt();

                System.out.print("Enter Y coordinate for your "+(i+1)+". ship: ");
                y[i] = input.nextInt();

                System.out.println();
            }

            newGrid[y[i]+1][x[i]+2] = '@';
        }

        for (char[] chars : newGrid) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    public static void computerShips(char[][] playedGrid)
    {
        System.out.print("\nComputer is deploying ships\n\n");

        int[] x = new int[NUM_SHIPS];
        int[] y = new int[NUM_SHIPS];

        for(int i=0; i<NUM_SHIPS;i++)
        {
            x[i] = new Random().nextInt(10);
            y[i] = new Random().nextInt(10);

            while (x[i] < 0 || x[i] > 9 || y[i] < 0 || y[i] > 9)
            {
                x[i] = new Random().nextInt(10);
                y[i] = new Random().nextInt(10);
            }

            while (playedGrid[y[i]+1][x[i]+2]=='@')
            {
                x[i] = new Random().nextInt(10);
                y[i] = new Random().nextInt(10);
            }

            playedGrid[y[i]+1][x[i]+2] = ' ';
            System.out.println((i+1)+". Ships DEPLOYED");
        }

        System.out.println();
    }

    public static void playersGame(Scanner input, char[][] gameGrid)
    {
        System.out.println("Your turn: ");

        System.out.print("Enter the x coordinate: ");
        int x = input.nextInt();

        System.out.print("Enter the y coordinate: ");
        int y = input.nextInt();

        while(x<0 || x>9 || y<0 || y>9)
        {
            System.out.println("Coordinates for ship not accepted. Enter the correct coordinates:");

            System.out.print("Enter the x coordinate: ");
            x = input.nextInt();

            System.out.print("Enter the y coordinate: ");
            y = input.nextInt();

            System.out.println();
        }

        while (gameGrid[y+1][x+2]=='-'||gameGrid[y+1][x+2]=='x'||gameGrid[y+1][x+2]=='!')
        {
            System.out.println("Coordinates already used. Enter an unused coordinate:");

            System.out.print("Enter the x coordinate: ");
            x = input.nextInt();

            System.out.print("Enter the y coordinate: ");
            y = input.nextInt();

            System.out.println();
        }

        if(gameGrid[y+1][x+2]=='2')
        {
            System.out.println("Boom! You sunk the ship!");
            gameGrid[y+1][x+2]='!';
            COMPUTER_SHIPS--;
        }

        else if(gameGrid[y+1][x+2]=='@')
        {
            System.out.println("Oh no, you sunk your own ship :(");
            gameGrid[y+1][x+2]='x';
            PLAYER_SHIPS--;
        }

        else
        {
            System.out.println("Sorry, you missed");
            gameGrid[y+1][x+2]='-';
        }

        System.out.println();
    }

    public static void computersGame(char[][] gameGrid)
    {
        System.out.println("Computer's Turn");

        int x = new Random().nextInt(10);
        int y = new Random().nextInt(10);

        while (x< 0 || x > 9 || y < 0 || y > 9)
        {
            x = new Random().nextInt(10);
            y = new Random().nextInt(10);
        }

        while (gameGrid[y+1][x+2]=='^'||gameGrid[y+1][x+2]=='x'||gameGrid[y+1][x+2]=='!')
        {
            x = new Random().nextInt(10);
            y = new Random().nextInt(10);
        }

        if(gameGrid[y+1][x+2]=='@')
        {
            System.out.println("The Computer sunk one of your ships!");
            gameGrid[y+1][x+2]='x';
            PLAYER_SHIPS--;
        }

        else if(gameGrid[y+1][x+2]=='2')
        {
            System.out.println("The Computer sunk one its own ships!");
            gameGrid[y+1][x+2]='!';
            COMPUTER_SHIPS--;
        }

        else
        {
            System.out.println("Computer missed.");
            gameGrid[y+1][x+2]='^';
        }

        System.out.println();
    }

    public static void checkStatus(char[][] grid)
    {
        for (char[] chars : grid) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }

        System.out.println("\nYour ships: "+PLAYER_SHIPS+" | Computer ships: "+COMPUTER_SHIPS+"\n");
    }
}