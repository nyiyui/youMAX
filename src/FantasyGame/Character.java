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
        System.out.println(getName() + " takes " + taken + " gold.Gold=" + gold + " bars");
        System.out.printf("system> %s takes %d gold.", getName(), taken);
        String fullStat = gold == maxGold ? " I can't take any more gold!" : "";
        System.out.printf("%s> I now have %d gold!%s", getName(), gold, fullStat);
        return available - taken;
    }

    /**
     * Drinking potion restores health.
     */
    void drinkPotion() {
        health = 100;
        System.out.println(getName() + " drinks potion. Health=" + health + "%");
        healthChanged();
    }

    /**
     * Reduce the health by 10%.
     */
    void exposeToRadiation() {
        health = (int) (health * 0.9);
        System.out.println("system> "+getName() + " is exposed to radiation. Health=" + health + "%");
        healthChanged();
    }

    void healthChanged() {
        if (health<=30)
            System.out.printf("%s> I only have a bit of health remaining until I can't return home!",getName());
    }

    abstract String getName();

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
