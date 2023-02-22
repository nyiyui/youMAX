package Youniverse;

public class YouPerson extends Younimal {
    private String language;
    private char mbti[];

    public YouPerson(String name, int height, boolean immortal, double speed, String language) {
        super(name, height, immortal, speed);
        this.language = language;
        people.add(this);
        mbti = new char[4];
    }

    /**
     * Youpeople are inevitably social creatures, so they have to talk to each other.
     * After talking to each other, a YouPerson will feel an emotion
     *
     * @param speech The words someone is saying to this YouPerson
     * @param intent the intent behind the words that the person is saying
     * @param person the YouPerson speaking to this YouPerson
     */
    public void communicate(String speech, String intent, YouPerson person) {
        System.out.println("Attempting to initialize dialogue between " + getName() + " and " + person.getName() + "...");
        if (!person.getLanguage().equals(this.language)) {
            System.out.println(getName() + " and " + person.getName() + " can't talk to each other! :(");
            return;
        }
        System.out.println(person.getName() + " says, \"" + speech + "\" with " + intent + " intent.");
        if (intent.equals("evil")) {
            this.getYouHeart().setEmotion("Offended");
        } else {
            this.getYouHeart().setEmotion("Friendly");
        }
        System.out.println("Because of this, " + getName() + " is feeling " + getYouHeart().getEmotion() + " :>");
    }

    /**
     * Youpeople have many diverse personalities! Everyone wants to know what their personality type is so they take the MBTI test!
     * based on the numbers in the result of a personality test, the youperson is given a letter for a specific category.
     *
     * @param ie introversion vs. extroversion, >=50 is E, <50 is I
     * @param sn sensing vs. intuition, >= 50 is N, <50 is S
     * @param tf thinking vs. feeling, >= 50 is F, <50 is T
     * @param jp judging vs. perceivng, >= 50 is P, <50 is J
     */
    public void takePersonalityTest(int ie, int sn, int tf, int jp) {
        if (ie > 100 || ie < 0 || sn > 100 || sn < 0 || tf > 100 || tf < 0 || jp < 100 || jp < 0) {
            System.out.println(getName() + " didn't take a valid personality test!");
            return;
        }
        if (ie >= 50) {
            mbti[0] = 'E';
        } else {
            mbti[0] = 'I';
        }
        if (sn >= 50) {
            mbti[1] = 'N';
        } else {
            mbti[1] = 'S';
        }
        if (tf >= 50) {
            mbti[2] = 'F';
        } else {
            mbti[2] = 'T';
        }
        if (jp >= 50) {
            mbti[3] = 'P';
        } else {
            mbti[3] = 'J';
        }
        System.out.println(getName() + "'s new MBTI is " + mbti[0] + mbti[1] + mbti[2] + mbti[3] + "! :D");
    }

    /**
     * Youpeople love bonding with younimals, so they try to feed younimals.
     * However, sometimes the Younimal isn't feeling hungry so they sometimes act very meanly.
     * Although, when the Younimal is hungry, they gladly eat your food and exit with a feeling of happiness.
     *
     * @param target the target younimal Youperson is trying to feed
     */
    public void attemptFeeding(Younimal target) {
        if (target.isHungry())
            sayf("I gave some food to %s!", target.getName());
        else
            sayf("I tried to give some food to %s, but they don't like me...", target.getName());
    }

    /**
     * accessor method for language
     *
     * @return the language YouPerson speaks
     */
    public String getLanguage() {
        return language;
    }

    /**
     * mutator method for language
     *
     * @param language the new language that YouPerson speaks (because Youpeople can only speak one language at a time)
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * accessor method for mbti
     *
     * @return the mbti of YouPerson
     */
    public char[] getMbti() {
        return mbti;
    }

    /**
     * mutator method for mbti
     *
     * @param mbti YouPerson's new MBTI
     */
    public void setMbti(char[] mbti) {
        this.mbti = mbti;
    }
}
