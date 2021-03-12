package src;

public class ShapeI extends Shape {
    private static final int ROWS = 1;
    private static final int COLUMNS = 4;
    /**
     * Draws the shape I into an array.
     * @return An array of int with of the form of figure.
     */
    @Override
    public int[][]  draw() {
        int[][] matrix = new int[ROWS][COLUMNS];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
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
