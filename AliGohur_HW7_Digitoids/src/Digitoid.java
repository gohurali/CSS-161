/**
 * An abstract representation of a Digitoid. A basic game that allows the user to create digitoids
 * that can fight each other and gain experience(XP)! As XP builds, they can level up.
 *
 * @Author - Gohur Ali
 * @Version - 05222017
 * Created by gohur on 5/22/2017.
 */
public class Digitoid {
    //instance variables
    private String name;
    private String digitoidType;
    private double experience = 0;
    public Level level; //Enum Level

    //-------------------------------SETTERS---------------------------------------
    /**
     * Sets the name for the Object Digitoid.
     * @param name - name of the Digitoid
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Sets the type of the digitoid. A String. Examples could be Human, alien, fish, etc.
     * @param digitoidType - String - Type of the Digitoid.
     */
    private void setDigitoidType(String digitoidType){
        //gives an error message if the digitoid is given an empty string as a name.
        if(digitoidType.equals("")){
            System.out.println("Invalid type!");
        }else{
            //otherwise, sets the name
            this.digitoidType = digitoidType;
        }
    }
    /**
     * Sets the experience for the object.
     * @param experience - integer for experience.
     */
    private void setExperience(int experience){
        this.experience = experience;
    }
    //-------------------------------GETTERS------------------------------------------

    /**
     * Returns the name of the object. String
     * @return - String Name.
     */
    public String getName(){return name;}

    /**
     * Returns the type of the Digitoid
     * @return - String digitoid type
     */
    public String getDigitoidType(){return digitoidType;}

    /**
     * Returns the amount of experience that the object has gained.
     * @return - double experience
     */
    public double getExperience(){return experience;}
    //--------------------------------ACTIONS-----------------------------------------

    /**
     * A quick method that allows you to override and give the specific object a certain amount of experience.
     * @param newXP - the new amount of experience you want to give to the object instance.
     */
    public void experienceOverride(int newXP){
        this.experience = newXP; //assigns the new experience to the object.
        //Prints the new amount of experience that the object now has.
        System.out.println(this.getName() + " now has " + this.experience + " total experience.");

        /**
         * This conditional tree is a leveling system. Using the Enum Level
         * As they object gains a certain amount of experience it levels up!
         *
         * This increases the level of the object using the Level enum
         * Refer to the .fight method for more details!
         */
        if(this.experience >=0 && this.experience <= 5){
            level = Level.ONE;
            System.out.println(this.getName() + " is level " + level.getValue());
        }
        else if(5 < this.experience && this.experience <= 10){
            level = Level.TWO;
            System.out.println(this.getName() + " is now level " + level.getValue());
        }
        else if(10 < this.experience && this.experience <= 15 ){
            level = Level.THREE;
            System.out.println(this.getName() + " is now level " + level.getValue());
        }
        else if(15 < this.experience && this.experience <= 20 ){
            level = Level.FOUR;
            System.out.println(this.getName() + " is now level " + level.getValue());
        }
        else if(20 < this.experience && this.experience <= 25 ){
            level = Level.FIVE;
            System.out.println(this.getName() + " is now level " + level.getValue());
        }
        else if(25 < this.experience && this.experience <= 30 ){
            level = Level.SIX;
            System.out.println(this.getName() + " is now level " + level.getValue());
        }
        else if(30 < this.experience && this.experience <= 35 ){
            level = Level.SEVEN;
            System.out.println(this.getName() + " is now level " + level.getValue());
        }
        else if(35 < this.experience && this.experience <= 40 ){
            level = Level.EIGHT;
            System.out.println(this.getName() + " is now level " + level.getValue());
        }
        else if(40 < this.experience && this.experience <= 45 ){
            level = Level.NINE;
            System.out.println(this.getName() + " is now level " + level.getValue());
        }
        else if(this.experience > 45){
            level = Level.TEN;
            System.out.println(this.getName() + " is now level " + level.getValue());
        }
    }

    /**
     * The fight method is an interaction between two objects.
     * @param someone - Digitoid, object of the class.
     */
    public void fight(Digitoid someone){
        System.out.println();
        System.out.println("----------FIGHT---------\n" + this.getName() + " is fighting " + someone.getName());

        //variable that holds the experience earned in the battle.
        //Every time there is a fight, it is set back to 0.
        int addedExperience = 0;

        //if the fight is with itself, give an message.
        if(this.equals(someone) && this.getName().equals(someone.getName())){
            System.out.println("Cannot fight self");
        }
        //if the object it is fighting has a greater experience - More experienced, increase experience by 3
        else if(this.getExperience() < someone.getExperience()){
            //if they are the same type, ignoring the casing multiply the experience by 2
            if(this.getDigitoidType().equalsIgnoreCase(someone.getDigitoidType())){
                addedExperience += 3 * 2;
                this.experience += addedExperience;
            }else{
                //if they are not the same type, multiply the experience by 3.
                addedExperience += 3 * 3;
                this.experience += addedExperience;
            }
            //if they are equal to each other, then multiply the experience by 0.5.
            if(this.equals(someone) == true){
                this.experience -= addedExperience;
                addedExperience *= 0.5;
                this.experience += addedExperience;
            }
        }
        //Else if they have the same amount of experience -> Equally experienced, increase experience by 2
        else if(this.getExperience() == someone.getExperience()){
            //if they have the same type -> multiply by 2
            if(this.getDigitoidType().equalsIgnoreCase(someone.getDigitoidType())){
                addedExperience += 2 * 2;
                this.experience += addedExperience;
            }
            else{
                //If they have different types multiply the experience by 3
                addedExperience += 2 * 3;
                this.experience += addedExperience;
            }
            //if they are equal then half the gained experience!
            if(this.equals(someone) == true){
                this.experience -= addedExperience;
                addedExperience *= 0.5;
                this.experience += addedExperience;
            }
        }
        //else if the object your are fighting has less experience -> Less experienced, increase experience by 1
        else if(this.getExperience() > someone.getExperience()){
            //if they have the same type -> multiply by 2
            if(this.getDigitoidType().equalsIgnoreCase(someone.getDigitoidType())){
                addedExperience += 1 * 2;
                this.experience += addedExperience;
            //If they have different types multiply the experience by 3
            }else{
                addedExperience += 1*3;
                this.experience += addedExperience;
            }
            //if they are equal then half the gained experience!
            if(this.equals(someone) == true){
                this.experience -= addedExperience;
                addedExperience *= 0.5;
                this.experience += addedExperience;
            }
        }
        System.out.println(this.getName() + " gained " + addedExperience + " experience!");

        /**
         * This conditional tree is a leveling system. Using the Enum Level
         * As they object gains a certain amount of experience it levels up!
         * Leveling Breakdown:
         *  One   - 0 - 5 xp
         *  Two   - 6-10 xp
         *  Three - 11-15 xp
         *  Four  - 16-20 xp
         *  Five  - 21-25 xp
         *  Six   - 26-30 xp
         *  Seven - 31-35 xp
         *  Eight - 36-40 xp
         *  Nine  - 41-45 xp
         *  Ten   - 46-> max int xp
         *
         *  It updates the object everytime it levels up or you can use the toString() method -
         *  to check the current level and the experience that it has total!
         */
        if (this.experience >= 0 && this.experience <= 5) {
            level = Level.ONE;
            //System.out.println(this.getName() + " is level " + level.getValue());
        } else if (5 < this.experience && this.experience <= 10) {
            //If the object is already is this level - do nothing.
            //in other words, don't keep printing the level.
            if(this.level.equals(Level.TWO)){
            }else{
                //print when it levels up.
                level = Level.TWO;
                System.out.println(this.getName() + " is now level " + level.getValue() + "!");
            }
        } else if (10 < this.experience && this.experience <= 15) {
            if(this.level.equals(Level.THREE)){
            }else{
                level = Level.THREE;
                System.out.println(this.getName() + " is now level " + level.getValue()+ "!");
            }
        } else if (15 < this.experience && this.experience <= 20) {
            if(this.level.equals(Level.FOUR)){
            }else{
                level = Level.FOUR;
                System.out.println(this.getName() + " is now level " + level.getValue()+ "!");
            }
        } else if (20 < this.experience && this.experience <= 25) {
            if(this.level.equals(Level.FIVE)){
            }else{
                level = Level.FIVE;
                System.out.println(this.getName() + " is now level " + level.getValue()+ "!");
            }
        } else if (25 < this.experience && this.experience <= 30) {
            if(this.level.equals(Level.SIX)){
            }else{
                level = Level.SIX;
                System.out.println(this.getName() + " is now level " + level.getValue()+ "!");
            }
        } else if (30 < this.experience && this.experience <= 35) {
            if(this.level.equals(Level.SEVEN)){
            }else{
                level = Level.SEVEN;
                System.out.println(this.getName() + " is now level " + level.getValue()+ "!");
            }
        } else if (35 < this.experience && this.experience <= 40) {
            if(this.level.equals(Level.EIGHT)){
            }else{
                level = Level.EIGHT;
                System.out.println(this.getName() + " is now level " + level.getValue()+ "!");
            }
        } else if (40 < this.experience && this.experience <= 45) {
            if(this.level.equals(Level.NINE)){
            }else{
                level = Level.NINE;
                System.out.println(this.getName() + " is now level " + level.getValue()+ "!");
            }
        } else if (this.experience > 45) {
            if(this.level.equals(Level.TEN)){
            }else{
                level = Level.TEN;
                System.out.println(this.getName() + " is now level " + level.getValue()+ "!");
            }
        }
        System.out.println("------END OF FIGHT------\n");
    }



    //--------------------------------------OVERRIDES-----------------------------------------------

    /**
     * Checks if two objects are equal. Name(ignores the casing) and type(ignores the casing) must be the same to be equal.
     * @param someone - Digitoid
     * @return - returns true or false if the object is equal or not.
     */
    public boolean equals(Digitoid someone){
        boolean isTheSame = false;

        if(this.getName().equalsIgnoreCase(someone.getName()) && this.getDigitoidType().equalsIgnoreCase(someone.getDigitoidType())){
            isTheSame = true;
        }
        return isTheSame;
    }

    /**
     * The toString method allows the user to see the current stats of the object.
     * @return - String Formatted:     NAME:     |Type:     |Level X|objName's EXP: X|
     */
    public String toString(){
        return (this.getName()+ ": |Type: " + this.getDigitoidType()+"|"+"Level "+ level.getValue() + "|"
                + this.getName() + "'s EXP: " + this.getExperience() + "|");
    }
    //-----------------------------------------CONSTRUCTORS------------------------------------------
    /**
     * Constructor. If you create an object and don't give a type, it sets it as a human type as default.
     * @param name
     */
    public Digitoid(String name){
        //If the name is empty, then throw an exception that the name cannot be empty
        if(name.equals("")){
            try {
                throw new RuntimeException("First name can't be empty.");
            }catch(RuntimeException e){
                //Catch the exception and print and error message.
                System.out.println("Invalid Name Error!");
            }
        }else {
            //Else set the name.
            setName(name);
        }
        //Since the Digitoid was not given a type, it is set as Human as default.
        this.setDigitoidType("Human");
        //Setting the Level of the object
        if(this.experience >= 0 && this.experience <= 5 ){
            level = Level.ONE;
        }
        else if(5 < this.experience && this.experience <= 10){
            level = Level.TWO;
        }
        else if(10 < this.experience && this.experience <= 15 ){
            level = Level.THREE;
        }
        else if(15 < this.experience && this.experience <= 20 ){
            level = Level.FOUR;
        }
        else if(20 < this.experience && this.experience <= 25 ){
            level = Level.FIVE;
        }
        else if(25 < this.experience && this.experience <= 30 ){
            level = Level.SIX;
        }
        else if(30 < this.experience && this.experience <= 35 ){
            level = Level.SEVEN;
        }
        else if(35 < this.experience && this.experience <= 40 ){
            level = Level.EIGHT;
        }
        else if(40 < this.experience && this.experience <= 45 ){
            level = Level.NINE;
        }
        else if(this.experience > 45){
            level = Level.TEN;
        }



    }

    /**
     * Another Constructor if both arguments are given, name and type. Both Strings
     * @param name - name of the object
     * @param digitoidType - type of the object
     */
    public Digitoid(String name, String digitoidType){
        //If the name is empty, then throw an exception that the name cannot be empty
        if(name.equals("")){
            try {
                throw new RuntimeException("First name can't be empty.");
            }catch(RuntimeException e){
                //Catch the exception and print and error message.
                System.out.println("Invalid Name Error!");
            }
        }else {
            //Else set the name.
            setName(name);
        }
        //Setting the type
        setDigitoidType(digitoidType);

        //Setting the Level of the object
        if(this.experience >= 0 && this.experience <= 5 ){
            level = Level.ONE;
        }
        else if(5 < this.experience && this.experience <= 10){
            level = Level.TWO;
        }
        else if(10 < this.experience && this.experience <= 15 ){
            level = Level.THREE;
        }
        else if(15 < this.experience && this.experience <= 20 ){
            level = Level.FOUR;
        }
        else if(20 < this.experience && this.experience <= 25 ){
            level = Level.FIVE;
        }
        else if(25 < this.experience && this.experience <= 30 ){
            level = Level.SIX;
        }
        else if(30 < this.experience && this.experience <= 35 ){
            level = Level.SEVEN;
        }
        else if(35 < this.experience && this.experience <= 40 ){
            level = Level.EIGHT;
        }
        else if(40 < this.experience && this.experience <= 45 ){
            level = Level.NINE;
        }
        else if(this.experience > 45){
            level = Level.TEN;
        }



    }
}