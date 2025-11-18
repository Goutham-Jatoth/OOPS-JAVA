// import javax.swing.*;
// public class SwingExample {
//     public static void main(String[] args) {
//         JFrame f = new JFrame("Swing Frame");
//         f.setSize(300,200);
//         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         f.setVisible(true);
//     }
// }





// import javax.swing.*;
// public class SwingExample {
//     public static void main(String[] args) {
//         JFrame f = new JFrame("Label Demo");
//         JLabel l = new JLabel("Hello Swing Label!");
//         f.add(l);
//         f.setSize(300,200);
//         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         f.setVisible(true);
//     }
// }




// import javax.swing.*;
// public class SwingExample {
//     public static void main(String[] args) {
//         JFrame f = new JFrame("Button Demo");
//         JButton b = new JButton("Click Me");
//         f.add(b);
//         f.setSize(300,200);
//         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         f.setVisible(true);
//     }
// }





// import javax.swing.*;
// import java.awt.*;
// public class SwingExample {
//     public static void main(String[] args) {
//         JFrame f = new JFrame("Panel Demo");
//         JPanel p = new JPanel();
//         p.add(new JButton("OK"));
//         p.add(new JButton("Cancel"));
//         f.add(p);
//         f.setSize(300,200);
//         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         f.setVisible(true);
//     }
// }



// import javax.swing.*;
// public class SwingExample {
//     public static void main(String[] args) {
//         JFrame f = new JFrame("ScrollPane Demo");
//         JTextArea ta = new JTextArea(10, 30);
//         JScrollPane sp = new JScrollPane(ta);
//         f.add(sp);
//         f.setSize(400,250);
//         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         f.setVisible(true);
//     }
// }



// import javax.swing.*;
// public class SwingExample {
//     public static void main(String[] args) {
//         JFrame f = new JFrame("Text Demo");
//         JTextField tf = new JTextField("Enter Name : ", 20);
//         JTextArea ta = new JTextArea(5, 20);
//         f.add(tf, "North");
//         f.add(new JScrollPane(ta), "Center");
//         f.setSize(300,200);
//         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         f.setVisible(true);
//     }
// }




// import javax.swing.*;
// public class SwingExample {
//     public static void main(String[] args) {
//         JFrame f = new JFrame("Checkbox Demo");
//         JCheckBox c1 = new JCheckBox("Java");
//         JCheckBox c2 = new JCheckBox("Python");
//         JPanel p = new JPanel();
//         p.add(c1);
//         p.add(c2);
//         f.add(p);
//         f.setSize(300,200);
//         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         f.setVisible(true);
//     }
// }



// import javax.swing.*;
// public class SwingExample {
//     public static void main(String[] args) {
//         JFrame f = new JFrame("Radio Button Demo");
//         JRadioButton r1 = new JRadioButton("Male");
//         JRadioButton r2 = new JRadioButton("Female");
//         ButtonGroup bg = new ButtonGroup();
//         bg.add(r1);
//         bg.add(r2);
//         JPanel p = new JPanel();
//         p.add(r1);
//         p.add(r2);
//         f.add(p);
//         f.setSize(300,200);
//         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         f.setVisible(true);
//     }
// }



// import javax.swing.*;
// public class SwingExample {
//     public static void main(String[] args) {
//         JFrame f = new JFrame("ComboBox Demo");
//         JComboBox<String> cb = new JComboBox<>();
//         cb.addItem("Red");
//         cb.addItem("Green");
//         cb.addItem("Blue");
//         f.add(cb);
//         f.setSize(250,150);
//         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         f.setVisible(true);
//     }
// }



// import javax.swing.*;
// public class SwingExample {
//     public static void main(String[] args) {
//         JFrame f = new JFrame("List Demo");
//         String fruits[] = {"Apple", "Banana", "Orange"};
//         JList<String> list = new JList<>(fruits);
//         f.add(new JScrollPane(list));
//         f.setSize(250,180);
//         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         f.setVisible(true);
//     }
// }



// import javax.swing.*;
// public class SwingExample {
//     public static void main(String[] args) {
//         JFrame f = new JFrame("Main Window");
//         JDialog d = new JDialog(f, "Dialog Box", true);
//         d.add(new JLabel("This is a dialog!"));
//         d.setSize(200,100);
//         f.setSize(300,200);
//         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         f.setVisible(true);
//         d.setVisible(true);
//     }
// }



// import javax.swing.*;
// public class SwingExample {
//     public static void main(String[] args) {
//         JFrame f = new JFrame("Menu Demo");
//         JMenuBar mb = new JMenuBar();
//         JMenu file = new JMenu("File");
//         file.add(new JMenuItem("New"));
//         file.add(new JMenuItem("Open"));
//         file.add(new JMenuItem("Exit"));
//         mb.add(file);
//         f.setJMenuBar(mb);
//         f.setSize(300,200);
//         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         f.setVisible(true);
//     }
// }


// import javax.swing.*;
// import java.awt.*;
// public class SwingExample extends JPanel {
//     public void paintComponent(Graphics g) {
//         super.paintComponent(g);
//         g.drawString("Swing Graphics", 50, 50);
//         g.drawRect(60, 70, 100, 50);
//         g.drawOval(80, 150, 80, 80);
//     }
//     public static void main(String[] args) {
//         JFrame f = new JFrame("Graphics Demo");
//         f.add(new SwingExample());
//         f.setSize(300,300);
//         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         f.setVisible(true);
//     }
// }



// import javax.swing.*;
// import java.awt.*;
// public class SwingExample {
//     public static void main(String[] args) {
//         JFrame f = new JFrame("FlowLayout");
//         f.setLayout(new FlowLayout());
//         f.add(new JButton("One"));
//         f.add(new JButton("Two"));
//         f.add(new JButton("Three"));
//         f.setSize(300,150);
//         f.setVisible(true);
//         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//     }
// }



// import javax.swing.*;
// import java.awt.*;
// public class SwingExample {
//     public static void main(String[] args) {
//         JFrame f = new JFrame("BorderLayout");
//         f.add(new JButton("North"), BorderLayout.NORTH);
//         f.add(new JButton("South"), BorderLayout.SOUTH);
//         f.add(new JButton("East"), BorderLayout.EAST);
//         f.add(new JButton("West"), BorderLayout.WEST);
//         f.add(new JButton("Center"), BorderLayout.CENTER);
//         f.setSize(300,200);
//         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         f.setVisible(true);
//     }
// }




// import javax.swing.*;
// import java.awt.*;
// public class SwingExample {
//     public static void main(String[] args) {
//         JFrame f = new JFrame("GridLayout");
//         f.setLayout(new GridLayout(2, 3));
//         for (int i = 1; i <= 6; i++)
//             f.add(new JButton("Button " + i));
//         f.setSize(300,200);
//         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         f.setVisible(true);
//     }
// }



// import javax.swing.*;
// import java.awt.*;
// public class SwingExample {
//     public static void main(String[] args) {
//         JFrame f = new JFrame("CardLayout");
//         JPanel p = new JPanel(new CardLayout());
//         p.add("Card1", new JButton("Card One"));
//         p.add("Card2", new JButton("Card Two"));
//         CardLayout cl = (CardLayout)p.getLayout();
//         cl.next(p); // Show next card
//         f.add(p);
//         f.setSize(300,200);
//         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         f.setVisible(true);
//     }
// }



// import javax.swing.*;
// import java.awt.*;
// public class SwingExample {
//     public static void main(String[] args) {
//         JFrame f = new JFrame("GridBagLayout");
//         f.setLayout(new GridBagLayout());
//         GridBagConstraints gbc = new GridBagConstraints();
//         gbc.gridx = 0; gbc.gridy = 0;
//         f.add(new JButton("Button 1"), gbc);
//         gbc.gridx = 1;
//         f.add(new JButton("Button 2"), gbc);
//         gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2;
//         f.add(new JButton("Wide Button"), gbc);
//         f.setSize(300,200);
//         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         f.setVisible(true);
//     }
// }