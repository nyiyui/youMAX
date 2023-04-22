package FantasyGame;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Reduces elf health (omg that rhymes) at a constant rate with jitter.
 */
class HealthReductionService implements Service {
    private Character character;
    private double hpPerSecond;
    private int jitter;
    private int actualDtms;
    boolean stop;

    HealthReductionService(Character character, double hpPerSecond, int jitter) {
        this.character = character;
        this.hpPerSecond = hpPerSecond;
        this.jitter = jitter;
        this.actualDtms=0;
    }

    public void update(int dtms) throws ServiceRemoveException {
        if (hpPerSecond<1&&actualDtms<1000*(1/hpPerSecond)) {
            actualDtms+=dtms;
            return;
        }
        int deltaHp = (int) (hpPerSecond * actualDtms / 1000.0);
        if (jitter > 0) {
            deltaHp += ThreadLocalRandom.current().nextInt(-jitter, jitter);
        }
        character.setHealth(character.getHealth() + deltaHp);
        if (stop) throw new ServiceRemoveException();
        actualDtms=0;
    }
}
