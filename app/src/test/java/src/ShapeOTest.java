package src;

import org.junit.Test;
import src.shapes.*;

import static org.junit.Assert.*;

public class ShapeOTest {
    @Test
    public void draw_DrawingShapeO_ArrayOfNumbers() {
        ShapeO shapeO = new ShapeO(4, 4);
        boolean[][] actual = shapeO.draw();
        boolean[][] expected = {{ true, true},
                                { true, true}};
        assertArrayEquals(expected, actual);
    }
}