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
    Youmin() {
        this.setName("Youmin");
        this.setHeight(100);
        this.setImmortal(true);
        this.sunlight = 60;
        this.biome = "Youpical Rainforest";
    }



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

    public void makeYoulants() {
        // TODO: impl
    }
}
