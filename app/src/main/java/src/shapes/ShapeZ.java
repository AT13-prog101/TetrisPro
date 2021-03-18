package src.shapes;

public class ShapeZ extends Shape {
    private boolean[][] shapeZ = {{true, true, false},
                                  {false, true, true},
                                  {false, false, false}};

    public ShapeZ(final int xPos, final int yPos) {
        super(xPos, yPos);
        setContainer(getShapeZ());
    }

    /**
     * Draws the shape Z into an array.
     * @return An array of boolean with the form of figure.
     */
    public boolean[][] getShapeZ() {
        return shapeZ;
    }
}
