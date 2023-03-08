/**
 * Names: Ivy Zhuang, Ken Shibata, Youmin Lee
 * Teacher: Ms. Krasteva
 * Date: March 7, 2023
 * Purpose: driver class, gives 5 randomly generated sentences that seem to make no sense but have a clear structure to them :D
 * Contributions: Ivy created the driver class and original code, Youmin added the comments and the introduction line.
 */
package CrazySentences;

public class SentencesMain {
    /**
     * Driver class for the Sentence class
     * Introduces the program and says what it is about and gives a preparatory message for the output.
     * The for loop loops 5 times to generate 5 random sentences and outputs them for the user to see.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the Sentences program! This program will randomly generate 5 crazy sentences for your enjoyment!");
        System.out.println("Here are your 5 CRAZY SENTENCES!!!");
        for (int i=0;i<5;i++){
            Sentence sentence = new Sentence();
            System.out.println(sentence.getSentence());
        }
    }
}
