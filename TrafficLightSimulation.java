import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TrafficLightSimulation extends JFrame implements ActionListener {

    // Radio buttons for color selection
    JRadioButton redButton, yellowButton, greenButton;
    // Label for displaying message
    JLabel messageLabel;
    // Panel to draw the traffic light
    DrawPanel drawPanel;

    // Variable to store current color choice
    String selectedColor = "";

    public TrafficLightSimulation() {
        setTitle("Traffic Light Simulation");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Message Label
        messageLabel = new JLabel("", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 22));
        add(messageLabel, BorderLayout.NORTH);

        // Draw panel (custom inner class)
        drawPanel = new DrawPanel();
        add(drawPanel, BorderLayout.CENTER);

        // Radio buttons
        redButton = new JRadioButton("Red");
        yellowButton = new JRadioButton("Yellow");
        greenButton = new JRadioButton("Green");

        // Group buttons so only one can be selected
        ButtonGroup group = new ButtonGroup();
        group.add(redButton);
        group.add(yellowButton);
        group.add(greenButton);

        // Add ActionListeners
        redButton.addActionListener(this);
        yellowButton.addActionListener(this);
        greenButton.addActionListener(this);

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(redButton);
        buttonPanel.add(yellowButton);
        buttonPanel.add(greenButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == redButton) {
            selectedColor = "RED";
            messageLabel.setText("STOP");
            messageLabel.setForeground(Color.RED);
        } else if (e.getSource() == yellowButton) {
            selectedColor = "YELLOW";
            messageLabel.setText("READY");
            messageLabel.setForeground(Color.ORANGE);
        } else if (e.getSource() == greenButton) {
            selectedColor = "GREEN";
            messageLabel.setText("GO");
            messageLabel.setForeground(Color.GREEN);
        }
        drawPanel.repaint(); // Repaint the light panel
    }

    // Inner class for drawing traffic light
    class DrawPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Draw traffic light outline
            g.setColor(Color.BLACK);
            g.fillRect(100, 50, 100, 220);

            // Draw three circles (Red, Yellow, Green)
            // Red Light
            g.setColor(selectedColor.equals("RED") ? Color.RED : Color.DARK_GRAY);
            g.fillOval(125, 60, 50, 50);

            // Yellow Light
            g.setColor(selectedColor.equals("YELLOW") ? Color.YELLOW : Color.DARK_GRAY);
            g.fillOval(125, 130, 50, 50);

            // Green Light
            g.setColor(selectedColor.equals("GREEN") ? Color.GREEN : Color.DARK_GRAY);
            g.fillOval(125, 200, 50, 50);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TrafficLightSimulation().setVisible(true);
        });
    }
}