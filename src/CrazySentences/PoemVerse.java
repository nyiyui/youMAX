/**
 * Names: Ivy Zhuang, Ken Shibata, Youmin Lee
 * Teacher: Ms. Krasteva
 * Date: March 7, 2023
 * Purpose: Sentence class. Creates sentences with randomly generated words.
 * Contributions: the whole thing -> Ivy :D (some refactoring by Ken)
 */
package CrazySentences;

import java.util.ArrayList;
import java.util.Arrays;

public class PoemVerse {
    /**
     * set to true when loadLists runs to prevent two assignments
     */
    private static boolean loadedWords = false;
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

    /**
     * Generates 2 lines of beautiful poems.
     */
    private void generateVerse() {
        int nounChoice = (int) (Math.random() * 2); // randomly chooses to use -et nouns or -at nouns
        ArrayList<String> nouns;
        if (nounChoice == 0) {
            nouns = atNouns;
        } else {
            nouns = etNouns;
        }
        line1=maybeGetRandomPreposition()+generateSubject(nouns)+",";
        line2=getRandomVerb()+" "+maybeGetRandomPreposition()+generateSubject(nouns)+".";
        line1 = capitalize(line1);
        line2 = capitalize(line2);
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
     * randomly generates a random preposition from the preposition arraylist
     *
     * @return maybe a random preposition with a blank space at the end
     */
    private String maybeGetRandomPreposition() {
        if ((int) (Math.random() * 2) == 0) {
            return getRandomPreposition()+" ";
        }
        return "";
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
        if (loadedWords) return;
        articles = new ArrayList<>(Arrays.asList("the", "a"));
        atNouns = new ArrayList<>(Arrays.asList(
                "cat",
                "rat",
                "bat",
                "hat",
                "mat",
                "gnat",
                "autocrat",
                "democrat",
                "brat",
                "diplomat",
                "thermostat",
                "copycat",
                "acrobat",
                "meerkat",
                "muskrat"
        ));
        etNouns = new ArrayList<>(Arrays.asList(
                "racket",
                "basket",
                "supermarket",
                "magnet",
                "quintuplet",
                "clarinet",
                "alphabet",
                "leaflet",
                "circlet",
                "bayonet",
                "wallet",
                "goblet",
                "amulet",
                "islet"
        ));
        adjectives = new ArrayList<>(Arrays.asList(
                "bewitching",
                "ginormous",
                "dazzling",
                "deadly",
                "happy",
                "distressed",
                "amazing",
                "omniscient",
                "extraordinary",
                "furious",
                "spectacular",
                "fancy",
                "overjoyed",
                "icy",
                "delightful",
                "unparalleled"
        ));
        verbs = new ArrayList<>(Arrays.asList(
                "sings",
                "dances",
                "plays",
                "transforms",
                "reminisces",
                "contemplates",
                "ruminates",
                "anticipate",
                "withers",
                "gallops",
                "ambles",
                "illuminates",
                "transcends",
                "reincarnates",
                "veils"
        ));
        preposition = new ArrayList<>(Arrays.asList(
                "to",
                "on",
                "in",
                "after",
                "for",
                "around",
                "with",
                "over"
        ));
    }
}
