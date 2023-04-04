package Airplane;

import java.util.Objects;

public class AirplaneMain {
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

}
