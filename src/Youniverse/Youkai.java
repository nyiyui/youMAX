package Youniverse;


public class Youkai extends Younimal{
    Youkai() {
        super();
        youkais.add(this);
    }

    void helpThePeople() {
        for (YouPerson p : people) {
            help(p);
        }
    }

    void help(YouPerson p) {
        throw new RuntimeException("not implemented");
    }
}
