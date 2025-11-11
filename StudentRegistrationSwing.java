import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistrationSwing extends JFrame implements ActionListener {

    JLabel lblTitle, lblName, lblRoll, lblDept, lblGender, lblCourse, lblMsg;
    JTextField txtName, txtRoll;
    JComboBox<String> deptCombo, courseCombo;
    JRadioButton male, female;
    ButtonGroup genderGroup;
    JButton btnRegister, btnClear;

    StudentRegistrationSwing() {
        // --- Frame Setup ---
        setTitle("Student Registration Form (Swing)");
        setSize(500, 500);
        setLayout(null);
        getContentPane().setBackground(new Color(230, 240, 250));

        // --- Title ---
        lblTitle = new JLabel("Student Registration Form");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitle.setBounds(100, 40, 350, 30);
        add(lblTitle);

        // --- Name ---
        lblName = new JLabel("Name:");
        lblName.setBounds(100, 100, 100, 25);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(220, 100, 150, 25);
        add(txtName);

        // --- Roll No ---
        lblRoll = new JLabel("Roll No:");
        lblRoll.setBounds(100, 140, 100, 25);
        add(lblRoll);

        txtRoll = new JTextField();
        txtRoll.setBounds(220, 140, 150, 25);
        add(txtRoll);

        // --- Department ---
        lblDept = new JLabel("Department:");
        lblDept.setBounds(100, 180, 100, 25);
        add(lblDept);

        String[] departments = {"CSE", "ECE", "EEE", "MECH", "CIVIL"};
        deptCombo = new JComboBox<>(departments);
        deptCombo.setBounds(220, 180, 150, 25);
        add(deptCombo);

        // --- Gender ---
        lblGender = new JLabel("Gender:");
        lblGender.setBounds(100, 220, 100, 25);
        add(lblGender);

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        male.setBounds(220, 220, 70, 25);
        female.setBounds(300, 220, 80, 25);
        male.setBackground(new Color(230, 240, 250));
        female.setBackground(new Color(230, 240, 250));

        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        add(male);
        add(female);

        // --- Course ---
        lblCourse = new JLabel("Course:");
        lblCourse.setBounds(100, 260, 100, 25);
        add(lblCourse);

        String[] courses = {"Java", "Python", "C++", "Web Development"};
        courseCombo = new JComboBox<>(courses);
        courseCombo.setBounds(220, 260, 150, 25);
        add(courseCombo);

        // --- Buttons ---
        btnRegister = new JButton("Register");
        btnRegister.setBounds(140, 320, 100, 30);
        add(btnRegister);

        btnClear = new JButton("Clear");
        btnClear.setBounds(260, 320, 100, 30);
        add(btnClear);

        // --- Message Label ---
        lblMsg = new JLabel("");
        lblMsg.setBounds(100, 370, 350, 60);
        lblMsg.setForeground(Color.BLUE);
        add(lblMsg);

        // --- Add Listeners ---
        btnRegister.addActionListener(this);
        btnClear.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // ----- Handle Events -----
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegister) {
            String name = txtName.getText().trim();
            String roll = txtRoll.getText().trim();
            String dept = (String) deptCombo.getSelectedItem();
            String course = (String) courseCombo.getSelectedItem();
            String gender = male.isSelected() ? "Male" : (female.isSelected() ? "Female" : "Not Selected");

            if (name.isEmpty() || roll.isEmpty()) {
                lblMsg.setText("⚠ Please fill all required fields!");
                lblMsg.setForeground(Color.RED);
            } else {
                lblMsg.setForeground(new Color(0, 128, 0));
                lblMsg.setText("<html>✅ Registered Successfully!<br>Name: " + name +
                        " | Roll: " + roll +
                        " | Dept: " + dept +
                        " | Gender: " + gender +
                        " | Course: " + course + "</html>");
            }
        } else if (e.getSource() == btnClear) {
            txtName.setText("");
            txtRoll.setText("");
            genderGroup.clearSelection();
            deptCombo.setSelectedIndex(0);
            courseCombo.setSelectedIndex(0);
            lblMsg.setText("");
        }
    }

    // ----- Main Method -----
    public static void main(String[] args) {
        new StudentRegistrationSwing();
    }
}