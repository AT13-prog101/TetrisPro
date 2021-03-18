package src.shapes;
import src.interfaces.*;

public abstract class Shape implements DrawableDelegate, MovableDelegate, RotableDelegate {
    private int xPosition;
    private int yPosition;
    private boolean[][] container;
    private boolean firstColumnEmpty;
    private boolean lastColumnEmpty;
    private int horizontalLimit;

    public Shape(final int xPos, final int yPos) {
        xPosition = xPos;
        yPosition = yPos;
    }

    public Shape(final int xPos, final int yPos, final int horizontalL) {
        xPosition = xPos;
        yPosition = yPos;
        horizontalLimit = horizontalL;
        firstColumnEmpty = false;
        lastColumnEmpty = false;
    }

    /**
     * Increases xPosition in one.
     * In order to represent movement to the right
     */
    @Override
    public void moveRight() {
        if (yPosition < horizontalLimit - 3 && !lastColumnEmpty
                || yPosition < horizontalLimit - 2 && lastColumnEmpty) {
            yPosition += 1;
        }
    }

    /**
     * Decreases xPposition in one.
     * In order to represent movement to the left
     */
    @Override
    public void moveLeft() {
        if (yPosition > 0 && !firstColumnEmpty || yPosition > -1 && firstColumnEmpty) {
            yPosition -= 1;
        }
    }

    /**
     * Increases yPosition in one.
     * In order to represent downwards movement
     */
    @Override
    public void moveDown() {
        xPosition += 1;
    }

    /**
     * @return An int that is xPosition.
     */
    public int getxPosition() {
        return xPosition;
    }

    /**
     * @return An int that is yPosition.
     */
    public int getyPosition() {
        return yPosition;
    }

    /**
     * @return An arrray that is container of shape.
     */
    public boolean[][] getContainer() {
        return container;
    }

    /**
     * assigns values to container of shape.
     */
    public void setContainer(final boolean[][] cont) {
        container = cont;
    }
}
