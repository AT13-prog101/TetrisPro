package src;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class GameBoardTest extends TestCase {
    @Test
    public void createGameBoardArray_2And4_arrayOf2x4() {
        GameBoard gameBoard = new GameBoard();
        int[][] actual = gameBoard.createGameBoardArray(2, 4);
        int[][] expected = {{0, 0, 0, 0}, {0, 0, 0, 0}};
        assertArrayEquals(expected, actual);
    }
}