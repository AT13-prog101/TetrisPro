package src.utilities;

import src.shapes.*;

public class Game {
    public static boolean checkCollision(Shape shape, GameBoard gameBoard, int direction) {
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
        }
        int xInitial = shape.getxPosition();
        int yInitial = shape.getyPosition();
        int shapeLength = shape.getContainer().length;
        boolean[][] matchArray = gameBoard.getPartialGameBoardArray(xInitial + xMovement, yInitial + yMovement, shapeLength);
        for (int i = 0; i < shapeLength; i++) {
            for (int j = 0; j < shapeLength; j++) {
                if (shape.getContainer()[i][j] && matchArray[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void print(GameBoard gameBoard, Shape shape) {
        int x = shape.getxPosition();
        int y = shape.getyPosition();
        int arrayLength = shape.getContainer().length;
        for (int i = 0; i < gameBoard.getGameBoardArray().length; i++) {
            for (int j = 0; j < gameBoard.getGameBoardArray()[i].length; j++) {
                if (i >= y && i < (y + arrayLength) && j >= x && j < (x + arrayLength)) {
                    if (shape.getContainer()[i-y][j-x]) {
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
