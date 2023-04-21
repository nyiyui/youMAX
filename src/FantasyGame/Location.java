package FantasyGame;

import java.util.ArrayList;

public interface Location {
  /**
   * Elf enters the location.
   * {@link exit} must be called by the caller the same number of time as this method.
   */
  void enter(Elf elf);
  void exit(Elf elf);
  /**
   * Return name shown to user.
   */
  String getName();
  /**
   * Return blurb (description) shown to user.
   */
  String getBlurb();
  /**
   * Return available directions in this loaction.
   */
  ArrayList<Direction> getDirections();
}
