package src;

import java.util.Random;

public class RandomShape {
    private static final int MAX_RANDOM = 7;

    /**
     * Generates a class depending on a random number.
     * @return A class of shape.
     */
    public Shape getShape(int random, int posX, int posY) {
        int randomNumber = random;
        switch (randomNumber) {
            case 0:
                return new ShapeI(posX, posY);
            case 1:
                return new ShapeJ(posX, posY);
            case 2:
                return new ShapeL(posX, posY);
            case 3:
                return new ShapeO(posX, posY);
            case 4:
                return new ShapeS(posX, posY);
            case 5:
                return new ShapeT(posX, posY);
            default:
                return new ShapeZ(posX, posY);
        }
    }

    private int randomNumberGenerator() {
        Random random = new Random();
        int randomNumber = random.nextInt(MAX_RANDOM);
        return randomNumber;
    }
}
