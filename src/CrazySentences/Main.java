/**
 * Names: Ivy Zhuang, Ken Shibata, Youmin Lee
 * Teacher: Ms. Krasteva
 * Date: March 7, 2023
 * Purpose: driver class, shows user 5 randomly generated sentences as well as
 * Contributions: the whole thing -> Ivy :D
 */
package CrazySentences;

public class Main {
    public static void main(String[] args) {
        System.out.println("Here are your 5 CRAZY SENTENCES!!!");
        for (int i=0;i<5;i++){
            Sentence sentence = new Sentence();
            System.out.println(sentence.getSentence());
        }
    }
}
