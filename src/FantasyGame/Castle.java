/**
 * Names: Ken Shibata & Ivy Zhuang
 * Teacher: Ms. Krasteva
 * Date: Feb 21, 2023
 * Purpose: simulation of a fantasy game, modified and better than before!
 * Improved Storyline: printed by program.
 * Contributions: Ken - basically all the code, Ivy - game intro and lore, all those damn UMLs.
 * Note: Telop means text on top of graphics (e.g. captions).
 */
package FantasyGame;

import java.util.ArrayList;
import java.util.Random;

class Castle extends Location {
    ArrayList<CastleRoom> rooms;

    Castle() {
        rooms = new ArrayList<CastleRoom>();
    }

    /**
     * Adds a DarkRoom to the Castle level
     *
     * @param room
     */
    void addRoom(CastleRoom room) {
        rooms.add(room);
    }

    /**
     * Occurs when an Elf enters a DarkRoom
     *
     * @param character The Elf
     * @param room      The DarkRoom
     */
    void enterRoom(Character character, CastleRoom room) {
        room.enter(character);
        System.out.printf("%s> Entering %s!", character.getName());
    }

    /**
     * Occurs when an Elf leaves a DarkRoom.
     *
     * @param character The Elf.
     * @param room      The DarkRoom
     */
    void exitRoom(Character character, CastleRoom room) {
        room.exit(character);
        String radiationBlurb = room.isRadioactive() ? " It's nice to not be bombarded by alpha, beta and gamma particles!" : "";
        System.out.printf("%s> Leaving %s.%s", character.getName(), room.getName(), radiationBlurb);
    }

    /**
     * Returns the number of DarkRooms.
     *
     * @return The number of DarkRooms.
     */
    int getRoomCount() {
        return rooms.size();
    }

    /**
     * Returns a Room according to index.
     *
     * @param index
     * @return
     */
    CastleRoom getRoom(int index) {
        return rooms.get(index);
    }

    @Override
    String getName() {
        return "Bowser's Castle";
    }

    @Override
    String getBlurb() {
        return "What's this more than just trains and air conditioning got transported to this fantasy world?" +
                "\nIndeed, a piece of a popular game franchise is also here! Welcome to Bowser's Castle :D";
    }
}
