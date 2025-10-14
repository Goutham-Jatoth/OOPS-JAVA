// import java.awt.*; 
// import java.awt.event.*; 
// import java.applet.Applet; 
// /*<applet code="Fact.class" height=300 width=300></applet>*/ 
// public class Factorialapplet extends Applet implements ActionListener{ 
// Label l1,l2; 
// TextField t1,t2; 
// Button b1; 
// public void init(){ 
// l1=new Label("Enter any integer value: "); 
// add(l1); 
// t1=new TextField(5); 
// add(t1); 
// b1=new Button("Calculate"); 
// add(b1); 
// b1.addActionListener(this); 
// l2=new Label("Factorial of given integer number is "); 
// add(l2); 
// t2=new TextField(10); 
// add(t2); 
// } 
// public void actionPerformed(ActionEvent e){ 
// if(e.getSource()==b1){ 
// int fact=fact(Integer.parseInt(t1.getText())); 
// t2.setText(String.valueOf(fact)); 
// } 
// } 
// int fact(int f) 
// { 
// int s=0; if(f==0) 
// return 1; 
// else 
// return f*fact(f-1); 
// } 
// } 




// File: FactorialSwingApp.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class factorialapplet extends JFrame implements ActionListener {
    private JTextField txtInput, txtResult;
    private JButton btnCompute;

    public factorialapplet() {
        // Set title and layout
        setTitle("Factorial Calculator");
        setLayout(new GridLayout(3, 2, 10, 10)); // 3 rows, 2 columns, spacing 10px

        // Create labels, text fields, and button
        JLabel lblInput = new JLabel("Enter a number:");
        JLabel lblResult = new JLabel("Factorial:");
        txtInput = new JTextField();
        txtResult = new JTextField();
        txtResult.setEditable(false);
        btnCompute = new JButton("Compute");

        // Add components to frame
        add(lblInput);
        add(txtInput);
        add(lblResult);
        add(txtResult);
        add(new JLabel()); // empty cell for spacing
        add(btnCompute);

        // Add event listener
        btnCompute.addActionListener(this);

        // Frame settings
        setSize(350, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int n = Integer.parseInt(txtInput.getText());
            if (n < 0) {
                txtResult.setText("Invalid (negative)");
                return;
            }

            long fact = 1;
            for (int i = 1; i <= n; i++) {
                fact *= i;
            }

            txtResult.setText(String.valueOf(fact));
        } catch (NumberFormatException ex) {
            txtResult.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        new factorialapplet();
    }

}
















import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FactorialGUI extends JFrame implements ActionListener {
    JTextField t1, t2;
    JButton b;

    public FactorialGUI() {
        setTitle("Factorial Calculator");
        setSize(350, 200);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Enter any integer value:"));
        t1 = new JTextField(10);
        add(t1);

        b = new JButton("Calculate");
        add(b);
        b.addActionListener(this);

        add(new JLabel("Factorial value is:"));
        t2 = new JTextField(10);
        t2.setEditable(false);
        add(t2);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int n = Integer.parseInt(t1.getText());
        int fact = 1;
        for (int i = 1; i <= n; i++)
            fact *= i;
        t2.setText(String.valueOf(fact));
    }

    public static void main(String[] args) {
        new FactorialGUI();
    }
}
