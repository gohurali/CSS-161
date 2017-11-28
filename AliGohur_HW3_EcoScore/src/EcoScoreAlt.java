import java.util.*;
/**
 * Created by gohur on 4/10/2017.
 */
public class EcoScoreAlt {
    public static double totalDistance = 0;
    public static double totalGas = 0;
    public static double cumulativeMPG = 0;

    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        int userMenuChoice;
        String userMenuChoiceAll;

        do{

            displayMainMenu();
            System.out.println("Please choose a choice from above");
            userMenuChoiceAll = userInput.nextLine();
            userMenuChoice = Integer.parseInt(userMenuChoiceAll);


            if(userMenuChoice == 1){
                //Enter Trip Data
                System.out.println("How many miles have you traveled in the past 5 minutes? ");
                double milesInLastFive = userInput.nextDouble();

                System.out.println("How many gallons of gas have been consumed in the past 5 minutes? ");
                double gallonsOfGasLastFive = userInput.nextDouble();

                totalDistanceTraveled(milesInLastFive);
                totalGasConsumed(gallonsOfGasLastFive);
                double mpg = MpgOverFive(milesInLastFive, gallonsOfGasLastFive);
                System.out.println(mpg);

                cumulativeMPG = milesInLastFive / gallonsOfGasLastFive;
                System.out.println("Here is your cumulative MPG: " + cumulativeMPG);

                System.out.println("Would you like to keep entering data? (Y/N) ");
                String moreData = userInput.next();

                while(moreData.equalsIgnoreCase("y") || moreData.equalsIgnoreCase("yes")){

                    System.out.println("How many miles have you traveled in the past 5 minutes? ");
                    milesInLastFive = userInput.nextDouble();

                    System.out.println("How many gallons of gas have been consumed in the past 5 minutes? ");
                    gallonsOfGasLastFive = userInput.nextDouble();

                    totalDistanceTraveled(milesInLastFive);
                    totalGasConsumed(gallonsOfGasLastFive);
                    mpg = MpgOverFive(milesInLastFive, gallonsOfGasLastFive);
                    System.out.println(mpg);

                    cumulativeMPG = ((milesInLastFive/gallonsOfGasLastFive) + cumulativeMPG) /2 ;
                    System.out.println("Here is your cumulative MPG: " + cumulativeMPG);

                    System.out.println("Would you like to keep entering data? (Y/N) ");
                    moreData = userInput.next();
                }
            }
            else if (userMenuChoice == 2){
                //Enter Eco Score
                System.out.println("Here is your total distance for the trip (Miles): " + totalDistance);
                System.out.println("Here is your total gallons of gas consumed: "+ totalGas);
                System.out.println("Here is your cumulative MPG: " + cumulativeMPG);
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
            else if (userMenuChoice == 3){
                System.exit(0);
            }
            else if (userMenuChoice != 3){
                System.out.println("Error Message.");
            }

        }while(userMenuChoice != 3);
    }

    public static void displayMainMenu(){
        System.out.println("1.  Enter trip data");
        System.out.println();
        System.out.println("2.  Show Eco Score");
        System.out.println();
        System.out.println("3.  Exit Program");
        System.out.println();
    }
    public static double giveTripData(){
        Scanner userInput = new Scanner(System.in);

        System.out.println("How many miles have you traveled in the past 5 minutes? ");
        double milesInLastFive = userInput.nextDouble();

        System.out.println("How many gallons of gas have been consumed in the past 5 minutes? ");
        double gallonsOfGasLastFive = userInput.nextDouble();

        return milesInLastFive;
    }
    public static void totalDistanceTraveled(double milesInLastFive){

        totalDistance = milesInLastFive + totalDistance;
        System.out.println(totalDistance);
    }
    public static void totalGasConsumed(double gallonsOfGasLastFive){

        totalGas = gallonsOfGasLastFive + totalGas;

        System.out.println(totalGas);
    }
    public static double MpgOverFive(double distanceTraveled , double gasConsumed){

        double mpg = distanceTraveled / gasConsumed ;
        return  mpg;
    }
    public static void CumulativeMpg(double initialCumulativeMPG ,double distanceTraveled , double gasConsumed){

        cumulativeMPG = ((distanceTraveled / gasConsumed) + cumulativeMPG) / 2;

    }
}