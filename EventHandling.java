import java.awt.*;
import java.awt.event.*;

public class EventHandling extends Frame implements ActionListener {

    Label lblTitle, lblName, lblRoll, lblDept, lblGender, lblCourse, lblMsg;
    TextField txtName, txtRoll;
    Choice deptChoice, courseChoice;
    CheckboxGroup genderGroup;
    Checkbox male, female;
    Button btnRegister, btnClear;

    EventHandling() {
        // --- Frame Setup ---
        setTitle("Student Registration Form");
        setSize(500, 500);
        setLayout(null);
        setBackground(new Color(230, 240, 250));

        // --- Title Label ---
        lblTitle = new Label("Student Registration Form");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 25));
        lblTitle.setBounds(140, 50, 250, 25);
        add(lblTitle);

        // --- Name ---
        lblName = new Label("Name:");
        lblName.setBounds(100, 100, 100, 25);
        add(lblName);

        txtName = new TextField();
        txtName.setBounds(220, 100, 150, 25);
        add(txtName);

        // --- Roll No ---
        lblRoll = new Label("Roll No:");
        lblRoll.setBounds(100, 140, 100, 25);
        add(lblRoll);

        txtRoll = new TextField();
        txtRoll.setBounds(220, 140, 150, 25);
        add(txtRoll);

        // --- Department ---
        lblDept = new Label("Department:");
        lblDept.setBounds(100, 180, 100, 25);
        add(lblDept);

        deptChoice = new Choice();
        deptChoice.add("CSE");
        deptChoice.add("ECE");
        deptChoice.add("EEE");
        deptChoice.add("MECH");
        deptChoice.add("CIVIL");
        deptChoice.setBounds(220, 180, 150, 25);
        add(deptChoice);

        // --- Gender ---
        lblGender = new Label("Gender:");
        lblGender.setBounds(100, 220, 100, 25);
        add(lblGender);

        genderGroup = new CheckboxGroup();
        male = new Checkbox("Male", genderGroup, false);
        female = new Checkbox("Female", genderGroup, false);

        male.setBounds(220, 220, 60, 25);
        female.setBounds(290, 220, 70, 25);
        add(male);
        add(female);

        // --- Course Choice ---
        lblCourse = new Label("Course:");
        lblCourse.setBounds(100, 260, 100, 25);
        add(lblCourse);

        courseChoice = new Choice();
        courseChoice.add("Java");
        courseChoice.add("Python");
        courseChoice.add("C++");
        courseChoice.add("Web Development");
        courseChoice.setBounds(220, 260, 150, 25);
        add(courseChoice);

        // --- Buttons ---
        btnRegister = new Button("Register");
        btnRegister.setBounds(140, 320, 100, 30);
        add(btnRegister);

        btnClear = new Button("Clear");
        btnClear.setBounds(260, 320, 100, 30);
        add(btnClear);

        // --- Message Label ---
        lblMsg = new Label("");
        lblMsg.setBounds(100, 370, 350, 60);
        lblMsg.setForeground(Color.blue);
        add(lblMsg);

        // --- Add Event Listeners ---
        btnRegister.addActionListener(this);
        btnClear.addActionListener(this);

        // --- Window Close Operation ---
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    // ----- Handle Events -----
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegister) {
            String name = txtName.getText();
            String roll = txtRoll.getText();
            String dept = deptChoice.getSelectedItem();
            String course = courseChoice.getSelectedItem();
            Checkbox selectedGender = genderGroup.getSelectedCheckbox();
            String gender = (selectedGender != null) ? selectedGender.getLabel() : "Not Selected";

            if (name.isEmpty() || roll.isEmpty()) {
                lblMsg.setText("Please fill all required fields!");
                lblMsg.setForeground(Color.red);
            } else {
                lblMsg.setForeground(Color.green);
                lblMsg.setText("Registered Successfully!\n" +
                        " Name: " + name +
                        " | Roll No: " + roll +
                        " | Dept: " + dept +
                        " | Gender: " + gender +
                        " | Course: " + course);
            }
        } else if (e.getSource() == btnClear) {
            txtName.setText("");
            txtRoll.setText("");
            genderGroup.setSelectedCheckbox(null);
            deptChoice.select(0);
            courseChoice.select(0);
            lblMsg.setText("");
        }
    }

    // ----- Main Method -----
    public static void main(String[] args) {
        new EventHandling();
    }
}