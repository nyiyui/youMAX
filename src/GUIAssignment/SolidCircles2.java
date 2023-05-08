package GUIAssignment;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SolidCircles2 {
    private static SpinnerNumberModel num;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Exercise 9.6-3 oops not 9.6, 9.8-6 (totally did not copy paste from that exercise)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 1));
        Circles c = new Circles();
        c.setMinimumSize(new Dimension(500, 500));
        num = new SpinnerNumberModel(2, 2, 100, 1);
        JSpinner num2 = new JSpinner(num);
        num.addChangeListener(e -> c.repaint());
        frame.add(new JLabel("Please enter a number n where 2 <= n <= 100 below!"));
        frame.add(num2);
        JButton b = new JButton("Regenerate");
        b.addActionListener(e -> c.repaint());
        frame.add(b);
        frame.add(c);
        frame.setVisible(true);
    }

    static class Circles extends JComponent {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int v = (Integer) num.getValue();
            for (int i = 0; i < v; i++) {
                g.setColor(new Color(new Random().nextInt(0xffffff)));
                g.fillOval(new Random().nextInt(getSize().width), new Random().nextInt(getSize().height), 4, 4);
            }
        }
    }
}
