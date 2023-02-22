/**
 * Names: Ivy Zhuang, Ken Shibata, Youmin Lee
 * Teacher: Ms. Krasteva
 * Date: Feb 21, 2023
 * Purpose: Driver class, tests out classes and their instance methods
 */
package Youniverse;

public class Main {
    public static void main(String[] args) {
        YouGod youGod = new YouGod();
        youGod.beginCreation();
        Youmax max = new Youmax(1000);
        Youmin min = new Youmin();
//        max.makeYounimals();
//        min.makeYoulants();
        youGod.thinkOf("There are so many new YouCreations surrounding me!","comforted");
        youGod.transcend();
    }
}
