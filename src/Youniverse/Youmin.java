/**
 * Names: Ivy Zhuang and friends
 * Teacher: Ms. Krasteva
 * Date: Feb 20, 2023
 * Purpose: Youmin Class, the originator of all Youlants. Legends have it she looks like a yousunflower :eyes:
 */
package Youniverse;

public class Youmin extends YouGod {
    /**
     * sunlight = percentage of sunlight Youmin is absorbing
     * biome = the environmental conditions Youmin is living
     */
    private int sunlight;
    private String biome;

    /**
     * 1st constructor for Youmin, Takes no parameters and sets all attributes to default values.
     */
    public Youmin() {
        this.setName("YouMin");
        this.setHeight(100);
        this.setImmortal(true);
        this.sunlight = 60;
        this.biome = "Youpical Rainforest";
    }

    /**
     * 2nd constructor for Youmin, used when one doesn't want to use the default values
     *
     * @param name     name of Youmin
     * @param height   how tall Youmin is in centimetres
     * @param immortal whether or not Youmin is immortal
     */
    public Youmin(String name, int height, boolean immortal, int sunlight, String biome) {
        super(name, height, immortal);
        this.sunlight = sunlight;
        this.biome = biome;
    }

    /**
     * Youmin uses the sunlight to grow :relieved:
     *
     * @param growth number of centimetres YouMin could grow if there was 100% sunlight
     */
    @Override
    public void grow(int growth) {
        int realGrowth = getHeight() + (int) (growth * sunlight / 100.0);
        this.setHeight(realGrowth);
        this.getYouHeart().setHp(realGrowth / 2.0);
        System.out.println(getName()+" has grown "+realGrowth+" cm!");
        System.out.println("Current HP: "+this.getYouHeart().getHp());
    }

    /**
     * if oneself is immortal, then one will simply continue being a menace >:)
     * else, youmin becomes a part of the soil once more. :(((
     */
    @Override
    public void die() {
        if(isImmortal()){
            System.out.println(getName()+" is not affected by death >:)");
        }
        else {
            System.out.println(getName()+" will become a part of the soil. :(");
        }
    }

    /**
     * if Youmin changes where she takes root, her biome, sunlight, and emotions all change. moving away is a big deal yk
     * @param destination Youmin's new biome/home.
     */
    public void uproot(String destination){
        biome = destination;
        this.getYouHeart().setEmotion("Nostalgic"); //bc shes moving far away from home :pensive:
        if(destination.equals("YouDesert") || destination.equals("Yougrassland")){
            sunlight = 100;
        }
        else if(destination.equals("Youndra")){
            sunlight = 40;
        }
        else{
            sunlight = 60;
        }
        System.out.println(getName()+" now lives in the "+biome+", where she gets "+sunlight+"% of sunlight.");
    }

    /**
     * even if Youmin can't walk like Youmax, she too can invoke her powers ;D
     */
    @Override
    public void beginCreation() {
        if(isImmortal()){
            this.getYouHeart().setEmotion("Empowered");
            System.out.println(getName()+" is going to create new companions, the Youlants!");
        }
        else{
            System.out.println("??? "+getName()+" isn't that powerful? :>");
        }
        Youkai reimu = new Youkai("霊夢 (Reimu)", 160, 300);
        YoukaiWatch reimuWatch = new YoukaiWatch(reimu);
        reimuWatch.activate();
    }

    /**
     * accessor method for Youmin's sunlight
     * @return how much sunlight Youmin is absorbing
     */
    public int getSunlight() {
        return sunlight;
    }

    /**
     * mutator method for the amount of sunlight Youmin receives
     * @param sunlight the new amount of sunlight Youmin is going to get
     */
    public void setSunlight(int sunlight) {
        this.sunlight = sunlight;
    }

    /**
     * accessor method for Youmin's biome
     * @return the biome that Youmin currently lives in
     */
    public String getBiome() {
        return biome;
    }

    /**
     * mutator method for Youmin's biome
     * @param biome Youmin's new biome.
     */
    public void setBiome(String biome) {
        this.biome = biome;
    }
}
