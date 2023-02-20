/**
 * Names: Ivy Zhuang and friends
 * Teacher: Ms. Krasteva
 * Date: Feb 20, 2023
 * Purpose: Youmin Class, the originator of all Youlants. Legends have it she looks like a yousunflower :eyes:
 */
package Youniverse;

public class Youmin extends YouGod {
    //TODO: methods, getters, setters, javadoc comments
    private int sunlight;
    private String location;

    /**
     * 1st constructors. Takes no parameters and sets all attributes to default values.
     */
    public Youmin() {
        this.setName("YouMin");
        this.setHeight(100);
        this.setImmortal(true);
        this.sunlight = Integer.MAX_VALUE;
        this.location = "YouEarth";
    }

    public int getSunlight() {
        return sunlight;
    }

    public void setSunlight(int sunlight) {
        this.sunlight = sunlight;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
