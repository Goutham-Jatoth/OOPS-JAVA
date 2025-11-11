import javax.swing.*;
import java.awt.*;
import java.io.*;

public class DisplayTableGrid extends JFrame {

    DisplayTableGrid() {
        setTitle("Display Table from File");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new GridLayout(0, 1)); // rows auto-adjust

        try {
            File file = new File("Table.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                // Split by comma
                String[] columns = line.split(",");

                // Create a row panel with GridLayout (one row per line)
                JPanel rowPanel = new JPanel();
                rowPanel.setLayout(new GridLayout(1, columns.length, 10, 10));

                for (String col : columns) {
                    JLabel lbl = new JLabel(col.trim(), SwingConstants.CENTER);
                    lbl.setOpaque(true);
                    lbl.setBorder(BorderFactory.createLineBorder(Color.GRAY));

                    if (isHeader) {
                        lbl.setBackground(new Color(173, 216, 230)); // header color
                        lbl.setFont(new Font("Arial", Font.BOLD, 14));
                    } else {
                        lbl.setBackground(Color.WHITE);
                        lbl.setFont(new Font("Arial", Font.PLAIN, 13));
                    }
                    rowPanel.add(lbl);
                }

                panel.add(rowPanel);
                isHeader = false;
            }
            br.close();
        } catch (IOException e) {
            JLabel errorLabel = new JLabel("Error reading Table.txt", SwingConstants.CENTER);
            errorLabel.setForeground(Color.RED);
            panel.add(errorLabel);
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new DisplayTableGrid();
    }
}