package FantasyGame;

public abstract class Location {
  /**
   * Elf enters the location.
   * exit must be called by the caller the same number of time as this method.
   */
  void enter(Character character) {
    System.out.printf("%s> I'm entering %s. According to my guidebook: %s", character.getName(),this.getBlurb());
  }

  void exit(Character character) {
    System.out.printf("%s> I'm exiting %s. Bye-nya!",character.getName());
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
