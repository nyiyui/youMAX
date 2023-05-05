package GUIAssignment;

import javax.swing.*;
import java.awt.*;

public class Task2Part2 {
    public Task2Part2() {
        JFrame frame = new JFrame("9.2 Question 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.add(new Painting());
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Task2Part2();
    }

    public class Painting extends JComponent {
        public void paint(Graphics g) {
            g.setColor(Color.green);
            g.drawRect(150, 25, 100, 100);
            g.setColor(Color.red);
            g.drawLine(150, 25, 150, 125);
            g.drawLine(250,25, 250, 125);
        }
    }
}
