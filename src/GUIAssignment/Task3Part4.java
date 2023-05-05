package GUIAssignment;

import javax.swing.*;
import java.awt.*;

public class Task3Part4 {
    public Task3Part4 (){
        JFrame f = new JFrame("9.3 Question 4");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(200, 200);
        f.setLayout(new GridLayout(2, 2));
        f.add(new Circle(Color.red));
        f.add(new Circle(f.getBackground()));
        f.add(new Circle(f.getBackground()));
        f.add(new Circle(Color.red));
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new Task3Part4();
    }
    public class Circle extends JComponent {
        private Color color;
        public Circle(Color c){
            color = c;
        }
        public void paint(Graphics g){
            g.setColor(color);
            g.fillOval(0, 0, getWidth(), getHeight());
        }
    }
}
