/**
 * Names: Ken Shibata & Ivy Zhuang
 * Teacher: Ms. Krasteva
 * Date: Feb 21, 2023
 * Purpose:
 * Improved Storyline: youElf is on a journey to defeat YouEvil.
 * YouElf fights younemies (interface mb?) along the way, such as Dragons and younicorns.
 * YouElf travels through the Forest (new location) that is filled with younimals that help YouElf by giving her youGrass.
 * By you-sing youGrass, YouElf has more chances to use her special move, the you-shouldtouchgrass.
 * You-shouldtouchgrass allows YouElf to gain more attack and hp to defeat the younemies.
 * Other actions:
 * - fight younemies --> auto-attack system until either youElf or the younemy dies
 * - die --> when youElf's hp reaches 0, game over :pensive:
 * - make friends with younimals --> receive one youGrass (+10 atk, +10% hp)
 */
package FantasyGame;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
