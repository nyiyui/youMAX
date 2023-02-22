/**
 * Names: Youmin Lee, Ivy Zhuang, Ken Shibata
 * Teacher: Ms. Krasteva
 * Date: Feb 19, 2023
 * Purpose: YouGod Class, the originator of all living things in the Youniverse.
 */
package Youniverse;

import java.util.ArrayList;

public class YouGod {
    /**
     * name = everyone needs a name :relieved:
     * youHeart = YouGod's youHeart, carries all of her emotions ;>
     * height = how tall YouGod is in centimetres.
     * thoughts = an arraylist containing every thought YouGod has thought
     * immortal = whether or not YouGod has an eternal life
     */
    private String name;
    private YouHeart youHeart;
    private int height;
    private ArrayList<String> thoughts;
    private boolean immortal;
    private boolean transcended;

    /**
     * 1st constructor, only for the actual YouGOD!
     * <p>
     * Package-private so other people don't make fake YouGODs.
     */
    YouGod() {
        name = "YouGOD";
        youHeart = new YouHeart();
        height = 100;
        thoughts = new ArrayList<>();
        immortal = true;
    }

    /**
     * 2nd constructor for YouGod, used when one doesn't want to use the default values
     *
     * @param name     name of YouGod
     * @param height   how tall YouGod is in centimetres
     * @param immortal whether or not YouGod is immortal
     */
    public YouGod(String name, int height, boolean immortal) {
        this.name = name;
        this.youHeart = new YouHeart();
        this.height = height;
        this.thoughts = new ArrayList<>();
        this.immortal = immortal;
    }

    /**
     * if YouGod is an immortal and almighty being, she will invoke her powers if she is feeling lonely
     */
    public void beginCreation() {
        if (immortal) {
            if (youHeart.isLonely()) {
                youHeart.setLonely(false);
                youHeart.setEmotion("Empowered");
                showf("%s has decided to enlighten the Youniverse!", name);
            } else {
                showf("%s is not feeling lonely enough :/", name);
            }
        } else {
            System.out.println("???> " + name + " isn't that powerful?");
        }
    }

    /**
     * when YouGod thinks of something, add said thought into her lists
     *
     * @param thought a thought that YouGod just had
     * @param emotion the emotion YouGod feels due to having that emotion
     */
    public void thinkOf(String thought, String emotion) {
        thoughts.add(thought);
        youHeart.setEmotion(emotion);
        System.out.println(name + " just thought of something!");
        System.out.println("\t--> \"" + thought + "\"");
        System.out.println("Now " + name + " feels " + emotion + "!");
        showf("%s's heart rate is now: %s bpm", name, youHeart.getBpm());
    }

    /**
     * if oneself is immortal, then one will simply be youported to the next Youniverse
     * else, one's heart shall stop function and one will peacefully pass on :pensive:
     */
    public void die() {
        if (immortal) {
            System.out.println(name + " never dies! Transcending to the next Youniverse...");
        } else {
            youHeart.die();
            System.out.println(name + " has lived a long healthy life. :(");
        }
    }

    /**
     * all livings things can grow, so obviously YouGod should try to grow, too.
     *
     * @param growth number of centimetres YouGod is growing taller by
     */
    public void grow(int growth) {
        height += growth;
        youHeart.setHp(youHeart.getHp() + growth / 2.0);
        System.out.println(name + " has grown " + growth + " centimetres!");
        System.out.println("Current HP: " + youHeart.getHp());
    }

    /**
     * accessor method for YouGod's name
     *
     * @return name of YouGod
     */
    public String getName() {
        return name;
    }

    /**
     * mutator method for YouGod's name
     *
     * @param name a new name for YouGod
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * accessor method for YouGod's YouHeart
     *
     * @return YouGod's YouHeart
     */
    public YouHeart getYouHeart() {
        return youHeart;
    }

    /**
     * mutator method for YouGod's YouHeart
     *
     * @param youHeart a new YouHeart for YouGod
     */
    public void setYouHeart(YouHeart youHeart) {
        this.youHeart = youHeart;
    }

    /**
     * accessor method for YouGod's height
     *
     * @return YouGod's height (altho YouGod doesn't seem to be that tall)
     */
    public int getHeight() {
        return height;
    }

    /**
     * mutator method for YouGod's height
     *
     * @param height YouGod's new height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * accessor method for YouGod's thoughts
     *
     * @return a list full of what YouGod is thinking
     */
    public ArrayList<String> getThoughts() {
        return thoughts;
    }

    /**
     * mutator method for YouGod's thoughts
     *
     * @param thoughts a new list of thoughts for YouGod
     */
    public void setThoughts(ArrayList<String> thoughts) {
        this.thoughts = thoughts;
    }

    /**
     * accessor method for YouGod's immortality
     *
     * @return whether or not YouGod is immortal
     */
    public boolean isImmortal() {
        return immortal;
    }

    /**
     * mutator method for YouGod's immortality
     *
     * @param immortal new status of YouGod's immortality
     */
    public void setImmortal(boolean immortal) {
        this.immortal = immortal;
    }

    /**
     * Say something on the console.
     *
     * @param message message to say
     */
    protected void say(String message) {
        System.out.printf("%s> %s", name, message);
    }

    /**
     * Say a formatted string using the specified format string and arguments on the console.
     *
     * @param format format specifier for message
     * @param args   arguments referenced by the format.
     */
    protected void sayf(String format, Object... args) {
        System.out.printf("%s> %s", name, String.format(format, args));
    }

    /**
     * Say something on the console as the voice from heaven.
     *
     * @param message message to say
     */
    protected void show(String message) {
        System.out.printf("%s> %s", name, message);
    }

    /**
     * Say a formatted string using the specified format string and arguments on the console as the voice from heaven.
     *
     * @param format format specifier for message
     * @param args   arguments referenced by the format.
     */
    protected void showf(String format, Object... args) {
        System.out.printf("%s> %s", name, String.format(format, args));
        System.out.println();
    }

    /**
     * Makes the YouGod transcend into the next Youniverse.
     */
    public void transcend() {
        show("YouGod has transcended into the next Youniverse!");
        transcended = true;
    }
}
