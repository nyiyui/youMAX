package GUIAssignment;

import javax.swing.*;
import java.awt.*;

public class Task3Part2 {
    public Task3Part2 (){
        JFrame frame = new JFrame("9.3 Question 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(140, 70);
        frame.setLayout(new GridLayout(1, 3));
        frame.add(new Button("A"));
        frame.add(new Button("B"));
        frame.add(new Button("C"));
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Task3Part2();
    }
}
