package src.shapes;

public class ShapeT extends Shape {
    private boolean[][] shapeT = {{true, true, true},
                                  {false, true, false},
                                  {false, false, false}};

    public ShapeT(final int xPos, final int yPos) {
        super(xPos, yPos);
        setContainer(getShapeT());
    }

    /**
     * Draws the shape T into an array.
     * @return An array of boolean with the form of figure.
     */
    public boolean[][] getShapeT() {
        return shapeT;
    }
}
