package src.shapes;
import src.interfaces.*;

public abstract class Shape implements DrawableDelegate, MovableDelegate, RotableDelegate {
    private int xPosition;
    private int yPosition;
    private boolean[][] container;

    public Shape(final int xPos, final int yPos) {
        xPosition = xPos;
        yPosition = yPos;
    }

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
        if (yPosition > 0) {
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
