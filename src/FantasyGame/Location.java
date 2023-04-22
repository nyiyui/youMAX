package FantasyGame;

import java.util.ArrayList;

public interface Location {
  /**
   * Elf enters the location.
   * {@link Location}.exit must be called by the caller the same number of time as this method.
   */
  void enter(Character character);
  void exit(Character character);
  /**
   * Return name shown to user.
   */
  String getName();
  /**
   * Return blurb (description) shown to user.
   */
  String getBlurb();

  /**
   * Return message shown via ? command
   * @return If not null, message shown via ? command
   */
  String getMessage();
  /**
   * Return available directions in this loaction.
   */
  ArrayList<Direction> getDirections();

  void drawMap(char framebuffer[], int consoleRows, int consoleCols);
  void move(int directionId);
}
