package CrazySentences;

import java.util.ArrayList;

public class AIPoem {
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

    public AIPoem() {
        loadLists();
    }

    /**
     * manually adds every word into their respective lists
     */
    private static void loadLists(){
        articles = new ArrayList<>();
        atNouns = new ArrayList<>();
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
