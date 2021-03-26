package src.utilities;

import src.shapes.*;

public class Game {
    private int xMovement;
    private int yMovement;
    private boolean downLimitReached = false;

    public int getyMovement() {
        return yMovement;
    }

    public boolean getdownLimitReached() {
        return downLimitReached;
    }

    public int getxMovement() {
        return xMovement;
    }

    /**
     * Verifies if the shape collides with the game board array
     * @param shape the figure to check
     * @param gameBoard the game board array
     * @param direction the movement direction to check
     * @return a boolean with the result
     */
    public boolean checkCollision(final Shape shape, final GameBoard gameBoard, final DirectionType direction) {
        selectDirection(direction, shape);
        if (downLimitReached) {
            return true;
        }
        int shapeHeight = shape.getPartialShape().length;
        int shapeWidth = shape.getPartialShape()[0].length;
        boolean[][] matchArray = gameBoard.getPartialGameBoardArray(shape.getxPosition() + xMovement + shape.getLeftColumns(), shape.getyPosition() + yMovement + shape.getTopRows(), shapeHeight, shapeWidth);
        return compareArrays(matchArray, shape.getPartialShape(), shapeHeight, shapeWidth);
    }

    /**
     * Checks if two arrays have a similar value on a same position
     * @param firstArray to compare
     * @param secondArray to compare
     * @param height of the arrays
     * @param width of the arrays
     * @return
     */
    public boolean compareArrays(boolean[][] firstArray, boolean[][] secondArray, int height, int width) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (firstArray[i][j] && secondArray[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Sets the parameters to check collision on a certain direction
     * @param direction the shape's current direction
     * @param shape that is moving
     */
    public void selectDirection(DirectionType direction, Shape shape) {
        xMovement = 0;
        yMovement = 0;
        downLimitReached = false;
        switch (direction) {
            case Left:
                if (shape.checkLeftLimit()) {
                    xMovement = 0;
                } else {
                    xMovement = -1;
                }
                break;
            case Down:
                if (shape.checkDownLimit()) {
                    downLimitReached = true;
                } else {
                    yMovement = 1;
                }
                break;
            case Right:
                if (shape.checkRightLimit()) {
                    xMovement = 0;
                } else {
                    xMovement = 1;
                }
                break;
        }
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
