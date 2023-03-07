/**
 * Names: Ivy Zhuang, Ken Shibata, Youmin Lee
 * Teacher: Ms. Krasteva
 * Date: March 7, 2023
 * Purpose: Sentence class. Creates sentences with randomly generated words.
 * Who did What: the whole thing -> Ivy :D
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
    /**
     * contains the sentence that was randomly generated
     */
    private String sentence;

    /**
     * Constructor for Sentence.
     * Loads the lists and then randomly generates a sentence.
     */
    public Sentence(){
        loadLists();
        sentence = generateSentence();
    }

    /**
     * accessor method for sentence
     * @return the sentence that was randomly generated
     */
    public String getSentence() {
        return sentence;
    }

    /**
     * Generates a sentence with random words
     * A sentence contains a subject, a verb, a preposition, and another subject
     * @return a randomly generated sentence
     */
    private String generateSentence(){
        String result = generateSubject();
        result = result.substring(0, 1).toUpperCase() + result.substring(1);
        int idxV = (int) (Math.random() * verbs.size()), idxP = (int) (Math.random() * preposition.size());
        result += " " + verbs.get(idxV) + " " + preposition.get(idxP) + " " + generateSubject();
        result += punctuation.get((int) (Math.random() * punctuation.size()));
        return result;
    }

    /**
     * Generates a subject with random words.
     * A subject contains an article, an adjective, and a noun
     * @return a randomly generated subject
     */
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
        nouns.add("pigeon");
        nouns.add("flounder");

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
        adjectives.add("overjoyed");
        adjectives.add("icy");
        adjectives.add("sunny");
        adjectives.add("shiny");

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
        verbs.add("ambles");
        verbs.add("discusses");
        verbs.add("travels");

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
