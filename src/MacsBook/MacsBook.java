package MacsBook;

import Pokemon_Rating.AllDataScreen;
import Pokemon_Rating.PremiseScreen;
import javafx.css.CssParser;

import java.util.ArrayList;
import java.util.Scanner;

public class MacsBook {
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<Integer> numbers = new ArrayList<>();
    private ArrayList<Double> aMarks = new ArrayList<>();
    private ArrayList<Double> tMarks = new ArrayList<>();
    private ArrayList<Double> fMarks = new ArrayList<>();

    private void menu() {
        System.out.println("Menu!");
        System.out.println("Options");
        System.out.println("  create - add marks");
        System.out.println("  all - view all student names, numbers, marks, and averages");
        System.out.println("  single - view single student info");
        System.out.println("  exit - exit application");
        Scanner s = new Scanner(System.in);
        InputLoop:
        while (true) {
            System.out.print("> ");
            String line = s.nextLine().toLowerCase();
            int displayType = 0;
            switch (line) {
                case "create":
                    createMenu();
                    break InputLoop;
                case "all":
                case "single":
                    marksMenu(displayAll);
                    break InputLoop;
                case "exit":
                    break InputLoop;
                default:
                    System.out.println("Invalid option chosen. Try again.");
                    break;
            }
        }
    }

    private double studentAverage(int i) {
        return (aMarks.get(i) + tMarks.get(i) + fMarks.get(i)) / 3.0;
    }

    private double classAverage() {
        double sum = 0.0;
        for (int i = 0; i < names.size(); i++) {
            sum += studentAverage(i);
        }
        return sum / (double) names.size();
    }

    private void createMenu() {
        Scanner s = new Scanner(System.in);
        System.out.println("=== Create Data");
        System.out.println("--- Input Names");
        System.out.println("Note: input blank line to end.");
        for (int i = 0; true; i++) {
            System.out.printf("%d\tname> ", i);
            String line = s.nextLine();
            if (line.length() == 0)
                break;
            names.add(line.strip());
        }
        System.out.println("--- Input Numbers");
        for (int i = 0; i < names.size(); i++) {
            System.out.printf("%d\tnumber for %s> ", i, names.get(i));
            String line = s.nextLine();
            try {
                numbers.add(Integer.parseInt(line));
            } catch (NumberFormatException e) {
                System.out.println("--- invalid number; try again.");
                i--;
            }
        }
        System.out.println("--- Input Student Assignment Marks (AM) (percent)");
        for (int i = 0; i < names.size(); i++) {
            System.out.printf("%d\tAM for %s> ", i, names.get(i));
            String line = s.nextLine();
            try {
                double mark = Double.parseDouble(line);
                if (mark < 0 || mark > 100) {
                    throw new NumberFormatException("outside of range");
                }
                aMarks.add(mark);
            } catch (NumberFormatException e) {
                System.out.println("--- invalid number; try again.");
                i--;
            }
        }
        System.out.println("--- Input Student Test Marks (TM) (percent)");
        for (int i = 0; i < names.size(); i++) {
            System.out.printf("%d\tTM for %s> ", i, names.get(i));
            String line = s.nextLine();
            try {
                double mark = Double.parseDouble(line);
                if (mark < 0 || mark > 100) {
                    throw new NumberFormatException("outside of range");
                }
                tMarks.add(mark);
            } catch (NumberFormatException e) {
                System.out.println("--- invalid number; try again.");
                i--;
            }
        }
        System.out.println("--- Input Student Final (Project) Marks (FM) (percent)");
        for (int i = 0; i < names.size(); i++) {
            System.out.printf("%d\tFM for %s> ", i, names.get(i));
            String line = s.nextLine();
            try {
                double mark = Double.parseDouble(line);
                if (mark < 0 || mark > 100) {
                    throw new NumberFormatException("outside of range");
                }
                fMarks.add(mark);
            } catch (NumberFormatException e) {
                System.out.println("--- invalid number; try again.");
                i--;
            }
        }
        System.out.println("--- Input Student Final (Project) Marks (FM) (percent)");
        for (int i = 0; i < names.size(); i++) {
            System.out.printf("%d average for %s: %.2f\n", i, names.get(i), studentAverage(i));
        }
        System.out.printf("class average: %.2f\n", classAverage());
    }
}