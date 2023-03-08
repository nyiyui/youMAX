package MacsBook;
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
     * List of assignment marks.
     */
    private ArrayList<Double> aMarks = new ArrayList<>();
    /**
     * List of test marks.
     */
    private ArrayList<Double> tMarks = new ArrayList<>();
    /**
     * List of final marks.
     */
    private ArrayList<Double> fMarks = new ArrayList<>();

    public static void main(String[] args) {
        MacsBook book = new MacsBook();
        book.menu();
    }

    /**
     * Main menu. Dispatches to other menu methods.
     */
    private void menu() {
        System.out.println("Menu!");
        showHelp();
        Scanner s = new Scanner(System.in);
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
                case "exit":
                    break InputLoop;
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
        System.out.println("--- Help!");
        System.out.println("Options");
        System.out.println("  help - show options");
        System.out.println("  create - append marks");
        System.out.println("  all - view all student names, numbers, marks, and averages");
        System.out.println("  single - view single student info");
        System.out.println("  exit - exit application");
    }

    /**
     * Menu for choosing a student
     * @param displayAll display all student records?
     */
    private void marksMenu(boolean displayAll) {
        Scanner s = new Scanner(System.in);
        if (!displayAll) {
            while (true) {
                System.out.println("--- Choose Student");
                System.out.println("Note: input blank line to exit prematurely.");
                System.out.print("> ");
                String line = s.nextLine().trim();
                if (line.length() == 0) {
                    break;
                }
                ArrayList<Integer> matches = new ArrayList<>();
                for (int i = 0; i < names.size(); i++)
                    if (names.get(i).equals(line))
                        matches.add(i);
                if (matches.size() == 0) {
                    System.out.println("--- name not found in records");
                    continue;
                }
                int chosenI = -1;
                if (matches.size() == 1) {
                    chosenI = matches.get(0);
                } else {
                    while (true) {
                        for (int i : matches) {
                            printRecord(i);
                        }
                        System.out.println("--- Multiple student with name found.");
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
        System.out.printf("  Assignment Mark: %.2f\n", aMarks.get(i));
        System.out.printf("  Test Mark: %.2f\n", tMarks.get(i));
        System.out.printf("  Final Mark: %.2f\n", fMarks.get(i));
        System.out.printf("  Average: %.2f\n", studentAverage(i));
    }

    /**
     * Gets a student's average mark.
     * @param i student index
     * @return average mark
     */
    private double studentAverage(int i) {
        return (aMarks.get(i) + tMarks.get(i) + fMarks.get(i)) / 3.0;
    }

    /**
     * Gets a class' average mark.
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
     * Menu for creating records.
     */
    private void createMenu() {
        Scanner s = new Scanner(System.in);
        System.out.println("=== Create Data");
        System.out.println("--- Input Names");
        System.out.println("Note: input blank line to end.");
        int init = names.size();
        for (int i = init; true; i++) {
            System.out.printf("%d\tname> ", i);
            String line = s.nextLine();
            if (line.length() == 0)
                break;
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
        System.out.println("--- Input Student Assignment Marks (AM) (percent)");
        for (int i = init; i < names.size(); i++) {
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
        for (int i = init; i < names.size(); i++) {
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
        for (int i = init; i < names.size(); i++) {
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