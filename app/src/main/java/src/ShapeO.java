package src;

public class ShapeO extends Shape {
    private static final int ROWS = 2;
    private static final int COLUMNS = 2;

    /**
     *
     * @return
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
