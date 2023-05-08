package GUIAssignment;

import javax.swing.*;
import java.awt.*;

public class Quadrants extends JFrame {
    Quadrants() {
        super("Exercise 9.8-2");
        setSize(500, 400); // NOTE: not respected by some e.g. tiling WMs
        setLayout(new GridLayout(3, 3));
        add(new Quadrant2());
        add(new JLabel());
        add(new Quadrant1());
        add(new JLabel());
        add(new Centre());
        add(new JLabel());
        add(new Quadrant3());
        add(new JLabel());
        add(new Quadrant4());
    }

    class Quadrant1 extends JComponent {
        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(Color.MAGENTA);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.BLACK);
            g.setFont(new Font("SfansSerif", Font.PLAIN, 20));
            g.drawString("John", getWidth() / 2, getHeight() / 2);
        }
    }

    class Quadrant2 extends JComponent {
        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(Color.BLUE);
            int dim = Math.min(getWidth(), getHeight());
            g.fillOval(0, 0, dim, dim);
            g.setColor(Color.WHITE);
            // write once, debug everywhere
            g.setFont(new Font("Monospaced", Font.PLAIN, 20));
            g.drawString("Kayla", getWidth() / 4, getHeight() / 2);
        }
    }

    class Quadrant3 extends JComponent {
        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(Color.RED);
            g.setXORMode(Color.WHITE); // sorry dark mode people
            final int margin = 10;
            int dim = Math.min(getWidth(), getHeight());
            g.fillRect(0, 0, dim, dim);
            g.fillRect(margin, margin, dim - 2 * margin, dim - 2 * margin);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Serif", Font.PLAIN, 20));
            g.drawString("Orwell", getWidth() / 4, getHeight() / 2);
        }
    }

    class Quadrant4 extends JComponent {
        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(Color.CYAN);
            g.setXORMode(Color.WHITE);
            final int margin = 10;
            g.fillOval(0, 0, getWidth(), getHeight());
            g.fillOval(margin, margin, getWidth() - 2 * margin, getHeight() - 2 * margin);
            g.setColor(Color.BLACK);
            g.setFont(new Font("SansSerif", Font.ITALIC, 20));
            g.drawString("Thomas", getWidth() / 3, getHeight() / 2);
        }
    }

    class Centre extends JComponent {
        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(Color.YELLOW);
            g.fillPolygon(new int[]{0, getWidth(), getWidth() / 2,}, new int[]{getHeight(), getHeight(), 0,}, 3);
            g.setColor(Color.BLACK);
            g.setFont(new Font("SansSerif", Font.BOLD + Font.ITALIC, 20));
            g.drawString("Vaughn", getWidth() / 3, getHeight() * 3 / 4);
        }
    }

    public static void main(String[] args) {
        Quadrants q = new Quadrants();
        q.setVisible(true);
    }
}
