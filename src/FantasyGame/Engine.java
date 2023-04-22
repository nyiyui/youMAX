package FantasyGame;

import java.util.ArrayList;

public class Engine {
    private ArrayList<Service> services;
    private static Engine singleton;
    private long startNano;
    private boolean active=true;

    static Engine current() {
        if (singleton == null) singleton = new Engine();
        return singleton;
    }

    Engine() {
        this.services = new ArrayList<>();
        startNano = System.nanoTime();
    }

    public long getSinceStartNano() {
        return System.nanoTime() - startNano;
    }

    /**
     * Adds a system to run.
     * Remove systems by throwing SystemRemoveException from System.update.
     */
    void addSystem(Service s) {
        services.add(s);
    }


    public void loop() {
        ArrayList<Long> lastTimes = new ArrayList<>(services.size());
        for (int i = 0; i < services.size(); i++)
            lastTimes.add(0l);
        while (active) {
            for (int i = services.size() - 1; i >= 0; i--) {
                long lastTime = lastTimes.get(i);
                long currentTime = System.nanoTime();
                int dtms = (lastTime == 0) ? 0 : (int) ((currentTime - lastTime) / 1000000);
                try {
                    services.get(i).update(dtms);
                } catch (ServiceRemoveException e) {
                    services.remove(i);
                }
                try {
                    Thread.sleep(10); // ew
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            for (int i = services.size() - 1; i >= 0; i--) {
                lastTimes.set(i, System.nanoTime());
            }
            assert services.size() == lastTimes.size();
        }
    }

    /**
     * Stop the engine (game over).
     */
    public void stop() {
        active=false;
    }
}
