/**
 * Names: Youmin Lee, Ivy Zhuang, Ken Shibata
 * Teacher: Ms. Krasteva
 * Date: Feb 19, 2023
 * Purpose: YouGod Class, the originator of all living things in the Youniverse.
 */
package Youniverse;

import java.util.ArrayList;

public class YouGod {
    private String name;
    private YouHeart youHeart;
    private int height;
    private ArrayList<String> thoughts;
    private boolean immortal;

    protected static ArrayList<Youkai> youkais;
    protected static ArrayList<YouPerson> people;

    /**
     * 1st constructors. Takes no parameters and sets all attributes to default values.
     */
    public YouGod() {
        name = "YouGOD";
        youHeart = new YouHeart();
        height = 100;
        thoughts = new ArrayList<String>();
        immortal = true;
    }

    /**
     * 2nd constructor for YouGod, used when one doesn't want to use the default values
     * @param name name of YouGod
     * @param height how tall YouGod is in centimetres
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
    public void beginCreation(){
        if(immortal){
            if(youHeart.isLonely()) {
                youHeart.setLonely(false);
                youHeart.setEmotion("Empowered");
                System.out.println(name + " has decided to enlighten the Youniverse!");
            }
            else{
                System.out.println(name+" is not feeling lonely enough :/");
            }
        }
        else {
            System.out.println("??? "+name+" isn't that powerful?");
        }
    }

    /**
     * when YouGod thinks of something, add said thought into her lists
     * @param thought a thought that YouGod just had
     * @param emotion the emotion YouGod feels due to having that emotion
     */
    public void thinkOf(String thought, String emotion){
        thoughts.add(thought);
        youHeart.setEmotion(emotion);
        System.out.println(name + " just thought of something!");
        System.out.println("\t--> \""+thought+"\"");
        System.out.println("Now "+name+" feels "+emotion+"!");
    }

    /**
     * if oneself is immortal, then one will simply be youported to the next Youniverse
     * else, one's heart shall stop function and one will peacefully pass on :pensive:
     */
    public void die(){
        if(immortal){
            System.out.println(name+" never dies! Transcending to the next Youniverse...");
        }
        else{
            youHeart.die();
            System.out.println(name+" has lived a long healthy life. :(");
        }
    }

    /**
     * all livings things can grow, so obviously YouGod should try to grow, too.
     * @param growth number of centimetres YouGod is growing taller by
     */
    public void grow(int growth){
        height += growth;
        youHeart.setHp(youHeart.getHp() + growth/2.0);
        System.out.println(name+" has grown "+growth+" centimetres!");
        System.out.println("Current HP: "+youHeart.getHp());
    }
    //TODO: javadoc comments for getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public YouHeart getYouHeart() {
        return youHeart;
    }

    public void setYouHeart(YouHeart youHeart) {
        this.youHeart = youHeart;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public ArrayList<String> getThoughts() {
        return thoughts;
    }

    public void setThoughts(ArrayList<String> thoughts) {
        this.thoughts = thoughts;
    }

    public boolean isImmortal() {
        return immortal;
    }

    public void setImmortal(boolean immortal) {
        this.immortal = immortal;
    }
}
