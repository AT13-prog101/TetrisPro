package src.utilities;

public class GameBoard {
    private Player player;
    private int speed;
    static final int GAME_BOARD_HEIGHT = 20;
    static final int GAME_BOARD_WIDTH = 10;

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
}
