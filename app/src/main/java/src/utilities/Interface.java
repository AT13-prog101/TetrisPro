package src.utilities;

import src.shapes.Shape;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.TimerTask;
import java.util.Timer;

public class Interface extends JFrame implements KeyListener {
    private GameBoard gameBoard = new GameBoard();
    private Game game = new Game();
    private RandomShape randomShape;
    private Shape shape;
    private static final int SIZE_IMAGE = 40;
    private int scaleWidth = gameBoard.getGameBoardWidth();
    private int scaleHeight = gameBoard.getGameBoardHeight();
    private int sizeWindowWidth = scaleWidth * SIZE_IMAGE;
    private int sizeWindowHeight = scaleHeight * SIZE_IMAGE;
    private static final int INITIAL_POSX_SHAPE = 3;
    private static final int INITIAL_POSY_SHAPE = 0;
    private static final int SPEED = 500;
    private static JLabel[][] labelArray;
    private Timer timer;

    public Interface() { }

    /**
     * Method initialize the graphical interface.
     */
    public void init() {
        timer = new Timer();
        setSize(sizeWindowWidth, sizeWindowHeight);
        setTitle("TETRIS");
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setFocusable(true);
        shape();
        labelArray = new JLabel[scaleHeight][scaleWidth];
        setLayout(new GridLayout(scaleHeight, scaleWidth));
        for (int row = 0; row < scaleHeight; row++) {
            for (int col = 0; col < scaleWidth; col++) {
                Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
                JLabel label = new JLabel();
                label.setName("Tetris");
                label.setOpaque(true);
                if (gameBoard.getGameBoardArray()[row][col]) {
                    label.setBackground(Color.red);
                } else {
                    label.setBackground(Color.black);
                }
                label.setBorder(border);
                labelArray[row][col] = label;
                add(label);
            }
        }
        setVisible(true);
        addKeyListener(this);
        start();
    }
    /**
     * Method to initialize and show a shape.
     */
    public void shape() {
        randomShape = new RandomShape();
        shape = randomShape.getShape(randomShape.randomNumberGenerator(), INITIAL_POSX_SHAPE, INITIAL_POSY_SHAPE);
        printShape();
    }
    /**
     * Refresh the icon of a label where it is our Alien.
     */
    public void printShape() {
        gameBoard.setGameBoardArray(shape);
    }

    /**
     * @Override keyTyped.
     */
    @Override
    public void keyTyped(final KeyEvent e) {
        return;
    }

    /**
     * @Override keyPressed.
     */
    @Override
    public void keyPressed(final KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            updateShape(Color.black);
            shape.moveRight();
            System.out.println("pos x: " + shape.getxPosition());
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            updateShape(Color.black);
            shape.moveLeft();
            System.out.println("pos x: " + shape.getxPosition());
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            updateShape(Color.black);
            shape.moveDown();
            System.out.println("pos y: " + shape.getyPosition());
        }
    }

    /**
     * @Override keyReleased.
     */
    @Override
    public void keyReleased(final KeyEvent e) {
        return;
    }

    /**
     * Method to initialize timer.
     */
    public void start() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                updateShape(Color.black);
                shape.moveDown();
                System.out.println("pos y: " + shape.getyPosition());
                updateShape(Color.green);
            }
        };
        timer.scheduleAtFixedRate(task, 0, SPEED);
    }
    /** */
    public void updateShape(final Color color) {
        int y = shape.getyPosition();
        int x = shape.getxPosition();
        for (int i = 0; i < shape.getContainer().length - shape.getDownRows(); i++) {
            for (int j = shape.getLeftColumns(); j < shape.getContainer()[0].length - shape.getRightColumns(); j++) {
                if (shape.getContainer()[i][j]) {
                    updateShape3(this.labelArray[i + y][j + x], color);
                }
            }
        }
    }

    /** */
    public void updateShape3(final JLabel label, final Color color) {
        label.setBackground(color);
    }

}
