/**
 * Names: Ivy Zhuang, Ken Shibata, Youmin Lee
 * Teacher: Ms. Krasteva
 * Date: Feb
 * Purpose: YouKaiWatch Class, a watch that every youperson owns which is used to summon the youkais it stores
 */
package Youniverse;

import java.util.ArrayList;

public class YoukaiWatch extends YouGod{
    /**
     * Lists all youkais created.
     */
    private static ArrayList<YoukaiWatch> watches = new ArrayList<>();
    /**
     * All YoukaiWatches are paired with Youkais. This is this watch's pair.
     */
    private Youkai pair;

    /**
     * Creates a new YoukaiWatch
     * @param pair Paired Youkai. Whenever the watch is activated, this Youkai is called.
     */
    YoukaiWatch(Youkai pair) {
        super(String.format("Watch %d", watches.size()), 2, true); // all YoukaiWatches are immortal as youkais ArrayList is only appended to.
        watches.add(this);
        this.pair = pair;
    }

    /**
     * Activates the watch, helping all the people.
     */
    public void activate() {
        pair.helpThePeople();
    }
}