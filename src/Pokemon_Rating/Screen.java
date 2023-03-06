/**
 * Names: Ken Shibata, Youmin Lee, Ivy Zhuang
 * Teacher: Ms. Krasteva
 * Date: March 6, 2023
 * Purpose: abstract class for UI screen (mainly for ScreenManager to render the screen)
 */
package Pokemon_Rating;

abstract class Screen {
    /**
     * Performs any necessary user interaction. It is intended to call ScreenManager to either call itself or other screens.
     */
    abstract void tick(ScreenManager manager);
}
