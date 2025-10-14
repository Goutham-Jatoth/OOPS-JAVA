// import java.awt.*; 
// import java.applet.*; 
// /* <applet code="Applet1" width=200 height=300></applet>*/ 
// public class Simplemessageapplet extends Applet 
// { 
// // Paint method to display the message. 
// public void paint(Graphics g) 
// { 
// g.drawString("Hello World!",20,20); 
// } 
// } 







// File: SimpleMessageApp.java
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Simplemessageapplet {
    public static void main(String[] args) {
        // Create a window (JFrame)
        JFrame frame = new JFrame("Simple Message App");

        // Create a label to display the message
        JLabel label = new JLabel("Hello, Welcome to Java Swing!", SwingConstants.CENTER);

        // Add the label to the frame
        frame.add(label);

        // Set frame size
        frame.setSize(400, 200);

        // Close the program when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the frame visible
        frame.setVisible(true);
    }
}