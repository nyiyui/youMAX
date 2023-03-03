package Pokemon_Rating;

import java.io.FileNotFoundException;

abstract class Screen {
    /**
     * Performs any necessary user interaction. It is intended to call ScreenManager to either call itself or other screens.
     */
    abstract void tick(ScreenManager manager) ;
}
