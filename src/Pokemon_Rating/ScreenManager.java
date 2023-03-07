/**
 * Names: Ken Shibata, Youmin Lee, Ivy Zhuang
 * Teacher: Ms. Krasteva
 * Date: March 5, 2023
 * Purpose: Manages the screens the user can see
 */
package Pokemon_Rating;

import java.util.ArrayList;

class ScreenManager {
    
    ArrayList<Screen> screens;
    // using ArrayList instead of Stack as we don't know if we're allowed to use Stack

    /**
     * initializes empty arraylist
     */
    ScreenManager() {
        screens = new ArrayList<>();
    }

    /**
     * adds a screen into the screen manager
     * @param pushee the screen being pushed in
     */
    void push(Screen pushee) {
        screens.add(pushee);
    }

    /**
     * pops out last used screen
     * @return the screen that was popped out
     */
    Screen pop() {
        Screen popee = screens.get(screens.size()-1);
        screens.remove(screens.size() - 1);
        return popee;
    }

    /**
     * Tick the screens until none are remaining.
     */
    void run() {
        while (screens.size() > 0) {
            Screen current = screens.get(screens.size()-1);
            System.out.println("current: "+current);
            System.out.println(screens);
            current.tick(this);
        }
    }

    /**
     * Exits the program by completely emptying the screen manager
     */
    void exit(){
        while (screens.size() > 0){
            pop();
        }
    }
}
