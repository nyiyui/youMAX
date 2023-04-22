package FantasyGame;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

class Forest implements Location {
  private AirQualityService aqs;
  @Override
  public void enter(Elf elf) {
    aqs = new AirQualityService(elf, 2, 5);
    Engine.current().addSystem(aqs);
  }

  @Override
  public void exit(Elf elf) {
    aqs.stop = true;
  }

  public String getName() { return "Forest of Magic"; };
  public String getBlurb() {
    return "The Forest of Magic is the focal point of all things hostile and evil, located somewhat-near the Human Village (since the position changes constantly, it is not possible to accurately measure the distance.)";
  }

  @Override
  public ArrayList<Direction> getDirections() {
    return null;
  }

  ;
}

/**
 * Reduces elf health (omg that rhymes) at a constant rate with jitter.
 */
class AirQualityService implements Service {
  private Elf elf;
  private int hpPerSecond;
  private int jitter;
  boolean stop;

  AirQualityService(Elf elf, int hpPerSecond, int jitter) {
    this.elf = elf;
    this.hpPerSecond = hpPerSecond;
    this.jitter = jitter;
  }

  public void update(int dtms) throws ServiceRemoveException {
    int deltaHp = (int) ((double) hpPerSecond * dtms / 1000.0);
    deltaHp += ThreadLocalRandom.current().nextInt(-jitter, jitter);
    elf.setHealth(elf.getHealth() + deltaHp);
    if (stop) throw new ServiceRemoveException();
  }
}
