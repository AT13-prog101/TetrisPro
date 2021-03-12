package src;

public class ShapeO extends Shape {
    private static final int ROWS = 2;
    private static final int COLUMNS = 2;

    public ShapeO(int xPos, int yPos) {
        super(xPos, yPos);
    }

    /**
     * Draws the shape O into an array.
     * @return An array of int with the form of figure.
     */
    @Override
    public int[][]  draw() {
        int[][] matrix = new int[ROWS][COLUMNS];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = 1;
            }
        }
        return matrix;
    }

    @Override
    public void rotateLeft() {

    }

    @Override
    public void rotateRight() {

    }

}
