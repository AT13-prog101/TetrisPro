package src.utilities;

import java.util.Scanner;

public class Menu {
    private static final int OPTION_1 = 1;
    private static final int OPTION_2 = 2;
    private static final int OPTION_3 = 3;
    private static final int OPTION_4 = 4;
    private static final int OPTION_5 = 5;
    private static final int OPTION_6 = 6;

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
        boolean gameInCourse = true;
        Scanner scanner = new Scanner(System.in);
        while (gameInCourse) {
            System.out.println("Press next numbers to");
            System.out.println("1.- Move to Right");
            System.out.println("2.- Move to Left");
            System.out.println("3.- Rotate to Right");
            System.out.println("4.- Rotate to Left");
            System.out.println("5.- Go Down");
            System.out.println("6.- Exit");
            int option = scanner.nextInt();
            switch (option) {
                case OPTION_1:
                    System.out.println("Moved to right");
                    break;
                case OPTION_2:
                    System.out.println("Moved to left");
                    break;
                case OPTION_3:
                    System.out.println("Rotated to right");
                    break;
                case OPTION_4:
                    System.out.println("Rotated to left");
                    break;
                case OPTION_5:
                    System.out.println("Went Down");
                    break;
                case OPTION_6:
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
