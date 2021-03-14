package src;

import org.junit.Test;
import src.shapes.*;

import static org.junit.Assert.*;

public class ShapeZTest {
    @Test
    public void draw_DrawingShapeZ_ArrayOfNumbers() {
        ShapeZ shapeZ = new ShapeZ(7, 7);
        boolean[][] actual = shapeZ.draw();
        boolean[][] expected = {{true, true, false},{false, true, true}};
        assertArrayEquals(expected, actual);
    }
}