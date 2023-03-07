/**
 * Names: Ivy Zhuang, Ken Shibata, Youmin Lee
 * Teacher: Ms. Krasteva
 * Date: March 7, 2023
 * Purpose: Sentence class. Creates sentences with randomly generated words.
 */
package CrazySentences;

import java.util.ArrayList;

public class Sentence {
    /**
     * list of nouns
     */
    private static ArrayList<String> nouns;
    /**
     * list of articles
     */
    private static ArrayList<String> articles;
    /**
     * list of adjectives
     */
    private static ArrayList<String> adjectives;
    /**
     * list of verbs
     */
    private static ArrayList<String> verbs;
    /**
     * list of preposition
     */
    private static ArrayList<String> preposition;
    /**
     * list of punctuation
     */
    private static ArrayList<String> punctuation;

    private String sentence;

    public Sentence(){
        loadLists();
        sentence = generateSentence();
    }

    public String getSentence() {
        return sentence;
    }

    private String generateSentence(){
        String result = generateSubject();
        result = result.substring(0, 1).toUpperCase() + result.substring(1);
        int idxV = (int) (Math.random() * verbs.size()), idxP = (int) (Math.random() * preposition.size());
        result += " " + verbs.get(idxV) + " " + preposition.get(idxP) + " " + generateSubject();
        result += punctuation.get((int) (Math.random() * punctuation.size()));
        return result;
    }
    private static String generateSubject(){
        String result = "";
        String vowels = "aeiou"; // for checking first letter of nouns or adjectives
        int idxR = (int) (Math.random() * articles.size()); // randomly generated index within preposition list
        result += articles.get(idxR);
        int idxA = (int) (Math.random() * adjectives.size()); // randomly generated index within adjective list
        if(articles.get(idxR).equals("a") && vowels.contains(adjectives.get(idxA).charAt(0) + "")){
            result += "n " + adjectives.get(idxA);
        }
        else{
            result += " " + adjectives.get(idxA);
        }
        int idxN = (int) (Math.random() * nouns.size()); // randomly generated index within noun list
        result += " " + nouns.get(idxN);
        return result;
    }
    /**
     * manually adds every word into their respective lists
     */
    private static void loadLists(){
        articles = new ArrayList<>();
        nouns = new ArrayList<>();
        adjectives = new ArrayList<>();
        verbs = new ArrayList<>();
        preposition = new ArrayList<>();
        punctuation = new ArrayList<>();

        articles.add("the");
        articles.add("a");

        nouns.add("YouGOD");
        nouns.add("tree");
        nouns.add("computer");
        nouns.add("instrument");
        nouns.add("girl");
        nouns.add("boy");
        nouns.add("frog");
        nouns.add("rabbit");
        nouns.add("sunflower");
        nouns.add("octopus");
        nouns.add("universe");
        nouns.add("squid");
        nouns.add("apple");

        adjectives.add("short");
        adjectives.add("dazzling");
        adjectives.add("deadly");
        adjectives.add("happy");
        adjectives.add("sad");
        adjectives.add("amazing");
        adjectives.add("omniscient");
        adjectives.add("angry");
        adjectives.add("furious");
        adjectives.add("spectacular");
        adjectives.add("fancy");

        verbs.add("languishes");
        verbs.add("walks");
        verbs.add("sits");
        verbs.add("kills");
        verbs.add("watches");
        verbs.add("minimizes");
        verbs.add("poops");
        verbs.add("contemplates");
        verbs.add("locomotes");
        verbs.add("vaults");
        verbs.add("withers");
        verbs.add("prevails");

        preposition.add("at");
        preposition.add("on");
        preposition.add("in");
        preposition.add("from");
        preposition.add("for");
        preposition.add("around");
        preposition.add("with");
        preposition.add("over");

        punctuation.add(".");
        punctuation.add("!");
        punctuation.add("?");
    }
}
