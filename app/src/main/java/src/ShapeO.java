package src;

public class ShapeO extends Shape {
    private static final int ROWS = 1;
    private static final int COLUMNS = 4;

    /**
     *
     * @return
     */
    @Override
    public int[][]  draw() {
        int[][] mat = new int[ROWS][COLUMNS];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
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
