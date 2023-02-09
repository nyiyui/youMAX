/**
 * OOP Exercise 1: Creating Objects - Animal
 * <p>
 * Course: ICS3U0
 * Teacher: Ms. Krasteva
 * Created: 2023-02-09
 * Purpose: Objects representing an Animal that can get tired and hungry.
 *
 * @author Ms. Krasteva
 */
package CreatingObjects;

public class Animal {
    private String name;
    private boolean tired;
    private boolean hungry;
    private double weight;

    /**
     * Creates 5 instances of Animal and runs each of the instance methods.
     *
     * @param args ignored command-line arguments
     */
    public static void main(String[] args) {
        Animal[] animals = new Animal[5];
        animals[0] = new Animal("Moo", 50);
        animals[1] = new Animal("John", 60);
        animals[2] = new Animal("Reimu", 55);
        animals[3] = new Animal("Flandre", 45);
        animals[4] = new Animal("Marisa", 70);
        for (Animal a : animals) {
            a.feed("vegetables");
            a.feed("meat");
            a.sleep();
        }
    }

    /**
     * Initialises an Animal with a name and weight.
     *
     * @param n name
     * @param w weight
     */
    public Animal(String n, double w) {
        name = n;
        tired = true;
        hungry = true;
        weight = w;
    }

    /**
     * Feed the animal vegetables, meat, or other food.
     *
     * @param v type of food
     */
    public void feed(String v) {
        hungry = false;
        if (v.equals("vegetables"))
            weight += 2;
        else if (v.equals("meat"))
            weight += 4;
        else
            weight += 1;
    }

    /**
     * Make the animal sleep.
     */
    public void sleep() {
        tired = false;
        weight -= 3;
    }
} // Animal class
