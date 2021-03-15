package src.shapes;

public class ShapeI extends Shape {
    private static final int ROWS = 1;
    private static final int COLUMNS = 4;

    public ShapeI(final int xPos, final int yPos) {
        super(xPos, yPos);
        setContainer(draw());
    }

    /**
     * Draws the shape I into an array.
     * @return An array of int with the form of figure.
     */
    @Override
    public boolean[][]  draw() {
        boolean[][] matrix = new boolean[ROWS][COLUMNS];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = true;
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
