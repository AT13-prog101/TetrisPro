package src;

import org.junit.Test;
import src.shapes.*;

import static org.junit.Assert.*;

public class ShapeSTest {

    @Test
    public void draw_DrawingShapeS_ArrayOfNumbers() {
        ShapeS shapeS = new ShapeS(5, 5);
        boolean[][] actual = shapeS.getShapeS();
        boolean[][] expected = {{ false, true, true},
                                { true, true, false},
                                { false, false, false}};
        assertArrayEquals(expected, actual);

    }
}