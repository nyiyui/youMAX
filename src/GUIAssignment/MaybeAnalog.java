package GUIAssignment;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class MaybeAnalog extends JFrame {
    SpinnerNumberModel hours;
    SpinnerNumberModel minutes;
    Clock clock;
    private static final int MARGIN = 10;

    MaybeAnalog() {
        hours = new SpinnerNumberModel(0, 0, 23, 1);
        hours.addChangeListener(e -> clock.repaint());
        minutes = new SpinnerNumberModel(0, 0, 59, 1);
        minutes.addChangeListener(e -> clock.repaint());
        clock = new Clock();
        setNow();
        // this is when I realised the analog clock *was* right, it *was* 3:29.
    }

    private void setNow() {
        hours.setValue(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
        minutes.setValue(Calendar.getInstance().get(Calendar.MINUTE));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Exercise 9.8-5");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 1));
        MaybeAnalog c = new MaybeAnalog();
        JPanel form = new JPanel();
        c.setMinimumSize(new Dimension(500, 500));
        JSpinner hours = new JSpinner(c.hours);
        JSpinner minutes = new JSpinner(c.minutes);
        form.setLayout(new GridLayout(2, 2));
        form.add(new JLabel("Hours"));
        form.add(hours);
        form.add(new JLabel("Minutes"));
        form.add(minutes);
        frame.add(form);
        frame.add(c.clock);
        frame.setVisible(true);
    }

    private class Clock extends JComponent {
        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(Color.BLACK);
            int dim = Math.min(getWidth(), getHeight()) - 2 * MARGIN;
            int c = dim / 2;
            double m = ((int) minutes.getValue()) / 60.0;
            double h = (((int) hours.getValue()) % 12) / 12.0 + m / 12;
            g.drawOval(MARGIN, MARGIN, dim, dim);
            g.drawLine(c, c, (int) (c + (dim / 3) * Math.cos(h * 2 * Math.PI - Math.PI / 2)), (int) (c + (dim / 3) * Math.sin(h * 2 * Math.PI - Math.PI / 2)));
            g.drawLine(c, c, (int) (c + (dim * 2 / 5) * Math.cos(m * 2 * Math.PI - Math.PI / 2)), (int) (c + (dim * 2 / 5) * Math.sin(m * 2 * Math.PI - Math.PI / 2)));
        }
    }
}
