/**
 * Names: Ivy Zhuang, Ken Shibata, Youmin Lee
 * Teacher: Ms Krasteva
 * Date: Feb 20, 2023
 * Purpose: Younimal class, the little critters running around the Youniverse.
 */
package Youniverse;

import java.util.ArrayList;

public class Younimal extends Youmax {
    //TODO: javadoc comments, more methods
    /**
     * whether this Younimal is hungry
     */
    private boolean hungry;
    /**
     * How heavy Younimal is (lb)
     */
    private double weight;
    protected static ArrayList<YouPerson> people = new ArrayList<>();

    /**
     * constructor for Younimal, uses Youmax superconstructor
     * automatically sets hungry to true and weight is calculated relative to height.
     *
     * @param name     Younimals need names, or we won't be able to tell them apart.
     * @param height   how tall this Younimal is (cm)
     * @param immortal some Younimals can live forever, some can't :')
     * @param speed    how fast this Younimal is. (m/s)
     */
    public Younimal(String name, int height, boolean immortal, double speed) {
        super(name, height, immortal, speed);
        hungry = true;
        weight = height * 2.5;
    }

    /**
     *
     * @param food for some mysterious reason, everyone on YouEarth are vegeterians meaning we only eat Youlants :>
     */
    public void eat(Youlant food){

    }
    public boolean isHungry() {
        return hungry;
    }

    public void setHungry(boolean hungry) {
        this.hungry = hungry;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Call when Younimal is charmed by another Younimal.
     *
     * @param charmedBy charmed by this Younimal.
     */
    protected void charmedBy(Younimal charmedBy) {
        sayf("%sに胸キュン！ (charmed by %s)\n", charmedBy.getName(), charmedBy.getName());
    }
}
