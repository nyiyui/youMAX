/**
 * Names: Ken Shibata, Youmin Lee, Ivy Zhuang
 * Teacher: Ms. Krasteva
 * Date: March 6, 2023
 * Purpose: Waits for the user to press enter.
 */
package Pokemon_Rating;

import java.util.Scanner;
/**
 * Waits for the user to press enter.
 */
public class BufferScreen extends Screen {
    @Override
    void tick(ScreenManager manager) {
        System.out.print("Press enter to continue:");
        new Scanner(System.in).nextLine();
        manager.pop();
    }
}
