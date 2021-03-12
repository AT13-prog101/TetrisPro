package src.shapes;

public class ShapeZ extends Shape {
    private static final int ROWS = 2;
    private static final int COLUMNS = 3;

    public ShapeZ(final int xPos, final int yPos) {
        super(xPos, yPos);
    }

    /**
     * Draws the shape Z into an array.
     * @return An array of int with the form of figure.
     */
    @Override
    public int[][]  draw() {
        int[][] matrix = new int[ROWS][COLUMNS];
        System.out.println(matrix[0].length - 2);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 && j < matrix[0].length - 1) {
                    matrix[i][j] = 1;
                } else if (i == 1 &&  j > 0) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
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
