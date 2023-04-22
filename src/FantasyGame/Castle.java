package FantasyGame;

import java.util.ArrayList;

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
        String radiationBlurb = room.radioactive ? " It's nice to not be bombarded by alpha, beta and gamma particles!" : "";
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
     * Returns a DarkRoom according to index.
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
        return "TODO: ivy help";
    }
}
