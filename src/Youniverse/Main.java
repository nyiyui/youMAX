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
        youGod.thinkOf("this is a world (is it even?) filled with nothingness.", "lonely and sad");
        youGod.beginCreation();
        Youmax max = new Youmax(1000);
        Youmin min = new Youmin();
        max.beginCreation();
        min.beginCreation();
        Younimal animal = new Younimal("YouDog", 50, false, 5000);
        Youlant plant = new Youlant("Youlac", 5, 40, "Tundra", 2);
        plant.uproot("Yougrassland");
        plant.grow(100);
        plant.bloom();
        animal.eat(plant);
        plant.die();
        animal.travel(10000004, "Yourope");
        YouPerson person = new YouPerson("Kenneth", 150, true, 10, "Japanese");
        YouCat cat = new YouCat();
        cat.meow();
        cat.charm(person);
        person.charmedBy(cat);
        person.attemptFeeding(cat);
        person.takePersonalityTest(90, 40, 20, 10);
        YouPerson person1 = new YouPerson("Paul", 200, false, 10, "English");
        person.communicate("buses r so pog", "evil", person1);
        person.setLanguage("English");
        person.communicate("trains r so fun", "good", person1);
        person.thinkOf("trains r indeed pog", "trains");
        Youkai youkai = new Youkai("Youmagic", 30, 2000.5);
        youkai.help(person);
        youkai.die();
        YoukaiWatch watch = new YoukaiWatch(youkai);
        watch.beginCreation();
        watch.activate();
        youGod.thinkOf("There are so many new YouCreations surrounding me!","comforted");
        youGod.die();
        System.out.println("And that's the end of the YouCreation YouMyth!");
    }
}
