package Youniverse;

public class YouPerson extends Younimal {
    private String language;
    //TODO: more attributes? (like String MBTI or smth), methods, javadoc comments

    public YouPerson(String name, int height, boolean immortal, double speed, String language) {
        super(name, height, immortal, speed);
        this.language = language;
        people.add(this);
    }
    public void attemptFeeding(Younimal target){
        if (target.isHungry())
          sayf("I gave some food to %s!", target.getName());
        else
            sayf("I tried to give some food to %s, but they don't like me...",target.getName());
    }
}
