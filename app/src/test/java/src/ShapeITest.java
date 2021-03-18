package src;
import org.junit.Test;
import src.shapes.*;

import static org.junit.Assert.*;

public class ShapeITest {

    @Test
    public void draw_DrawingShapeI_ArrayOfNumbers() {
        ShapeI shapeI = new ShapeI(1, 1);
        boolean[][] actual = shapeI.getShapeI();
        boolean[][] expected = {{ true, false, false, false},
                                { true, false, false, false},
                                { true, false, false, false},
                                { true, false, false, false}};
        assertArrayEquals(expected, actual);
    }
}