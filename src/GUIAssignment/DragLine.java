package GUIAssignment;

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class DragLine extends JPanel
        implements MouseMotionListener, MouseListener {
    static final String NEWLINE = System.getProperty("line.separator");
    Visualiser output;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Exercise 9.5-1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JComponent newContentPane = new ClickRect();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
    }

    public DragLine() {
        super(new GridLayout(1, 0));
        addMouseMotionListener(this);
        addMouseListener(this);
        setPreferredSize(new Dimension(500, 500));
        output = new Visualiser();
        add(output);
    }

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
//        System.out.printf("dragged %d %d\n", e.getX(), e.getY());
        output.endX = e.getX();
        output.endY = e.getY();
        output.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        System.out.printf("pressed %d %d\n", e.getX(), e.getY());
        output.startX = e.getX();
        output.startY = e.getY();
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

    class Visualiser extends JComponent {
        int startX;
        int startY;
        int endX;
        int endY;

        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(new Color(0x137a7f));
            g.drawLine(startX, startY, endX, endY);
        }
    }
}
