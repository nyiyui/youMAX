package FantasyGame;
/**
 * Names: Ken Shibata & Ivy Zhuang
 * Teacher: Ms. Krasteva
 * Date: Feb 21, 2023
 * Purpose: simulation of a fantasy game, modified and better than before!
 * Improved Storyline: printed by program.
 * Contributions: Ken - basically all the code, Ivy - game intro and lore, all those damn UMLs.
 * Note: Telop means text on top of graphics (e.g. captions).
 */
public abstract class Location {
  /**
   * Elf enters the location.
   * exit must be called by the caller the same number of time as this method.
   */
  void enter(Character character) {
    System.out.printf("%s> I'm entering %s. According to a conveniently placed sign: %s", character.getName(),this.getName(),this.getBlurb());
  }

  void exit(Character character) {
    System.out.printf("%s> I'm exiting %s. Bye-nya!",character.getName(),this.getName());
  }

  /**
   * Return name shown to user.
   */
  abstract String getName();
  /**
   * Return blurb (description) shown to user.
   */
  abstract  String getBlurb();
}
