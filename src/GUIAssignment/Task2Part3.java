package GUIAssignment;

import javax.swing.*;
import java.awt.*;

public class Task2Part3 {
    public Task2Part3() {
        JFrame frame = new JFrame("9.2 Question 3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.add(new Painting());
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Task2Part3();
    }

    public class Painting extends JComponent {
        public void paint(Graphics g) {
            g.drawRect(190, 90, 20, 20);

            int x1[] = {200, 220, 200, 180}, y1[] = {80, 100, 120, 100};
            g.drawPolygon(x1, y1, 4);

            g.drawRect(180, 80, 40, 40);

            int x2[] = {200, 240, 200, 160}, y2[] = {60, 100, 140, 100};
            g.drawPolygon(x2, y2, 4);

            g.drawRect(160,60,80,80);

            int x3[] = {200, 280, 200, 120}, y3[] = {20, 100, 180, 100};
            g.drawPolygon(x3, y3, 4);
        }
    }
}
