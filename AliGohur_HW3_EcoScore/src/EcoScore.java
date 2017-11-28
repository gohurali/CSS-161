import java.util.*;
/**
 * This is a program that gives the user the Eco Score for their car. The user will input the amount of miles traveled
 * and gallons of gas consumed in the last five minutes of travel. After they input these values they are given the
 * total distance traveled, total gas consumed, MPG, and cumulative MPG. The user can continue to enter data as many
 * time as they would like for five minute increments. Then the user will use the menu to take a look at their Eco Score
 * and then they may leave the program.
 *
 * Created by Gohur on 4/10/2017.
 * @author Gohur Ali
 * @version 04132017
 */
public class EcoScore {
    //Global variables that are updated each time they are used
    public static double totalDistance = 0;
    public static double totalGas = 0;
    public static double cumulativeMPG = 0;

    public static void main(String[] args){
        //Creating a new instance of a Scanner
        Scanner userInput = new Scanner(System.in);
        //Declaring userMenuChoice as a variable so that it may be used in the do-while loop.
        double userMenuChoice;

        /*
        Backbone of the code
        This will go back to printing the main menu after the user picks and option
         */
        do{
            //Printing the main menu and prompting the user to choose a choice from the menu
            displayMainMenu();
            System.out.print("Please choose a choice from above: ");
            userMenuChoice = userInput.nextDouble();
            System.out.println();

            /*
            Choice one is Trip Data. This will ask the user for miles traveled and gallons consumed
            in the last fives minutes. After input, the program will calculate MPG, Total Dist. Traveled,
            Total Gas Consumed, and Cumulative MPG.
             */
            if(userMenuChoice == 1){
                //Enter Trip Data

                //Ask the user for miles traveled in the last five minutes
                System.out.print("How many miles have you traveled in the past 5 minutes? ");
                double milesInLastFive = userInput.nextDouble(); //Assigned to double to support decimals

                //Ask the user for gas consumed in the last five minutes
                System.out.print("How many gallons of gas have been consumed in the past 5 minutes? ");
                double gallonsOfGasLastFive = userInput.nextDouble();//Assigned to double to support decimals

                System.out.println();

                //MpgOverFive method calculates and returns the mpg for the given time and assigns to a variable
                double mpg = MpgOverFive(milesInLastFive, gallonsOfGasLastFive);
                String mpgFormat = String.format("MPG over the past 5 minutes: %1$.2f", mpg);//Formatted to 2 decimals
                System.out.println(mpgFormat);

                //totalDistance method calculates and returns the total distance and assigns to a variable
                double totalDistance = totalDistanceTraveled(milesInLastFive);
                //Formatted to 2 decimals
                String totalDistanceFormat = String.format("Total Distance Traveled (Miles): %1$.2f", totalDistance);
                System.out.println(totalDistanceFormat);

                //totalGas method calculates and returns the total gas consumed and assigns to a variable
                double totalGas = totalGasConsumed(gallonsOfGasLastFive);
                //Formatted to 2 decimals
                String totalGasFormat = String.format("Total Gallons of Gas Consumed: %1$.2f", totalGas);
                System.out.println(totalGasFormat);

                //Calculating cumulative MPG
                cumulativeMPG = milesInLastFive / gallonsOfGasLastFive;
                //Formatted to 2 decimals
                String cumulativeMPGFormat = String.format("Cumulative MPG: %1$.2f", cumulativeMPG);
                System.out.println(cumulativeMPGFormat);

                System.out.println();

                //Asking the user if they would like to enter more data
                System.out.print("Would you like to keep entering data (Y/N)? ");
                String moreData = userInput.next();
                System.out.println();

                //If yes, then the while loop will keep asking the user for data till the user says no.
                while(moreData.equalsIgnoreCase("y") || moreData.equalsIgnoreCase("yes")){
                    //See above comments for this body of code.
                    System.out.print("How many miles have you traveled in the past 5 minutes? ");
                    milesInLastFive = userInput.nextDouble();

                    System.out.print("How many gallons of gas have been consumed in the past 5 minutes? ");
                    gallonsOfGasLastFive = userInput.nextDouble();

                    System.out.println();

                    mpg = MpgOverFive(milesInLastFive, gallonsOfGasLastFive);
                    mpgFormat = String.format("MPG over the past 5 minutes: %1$.2f", mpg);
                    System.out.println(mpgFormat);

                    totalDistance = totalDistanceTraveled(milesInLastFive);
                    totalDistanceFormat = String.format("Total Distance Traveled: %1$.2f", totalDistance);
                    System.out.println(totalDistanceFormat);

                    totalGas = totalGasConsumed(gallonsOfGasLastFive);
                    totalGasFormat = String.format("Total gallons consumed: %1$.2f", totalGas);
                    System.out.println(totalGasFormat);

                    cumulativeMPG = (totalDistance) / (totalGas);
                    cumulativeMPGFormat = String.format("Cumulative MPG: %1$.2f", cumulativeMPG);
                    System.out.println(cumulativeMPGFormat);

                    System.out.println();

                    //Once again asks the user if they would like to enter more data.
                    //If yes, the loop repeats.
                    //If no, loop ends and you are back to the Main Menu.
                    System.out.print("Would you like to keep entering data (Y/N)? ");
                    moreData = userInput.next();
                    System.out.println();
                }
            }
            else if (userMenuChoice == 2){
                //Enter Eco Score

                //Format statements that print total distance, total gas, and cumulative MPG
                //Formatted to 2 decimals
                System.out.printf("Here is your total distance for the trip (Miles): %1$.2f\n", totalDistance);
                System.out.printf("Here is your total gallons of gas consumed: %1$.2f\n", totalGas);
                System.out.printf("Here is your cumulative MPG: %1$.2f\n", cumulativeMPG);

                //Based on the cumulative MPG, the calculator will give you a certain amount of planets.
                //Anything of less 30 has the calculator tell you that you need to drive more efficiently.
                if(cumulativeMPG > 100){
                    System.out.println("Your MPG is greater than 100! You've earned 5 planets!");
                }
                else if((cumulativeMPG < 100) &&(cumulativeMPG > 50)){
                    System.out.println("Your MPG is excellent! You've earned 3 planets!");
                }
                else if((cumulativeMPG < 50) &&(cumulativeMPG > 30)){
                    System.out.println("Your MPG is good! You've earned 1 planet!");
                }
                else if((cumulativeMPG < 30) &&(cumulativeMPG > 10)) {
                    System.out.println("Your MPG is average. Try to drive more efficiently.");
                }
                else if (cumulativeMPG < 10){
                    System.out.println("Your MPG is very inefficient.");
                }
                System.out.println();
            }
            //Choice three exits the program
            else if (userMenuChoice == 3){
                System.out.println("Thanks for using the Eco Score Calculator!");
                System.exit(0);
            }
            //Any input other than 3 will have the program give you an error and prompt you again.
            else if (userMenuChoice != 3){
                System.out.println("Error! Invalid Input. Try Again.");
            }

        }while(userMenuChoice != 3);//As long the user input is NOT 3, display menu and ask for user choice.
    }

    /**
     * A method that displays the main menu to the user
     */
    public static void displayMainMenu(){
        //Menu Display
        System.out.println("Welcome to the Eco Score Calculator!");
        System.out.println();
        System.out.println("1.  Enter trip data");
        System.out.println();
        System.out.println("2.  Show Eco Score");
        System.out.println();
        System.out.println("3.  Exit Program");
        System.out.println();
    }

    /**
     * This gives the user the total distance traveled with each time the user gives miles traveled.
     * @param milesInLastFive - miles traveled in the last five minutes
     * @return - returns the total amount of distance traveled
     */
    public static double totalDistanceTraveled(double milesInLastFive){
        //total distance = Previous distances + distance traveled in last five minutes
        totalDistance = milesInLastFive + totalDistance;
        return totalDistance;
    }

    /**
     * This gives the user the total gallons of gas consumed with each time the user gives the gallons
     * consumed
     * @param gallonsOfGasLastFive - gallons of gas consumed in the last five minutes
     * @return  - returns the total amount of gas consumed
     */
    public static double totalGasConsumed(double gallonsOfGasLastFive) {
        //total gas = total gas consumed + gallons of gas consumed in last 5 minutes
        totalGas = gallonsOfGasLastFive + totalGas;
        return totalGas;
    }

    /**
     * Returns the miles per gallon in the last five minutes of the trip.
     * @param distanceTraveled - takes the miles entered for the last five minutes
     * @param gasConsumed - takes the gallons consumed in the last five minutes
     * @return - returns the miles per gallon (distance/gasConsumed)
     */
    public static double MpgOverFive(double distanceTraveled , double gasConsumed){
        //Calculating MPG = Distance/gasConsumed
        double mpg = distanceTraveled / gasConsumed ;
        return  mpg;
    }
}