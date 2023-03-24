/**
 * OOP 2: Airplane
 * Course:      ICS4UP
 * Teacher:     Ms. Krasteva
 * Date:        2023-02-14
 * Description: An object simulating an airplane. It can (un)load passengers, use/fill up on gas, and open/close doors.
 * Author:      Ken Shibata
 */
package Airplane;

import java.util.Objects;

public class Airplane {
    private int gasLevel;
    private String landingGear;
    private String doorStatus;
    private int passengers;

    public Airplane() {
        this.gasLevel = 100;
        this.landingGear = "Down";
        this.doorStatus = "Open";
        this.passengers = 100;
    }

    public void openDoor() {
        if (Objects.equals(this.doorStatus, "Open"))
            System.out.println("door: kept open");
        else
            System.out.println("door: opened");
        this.doorStatus = "Open";
    }

    public void closeDoor() {
        if (Objects.equals(this.doorStatus, "Close"))
            System.out.println("door: kept close");
        else
            System.out.println("door: closed");
        this.doorStatus = "Closed";
    }

    public void fillUp() {
        this.gasLevel = 100;
        System.out.println("gas: filled up");
    }

    public void takeOff() {
        this.gasLevel -= 30;
        System.out.printf("gas: takeoff fuel used (-30 to %d)\n", this.gasLevel);
    }

    public void doneTakeoff() {
        // NOTE: we want to fail if null
        if (this.landingGear.equals("Down"))
            System.out.println("gear: pulled up");
        else
            System.out.println("gear: kept up");
        this.landingGear = "Up";
    }

    /**
     * Simulated cruise. Removes a portion of fuel from fuel tank.
     *
     * @param usedFuelPercent fuel used (percentage: 0 to 100) of the total available fuel
     */
    public void normalFlight(int usedFuelPercent) {
        this.gasLevel -= usedFuelPercent;
        System.out.printf("gas: normal flight fuel used (-%d to %d)\n", usedFuelPercent, this.gasLevel);
    }

    public void prepLanding() {
        // NOTE: we want to fail if null
        if (this.landingGear.equals("Up"))
            System.out.println("gear: lowered");
        else
            System.out.println("gear: kept down");
        this.landingGear = "Down";
    }

    public void land() {
        this.gasLevel -= 15;
        System.out.printf("gas: landing fuel used (-15 to %d)\n", this.gasLevel);
    }

    public void loadPass(int passengersAdded) {
        this.passengers += passengersAdded;
        System.out.printf("passengers: loaded %d to %s\n", passengersAdded,this.passengers);
    }

    public void unloadPass() {
        this.passengers = 0;
        System.out.println("passengers: unloaded");
    }

    public int getGasLevel() {
        return this.gasLevel;
    }

    public String getDoorStatus() {
        return this.doorStatus;
    }

    public int getPassengers() {
        return this.passengers;
    }

    public String getLandingGear() {
        return this.landingGear;
    }
}
