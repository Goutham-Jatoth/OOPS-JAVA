import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame implements ActionListener {
    JTextField textField;
    double num1, num2, result;
    char operator;

    public SimpleCalculator() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textField = new JTextField();
        textField.setEditable(false);
        add(textField, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        String[] buttons = {
            "7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "*",
            "0", "%", "C", "="
        };

        for (String b : buttons) {
            JButton button = new JButton(b);
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String input = e.getActionCommand();

        if (input.matches("[0-9]")) {
            textField.setText(textField.getText() + input);
        } else if (input.matches("[+\\-\\*%]")) {
            num1 = Double.parseDouble(textField.getText());
            operator = input.charAt(0);
            textField.setText("");
        } else if (input.equals("=")) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '%':
                    if (num2 == 0) {
                        textField.setText("Error");
                        return;
                    }
                    result = num1 % num2; break;
            }
            textField.setText(String.valueOf(result));
        } else if (input.equals("C")) {
            textField.setText("");
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}





























import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorGUI extends JFrame implements ActionListener {
    JTextField display;
    int v1, v2, result;
    char op;

    public CalculatorGUI() {
        setTitle("Calculator");
        setSize(300, 400);
        setLayout(new GridLayout(5, 4, 5, 5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        display = new JTextField();
        display.setEditable(false);
        add(display);

        String[] buttons = {
            "7","8","9","/",
            "4","5","6","*",
            "1","2","3","-",
            "0","%","=","+",
            "Clear"
        };

        for (String text : buttons) {
            JButton b = new JButton(text);
            b.addActionListener(this);
            add(b);
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();

        // If digit, append to display
        if (str.matches("\\d")) {
            display.setText(display.getText() + str);
        }
        // If operator, store first value and operator
        else if ("+-*/%".contains(str)) {
            v1 = Integer.parseInt(display.getText());
            op = str.charAt(0);
            display.setText("");
        }
        // Equals button
        else if (str.equals("=")) {
            v2 = Integer.parseInt(display.getText());
            switch (op) {
                case '+': result = v1 + v2; break;
                case '-': result = v1 - v2; break;
                case '*': result = v1 * v2; break;
                case '/': result = v1 / v2; break;
                case '%': result = v1 % v2; break;
            }
            display.setText(String.valueOf(result));
        }
        // Clear button
        else if (str.equals("Clear")) {
            display.setText("");
        }
    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }
}
