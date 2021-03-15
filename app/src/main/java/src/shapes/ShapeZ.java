package src.shapes;

public class ShapeZ extends Shape {
    private static final int ROWS = 3;
    private static final int COLUMNS = 3;

    public ShapeZ(final int xPos, final int yPos) {
        super(xPos, yPos);
        setContainer(draw());
    }

    /**
     * Draws the shape Z into an array.
     * @return An array of int with the form of figure.
     */
    @Override
    public boolean[][]  draw() {
        boolean[][] matrix = new boolean[ROWS][COLUMNS];
        System.out.println(matrix[0].length - 2);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if ((i == 0 && j < matrix[0].length - 1) || (i == 1 &&  j > 0)) {
                    matrix[i][j] = true;
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
