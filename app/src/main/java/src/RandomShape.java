package src;

import java.util.Random;

public class RandomShape {
    private static final int MAX_RANDOM = 7;

    /**
     * Generates a class depending on a random number.
     * @return A class of shape.
     */
    public Shape getShape(int random) {
        int randomNumber = random;
        switch (randomNumber) {
            case 0:
                return new ShapeI();
            case 1:
                return new ShapeJ();
            case 2:
                return new ShapeL();
            case 3:
                return new ShapeO();
            case 4:
                return new ShapeS();
            case 5:
                return new ShapeT();
            default:
                return new ShapeZ();
        }
    }

    private int randomNumberGenerator() {
        Random random = new Random();
        int randomNumber = random.nextInt(MAX_RANDOM);
        return randomNumber;
    }
}
