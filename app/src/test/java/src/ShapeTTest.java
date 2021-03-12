package src;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShapeTTest {

    @Test
    public void draw_DrawingShapeT_ArrayOfNumbers() {
        ShapeT shapeT = new ShapeT(6, 6);
        int[][] actual = shapeT.draw();
        int[][] expected = {{ 1, 1, 1},{ 0, 1, 0}};
        assertArrayEquals(expected, actual);
    }
}