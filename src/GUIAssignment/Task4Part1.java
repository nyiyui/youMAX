package GUIAssignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Task4Part1 implements ActionListener {
    JButton on = new JButton("On");
    JButton off = new JButton("Off");
    JFrame f;
    public Task4Part1(){
        f = new JFrame("9.4 Question 1");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 400);
        f.setResizable(false);
        f.setLayout(new FlowLayout());
        on.addActionListener(this);
        off.addActionListener(this);
        f.add(on);
        f.add(off);
        f.setVisible(true);
    }
    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == on)
            f.getContentPane().setBackground(Color.white);
        else if (e.getSource() == off)
            f.getContentPane().setBackground(Color.black);
    }

    public static void main(String[] args) {
        new Task4Part1();
    }
}
