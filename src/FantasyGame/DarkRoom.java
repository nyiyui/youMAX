package FantasyGame;

import java.util.ArrayList;

/**
 * DarkRooms have certain properties that Elves can interact with.
 *
 *
 */
class DarkRoom {
	String name;
	int gold;
	boolean radioactive;
	
	ArrayList<Elf> elves;
	
	/**
	 * Constructs a DarkRoom
	 * @param name The name of the room.
	 * @param gold The amount of the gold.
	 * @param radioactive If radioactivity is present
	 */
	DarkRoom(String name, int gold, boolean radioactive)
	{
		this.name = name;
		this.gold = gold;
		this.radioactive = radioactive;
		
		elves = new ArrayList<Elf>();
	}
	
	/**
	 * Have Elf interact with DarkRoom.
	 * @param elf
	 */
	void enter(Elf elf)
	{
		elves.add(elf);
		
		if (radioactive)
			elf.exposeToRadiation();
		
		gold = elf.takeGold(gold);
	}
	
	/**
	 * Remove Elf from room.
	 * @param elf
	 */
	void exit(Elf elf)
	{
		elves.remove(elf);
	}

	/**
	 * A description of this DarkRoom
	 * @return
	 */
	String getName() {
		
		return name;
	}
}