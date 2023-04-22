package FantasyGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
/*
 ^
/|\
/|\    ^
/|\   /|\
      /|\
      /|\
     *
    **o
   *o***
  *****o*
 **o******
********o**
    ! !
   -----
   \   /
    ---

*/

class Forest extends TiledLocation implements Location {
    private static final ArrayList<Direction> directions = new ArrayList(Arrays.asList(
            new Direction("castle", 1000, 0)
    ));

    Forest() {
        super.mapTile = "" +
                " ^                 \n" +
                "/|\\                \n" +
                "/|\\    ^           \n" +
                "/|\\   /|\\          \n" +
                "      /|\\          \n" +
                "      /|\\          \n" +
                "     *             \n" +
                "    **o            \n" +
                "   *o***           \n" +
                "  *****o*          \n" +
                " **o******         \n" +
                "********o**        \n" +
                "    ! !            \n" +
                "   -----           \n" +
                "   \\   /           \n" +
                "    ---            \n" +
                "                   ";
    }

    private HealthReductionService aqs;

    @Override
    public void enter(Character character) {
        super.enter(character);
        aqs = new HealthReductionService(character, -0.4, 0);
        Engine.current().addSystem(aqs);
    }

    @Override
    public void exit(Character character) {
        super.exit(character);
        aqs.stop = true;
    }

    public String getName() {
        return "Forest of Magic";
    }

    ;

    public String getBlurb() {
        return "The Forest of Magic is the focal point of all things hostile and evil, located somewhat-near the Human Village (since the position changes constantly, it is not possible to accurately measure the distance.)";
    }

    @Override
    public ArrayList<Direction> getDirections() {
        return directions;
    }

    @Override
    public void move(int directionId) {
        if (directionId == 0)
            character.moveTo(new Castle());
    }
}
