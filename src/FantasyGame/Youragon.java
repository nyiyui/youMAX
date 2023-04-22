package FantasyGame;

import java.util.Random;

public class Youragon implements Younemy {
    @Override
    public String getName() {
        return "The Big Red Dragon";
    }

    @Override
    public void attack(Character target) {
        switch (new Random().nextInt(3)) {
            case 0:
                System.out.printf("system> <%s> used attack <Poke>!\n", getName());
                System.out.printf("%s> Poke!\n", getName());
                System.out.printf("%s> Aaaah!\n", target.getName());
                target.health -= 2;
                break;
            case 1:
                System.out.printf("system> <%s> used attack <Bite>!\n", getName());
                System.out.printf("%s> Chomp!\n", getName());
                System.out.printf("%s> AAaaaaaaaaaaaaaaaaaaaaAAAhh!\n", target.getName());
                target.health -= 11;
                break;
            case 2:
                System.out.printf("system> <%s> used attack <Fire>!\n", getName());
                System.out.printf("%s> GAAaAAAAa!\n", getName());
                System.out.printf("%s> AAaaaaaaaaUUUUUUUUUUuuuuuuuuuuwuaaaAAAaaaaaaaaaaaaaaaaaaAAAhh!\n", target.getName());
                target.health -= 11;
                break;
        }
    }
}
