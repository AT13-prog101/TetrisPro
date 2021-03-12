package src;

public abstract class Shape implements DrawableDelegate, MovableDelegate, RotableDelegate {
    private int xPosition;
    private int yPosition;

    public Shape(int xPos, int yPos) {
        xPosition = xPos;
        yPosition = yPos;
    }

    @Override
    public abstract int[][] draw();

    /**
     * Adds one to yPosition.
     * In order to represent to move right
     */
    @Override
    public void moveRight() {
        yPosition += 1;
    }

    /**
     * Adds one to yPosition.
     * In order to represent to move left
     */
    @Override
    public void moveLeft() {
        yPosition -= 1;
    }

    /**
     * Adds one to xPosition.
     * In order to represent to move down
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
