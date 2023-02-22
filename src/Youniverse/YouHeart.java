/**
 * Names: Youmin Lee, Ivy Zhuang, Ken Shibata
 * Teacher: Ms. Krasteva
 * Date: Feb 19, 2023
 * Purpose: Youheart class, all living things have a heart, no? and a heart can feel many things, like loneliness ;)
 */
package Youniverse;

/**
 * bpm = YouHeart's heartbeats per minute
 * lonely = whether or not YouHeart feels lonely
 * hp = how much health YouHeart has
 * emotion = what YouHeart is feeling like
 */
public class YouHeart {
    /**
     * bpm = beats per minute that youheart beats
     * lonely = whether or not youheart is feeling lonely
     * hp = the amount of hit points youheart has
     * emotion = what emotion youheart is feeling
     */
    private int bpm;
    private boolean lonely;
    private double hp;
    private String emotion;

    /**
     * constructor for YouHeart, all living creatures start with the same youheart bc equality :D
     */
    public YouHeart() {
        bpm = 100;
        lonely = true;
        hp = 100;
        emotion = "Melancholy";
    }

    /**
     * If one dies, YouHeart stops all functions and becomes content with the life it lived
     */
    public void die() {
        bpm = 0;
        emotion = "Content";
        lonely = true;
        hp = 0;
    }
<<<<<<< HEAD
    //TODO: javadoc comments for getters and setters

    /**
     * Gets/retrieves YouHeart's bpm
     * @return bpm
=======

    /**
     * accessor method for beats per minute
     *
     * @return YouHeart's bpm
>>>>>>> 3fb40de2a3f1f42ebb33e77f8b47882b091bf9b1
     */
    public int getBpm() {
        return bpm;
    }

    /**
<<<<<<< HEAD
     * Sets YouHeart's bpm to a different int
     * @param bpm
=======
     * mutator method for BPM
     *
     * @param bpm new value of Youheart's bpm
>>>>>>> 3fb40de2a3f1f42ebb33e77f8b47882b091bf9b1
     */
    public void setBpm(int bpm) {
        this.bpm = bpm;
    }

    /**
<<<<<<< HEAD
     * Checks if YouHeart is feeling lonely with boolean
     * @return lonely
=======
     * accessor method for YouHeart's loneliness
     *
     * @return whether or not Youheart is feeling lonely
>>>>>>> 3fb40de2a3f1f42ebb33e77f8b47882b091bf9b1
     */
    public boolean isLonely() {
        return lonely;
    }

    /**
     * Sets loneliness. Lonely Youmax is sad.
     *
     * @param lonely the state of youheart's loneliness
     */
    public void setLonely(boolean lonely) {
        this.lonely = lonely;
    }

    /**
<<<<<<< HEAD
     * 
     * @return
=======
     * accessor method for youheart's HP
     *
     * @return how much HP youheart has
>>>>>>> 3fb40de2a3f1f42ebb33e77f8b47882b091bf9b1
     */
    public double getHp() {
        return hp;
    }

    /**
     * mutator method for youheart's hp
     *
     * @param hp new value of youheart's hp
     */
    public void setHp(double hp) {
        this.hp = hp;
    }

    /**
     * accessor method for youheart's emotion
     *
     * @return what emotion youheart is feeling
     */
    public String getEmotion() {
        return emotion;
    }

    /**
<<<<<<< HEAD
     *
     * @param emotion
=======
     * mutator method for youheart's emotion. The more complicated (longer) the emotion, the higher the heart rate rises to.
     *
     * @param emotion youhearts don't feel the same emotion all the time, so this is the new emotion youheart will feel
>>>>>>> 3fb40de2a3f1f42ebb33e77f8b47882b091bf9b1
     */
    public void setEmotion(String emotion) {
        this.emotion = emotion;
        setBpm(getBpm() + emotion.length() / 2);
    }
}
