package Youniverse;

import java.util.Random;

public class YouCat extends Younimal {
    /**
     * Creates a String array for the YouCat names
     */
    private static String[] NAMES = {
            "坂本",
            "彼女の猫",
            "ビクター",
            "仁ちゃん",
    };

    /**
     * Makes a new YouCat with a randomly-chosen name.
     */
    YouCat() {
        super(NAMES[new Random().nextInt(NAMES.length)], 40, false, 2);
    }

    /**
     * Creates a behaviour of the YouCat which is to meow
     */
    void meow() {
        say("にゃお！ (meow)");
    }

    /**
     *Creates a behaviour of the YouCat which is to charm a YouPerson
     * @param target
     */
    void charm(YouPerson target){
        sayf("にゃ〜んｽﾘｽﾘキュル (charms %s)", target.getName());
        target.charmedBy(this);
    }
}
