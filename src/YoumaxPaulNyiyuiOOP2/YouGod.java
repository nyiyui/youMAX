/**
 * Names: Youmin Lee, Ivy Zhuang, Ken Shibata
 * Teacher: Ms. Krasteva
 * Date:
 * Purpose:
 */
package YoumaxPaulNyiyuiOOP2;

import java.util.ArrayList;

public class YouGod {
    private String name;
    private YouHeart youHeart;
    private int height;
    private ArrayList<String> thoughts;
    private boolean immortal;

    public YouGod() {
        name = "YouGOD";
        youHeart = new YouHeart(); //TODO: change constructor once YouHeart has all its variable and a proper constructor
        height = 150;
        thoughts = new ArrayList<String>();
        immortal = true;
    }

}
