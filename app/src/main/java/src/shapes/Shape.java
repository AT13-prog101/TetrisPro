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
    private int rightColumns;
    private int leftColumns;
    private int downRows;

    public Shape(final ShapeType type) {
        xPosition = X_POS_DEFAULT;
        yPosition = Y_POS_DEFAULT;
        horizontalLimit = HOR_LIMIT_DEFAULT;
        verticalLimit = VER_LIMIT_DEFAULT;
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
     * @return .
     */
    public int getDownRows() {
        return downRows;
    }
    /**
     * @return an integer with the number of columns to right
     */
    public int getRightColumns() {
        return rightColumns;
    }
    /**
     * @return an integer with the number of columns to left.
     */
    public int getLeftColumns() {
        return leftColumns;
    }
    /**
     * @return a boolean that checks the lower bound
     */
    public boolean checkDownLimit() {
        return yPosition == verticalLimit - container.length + downRows;
    }
    /**
     * @return a boolean that checks the right limit
     */
    public boolean checkRightLimit() {
        return xPosition == horizontalLimit - container.length + rightColumns;
    }

    /**
     * @return a boolean that checks the right limit
     */
    public boolean checkLeftLimit() {
        return xPosition + leftColumns == 0;
    }

    /**
     * Decreases xPosition in one.
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
     * calculates free columns from right.
     * @return An integer that represents how many free columns shape container has.
     */
    public int reviewFromRight(final boolean[][] mat) {
        boolean rightColumnEmpty = true;
        int columnCounter = 0;
        int j = mat[0].length - 1;
        while (rightColumnEmpty && j >= 0) {
            int i = 0;
            while (rightColumnEmpty && i < mat.length) {
                rightColumnEmpty = rightColumnEmpty && !mat[i][j];
                i++;
            }
            if (rightColumnEmpty) {
                columnCounter++;
            }
            j--;
        }
        return columnCounter;
    }

    /**
     * calculates free columns from left.
     * @return An integer that represents how many free columns shape container has.
     */
    public int reviewFromLeft(final boolean[][] mat) {
        boolean leftColumnEmpty = true;
        int columnCounter = 0;
        int j = 0;
        while (leftColumnEmpty && j < mat[0].length) {
            int i = 0;
            while (leftColumnEmpty && i < mat.length) {
                leftColumnEmpty = leftColumnEmpty && !mat[i][j];
                i++;
            }
            if (leftColumnEmpty) {
                columnCounter++;
            }
            j++;
        }
        return columnCounter;
    }

    /**
     * calculates free rows from down.
     * @return An integer that represents how many free rows shape container has.
     */
    public int reviewFromDown(final boolean[][] mat) {
        boolean downRowEmpty = true;
        int rowCounter = 0;
        int i = mat[0].length - 1;
        while (downRowEmpty && i >= 0) {
            int j = 0;
            while (downRowEmpty && j < mat.length) {
                downRowEmpty = downRowEmpty && !mat[i][j];
                j++;
            }
            if (downRowEmpty) {
                rowCounter++;
            }
            i--;
        }
        return rowCounter;
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
        rightColumns = reviewFromRight(container);
        leftColumns = reviewFromLeft(container);
        downRows = reviewFromDown(container);
    }
}
