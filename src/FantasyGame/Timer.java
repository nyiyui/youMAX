package FantasyGame;


public abstract class Timer implements Service {
    private final int trigger;
    private int dtms;

    /**
     * @param trigger time from service start to trigger at
     */
    public Timer(int trigger) {
        this.trigger = trigger;
    }

    @Override
    public void update(int dtms) throws ServiceRemoveException {
        this.dtms += dtms;
        if (this.dtms >= trigger) {
            callback();
            throw new ServiceRemoveException();
        }
    }

    /**
     * Called when the timer is up.
     */
    public abstract void callback();
}
