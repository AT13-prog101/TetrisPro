package src;

import org.junit.Test;
import src.shapes.*;

import static org.junit.Assert.*;

public class ShapeLTest {
    @Test
    public void draw_DrawingShapeL_ArrayOfNumbers() {
        ShapeL shapeL = new ShapeL(3, 3);
        boolean[][] actual = shapeL.draw();
        boolean[][] expected = {{true, true, true},{true, false, false}};
        assertArrayEquals(expected, actual);
    }
}