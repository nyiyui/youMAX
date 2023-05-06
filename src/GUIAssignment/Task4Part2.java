package GUIAssignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Task4Part2 implements ActionListener {
    JFrame frame;
    JButton changeColor;
    Color bg = new Color(241, 186, 207);
    Color flower = Color.white;
    Color text = new Color(255, 120, 140);
    Color border = new Color(80, 150, 100);
    int ctr;
    Card card = new Card();

    public Task4Part2() {
        ctr = 0;
        frame = new JFrame("9.2 Question 4");
        changeColor = new JButton("Change Colour");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(500, 700);
        changeColor.addActionListener(this);
        frame.add(changeColor, BorderLayout.NORTH);
        frame.add(card, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Task4Part2();
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == changeColor && ctr % 2 == 0){
            bg = new Color(220, 180, 255);
            border = new Color(50, 50, 150);
            flower = Color.red;
            text = new Color(150, 20, 150);
        }
        else {
            bg = new Color(241, 186, 207);
            flower = Color.white;
            text = new Color(255, 120, 140);
            border = new Color(80, 150, 100);
        }
        ctr = (ctr+1) % 2;
        card.repaint();
    }

    public class Card extends JComponent {
        public void paint(Graphics g) {
            g.setColor(bg);
            g.fillRect(0, 0, 500, 700);

            g.setColor(border);
            g.fillOval(90, 140, 320, 320);

            g.setColor(Color.white);
            g.fillOval(100, 150, 300, 300);

            g.setColor(text);
            g.setFont(new Font("Blackadder ITC", Font.BOLD, 50));
            g.drawString("Happy", 180, 250);
            g.drawString("Mother's", 150, 325);
            g.drawString("Day", 200, 400);


            for (int x = 65; x < 500; x += 150) {
                g.setColor(flower);

                g.fillOval(x, 20, 20, 20);
                g.fillOval(x, 40, 20, 20);
                g.fillOval(x + 20, 20, 20, 20);
                g.fillOval(x + 20, 40, 20, 20);

                g.fillOval(x, 590, 20, 20);
                g.fillOval(x, 610, 20, 20);
                g.fillOval(x + 20, 590, 20, 20);
                g.fillOval(x + 20, 610, 20, 20);

                g.setColor(new Color(250, 210, 90));
                g.fillOval(x + 10, 30, 20, 20);
                g.fillOval(x + 10, 600, 20, 20);
            }
        }
    }
}
