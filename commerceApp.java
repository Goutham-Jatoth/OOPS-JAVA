import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

public class commerceApp extends JFrame implements ActionListener {
    private ArrayList<Product> products;
    private ArrayList<Product> cart;

    private JComboBox<String> productList;
    private JTextArea cartArea;
    private JButton addButton, removeButton, checkoutButton, clearButton;

    public commerceApp() {
        setTitle("🛒 Commerce App - Shopping System");
        setSize(700, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Initialize product list
        products = new ArrayList<>();
        products.add(new Product("Laptop", 55000));
        products.add(new Product("Smartphone", 25000));
        products.add(new Product("Headphones", 2000));
        products.add(new Product("Smartwatch", 5000));
        products.add(new Product("Keyboard", 1200));
        products.add(new Product("Mouse", 800));
        products.add(new Product("Power Bank", 1500));
        products.add(new Product("Camera", 30000));
        products.add(new Product("Bluetooth Speaker", 3500));
        products.add(new Product("Tablet", 18000));
        products.add(new Product("Gaming Console", 40000));
        products.add(new Product("LED TV", 45000));
        products.add(new Product("Shoes", 2500));
        products.add(new Product("Backpack", 1200));
        products.add(new Product("Sunglasses", 1800));
        products.add(new Product("Wrist Watch", 3500));
        products.add(new Product("Jacket", 4000));
        products.add(new Product("Jeans", 2200));
        products.add(new Product("Shirt", 1500));
        products.add(new Product("Perfume", 2800));

        cart = new ArrayList<>();

        // Top Panel: Product selection
        JPanel topPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        topPanel.add(new JLabel("Select Product:"));
        String[] productNames = new String[products.size()];
        for (int i = 0; i < products.size(); i++) {
            productNames[i] = products.get(i).name + " - ₹" + products.get(i).price;
        }
        productList = new JComboBox<>(productNames);
        topPanel.add(productList);

        addButton = new JButton("Add to Cart");
        addButton.addActionListener(this);
        topPanel.add(addButton);

        removeButton = new JButton("Remove Last Item");
        removeButton.addActionListener(this);
        topPanel.add(removeButton);

        add(topPanel, BorderLayout.NORTH);

        // Center Panel: Cart Area
        cartArea = new JTextArea();
        cartArea.setEditable(false);
        cartArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(cartArea);
        add(scrollPane, BorderLayout.CENTER);

        // Bottom Panel: Actions
        JPanel bottomPanel = new JPanel();
        checkoutButton = new JButton("Checkout");
        clearButton = new JButton("Clear Cart");

        checkoutButton.addActionListener(this);
        clearButton.addActionListener(this);

        bottomPanel.add(checkoutButton);
        bottomPanel.add(clearButton);

        add(bottomPanel, BorderLayout.SOUTH);

        updateCart();
        setVisible(true);
    }

    private void updateCart() {
        cartArea.setText("=========== CART ===========\n");
        double total = 0;
        if (cart.isEmpty()) {
            cartArea.append("Cart is empty!\n");
        } else {
            for (Product p : cart) {
                cartArea.append(p.name + " - ₹" + p.price + "\n");
                total += p.price;
            }
        }
        cartArea.append("\nTotal: ₹" + total + "\n");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            int index = productList.getSelectedIndex();
            if (index >= 0) {
                cart.add(products.get(index));
                updateCart();
            }
        } else if (e.getSource() == removeButton) {
            if (!cart.isEmpty()) {
                cart.remove(cart.size() - 1);
                updateCart();
            }
        } else if (e.getSource() == clearButton) {
            cart.clear();
            updateCart();
        } else if (e.getSource() == checkoutButton) {
            if (cart.isEmpty()) {
                JOptionPane.showMessageDialog(this, "❌ Cart is empty. Add items first!");
            } else {
                double total = 0;
                StringBuilder receipt = new StringBuilder("=========== RECEIPT ===========\n");
                for (Product p : cart) {
                    receipt.append(p.name).append(" - ₹").append(p.price).append("\n");
                    total += p.price;
                }
                receipt.append("\nTotal Amount: ₹").append(total).append("\n");
                receipt.append("Thank you for shopping! 🛍️");

                JOptionPane.showMessageDialog(this, receipt.toString(), "Receipt", JOptionPane.INFORMATION_MESSAGE);

                cart.clear();
                updateCart();
            }
        }
    }

    public static void main(String[] args) {
        new commerceApp();
    }
}