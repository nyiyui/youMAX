package FantasyGame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class represents the sole character of the game.
 */
class Character {
    String name;
    /**
     * Health as a percentage (0 to 100 inclusive)
     */
    int health;
    int gold;
    private Location here;
    int maxGold = 8;
    ArrayList<Direction> directions;

    Character(String name) {
        this.name = name;
        health = 100;
        gold = 0;
    }

    public int getMaxGold() {
        return maxGold;
    }

    void setupEngine(Engine e) {
        e.addSystem(new ElfService(this));
    }

    /**
     * Takes the maximum amount of gold and returns the leftover amount.
     *
     * @param available The amount of gold available to be taken.
     * @return The amount of gold leftover.
     */
    int takeGold(int available) {
        int taken = 0;
        if (available + gold <= maxGold) {
            gold += available;
            taken = available;
        } else {
            gold = maxGold;
            taken = available - maxGold;
        }

        System.out.println(getName() + " takes " + taken + " gold. Gold=" + gold + " bars");

        return available - taken;
    }

    /**
     * Drinking potion restores health.
     */
    void drinkPotion() {
        health = 100;

        System.out.println(getName() + " drinks potion. Health=" + health + "%");
    }

    /**
     * Reduce the health by 10%.
     */
    void exposeToRadiation() {
        health = (int) (health * 0.9);

        System.out.println(getName() + " is exposed to radiation. Health=" + health + "%");
    }

    /**
     * A description of this Elf.
     *
     * @return
     */
    String getName() {
        return "Elf " + name;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Location getHere() {
        return here;
    }

    public void moveTo(Location l) {
        Telop.current().stopShowing();
        if (here != null) {
            here.exit(this);
            Telop.current().show('@', String.format("Leaving %s, entering %s!", here.getName(), l.getName()));
        } else {
            Telop.current().show('@', String.format("Entering %s!",  l.getName()));
        }
        here = l;
        l.enter(this);
    }

    /**
     * (Internal method) Get telop message for current location.
     *
     * @return telop message
     */
    String getMessage() {
        if (here.getMessage()!=null)return here.getMessage();
        String res = "\nPress the first letter and enter to move there:\n";
        ArrayList<Direction> ds = here.getDirections();
        for (int i = 0; i < ds.size(); i++) {
            res += String.format("%d. %s\n", i + 1, ds.get(i).name);
        }
        return here.getBlurb() + res;
    }
}

/**
 * Implements player movement.
 */
class ElfService implements Service {
    private Character character;

    ElfService(Character character) {
        this.character = character;
    }

    private void checkHealth() {
        if (character.health<=0) {
            Telop.current().show('x',"Our brave main character, YouMAX, has reached 0 HP. YouMAX must re-run the program to youvive herself!");
            Engine.current().stop();
        }
    }

    public void update(int dtms) {
        checkHealth();
        Scanner s = new Scanner(System.in);
        // available() docs say "estimate" but I mean...
        try {
            if (System.in.available() == 0) return;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String move = s.next().toLowerCase();
        if (move.length()==0) {
            Telop.current().stopShowing();
        }
        if (move.charAt(0) == '?') {
            Telop.current().show('*',character.getMessage());
        }
        if (move.charAt(0) == 's') {
            Telop.current().show('@',"The main character died.");
            Engine.current().stop();
        }
        boolean moved = true;
        for (Direction d : character.getHere().getDirections()) {
            String target = d.name.toLowerCase();
            if (move.length() == 1 && move.charAt(0) == target.charAt(0)) {
                if (d.id == -1) {
                    character.moveTo(new Forest());
                }
                character.getHere().move(d.id);
                System.out.println("move");
                moved = true;
                break;
            }
        }
        if (moved) return;
        Telop.current().show(String.format("Unknown move %s", move));
    }
}
