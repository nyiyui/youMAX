package FantasyGame;

/**
 * This class represents the a character of the game.
 */
abstract class Character {
    String name;
    /**
     * Health as a percentage (0 to 100 inclusive)
     */
    int health;
    int gold;
    Location here;
    final static int maxGold = 8;

    Character(String name) {
        this.name = name;
        health = 100;
        gold = 0;
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
