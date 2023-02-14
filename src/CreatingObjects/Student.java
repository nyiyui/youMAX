/**
 * OOP Exercise 1: Creating Objects - Student
 * <p>
 * Course: ICS3U0
 * Teacher: Ms. Krasteva
 * Created: 2023-02-09
 * Purpose: Objects representing a Student with two marks.
 *
 * @author Ms. Krasteva
 */
package CreatingObjects;

public class Student {
    public String name;
    public int mark1;
    public int mark2;
    public double average;

    /**
     * Creates 5 instances of Student and runs each of the instance methods.
     *
     * @param args ignored command-line arguments
     */
    public static void main(String[] args) {
        Student[] students = new Student[5];
        students[0] = new Student("John Doe");
        students[1] = new Student("Example Name");
        students[2] = new Student("Patchouli Knowledge");
        students[3] = new Student("Reimu Hakurei");
        students[4] = new Student("Flandre Scarlet");
        for (Student s : students) {
            s.setMarks(1, 1);
            s.calcAverage();
            System.out.println(s.message());
        }
    }

    /**
     * Initialises a Student with their name. THeir marks are all unset.
     *
     * @param n student name
     */
    public Student(String n) {
        name = n;
        mark1 = 0;
        mark2 = 0;
        average = 0.0;
    }

    /**
     * sets the marks for this Student.
     *
     * @param x 1st mark
     * @param y 2nd mark
     */
    public void setMarks(int x, int y) {
        mark1 = x;
        mark2 = y;
    }

    /**
     * calculates the average and puts the result in the average attribute.
     */
    public void calcAverage() {
        average = (mark1 + mark2) / 2.0; // changed from /2 to not truncate double
    }

    /**
     * returns a String with a message to the student with their average mark.
     *
     * @return message with name and average mark
     */
    public String message() {
        return name + ", you got an average mark of " + average + "."; // edited for grammar
    }
} // CreatingObjects.Student class
