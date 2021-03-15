package src;

import org.junit.Test;
import src.shapes.*;

import static org.junit.Assert.*;

public class ShapeTTest {

    @Test
    public void draw_DrawingShapeT_ArrayOfNumbers() {
        ShapeT shapeT = new ShapeT(6, 6);
        boolean[][] actual = shapeT.draw();
        boolean[][] expected = {{ true, true, true},
                                { false, true, false},
                                { false, false, false}};
        assertArrayEquals(expected, actual);

    }
}