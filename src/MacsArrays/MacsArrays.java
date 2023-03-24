/**
 * Names: Ayda, Alex, Ken
 * Teacher: Ms. Krasteva
 * Date: March 8, 2023
 * Purpose: MacsBook business logic
 * Contributions: 
 *  - Ken:
 *  - Ayda:  
 *  - Alex: 
 * for now everyone does everything and then we pick the best parts, then lie!
 */
package MacsArrays;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MacsBook {
    /**
     * List of student names.
     */
    private ArrayList<String> names = new ArrayList<>();
    /**
     * List of student numbers.
     */
    private ArrayList<Integer> numbers = new ArrayList<>();
    /**
     * List of student marks.
     */
    private ArrayList<Double> sMarks = new ArrayList<>();
    private Scanner s;

    MacsBook() {
        s = new Scanner(System.in);
    }

    /**
     * Main menu. Dispatches to other menu methods.
     */
    void menu() {
        System.out.println("Menu!");
        showHelp();
        InputLoop:
        while (true) {
            System.out.print("> ");
            String line = s.nextLine().toLowerCase();
            boolean displayAll = false;
            switch (line) {
                case "create":
                    createMenu();
                    break;
                case "help":
                    showHelp();
                    break;
                case "halp":
                    System.out.println("You need help? Type \"help\"!");
                    break;
                case "all":
                    displayAll = true;
                case "single":
                    marksMenu(displayAll);
                    break;
                case "load":
                    loadRecords();
                    break;
                case "save":
                    saveRecords();
                    break;
                case "exit":
                    break InputLoop;
                case "":
                    break;
                default:
                    System.out.println("Invalid option chosen. Try again.");
                    break;
            }
        }
    }

    /**
     * Shows a help menu with available commands.
     */
    private static void showHelp() {
        System.out.println("--- Available options:");
        System.out.println("Options");
        System.out.println("  help - show options");
        System.out.println("  create - append marks");
        System.out.println("  all - view all student names, numbers, marks, and averages");
        System.out.println("  single - view single student info");
        System.out.println("  load - load and append data to current records");
        System.out.println("  save - dump records to file");
        System.out.println("  exit - exit application");
    }

    /**
     * Menu for choosing a student
     * @param displayAll display all student records?
     */
    private void marksMenu(boolean displayAll) {
        if (!displayAll) {
            while (true) {
                System.out.println("--- Choose Student");
                System.out.println("Note: input blank line to exit prematurely.");
                System.out.print("name> ");
                String line = s.nextLine().trim();
                if (line.length() == 0) {
                    break;
                }
                ArrayList<Integer> matches = new ArrayList<>();
                for (int i = 0; i < names.size(); i++)
                    if (names.get(i).equals(line)) matches.add(i);
                if (matches.size() == 0) {
                    System.out.println("--- name not found in records");
                    continue;
                }
                int chosenI;
                if (matches.size() == 1) {
                    chosenI = matches.get(0);
                } else {
                    while (true) {
                        System.out.println("--- Multiple students with name found.");
                        for (int i : matches) {
                            printRecordShort(i);
                        }
                        System.out.println("--- Input student index:");
                        System.out.print("> ");
                        chosenI = s.nextInt();
                        if (chosenI < 0 || chosenI >= names.size()) {
                            System.out.println("--- invalid student index given");
                            continue;
                        }
                        break;
                    }
                }
                printRecord(chosenI);
                break;
            }
        } else {
            System.out.printf("Printing %d records:\n", names.size());
            for (int i = 0; i < names.size(); i++) {
                printRecord(i);
            }
            System.out.printf("Class Average: %.3f\n",classAverage());
        }
    }

    /**
     * Print records for a single student
     * @param i student index
     */
    private void printRecord(int i) {
        System.out.printf("Student Index %d\n", i);
        System.out.printf("  Name: %s\n", names.get(i));
        System.out.printf("  Number: %s\n", numbers.get(i));
        System.out.printf("  Mark: %.2f\n", sMarks.get(i));
    }

    /**
     * Print short version of records for a single student
     *
     * @param i student index
     */
    private void printRecordShort(int i) {
        System.out.printf("Student Index %d\t(#%d)\t%s\n", i, numbers.get(i), names.get(i));
    }

    /**
     * Gets a class' average mark.
     *
     * @return average mark
     */
    private double classAverage() {
        double sum = 0.0;
        for (int i = 0; i < names.size(); i++) {
            sum += studentAverage(i);
        }
        return sum / (double) names.size();
    }

    /**
     *
     */
    private void getMarks(String markName, String markType, ArrayList<Double> marks, int init) {
        System.out.printf("--- Input Student %s (%s) (percent)\n", markName, markType);
        for (int i = init; i < names.size(); i++) {
            System.out.printf("%d\t%s for %s> ", i, markType, names.get(i));
            String line = s.nextLine();
            try {
                double mark = Double.parseDouble(line);
                if (mark < 0 || mark > 100) {
                    throw new NumberFormatException("outside of range");
                }
                marks.add(mark);
            } catch (NumberFormatException e) {
                System.out.println("--- invalid number; try again.");
                i--;
            }
        }
    }

    /**
     * Menu for creating records.
     */
    private void createMenu() {
        System.out.println("=== Create Data");
        System.out.println("--- Input Names");
        System.out.println("Note: input blank line to end.");
        int init = names.size();
        for (int i = init; true; i++) {
            System.out.printf("%d\tname> ", i);
            String line = s.nextLine();
            if (line.length() == 0) break;
            names.add(line.trim());
        }
        System.out.println("--- Input Numbers");
        for (int i = init; i < names.size(); i++) {
            System.out.printf("%d\tnumber for %s> ", i, names.get(i));
            String line = s.nextLine();
            try {
                numbers.add(Integer.parseInt(line));
            } catch (NumberFormatException e) {
                System.out.println("--- invalid number; try again.");
                i--;
            }
        }
        getMarks("Student Marks", "M", aMarks, init);
        System.out.println("--- Student Averages");
        for (int i = 0; i < names.size(); i++) {
            System.out.printf("%d average for %s: %.2f\n", i, names.get(i), studentAverage(i));
        }
        System.out.printf("class average: %.2f\n", classAverage());
    }

    private void saveRecords() {
        System.out.println("=== Save Records");
        System.out.print("Filepath to save to: ");
        try {
            try (FileWriter w = new FileWriter(s.nextLine())) {
                w.write("MacsBook-format-v1\n");
                for (String name : names) {
                    w.write(escape(name));
                    w.write("\t");
                }
                w.write("\n");
                for (int number : numbers) {
                    w.write(String.format("%d", number));
                    w.write("\t");
                }
                w.write("\n");
                for (double mark : sMarks) {
                    w.write(String.format("%.2f", mark));
                    w.write("\t");
                }
                w.write("\n");
            }
        } catch (Exception e) {
            System.out.printf("--- save error: %s\n", e.getLocalizedMessage());
        }
    }

    private void loadRecords() {
        System.out.println("=== Load and Append Records");
        System.out.print("Filepath to load from: ");
        try {
            try (FileReader fr = new FileReader(s.nextLine())) {
                Scanner s = new Scanner(fr);
                if (!s.nextLine().equals("MacsBook-format-v1")) {
                    System.out.println("--- unknown file version/format");
                    return;
                }
                s.useDelimiter("[\\t\\n]");
                String[] raw = s.nextLine().split("\\t");
                for (String nameRaw : raw) {
                    names.add(unescape(nameRaw));
                }
                 raw = s.nextLine().split("\\t");
                for (String numberRaw : raw) {
                    numbers.add(Integer.parseInt(numberRaw));
                }
                if (numbers.size() != names.size()) {
                    System.out.println("--- file has corrupt data: numbers length not equal to names length");
                    return;
                }
                raw = s.nextLine().split("\\t");
                for (String markRaw : raw) {
                    sMarks.add(Double.parseDouble(markRaw));
                }
                if (sMarks.size() != names.size()) {
                    System.out.println("--- file has corrupt data: assignment marks length not equal to names length");
                    return;
                }

            }
        } catch (IOException e) {
            System.out.printf("--- load error: %s\n", e.getLocalizedMessage());
        }
    }

    /**
     * Escapes string s so it doesn't contain tabs.
     *
     * @param s String to escape
     * @return escaped string
     */
    private static String escape(String s) {
        return s.replaceAll("\\\\", "\\\\").replaceAll("\\t", "\\t");
    }

    /**
     * Unescapes a string escaped by escape().
     *
     * @param s escaped string
     * @return unescaped string
     */
    private static String unescape(String s) {
        return s.replaceAll("\\\\t", "\t").replaceAll("\\\\\\\\", "\\");
    }
}
