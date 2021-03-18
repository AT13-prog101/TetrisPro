package src.utilities;
import src.shapes.*;

import java.util.Random;

public class RandomShape {
    private static final int MAX_RANDOM = 7;
    private static final int SHAPE_I_INT = 0;
    private static final int SHAPE_J_INT = 1;
    private static final int SHAPE_L_INT = 2;
    private static final int SHAPE_O_INT = 3;
    private static final int SHAPE_S_INT = 4;
    private static final int SHAPE_T_INT = 5;

    /**
     * Generates a class depending on a random number.
     * @return A class of shape.
     */
    public Shape getShape(final int random, final int posX, final int posY) {
        int randomNumber = random;
        switch (randomNumber) {
            case SHAPE_I_INT:
                return new ShapeI(posX, posY);
            case SHAPE_J_INT:
                return new ShapeJ(posX, posY);
            case SHAPE_L_INT:
                return new ShapeL(posX, posY);
            case SHAPE_O_INT:
                return new ShapeO(posX, posY);
            case SHAPE_S_INT:
                return new ShapeS(posX, posY);
            case SHAPE_T_INT:
                return new ShapeT(posX, posY);
            default:
                return new ShapeZ(posX, posY);
        }
    }
}
