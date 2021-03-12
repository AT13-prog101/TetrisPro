package src;

public class ShapeO extends Shape {
    private static final int ROWS = 2;
    private static final int COLUMNS = 2;

    /**
     * Draws the shape O into an array.
     * @return An array of int with of the form of figure.
     */
    @Override
    public int[][]  draw() {
        int[][] mat = new int[ROWS][COLUMNS];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                mat[i][j] = 1;
            }
        }
        return mat;
    }

    @Override
    public void rotateLeft() {

    }

    @Override
    public void rotateRight() {

    }

}
