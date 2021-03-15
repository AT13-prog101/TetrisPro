package src.utilities;

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

    public void init() { }

    /**
     * Creates the game board array
     * @param height is the game board height
     * @param width is the game board width
     * @return the game board array
     */
    public int[][] createGameBoardArray(final int height, final int width) {
        int[][] gameBoardArray = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                gameBoardArray[i][j] = 0;
            }
        }
        return gameBoardArray;
    }

    /**
     * Sets all the values of a row to 0
     * @param gameBoardArray is the array to set the values
     * @param row is the row on the array to set the values
     * @return the array with the values set
     */
    public int[][] cleanRowOnArray(final int[][] gameBoardArray, final int row) {
        for (int j = 0; j < gameBoardArray[row].length; j++) {
            gameBoardArray[row][j] = 0;
        }
        return gameBoardArray;
    }

    /**
     * Verifies if a certain row is full of 1
     * @param gameBoardArray is the array to check
     * @param row is the row to be verified
     * @return a boolean according to the verification made
     */
    public boolean checkFullRow(final int[][] gameBoardArray, final int row) {
        int notEmptyValueCounter = 0;
        for (int j = 0; j < gameBoardArray[row].length; j++) {
            if (gameBoardArray[row][j] == 1) {
                notEmptyValueCounter += 1;
            }
        }
        return (notEmptyValueCounter == gameBoardArray[row].length);
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
     * Prints the Game Board
     */
    public void printGameBoard() {
        int[][] gameBoardArray = createGameBoardArray(GAME_BOARD_HEIGHT, GAME_BOARD_WIDTH);
        for (int i = 0; i < gameBoardArray.length; i++) {
            for (int j = 0; j < gameBoardArray[i].length; j++) {
                System.out.print(gameBoardArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}
