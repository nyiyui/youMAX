package Youniverse;

public class YouPerson extends Younimal {
    private String language;

    public YouPerson(String name, int height, boolean immortal, double speed, String language) {
        super(name, height, immortal, speed);
        this.language = language;
    }
}
