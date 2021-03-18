package src;

import org.junit.Test;
import src.utilities.*;

import java.lang.reflect.Array;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;


public class GameBoardTest {
    @Test
    public void createGameBoardArray_Height2AndWidth4_arrayOf2x4() {
        GameBoard gameBoard = new GameBoard();
        boolean[][] actual = gameBoard.createGameBoardArray(2, 4);
        boolean[][] expected = {{false, false, false, false}, {false, false, false, false}};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void cleanRowOnArray_Row1_GameBoardArrayWithRow1False() {
        GameBoard gameBoard = new GameBoard();
        boolean[][] array = {
                {true, true, true, true, true, true, true, true, true, true},
                {true, true, true, true, true, true, true, true, true, true},
                {true, true, true, true, true, true, true, true, true, true}};
        gameBoard.setGameBoardArray(0, 0, array);
        gameBoard.cleanRowOnArray(1);
        boolean[][] actual = gameBoard.getGameBoardArray();
        boolean [][] expected = {
                {true, true, true, true, true, true, true, true, true, true},
                {false, false, false, false, false, false, false, false, false, false},
                {true, true, true, true, true, true, true, true, true, true},
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
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false}
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void checkFullRow_Row5AndValueFalse_True() {
        GameBoard gameBoard = new GameBoard();
        boolean actual = gameBoard.checkFullRow(5, false);
        assertTrue(actual);
    }

    @Test
    public void checkFullRow_Row1AndValueTrue_False() {
        GameBoard gameBoard = new GameBoard();
        boolean actual = gameBoard.checkFullRow(1, true);
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
        gameBoard.adjustLines();
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

    @Test
    public void getLineFromGameBoardArray_Row10_BooleanArrayFullWithFalse() {
        GameBoard gameBoard = new GameBoard();
        boolean[][] actual = gameBoard.getLineFromGameBoardArray(10);
        boolean[][] expected = {{false, false, false, false, false, false, false, false, false, false}};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void convertBooleanToNumber_True_1() {
        GameBoard gameBoard = new GameBoard();
        boolean value = true;
        String actual = gameBoard.toNumeralString(value);
        String expected = "1";
        assertEquals(actual, expected);
    }

    @Test
    public void convertBooleanToNumber_False_0() {
        GameBoard gameBoard = new GameBoard();
        boolean value = false;
        String actual = gameBoard.toNumeralString(value);
        String expected = "0";
        assertEquals(actual, expected);
    }

    @Test
    public void show_RandomShapeGameBoard_GameBoardWithShape() {
        GameBoard gameBoard = new GameBoard();
        boolean[][] actual = gameBoard.show();
        boolean[][] expected = new boolean[20][10];
        assertEquals(actual.length, expected.length);
    }
}