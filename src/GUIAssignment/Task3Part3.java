package GUIAssignment;

import javax.swing.*;
import java.awt.*;

public class Task3Part3 {
    public Task3Part3() {
        JFrame frame = new JFrame("9.3 Question 3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        JPanel top = new JPanel(), bot = new JPanel();
        top.setLayout(new FlowLayout());
        bot.setLayout(new FlowLayout());
        top.add(new Button("top"));
        frame.add(top, BorderLayout.NORTH);
        bot.add(new Button("Yes"));
        bot.add(new Button("No"));
        bot.add(new Button("??"));
        frame.add(bot, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Task3Part3();
    }
}
