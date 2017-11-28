import java.util.*;
/**
 * This is a program what takes user checkpoints and stores them. The user may edit and update the new number in the list.
 * Utilized Arraylist for this program.
 * Created by gohur on 4/19/2017.
 *
 * @author Gohur Ali
 * @version 04242017
 */
public class Checkpoints {
    public static void main(String[] args){
        //Creating an instance of a Scanner
        Scanner userInput = new Scanner(System.in);
        //Initializing userMenuChoice for the Do-While Loop
        int userMenuChoice;

        //Do-While Loop used in order to have the Menu print out at least once.
        do{
            //Calling the displayMenu function in order to display the menu to the user
            displayMenu();
            //Asking the user to choose from the menu
            System.out.print("Please choose from the above menu: ");
            userMenuChoice = userInput.nextInt(); //puts user integer input inside
            //If the user inputs 1, then let the user enter checkpoints
            if(userMenuChoice == 1){//Enter Checkpoints
                System.out.println();
                EnterUserCheckPoints();
            }
            //If the user inputs 2, then let the user edit checkpoints
            else if(userMenuChoice == 2){//Edit Checkpoints
                System.out.println();

                //Getting size of the array
                int numOfElements = theCheckpoints.size();

                if(numOfElements > 0){
                    editCheckpoints();
                }else{//If the array has 0 elements, user will get a error message!
                    System.out.println("You have not entered any checkpoints!");
                }
            }
            //If the user inputs 3, then display the checkpoints
            else if(userMenuChoice == 3){//Display the checkpoints
                System.out.println();
                //Getting the number of elements in the array
                int numOfElements = theCheckpoints.size();

                //Checks to see how many elements are in the array
                //If the number elements of the array are greater than 0, display the checkpoints
                if(numOfElements > 0){
                    displayCheckpoints();
                }
                //Else(0 Elements) tell the user that they have not entered any elements.
                else{
                    System.out.println("You have not entered any checkpoints!");
                    //displayCheckpoints();
                }
            }
            //If the user inputs 0, exit the program.
            else if(userMenuChoice == 0){
                System.out.println();
                System.out.println("Thanks for using our App!");
                System.exit(0);//Program Termination
            }
            //Any input other than 0, give the user a Error message and ask again.
            else if(userMenuChoice != 0){
                System.out.println("Error: Invalid Input");
            }
       }while(userMenuChoice != 0);
    }
    //Class level ArrayList in order to give access to all methods.
    public static ArrayList<Double> theCheckpoints = new ArrayList<Double>();

    /**
     *A method that displays the menu
     */
    public static void displayMenu(){
        System.out.println();
        System.out.println("--Welcome to the Checkpoints Program!--");
        System.out.println();
        System.out.println("1.  Enter Checkpoints");
        System.out.println();
        System.out.println("2.  Edit Checkpoints");
        System.out.println();
        System.out.println("3.  Display Checkpoints");
        System.out.println();
        System.out.println("0.  Exit Program");
        System.out.println();
        System.out.println();
    }
    /**
     *A method that asks the user to input the Checkpoints and saves the user's checkpoints in the Class Level ArrayList.
     */
    public static void EnterUserCheckPoints() {
        //Creating an instance of a Scanner
        Scanner userInput = new Scanner(System.in);

        //Asking the user to input the first checkpoint
        System.out.print("Enter Checkpoint 1: ");
        double userNum = userInput.nextDouble();

        //Checking the user's value
        //If the inputted value is greater than or equal to zero, add the value to the list.
        if(userNum > 0){
            theCheckpoints.add(userNum);
        }
        else if (userNum == 0){//If 0 is entered, give a error message
            System.out.println("Error. Zero Value Entered.");
        }
        //Anything else (Negative values), give an error message
        else{
            System.out.println("Error. Negative Value.");
        }

        //Asking the user if they would like to enter more checkpoints
        System.out.print("Would you like to add another checkpoint(Y/N)? ");
        String userReply = userInput.next();

        //Checking the user's string input, anything starting with "y" will be taken as a yes
        if (userReply.startsWith("y") || userReply.startsWith("Y")) {
            int checkpointNum;//will determine the checkpoint number that the user is entering
            if(userNum > 0){
                //Since we have checkpoint 1, checkpoints will start 2 after they would like to enter more checkpoints
                checkpointNum = 2;
            }
            else if(userNum == 0){//If 0 is entered, give a error message
                System.out.println("Error. Zero Value Entered.");
                checkpointNum = 1;
            }
            else{
                //if the user entered a negative number they are re-prompted to enter the checkpoint
                //so the user will need to be asked to enter checkpoint number 1 again.
                checkpointNum = 1;
            }
            while (userReply.startsWith("y") || userReply.startsWith("Y")) {
                //Asking the user to input the next checkpoint
                System.out.print("Enter Checkpoint " + checkpointNum + ": ");
                userNum = userInput.nextDouble();

                //Checking the user's value
                //If the inputted value is greater than or equal to zero, add the value to the list.
                if(userNum > 0){
                    theCheckpoints.add(userNum);
                    ++checkpointNum;//Increments checkpoint num by 1 so that the print statement updates to third(or next) checkpoint
                }
                else if(userNum == 0){//If 0 is entered, give a error message
                    System.out.println("Error. Zero Value Entered.");
                }
                //Anything else (Negative values), give an error message
                else {//If a negative value is entered, give a error message
                    System.out.println("Error. Negative Value.");
                }

                //Asking the user if they would like to enter more checkpoints
                System.out.print("Would you like to add another checkpoint(Y/N)? ");
                userReply = userInput.next();

                //if the user inputs anything that starts with "n" then goes back to the main menu
                if (userReply.startsWith("n") || userReply.startsWith("N")) {
                    System.out.println("Thanks for entering checkpoints. Returning to menu.");
                }
            }
            //if the user inputs anything that starts with "n" then goes back to the main menu
        } else if (userReply.startsWith("n") || userReply.startsWith("N")) {
            System.out.println("Thanks for entering checkpoints. Returning to menu.");
        }
    }
    /**
     *A method that allows the user to edit entered checkpoints.
     */
    public static void editCheckpoints(){
        //Creating an instance of a scanner
        Scanner userInput = new Scanner(System.in);

        //Printing out the list of values, each value on its own line
        System.out.println("Your Checkpoints:");
        //j starts at 1 so that the output shows the list from the first inputted checkpoint to the last
        for(int i = 0, j = 1;i < theCheckpoints.size(); i++, j++){
            System.out.print("Checkpoint " + j + ": ");
            System.out.print(theCheckpoints.get(i));
            System.out.println();
        }
        //Asking the user which checkpoint they would like to edit
        System.out.print("Which checkpoint would you like to edit? ");
        int userChoiceEdit = userInput.nextInt();

        //Since Checkpoints starts at 1, subtract by 1 to get correct index in array.
        int userChoiceEditIndex = userChoiceEdit - 1;

        //Asking the user what they would like to change the checkpoint value to
        System.out.print("What would you like to change it to? ");
        double userChoiceNewChange = userInput.nextDouble();

        //Checks to see if the value entered was negative, if so gives an error message
        if(userChoiceNewChange > 0){
            //Goes to the given index and changes the value in that element to the new value
            theCheckpoints.set(userChoiceEditIndex, userChoiceNewChange);
        }
        else if(userChoiceNewChange == 0){//If zero is entered, give a error message
            System.out.println("Error. Zero Value Entered.");
        }
        else{//If a negative value is entered, give a error message
            System.out.println("Error. Negative Value.");
        }

        //Asking the user if they would like to edit more checkpoints
        System.out.print("Would you like to edit more checkpoints(Y/N)? ");
        String userReply = userInput.next();

        //Checking the user's string input, anything starting with "y" will be taken as a yes
        if(userReply.startsWith("y") || userReply.startsWith("Y")){
            while(userReply.startsWith("y")|| userReply.startsWith("Y")){
                //Refer to block of code above.
                System.out.println("Your New Checkpoints:");
                for(int i = 0, j = 1;i < theCheckpoints.size(); i++, j++){
                    System.out.print("Checkpoint " + j + ": ");
                    System.out.print(theCheckpoints.get(i));
                    System.out.println();
                }
                System.out.print("Which checkpoint would you like to edit? ");
                userChoiceEdit = userInput.nextInt();

                userChoiceEditIndex = userChoiceEdit - 1;

                System.out.print("What would you like to change it to? ");
                userChoiceNewChange = userInput.nextDouble();

                if(userChoiceNewChange > 0){
                    theCheckpoints.set(userChoiceEditIndex, userChoiceNewChange);
                }
                else if(userChoiceNewChange == 0){
                    System.out.println("Error. Zero Value Entered.");
                }
                else{
                    System.out.println("Error. Negative Value.");
                }

                System.out.print("Would you like to add another checkpoint(Y/N)? ");
                userReply = userInput.next();
                if(userReply.startsWith("n")||userReply.startsWith("N")){
                    System.out.println("Thanks for entering checkpoints. Returning to menu.");
                }
            }
        }
        else if(userReply.startsWith("n")||userReply.startsWith("N")){
            System.out.println("Thanks for entering checkpoints. Returning to menu.");
        }
    }
    /**
     * This method displays the checkpoints in the array and puts each value on its own line.
     */
    public static void displayCheckpoints(){
        //Prints the array with each element on a separate line
        for(int i = 0, j = 1;i < theCheckpoints.size(); i++, j++){
            System.out.print("Checkpoint " + j + ": ");
            System.out.print(theCheckpoints.get(i));
            System.out.println();
        }
    }
}