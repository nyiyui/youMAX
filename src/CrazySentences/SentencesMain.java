package CrazySentences;

public class SentencesMain {
    public static void main(String[] args) {
        System.out.println("Here are your 5 CRAZY SENTENCES!!!");
        for (int i=0;i<5;i++){
            Sentence sentence = new Sentence();
            System.out.println(sentence.getSentence());
        }
    }
}
