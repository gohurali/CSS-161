/**
 *
 * Driver Class for Level and Digitoid.
 *
 * @Author - Gohur Ali
 * @Version - 05222017
 * Created by gohur on 5/22/2017.
 */
public class Driver {
    public static void main(String[] args){
        Digitoid gohur = new Digitoid("Gohur");
        Digitoid pikachu = new Digitoid("Pikachu","Pokemon");
        Digitoid pikachu2 = new Digitoid("pikachu","Pokemon");
        Digitoid squirtle = new Digitoid("Squirtle","Pokemon");

        System.out.println(pikachu.equals(pikachu2));
        System.out.println(gohur.equals(pikachu));

        System.out.println(pikachu.toString());

        Digitoid invalid = new Digitoid("");
        Digitoid invalid2 = new Digitoid("rock","");
        Digitoid invalid3 = new Digitoid("","");

        pikachu.fight(pikachu);

        //Same Type - Higher Experience
        Digitoid machop = new Digitoid("Machop","Pokemon");
        machop.experienceOverride(20);

        pikachu.fight(machop);

        //Same Type - Same Experience
        pikachu.experienceOverride(0);

        pikachu.fight(squirtle);

        //Same Type - Lower Experience
        pikachu.fight(squirtle);

        //Different Type - Higher Experience
        gohur.experienceOverride(25);
        pikachu.fight(gohur);

        //Different Type - Same Experience

        System.out.println(pikachu.toString());
        System.out.println(gohur.toString());

        pikachu.experienceOverride(25);

        gohur.fight(pikachu);

        //Different Type - Lower Experience
        gohur.fight(pikachu);

        //Where equals is false - All Above

        //Where equals is true

        // XP Higher
        System.out.println(pikachu.toString());
        pikachu2.fight(pikachu);

        //XP Same
        pikachu.experienceOverride(0);
        pikachu2.experienceOverride(0);
        pikachu2.fight(pikachu);

        //XP Lower
        System.out.println(pikachu.toString());
        System.out.println(pikachu2.toString());

        pikachu2.fight(pikachu);

        DigitoidCollection myDigitoids = new DigitoidCollection();

        myDigitoids.addDigitoid(pikachu);
        myDigitoids.addDigitoid(squirtle);
        myDigitoids.addDigitoid(gohur);
        myDigitoids.addDigitoid(machop);

        myDigitoids.displayDigitoids();



        System.out.println(pikachu.toString());

    }
}
