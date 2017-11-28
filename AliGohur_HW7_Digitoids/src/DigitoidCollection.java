/**
 * Abstract Representation of a Collection that a user can create and display the digitoids from the Digitoid class.
 *
 * @Author - Gohur Ali
 * @Version - 05222017
 * Created by gohur on 5/30/2017.
 */
public class DigitoidCollection {

    //Two Dimensional Array for the Digitoids.
    public String listOfDigitoids[][] = new String[4][50];
    //allows for indexing of the array
    private int digitoidListCounter = 0;

    /**
     * Adds digitoids to the 2D array.
     * @param someone - Object of the Digitoid Class
     */
    public void addDigitoid(Digitoid someone){
        if(digitoidListCounter < 50){
            listOfDigitoids[0][digitoidListCounter] = someone.getName();
            listOfDigitoids[1][digitoidListCounter] = someone.getDigitoidType();
            listOfDigitoids[2][digitoidListCounter] = Integer.toString(someone.level.getValue());
            listOfDigitoids[3][digitoidListCounter] = Double.toString(someone.getExperience());
            digitoidListCounter++;
        }
    }
    /**
     * Displays the Digitoids in the collection.
     */
    public void displayDigitoids(){
        for(int i = 0; i < listOfDigitoids[0].length; i++){
            if(listOfDigitoids[0][i] != null){
                if(listOfDigitoids[0][i].length() <= 12){
                    if(listOfDigitoids[1][i].length() > 12){
                        System.out.print(String.format("|%23s  |", listOfDigitoids[0][i]));
                    }else{
                        System.out.print(String.format("|%12s  |", listOfDigitoids[0][i]));
                    }
                }
                else if(listOfDigitoids[0][i].length() > 12){
                    System.out.print(String.format("|%16s  |", listOfDigitoids[0][i]));
                }
            }
        }
        System.out.println();
        for(int i = 0; i < listOfDigitoids[1].length; i++){
            if(listOfDigitoids[1][i] != null){
                //if the length of the value is less than or equal to 12
                if(listOfDigitoids[1][i].length() <= 12){
                    //if the length of the name is greater than 12
                    if(listOfDigitoids[0][i].length() > 12){
                        System.out.print(String.format("|Type:%11s  |", listOfDigitoids[1][i]));
                    } else{
                        System.out.print(String.format("|Type:%7s  |", listOfDigitoids[1][i]));
                    }
                }
                //else if the length of the value is greater than 12
                else if(listOfDigitoids[1][i].length() > 12){
                    System.out.print(String.format("|Type:%18s  |", listOfDigitoids[1][i]));
                }
            }
        }
        System.out.println();
        for(int i = 0; i < listOfDigitoids[2].length; i++){
            if(listOfDigitoids[2][i] != null){
                //if the length of the value is less than or equal to 12
                if(listOfDigitoids[2][i].length() <= 12){
                    //if the length of the name is greater than 12
                    if(listOfDigitoids[1][i].length() > 12){
                        System.out.print(String.format("|Level:%10s  |", listOfDigitoids[2][i]));
                    } else{
                        System.out.print(String.format("|Level:%6s  |", listOfDigitoids[2][i]));
                    }
                }
                //else if the length of the value is greater than 12
                else if(listOfDigitoids[2][i].length() > 12){
                    System.out.print(String.format("|Level:%17s  |", listOfDigitoids[2][i]));
                }
            }
        }
        System.out.println();
        for(int i = 0; i < listOfDigitoids[3].length; i++){
            if(listOfDigitoids[3][i] != null){
                //if the length of the value is less than or equal to 12
                if(listOfDigitoids[3][i].length() <= 12){
                    //if the length of the name is greater than 12
                    if(listOfDigitoids[2][i].length() > 12){
                        System.out.print(String.format("|EXP:%12s  |", listOfDigitoids[3][i]));
                    } else{
                        System.out.print(String.format("|EXP:%8s  |", listOfDigitoids[3][i]));
                    }
                }
                //else if the length of the value is greater than 12
                else if(listOfDigitoids[3][i].length() > 12){
                    System.out.print(String.format("|EXP:%15s  |", listOfDigitoids[3][i]));
                }
            }
        }
        System.out.println();
        System.out.println();
    }
}
