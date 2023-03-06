/**
 * Names: Ken Shibata, Youmin Lee, Ivy Zhuang
 * Teacher: Ms. Krasteva
 * Date: March 6, 2023
 * Purpose: interface of screens that user interacts with
 */
package Pokemon_Rating;
//TODO: plz check over purpose comment again :skull:

abstract class Screen {
    /**
     * Performs any necessary user interaction. It is intended to call ScreenManager to either call itself or other screens.
     */
    abstract void tick(ScreenManager manager) ;
}
