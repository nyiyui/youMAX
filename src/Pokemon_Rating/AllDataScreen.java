/**
 * Names: Ken Shibata, Youmin Lee, Ivy Zhuang
 * Teacher: Ms. Krasteva
 * Date: March 6, 2023
 * Purpose:
 */
package Pokemon_Rating;

abstract class AllDataScreen extends Screen{
    //TODO: fill out purpose bc idk what to put lol
    public static int DISPLAY_TYPE_ALL = 1;
    public static int DISPLAY_TYPE_BEST = 2;
    protected int displayType;

    public void setDisplayType(int displayType) {
        this.displayType = displayType;
    }
}
