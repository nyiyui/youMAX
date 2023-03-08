/**
 * Names: Ivy Zhuang, Ken Shibata, Youmin Lee
 * Teacher: Ms. Krasteva
 * Date: March 7, 2023
 * Purpose: driver class, shows user 5 randomly generated sentences as well as
 * Contributions: the whole thing -> Ivy :D
 */
package CrazySentences;
import java.util.Scanner;

public class PoemVerseMain {
    // TODO: make main menu for both crazy sentences and AI poem
    public static void main(String[] args) {
        System.out.println("How many verses would you like in your poem? :D");
        Scanner s = new Scanner(System.in);
        int verses = s.nextInt();
        for (int i=0;i<verses;i++){
            PoemVerse poemVerse = new PoemVerse();
            System.out.println(poemVerse);
        }
    }
}
