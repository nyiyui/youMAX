/**
 * Names: Ivy Zhuang, Ken Shibata, Youmin Lee
 * Teacher: Ms Krasteva
 * Date: Feb 20, 2023
 * Purpose: Younimal class, the little critters running around the Youniverse.
 */
package Youniverse;

public class Younimal extends Youmax {
    /**
     * hungry = whether or not this Younimal is hungry
     * weight = how heavy Younimal is in pounds
     */
    private boolean hungry;
    private double weight;

    /**
     * constructor for Younimal, uses Youmax superconstructor
     * automatically sets hungry to true and weight is calculated relative to height.
     * @param name Younimals need names, or we won't be able to tell them apart.
     * @param height how tall this Younimal is
     * @param immortal some Younimals can live forever, some can't :')
     * @param speed how fast this Younimal is. (in metres per second)
     */
    public Younimal(String name, int height, boolean immortal, double speed) {
        super(name, height, immortal, speed);
        hungry = true;
        weight = height * 2.5;
    }
}
