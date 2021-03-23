package src.utilities;

import src.shapes.Shape;

import java.util.Random;
import java.util.Scanner;

public class Menu {
    private static final int OPTION_1 = 1;
    private static final int OPTION_2 = 2;
    private static final int OPTION_3 = 3;
    private static final int OPTION_4 = 4;
    private static final int OPTION_5 = 5;
    private static final int OPTION_6 = 6;
    private static final int MAX_RANDOM = 7;
    private static final int INITIAL_POSX_SHAPE = 3;
    private static final int INITIAL_POSY_SHAPE = 0;
    private GameBoard gameBoard;
    private RandomShape randomShape;
    private Shape shape;
    private Game game;

    /**
     * Prints the initial Menu
     */
    public void showGameMenu() {
//        gameBoard = new GameBoard();
//        game = new Game();
//        randomShape = new RandomShape();
//        shape = randomShape.getShape(randomNumberGenerator(), INITIAL_POSX_SHAPE, INITIAL_POSY_SHAPE);
        boolean gameInCourse = true;
        Scanner scanner = new Scanner(System.in);

        while (gameInCourse) {
            System.out.println("1.- Play");
            System.out.println("2.- Change difficulty");
            System.out.println("3.- Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case OPTION_1:
                    gameInCourse = false;
                    showMovementMenu();
                    break;
                case OPTION_2:
                    gameInCourse = false;
                    showDifficultyMenu();
                    break;
                case OPTION_3:
                    gameInCourse = false;
                    System.out.println("Good bye");
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
        scanner.close();
    }

    /**
     * Prints the difficulty Menu
     */
    public void showDifficultyMenu() {
        boolean difficultyInCourse = true;
        Scanner scanner = new Scanner(System.in);

        while (difficultyInCourse) {
            System.out.println("Select difficulty for the game");
            System.out.println("1.- Easy");
            System.out.println("2.- Medium");
            System.out.println("3.- Hard");
            System.out.println("4.- Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case OPTION_1:
                    difficultyInCourse = false;
                    System.out.println("Easy");
                    showMovementMenu();
                    break;
                case OPTION_2:
                    difficultyInCourse = false;
                    System.out.println("Medium");
                    showMovementMenu();
                    break;
                case OPTION_3:
                    difficultyInCourse = false;
                    System.out.println("Hard");
                    showMovementMenu();
                    break;
                case OPTION_4:
                    difficultyInCourse = false;
                    System.out.println("Good bye");
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
        scanner.close();
    }

    /**
     * Prints the options for movement menu
     */
    public void showMovementMenu() {
//        gameBoard = new GameBoard();
//        game = new Game();
//        randomShape = new RandomShape();
//        shape = randomShape.getShape(randomNumberGenerator(), INITIAL_POSX_SHAPE, INITIAL_POSY_SHAPE);
//        gameBoard.setGameBoardArray(shape);
        gameBoard = new GameBoard();
//        boolean[][] joelXD = {{true, true, true, true, true, true}};
//        gameBoard.setGameBoardArray(0, 6, joelXD);
        game = new Game();

        boolean gameInCourse = true;
        boolean collision = true;
        Scanner scanner = new Scanner(System.in);
        while (gameInCourse) {
            if (collision) {
                randomShape = new RandomShape();
                shape = randomShape.getShape(randomNumberGenerator(), INITIAL_POSX_SHAPE, INITIAL_POSY_SHAPE);
                collision = false;
                System.out.println("es true");
            } else {
                System.out.println("es false");
            }

            game.print(gameBoard, shape);
            System.out.println("Press next numbers to");
            System.out.println("1.- Move to Right");
            System.out.println("2.- Move to Left");
            System.out.println("3.- Rotate shape");
            System.out.println("4.- Go Down");
            System.out.println("5.- Exit");
            int option = scanner.nextInt();
            switch (option) {
                case OPTION_1:
                    if (game.checkCollision(shape, gameBoard, 2 + 1)) {
                        collision = true;
                        gameBoard.setGameBoardArray(shape.getxPosition(), shape.getyPosition(), shape.getContainer());
                    } else {
                        System.out.println("Moved to right");
                        shape.moveRight();
                        shape.moveDown();
                    }
                    break;
                case OPTION_2:
                    if (game.checkCollision(shape, gameBoard, 2 + 1)) {
                        collision = true;
                        gameBoard.setGameBoardArray(shape.getxPosition(), shape.getyPosition(), shape.getContainer());
                    } else {
                        System.out.println("Moved to left");
                        shape.moveLeft();
                        shape.moveDown();
                    }
                    break;
                case OPTION_3:
                    System.out.println("Rotated shape");
                    shape.rotate();
                    shape.moveDown();
                    break;
                case OPTION_4:
                    if (game.checkCollision(shape, gameBoard, 2)) {
                        collision = true;
                        gameBoard.setGameBoardArray(shape.getxPosition(), shape.getyPosition(), shape.getContainer());
                    } else {
                        System.out.println("Went Down");
                        shape.moveDown();
                    }
                    break;
                case OPTION_5:
                    gameInCourse = false;
                    System.out.println("Good bye");
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
        scanner.close();
    }

    /**
     * Generates a random number
     * @return a random number
     */
    private int randomNumberGenerator() {
        Random random = new Random();
        int randomNumber = random.nextInt(MAX_RANDOM);
        return randomNumber;
    }

}
