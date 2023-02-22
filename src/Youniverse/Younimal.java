/**
 * Names: Ivy Zhuang, Ken Shibata, Youmin Lee
 * Teacher: Ms Krasteva
 * Date: Feb 20, 2023
 * Purpose: Younimal class, the little critters running around the Youniverse.
 */
package Youniverse;

import java.util.ArrayList;

public class Younimal extends Youmax {
    /**
     * whether this Younimal is hungry
     */
    private boolean hungry;
    /**
     * How heavy Younimal is (lb)
     */
    private double weight;
    /**
     * the people Younimal can interact with
     */
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
     * Younimals need to eat to survive, but won't eat if they aren't hungry or the food is unhealthy
     * if they eat the food, they will gain weight and HP :D
     *
     * @param food for some mysterious reason, everyone on YouEarth are vegeterians meaning we only eat Youlants :>
     */
    public void eat(Youlant food) {
        if (!hungry) {
            System.out.println(getName() + " isn't hungry smh.");
        } else if (food.getNutrients() < 0) {
            System.out.println(getName() + " won't eat this unhealthy youlant. >:(");
        } else {
            hungry = false;
            weight += food.getNutrients() / 2.0;
            getYouHeart().setHp(getYouHeart().getHp() + food.getNutrients());
            System.out.println(getName() + " has eaten a(n) " + food.getName() + "!");
            System.out.println("It had a nutritional value of " + food.getNutrients() + " and now " + getName() + " has " + getYouHeart().getHp() + " HP.");
        }
    }

    /**
     * accessor method for younimal's hunger
     *
     * @return whether or not younimal is hungry
     */
    public boolean isHungry() {
        return hungry;
    }

    /**
     * mutator method for how hungry younimal is
     *
     * @param hungry how hungry younimal is
     */
    public void setHungry(boolean hungry) {
        this.hungry = hungry;
    }

    /**
     * accessor method for younimal's weight
     *
     * @return how much younimal weighs
     */
    public double getWeight() {
        return weight;
    }

    /**
     * mutator method for younimal's weight
     *
     * @param weight younimal's new weight
     */
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
