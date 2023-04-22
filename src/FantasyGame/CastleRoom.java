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

/**
 * CastleRooms have certain properties that Elves can interact with.
 */
class CastleRoom {
    private String name;
    private int gold;
    private boolean radioactive;

    ArrayList<Character> elves;

    /**
     * Constructs a CastleRoom
     *
     * @param name        The name of the room.
     * @param gold        The amount of the gold.
     * @param radioactive If radioactivity is present
     */
    CastleRoom(String name, int gold, boolean radioactive) {
        this.name = name;
        this.gold = gold;
        this.radioactive = radioactive;

        elves = new ArrayList<Character>();
    }

    /**
     * Have Elf interact with CastleRoom.
     *
     * @param character
     */
    void enter(Character character) {
        elves.add(character);
        // randomly expose to raadiation
        if (isRadioactive() && new Random().nextInt(10) == 0) {
            System.out.printf("%s> Wah! I got hit by a gamma ray!\n",character.getName());
            character.exposeToRadiation();
        }
        gold = character.takeGold(gold);
    }

    /**
     * Remove Elf from room.
     *
     * @param character
     */
    void exit(Character character) {
        elves.remove(character);
    }

    /**
     * A description of this CastleRoom
     *
     * @return
     */
    String getName() {
        return name;
    }

    public boolean isRadioactive() {
        return radioactive;
    }
}