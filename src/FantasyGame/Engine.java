package FantasyGame;

import java.util.ArrayList;

public class Engine {
  private ArrayList<Service> services;
  private static Engine singleton;

  static Engine current() {
    if (singleton == null) singleton = new Engine();
    return singleton;
  }

  Engine() {
    this.services = new ArrayList<>();
  }

  /**
   * Adds a system to run.
   * Remove systems by throwing SystemRemoveException from System.update.
   */
  void addSystem(Service s) { services.add(s); }

  /**
   * Processes all systems for the delta time.
   */
  private void tick(int dtms) {
  }

  public void loop() {
    ArrayList<Long> lastTimes = new ArrayList<>(services.size());
    for (int i = 0; i < services.size(); i++)
      lastTimes.add(0l);
    ArrayList<Boolean> remove = new ArrayList<>(services.size());
    for (int i = 0; i < services.size(); i++)
      remove.add(false);
    while (true) {
      for (int i = services.size()-1; i >=0; i --) {
        long lastTime = lastTimes.get(i);
        long currentTime = System.nanoTime();
        int dtms = (lastTime == 0) ? 0 : (int) ((currentTime - lastTime) / 1000000);
        try {
          services.get(i).update(dtms);
        } catch (ServiceRemoveException e) {
          remove.set(i, true);
        }
        try {
          Thread.sleep(100); // ew
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
      for (int i = services.size()-1; i >=0; i --) {
        if (remove.get(i)) {
          services.remove(i);
          lastTimes.remove(i);
          remove.remove(i);
        }
        lastTimes.set(i, System.nanoTime());
      }
      assert services.size() == lastTimes.size() && lastTimes.size() == remove.size();
    }
  }
}
