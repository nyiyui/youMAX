/**
 * Names: Ivy Zhuang, Youmin Lee, Ken Shibata
 * Teacher: Ms. Krasteva
 * Date: March 8, 2023
 * Purpose: simulates one round of Bridge
 * Contributions: Ivy did whole Bridge Class
 */
package Bridge;

import java.util.ArrayList;
import java.util.Collections;

public class Bridge {
    /**
     * traditional deck of cards (52 cards)
     */
    private ArrayList<String> deck;
    /**
     * hands of each player. There are four players, thus players 1-4
     */
    private String player1 = "", player2 = "", player3 = "", player4 = "";
    /**
     * the winner of one round of bridge
     */
    private String winner;
    /**
     * the maximum number of points a player has, aka the number of points the winner has
     */
    private int maxPoints;

    /**
     * Constructor for Bridge. Initializes an empty deck
     */
    public Bridge() {
        deck = new ArrayList<>();
    }

    /**
     * Simulates one round of bridge
     */
    public void simulateRound(){
        fillDeck();
        shuffleDeck();
        dealCards();
        showPlayerHand(player1, "Youmin");
        showPlayerHand(player2, "Youmax");
        showPlayerHand(player3, "YouGod");
        showPlayerHand(player4, "Youniverse");
        showWinner();
    }

    /**
     * shows the winner and the number of points said winner has to the user
     */
    private void showWinner(){
        System.out.println("\nThe winner is "+winner+", with "+maxPoints+" points!!");
    }

    /**
     * shows a player hand to the user
     * @param hand the hand of the player, contains 13 cards
     * @param playerName the name of the player
     */
    private void showPlayerHand(String hand, String playerName){
        System.out.println("Showing "+playerName + "'s hand:");
        String spades = "", hearts = "", diamonds = "", clubs = "";
        int s = 0, h = 0, d = 0, c = 0;
        int points = 0;
        for(int i=0;i<hand.length();i+=2){
            String card = hand.substring(i, i+2);
            // check card suit
            if(card.charAt(1) == 'S'){
                spades += card + " ";
                s++;
            }
            else if(card.charAt(1) == 'H'){
                hearts += card + " ";
                h++;
            }
            else if(card.charAt(1) == 'D'){
                diamonds += card + " ";
                d++;
            }
            else {
                clubs += card + " ";
                c++;
            }
            // check card denomination
            if(card.charAt(0) == 'A'){
                points += 4;
            }
            else if(card.charAt(0) == 'K'){
                points += 3;
            }
            else if (card.charAt(0) == 'Q'){
                points += 2;
            } else if (card.charAt(0) == 'J') {
                points += 1;
            }
        }
        System.out.println("Spades:\t\t"+spades);
        System.out.println("Hearts:\t\t"+hearts);
        System.out.println("Diamonds:\t"+diamonds);
        System.out.println("Clubs:\t\t"+clubs);
        // check for void, singleton, and doubleton
        if (s == 0 || h == 0 || d == 0 || c == 0){
            System.out.println(playerName+" has a void!");
            points += 3;
        }
        if (s == 1 || h == 1 || d == 1 || c == 1){
            System.out.println(playerName+" has a singleton!");
            points += 2;
        }
        if (s == 2 || h == 2 || d == 2 || c == 2){
            System.out.println(playerName+" has a doubleton!");
            points += 1;
        }
        // shows player's total points
        System.out.println(playerName+" has "+points+" points!\n");
        // updates winner and max points
        if (maxPoints < points){
            winner = playerName;
            maxPoints = points;
        }
    }

    /**
     * shuffles the deck
     */
    private void shuffleDeck() {
        Collections.shuffle(deck);
        System.out.println("Deck has been shuffled!");
    }

    /**
     * deal cards to each player's hand
     */
    private void dealCards() {
        while(!deck.isEmpty()){
            player1 += deck.remove(0);
            player2 += deck.remove(0);
            player3 += deck.remove(0);
            player4 += deck.remove(0);
        }
    }

    /**
     * adds all cards into the text from one string that contains all the cards
     */
    private void fillDeck() {
        String cards = "AD2D3D4D5D6D7D8D9DTDJDQDKD" +
                "AC2C3C4C5C6C7C8C9CTCJCQCKC" +
                "AH2H3H4H5H6H7H8H9HTHJHQHKH" +
                "AS2S3S4S5S6S7S8S9STSJSQSKS";
        for (int i = 0; i < cards.length(); i += 2) {
            deck.add(cards.substring(i, i + 2));
        }
    }

}
