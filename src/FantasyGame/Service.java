package FantasyGame;

public interface Service {
  /**
   * System applies changes to be made over the delta time specified.
   * @param dtms change in milliseconds to apply changes for
   */
  public void update(int dtms) throws ServiceRemoveException;
}
