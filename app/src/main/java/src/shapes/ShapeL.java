package src.shapes;

public class ShapeL extends Shape {
    private static final int ROWS = 2;
    private static final int COLUMNS = 3;

    public ShapeL(final int xPos, final int yPos) {
        super(xPos, yPos);
    }

    /**
     * Draws the shape L into an array.
     * @return An array of int with the form of figure.
     */
    @Override
    public int[][]  draw() {
        int[][] matrix = new int[ROWS][COLUMNS];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 1 && j >= i) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = 1;
                }
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
