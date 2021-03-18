package src.shapes;

public class ShapeI extends Shape {

    private boolean[][] shapeI = {{true, false, false, false},
                                  {true, false, false, false},
                                  {true, false, false, false},
                                  {true, false, false, false}};

    public ShapeI(final int xPos, final int yPos) {
        super(xPos, yPos);
        setContainer(getShapeI());
    }
    /**
     * Draws the shape I into an array.
     * @return An array of boolean with the form of figure.
     */
    public boolean[][] getShapeI() {
        return shapeI;
    }
}
