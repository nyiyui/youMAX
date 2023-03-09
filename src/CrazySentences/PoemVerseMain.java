/**
 * Names: Ivy Zhuang, Ken Shibata, Youmin Lee
 * Teacher: Ms. Krasteva
 * Date: March 7, 2023
 * Purpose: driver class, allows the user to pick the amount of verses they would like in their poem and display it.
 * Contributions: Ivy created the driver class and PoemVerse Class, Youmin added the user input scanner
 * and changed it so that the number of verses in the poem is to the user's choice and the welcome line. Also added in the comments.
 */
package CrazySentences;
import java.util.Scanner;

public class PoemVerseMain {
    /**
     * Driver class for the PoemVerse class
     * Introduces the program and then asks how many verses they want in their random poem.
     * Then we take their input and put it in a loop to generate the amount of verses that they want in their poem.
     * The output is their randomly generated poem that has the amount of verses that they wish for!
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the PoemVerse program! This program generates a random AI-generated poem with as many verses as you choose ;)");
        System.out.println("How many verses would you like in your poem?");
        Scanner s = new Scanner(System.in);
        int verses = s.nextInt();
        for (int i=0;i<verses;i++){
            PoemVerse poemVerse = new PoemVerse();
            System.out.println(poemVerse);
        }
    }
}
