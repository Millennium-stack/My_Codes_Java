import java.util.Scanner;

public class tripPlanner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        greeting(input);
        timeBudget(input);
        time(input);
        country(input);
        hackerProblem(input);
    }

        public static void greeting(Scanner input) {
            System.out.println("Welcome to Vacation Planner!");
            System.out.print("What is yor name? ");
            String name = input.nextLine();
            System.out.print("Nice to meet you " + name + ", where are you travelling to? ");
            String city = input.nextLine();
            System.out.println("Great! " + city + " sounds like a great trip");
            System.out.println("***********");
        }

        public static void timeBudget(Scanner input) {
            System.out.print("\nHow many days are you going to spend travelling? ");
            int days = input.nextInt();
            System.out.print("How much money, in USD, are you planning to spend on your trip? ");
            int money = input.nextInt();
            System.out.print("What is the three letter currency symbol for your travel destination? ");
            String symbol = input.next();
            System.out.print("How many " + symbol + " are there in 1 USD? ");
            double value = input.nextDouble();

            int hours = days * 24;
            int minutes = hours * 60;

            double perDay = (double) money / days;

            double budget = money*value;
            double perBudget = budget/days;

            System.out.println("\nIf you are travelling for " + days + " days that is the same as " + hours + " hours or " + minutes + " minutes");
            System.out.println("If you are going to spend $" + money + " USD that means per day you can spend up to $"+String.format("%.2f",perDay)+" USD");
            System.out.println("Your total budget in MXC is "+budget+" "+symbol+", which per day is "+String.format("%.2f",perBudget)+" MXC");
            System.out.println("***********");
        }

        public static void time(Scanner input)
        {
            System.out.print("\n What is the difference, in hours, between your home and your destination? ");
            int diff = input.nextInt();

            int nightTime = 0+diff;
            int dayTime = 12+diff;

            System.out.println("That means that when it is midnight at home it will be "+nightTime+":00 in your travel destination and when it is noon at home it will be "+dayTime+":00");
            System.out.println("***********");
        }

        public static void country(Scanner input)
        {
            System.out.print("\n What is the square area of your destination country in km2? ");
            int area = input.nextInt();

            double miles = area*0.3861;
            System.out.println("In miles2 that is "+miles);
            System.out.println("***********");
        }

    public static void hackerProblem(Scanner input)
    {
        System.out.println("\nEnter the coordinates of your home");
        System.out.print("Latitude: ");
        double lat1 = input.nextDouble();
        System.out.print("Longitude: ");
        double lon1 = input.nextDouble();

        System.out.println("\nEnter the coordinates of your destination");
        System.out.print("Latitude: ");
        double lat2 = input.nextDouble();
        System.out.print("Longitude: ");
        double lon2 = input.nextDouble();

        double radLat1 = Math.toRadians(lat1);
        double radLon1 = Math.toRadians(lon1);
        double radLat2 = Math.toRadians(lat2);
        double radLon2 = Math.toRadians(lon2);

        double finalLat = (radLat1-radLat2)/2;
        double finalLon = (radLon1-radLon2)/2;

        double sinValLat = Math.sin(finalLat);
        double sinSquareLat = Math.pow(sinValLat,2);

        double sinValLon = Math.sin(finalLon);
        double sinSquareLon = Math.pow(sinValLon,2);

        double cosLat1 = Math.cos(radLat1);
        double cosLat2 = Math.cos(radLat2);

        double h = sinSquareLat+(cosLat1*cosLat2*sinSquareLon);
        double rootH = Math.sqrt(h);

        double sinInv = Math.asin(rootH);
        double r = 6378.1;  //radius of earth in km

         double distance = 2*r*sinInv;

        System.out.print("\nDistance: "+Math.round(distance)+" km");
    }
}
