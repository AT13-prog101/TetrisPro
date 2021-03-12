package src;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShapeLTest {
    @Test
    public void draw_DrawingShapeL_ArrayOfNumbers() {
        ShapeL shapeL = new ShapeL();
        int[][] actual = shapeL.draw();
        int[][] expected = {{ 1, 1, 1},{ 1, 0, 0}};
        assertArrayEquals(expected, actual);
    }
}