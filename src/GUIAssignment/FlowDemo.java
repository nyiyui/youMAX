package GUIAssignment;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlowDemo extends JFrame {
    public FlowDemo(String s) {
        super(s);
    }

    public static void main(String[] args) {
        JFrame frame = new FlowDemo("Exercise 9.4-1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        JButton on = new JButton("On");
        on.addActionListener(e -> frame.getContentPane().setBackground(Color.WHITE));
        JButton off = new JButton("Off");
        off.addActionListener(e -> frame.getContentPane().setBackground(Color.BLACK));
        frame.add(on);
        frame.add(off);

        frame.pack();
        frame.setVisible(true);
    }
}
