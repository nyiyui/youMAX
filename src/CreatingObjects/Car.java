/**
 * OOP Exercise 1: Creating Objects - Car
 * <p>
 * Course: ICS3U0
 * Teacher: Ms. Krasteva
 * Created: 2023-02-09
 * Purpose: Objects representing a Car.
 *
 * @author Ms. Krasteva
 */
package CreatingObjects;

public class Car {
    private String brand;
    private String model;
    private int kilometres;
    private double gas;
    private double tankCapacity;

    /**
     * Creates 5 instances of Car and runs each of the instance methods.
     *
     * @param args ignored command-line arguments
     */
    public static void main(String[] args) {
        Car[] Cars = new Car[5];
        Cars[0] = new Car("Toyota", "Supra", 0, 100);
        Cars[1] = new Car("Toyota", "Corolla", 0, 90);
        Cars[2] = new Car("Toyota", "Camry", 0, 120);
        Cars[3] = new Car("Toyota", "Crown", 0, 130);
        Cars[4] = new Car("Toyota", "RAV4", 0, 200);
        for (Car c : Cars) {
            c.gasUp();
            c.drive(123.456);
        }
    }

    /**
     * Initialise a Car with the brand, model, gas, and tank capacity
     *
     * @param b    brand name
     * @param m    model name
     * @param g    gas
     * @param tCap tank capacity
     */
    public Car(String b, String m, double g, double tCap) {
        brand = b;
        model = m;
        kilometres = 0;
        gas = g;
        tankCapacity = tCap;
    }

    /**
     * Drives this Car distance km.
     *
     * @param distance distance driven (km)
     */
    public void drive(double distance) {
        kilometres += distance;
        gas -= distance / 5;
    }

    /**
     * Fill su the tank with gas (to max capacity).
     */
    public void gasUp() {
        gas = tankCapacity;
    }
} // Car class

