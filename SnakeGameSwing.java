import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SnakeGameSwing extends JPanel implements ActionListener, KeyListener {

    private final int TILE_SIZE = 25;      // Each box size
    private final int WIDTH = 600;         // Window width
    private final int HEIGHT = 600;        // Window height
    private final int TOTAL_TILES = (WIDTH * HEIGHT) / (TILE_SIZE * TILE_SIZE);

    private final int[] x = new int[TOTAL_TILES]; // X positions of snake body
    private final int[] y = new int[TOTAL_TILES]; // Y positions of snake body

    private int snakeLength = 3;
    private int foodX, foodY;
    private char direction = 'R'; // U=Up, D=Down, L=Left, R=Right
    private boolean running = false;
    private Timer timer;
    private Random random;
    private int score = 0;

    SnakeGameSwing() {
        random = new Random();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);
        startGame();
    }

    // Start the game
    public void startGame() {
        newFood();
        running = true;
        timer = new Timer(100, this); // Snake speed
        timer.start();
    }

    // Draw game components
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if (running) {
            // Draw food
            g.setColor(Color.RED);
            g.fillOval(foodX, foodY, TILE_SIZE, TILE_SIZE);

            // Draw snake
            for (int i = 0; i < snakeLength; i++) {
                if (i == 0)
                    g.setColor(Color.GREEN); // head
                else
                    g.setColor(new Color(45, 180, 0));
                g.fillRect(x[i], y[i], TILE_SIZE, TILE_SIZE);
            }

            // Draw score
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("Score: " + score, 10, 25);
        } else {
            gameOver(g);
        }
    }

    // Create new food location
    public void newFood() {
        foodX = random.nextInt(WIDTH / TILE_SIZE) * TILE_SIZE;
        foodY = random.nextInt(HEIGHT / TILE_SIZE) * TILE_SIZE;
    }

    // Move snake
    public void move() {
        for (int i = snakeLength; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) {
            case 'U':
                y[0] -= TILE_SIZE;
                break;
            case 'D':
                y[0] += TILE_SIZE;
                break;
            case 'L':
                x[0] -= TILE_SIZE;
                break;
            case 'R':
                x[0] += TILE_SIZE;
                break;
        }
    }

    // Check if snake eats food
    public void checkFood() {
        if (x[0] == foodX && y[0] == foodY) {
            snakeLength++;
            score += 10;
            newFood();
        }
    }

    // Check collisions
    public void checkCollisions() {
        // Collide with body
        for (int i = snakeLength; i > 0; i--) {
            if (x[0] == x[i] && y[0] == y[i]) {
                running = false;
                break;
            }
        }

        // Collide with walls
        if (x[0] < 0 || x[0] >= WIDTH || y[0] < 0 || y[0] >= HEIGHT) {
            running = false;
        }

        if (!running) {
            timer.stop();
        }
    }

    // Game over screen
    public void gameOver(Graphics g) {
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 50));
        g.drawString("Game Over", 150, 250);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 25));
        g.drawString("Score: " + score, 240, 300);
        g.drawString("Press SPACE to Restart", 150, 350);
    }

    // Main game loop
    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkFood();
            checkCollisions();
        }
        repaint();
    }

    // Keyboard controls
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                if (direction != 'R') direction = 'L';
                break;
            case KeyEvent.VK_RIGHT:
                if (direction != 'L') direction = 'R';
                break;
            case KeyEvent.VK_UP:
                if (direction != 'D') direction = 'U';
                break;
            case KeyEvent.VK_DOWN:
                if (direction != 'U') direction = 'D';
                break;
            case KeyEvent.VK_SPACE:
                if (!running) {
                    snakeLength = 3;
                    direction = 'R';
                    score = 0;
                    x[0] = y[0] = 0;
                    running = true;
                    startGame();
                }
                break;
        }
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    // Main Method
    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game (Swing)");
        SnakeGameSwing gamePanel = new SnakeGameSwing();
        frame.add(gamePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}