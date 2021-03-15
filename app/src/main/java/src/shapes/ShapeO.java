package src.shapes;

public class ShapeO extends Shape {
    private static final int ROWS = 2;
    private static final int COLUMNS = 2;

    public ShapeO(final int xPos, final int yPos) {
        super(xPos, yPos);
        setContainer(draw());
    }

    /**
     * Draws the shape O into an array.
     * @return An array of int with the form of figure.
     */
    @Override
    public boolean[][]  draw() {
        boolean[][] matrix = new boolean[ROWS][COLUMNS];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
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
