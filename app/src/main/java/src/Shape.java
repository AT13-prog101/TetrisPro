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

    @Override
    public void moveRight() {
        yPosition += 1;
    }

    @Override
    public void moveLeft() {
        yPosition -= 1;
    }

    @Override
    public void moveDown() {
        xPosition += 1;
    }

    @Override
    public abstract void rotateLeft();

    @Override
    public abstract void rotateRight();

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }
}
