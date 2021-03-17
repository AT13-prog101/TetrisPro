package src;

import org.junit.Test;
import src.shapes.*;

import static org.junit.Assert.*;

public class ShapeJTest {
    @Test
    public void draw_DrawingShapeJ_ArrayOfNumbers() {
        ShapeJ shapeJ = new ShapeJ(2, 2);
        boolean[][] actual = shapeJ.draw();
        boolean[][] expected = {{ true, true, true},
                                { false, false, true},
                                { false, false, false}};
        assertArrayEquals(expected, actual);

    }

}