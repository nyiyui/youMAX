package FantasyGame;

import java.util.Random;

public class Goblin implements Enemy {
    @Override
    public String getName() {
        return "Some Random Goblin :tm:";
    }

    @Override
    public void attack(Character target) {
        switch (new Random().nextInt(2)) {
            case 0:
                System.out.printf("system> <%s> used attack <Growl>!", getName());
                System.out.printf("%s> Growl!", getName());
                target.health -= 2;
                break;
            case 1:
                System.out.printf("system> <%s> used attack <Bite>!", getName());
                System.out.printf("%s> Chomp!", getName());
                target.health -= 11;
                break;
        }
    }
}
