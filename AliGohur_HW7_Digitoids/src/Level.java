/**
 *
 * Level Enum. Allows for Objects to have a certain level after they obtain a certain amount of experience.
 *
 * @Author - Gohur Ali
 * @Version - 05222017
 * Created by gohur on 5/29/2017.
 */

public enum Level {
    /**
     * One   - 0 - 5 xp
     * Two   - 6-10 xp
     * Three - 11-15 xp
     * Four  - 16-20 xp
     * Five  - 21-25 xp
     * Six   - 26-30 xp
     * Seven - 31-35 xp
     * Eight - 36-40 xp
     * Nine  - 41-45 xp
     * Ten   - 46-> max int xp
     */

    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE (5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10);

    private final int value;
    public int getValue(){
        return value;
    }
    private Level(int value){
        this.value = value;
    }


}
