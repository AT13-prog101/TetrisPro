package src.utilities;

import src.shapes.Shape;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
    private static JLabel[][] labelArray;

    public Interface() { }

    /**
     * Method initialize the graphical interface.
     */
    public void init() {
        setSize(sizeWindowWidth, sizeWindowHeight);
        setTitle("TETRIS");
        setLocationRelativeTo(null);
        setVisible(true);
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
                    label.setBackground(Color.gray);
                } else {
                    label.setBackground(Color.black);
                }
                label.setBorder(border);
                labelArray[row][col] = label;
                add(label);
            }
        }
        addKeyListener(this);
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
    public void keyTyped(KeyEvent e) {
        return;
    }

    /**
     * @Override keyPressed.
     */
    @Override
    public void keyPressed(final KeyEvent e) {
//        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//        }
//        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            shape.moveDown();
            System.out.println(gameBoard.getGameBoardArray());
            gameBoard.print(gameBoard.getGameBoardArray());
        }
    }

    /**
     * @Override keyReleased.
     */
    @Override
    public void keyReleased(KeyEvent e) {
        return;
    }
}
