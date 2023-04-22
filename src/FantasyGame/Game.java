/**
 * top comments lmao
 */
package FantasyGame;

/**
 * This class is responsible for running {@link Engine}'s game loop.
 */
public class Game {
	private static final String storySoFar ="The story so far (aka the improved storyline): "+
		"Once upon a time, in your typical fantasy world, an Elf from the future suddenly appears?!"+
		"With them, they brought new high-end technology such as the EMS (Elf Movement Service)!"+
		"In addition, the ELf is travelling through a very high-tech forest which is installed with an AQS (Air Quality Service)."+
		"Within this forest, the Elf can...";

    /**
     * Initiates the start of game play.
     */
    void play() {
        Character character = new Character("YouMAX");
        character.moveTo(new Forest());
        Engine.current().addSystem(Telop.current());
        Telop.current().setCharacter(character);
        Telop.current().show('*', "Press \"?\" and enter to view info, \"s\" to make the main character die.");
		Engine.current().addSystem(new TelopTimer(3000, storySoFar));
        character.setupEngine(Engine.current());
        Engine.current().loop();
    }
}
