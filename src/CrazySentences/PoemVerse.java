/**
 * Names: Ivy Zhuang, Ken Shibata, Youmin Lee
 * Teacher: Ms. Krasteva
 * Date: March 7, 2023
 * Purpose: Sentence class. Creates sentences with randomly generated words.
 * Contributions: the whole thing -> Ivy :D
 */
package CrazySentences;

import java.util.ArrayList;

public class PoemVerse {
    /**
     * list of nouns in -at
     */
    private static ArrayList<String> atNouns;
    /**
     * list of nouns in -et
     */
    private static ArrayList<String> etNouns;
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
     * first line of the verse
     */
    private String line1;
    /**
     * second line of the verse
     */
    private String line2;

    public PoemVerse() {
        loadLists();
        generateVerse();
    }

    /**
     * returns string representation as a 2-line poem verse
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return line1 + "\n" + line2;
    }

    private void generateVerse() {
        int choice = (int) (Math.random() * 2); // randomly chooses to use -et nouns or -at nouns
        if (choice == 0) {
            line1 = generateSubject(atNouns) + ",";
            line1 = capitalize(line1);
            line2 = getRandomVerb() + " " + getRandomPreposition() + " " + generateSubject(atNouns) + ".";
            line2 = capitalize(line2);
        } else {
            line1 = getRandomPreposition() + " " + generateSubject(etNouns) + ",";
            line1 = capitalize(line1);
            line2 = getRandomVerb() + " " + generateSubject(etNouns) + ".";
            line2 = capitalize(line2);
        }
    }

    /**
     * Generates a random subject with randomly chosen words
     * A subject consists of an article, an adjective, and a noun
     *
     * @param nouns list of nouns that is used to generate the subject
     * @return a rnadomly generated subject
     */
    private String generateSubject(ArrayList<String> nouns) {
        String result = "";
        String vowels = "aeiou"; // for checking first letter of nouns or adjectives
        String art = getRandomArticle();
        result += art;
        String adj = getRandomAdjective();
        if (art.equals("a") && vowels.contains(adj.charAt(0) + "")) {
            result += "n " + adj;
        } else {
            result += " " + adj;
        }
        result += " " + getRandomNoun(nouns);
        return result;
    }

    /**
     * randomly generates a random article from the articles arraylist
     *
     * @return a random article
     */
    private String getRandomArticle() {
        return articles.get((int) (Math.random() * articles.size()));
    }

    /**
     * randomly generates a random adjective from the adjectives arraylist
     *
     * @return a random adjective
     */
    private String getRandomAdjective() {
        return adjectives.get((int) (Math.random() * adjectives.size()));
    }

    /**
     * randomly generates a random noun from one of the noun arraylists
     *
     * @param nouns the list of nouns that the method randomly chooses from (either atNouns or etNouns)
     * @return a random noun
     */
    private String getRandomNoun(ArrayList<String> nouns) {
        return nouns.get((int) (Math.random() * nouns.size()));
    }

    /**
     * randomly generates a random preposition from the preposition arraylist
     *
     * @return a random preposition
     */
    private String getRandomPreposition() {
        return preposition.get((int) (Math.random() * preposition.size()));
    }

    /**
     * randomly generates a random verb from the verbs arraylist
     *
     * @return a random verb
     */
    private String getRandomVerb() {
        return verbs.get((int) (Math.random() * verbs.size()));
    }

    /**
     * capitalizes the first letter of the given string
     *
     * @param s String to have its first letter capitalized
     * @return the string with its first letter capitalized
     */
    private String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    /**
     * manually adds every word into their respective lists
     */
    private static void loadLists() {
        articles = new ArrayList<>();
        atNouns = new ArrayList<>();
        etNouns = new ArrayList<>();
        adjectives = new ArrayList<>();
        verbs = new ArrayList<>();
        preposition = new ArrayList<>();

        articles.add("the");
        articles.add("a");

        atNouns.add("cat");
        atNouns.add("rat");
        atNouns.add("bat");
        atNouns.add("hat");
        atNouns.add("mat");
        atNouns.add("gnat");
        atNouns.add("autocrat");
        atNouns.add("democrat");
        atNouns.add("brat");
        atNouns.add("diplomat");
        atNouns.add("thermostat");
        atNouns.add("copycat");
        atNouns.add("acrobat");
        atNouns.add("meerkat");
        atNouns.add("muskrat");

        etNouns.add("racket");
        etNouns.add("basket");
        etNouns.add("supermarket");
        etNouns.add("magnet");
        etNouns.add("quintuplet");
        etNouns.add("clarinet");
        etNouns.add("alphabet");
        etNouns.add("leaflet");
        etNouns.add("circlet");
        etNouns.add("bayonet");
        etNouns.add("wallet");
        etNouns.add("goblet");
        etNouns.add("amulet");
        etNouns.add("islet");

        adjectives.add("bewitching");
        adjectives.add("ginormous");
        adjectives.add("dazzling");
        adjectives.add("deadly");
        adjectives.add("happy");
        adjectives.add("distressed");
        adjectives.add("amazing");
        adjectives.add("omniscient");
        adjectives.add("extraordinary");
        adjectives.add("furious");
        adjectives.add("spectacular");
        adjectives.add("fancy");
        adjectives.add("overjoyed");
        adjectives.add("icy");
        adjectives.add("delightful");
        adjectives.add("unparalleled");

        verbs.add("sings");
        verbs.add("dances");
        verbs.add("plays");
        verbs.add("transforms");
        verbs.add("reminisces");
        verbs.add("contemplates");
        verbs.add("ruminates");
        verbs.add("anticipate");
        verbs.add("withers");
        verbs.add("gallops");
        verbs.add("ambles");
        verbs.add("illuminates");
        verbs.add("transcends");
        verbs.add("reincarnates");
        verbs.add("veils");

        preposition.add("to");
        preposition.add("on");
        preposition.add("in");
        preposition.add("after");
        preposition.add("for");
        preposition.add("around");
        preposition.add("with");
        preposition.add("over");
    }
}
