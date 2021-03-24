package src.shapes;


public class Shape  {
    private int xPosition;
    private int yPosition;
    static final int X_POS_DEFAULT = 3;
    static final int Y_POS_DEFAULT = 0;
    static final int HOR_LIMIT_DEFAULT = 10;
    static final int VER_LIMIT_DEFAULT = 20;
    private boolean[][] container;
    private int horizontalLimit;
    private int verticalLimit;
    private boolean rotationStatus;
    private int rightColumns;
    private int leftColumns;
    private int downRows;

    public Shape(final int xPos, final int yPos, final ShapeType type) {
        this(xPos, yPos, HOR_LIMIT_DEFAULT, VER_LIMIT_DEFAULT, type);
    }

    public Shape(final ShapeType type) {
        this(X_POS_DEFAULT, Y_POS_DEFAULT, HOR_LIMIT_DEFAULT, VER_LIMIT_DEFAULT, type);
    }

    public Shape(final int xPos, final int yPos, final int horizontalL, final int verticalL,
                 final ShapeType type) {
        xPosition = xPos;
        yPosition = yPos;
        horizontalLimit = horizontalL;
        verticalLimit = verticalL;
        this.rotationStatus = true;
        this.container = ShapeDefinition.generate(type);
        updateColumnsReviewer();
    }
    /**
     * Increases xPosition in one.
     * In order to represent movement to the right.
     */
    public void moveRight() {
        if (xPosition < horizontalLimit - container.length + rightColumns) {
            xPosition += 1;
        }
    }

    /**
     * Decreases xPposition in one.
     * In order to represent movement to the left
     */
    public void moveLeft() {
        if (xPosition > 0 - leftColumns) {
            xPosition -= 1;
        }
    }

    /**
     * Increases yPosition in one.
     * In order to represent downwards movement
     */
    public void moveDown() {
        if (yPosition < verticalLimit - container.length + downRows) {
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
     * calculates free columns from right.
     */
    public void reviewFromRight() {
        boolean res = true;
        int counter = 0;
        int j = container[0].length - 1;
        while (res && j >= 0) {
            int i = 0;
            while (res && i < container.length) {
                res = res && !container[i][j];
                i++;
            }
            if (res) {
                counter++;
            }
            j--;
        }
        rightColumns = counter;
    }

    /**
     * calculates free columns from left.
     */
    public void reviewFromLeft() {
        boolean res = true;
        int counter = 0;
        int j = 0;
        while (res && j < container[0].length) {
            int i = 0;
            while (res && i < container.length) {
                res = res && !container[i][j];
                i++;
            }
            if (res) {
                counter++;
            }
            j++;
        }
        leftColumns = counter;
    }

    /**
     * calculates free rows from down.
     */
    public void reviewFromDown() {
        boolean res = true;
        int counter = 0;
        int i = container[0].length - 1;
        while (res && i >= 0) {
            int j = 0;
            while (res && j < container.length) {
                res = res && !container[i][j];
                j++;
            }
            if (res) {
                counter++;
            }
            i--;
        }
        downRows = counter;
    }

    /**
     * rotate the matrix.
     * @return An array of boolean with the rotate form of figure.
     */
    public void rotate() {
        boolean[][] rotatedMatrix = new boolean[container.length][container.length];
        for (int i = 0; i < rotatedMatrix.length; i++) {
            for (int j = 0; j < rotatedMatrix.length; j++) {
                rotatedMatrix[i][rotatedMatrix.length - 1 - j] = container[j][i];
            }
        }
        setContainer(rotatedMatrix);
        updateColumnsReviewer();
    }

    /**
     * does column controllers are updated.
     */
    public void updateColumnsReviewer() {
        reviewFromRight();
        reviewFromLeft();
        reviewFromDown();
    }

    /**
     * @retunr free right columns of container.
     */
    public int getRightColumns() {
        return rightColumns;
    }

    /**
     * @return free left columns of container.
     */
    public int getLeftColumns() {
        return leftColumns;
    }

    /**
     * @return free down rows of container.
     */
    public int getDownRows() {
        return downRows;
    }

    /**
     * @return if container is at right limit.
     */
    public boolean checkRightLimit() {
        return xPosition == horizontalLimit - container.length + rightColumns - 1;
    }

    /**
     * @return if container is at down limit.
     */
    public boolean checkDownLimit() {
        return yPosition == verticalLimit - container.length + downRows - 1;
    }

    /**
     * @return if container is at left limit.
     */
    public boolean checkLeftLimit() {
        return xPosition + leftColumns == 0;
    }
}
