package src.utilities;

import java.util.Random;
import java.util.Scanner;

public class GameBoard {
    static final int GAME_BOARD_HEIGHT = 20;
    static final int GAME_BOARD_WIDTH = 10;
    private static final int OPTION_1 = 1;
    private static final int OPTION_2 = 2;
    private static final int OPTION_3 = 3;
    private static final int OPTION_4 = 4;
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
     * Obtains the game board array
     * @return the game board array
     */
    public boolean[][] getGameBoardArray() {
        return this.gameBoardArray;
    }

    /**
     * Creates the game board array
     * @param height is the game board height
     * @param width is the game board width
     * @return the game board array
     */
    public boolean[][] createGameBoardArray(final int height, final int width) {
        boolean[][] gameBoardArray = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                gameBoardArray[i][j] = false;
            }
        }
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
     * Prints an array of booleans
     * @param arrayOfBooleans is the array to print
     */
    public void print(final boolean[][] arrayOfBooleans) {
        for (int i = 0; i < arrayOfBooleans.length; i++) {
            for (int j = 0; j < arrayOfBooleans[i].length; j++) {
                System.out.print(toNumeralString(arrayOfBooleans[i][j]) + " ");
            }
            System.out.println();
        }
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
