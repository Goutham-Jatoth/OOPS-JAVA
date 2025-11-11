import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Hashtable;

public class PhoneDirectorySwing extends JFrame implements ActionListener {

    JTextField txtSearch;
    JButton btnSearch, btnClear;
    JLabel lblResult;
    Hashtable<String, String> nameToPhone = new Hashtable<>();
    Hashtable<String, String> phoneToName = new Hashtable<>();

    PhoneDirectorySwing() {
        setTitle("Phone Directory Lookup");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(230, 240, 250));

        JLabel lblTitle = new JLabel("Phone Directory", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitle.setBounds(100, 30, 300, 30);
        add(lblTitle);

        JLabel lblEnter = new JLabel("Enter Name or Phone No:");
        lblEnter.setFont(new Font("Arial", Font.PLAIN, 16));
        lblEnter.setBounds(70, 90, 220, 30);
        add(lblEnter);

        txtSearch = new JTextField();
        txtSearch.setBounds(280, 90, 150, 30);
        add(txtSearch);

        btnSearch = new JButton("Search");
        btnSearch.setBounds(120, 150, 100, 30);
        add(btnSearch);

        btnClear = new JButton("Clear");
        btnClear.setBounds(260, 150, 100, 30);
        add(btnClear);

        lblResult = new JLabel("", SwingConstants.CENTER);
        lblResult.setFont(new Font("Arial", Font.BOLD, 15));
        lblResult.setBounds(50, 220, 400, 40);
        lblResult.setForeground(Color.BLUE);
        add(lblResult);

        // Button Listeners
        btnSearch.addActionListener(this);
        btnClear.addActionListener(this);

        // Load contacts from file
        loadContacts();

        setVisible(true);
    }

    // Load contacts from text file
    void loadContacts() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("Contacts.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    String phone = parts[1].trim();
                    nameToPhone.put(name, phone);
                    phoneToName.put(phone, name);
                }
            }
            br.close();
        } catch (IOException e) {
            lblResult.setText("Error reading Contacts.txt!");
            lblResult.setForeground(Color.RED);
        }
    }

    // Button actions
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch) {
            String input = txtSearch.getText().trim();

            if (input.isEmpty()) {
                lblResult.setText("Please enter a name or phone number!");
                lblResult.setForeground(Color.RED);
                return;
            }

            if (nameToPhone.containsKey(input)) {
                lblResult.setText("Phone Number: " + nameToPhone.get(input));
                lblResult.setForeground(new Color(0, 128, 0));
            } else if (phoneToName.containsKey(input)) {
                lblResult.setText("Name: " + phoneToName.get(input));
                lblResult.setForeground(new Color(0, 128, 0));
            } else {
                lblResult.setText("No record found for: " + input);
                lblResult.setForeground(Color.RED);
            }
        } else if (e.getSource() == btnClear) {
            txtSearch.setText("");
            lblResult.setText("");
        }
    }

    public static void main(String[] args) {
        new PhoneDirectorySwing();
    }
}