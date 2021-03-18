package src.shapes;

public class ShapeO extends Shape {
    private boolean[][] shapeO = {{true, true},
                                  {true, true}};

    public ShapeO(final int xPos, final int yPos) {
        super(xPos, yPos);
        setContainer(getShapeO());
    }

    /**
     * Draws the shape O into an array.
     * @return An array of boolean with the form of figure.
     */
    public boolean[][] getShapeO() {
        return shapeO;
    }
}
