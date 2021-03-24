package src.utilities;

import java.util.Random;
import src.shapes.*;

public class GameBoard {
    static final int GAME_BOARD_HEIGHT = 20;
    static final int GAME_BOARD_WIDTH = 10;
    private static final int MAX_RANDOM = 7;
    private static final int INITIAL_POSX_SHAPE = 3;
    private static final int INITIAL_POSY_SHAPE = 0;
    private boolean[][] gameBoardArray;

    public GameBoard() {
        this.gameBoardArray = createGameBoardArray(GAME_BOARD_HEIGHT, GAME_BOARD_WIDTH);
    }

    /**
     * Sets the values of the game board array according to a position and an array
     * @param x initial position on the x axis
     * @param y initial position on the y axis
     * @param array the array that contains the values to change
     */
    public void setGameBoardArray(final int x, final int y, final boolean[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                this.gameBoardArray[i + y][j + x] = array[i][j];
            }
        }
    }

    /**
     * Sets the values of the game board array according to a position and an array
     * @param shape that contains the values to change
     */
    public void setGameBoardArray(final Shape shape) {
        int y = shape.getyPosition();
        int x = shape.getxPosition();
        for (int i = 0; i < shape.getContainer().length - shape.getDownRows(); i++) {
            for (int j = shape.getLeftColumns(); j < shape.getContainer()[0].length - shape.getRightColumns(); j++) {
                if (shape.getContainer()[i][j]) {
                    this.gameBoardArray[i + y][j + x] = shape.getContainer()[i][j];
                }
            }
        }
    }

    /**
     * Obtains the game board array
     * @return the game board array
     */
    public boolean[][] getGameBoardArray() {
        return this.gameBoardArray;
    }

    /**
     * Gets a part of the game board array
     * @param xInitial the initial position on x axis
     * @param yInitial the initial position on y axis
     * @param shapeHeight the shape's height
     * @param shapeWidth the shape's width
     * @return the partial game board array
     */
    public boolean[][] getPartialGameBoardArray(final int xInitial, final int yInitial, final int shapeHeight, final int shapeWidth) {
        boolean[][] partialArray = new boolean[shapeHeight][shapeWidth];
        for (int i = 0; i < shapeHeight; i++) {
            for (int j = 0; j < shapeWidth; j++) {
                partialArray[i][j] = gameBoardArray[i + yInitial][j + xInitial];
            }
        }
        return partialArray;
    }

    /**
     * Creates the game board array
     * @param height is the game board height
     * @param width is the game board width
     * @return the game board array
     */
    public boolean[][] createGameBoardArray(final int height, final int width) {
        boolean[][] gameBoardArray = new boolean[height][width];
        return gameBoardArray;
    }

    /**
     * Sets all the values of a row to false
     * @param row is the row on the array to set the values
     * @return the array with the values set
     */
    public boolean[][] cleanRowOnArray(final int row) {
        for (int j = 0; j < gameBoardArray[row].length; j++) {
            gameBoardArray[row][j] = false;
        }
        return gameBoardArray;
    }

    /**
     * Verifies if a certain row is full of a certain value
     * @param row is the row to be verified
     * @param arrayValue is the value to check
     * @return a boolean according to the verification made
     */
    public boolean checkFullRow(final int row, final boolean arrayValue) {
        int valueCounter = 0;
        for (int j = 0; j < gameBoardArray[row].length; j++) {
            if (gameBoardArray[row][j] == arrayValue) {
                valueCounter += 1;
            }
        }
        return (valueCounter == gameBoardArray[row].length);
    }

    /**
     * Moves the lines to the bottom side when empty lines in between
     */
    public void adjustLines() {
        int row = gameBoardArray.length - 1;
        int emptyRowCounter;
        while (row >= 0) {
            emptyRowCounter = 0;
            while (checkFullRow(row, false)) {
                emptyRowCounter += 1;
                if (row == 0) {
                    break;
                } else {
                    row -= 1;
                }
            }
            if (emptyRowCounter == 0 || row == 0) {
                row -= 1;
            } else {
                boolean[][] newRow = getLineFromGameBoardArray(row);
                setGameBoardArray(0, row + emptyRowCounter, newRow);
                cleanRowOnArray(row);
                row = row + emptyRowCounter - 1;
            }
        }
    }

    /**
     * Checks full lines on game board and adjust it
     */
    public void updateLinesOnGameBoard() {
        for (int i = 0; i < gameBoardArray.length; i++) {
            if (checkFullRow(i, true)) {
                cleanRowOnArray(i);
            }
        }
        adjustLines();
    }

    /**
     * Creates the game board array with a shape on it
     * @return the game board array with a shape on it
     */
    public boolean[][] show() {
        RandomShape randomShape = new RandomShape();
        boolean[][] shape = randomShape.getShape(randomNumberGenerator(), INITIAL_POSX_SHAPE, INITIAL_POSY_SHAPE).getContainer();
        setGameBoardArray(INITIAL_POSX_SHAPE, INITIAL_POSY_SHAPE, shape);
        return this.gameBoardArray;
    }

    /**
     * Generates a random number
     * @return a random number
     */
    private int randomNumberGenerator() {
        Random random = new Random();
        int randomNumber = random.nextInt(MAX_RANDOM);
        return randomNumber;
    }

    /**
     * Transforms a boolean into 0 or 1 according to its value
     * @param input is the boolean to change
     * @return a 0 or 1
     */
    public String toNumeralString(final Boolean input) {
        return input.booleanValue() ? "1" : "0";
    }
    /**
     * Gets the full line of the game board array
     * @param row the row to get
     * @return the array with the selected line
     */
    public boolean[][] getLineFromGameBoardArray(final int row) {
        boolean[][] line = new boolean[1][gameBoardArray[row].length];
        for (int j = 0; j < gameBoardArray[row].length; j++) {
            line[0][j] = gameBoardArray[row][j];
        }
        return line;
    }
}
