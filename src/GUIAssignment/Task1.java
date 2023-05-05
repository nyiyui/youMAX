package GUIAssignment;


import java.awt.*;
import javax.swing.*;

public class Task1 {

    public Task1() {
        JFrame frame = new JFrame("Envelope");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 300);
        frame.add(new Address());
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Task1();
    }

    public class Address extends JComponent {
        public void paint(Graphics g) {
            g.setColor(new Color(220, 30, 240));
            g.setFont(new Font("AdobeDevanagari", Font.BOLD, 30));
            g.drawString("Youmax Lee", 300, 110);
            g.drawString("69 And I'm Like So Tru Avenue", 170, 170);
        }
    }
}


