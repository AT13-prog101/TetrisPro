package src.utilities;

import java.util.Random;
import java.util.Scanner;

public class GameBoard {
    private Player player;
    private int speed;
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
    public void setGameBoardArray(int x, int y, boolean[][] array) {
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

    public void init() { }

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
     * @param gameBoardArray is the array to set the values
     * @param row is the row on the array to set the values
     * @return the array with the values set
     */
    public boolean[][] cleanRowOnArray(final boolean[][] gameBoardArray, final int row) {
        for (int j = 0; j < gameBoardArray[row].length; j++) {
            gameBoardArray[row][j] = false;
        }
        return gameBoardArray;
    }

    /**
     * Verifies if a certain row is full of a certain value
     * @param gameBoardArray is the array to check
     * @param row is the row to be verified
     * @param arrayValue is the value to check
     * @return a boolean according to the verification made
     */
    public boolean checkFullRow(final boolean[][] gameBoardArray, final int row, final boolean arrayValue) {
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
     * @param gameBoardArray the array to adjust
     */
    public void adjustLines(final boolean[][] gameBoardArray) {
        int row = gameBoardArray.length - 1;
        int emptyRowCounter;
        while (row >= 0) {
            emptyRowCounter = 0;
            while (checkFullRow(gameBoardArray, row, false)) {
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
                boolean[][] newRow = new boolean[1][gameBoardArray[row].length];
                for (int j = 0; j < gameBoardArray[row].length; j++) {
                    newRow[0][j] = gameBoardArray[row][j];
                }
                setGameBoardArray(0, row + emptyRowCounter, newRow);
                cleanRowOnArray(gameBoardArray, row);
                setGameBoardArray(0, 0, gameBoardArray);
                row = row + emptyRowCounter - 1;
            }
        }
    }

    /**
     * Prints the options for movement menu
     */
    public void movementMenu() {
        boolean gameInCourse = true;
        Scanner scanner = new Scanner(System.in);
        while (gameInCourse) {
            System.out.println("Press next numbers to");
            System.out.println("1.- Move to Right");
            System.out.println("2.- Move to Left");
            System.out.println("3.- Rotate to Right");
            System.out.println("4.- Rotate to Left");
            System.out.println("5.- Exit");
            int option = scanner.nextInt();
            switch (option) {
                case OPTION_1:
                    System.out.println("Moved to right");
                    break;
                case OPTION_2:
                    System.out.println("Moved to left");
                    break;
                case OPTION_3:
                    System.out.println("Rotated to right");
                    break;
                case OPTION_4:
                    System.out.println("Rotated to left");
                    break;
                default:
                    gameInCourse = false;
                    break;
            }
        }
        scanner.close();
    }

    /**
     * Creates the game board array with a shape on it
     * @return the game board array with a shape on it
     */
    public boolean[][] show() {
        RandomShape randomShape = new RandomShape();
        boolean[][] shape = randomShape.getShape(randomNumberGenerator(), INITIAL_POSX_SHAPE, INITIAL_POSY_SHAPE).draw();
        setGameBoardArray(INITIAL_POSX_SHAPE, INITIAL_POSY_SHAPE, shape);
        return this.gameBoardArray;
    }

    /**
     * Prints an array of booleans
     * @param arrayOfBooleans is the array to print
     */
    public void print(boolean[][] arrayOfBooleans) {
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
    public static String toNumeralString(Boolean input) {
        if (input == null) {
            return "null";
        } else {
            return input.booleanValue() ? "1" : "0";
        }
    }
}
