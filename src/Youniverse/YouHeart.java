/**
 * Names: Youmin Lee, Ivy Zhuang, Ken Shibata
 * Teacher: Ms. Krasteva
 * Date: Feb 19, 2023
 * Purpose: Youheart class, all living things have a heart, no? and a heart can feel many things, like loneliness ;)
 */
package Youniverse;

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

    /**
     * accessor method for beats per minute
     *
     * @return YouHeart's bpm
     */
    public int getBpm() {
        return bpm;
    }

    /**
     * mutator method for BPM
     *
     * @param bpm new value of Youheart's bpm
     */
    public void setBpm(int bpm) {
        this.bpm = bpm;
    }

    /**
     * accessor method for YouHeart's loneliness
     *
     * @return whether or no Youheart is feeling lonely
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
     * accessor method for youheart's HP
     *
     * @return how much HP youheart has
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
     * mutator method for youheart's emotion. The more complicated (longer) the emotion, the higher the heart rate rises to.
     *
     * @param emotion youhearts don't feel the same emotion all the time, so this is the new emotion youheart will feel
     */
    public void setEmotion(String emotion) {
        this.emotion = emotion;
        setBpm(getBpm() + emotion.length() / 2);
    }
}
