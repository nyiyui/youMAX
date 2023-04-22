package FantasyGame;

import java.util.ArrayList;
import java.util.Arrays;

class Castle extends TiledLocation implements Location {
    ArrayList<DarkRoom> rooms;
    Character character;
    private static final ArrayList<Direction> directions = new ArrayList(Arrays.asList(
            new Direction("foyer", 1000, 0),
            new Direction("upstairs", 1000, 1),
            new Direction("downstairs", 1000, 2),
            new Direction("take gold", 1000, 10),
            new Direction("exit", 1000, -1)
    ));
    private int currentRoom = -1;
    private static final String TILE = "" +
            "_|__\n" +
            "___|";

    private ToggleableHealthReductionService hr;

    Castle() {
        rooms = new ArrayList<>(Arrays.asList(
                new DarkRoom("Foyer", 0, false),
                new DarkRoom("Watchtower", 2, false),
                new DarkRoom("Basement", 3, true)
        ));
        currentRoom = 0;
        super.mapTile = TILE;
    }

    /**
     * Adds a DarkRoom to the Castle level
     *
     * @param room
     */
    void addRoom(DarkRoom room) {
        rooms.add(room);
    }

    /**
     * Occurs when an Elf enters a DarkRoom
     *
     * @param character The Elf
     * @param room      The DarkRoom
     */
    void enterRoom(Character character, DarkRoom room) {
        room.enter(character);

        System.out.println(character.getName() + " enters the " + room.getName());
    }

    /**
     * Occurs when an Elf leaves a DarkRoom.
     *
     * @param character The Elf.
     * @param room      The DarkRoom
     */
    void exitRoom(Character character, DarkRoom room) {
        room.exit(character);

        System.out.println(character.getName() + " leaves the " + room.getName());
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
    DarkRoom getRoom(int index) {
        return rooms.get(index);
    }

    @Override
    public String getName() {
        return "Castle";
    }

    @Override
    public String getBlurb() {
        return "I honestly don't know enough about castles to be able to write a blurb about it. So here's some cool facts: I tried to debug a WireGuard (VPN) connection and just forgot to specify Interface.Address in the config file. :(";
    }

    @Override
    public ArrayList<Direction> getDirections() {
        return directions;
    }

    @Override
    public void move(int directionId) {
        if (directionId < 10) {
            currentRoom = directionId;
            String radiationStat = (rooms.get(currentRoom).radioactive) ? "(radioactive) " : "";
            Telop.current().show(String.format("Hey, is this the infamous %s%s?", radiationStat, rooms.get(currentRoom).getName()));
            message = "Press the following character and enter to perform the action: t. take gold    e. exit";
            if (hr == null) {
                hr = new ToggleableHealthReductionService(character, 0.7, 0);
                Engine.current().addSystem(hr);
            }
            hr.enabled = rooms.get(currentRoom).radioactive;
        } else if (directionId == 10) {
            int got = rooms.get(currentRoom).gold;
            character.gold += got;
            Telop.current().show('@', String.format("I got %d gold! I now have %s gold!", got, character.gold));
        }
    }
}

class ToggleableHealthReductionService extends HealthReductionService {
    public boolean enabled;

    public ToggleableHealthReductionService(Character character, double hpPerSecond, int jitter) {
        super(character, hpPerSecond, jitter);
    }

    @Override
    public void update(int dtms) throws ServiceRemoveException {
        if (enabled)
            super.update(dtms);
    }
}