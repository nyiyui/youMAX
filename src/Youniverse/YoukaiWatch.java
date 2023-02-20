/**
 * Names: Ivy Zhuang, Ken Shibata, Youmin Lee
 * Teacher: Ms. Krasteva
 * Date: Feb
 * Purpose: YouKaiWatch Class, a watch that every youperson owns which is used to summon the youkais it stores
 */
package Youniverse;

import java.util.ArrayList;

public class YoukaiWatch extends YouGod{
    //TODO: constructor, methods, attributes, comments
    private ArrayList<Youkai> youkais;
    public void call() {
        for (Youkai y : youkais) {
            y.helpThePeople();
        }
    }
}
