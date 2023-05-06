package GUIAssignment;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Task4Part3 implements ActionListener
{
    int choice = 0, size = 200;

    JButton square = new JButton("Square");
    JButton rectangle = new JButton("Rectangle");
    JButton circle = new JButton("Circle");
    JButton larger = new JButton("Larger");
    JButton smaller = new JButton("Smaller");

    Drawing draw = new Drawing();
    public Task4Part3()
    {
        JFrame frame = new JFrame("Draw Shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        square.addActionListener(this);
        rectangle.addActionListener(this);
        circle.addActionListener(this);
        larger.addActionListener(this);
        smaller.addActionListener(this);
        JPanel panel = new JPanel();
        panel.add(square);
        panel.add(rectangle);
        panel.add(circle);
        panel.add(larger);
        panel.add(smaller);
        frame.add(panel, "North");
        frame.add(draw);
        frame.setSize(500,500);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == square)
            choice = 1;
        else if (e.getSource() == rectangle)
            choice = 2;
        else if (e.getSource() == circle)
            choice = 3;
        else if (e.getSource() == larger)
            size += 5;
        else
            size -= 5;
        draw.repaint();
    }
    class Drawing extends JComponent
    {
        public void paint(Graphics g)
        {
            g.setColor(Color.red);
            if (choice == 1)
                g.fillRect((getWidth() - size - 100) / 2,(getHeight() - size - 100) / 2,size + 100,size + 100);
            else if (choice == 2)
                g.fillRect((getWidth() - size - 150) / 2,(getHeight() - size + 100) / 2,size + 150,size - 100);
            else if (choice == 3)
                g.fillOval((getWidth() - size) / 2,(getHeight() - size) / 2,size,size);
        }
    }
    public static void main(String[] args)
    {
        new Task4Part3();
    }
}
