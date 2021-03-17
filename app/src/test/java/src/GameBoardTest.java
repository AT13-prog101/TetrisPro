package src;

import org.junit.Test;
import src.utilities.*;

import static org.junit.Assert.*;

public class GameBoardTest {
    @Test
    public void createGameBoardArray_Height2AndWidth4_arrayOf2x4() {
        GameBoard gameBoard = new GameBoard();
        boolean[][] actual = gameBoard.createGameBoardArray(2, 4);
        boolean[][] expected = {{false, false, false, false}, {false, false, false, false}};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void cleanRowOnArray_ArrayOf2x3AndRowTrue_arrayOf2x3WithFalseOnRow1() {
        GameBoard gameBoard = new GameBoard();
        boolean[][] actual = {{true, true, true}, {true, true, true}};
        actual = gameBoard.cleanRowOnArray(actual, 1);
        boolean[][] expected = {{true, true, true}, {false, false, false}};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void checkFullRow_ArrayOf2x5andRow0_True() {
        GameBoard gameBoard = new GameBoard();
        boolean[][] array = {{true, true, true, true, true}, {false, true, false, true, false}};
        boolean actual = gameBoard.checkFullRow(array,0, true);
        assertTrue(actual);
    }

    @Test
    public void checkFullRow_ArrayOf2x5andRow1_False() {
        GameBoard gameBoard = new GameBoard();
        boolean[][] array = {{true, true, true, true, true}, {false, true, false, true, false}};
        boolean actual = gameBoard.checkFullRow(array,1, true);
        assertFalse(actual);
    }

    @Test
    public void setGameBoardArray_1And2AndArrayOf2x2_UpdatedArray() {
        GameBoard gameBoard = new GameBoard();
        boolean[][] arrayToChange = {{true, true}, {true, true}};
        gameBoard.setGameBoardArray(1, 2, arrayToChange);
        boolean[][] actual = gameBoard.getGameBoardArray();
        boolean [][] expected = {
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, true, true, false, false, false, false, false, false, false},
                {false, true, true, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false}
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void adjustLines_GameBoardArray_OrderedGameBoardArray() {
        GameBoard gameBoard = new GameBoard();
        boolean[][] disorderedArray = {
                {false, false, false, false, false, false, false, false, false, false},
                {true, false, false, true, false, true, false, true, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {true, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {true, true, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {true, false, false, false, true, false, false, false, false, true},
                {true, false, true, false, false, true, false, false, true, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {true, false, true, false, false, false, true, false, false, false}
        };
        gameBoard.setGameBoardArray(0, 0, disorderedArray);
        gameBoard.adjustLines(gameBoard.getGameBoardArray());
        boolean[][] actual = gameBoard.getGameBoardArray();
        boolean [][] expected = {
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {true, false, false, true, false, true, false, true, false, false},
                {true, false, false, false, false, false, false, false, false, false},
                {true, true, false, false, false, false, false, false, false, false},
                {true, false, false, false, true, false, false, false, false, true},
                {true, false, true, false, false, true, false, false, true, false},
                {true, false, true, false, false, false, true, false, false, false}
        };
        assertArrayEquals(expected, actual);
    }
}