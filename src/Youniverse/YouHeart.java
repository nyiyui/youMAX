/**
 * Names: Youmin Lee, Ivy Zhuang, Ken Shibata
 * Teacher: Ms. Krasteva
 * Date:
 * Purpose:
 */
package Youniverse;

public class YouHeart {
    private int bpm;
    private boolean lonely;
    private double hp;
    private String emotion;

    public YouHeart() {
        bpm = 100;
        lonely = true;
        hp = 100;
        emotion = "Melancholy";
    }

    public void die(){
        bpm = 0;
        emotion = "Content";
        lonely = true;
        hp = 0;
    }
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
