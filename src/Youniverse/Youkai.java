/**
 * Names: Ivy Zhuang, Ken Shibata, Youmin Lee
 * Teacher: Ms. Krasteva
 * Date: Feb 20, 2023
 * Purpose: Youkai class, youkai are mythical younimals with the power to help the youpeople
 */
package Youniverse;

import java.util.ArrayList;

public class Youkai extends Younimal {
    /**
     * List of all Youkais. As this is only appended to, all Youkais are immortal to the GC.
     */
    private static ArrayList<Youkai> youkais = new ArrayList<>();

    /**
     * Creates a Youkai.
     *
     * @param name   Youkai's name
     * @param height Height (cm)
     * @param speed  Max speed (m/s)
     */
    public Youkai(String name, int height, double speed) {
        super(name, height, true, speed);
        youkais.add(this);
    }

    /**
     * Helps all YouPersons.
     */
    public void helpThePeople() {
        for (YouPerson p : people) {
            help(p);
        }
    }

    /**
     * Helps the specified YouPerson.
     * @param target The YouPerson to help.
     */
    public void help(YouPerson target) {
        target.thinkOf(String.format("Oh! %s came to help me!", getName()), "so happy I can't believe it");
    }
}
