package src.shapes;


public class Shape  {
    private int xPosition;
    private int yPosition;
    private boolean[][] container;
    private boolean firstColumnEmpty;
    private boolean lastColumnEmpty;
    private int horizontalLimit;
    private int veticalLimit;
    private boolean rotationStatus;

    public Shape(final int xPos, final int yPos, final ShapeType type) {
        this.xPosition = xPos;
        this.yPosition = yPos;
        this.rotationStatus = true;
        this.container = ShapeDefinition.generate(type);
    }

    public Shape(final int xPos, final int yPos, final int horizontalL, final int verticalL,
                 final ShapeType type) {
        xPosition = xPos;
        yPosition = yPos;
        horizontalLimit = horizontalL;
        veticalLimit = verticalL;
        firstColumnEmpty = false;
        lastColumnEmpty = false;
        this.rotationStatus = true;
        this.container = ShapeDefinition.generate(type);
    }

    /**
     * Increases xPosition in one.
     * In order to represent movement to the right
     */
    public void moveRight() {
        if (yPosition < horizontalLimit - (1 + 1 + 1) && !lastColumnEmpty
                || yPosition < horizontalLimit - 2 && lastColumnEmpty) {
            xPosition += 1;
        }
    }

    /**
     * Decreases xPposition in one.
     * In order to represent movement to the left
     */
    public void moveLeft() {
        if (yPosition > 0 && !firstColumnEmpty || yPosition > -1 && firstColumnEmpty) {
            xPosition -= 1;
        }
    }

    /**
     * Increases yPosition in one.
     * In order to represent downwards movement
     */
    public void moveDown() {
        if (yPosition < veticalLimit) {
            yPosition += 1;
        }
    }

    /**
     * @return An int that is xPosition.
     */
    public int getxPosition() {
        return xPosition;
    }

    /**
     * @return An int that is yPosition.
     */
    public int getyPosition() {
        return yPosition;
    }

    /**
     * @return An arrray that is container of shape.
     */
    public boolean[][] getContainer() {
        return container;
    }

    /**
     * assigns values to container of shape.
     */
    public void setContainer(final boolean[][] cont) {
        container = cont;
    }

    /**
     * @return An bolean that is eje of shape.
     */
    public boolean isRotationStatus() {
        return rotationStatus;
    }

    /**
     * assigns values to rotate eje of shape.
     */
    private void setRotationStatus(final boolean rotation) {
        this.rotationStatus = rotation;
    }

    /**
     * rotate the matrix.
     * @return An array of boolean with the rotate form of figure.
     */
    public boolean[][] rotateShape(final boolean[][] matrix) {
        boolean[][] newMatrix;
        if (isRotationStatus()) {
            setRotationStatus(false);
            newMatrix = transposeMatrix(this.getContainer());
            return newMatrix;
        }
        newMatrix = reverseMatrix(this.getContainer());
        setContainer(newMatrix);
        setRotationStatus(true);
        return newMatrix;
    }

    /**
     * transpose the matrix.
     * @return An array of boolean with the transpose form of figure.
     */
    public boolean[][] transposeMatrix(final boolean[][] matrix)  {
        boolean[][] newMatrix = new boolean[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                newMatrix[j][i] = matrix[i][j];
            }
        }
        return newMatrix;
    }
    /**
     * reverse the matrix.
     * @return An array of boolean with reverse form of figure.
     */
    public boolean[][] reverseMatrix(final boolean[][] matrix) {
        int middle = matrix.length / 2;
        for (int i = 0; i < middle; i++) {
            boolean[] matrixAux = matrix[i];
            matrix[i] = matrix[matrix.length - i - 1];
            matrix[matrix.length - i - 1] = matrixAux;
        }
        return matrix;
    }
    /**
     * reverse the matrix.
     * @return An array of boolean with reverse form of figure.
     */
    public boolean getFirst() {
        return firstColumnEmpty;
    }
    /**
     * reverse the matrix.
     * @return An array of boolean with reverse form of figure.
     */
    public boolean getLast() {
        return lastColumnEmpty;
    }
}
