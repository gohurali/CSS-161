import java.util.Scanner;
/**
 * This is a program that expands on the Gas Costs.
 * It Calculates the Average speed, Miles Per Gallon, and Cost of Gas
 *
 * The program will simply ask for your initial Odometer reading and
 * your ending odometer reading. The purpose is to help the user determine
 * how efficient their vehicle is and how much is being spent in gas for their trip.
 *
 * @Gohur Ali
 * @4/7/2017
 */
public class TripCalculatorMenu {
    public static void main(String[] args){
        //Creates a new instance of a scanner for user input
        Scanner userInput = new Scanner(System.in);

        //Asking the user for the Starting Odometer in miles
        System.out.print("Starting Odometer(Miles)? ");
        int startingOdometer = userInput.nextInt();

        //Checks if user input was positive. If not, it's made positive, and is stored
        double nowPositiveStartingOdometer = isPositive(startingOdometer);

        //Asking the user for the Ending Odometer in miles
        System.out.print("Ending Odometer(Miles)? ");
        int endingOdometer = userInput.nextInt();

        //Checks if user input was positive. If not, it's made positive, and is stored
        double nowPositiveEndingOdometer = isPositive(endingOdometer);

        /*This methods is checking for the starting value being less than the ending.
        If the ending Odometer was for some reason less than the starting, then it gives
        the user an error and breaks the program.*/
        isLessThan(nowPositiveStartingOdometer, nowPositiveEndingOdometer);

        //Asking the user for how many gallons of gas were consumed
        System.out.print("Gallons of Gas Consumed? ");
        double gallonsOfGasConsumed = userInput.nextDouble();
        //Checks to see if the value given is positive
        isPositive(gallonsOfGasConsumed);

        //Finds the difference between the given values which equates to the distance.
        // Distance = (Ending Amount of miles) - (Starting amount of miles)
        double distance = nowPositiveEndingOdometer - nowPositiveStartingOdometer;

        //While loop continues to run until user enters 0
        //Gives the user a choice to choose any option.
        while(true) {
            displayMainMenu(); //Prints the Main Menu
            System.out.println();
            //Asks the user to choose an option
            System.out.print("Please choose from the above options: ");
            int userMenuChoice = userInput.nextInt();

            if (userMenuChoice == 1) {
                //Displays the user's average speed given the odometer inputs
                averageSpeed(distance);
                System.out.println();
            } else if (userMenuChoice == 2) {
                //Displays the user's MPG given the odometer inputs and gallons consumed
                calculateMPG(distance, gallonsOfGasConsumed);
                System.out.println();
            } else if (userMenuChoice == 3) {
                //Displays the user's cost of gas for the trip
                gasCosts(gallonsOfGasConsumed);
                System.out.println();
            } else if (userMenuChoice == 0) {
                //When user enters 0, they are given a farewell and program breaks
                farewellMessage();
                System.exit(0); //Program exits here.
            }
        }
    }
    public static void displayMainMenu(){
        //Main Menu display
        //Added spaces in order to increase readability
        System.out.println("1.  Calculate Average Speed");
        System.out.println();
        System.out.println("2.  Calculate MPG");
        System.out.println();
        System.out.println("3.  Calculate Gas Costs");
        System.out.println();
        System.out.println("0.  End Program");

    }
    public static double isPositive(double numA){
        //This method checks for the inputted odometer values to be positive.
        if (numA > 0){
            return numA;
        }
        else if (numA < 0){
            //Turns a negative input into a positive and the new positive value is stored.
            System.out.println("You inputted a negative value! Here's your new value: " + numA * -1);
            return numA * -1 ;
        }
        else{
            return numA;
        }
    }
    public static void isLessThan(double numberA, double numberB){
        /*This method checks if the starting odometer value
         was less than the ending odometer value*/
        if (numberB > numberA){
            System.out.print("");
        }
        else if(numberA > numberB){
            //If the ending was less than the starting value than program breaks.
            System.out.println("Error. There was an issue with your Odometer values.");
            System.exit(0);//Program exits here.
        }
    }
    public static void averageSpeed(double distance){
        //Creates a new instance of a scanner for user input
        Scanner yourInput = new Scanner(System.in);

        //Asks the user how the the trip was in minutes
        System.out.print("How long was your trip (minutes)?");
        int durationInMinutes = yourInput.nextInt();

        //Checks if user input was positive. If not, it's made positive, and is stored
        double nowPositiveTimeMin = isPositive(durationInMinutes);

        //Converts from minutes to hours
        double durationInHours = nowPositiveTimeMin / 60;

        //Average Speed  = “Distance Traveled (Miles)” / “Duration of Travel (Hours)”
        double theAverageSpeed = distance/durationInHours;

        //Used a format statement to print my Average speed and rounds decimal to 2 places.
        System.out.printf("Your average speed was: %1$.2f MPH", theAverageSpeed);
        System.out.println();
        System.out.println();
    }
    public static void calculateMPG(double distance, double gallonsOfGasConsumed){
        //Miles Per Gallon = “Distance Traveled (Miles)” / “Gallons of Gas Consumed”
        double milesPerGallon = distance/gallonsOfGasConsumed;

        //Used a format statement to print the MPG and rounds decimal to 2 places.
        System.out.printf("Your MPG for the trip was: %1$.2f", milesPerGallon);
        System.out.println();
        System.out.println();
    }
    public static void gasCosts(double gallonsOfGasConsumed){
        //Creates a new instance of a scanner for user input
        Scanner yourInput = new Scanner(System.in);

        //Asks the user how much the cost of gas is per gallon
        //User must input the dollar sign when inputting the cost of gas
        System.out.print("What is the cost of gas per gallon? ");
        String costOfGasString = yourInput.next();

        /*.substring(1) will slice and cut off the dollar sign from the input
        the rest of the input is stored in costOfGasStringSliced*/
        String costOfGasStringSliced = costOfGasString.substring(1);

        //Converts costOfGasStringSliced from a String to a double.
        double costOfGas = Double.parseDouble(costOfGasStringSliced);
        //The cost for gas for the trip = (The cost of gas) * (The gas consumed for the trip)
        double costOfGasForTrip = costOfGas * gallonsOfGasConsumed;

        //Used a format statement to print the cost of gas for the trip and rounds decimal to 2 places.
        System.out.printf("The cost of gas for your trip is: $%1$.2f", costOfGasForTrip);
        System.out.println();
        System.out.println();
    }
    public static void farewellMessage(){
        //Farewell Message to the user after the user decides to quit the program.
        System.out.println("See you again!");
    }
}