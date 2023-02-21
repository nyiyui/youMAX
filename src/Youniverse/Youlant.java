/**
 * Names: Ivy Zhuang, Ken Shibata, Youmin Lee
 * Teacher: Ms. Krasteva
 * Date: Feb 21, 2023
 * Purpose: Youlant class. Youlants provide sustenance for all mortal beings in the Youniverse
 */
package Youniverse;

public class Youlant extends Youmin {
    /**
     * youflowers = number of youflowers Youlant has
     * youleaves = number of youleaves Youlant has
     * nutrients = nutritional value of Youlant
     */
    private int youflowers;
    private int youleaves;
    private int nutrients;

    /**
     * constructor for Youlant, uses Youmin superconstructor
     * initially has no youflowers and nutrients is based on number of youleaves
     *
     * @param name     name of Youlant
     * @param height   how tall Youlant is in centimetres
     * @param sunlight how much sunlight Youlant is absorbing
     * @param biome what environment Youlant lives in
     */
    public Youlant(String name, int height, int sunlight, String biome, int youleaves) {
        super(name, height, false, sunlight, biome); //youlants aren't immortal unfortunately :(
        this.youflowers = 0;
        this.youleaves = youleaves;
        this.nutrients = youleaves * 4;
    }
    public void bloom(){
        if(youflowers == 0 || getSunlight() < 50){
            System.out.println(getName()+" can't bloom any youflowers right now :(");
            return;
        }
        getYouHeart().setEmotion("Elated");
        getYouHeart().setHp(getYouHeart().getHp() + youflowers * 10);
        System.out.println(getName()+" has bloomed in the spring air with a feeling of elatedness :D");
        System.out.println(getName()+" is feeling healthier, look their HP is "+getYouHeart().getHp()+"!");
    }
    /**
     * Youlants uses the sunlight to grow :relieved:
     * youlants also can grow youflowers. >:D youlant also grows more leaves and gets more nutrients
     *
     * @param growth number of centimetres YouMin could grow if there was 100% sunlight
     */
    @Override
    public void grow(int growth) {
        super.grow(growth);
        youleaves += growth / 4;
        nutrients += growth;
        if(getHeight() > 100){
            youflowers++;
            System.out.println("Is that a little youflower that "+getName()+" has grown? So cute!");
            System.out.println("Now "+getName()+" has "+youflowers+" youflowers");
            return;
        }
        System.out.println("Unfortunately, "+getName()+" hasn't grown enough to grow any youflowers. :(");
    }

    /**
     * accessor method for youflowers
     * @return number of youflowers Youlant has
     */
    public int getYouflowers() {
        return youflowers;
    }

    /**
     * mutator method for youflowers
     * @param youflowers new number of youflowers Youlant has
     */
    public void setYouflowers(int youflowers) {
        this.youflowers = youflowers;
    }

    /**
     * accessor method for youleaves
     * @return number of youleaves Youlant has
     */
    public int getYouleaves() {
        return youleaves;
    }

    /**
     * mutator method for youleaves
     * @param youleaves new number of youleaves
     */
    public void setYouleaves(int youleaves) {
        this.youleaves = youleaves;
    }

    /**
     * accessor method for nutrients
     * @return Youlant's nutritional value
     */
    public int getNutrients() {
        return nutrients;
    }

    /**
     * mutator method for nutrients
     * @param nutrients new nutritional value Youlant has
     */
    public void setNutrients(int nutrients) {
        this.nutrients = nutrients;
    }
}
