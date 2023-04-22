/**
 * Names: Ken Shibata & Ivy Zhuang
 * Teacher: Ms. Krasteva
 * Date: Feb 21, 2023
 * Purpose: simulation of a fantasy game, modified and better than before!
 * Improved Storyline: printed by program.
 * Contributions: Ken - basically all the code, Ivy - game intro and lore, all those damn UMLs.
 * Note: Telop means text on top of graphics (e.g. captions).
 */
package FantasyGame;

class Forest extends Location {
    public String getName() {
        return "Forest of Magic";
    }

    public String getBlurb() {
        return "The Forest of Magic is the focal point of all things hostile and evil, located somewhat-near the Human Village (since the position changes constantly, it is not possible to accurately measure the distance.)";
    }
}