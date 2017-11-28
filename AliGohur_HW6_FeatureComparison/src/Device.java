
/**
 * An abstract representation of a device. We can add features of a device to better describe it.
 *
 * @author Gohur Ali
 * @version 05192017
 *
 * Created by gohur on 5/15/2017.
 */
public class Device {
    private String name;
    private String featuresList[][];
    private int featureCounter = 0;

    //Setters
    /**
     * sets the name with invarients in mind
     * @param name - the given name for the object
     */
    public void setName(String name){
        //if the name is an empty name, give an error message
        if(name.equals("")){
            System.out.println("Invalid Name.");
        } else {
            //else assign the name
            this.name = name;
        }
    }
    //Getters

    /**
     *  A getter method to return the name of the object
     * @return - returns the name of the object
     */
    public String getName(){
        return name;
    }
    public int getFeatureCounter(){return featureCounter;}

    /**
     * One of two overloaded methods. Takes a parameter of a feature name (String) and returns the value associated
     * with the feature name.
     * @param featureName - String. A feature that has been entered into the features array.
     * @return - returns the String value
     */
    public String getFeatureValue(String featureName){
        //Goes through the columns of the first row
        for(int i = 0; i < featuresList[0].length; i++) {
            //if it finds the name in the array, it returns the value in the same place, but next row
            if(featuresList[0][i] != null) {
                if (featuresList[0][i].contains(featureName)) {
                    return featuresList[1][i];
                }
            }
        }
        for(int i = 0; i < featuresList[0].length; i++) {
            //if it finds the name in the array, it returns the value in the same place, but next row
            if(featuresList[0][i] != null) {
                if (!featuresList[0][i].contains(featureName)) {
                    return "Feature not found!";
                }
            }
        }
        return "Feature not found!";
    }

    /**
     * The second of the two overloaded methods that get the value of the given feature parameter. Returns the value associated
     * with the feature name.
     *
     * @param indexOfFeature - (int) index of the parameter that is needed
     * @return - returns the associated value of the given feature index
     */
    public String getFeatureValue(int indexOfFeature){
        //if the index is less than the length or equal to 0 then return the value at the given index
        if(indexOfFeature < featuresList[0].length && indexOfFeature >= 0){
            return featuresList[1][indexOfFeature];
        }
        //If the index is greater than  or equal to the length, given an error message
        else if(indexOfFeature >= featuresList[0].length){
            return "Feature not found! Invalid Index Error!";
        }
        //index less than 0, give an error message
        else if(indexOfFeature < 0){
            return "Invalid Index Given. No Feature to return";
        }
        return "Feature not found!";
    }
    //Actions
    /**
     * A adds a feature and the value to the 2D array.
     *
     * @param featureName - name of the feature
     * @param featureValue - the value of the feature
     */
    public void addFeature(String featureName, String featureValue){
        //if the name or value are empty strings, give an error message
        if(featureName.equals("") || featureValue.equals("")){
            System.out.println("Cannot add feature. Empty Feature Name or Value.");
        }
        //else if the counter is less than 10, add the feature and value to their respective row and column
        else if(featureCounter < 10){
            featuresList[0][featureCounter] = featureName;
            featuresList[1][featureCounter] = featureValue;
            //increase the counter to prepare for next addition
            featureCounter++;
        }
        //else give a message that they cannot add more features as they have reached the max.
        else if (featureCounter >= 10){
            System.out.println("You can't add anymore features!");
        }

        int uniques = featuresList[0].length;
        //Nested for-Loop to check for duplicates
        for(int i = 0; i < uniques; i++){
            //plus 1 because we don't want to count i itself
            for(int j = i+1; j < uniques; j++){
                //ignoring null elements
                if(featuresList[0][i] != null){
                    //Ignoring the case of the feature and if the feature has the same name and is already in the array
                    //AND if the feature value is the same and is already in the array, set both to null
                    if(featuresList[0][i].equalsIgnoreCase(featuresList[0][j]) && featuresList[0][j].contains(featureName) && featuresList[1][i].equalsIgnoreCase(featuresList[1][j]) && featuresList[1][j].contains(featureValue)){

                        System.out.println("You've already added this feature to the " + this.getName()+"!");
                        featuresList[0][j] = null;
                        featuresList[1][j] = null;
                        //decrease counter to correct the index
                        featureCounter--;
                    }
                    //if the feature name is the same, but the value is different, add the value to the original element
                    else if(featuresList[0][i].equalsIgnoreCase(featuresList[0][j]) && featuresList[0][j].contains(featureName) && !featuresList[1][i].contains(featureValue)){
                        featuresList[1][i] +=  ", " + featureValue;
                        featuresList[0][j] = null;
                        featuresList[1][j] = null;
                        featureCounter--;
                    }
                }
            }
        }
    }

    /**
     * Displays the features if the object. Designed to print each element in a box.
     */
    public void displayFeature(){
        System.out.println("---Features for " + this.getName() + "---");
        int nullCounter = 0;
        //First loop prints the feature name
        for(int i = 0; i < featuresList[0].length; i++){
            //ignore null elements
            if(featuresList[0][i] == null){
                nullCounter++;
            }
            if(featuresList[0][i] != null){
                //if the size of element is less than or equal to 12
                if(featuresList[0][i].length() <= 12){
                    //if the value string is greater than 12
                    if(featuresList[1][i].length() > 12 ){
                        System.out.print(String.format("|%23s  |", featuresList[0][i]));
                    }
                    else{
                        System.out.print(String.format("|%12s  |", featuresList[0][i]));
                    }
                }
                //else if the length of the name is greater than 12
                else if(featuresList[0][i].length() > 12){
                    System.out.print(String.format("|%16s  |", featuresList[0][i]));
                }
            }
        }
        //starts on next line
        System.out.println();

        //prints the values in the second row
        for(int i = 0; i < featuresList[1].length; i++){
            //ignore all null elements
            if(featuresList[1][i] != null){
                //if the length of the value is less than or equal to 12
                if(featuresList[1][i].length() <= 12){
                    //if the length of the name is greater than 12
                    if(featuresList[0][i].length() > 12){
                        System.out.print(String.format("|%16s  |", featuresList[1][i]));
                    } else{
                        System.out.print(String.format("|%12s  |", featuresList[1][i]));
                    }
                }
                //else if the length of the value is greater than 12
                else if(featuresList[1][i].length() > 12){
                    System.out.print(String.format("|%23s  |", featuresList[1][i]));
                }
            }
        }
        //continues to next line
        System.out.println();
        if(nullCounter == 10){
            System.out.println("Empty List! No features for " + this.getName() + " have been entered.\n");
        }
    }
    //Constuctors

    /**
     * Constructor that takes only name of the object
     * @param name - name of the object
     */
    public Device(String name){
        setName(name);
        //initializing the array to 2 rows and 10 columns
        featuresList = new String[2][10];
    }

    /**
     * Constructor that takes the name and a features list as arguments
     * @param name - name of the object
     * @param featuresListArgument - 2D array of features taken as argument
     */
    public Device(String name, String[][] featuresListArgument){
        //Setting the name
        setName(name);
        //assigning the given parameter list to the features list.
        featuresList = featuresListArgument;

        //setting and updating the counter so if the user wants to add any more features, they can
        for(int i = 0; i < featuresList[0].length; i++){
            if(featuresList[0][i] != null) {
                featureCounter++;
            }
        }
    }
}