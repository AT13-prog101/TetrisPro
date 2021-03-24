package src;

import org.junit.Test;
import src.shapes.*;
import src.utilities.*;
import static org.junit.Assert.*;

public class GameBoardTest {
    @Test
    public void createGameBoardArray_Height2AndWidth4_arrayOf2x4() {
        GameBoard gameBoard = new GameBoard();
        boolean[][] actual = gameBoard.createGameBoardArray(2, 4);
        boolean[][] expected = new boolean[2][4];
        assertArrayEquals(expected, actual);
    }

    @Test
    public void cleanRowOnArray_Row1_GameBoardArrayWithRow1False() {
        GameBoard gameBoard = new GameBoard();
        boolean[][] array = createArray(3,10);
        gameBoard.setGameBoardArray(0, 0, array);
        gameBoard.cleanRowOnArray(1);
        boolean[][] actual = gameBoard.getGameBoardArray();
        boolean [][] expected = new boolean[20][10];
        updateRowOnArray(0,expected);
        updateRowOnArray(2,expected);
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
        Shape shape = new Shape(1,2, ShapeType.O);
        gameBoard.setGameBoardArray(shape);
        boolean[][] actual = gameBoard.getGameBoardArray();
        boolean [][] expected = new boolean[20][10];
        updatePositionOnArray(1,2, expected);
        updatePositionOnArray(2,2, expected);
        updatePositionOnArray(1,3, expected);
        updatePositionOnArray(2,3, expected);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void adjustLines_GameBoardArray_OrderedGameBoardArray() {
        GameBoard gameBoard = new GameBoard();
        boolean[][] array = createArray(1,10);
        gameBoard.setGameBoardArray(0, 1, array);
        gameBoard.setGameBoardArray(0, 5, array);
        gameBoard.setGameBoardArray(0, 10, array);
        gameBoard.setGameBoardArray(0, 15, array);
        gameBoard.adjustLines();
        boolean[][] actual = gameBoard.getGameBoardArray();
        boolean [][] expected = new boolean[20][10];
        updateRowOnArray(16, expected);
        updateRowOnArray(17, expected);
        updateRowOnArray(18, expected);
        updateRowOnArray(19, expected);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getLineFromGameBoardArray_Row10_BooleanArrayFullWithFalse() {
        GameBoard gameBoard = new GameBoard();
        boolean[][] actual = gameBoard.getLineFromGameBoardArray(10);
        boolean[][] expected = new boolean[1][10];
        assertArrayEquals(expected, actual);
    }

    @Test
    public void updateLinesOnGameBoard_GameBoardArray_EmptyGameBoardArray() {
        GameBoard gameBoard = new GameBoard();
        boolean[][] array = createArray(1,10);
        gameBoard.setGameBoardArray(0, 1, array);
        gameBoard.setGameBoardArray(0, 10, array);
        gameBoard.setGameBoardArray(0, 18, array);
        gameBoard.setGameBoardArray(0, 19, array);
        gameBoard.updateLinesOnGameBoard();
        boolean[][] actual = gameBoard.getGameBoardArray();
        boolean[][] expected = new boolean[20][10];
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

    /**
     * Creates an array full of true values
     * @param height of the array
     * @param width of the array
     * @return the array with dimensions and values set
     */
    public static boolean[][] createArray(int height, int width) {
        boolean[][] array = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                array[i][j] = true;
            }
        }
        return array;
    }

    /**
     * Sets a row of an array to true
     * @param row to set
     * @param array to set
     * @return array with the row changed
     */
    public static boolean[][] updateRowOnArray(int row, boolean[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == row) {
                    array[i][j] = true;
                }
            }
        }
        return array;
    }

    /**
     * Sets a position on the array to true
     * @param x position on x axis
     * @param y position on y axis
     * @param array to set
     * @return the array with the value set
     */
    public static boolean[][] updatePositionOnArray(int x, int y, boolean[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == y && j ==x) {
                    array[i][j] = true;
                }
            }
        }
        return array;
    }

}