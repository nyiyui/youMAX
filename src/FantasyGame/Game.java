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

import java.util.Arrays;
import java.util.Random;

/**
 * This class is responsible for constructing levels and coordinating interaction of
 * Elves with Darkrooms.
 */
public class Game {

    /**
     * Initiates the start of game play.
     */
    void play() {
        gameIntro();
        Character characters[] = {
                new Elf("YouMAX"),
                new Souta()
        };
        Castle castle = new Castle();
        createLevel1(castle);

        for (int i = 0; i < castle.getRoomCount(); i++) {
            CastleRoom room = castle.getRoom(i);
            Character character = characters[new Random().nextInt(characters.length)];
            castle.enterRoom(character, room);
            switch (new Random().nextInt(10)) {
                case 0:
                    character.hallucinate();
                    break;
                case 1:
                case 2:
                    character.drinkPotion();
                    break;
            }
            castle.exitRoom(character, room);
        }
    }

    void gameIntro() {
        System.out.println("The story so far (aka the improved storyline): ");
        System.out.println("Once upon a time, in your typical fantasy world, an Elf, Fortuna, from the future suddenly appears?!");
        System.out.println("With them, they brought new high-end technology such as the EMS (Elf Movement Service)!");
        System.out.println("In addition, Fortuna is travelling through a very high-tech forest which is installed with an AQS (Air Quality Service).");
        System.out.println("Within this forest, the Fortuna can fight dragons and you-unicorns.");
        System.out.println("Fortuna may or may not be powerful to defeat these enemies, so we shall have to see how the story unfolds. IKZ!!!");
        System.out.println(new String(new char[77]).replaceAll(".","-"));
    }

    /**
     * Constructs one level of the game for a character.
     *
     * @param castle
     */
    void createLevel1(Castle castle) {
        CastleRoom room = new CastleRoom("foyer", 3, true);
        castle.addRoom(room);

        room = new CastleRoom("kitchen", 0, false);
        castle.addRoom(room);

        room = new CastleRoom("living room", 5, true);
        castle.addRoom(room);

        room = new CastleRoom("basement",7,true);
        castle.addRoom(room);
    }
}
