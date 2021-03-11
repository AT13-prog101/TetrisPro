package src;

public class ShapeJ extends Shape {
    private static final int ROWS = 2;
    private static final int COLUMNS = 3;

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
        mat[1][0] = 0;
        mat[1][1] = 0;
        return mat;
    }

    @Override
    public void rotateLeft() {

    }

    @Override
    public void rotateRight() {

    }

}
