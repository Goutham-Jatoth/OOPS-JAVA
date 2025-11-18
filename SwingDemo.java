import javax.swing.*;
import java.awt.*;

public class SwingDemo extends JFrame {

    // Constructor
    public SwingDemo() {

        // -------- Frame Settings --------
        setTitle("Full Swing Components Demo");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        // --------- TOP PANEL (FlowLayout) ----------
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(new JLabel("Name:"));
        topPanel.add(new JTextField(10));
        topPanel.add(new JButton("Submit"));
        add(topPanel, BorderLayout.NORTH);


        // --------- LEFT PANEL (GridLayout) ----------
        JPanel leftPanel = new JPanel(new GridLayout(5,1));

        leftPanel.add(new JCheckBox("Java"));
        leftPanel.add(new JCheckBox("Python"));

        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        ButtonGroup bg = new ButtonGroup();
        bg.add(male); bg.add(female);

        leftPanel.add(male);
        leftPanel.add(female);

        add(leftPanel, BorderLayout.WEST);


        // --------- RIGHT PANEL (ComboBox + List) ----------
        JPanel rightPanel = new JPanel(new GridLayout(2,1));

        JComboBox<String> cb = new JComboBox<>();
        cb.addItem("Red");
        cb.addItem("Green");
        cb.addItem("Blue");

        rightPanel.add(cb);

        String fruits[] = {"Apple","Banana","Orange","Grapes"};
        JList<String> list = new JList<>(fruits);

        rightPanel.add(new JScrollPane(list));

        add(rightPanel, BorderLayout.EAST);


        // --------- CENTER PANEL (TextArea + ScrollPane + CardLayout) ----------

        JPanel centerCardPanel = new JPanel(new CardLayout());

        JTextArea ta = new JTextArea("This is a JTextArea.\nYou can type here...");
        centerCardPanel.add("TextArea", new JScrollPane(ta));

        // Graphic Panel
        JPanel graphicPanel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawString("Graphics Drawing Example", 20, 20);
                g.drawRect(50, 40, 100, 60);
                g.drawOval(200, 40, 80, 80);
            }
        };
        centerCardPanel.add("Graphics", graphicPanel);

        add(centerCardPanel, BorderLayout.CENTER);


        // --------- CARD SWITCH BUTTON ----------
        JButton switchCardBtn = new JButton("Switch Cards");
        switchCardBtn.addActionListener(e -> {
            CardLayout cl = (CardLayout) centerCardPanel.getLayout();
            cl.next(centerCardPanel);
        });

        add(switchCardBtn, BorderLayout.SOUTH);


        // --------- MENU BAR ----------
        JMenuBar mb = new JMenuBar();
        JMenu file = new JMenu("File");
        file.add(new JMenuItem("New"));
        file.add(new JMenuItem("Open"));
        file.add(new JMenuItem("Exit"));
        mb.add(file);
        setJMenuBar(mb);


        setVisible(true);
    }


    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {
        new SwingDemo();
    }
}