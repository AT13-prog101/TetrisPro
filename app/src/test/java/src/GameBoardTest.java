package src;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class GameBoardTest {
    @Test
    public void createGameBoardArray_Height2AndWidth4_arrayOf2x4() {
        GameBoard gameBoard = new GameBoard();
        int[][] actual = gameBoard.createGameBoardArray(2, 4);
        int[][] expected = {{0, 0, 0, 0}, {0, 0, 0, 0}};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void cleanRowOnArray_ArrayOf2x3AndRow1_arrayOf2x3WithZerosOnRow1() {
        GameBoard gameBoard = new GameBoard();
        int[][] actual = {{1, 1, 1}, {1, 1, 1}};
        actual = gameBoard.cleanRowOnArray(actual, 1);
        int[][] expected = {{1, 1, 1}, {0, 0, 0}};
        assertArrayEquals(expected, actual);
    }
}