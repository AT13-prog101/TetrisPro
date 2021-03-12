package src.shapes;
import src.interfaces.*;

public abstract class Shape implements DrawableDelegate, MovableDelegate, RotableDelegate {
    private int xPosition;
    private int yPosition;

    public Shape(final int xPos, final int yPos) {
        xPosition = xPos;
        yPosition = yPos;
    }

    @Override
    public abstract int[][] draw();

    /**
     * Increases xPosition in one.
     * In order to represent movement to the right
     */
    @Override
    public void moveRight() {
        yPosition += 1;
    }

    /**
     * Decreases xPposition in one.
     * In order to represent movement to the left
     */
    @Override
    public void moveLeft() {
        yPosition -= 1;
    }

    /**
     * Increases yPosition in one.
     * In order to represent downwards movement
     */
    @Override
    public void moveDown() {
        xPosition += 1;
    }

    @Override
    public abstract void rotateLeft();

    @Override
    public abstract void rotateRight();

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
}
