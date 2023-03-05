/**
 * Names: Ken Shibata, Yoummin Lee, Ivy Zhuang
 * Teacher: Ms. Krasteva
 * Date: March 4, 2023
 * Purpose: driver class for part 1 of the assignment
 */
package Pokemon_Rating;

public class MainPartOne {
    public static void main(String[] args) {
        ScreenManager m = new ScreenManager();
        m.push(new MenuScreen(new AllDataParallelScreen()));
        m.run();
    }
}
