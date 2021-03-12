package src;

import org.junit.Test;
import src.shapes.*;

import static org.junit.Assert.*;

public class ShapeJTest {
    @Test
    public void draw_DrawingShapeJ_ArrayOfNumbers() {
        ShapeJ shapeJ = new ShapeJ(2, 2);
        int[][] actual = shapeJ.draw();
        int[][] expected = {{ 1, 1, 1},{ 0, 0, 1}};
        assertArrayEquals(expected, actual);
    }

}