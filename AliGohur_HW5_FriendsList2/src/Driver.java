/**
 * The Driver class for the Person Class
 * @author  Gohur Ali
 * @version 05012017
 *
 * Created by gohur on 5/1/2017.
 */
public class Driver {
    public static void main(String[] args){
        System.out.println("This is a list of instances of people:");
        Person gohur = new Person("Gohur" , "Ali");
        Person bob = new Person("Bob", "Edwards");
        Person john = new Person("John", "Doe");
        Person cole = new Person("Cole", "Smith");
        Person sarah = new Person("Sarah", "Jane");
        Person mary = new Person("Mary", "Lou");
        Person daniel = new Person("Daniel", "Richards");
        Person kory = new Person("Kory", "Parker");
        Person vince = new Person("Vince", "Carter");

        //Attempting to create a person with an invalid first and/or last name
        Person mrInvalid = new Person("","");

        //Ensuring each instance has at least one friend
        gohur.addNewFriend(bob);
        bob.addNewFriend(john);
        john.addNewFriend(cole);
        cole.addNewFriend(sarah);
        sarah.addNewFriend(mary);
        mary.addNewFriend(daniel);
        daniel.addNewFriend(gohur); //Works bilaterally! gohur has daniel as a friend as well!

        gohur.addNewFriend(john);
        gohur.addNewFriend(cole);
        gohur.addNewFriend(sarah); //Gohur's fifth friend

        daniel.addNewFriend(cole);
        daniel.displayObjectFriend();

        daniel.removeAFriend("Cole", "Smith");
        daniel.displayObjectFriend();


        gohur.addNewFriend(mary); //Gives a message that the friends list is full
        gohur.displayObjectFriend();

        //Attempting to add self
        daniel.addNewFriend(daniel);
        daniel.displayObjectFriend();

        //Attempting to add a friend that is already added
        daniel.addNewFriend(mary);
        daniel.displayObjectFriend();

        //Attempting to remove a friend that is not in Daniel's friends list
        daniel.removeAFriend("Cole", "Smith");
        daniel.displayObjectFriend();

        //Kory has no friends here
        kory.displayObjectFriend();

        //Giving Kory a friend
        kory.addNewFriend(john);
        kory.displayObjectFriend();

        //Kory removing his only friend
        kory.removeAFriend("John", "Doe");
        kory.displayObjectFriend();

        //Attempting to remove a friend from a Person with no friends
        kory.removeAFriend("Gohur", "Ali");
        kory.displayObjectFriend();

        vince.addNewFriend(gohur);
        vince.removeAFriend("Sarah", "Jane");

        vince.displayObjectFriend();
    }
}
