/**
 * Names: Ken Shibata, Yoummin Lee, Ivy Zhuang
 * Teacher: Ms. Krasteva
 * Date: March 5, 2023
 * Purpose: driver class for part 2 of the assignment
 */
package Pokemon_Rating;

public class MainPartTwo {
    public static void main(String[] args) {
        ScreenManager m = new ScreenManager();
        m.push(new MenuScreen(new AllDataTwoDeeScreen()));
        m.run();
    }
}
