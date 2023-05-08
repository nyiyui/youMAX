package GUIAssignment;

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class ClickColinear extends JPanel implements MouseMotionListener, MouseListener {
    ColinearVisualiser output;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Exercise 9.8-4");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JComponent newContentPane = new ClickColinear();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
    }

    public ClickColinear() {
        super(new GridLayout(1, 0));
        addMouseListener(this);
        addMouseMotionListener(this);
        setPreferredSize(new Dimension(500, 500));
        output = new ColinearVisualiser();
        add(output);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (output.state) {
            case -1:
                output.state++;
            case 0:
                output.x1 = e.getX();
                output.y1 = e.getY();
                break;
            case 1:
                output.x2 = e.getX();
                output.y2 = e.getY();
                break;
            case 2:
                output.x3 = e.getX();
                output.y3 = e.getY();
                break;
        }
        output.state++;
        output.state %= 3;
        output.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (output.state != 2) return;
        output.x3 = e.getX();
        output.y3 = e.getY();
        output.repaint();
    }

    class ColinearVisualiser extends JComponent {
        /**
         * state of selection
         * 0 - selected / selecting 1st
         * 1 - selecting 2nd
         * 2 - selecting 2nd
         */
        int state = -1;
        int x1;
        int y1;
        int x2;
        int y2;
        int x3;
        int y3;

        @Override
        protected void paintComponent(Graphics g) {
            Color circleColor;
            switch (state) {
                case 0:
                    circleColor=new Color(0x137a7f);
                    break;
                case 2:
                    circleColor=Color.GRAY;
                    break;
                default:
                    return;
            }
            g.drawString("1", x1, y1);
            g.drawString("2", x2, y2);
            g.drawString("3", x3, y3);
            double x12 = (x1 + x2) / 2.0;
            double y12 = (y1 + y2) / 2.0;
            double x32 = (x3 + x2) / 2.0;
            double y32 = (y3 + y2) / 2.0;
            g.setColor(Color.BLUE);
            double m1 = -1.0 * ((double) (x1 - x2)) / ((double) (y1 - y2)); // y-y12=m1(x-x12)
            double m2 = -1.0 * ((double) (x3 - x2)) / ((double) (y3 - y2));
            // find equations of perpendicular bisectors of lines 12 and 32
            // m1x-m1x12+y12=m2x-m2x32+y32
            // x(m1-m2)=-m2x32+y32+m1x12-y12
            double cx = (-m2 * x32 + y32 + m1 * x12 - y12) / (m1 - m2);
            double cy = m1 * (cx - x12) + y12;
            double d1 = Math.max(Math.max(Math.abs(x12-cx),Math.abs(x12-x1)),Math.abs(x12-x2));
            double d2 = Math.max(Math.max(Math.abs(x32-cx),Math.abs(x32-x3)),Math.abs(x32-x2));
            g.drawLine((int) (x12 - d1), (int) ( y12 - d1 * m1), (int) (x12 + d1), (int) ( y12 + d1 * m1));
            g.drawLine((int) (x32 - d2), (int) ( y32 - d2 * m2), (int) (x32 + d2), (int) ( y32 + d2* m2));
            g.drawString("centre", (int) cx, (int) cy);
            g.setColor(circleColor);
            double r = Math.sqrt(Math.abs(cx - x1) * Math.abs(cx - x1) + Math.abs(cy - y1) * Math.abs(cy - y1));
            g.drawOval((int) (cx - r), (int) (cy - r), (int) r * 2, (int) r * 2);
            // Although slightly different, two slopes may be similar enough that calculations result in NaN values.
            // Assume these NaN values only come from sufficiently-similar m1 and m2 values.
            if (m1 == m2 || Double.isNaN(r)) {
                g.drawString("You selected three colinear points!", getWidth() / 2, getHeight() / 2);
                System.out.println("colinear");
            }
        }
    }
}
