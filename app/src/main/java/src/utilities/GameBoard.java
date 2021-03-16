package src.utilities;

public class GameBoard {
    private Player player;
    private int speed;
    static final int GAME_BOARD_HEIGHT = 20;
    static final int GAME_BOARD_WIDTH = 10;
    private boolean[][] gameBoardArray;

    public GameBoard () {
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

    public void adjustLines(final boolean[][] gameBoardArray) {
        int row = gameBoardArray.length - 1;
        int emptyRowCounter;
        while (row >= 0) {
            emptyRowCounter = 0;
            while (checkFullRow(gameBoardArray, row, false)) {
                emptyRowCounter += 1;
                row -= 1;
            }
            if (emptyRowCounter == 0) {
                row -= 1;
            } else {
                boolean[][] array = new boolean[1][gameBoardArray[row].length];
                for (int j = 0; j < gameBoardArray[row].length; j++) {
                    array[0][j] = gameBoardArray[row][j];
                }
                setGameBoardArray(0, row + emptyRowCounter, array);
                cleanRowOnArray(gameBoardArray, row);
                setGameBoardArray(0, 0, gameBoardArray);
                row = row + emptyRowCounter - 1;
            }
        }
    }
}
