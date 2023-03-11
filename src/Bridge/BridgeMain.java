/**
 * Names: Ivy Zhuang, Ken Shibata, Youmin Lee
 * Teacher: Ms. Krasteva
 * Date: March 7, 2023
 * Purpose: driver class, runs the Bridge class (starts a round of the card game, Bridge)
 * Contributions: Ivy created the main method and the Bridge class.
 * Youmin added the comments, created the driver class and added in the user input scanner
 */
package Bridge;
import CrazySentences.PoemVerse;

import java.util.Scanner;
import java.util.ArrayList;

public class BridgeMain {
    public static void main(String[] args) {
        System.out.println("Welcome to the card game Bridge. Starting one round of Bridge!");
        //System.out.println("Please enter your players' names: ");
        Scanner n = new Scanner(System.in);
        String[] names = new String[4];
        System.out.println("Please enter four player names: ");
        for(int i=0; i<4; i++)
        {
        //reading array elements from the user
            names[i]=n.nextLine();
        }
        System.out.println(names[1]);
        Bridge round = new Bridge(names);
        round.simulateRound();

    }
}
