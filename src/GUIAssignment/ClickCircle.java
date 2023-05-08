package GUIAssignment;

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class ClickCircle extends JPanel
        implements MouseMotionListener, MouseListener {
    static final String NEWLINE = System.getProperty("line.separator");
    Visualiser output;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Exercise 9.5-2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JComponent newContentPane = new ClickRect();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
    }

    public ClickCircle() {
        super(new GridLayout(1, 0));
        addMouseListener(this);
        addMouseMotionListener(this);
        setPreferredSize(new Dimension(500, 500));
        output = new Visualiser();
        add(output);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (output.state) {
            case 0:
                output.startX = e.getX();
                output.startY = e.getY();
                break;
            case 1:
                output.endX = e.getX();
                output.endY = e.getY();
                break;
        }
        output.state++;
        output.state %= 2;
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
        if (output.state != 1) return;
        output.endX = e.getX();
        output.endY = e.getY();
        output.repaint();
    }

    class Visualiser extends JComponent {
        /**
         * state of selection
         * 0 - selected / selecting start
         * 1 - selecting end
         */
        int state = 0;
        int startX;
        int startY;
        int endX;
        int endY;

        @Override
        protected void paintComponent(Graphics g) {
            switch (state) {
                case 0:
                    g.setColor(new Color(0x137a7f));
                    break;
                case 1:
                    g.setColor(new Color(0xbec8d177, true));
                    break;
            }
            int x1 = Math.min(startX,endX);
            int x2 = Math.max(startX,endX);
            int y1 = Math.min(startY,endY);
            int y2 = Math.max(startY,endY);
            g.drawOval(x1, y1,x2-x1,y2-y1);
        }
    }
}
