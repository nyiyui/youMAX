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

    public static void main(String[] args) {
        // NOTE: run with -ea
        Airplane youcraft = new Airplane();
        // assert initial state
        assert youcraft.getGasLevel() == 100;
        assert Objects.equals(youcraft.getLandingGear(), "Down");
        assert Objects.equals(youcraft.getDoorStatus(), "Open");
        assert youcraft.getPassengers() == 100;

        // closing door
        youcraft.closeDoor();
        assert Objects.equals(youcraft.getDoorStatus(), "Closed");
        youcraft.openDoor();
        assert Objects.equals(youcraft.getDoorStatus(), "Open");

        // test landing gear
        youcraft.doneTakeoff();
        assert Objects.equals(youcraft.getLandingGear(), "Up");
        youcraft.prepLanding();
        assert Objects.equals(youcraft.getLandingGear(), "Down");

        // gas level
        youcraft.fillUp();
        assert youcraft.getGasLevel() == 100;
        youcraft.takeOff();
        assert youcraft.getGasLevel() == 70;
        youcraft.normalFlight(50);
        assert youcraft.getGasLevel() == 20;
        youcraft.land();
        assert youcraft.getGasLevel() == 5;

        // passengers
        youcraft.unloadPass();
        assert youcraft.getPassengers() == 0;
        Airplane youcopter = new Airplane();
        youcopter.loadPass(23);
        assert youcopter.getPassengers() == 100 + 23;
    }

    public void openDoor() {
        if (this.doorStatus == "Open")
            System.out.println("door: kept open");
        else
            System.out.println("door: opened");
        this.doorStatus = "Open";
    }

    public void closeDoor() {
        if (this.doorStatus == "Close")
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
