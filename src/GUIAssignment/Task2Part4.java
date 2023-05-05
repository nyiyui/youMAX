package GUIAssignment;

import javax.swing.*;
import java.awt.*;

public class Task2Part4 {
    public Task2Part4(){
        JFrame frame = new JFrame("9.2 Question 4");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 700);
        frame.add(new Card());
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Task2Part4();
    }
    public class Card extends JComponent {
        public void paint(Graphics g) {
            g.setColor(new Color(241, 186, 207));
            g.fillRect(0, 0, 500, 700);

            g.setColor(new Color(80, 150, 100));
            g.fillOval(90, 140, 320, 320);

            g.setColor(Color.white);
            g.fillOval(100, 150, 300, 300);

            g.setColor(new Color(255, 120, 140));
            g.setFont(new Font("Blackadder ITC", Font.BOLD, 50));
            g.drawString("Happy", 180, 250);
            g.drawString("Mother's", 150, 325);
            g.drawString("Day", 200, 400);


            for (int x=65;x<500;x+=150){
                g.setColor(Color.white);

                g.fillOval(x, 20, 20, 20);
                g.fillOval(x, 40, 20, 20);
                g.fillOval(x+20, 20, 20, 20);
                g.fillOval(x+20, 40, 20, 20);

                g.fillOval(x, 590, 20, 20);
                g.fillOval(x, 610, 20, 20);
                g.fillOval(x+20, 590, 20, 20);
                g.fillOval(x+20, 610, 20, 20);

                g.setColor(new Color(250, 210, 90));
                g.fillOval(x+10, 30, 20, 20);
                g.fillOval(x+10, 600, 20, 20);
            }
        }
    }
}
