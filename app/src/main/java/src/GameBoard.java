package src;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GameBoard {
    Player player;
    int speed;
    static final int GAME_BOARD_HEIGHT = 20;
    static final int GAME_BOARD_WIDTH = 10;

    public void init() { }

    /**
     * Creates the game board array
     * @param height is the game board height
     * @param width is the game board width
     * @return game board array
     */
    public int[][] createGameBoardArray(final int height, final int width) {
        int[][] array = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                array[i][j] = 0;
            }
        }
        return array;
    }
}
