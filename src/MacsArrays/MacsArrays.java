/**
 * Names: Ayda, Alex, Ken
 * Teacher: Ms. Krasteva
 * Date: March 8, 2023
 * Purpose: MacsArrays business logic
 * Contributions:
 * - Ken:  mark editing, autosave, and general code cleanup
 * - Ayda: printing records
 * - Alex: sorting
 */
package MacsArrays;

import java.io.*;
import java.util.*;

public class MacsArrays {
    private static final String[] GREETINGS = {"Hello!", "nya~", "I'm sorry for this being late."};
    /**
     * Path to autosave to.
     */
    private static final String AUTOSAVE_PATH = ".macsarrays-autosave";
    /**
     * List of student names.
     */
    private ArrayList<String> names;
    /**
     * List of student numbers.
     */
    private ArrayList<Integer> numbers;
    /**
     * List of student marks.
     */
    private ArrayList<Double> sMarks;
    private Scanner s;

    MacsArrays() {
        s = new Scanner(System.in);
        names = new ArrayList<>();
        numbers = new ArrayList<>();
        sMarks = new ArrayList<>();
    }

    /**
     * Formats a single row of table-oriented data. Pads to the required lengths.
     *
     * @param lengths width of each value's cell. Length of lengths must be equal to length of values.
     * @param values  values for each column/cell. Length of values must be equal to length of lengths.
     * @return formatted row without a newline
     */
    private static String formatRow(int[] lengths, String[] values) {
        if (lengths.length != values.length) throw new RuntimeException("lengths must be equal in lengths to values");
        String[] elements = new String[lengths.length];
        for (int i = 0; i < lengths.length; i++)
            elements[i] = new String(new char[lengths[i]]).replaceAll("\0", " ").substring(values[i].length()) + values[i];
        return String.join(" ", elements);
    }

    /**
     * Shows a help menu with available commands.
     */
    private static void showHelp() {
        System.out.println("--- Available options:");
        System.out.println("Options");
        System.out.println("  help   - show options");
        System.out.println("  create - append marks");
        System.out.println("  edit   - edit a single student's records");
        System.out.println("  sort-a - sort alphabetically (A-Z) and show");
        System.out.println("  sort-m - sort by descending mark and show");
        System.out.println("  all    - view all student names, numbers, marks, and averages");
        System.out.println("  single - view single student info");
        System.out.println("  load   - load and append data to current records");
        System.out.println("  save   - save records to file");
        System.out.println("  print  - save records in a columned format");
        System.out.println("  exit   - exit application");
    }

    /**
     * Main menu. Dispatches to other menu methods.
     */
    void menu() {
        System.out.println(GREETINGS[new Random().nextInt(GREETINGS.length)]);
        showHelp();
        loadAutosave();
        InputLoop:
        while (true) {
            System.out.print("> ");
            String line = s.nextLine().toLowerCase();
            boolean displayAll = false;
            switch (line) {
                case "help":
                    showHelp();
                    break;
                case "halp":
                    System.out.println("You need help? Type \"help\"!");
                    break;
                case "create":
                    createMenu();
                    saveAutosave();
                    break;
                case "edit":
                    editMenu();
                    saveAutosave();
                    break;
                case "sort-a":
                    sortByAlpha();
                    saveAutosave();
                    break;
                case "sort-m":
                    sortByMark(false);
                    saveAutosave();
                    break;
                case "all":
                    displayAll = true;
                case "single":
                    marksMenu(displayAll);
                    break;
                case "autosave":
                    saveAutosave();
                    break;
                case "load-autosave":
                    loadAutosave();
                case "load":
                    loadRecordsMenu();
                    break;
                case "save":
                    saveRecordsMenu();
                    break;
                case "print":
                    printRecords();
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

    private void editMenu() {
        int chosenI = chooseStudent("to edit");
        printRecord(chosenI);
        System.out.println("Note: enter blank line to keep existing value.");
        int newNumber;
        do {
            System.out.print("number>");
            try {
                newNumber = Integer.parseInt(s.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("invalid number " + e.getLocalizedMessage());
                continue;
            }
            break;
        } while (true);
        System.out.print("name>");
        String newName = s.nextLine().trim();
        double newMark;
        do {
            System.out.print("mark>");
            try {
                newMark = Double.parseDouble(s.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("invalid number " + e.getLocalizedMessage());
                continue;
            }
            break;
        } while (true);
        numbers.set(chosenI, newNumber);
        names.set(chosenI, newName);
        sMarks.set(chosenI, newMark);
        System.out.println("--- New (updated) records");
        printRecord(chosenI);
    }

    private int chooseStudent(String intent) {
        while (true) {
            System.out.println("--- Choose Student " + intent);
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
                System.out.println("name not found in records");
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
            return chosenI;
        }
        return -1;
    }


    /**
     * Menu for choosing a student
     *
     * @param displayAll display all student records?
     */
    private void marksMenu(boolean displayAll) {
        if (!displayAll) {
            int chosenI = chooseStudent("to show info");
            printRecord(chosenI);
        } else {
            System.out.printf("Printing %d records:\n", names.size());
            int indexStringMax = Integer.max(5, (int) Math.log10(names.size()));
            int numberStringMax = 6;
            int nameStringMax = 4;
            int markStringMax = 4;
            for (int i = 0; i < names.size(); i++) {
                String number = String.format("%d", numbers.get(i));
                String name = names.get(i);
                String mark = String.format("%.2f", sMarks.get(i));
                numberStringMax = Integer.max(numberStringMax, number.length());
                nameStringMax = Integer.max(nameStringMax, name.length());
                markStringMax = Integer.max(markStringMax, mark.length());
            }
            int[] lengths = {indexStringMax, numberStringMax, nameStringMax, markStringMax};
            System.out.println(formatRow(lengths, new String[]{"Index", "Number", "Name", "Mark",}));
            for (int i = 0; i < names.size(); i++) {
                String index = Integer.toString(i);
                String number = Integer.toString(numbers.get(i));
                String name = names.get(i);
                String mark = Double.toString(sMarks.get(i));
                System.out.println(formatRow(lengths, new String[]{index, number, name, mark,}));
            }
            System.out.printf("Class Average: %.3f\n", classAverage());
        }
    }

    /**
     * Print records for a single student
     *
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
            sum += sMarks.get(i);
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
        getMarks("Student Marks", "M", sMarks, init);
        System.out.printf("Class average: %.2f\n", classAverage());
    }

    private void saveRecords(String path) throws IOException {
        try (FileWriter w = new FileWriter(path)) {
            w.write("MacsArrays-format-v1\n");
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
    }

    /**
     * Save records in a human-readable format (also ask user for path to save to).
     * This only saves the name and marks.
     */
    private void printRecords() {
        System.out.println("=== Print Records");
        System.out.print("Filepath to print to: ");
        try (FileWriter w = new FileWriter(s.nextLine())) {
            // we're only dealing with English with UTF-8...I hope
            // Ah yes non-English languages totally do not exist, so we don't have to care about them hehehe
            // Also noone uses non-UTF-8...Right? Mmmmmhmmmmmm indeed.
            // Ms. Krasteva please don't kill me I don't do this in MCPT code.
            MultiWriter sink = new MultiWriter(w, new OutputStreamWriter(System.out));
            new PrintWriter(System.out).write("test");
            System.out.println("Printed data:");
            int nameNumberStringMax = 24;
            int markStringMax = 4;
            for (int i = 0; i < names.size(); i++) {
                String number = String.format("%d", numbers.get(i));
                String name = names.get(i);
                String mark = String.format("%.2f", sMarks.get(i));
                nameNumberStringMax = Integer.max(nameNumberStringMax, name.length() + 2 + number.length() + 1+4);
                markStringMax = Integer.max(markStringMax, mark.length());
            }
            int[] lengths = {nameNumberStringMax, markStringMax};
            sink.write(formatRow(lengths, new String[]{"Name (and Number)    ", "Mark",}) + "\n");
            for (int i = 0; i < names.size(); i++) {
                String number = Integer.toString(numbers.get(i));
                String name = names.get(i);
                String mark = Double.toString(sMarks.get(i));
                sink.write(formatRow(lengths, new String[]{String.format("%s (%s)    ", name, number), mark,}) + "\n");
            }
        } catch (Exception e) {
            System.out.printf("--- print error: %s\n", e.getLocalizedMessage());
        }
    }

    private void saveAutosave() {
        try {
            saveRecords(AUTOSAVE_PATH);
            System.out.println("--- autosaved.");
        } catch (IOException e) {
            System.out.printf("--- autosave failed (%s). Type `autosave` to try again\n", e.getLocalizedMessage());
        }
    }

    private void saveRecordsMenu() {
        System.out.println("=== Save Records");
        System.out.print("Filepath to save to: ");
        try {
            saveRecords(s.nextLine());
        } catch (Exception e) {
            System.out.printf("--- save error: %s\n", e.getLocalizedMessage());
        }
    }

    private void loadAutosave() {
        try {
            loadRecords(AUTOSAVE_PATH);
        } catch (FileNotFoundException e) {
            System.out.println("--- no autosave found");
        } catch (IOException e) {
            System.out.printf("--- failed to load autosave (%s)\n", e.getLocalizedMessage());
        }
        System.out.printf("--- loaded %d records from autosave.\n", names.size());
    }


    private void loadRecords(String path) throws IOException {
        try (FileReader fr = new FileReader(path)) {
            Scanner s = new Scanner(fr);
            if (!s.nextLine().equals("MacsArrays-format-v1")) {
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
    }

    private void loadRecordsMenu() {
        System.out.println("=== Load and Append Records");
        System.out.print("Filepath to load from: ");
        try {
            loadRecords(s.nextLine());
        } catch (IOException e) {
            System.out.printf("--- load error: %s\n", e.getLocalizedMessage());
        }
    }

    /**
     * Sorts the two arrays of names and marks by student name
     */
    private void sortByAlpha() {
        new Sorter<String, Double, Integer>().insertionSort(Comparator.naturalOrder(), 0, names.size(), names, sMarks, numbers);
    }

    /**
     * Sorts the two arrays of names and marks by grade. Reverse changes the order in which it is sorted.
     *
     * @param ascending whether array is sorted ascending
     */
    private void sortByMark(boolean ascending) {
        Comparator<Double> c;
        if (ascending) {
            c = Comparator.naturalOrder();
        } else {
            c = Collections.reverseOrder();
        }
        new Sorter<Double, String, Integer>().insertionSort(c, 0, names.size(), sMarks, names, numbers);
    }

    /**
     * Helper method which is used to move the element to the correct position
     */
    private void selectandSwap(int index, int passes) {
        String tempName = names.get(index);
        double tempMark = sMarks.get(index);
        names.remove(index);
        sMarks.remove(index);
        names.add(names.size() - 1 - passes, tempName);
        sMarks.add(sMarks.size() - 1 - passes, tempMark);
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

/**
 * Do synchronised operations on multiple Writers.
 * Idea is from <a href="https://pkg.go.dev/io#MultiWriter">Go's io.MultiWriter</a>
 */
class MultiWriter extends Writer {
    private final Writer[] sinks;

    /**
     * Make a new writer with multiple sinks. Zero sinks act as a null device.
     *
     * @param sinks Writers to write in, in the order they will be written to.
     */
    MultiWriter(Writer... sinks) {
        this.sinks = sinks;
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        for (Writer s : sinks)
            s.write(cbuf, off, len);
    }

    @Override
    public void flush() throws IOException {
        for (Writer s : sinks)
            s.flush();
    }

    @Override
    public void close() throws IOException {
        for (Writer s : sinks)
            s.flush();
    }
}

class Sorter<T, U, V> {
    /**
     * Stably sorts array sortee along with other arrays.
     *
     * @param c         comparator to sort with
     * @param start     inclusive start index
     * @param end       non-inclusive end index
     * @param sortee    array to sort
     * @param trailing1 array to sort along with sortee (sorted/compared using sortee but changes to sortee are applied here too)
     * @param trailing2 array to sort along with sortee (sorted/compared using sortee but changes to sortee are applied here too)
     */
    void insertionSort(Comparator<T> c, int start, int end, List<T> sortee, List<U> trailing1, List<V> trailing2) {
        for (int i = start + 1; i < end; i++) {
            T tmp = sortee.get(i);
            U tmp1 = trailing1.get(i);
            V tmp2 = trailing2.get(i);
            int j = i;
            while (j > start && c.compare(sortee.get(j - 1), tmp) > 0) {
                sortee.set(j, sortee.get(j - 1));
                trailing1.set(j, trailing1.get(j - 1));
                trailing2.set(j, trailing2.get(j - 1));
                j--;
            }
            sortee.set(j, tmp);
            trailing1.set(j, tmp1);
            trailing2.set(j, tmp2);
        }
    }
}