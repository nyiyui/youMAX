package GUIAssignment;

import javax.swing.*;
import java.awt.*;

public class ModifiedMothersDay {
    public ModifiedMothersDay(){
        JFrame frame = new JFrame("9.2 Question 4");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 700);
        frame.setLayout(new GridLayout(2,0));
        Card card = new Card();
        frame.add(card);
        JButton changeButton = new JButton("Change Text");
        changeButton.addActionListener(e -> {
            card.showText1=!card.showText1;
            card.repaint();
        });
        frame.add(changeButton);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ModifiedMothersDay();
    }
    public class Card extends JComponent {
        boolean showText1 = true;
        public void paint(Graphics g) {
            g.setColor(new Color(241, 186, 207));
            g.fillRect(0, 0, 500, 700);

            g.setColor(new Color(80, 150, 100));
            g.fillOval(90, 140, 320, 320);

            g.setColor(Color.white);
            g.fillOval(100, 150, 300, 300);

            g.setColor(new Color(255, 120, 140));
            // Java moment: write once, debug everywhere due to abstractions glossing over font loading differences
            if (showText1) {
                g.setFont(new Font("Blackadder ITC", Font.BOLD, 50));
                g.drawString("Happy", 180, 250);
                g.drawString("Mother's", 150, 325);
                g.drawString("Day", 200, 400);
            }else{
                g.setFont(new Font("Blackadder ITC", Font.ITALIC, 50));
                g.drawString("Happy", 180, 250);
                g.drawString("Mother's", 150, 325);
                g.drawString("Day!", 200, 400);
            }


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
