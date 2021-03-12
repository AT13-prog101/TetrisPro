package src;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShapeSTest {

    @Test
    public void draw_DrawingShapeS_ArrayOfNumbers() {
        ShapeS shapeS = new ShapeS(5, 5);
        int[][] actual = shapeS.draw();
        int[][] expected = {{ 0, 1, 1},{ 1, 1, 0}};
        assertArrayEquals(expected, actual);
    }
}