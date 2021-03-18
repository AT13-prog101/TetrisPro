package src.shapes;


public class Shape  {
    private int xPosition;
    private int yPosition;
    private boolean[][] container;
    private boolean firstColumnEmpty;
    private boolean lastColumnEmpty;
    private int horizontalLimit;
    private boolean rotationStatus;


    public Shape(final int xPos, final int yPos) {
        xPosition = xPos;
        yPosition = yPos;
        this.rotationStatus = true;
    }

    public Shape(final int xPos, final int yPos, final int horizontalL) {
        xPosition = xPos;
        yPosition = yPos;
        horizontalLimit = horizontalL;
        firstColumnEmpty = false;
        lastColumnEmpty = false;
        this.rotationStatus = true;
    }

    /**
     * Increases xPosition in one.
     * In order to represent movement to the right
     */
    public void moveRight() {
        if (yPosition < horizontalLimit - 3 && !lastColumnEmpty
                || yPosition < horizontalLimit - 2 && lastColumnEmpty) {
            yPosition += 1;
        }
    }

    /**
     * Decreases xPposition in one.
     * In order to represent movement to the left
     */
    public void moveLeft() {
        if (yPosition > 0 && !firstColumnEmpty || yPosition > -1 && firstColumnEmpty) {
            yPosition -= 1;
        }
    }

    /**
     * Increases yPosition in one.
     * In order to represent downwards movement
     */
    public void moveDown() {
        xPosition += 1;
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
    public void setRotationStatus(final boolean rotationStatus) {
        this.rotationStatus = rotationStatus;
    }

    /**
     * rotate the matrix.
     * @return An array of boolean with the rotate form of figure.
     */
    public boolean[][] rotateShape(final boolean[][] matrix) {
        boolean[][] newMatrix;
        if (isRotationStatus()) {
            System.out.println("ENTRO TRASPONER");
            newMatrix = transposeMatrix(matrix);
            setRotationStatus(false);
        } else {
            System.out.println("ENTRO REVERSE");
            newMatrix = reverseMatrix(matrix);
            setRotationStatus(true);
        }
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
}
