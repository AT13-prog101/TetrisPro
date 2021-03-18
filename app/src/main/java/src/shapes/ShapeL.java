package src.shapes;

public class ShapeL extends Shape {
    private boolean[][] shapeL = {{true, false, false},
                                  {true, false, false},
                                  {true, true, false}};

    public ShapeL(final int xPos, final int yPos) {
        super(xPos, yPos);
        setContainer(getShapeL());
    }

    /**
     * Draws the shape L into an array.
     * @return An array of boolean with the form of figure.
     */
    public boolean[][] getShapeL() {
        return shapeL;
    }
}
