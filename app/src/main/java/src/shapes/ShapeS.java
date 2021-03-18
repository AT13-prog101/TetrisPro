package src.shapes;

public class ShapeS extends Shape {
    private boolean[][] shapeS = {{false, true, true},
                                  {true, true, false},
                                  {false, false, false}};

    public ShapeS(final int xPos, final int yPos) {
        super(xPos, yPos);
        setContainer(getShapeS());
    }

    /**
     * Draws the shape S into an array.
     * @return An array of boolean with the form of figure.
     */
    public boolean[][] getShapeS() {
        return shapeS;
    }
}
