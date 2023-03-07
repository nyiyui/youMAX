package Pokemon_Rating;

public class PremiseScreen extends Screen{
    @Override
    void tick(ScreenManager manager) {
        System.out.println("Premise:");
        System.out.println("  This program is called PokemonRatings and as the name suggests, it rates different pokemon based on their base stats (attack, defense, HP, and aesthetic). The chosen pokemon are Snorlax, Ditto, Mewtwo, Giratina, Pikachu, Eevee, and Binacle. The way each pokemon is overall rated is by taking the sum of all the points they have gotten from each base stat and outputting it as their final rating.");
        System.out.println("Bonus Story:");
        System.out.println("  Once upon a time, YouGOD appeared out of nowhere. YouGod felt a little lonely and created two distinct forces of the world, YouMax and YouMin, to ease her melancholic YouHeart. Out of the two forces, YouMax made the Younimals and YouMin created the Youlants. In particular, the Younimals consisted of the YouPeople, YouCat and the YouKai. Upon the YouEarth, YouGod’s YouHeart felt comforted by the new YouCreations surrounding her. To celebrate this occasion, YouGod invented the YouKaiWatch. This watch could call upon YouKai to aid the YouPeople. Thus, interdependency was set in place by YouGod. Feeling content with herself, YouGod transcended into another Youniverse. The End :>");
        manager.pop();
    }
}
