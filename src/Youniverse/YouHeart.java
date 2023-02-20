/**
 * Names: Youmin Lee, Ivy Zhuang, Ken Shibata
 * Teacher: Ms. Krasteva
 * Date: Feb 19, 2023
 * Purpose: Youheart class, all living things have a heart, no?
 */
package Youniverse;

public class YouHeart {
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
    public void die(){
        bpm = 0;
        emotion = "Content";
        lonely = true;
        hp = 0;
    }
    //TODO: javadoc comments for getters and setters
    public int getBpm() {
        return bpm;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
    }

    public boolean isLonely() {
        return lonely;
    }

    /**
     * Sets loneliness. Lonely Youmax is sad.
     */
    public void setLonely(boolean lonely) {
        this.lonely = lonely;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public String getEmotion() {
        return emotion;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }
}
