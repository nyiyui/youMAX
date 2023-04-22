/**
 * top comments lmao
 */
package FantasyGame;

/**
 * This class is responsible for constructing levels and coordinating interaction of
 * Elves with Darkrooms.
 *
 *
 */
public class Game {

	/**
	 * Initiates the start of game play.
	 */
	void play() {
		gameIntro();
    Engine.current().addSystem(Telop.current());
		Elf elf = new Elf("Sam");
    elf.setupEngine(Engine.current());
	Engine.current().loop();
    return;
//		Castle castle = new Castle();
//		createLevel1(castle);
//
//		for (int i=0; i<castle.getRoomCount(); i++)
//		{
//			DarkRoom room = castle.getRoom(i);
//			castle.enterRoom(elf, room);
//			castle.exitRoom(elf, room);
//		}
	}

	void gameIntro(){
		System.out.println("The story so far (aka the improved storyline): ");
		System.out.println("Once upon a time, in your typical fantasy world, an Elf from the future suddenly appears?!");
		System.out.println("With them, they brought new high-end technology such as the EMS (Elf Movement Service)!");
		System.out.println("In addition, the ELf is travelling through a very high-tech forest which is installed with an AQS (Air Quality Service).");
		System.out.println("Within this forest, the Elf can..."); // me add more later
	}

	/**
	 * Constructs one level of the game for a character.
	 * @param castle
	 */
	void createLevel1(Castle castle)
	{
		DarkRoom room = new DarkRoom("foyer", 50, true);
		castle.addRoom(room);
		
		room = new DarkRoom("kitchen", 100, false);
		castle.addRoom(room);
		
		room = new DarkRoom("living room", 0, true);
		castle.addRoom(room);
	}
}
