/**
 * OOP Exercise 1: Creating Objects - Question 2
 * <p>
 * Course: ICS3U0
 * Teacher: Ms. Krasteva
 * Created: 2023-02-09
 * Purpose: Implementation of question 2.
 *
 * @author nyiyui (Ken Shibata)
 */
package CreatingObjects;

public class CreatingObjects {
    /**
     * Does the contents of question 2 on the worksheet.
     * <p>
     * a) For the Student class create an array of 5 student objects
     * b) Using a different array of size 10 ensure the 5 original Students objects are transferred to the new array.
     * c) Fill in a new Student object at position 8 inside the array.
     * d) Write a for-loop to calculate the average of all students and print out all the information in the array of  Student objects.
     *
     * @param args command-line arguments (ignored)
     */
    public static void main(String[] args) {
        // a) For the Student class create an array of 5 student objects
        Student[] students = new Student[5];
        students[0] = new Student("John Doe");
        students[1] = new Student("Example Name");
        students[2] = new Student("Patchouli Knowledge");
        students[3] = new Student("Reimu Hakurei");
        students[4] = new Student("Flandre Scarlet");
        // b) Using a different array of size 10 ensure the 5 original Students objects are transferred to the new array.
        Student[] moreStudents = new Student[10];
        System.arraycopy(students, 0, moreStudents, 0, students.length);
        // c) Fill in a new Student object at position 8 inside the array.
        moreStudents[7] = new Student("Sakuya Izayoi");
        // d) Write a for-loop to calculate the average of all students and print out all the information in the array of  Student objects.
        for (Student s : moreStudents) {
            if (s == null) continue;
            s.calcAverage();
            System.out.println(s.message());
        }
    }
}
