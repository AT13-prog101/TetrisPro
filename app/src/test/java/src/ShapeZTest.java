package src;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShapeZTest {
    @Test
    public void draw_DrawingShapeZ_ArrayOfNumbers() {
        ShapeZ shapeZ = new ShapeZ();
        int[][] actual = shapeZ.draw();
        int[][] expected = {{ 1, 1, 0},{ 0, 1, 1}};
        assertArrayEquals(expected, actual);
    }
}