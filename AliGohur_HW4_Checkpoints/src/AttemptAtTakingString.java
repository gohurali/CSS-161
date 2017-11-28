import java.util.*;
/**
 * Created by gohur on 4/24/2017.
 */
public class AttemptAtTakingString {
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        int userMenuChoice;
        boolean userMenuChoiceInt;
        boolean userMenuChoiceString;

        do{
            displayMenu();
            System.out.print("Please choose from the above menu: ");

            userMenuChoiceString = userInput.hasNext();
            userMenuChoiceInt = userInput.hasNextInt(); //Checks if input is an integer
            userMenuChoice = userInput.nextInt(); //puts user integer input inside


            System.out.println(userMenuChoiceString);
            System.out.println(userMenuChoiceInt);

            if(userMenuChoiceInt == true){
                if(userMenuChoice == 1){
                    System.out.println("This is Enter Checkpoints");
                }
                else if(userMenuChoice == 2){
                    System.out.println("This is Edit Checkpoints");
                }
                else if(userMenuChoice == 3){
                    System.out.println("This is Display Checkpoints");
                }
                else if(userMenuChoice == 0){
                    System.out.println("Have a good day");
                    System.exit(0);
                }
                else if(userMenuChoice != 0){
                    System.out.println("Error. Invalid Input.");
                }
            }
            else if(userMenuChoiceString == true){
                System.out.println("Error. Invalid Input.");
            }
        }while(userMenuChoice != 0);
    }
    public static void displayMenu(){
        System.out.println();
        System.out.println("1.  Enter Checkpoints");
        System.out.println();
        System.out.println("2.  Edit Checkpoints");
        System.out.println();
        System.out.println("3.  Display Checkpoints");
        System.out.println();
        System.out.println("0.  Exit Program");
        System.out.println();
    }
}
