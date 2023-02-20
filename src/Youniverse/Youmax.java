/**
 * Names: Ivy Zhuang, Ken Shibata, Youmin Lee
 * Teacher: Ms. Krasteva
 * Date: Feb 20, 2023
 * Purpose: Youmax class, one of the two energies created by YouMax, originator of the Younimals.
 */
package Youniverse;

public class Youmax extends YouGod {
    /**
     * speed = how fast Youmax can walk in metres per second
     * location = the name of the city/country/place Youmax is currently at
     */
    private double speed;
    private String location;

    public Youmax(double speed) {
        this.setName("YouMax");
        this.setHeight(100);
        this.setImmortal(true);
        this.speed = speed;
        this.location = "YouHome";
    }

    /**
     * 2nd constructor for YouMax, used when one doesn't want to use the default values
     *
     * @param name     name of YouMax
     * @param height   how tall YouMax is in centimetres
     * @param immortal whether or not YouMax is immortal
     * @param speed the speed of YouMax (YouMax can move, unlike YouMin lol)
     */
    public Youmax(String name, int height, boolean immortal, double speed) {
        super(name, height, immortal);
        this.speed = speed;

    }

    /**
     * all livings things can grow, so obviously YouGod should try to grow, too.
     * YouMax grows just like YouGod, but also gets faster
     * @param growth number of centimetres YouGod is growing taller by
     */
    @Override
    public void grow(int growth) {
        super.grow(growth);
        speed += growth / 3.0;
        System.out.println(getName()+" has also gotten faster, their speed is "+speed+" m/s now. :D");
    }

    /**
     * Youmax travels to a new place, calculates amount of time it takes and tells the user.
     * @param distance
     * @param destination
     */
    public void travel(double distance, String destination){
        double time = distance / speed;
        location = destination;
        System.out.println("It took "+getName()+" "+time+" seconds to get to "+destination+"!");
    }
    /**
     * YouMax follows in YouGod's footsteps and creates more living things to populate the YouEarth.
     * However, unlike YouGod, YouMax doesn't need to feel lonely to take action. :)
     */
    @Override
    public void beginCreation() {
        if(isImmortal()){
            this.getYouHeart().setEmotion("Empowered");
            System.out.println(getName()+" is going to create new companions, the Younimals!");
        }
        else{
            System.out.println("??? "+getName()+" isn't that powerful? :>");
        }
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
