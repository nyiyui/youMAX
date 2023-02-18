package YoumaxPaulNyiyuiOOP2;

import java.util.Random;

public class YouCat extends Younimal {
    private static String[] NAMES = {
            "坂本",
            "彼女の猫",
            "ビクター",
            "仁ちゃん",
    };
    private final String name;

    YouCat() {
        super();
        name = NAMES[new Random().nextInt(NAMES.length)];
    }

    void meow() {
        System.out.printf("%s> にゃお！", name);
    }
}
