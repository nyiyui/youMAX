/**
 * Names: Ayda, Alex, Ken
 * Teacher: Ms. Krasteva
 * Date: April 1, 2023
 * Purpose: To create a program that will sort a class's students by their marks numerically from highest to lowest or to sort them 
 * alphabetically. Two files are used, one that stores sorted/formated data, and one that stores the raw data the user enters. 
 * for ease of use/testing a file has been provided that contains 50 premade students, if you wish to discard this data, clear the file. 
 * 
 * Contributions: 
 *  - Ken:  editing, bugfixing, and general cleanup
 *  - Ayda: updated file structure and user clarity in print statements 
 *  - Alex: sorting numerical and alphabetical 
 */
package MacsSorting;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class MacsSorting {
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
   private static final String IN_PATH = "AydaAlexNekFileIn.txt";
   private static final String OUT_PATH = "AydaAlexNekFileOut.txt";
   
   /* when sorting occurs file writing must not take the array from the orginal file, this variable allows for an if statement in saveToOut() and marksMenu() */
   private boolean sorted = false; 

   MacsSorting() {
      s = new Scanner(System.in);
   }

   /**
    * Main menu. Dispatches to other menu methods.
    */
   void menu() {
      System.out.println("Menu!");
      showHelp();
      loadFromIn();
      
      InputLoop: while (true) {
         System.out.print("> ");
         String line = s.nextLine().toLowerCase();
         boolean displayAll = false;
         switch (line) {
            case "create":
               createMenu();
               break;
            case "edit":
               editMenu();
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
            case "numerical":
               sortByNumber();
               break;
            case "alpha":
               sortByAlpha();
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
      System.out.println("  edit - edit mark");
      System.out.println("  create - append marks");
      System.out.println("  all - view all student names, numbers, marks, and averages");
      System.out.println("  single - view single student info");
      System.out.println("  alpha - sort the data in the file alphabetically by student name"); 
      System.out.println("  numerical - sort the data in the file numerically by student averages (high to low)"); 
      System.out.println("  exit - exit application");
   }

   /**
    * Choose a student with an intent.
    * @param intent intent to use the student for e.g. "to view"
    */
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
                 if (!(0 < chosenI && chosenI < names.size())) {
                     System.out.printf("--- invalid student index given (0 to %d inclusive)",names.size()-1);
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


    private void editMenu() {
        int chosenI = chooseStudent("to edit");
        if (chosenI == -1) return;
        printRecord(chosenI);
        System.out.println("Note: enter blank line to keep existing value.");
        System.out.print("new name>");
        String newName = s.nextLine().trim();
        if (newName.length()!=0)
        names.set(chosenI, newName);
        int newNumber;
        do {
            System.out.print("new number>");
            try {
                String raw=    s.nextLine().trim();
                if (raw.length() == 0) break;
                newNumber = Integer.parseInt(raw);
            } catch (NumberFormatException e) {
                System.out.println("invalid number " + e.getLocalizedMessage());
                continue;
            }
        numbers.set(chosenI, newNumber);
            break;
        } while (true);
        double newMark;
        do {
            System.out.print("new mark>");
            try {
                String raw=    s.nextLine().trim();
                if (raw.length() == 0) break;
                newMark = Double.parseDouble(raw);
            } catch (NumberFormatException e) {
                System.out.println("invalid number " + e.getLocalizedMessage());
                continue;
            }
            if (newMark<0 || newMark>100) {
                System.out.println("invalid number (enter 0 to 100 inclusive)");
                continue;
            }
        sMarks.set(chosenI, newMark);
            break;
        } while (true);
        System.out.println("--- New (updated) records");
        printRecord(chosenI);
    }

   /**
    * show marks for a student or all of them
    * 
    * @param displayAll display all student records
    */
   private void marksMenu(boolean displayAll) {
      if (!displayAll) {
        int chosenI = chooseStudent("to view");
        if (chosenI !=-1)
        System.out.printf("Student mark: %.3f\n", sMarks.get(chosenI));
      } else {
         System.out.printf("Printing %d records:\n", names.size());
         if(!sorted){
            saveToOut();
         }
         loadFromOut();
         System.out.printf("Class Average: %.3f\n", classAverage());
      }
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
      System.out.println("=== Create Data \nYou will be prompted to input the names of all the students you wish to put in this class,\n"
         +"once you have done so, please enter an empty line to move to the next action prompt, \n"
         +"this section will be for student numbers, and finally there will be a section for \n"
         +"the average marks of each student");
      
      System.out.println("--- Input Names");
      int init = names.size();
      for (int i = init; true; i++) {
         System.out.printf("%d\tname> ", i);
         String line = s.nextLine();
         if (line.length() == 0)
            break;
         names.add(line.trim());
      }
      
      System.out.println("--- Input Student Numbers");
      for (int i = init; i < names.size(); i++) {
         System.out.printf("%d\tStudent number for %s> ", i, names.get(i));
         String line = s.nextLine();
         try {
            numbers.add(Integer.parseInt(line));
         } catch (NumberFormatException e) {
            System.out.println("--- invalid student index given, please only enter numbers between -2147483648 to 2147483647");
            i--;
         }
      }      
      getMarks("Student Marks", "M", sMarks, init);
            
      sorted = false; 
      saveToIn();
   }

   private void saveToIn() {
      try {
         FileWriter w = new FileWriter(IN_PATH);
         for (int i =0; i<names.size(); i++) {
            w.write(names.get(i) + " ");
            w.write(String.format("%d", numbers.get(i)) + " ");
            w.write(String.format("%.2f", sMarks.get(i)));
            w.write("\n");
         }      
         w.close();
      } catch (Exception e) {
         System.out.printf("--- save error: %s\n", e.getLocalizedMessage());
      }
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
            elements[i] = new String(new char[lengths[i]]).replaceAll("\\x00", " ").substring(values[i].length()) + values[i];
        return String.join(" ", elements);
    }

   private void saveToOut() {
      try (FileWriter wo = new FileWriter(OUT_PATH)) {
         /* stores the index of the longest name so that padding can be adjusted accordingly when printed to console and file */
         int longName = 0; 
         for(int i = 0; i<names.size(); i++){
            if((names.get(longName)).length() < ((names.get(i)).length())){
               longName = i; 
            }
         }

         int lengths[] = {longName, 6};
      
         /*iterates through the name and marks for loop and writes them into the out file in 2 columuns seperated by 5 space*/
         for (int i =0; i<names.size(); i++) {
            wo.write(formatRow(lengths, new String[]{
              names.get(i),
            String.format("%.2f", sMarks.get(i))
            })+"\n");
         }
      } catch (Exception e) {
         System.out.printf("--- save error: %s\n", e.getLocalizedMessage());
      }
   }
   
   /*
    * retrives data from the orginal file 
   */
   private void loadFromIn() {
      names.clear();
      numbers.clear(); 
      sMarks.clear(); 
      
      try {      
         FileReader fr = new FileReader(IN_PATH);
         Scanner s = new Scanner(fr);
         
         String [] raw;
         if(!s.hasNext()){
            System.out.println("There is no information in the file, please create data before using this method!");
         } 
         else
         {
            /* conti allows while to run until file has no more lines for it to read*/
            boolean conti = true;            
            while (conti) { 
               raw = s.nextLine().split(" ");        
               names.add(raw[0]);
               try{
                  numbers.add(Integer.parseInt(raw [1]));
                  sMarks.add(Double.parseDouble(raw [2]));
               } catch (NumberFormatException e){
               }
               
               if(!s.hasNext()){
                  conti=false;
               }
            } 
         }
         fr.close();
      } catch (IOException e) {
         System.out.printf("--- load error: %s\n", e.getLocalizedMessage());
      }
   }
   
   /**
    * loads data from user-edited data dump
    */
   private void loadFromOut() {
      names.clear();
      numbers.clear(); 
      sMarks.clear(); 
      try {
         FileReader fr = new FileReader(OUT_PATH);
         Scanner s = new Scanner(fr);
         
         String raw;
         if(s.hasNext()){
            /* conti allows while to run until file has no more lines for it to read*/
            boolean conti = true;
            
            while (conti) { 
               System.out.println(raw = s.nextLine());  
               if(!s.hasNext()){
                  conti=false;
               }
            } 
         }
         else {
            System.out.println("T-t try again");
            return; 
         }    
         fr.close();       
      } catch (IOException e) {
         System.out.printf("--- load error: %s\n", e.getLocalizedMessage());
      }
   }
   
   /**
    * Sorts the two arrays of names and marks by student name
    */
   private void sortByAlpha() {
      System.out.println("The data has now been sorted alphabetically by first name!"); 
      int passes = 0;
      while(passes < names.size()){
         while(passes < names.size()){
            String endName = names.get(0);
            for (int i = 1; i < names.size() - passes; i++){
               if (endName.compareTo(names.get(i)) < 0){
                  endName = names.get(i);
               }
            }
            selectandSwap(names.indexOf(endName), passes);
            passes++;
         }
      }
      sorted = true; 
      saveToOut(); 
   }
   
   /**
    * Sorts the two arrays of names and marks by grade. 
    */
   private void sortByNumber() {
      System.out.println("The data has now been sorted from highest average mark to lowest average mark!"); 
      int passes = 0;
      while (passes < sMarks.size()) {
         double largest = sMarks.get(0);
         for (int i = 1; i < sMarks.size() - passes; i++) {
            if (largest < sMarks.get(i)) {
               largest = sMarks.get(i);
            }
         }
         selectandSwap(sMarks.indexOf(largest), passes);
         passes++;
      }
      sorted = true; 
      saveToOut(); 
   }

   /**
    * Helper method which is used to move the element to the correct position
    */
   private void selectandSwap(int index, int passes) {
      String tmpName = names.get(index);
      double tmpMark = sMarks.get(index);
      int tmpNumber = numbers.get(index);
      names.remove(index);
      sMarks.remove(index);
      numbers.remove(index);
      names.add(names.size() - passes, tmpName);
      sMarks.add(sMarks.size() - passes, tmpMark);
      numbers.add(numbers.size() - passes, tmpNumber);
   }
   

    /**
     * Print short version of records for a single student
     *
     * @param i student index
     */
    private void printRecordShort(int i) {
        System.out.printf("Student Index %d\t(#%d)\t%s\n", i, numbers.get(i), names.get(i));
    }
}
