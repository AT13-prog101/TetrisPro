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

    }

    @Override
    public void moveLeft() {

    }

    @Override
    public void moveDown() {

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
