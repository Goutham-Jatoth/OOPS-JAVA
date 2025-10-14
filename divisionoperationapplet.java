// import java.awt.*; 
// import java.awt.event.*; 
// import java.applet.*; 
 
// /*<applet code="DivisionExample"width=230 height=250></applet>*/ 
 
// public class divisionoperationapplet extends Applet implements ActionListener { 
// String msg; 
// TextField num1, num2, res; 
// Label l1, l2, l3; 
// Button div; 
 
// public void init() { 
// l1 = new Label("Dividend"); 
// l2 = new Label("Divisor"); 
// l3 = new Label("Result"); 
// num1 = new TextField(10); 
// num2 = new TextField(10); 
// res = new TextField(10); 
// div = new Button("Click"); 
// div.addActionListener(this); 
// add(l1); 
// add(num1); 
// add(l2); 
// add(num2); 
// add(l3); 
// add(res); 
// add(div); 
// } 
 
// public void actionPerformed(ActionEvent ae) { 
// String arg = ae.getActionCommand(); 
// int num1 = 0, num2 = 0; 
// if (arg.equals("Click")) { 
// if (this.num1.getText().isEmpty() | this.num2.getText().isEmpty()) 
// { 
// msg = "Enter the valid numbers!"; 
// repaint(); 
// } else { 
// try { 
// num1 = Integer.parseInt(this.num1.getText()); 
// num2 = Integer.parseInt(this.num2.getText()); 
 
// int num3 = num1 / num2; 
// res.setText(String.valueOf(num3)); 
// msg = "Operation Succesfull!!!"; 
// repaint(); 
// } catch (NumberFormatException ex) { 
// System.out.println(ex); 
// res.setText(""); 
// msg = "NumberFormatException - Non-numeric"; 
// repaint(); 
// } catch (ArithmeticException e) { 
// System.out.println("Can't be divided by Zero" + e); 
// res.setText(""); 
// msg = "Can't be divided by Zero"; 
// repaint(); 
// } 
// } 
// } 
// } 
 
// public void paint(Graphics g) { 
// g.drawString(msg, 30, 70); 
// } 
// }














// File: DivisionSwingApp.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class divisionoperationapplet extends JFrame implements ActionListener {
    private JTextField txtNum1, txtNum2, txtResult;
    private JButton btnDivide;

    public divisionoperationapplet() {
        // Set title and layout
        setTitle("Integer Division");
        setLayout(new GridLayout(4, 2, 10, 10)); // rows, cols, hgap, vgap

        // Create labels and text fields
        JLabel lblNum1 = new JLabel("Enter Num1:");
        JLabel lblNum2 = new JLabel("Enter Num2:");
        JLabel lblResult = new JLabel("Result:");
        txtNum1 = new JTextField();
        txtNum2 = new JTextField();
        txtResult = new JTextField();
        txtResult.setEditable(false); // result is output only

        // Create button
        btnDivide = new JButton("Divide");

        // Add components to frame
        add(lblNum1); add(txtNum1);
        add(lblNum2); add(txtNum2);
        add(lblResult); add(txtResult);
        add(new JLabel()); // empty label for spacing
        add(btnDivide);

        // Add event listener
        btnDivide.addActionListener(this);

        // Frame settings
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center window
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Read inputs
            int num1 = Integer.parseInt(txtNum1.getText());
            int num2 = Integer.parseInt(txtNum2.getText());

            // Perform division
            int result = num1 / num2;

            // Display result
            txtResult.setText(String.valueOf(result));

        } catch (NumberFormatException ex) {
            // When user enters a non-integer value
            JOptionPane.showMessageDialog(this, 
                "Please enter valid integers!", 
                "Number Format Error", 
                JOptionPane.ERROR_MESSAGE);
            txtResult.setText("");
        } catch (ArithmeticException ex) {
            // When user tries to divide by zero
            JOptionPane.showMessageDialog(this, 
                "Cannot divide by zero!", 
                "Arithmetic Error", 
                JOptionPane.ERROR_MESSAGE);
            txtResult.setText("");
        }
    }

    public static void main(String[] args) {
        new divisionoperationapplet();
    }
}