package FantasyGame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class represents the sole character of the game.
 */
class Elf {
    String name;
    /**
     * Health as a percentage (0 to 100 inclusive)
     */
    int health;
    int gold;
    Location here;
    final static int maxGold = 8;
    ArrayList<Direction> directions;

    Elf(String name) {
        this.name = name;
        health = 100;
        gold = 0;
    }

    void setupEngine(Engine e) {
        e.addSystem(new ElfMovementService(this));
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
}

/**
 * Implements player movement.
 */
class ElfMovementService implements Service {
    private Elf elf;

    ElfMovementService(Elf elf) {
        this.elf = elf;
    }

    public void update(int dtms) {
        Scanner s = new Scanner(System.in);
        // available() docs say "estimate" but I mean...
        try {
            if (System.in.available() == 0) return;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String move = s.next().toLowerCase();
        boolean moved = true;
        for (Direction d : elf.here.getDirections()) {
            String target = d.name.toLowerCase();
            if (move.length() == 1 && move.charAt(0) == target.charAt(0)) {
//        elf.move(d);
                System.out.println("move");
                moved = true;
                break;
            }
        }
        if (moved) return;
        Telop.current().show(String.format("Unknown move %s", move));
    }
}
