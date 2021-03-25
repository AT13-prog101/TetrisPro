package src;

import org.junit.Test;
import src.shapes.*;
import src.utilities.DirectionType;
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
        boolean actual = game.checkCollision(shape, gameBoard, DirectionType.Down);
        assertTrue(actual);
    }

    @Test
    public void checkCollision_ShapeIGameBoardDownMovement_False() {
        Game game = new Game();
        GameBoard gameBoard = new GameBoard();
        Shape shape = new Shape(5,0,ShapeType.I);
        boolean[][] fullRow = {{true, true, true, true, true, false, true, true, true, true}};
        gameBoard.setGameBoardArray(0, 4,fullRow);
        boolean actual = game.checkCollision(shape, gameBoard, DirectionType.Down);
        assertFalse(actual);
    }

    @Test
    public void checkCollision_ShapeJGameBoardRightMovement_True() {
        Game game = new Game();
        GameBoard gameBoard = new GameBoard();
        Shape shape = new Shape(5,0,ShapeType.J);
        boolean[][] fullColumn = {{true}, {true}, {true}, {true}, {true}, {true}, {true}, {true}, {true}, {true}};
        gameBoard.setGameBoardArray(8, 0,fullColumn);
        boolean actual = game.checkCollision(shape, gameBoard, DirectionType.Right);
        assertTrue(actual);
    }

    @Test
    public void checkCollision_ShapeJGameBoardRightMovement_False() {
        Game game = new Game();
        GameBoard gameBoard = new GameBoard();
        Shape shape = new Shape(5,0,ShapeType.J);
        boolean[][] fullColumn = {{true}, {true}, {true}, {true}, {true}, {true}, {true}, {true}, {true}, {true}};
        gameBoard.setGameBoardArray(9, 0,fullColumn);
        boolean actual = game.checkCollision(shape, gameBoard, DirectionType.Right);
        assertFalse(actual);
    }

    @Test
    public void checkCollision_ShapeLGameBoarLeftMovement_True() {
        Game game = new Game();
        GameBoard gameBoard = new GameBoard();
        Shape shape = new Shape(5,0,ShapeType.L);
        boolean[][] fullColumn = {{true}, {true}, {true}, {true}, {true}, {true}, {true}, {true}, {true}, {true}};
        gameBoard.setGameBoardArray(4, 0,fullColumn);
        boolean actual = game.checkCollision(shape, gameBoard, DirectionType.Left);
        assertTrue(actual);
    }

    @Test
    public void checkCollision_ShapeLGameBoardLeftMovement_False() {
        Game game = new Game();
        GameBoard gameBoard = new GameBoard();
        Shape shape = new Shape(5,0, ShapeType.L);
        boolean[][] fullColumn = {{true}, {true}, {true}, {true}, {true}, {true}, {true}, {true}, {true}, {true}};
        gameBoard.setGameBoardArray(3, 0,fullColumn);
        boolean actual = game.checkCollision(shape, gameBoard, DirectionType.Left);
        assertFalse(actual);
    }

    @Test
    public void checkCollision_ShapeIGameBoardDownMovementLimitReached_True() {
        Game game = new Game();
        GameBoard gameBoard = new GameBoard();
        Shape shape = new Shape(5,19, ShapeType.I);
        boolean actual = game.checkCollision(shape, gameBoard, DirectionType.Down);
        assertTrue(actual);
    }

    @Test
    public void checkCollision_ShapeIGameBoardLeftMovementLimitReached_True() {
        Game game = new Game();
        GameBoard gameBoard = new GameBoard();
        Shape shape = new Shape(0,0, ShapeType.I);
        shape.rotate();
        shape.rotate();
        shape.rotate();
        game.checkCollision(shape, gameBoard, DirectionType.Right);
        int actual = game.getLeftEmptyColumns();
        int expected = shape.getLeftColumns();
        assertEquals(expected, actual);
    }

    @Test
    public void selectDirection_ShapeJGameBoardDownMovement_YMovement1() {
        Game game = new Game();
        Shape shape = new Shape(5,0, ShapeType.J);
        game.selectDirection(DirectionType.Down,shape);
        int actual = game.getyMovement();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void selectDirection_ShapeJGameBoardDownMovement_DownLimitReached() {
        Game game = new Game();
        Shape shape = new Shape(5,18, ShapeType.J);
        game.selectDirection(DirectionType.Down,shape);
        boolean actual = game.getdownLimitReached();
        assertTrue(actual);
    }

    @Test
    public void selectDirection_ShapeJGameBoardLeftMovement_XMovement0() {
        Game game = new Game();
        Shape shape = new Shape(0,0, ShapeType.J);
        game.selectDirection(DirectionType.Left,shape);
        int actual = game.getxMovement();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void selectDirection_ShapeJGameBoardLeftMovement_XMovementNegative1() {
        Game game = new Game();
        Shape shape = new Shape(5,0, ShapeType.J);
        game.selectDirection(DirectionType.Left,shape);
        int actual = game.getxMovement();
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    public void selectDirection_ShapeJGameBoardRightMovement_XMovement0() {
        Game game = new Game();
        Shape shape = new Shape(7,0, ShapeType.J);
        game.selectDirection(DirectionType.Right, shape);
        int actual = game.getxMovement();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void selectDirection_ShapeJGameBoardRightMovement_XMovement1() {
        Game game = new Game();
        Shape shape = new Shape(5,0, ShapeType.J);
        game.selectDirection(DirectionType.Right,shape);
        int actual = game.getxMovement();
        int expected = 1;
        assertEquals(expected, actual);
    }
}