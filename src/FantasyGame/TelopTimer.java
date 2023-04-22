package FantasyGame;

class TelopTimer extends Timer {
    private String message;

    public TelopTimer(int trigger, String message) {
        super(trigger);
        this.message = message;
    }

    @Override
    public void callback() {
        Telop.current().show('*', message);
    }
}