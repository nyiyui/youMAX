package CrazySentences;

import java.util.ArrayList;

public class Sentence {
    private static ArrayList<String> nouns;
    private static ArrayList<String> articles;
    private static ArrayList<String> adjectives;
    private static ArrayList<String> verbs;
    private static ArrayList<String> preposition;

    public Sentence(){

    }

    private static void loadLists(){
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

        verbs.add("jumps");
        verbs.add("walks");
    }
}
