/**
 * Names: Ken Shibata, Youmin Lee, Ivy Zhuang
 * Teacher: Ms. Krasteva
 * Date: March 6, 2023
 * Purpose: To share some code between the AllDataScreens
 */
package Pokemon_Rating;

/**
 * Abstract class for data screen.
 */
abstract class AllDataScreen extends Screen{
    public static int DISPLAY_TYPE_ALL = 1;
    public static int DISPLAY_TYPE_BEST = 2;
    protected int displayType;

    public void setDisplayType(int displayType) {
        this.displayType = displayType;
    }
}
