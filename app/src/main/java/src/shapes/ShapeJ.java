package src.shapes;

public class ShapeJ extends Shape {
    private boolean[][] shapeJ = {{false, false, true},
                                  {false, false, true},
                                  {false, true, true}};

    public ShapeJ(final int xPos, final int yPos) {
        super(xPos, yPos);
        setContainer(getShapeJ());
    }

    /**
     * Draws the shape J into an array.
     * @return An array of boolean with the form of figure.
     */
    public boolean[][] getShapeJ() {
        return shapeJ;
    }
}
