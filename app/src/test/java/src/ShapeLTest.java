package src;

import org.junit.Test;
import src.shapes.*;

import static org.junit.Assert.*;

public class ShapeLTest {
    @Test
    public void draw_DrawingShapeL_ArrayOfNumbers() {
        ShapeL shapeL = new ShapeL(3, 3);
        boolean[][] actual = shapeL.getShapeL();
        boolean[][] expected = {{ true, false, false},
                                { true, false, false},
                                { true, true, false}};
        assertArrayEquals(expected, actual);

    }
}