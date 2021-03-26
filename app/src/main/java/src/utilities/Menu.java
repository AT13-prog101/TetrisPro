package src.utilities;

import src.shapes.Shape;

import java.util.Scanner;

public class Menu {
    private static final int OPTION_1 = 1;
    private static final int OPTION_2 = 2;
    private static final int OPTION_3 = 3;
    private static final int OPTION_4 = 4;
    private static final int OPTION_5 = 5;
    private GameBoard gameBoard;
    private RandomShape randomShape;
    private Shape shape;
    private Game game;

    /**
     * Prints the initial Menu
     */
    public void showGameMenu() {
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
        gameBoard = new GameBoard();
        game = new Game();
        randomShape = new RandomShape();
        shape = randomShape.getShape(randomShape.randomNumberGenerator());
        boolean gameInCourse = true;
        Scanner scanner = new Scanner(System.in);
        while (gameInCourse) {
            if (game.checkCollision(shape, gameBoard, DirectionType.Hold)) {
                System.out.println("You Lose");
                break;
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
                    if (game.checkCollision(shape, gameBoard, DirectionType.Right)) {
                    } else {
                        System.out.println("Moved to right");
                        shape.moveRight();
                    }
                    break;
                case OPTION_2:
                    if (game.checkCollision(shape, gameBoard, DirectionType.Left)) {
                    } else {
                        System.out.println("Moved to left");
                        shape.moveLeft();
                    }
                    break;
                case OPTION_3:
                    if (game.checkCollision(shape, gameBoard, DirectionType.Rotate)) {
                        shape.rotate();
                        shape.rotate();
                        shape.rotate();
                    } else {
                        System.out.println("Rotated shape");
                    }
                    break;
                case OPTION_4:
                    if (game.checkCollision(shape, gameBoard, DirectionType.Down)) {
                        gameBoard.setGameBoardArray(shape);
                        gameBoard.updateLinesOnGameBoard();
                        randomShape = new RandomShape();
                        shape = randomShape.getShape(randomShape.randomNumberGenerator());
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
}
