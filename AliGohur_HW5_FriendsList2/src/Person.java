import java.util.*;
/**
 * An abstract representation of a friends list. A Person can add another person to their friends list or remove them.
 * @author  Gohur Ali
 * @version 05012017
 *
 * Created by gohur on 5/1/2017.
 */
public class Person {
    private String firstName;
    private String lastName;

    //Arraylist that holds the name of the people the Person adds as a friend.
    private ArrayList<String> friendsList = new ArrayList<String>();
    //Arraylist that holds names of the people who have been instantiated
    private ArrayList<String> listOfPeople = new ArrayList<String>();
    private ArrayList<Person> objectFriends = new ArrayList<Person>();
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~SETTERS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    /**
     * Sets the first name. Also checks for invalid first name such as empty string.
     * @param firstName
     */
    private void setFirstName(String firstName){//Enforce invarients
        //Checking for empty first name
        if(firstName.equals("")){
            System.out.println("Error. Invalid First Name");
        }else{
            //setting the first name
            this.firstName = firstName;
        }
    }
    /**
     * Sets the last name. Also checks for invalid last name such as an empty string.
     * @param lastName
     */
    private void setLastName(String lastName){//Enforce invarients
        //checking for empty last name
        if(lastName.equals("")){
            System.out.println("Error. Invalid Last Name");
        }else{
            //setting the last name
            this.lastName = lastName;
        }
    }
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~GETTERS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    /**
     * Gets the last name and returns it.
     * @param lastName
     * @return
     */
    public String getLastName(String lastName){
        return lastName;
    }
    /**
     * Gets the first name and returns it.
     * @param firstName
     * @return
     */
    public String getFirstName(String firstName){
        return firstName;
    }
    public ArrayList<String> getListOfPeople(){
        return listOfPeople;
    }
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ACTIONS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    /**
     * This allows the object to add a friend to their friends list.
     * @param newFriend - an instance of Person who the original object wants to add.
     */
    public void addNewFriend(Person newFriend){
        //Checking if the length of the array is less than five
        if(objectFriends.size() < 5){
            //If the name is empty, give an error message
            if(newFriend.firstName.equals("") || newFriend.lastName.equals("")){
                System.out.println("Error. Invalid Name");
            }
            //else if the person is trying to add them self, then tell them that they cannot add them-self.
            else if(newFriend.equals(this)){
                System.out.println("\nYou can't add yourself!");
            }
            //else if the array already has the person, then tell the person that the person is already in their list
            else if(objectFriends.contains(newFriend)){
                System.out.println("\nYou've already added " + newFriend.firstName + " " + newFriend.lastName + "!");
            }
            //otherwise, add them to the list
            else{
                objectFriends.add(newFriend);
                newFriend.objectFriends.add(this); //Adds the bilateral aspect of adding a friend
            }
            //The friends list is full
        }else{
            //Giving a message when the friends list size is equal to 5
            System.out.println();
            System.out.print("Your Friends List is Full "+ this.firstName +"!");
        }
    }
    /**
     * Allows the object to remove a friend from the friends list. Also is able to see if the object does not have any friends
     * left in their friends list, then gives a message.
     * @param firstName - first name of the object that the original Person wants to remove
     * @param lastName - last name of the object that the original Persona wants to remove
     */
    public void removeAFriend(String firstName, String lastName){
        //If the array is equal to zero, then the person is given a message
        if(objectFriends.size() == 0){
            System.out.println("\n" + this.firstName + " has no friends to remove!");
        }
        //for loop that runs through the list
        for(int i = 0; i <= objectFriends.size() - 1; i++){
            //Creating a Person variable
            Person friendToRemove = objectFriends.get(i);
            //Getting their first and last name
            String theirFirstName = friendToRemove.firstName;
            String theirLastName = friendToRemove.lastName;

            //if the first and last name are equal to that in the parameters then remove the person
            if(theirFirstName.equals(firstName) && theirLastName.equals(lastName)){
                objectFriends.remove(friendToRemove);
            }
            //if the person is trying to remove someone with a empty name, give a message
            else if (theirFirstName.equals("") || theirLastName.equals("")){
                System.out.println("Not a valid person");
            }
            //once the loop runs through the list and doesn't find the name, tell the person, the person they are
            //trying to remove is not in the list.
            else if (i == objectFriends.size() - 1){
                System.out.println("\n" + firstName + " " + lastName + " is not in " + this.firstName+ "'s"+ " friends list");
            }
        }
    }
    /**
     * Displays the list of friends that are in the object's friend's list. Also give's the Person's first name for clarity
     * on whose list is being printed.
     */
    public void displayObjectFriend(){
        //checking the list to see if there are more than 0 elements
        if(objectFriends.size() > 0){
            System.out.println("\nHere is your list of friends " + this.firstName + ":");
            //goes through the array
            for(int i = 0; i <= objectFriends.size() - 1; i++){
                //gets each person in the array
                Person thisPerson = objectFriends.get(i);
                //prints their name last,first
                System.out.print(thisPerson.lastName + "," + thisPerson.firstName + "    ");
            }
            System.out.println();
            //else, there are no friends to display for the person
        } else{
            System.out.println("\nNo Friends to Display!");
        }
    }
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~CONSTRUCTOR~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    /**
     * The constructor of the class.
     * @param firstName - first name of the original Person
     * @param lastName - last name of the original Person.
     */
    public Person(String firstName, String lastName){
        //Setting names and checking if they are valid
        setFirstName(firstName);
        setLastName(lastName);

        //If name has an empty string, give an error message, otherwise print the list of objects
        if(firstName.equals("") || lastName.equals("")){ //Checking for invalid names. The Person cannot have an empty first or last name.
            System.out.println("Invalid name."); //Error message printed for invalid name
        } else{//Else, add the Person to the list of people who have be instantiated
            String name = lastName + ", " + firstName;
            listOfPeople.add(name);
        }
        //Printing out the list of people.
        for(int i = 0; i <= listOfPeople.size() - 1; i++){
            System.out.print("• " + listOfPeople.get(i) + " ");
        }
        System.out.println();
    }
}