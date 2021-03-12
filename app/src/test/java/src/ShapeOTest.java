package src;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShapeOTest {
    @Test
    public void draw_DrawingShapeO_ArrayOfNumbers() {
        ShapeO shapeO = new ShapeO(4, 4);
        int[][] actual = shapeO.draw();
        int[][] expected = {{ 1, 1},{ 1, 1}};
        assertArrayEquals(expected, actual);
    }
}