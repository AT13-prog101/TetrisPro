package src;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShapeITest {

    @Test
    public void draw_DrawingShapeI_ArrayOfNumbers() {
        ShapeI shapeI = new ShapeI(1, 1);
        int[][] actual = shapeI.draw();
        int[][] expected = {{ 1, 1, 1, 1}};
        assertArrayEquals(expected, actual);
    }
}