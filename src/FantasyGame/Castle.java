package FantasyGame;

import java.util.ArrayList;

class Castle {
	ArrayList<DarkRoom> rooms;
	
	Castle()
	{
		rooms = new ArrayList<DarkRoom>();
	}
	
	/**
	 * Adds a DarkRoom to the Castle level
	 * @param room
	 */
	void addRoom(DarkRoom room)
	{
		rooms.add(room);
	}
	
	/**
	 * Occurs when an Elf enters a DarkRoom
	 * @param elf The Elf
	 * @param room The DarkRoom
	 */
	void enterRoom(Elf elf, DarkRoom room)
	{
		room.enter(elf);
		
		System.out.println(elf.getName() + " enters the " + room.getName() );
	}
	
	/**
	 * Occurs when an Elf leaves a DarkRoom.
	 * @param elf The Elf.
	 * @param room The DarkRoom
	 */
	void exitRoom(Elf elf, DarkRoom room)
	{
		room.exit(elf);
		
		System.out.println(elf.getName() + " leaves the " + room.getName() );
	}
	
	/**
	 * Returns the number of DarkRooms.
	 * @return The number of DarkRooms.
	 */
	int getRoomCount()
	{
		return rooms.size();
	}

	/**
	 * Returns a DarkRoom according to index.
	 * @param index
	 * @return
	 */
	DarkRoom getRoom(int index) {
		return rooms.get(index);
	}
}
