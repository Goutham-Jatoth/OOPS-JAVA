import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseAdaptarSwing extends JFrame {
    JLabel label;

    MouseAdaptarSwing() {
        setTitle("Mouse Adapter Example");
        setSize(300, 200);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("Click to see message");
        label.setBounds(80, 60, 180, 25);
        add(label);

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                label.setText("Mouse clicked using Adapter!");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new MouseAdaptarSwing();
    }
}