package src;

import org.junit.Test;
import src.shapes.*;

import static org.junit.Assert.*;

public class ShapeSTest {

    @Test
    public void draw_DrawingShapeS_ArrayOfNumbers() {
        ShapeS shapeS = new ShapeS(5, 5);
        boolean[][] actual = shapeS.draw();
        boolean[][] expected = {{false, true, true},{true, true, false}};
        assertArrayEquals(expected, actual);
    }
}