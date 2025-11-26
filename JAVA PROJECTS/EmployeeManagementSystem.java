// Employee Management System - Single File Version (Java Swing)
// Fixed version with correct string literals

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.*;
import java.util.*;
import java.util.regex.*;

// ------------------ Employee Class ------------------
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    int id;
    String name, department, designation, email, phone, photoPath;
    double salary;
    LocalDate dateOfJoining;
    ArrayList<String> leaveHistory = new ArrayList<>();

    public Employee(int id, String name, String department, String designation,
                    double salary, LocalDate dateOfJoining, String email,
                    String phone, String photoPath) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
        this.dateOfJoining = dateOfJoining;
        this.email = email;
        this.phone = phone;
        this.photoPath = photoPath;
    }

    public String toCSV() {
        return String.format("%d,%s,%s,%s,%.2f,%s,%s,%s,%s", id, name, department,
                designation, salary, dateOfJoining, email, phone, photoPath);
    }
}

// ------------------ Employee Manager ------------------
class EmployeeManager {
    ArrayList<Employee> employees = new ArrayList<>();
    int nextId = 1;
    File storeFile;

    public EmployeeManager(File f) {
        storeFile = f;
        load();
        for (Employee e : employees) if (e.id >= nextId) nextId = e.id + 1;
    }

    void save() {
        try (ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(storeFile))) {
            o.writeObject(employees);
        } catch (Exception ignored) {}
    }

    void load() {
        if (!storeFile.exists()) return;
        try (ObjectInputStream o = new ObjectInputStream(new FileInputStream(storeFile))) {
            employees = (ArrayList<Employee>) o.readObject();
        } catch (Exception ignored) {}
    }

    Employee add(String name, String dept, String desig, double sal, LocalDate doj,
                 String email, String phone, String photo) {
        Employee e = new Employee(nextId++, name, dept, desig, sal, doj, email, phone, photo);
        employees.add(e);
        save();
        return e;
    }

    void delete(Employee e) { employees.remove(e); save(); }

    void importCSV(File f) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line = br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");
                employees.add(new Employee(
                        Integer.parseInt(p[0]), p[1], p[2], p[3], Double.parseDouble(p[4]),
                        LocalDate.parse(p[5]), p[6], p[7], p.length > 8 ? p[8] : ""
                ));
            }
        }
        save();
    }

    void exportCSV(File f) throws Exception {
        try (PrintWriter pw = new PrintWriter(new FileWriter(f))) {
            pw.println("id,name,department,designation,salary,dateOfJoining,email,phone,photoPath");
            for (Employee e : employees) pw.println(e.toCSV());
        }
    }
}

// ------------------ Table Model ------------------
class EmployeeTableModel extends AbstractTableModel {
    String[] cols = {"ID","Name","Department","Designation","Salary","Date","Email","Phone"};
    java.util.List<Employee> list;

    public EmployeeTableModel(java.util.List<Employee> l) { list = l; }

    public int getRowCount() { return list.size(); }
    public int getColumnCount() { return cols.length; }
    public String getColumnName(int c) { return cols[c]; }
    public Object getValueAt(int r, int c) {
        Employee e = list.get(r);
        switch (c) {
            case 0: return e.id;
            case 1: return e.name;
            case 2: return e.department;
            case 3: return e.designation;
            case 4: return e.salary;
            case 5: return e.dateOfJoining;
            case 6: return e.email;
            case 7: return e.phone;
        }
        return "";
    }

    Employee get(int r) { return list.get(r); }
}

// ------------------ Main GUI ------------------
public class EmployeeManagementSystem extends JFrame {
    EmployeeManager manager = new EmployeeManager(new File("employees.dat"));
    EmployeeTableModel model = new EmployeeTableModel(manager.employees);
    JTable table = new JTable(model);
    JTextField searchField = new JTextField(20);

    public EmployeeManagementSystem() {
        super("Employee Management System - Single File Version");
        setSize(950,550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton add = new JButton("Add");
        JButton edit = new JButton("Edit");
        JButton del = new JButton("Delete");
        JButton imp = new JButton("Import");
        JButton exp = new JButton("Export");
        JButton leaveBtn = new JButton("Request Leave");
        JButton leaveHistoryBtn = new JButton("Leave History");

        top.add(add); top.add(edit); top.add(del); top.add(imp); top.add(exp); top.add(leaveBtn); top.add(leaveHistoryBtn);

        JPanel searchPanel = new JPanel();
        JButton go = new JButton("Search");
        searchPanel.add(new JLabel("Search:")); searchPanel.add(searchField); searchPanel.add(go);

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(table));
        add(searchPanel, BorderLayout.SOUTH);

        add.addActionListener(e -> openForm(null));
        edit.addActionListener(e -> editSelected());
        del.addActionListener(e -> deleteSelected());
        go.addActionListener(e -> search());

        imp.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            fc.setFileFilter(new FileNameExtensionFilter("CSV","csv"));
            if (fc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION) try {
                manager.importCSV(fc.getSelectedFile()); refresh();
            } catch (Exception ex) { JOptionPane.showMessageDialog(this,"Import failed"); }
        });

        exp.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            if (fc.showSaveDialog(this)==JFileChooser.APPROVE_OPTION) try {
                manager.exportCSV(fc.getSelectedFile());
            } catch (Exception ex) { JOptionPane.showMessageDialog(this,"Export failed"); }
        });

        leaveBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) { JOptionPane.showMessageDialog(this, "Select an employee first"); return; }
            row = table.convertRowIndexToModel(row);
            Employee emp = model.get(row);

            JDialog ld = new JDialog(this, "Leave Request", true);
            ld.setLayout(new GridLayout(4,2,5,5));
            JTextField days = new JTextField();
            JTextField reason = new JTextField();
            JButton submit = new JButton("Submit Request");
            ld.add(new JLabel("Number of Days:")); ld.add(days);
            ld.add(new JLabel("Reason:")); ld.add(reason);
            ld.add(new JLabel("")); ld.add(submit);
            submit.addActionListener(ev -> {
                String entry = LocalDate.now() + " - Leave Approved: " + days.getText() + " days | Reason: " + reason.getText();
                emp.leaveHistory.add(entry);
                manager.save();
                ld.dispose();
                JOptionPane.showMessageDialog(this,
                    "Your leave has been sanctioned as per your request.\nEnjoy your approved time off!",
                    "Leave Approved",
                    JOptionPane.INFORMATION_MESSAGE);
            });
            ld.pack(); ld.setLocationRelativeTo(this); ld.setVisible(true);
        });

        leaveHistoryBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) { JOptionPane.showMessageDialog(this, "Select an employee first"); return; }
            row = table.convertRowIndexToModel(row);
            Employee emp = model.get(row);
            JTextArea area = new JTextArea();
            for (String h : emp.leaveHistory) area.append(h + "\n");
            area.setEditable(false);
            JOptionPane.showMessageDialog(this, new JScrollPane(area), emp.name + " - Leave History", JOptionPane.INFORMATION_MESSAGE);
        });
    }

    void refresh() { model.fireTableDataChanged(); }

    void search() {
        String q = searchField.getText().trim().toLowerCase();
        TableRowSorter<EmployeeTableModel> s = new TableRowSorter<>(model);
        table.setRowSorter(s);
        if (q.isEmpty()) { s.setRowFilter(null); return; }
        s.setRowFilter(RowFilter.regexFilter("(?i)"+Pattern.quote(q)));
    }

    void editSelected() {
        int row = table.getSelectedRow();
        if (row == -1) { JOptionPane.showMessageDialog(this,"Select a row"); return; }
        row = table.convertRowIndexToModel(row);
        openForm(model.get(row));
    }

    void deleteSelected() {
        int row = table.getSelectedRow();
        if (row == -1) return;
        row = table.convertRowIndexToModel(row);
        Employee e = model.get(row);
        manager.delete(e); refresh();
    }

    void openForm(Employee emp) {
        JDialog d = new JDialog(this, emp==null?"Add Employee":"Edit Employee", true);
        d.setLayout(new GridLayout(10,2,5,5));
        JTextField name = new JTextField();
        JTextField dept = new JTextField();
        JTextField des = new JTextField();
        JTextField sal = new JTextField();
        JTextField doj = new JTextField("2024-01-01");
        JTextField email = new JTextField();
        JTextField phone = new JTextField();
        JTextField photo = new JTextField();
        JButton browse = new JButton("Browse");

        if (emp != null) {
            name.setText(emp.name);
            dept.setText(emp.department);
            des.setText(emp.designation);
            sal.setText(String.valueOf(emp.salary));
            doj.setText(emp.dateOfJoining.toString());
            email.setText(emp.email);
            phone.setText(emp.phone);
            photo.setText(emp.photoPath);
        }

        browse.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            if (fc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
                photo.setText(fc.getSelectedFile().getAbsolutePath());
        });

        d.add(new JLabel("Name:")); d.add(name);
        d.add(new JLabel("Department:")); d.add(dept);
        d.add(new JLabel("Designation:")); d.add(des);
        d.add(new JLabel("Salary:")); d.add(sal);
        d.add(new JLabel("Date (yyyy-mm-dd):")); d.add(doj);
        d.add(new JLabel("Email:")); d.add(email);
        d.add(new JLabel("Phone:")); d.add(phone);
        d.add(new JLabel("Photo:")); d.add(photo);
        d.add(new JLabel("")); d.add(browse);

        JButton save = new JButton("Save");
        d.add(save);
        save.addActionListener(e -> {
            try {
                double salary = Double.parseDouble(sal.getText());
                LocalDate date = LocalDate.parse(doj.getText());

                if (emp == null) manager.add(name.getText(), dept.getText(), des.getText(), salary,
                        date, email.getText(), phone.getText(), photo.getText());
                else {
                    emp.name=name.getText(); emp.department=dept.getText(); emp.designation=des.getText();
                    emp.salary=salary; emp.dateOfJoining=date;
                    emp.email=email.getText(); emp.phone=phone.getText(); emp.photoPath=photo.getText();
                    manager.save();
                }
                refresh(); d.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(d,"Invalid data");
            }
        });

        d.pack(); d.setLocationRelativeTo(this); d.setVisible(true);
    }

    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch (Exception ignored) {}
        new EmployeeManagementSystem().setVisible(true);
    }
}