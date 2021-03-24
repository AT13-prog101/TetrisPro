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
    private static final int MAX_RANDOM = 7;
    private static final int INITIAL_POSX_SHAPE = 3;
    private static final int INITIAL_POSY_SHAPE = 0;
    private GameBoard gameBoard;
    private RandomShape randomShape;
    private Shape shape;
    private Game game;
    private int onlyOneMovement = 0;
    private static final int SAFE_SPACE = 3;
    private static final int SAFE_ZONE = 8;

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
        shape = randomShape.getShape(randomNumberGenerator(), INITIAL_POSX_SHAPE, INITIAL_POSY_SHAPE);
        boolean gameInCourse = true;
        boolean collision = false;
        Scanner scanner = new Scanner(System.in);
        if (!validSpace()) {
            gameInCourse = false;
            System.out.println("You Lose");
        }
        while (gameInCourse) {
            if (collision) {
                gameBoard.setGameBoardArray(shape);
                gameBoard.updateLinesOnGameBoard();
                randomShape = new RandomShape();
                shape = randomShape.getShape(randomNumberGenerator(), INITIAL_POSX_SHAPE, INITIAL_POSY_SHAPE);
                collision = false;
                onlyOneMovement = 0;
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
                    } else {
                        System.out.println("Moved to right");
                        shape.moveRight();
                    }
                    break;
                case OPTION_2:
                    if (game.checkCollision(shape, gameBoard, 1)) {
                        collision = true;
                    } else {
                        System.out.println("Moved to left");
                        shape.moveLeft();
                    }
                    break;
                case OPTION_3:
                    System.out.println("Rotated shape");
                    shape.rotate();
                    break;
                case OPTION_4:
                    if (game.checkCollision(shape, gameBoard, 2)) {
                        collision = true;
                    } else {
                        System.out.println("Went Down");
                        onlyOneMovement++;
                        shape.moveDown();
                    }
                    if (collision && onlyOneMovement == 0) {
                        System.out.println("You Lose");
                        gameInCourse = false;
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
     *
     * @return a random number
     */
    private int randomNumberGenerator() {
        Random random = new Random();
        int randomNumber = random.nextInt(MAX_RANDOM);
        return randomNumber;
    }

    /**
     * Method to check if there is enough space to put the shape.
     */
    private boolean validSpace() {
        boolean valido = false;
        int count = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = SAFE_SPACE; j < gameBoard.getGameBoardArray()[i].length - SAFE_SPACE; j++) {
                if (valido == gameBoard.getGameBoardArray()[i][j]) {
                    count++;
                }
            }
        }
        if (count == SAFE_ZONE) {
            return true;
        }
        return false;
    }
}
