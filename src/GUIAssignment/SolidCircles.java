package GUIAssignment;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;
import java.util.Random;

public class SolidCircles {
    private static SpinnerNumberModel num;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Exercise 9.6-3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 1));
        Circles c =new Circles();
        c.setMinimumSize(new Dimension(500, 500));
        num = new SpinnerNumberModel(1,1,Integer.MAX_VALUE,1);
        JSpinner num2 = new JSpinner(num);
        num.addChangeListener(e -> c.repaint());
        frame.add(new JLabel("Please enter a positive number below!"));
        frame.add(num2);
        frame.add(c);
        frame.pack();
        frame.setVisible(true);
    }
    static class Circles extends JComponent{
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int v = (Integer) num.getValue();
            for (int i = 0; i < v; i++) {
                g.setColor(new Color(new Random().nextInt(0xffffff)));
                g.fillOval(new Random().nextInt(getSize().width),new Random().nextInt(getSize().height),10,10);
            }
        }
    }
}
