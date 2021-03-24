package src;

import org.junit.Test;
import src.shapes.*;
import src.utilities.Game;
import src.utilities.GameBoard;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void checkCollision_ShapeIGameBoardDownMovement_True() {
        Game game = new Game();
        GameBoard gameBoard = new GameBoard();
        Shape shape = new Shape(5,0,ShapeType.I);
        boolean[][] fullRow = {{true, true, true, true, true,true, true, true, true, true}};
        gameBoard.setGameBoardArray(0, 1,fullRow);
        boolean actual = game.checkCollision(shape, gameBoard, 2);
        assertTrue(actual);
    }

    @Test
    public void checkCollision_ShapeIGameBoardDownMovement_False() {
        Game game = new Game();
        GameBoard gameBoard = new GameBoard();
        Shape shape = new Shape(5,0,ShapeType.I);
        boolean[][] fullRow = {{true, true, true, true, true, false, true, true, true, true}};
        gameBoard.setGameBoardArray(0, 4,fullRow);
        boolean actual = game.checkCollision(shape, gameBoard, 2);
        assertFalse(actual);
    }

    @Test
    public void checkCollision_ShapeJGameBoardRightMovement_True() {
        Game game = new Game();
        GameBoard gameBoard = new GameBoard();
        Shape shape = new Shape(5,0,ShapeType.J);
        boolean[][] fullColumn = {{true}, {true}, {true}, {true}, {true}, {true}, {true}, {true}, {true}, {true}};
        gameBoard.setGameBoardArray(8, 0,fullColumn);
        boolean actual = game.checkCollision(shape, gameBoard, 3);
        assertTrue(actual);
    }

    @Test
    public void checkCollision_ShapeJGameBoardRightMovement_False() {
        Game game = new Game();
        GameBoard gameBoard = new GameBoard();
        Shape shape = new Shape(5,0,ShapeType.J);
        boolean[][] fullColumn = {{true}, {true}, {true}, {true}, {true}, {true}, {true}, {true}, {true}, {true}};
        gameBoard.setGameBoardArray(9, 0,fullColumn);
        boolean actual = game.checkCollision(shape, gameBoard, 3);
        assertFalse(actual);
    }

    @Test
    public void checkCollision_ShapeJGameBoarLeftMovement_True() {
        Game game = new Game();
        GameBoard gameBoard = new GameBoard();
        Shape shape = new Shape(5,0,ShapeType.L);
        boolean[][] fullColumn = {{true}, {true}, {true}, {true}, {true}, {true}, {true}, {true}, {true}, {true}};
        gameBoard.setGameBoardArray(4, 0,fullColumn);
        boolean actual = game.checkCollision(shape, gameBoard, 1);
        assertTrue(actual);
    }

    @Test
    public void checkCollision_ShapeJGameBoardLeftMovement_False() {
        Game game = new Game();
        GameBoard gameBoard = new GameBoard();
        Shape shape = new Shape(5,0, ShapeType.L);
        boolean[][] fullColumn = {{true}, {true}, {true}, {true}, {true}, {true}, {true}, {true}, {true}, {true}};
        gameBoard.setGameBoardArray(3, 0,fullColumn);
        boolean actual = game.checkCollision(shape, gameBoard, 1);
        assertFalse(actual);
    }
}