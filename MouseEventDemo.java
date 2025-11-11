import java.awt.*;
import java.awt.event.*;

public class MouseEventDemo extends Frame {

    String msg = "";  // message to display
    int x = 0, y = 0; // coordinates for drawing

    public MouseEventDemo() {
        setTitle("Mouse Event Demo using Adapter Classes");
        setSize(500, 400);
        setBackground(new Color(230, 240, 250));
        setFont(new Font("Arial", Font.BOLD, 18));

        // --- Add Mouse Listener (Adapter Class) ---
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                msg = "Mouse Clicked";
                repaint();
            }

            public void mousePressed(MouseEvent e) {
                msg = "Mouse Pressed";
                repaint();
            }

            public void mouseReleased(MouseEvent e) {
                msg = "Mouse Released";
                repaint();
            }

            public void mouseEntered(MouseEvent e) {
                msg = "Mouse Entered";
                repaint();
            }

            public void mouseExited(MouseEvent e) {
                msg = "Mouse Exited";
                repaint();
            }
        });

        // --- Add Mouse Motion Listener (Adapter Class) ---
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
                msg = "Mouse Moved";
                x = e.getX();
                y = e.getY();
                repaint();
            }

            public void mouseDragged(MouseEvent e) {
                msg = "Mouse Dragged";
                x = e.getX();
                y = e.getY();
                repaint();
            }
        });

        // --- Window Close Operation ---
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    // --- Paint method to show message ---
    public void paint(Graphics g) {
        g.setColor(Color.BLUE);
        // draw the message at the center of the window
        g.drawString(msg, getWidth() / 2 - 60, getHeight() / 2);
    }

    public static void main(String[] args) {
        new MouseEventDemo();
    }
}