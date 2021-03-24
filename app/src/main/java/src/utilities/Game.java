package src.utilities;

import src.shapes.*;

public class Game {
    /**
     * Verifies if the shape collides with the game board array
     * @param shape the figure to check
     * @param gameBoard the game board array
     * @param direction the movement direction to check
     * @return a boolean with the result
     */
    public boolean checkCollision(final Shape shape, final GameBoard gameBoard, final int direction) {
        if (shape.checkDownLimit()) {
            return true;
        }
        int xMovement = 0;
        int yMovement = 0;
        switch (direction) {
            case 1:
                xMovement = -1;
                break;
            case 2:
                yMovement = 1;
                break;
            case 3:
                xMovement = 1;
                break;
            default:
                break;
        }
        if (shape.checkRightLimit()) {
            xMovement = 0;
        }
        int xInitial = shape.getxPosition();
        int yInitial = shape.getyPosition();
        int shapeHeight = shape.getContainer().length - shape.getDownRows();
        int shapeWidth = shape.getContainer().length - shape.getRightColumns();
        boolean[][] matchArray = gameBoard.getPartialGameBoardArray(xInitial + xMovement, yInitial + yMovement, shapeHeight, shapeWidth);
        for (int i = 0; i < shapeHeight; i++) {
            for (int j = 0; j < shapeWidth; j++) {
                if (shape.getContainer()[i][j] && matchArray[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Displays the shape and gameboard on the console
     * @param gameBoard the game board array
     * @param shape the figure to display
     */
    public void print(final GameBoard gameBoard, final Shape shape) {
        int x = shape.getxPosition();
        int y = shape.getyPosition();
        int arrayLength = shape.getContainer().length;
        for (int i = 0; i < gameBoard.getGameBoardArray().length; i++) {
            for (int j = 0; j < gameBoard.getGameBoardArray()[i].length; j++) {
                if (i >= y && i < (y + arrayLength) && j >= x && j < (x + arrayLength)) {
                    if (shape.getContainer()[i - y][j - x]) {
                        System.out.print("1");
                    } else {
                        if (gameBoard.getGameBoardArray()[i][j]) {
                            System.out.print("1");
                        } else {
                            System.out.print("0");
                        }
                    }
                } else {
                    if (gameBoard.getGameBoardArray()[i][j]) {
                        System.out.print("1");
                    } else {
                        System.out.print("0");
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
