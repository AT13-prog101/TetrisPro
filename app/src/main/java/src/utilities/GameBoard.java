package src.utilities;

public class GameBoard {
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
     * Gets the full line of the game board array
     * @param row the row to get
     * @return the array with the selected line
     */
    public boolean[][] getLineFromGameBoardArray(int row) {
        boolean[][] line = new boolean[1][gameBoardArray[row].length];
        for (int j = 0; j < gameBoardArray[row].length; j++) {
            line[0][j] = gameBoardArray[row][j];
        }
        return line;
    }
}
