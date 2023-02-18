/**
 * Names: Youmin Lee, Ivy Zhuang, Ken Shibata
 * Teacher: Ms. Krasteva
 * Date:
 * Purpose:
 */
package YoumaxPaulNyiyuiOOP2;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class YouGod {
    private String name;
    private YouHeart youHeart;
    private int height;
    private ArrayList<String> thoughts;
    private boolean immortal;

    protected static ArrayList<Youkai> youkais;
    protected static ArrayList<YouPerson> people;

    public YouGod() {
        name = "YouGOD";
        youHeart = new YouHeart();
        height = 100;
        thoughts = new ArrayList<String>();
        immortal = true;
    }

    public YouGod(String name, int height, boolean immortal) {
        this.name = name;
        this.youHeart = new YouHeart();
        this.height = height;
        this.thoughts = new ArrayList<>();
        this.immortal = immortal;
    }
    public void beginCreation(){
        if(youHeart.isLonely()){
            youHeart.setLonely(false);
            youHeart.setEmotion("Empowered");
            System.out.println(name+" has decided to enlighten the Youniverse!");
        }
    }
    public void thinkOf(String thought, String emotion){
        thoughts.add(thought);
        youHeart.setEmotion(emotion);
        System.out.println(name + " just thought of something!");
        System.out.println("\t--> \""+thought+"\"");
        System.out.println("Now "+name+" feels "+emotion+"!");
    }
    public void die(){
        if(immortal){
            System.out.println(name+" never dies! Transcending to the next Youniverse...");
        }
        else{
            youHeart.die();
            System.out.println(name+" has lived a long healthy life. :(");
        }
    }
    public void grow(int growth){
        height += growth;
        youHeart.setHp(youHeart.getHp() + growth/2.0);
    }
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
