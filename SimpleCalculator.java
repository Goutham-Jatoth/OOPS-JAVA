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
