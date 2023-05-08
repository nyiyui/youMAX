package GUIAssignment;

import javax.swing.*;
import java.awt.*;

public class SimpleCalculator extends JFrame {
    /*
     * operation to do.
     * 0 - add
     * 1 - subtract
     * 2 - multiply
     * 3 - divide
     */
    private int operation = 0;

    private JSpinner field1;
    private JSpinner field2;
    private JTextField fieldR;

    SimpleCalculator() {
        super("A Simple Calculator");
        setupUi();
    }

    void setupUi() {
        // Qt moment
        setLayout(new FlowLayout());
        JComponent form = new JPanel();
        form.setLayout(new GridLayout(3, 2));
        form.add(new JLabel("First Value"));
        field1 = new JSpinner();
        form.add(field1);
        form.add(new JLabel("Second Value"));
        field2 = new JSpinner();
        form.add(field2);
        form.add(new JLabel("Result"));
        fieldR = new JTextField();
        fieldR.setEditable(false);
        form.add(fieldR);
        JComponent operations = new JPanel();
        JButton add = new JButton("+");
        add.addActionListener(e -> {
            operation = 0;
            recalc();
        });
        JButton sub = new JButton("-");
        sub.addActionListener(e -> {
            operation = 1;
            recalc();
        });
        JButton mul = new JButton("*");
        mul.addActionListener(e -> {
            operation = 2;
            recalc();
        });
        JButton div = new JButton("/");
        div.addActionListener(e -> {
            operation = 3;
            recalc();
        });
        operations.add(add);
        operations.add(sub);
        operations.add(mul);
        operations.add(div);
        add(form);
        add(operations);
        pack();
    }

    void recalc() {
        int res=-1;
        int v1 = (int)field1.getValue();
        int v2 = (int)field2.getValue();
        switch (operation) {
            case 0:res=v1+v2;break;
            case 1:res=v1-v2;break;
            case 2:res=v1*v2;break;
            case 3:res=v1/v2;break;
            default:
                assert false;
        }
        fieldR.setText(String.format("%d",res));
    }

    public static void main(String[] args) {
        SimpleCalculator sc = new SimpleCalculator();
        sc.setVisible(true);
    }
}