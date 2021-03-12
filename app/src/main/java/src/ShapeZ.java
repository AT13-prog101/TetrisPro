package src;

public class ShapeZ extends Shape {
    private static final int ROWS = 2;
    private static final int COLUMNS = 3;

    /**
     * Draws the shape Z into an array.
     * @return An array of int with of the form of figure.
     */
    @Override
    public int[][]  draw() {
        int[][] mat = new int[ROWS][COLUMNS];
        System.out.println(mat[0].length - 2);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (i == 0 && j < mat[0].length - 1) {
                    mat[i][j] = 1;
                } else if (i == 1 &&  j > 0) {
                    mat[i][j] = 1;
                } else {
                    mat[i][j] = 0;
                }
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
