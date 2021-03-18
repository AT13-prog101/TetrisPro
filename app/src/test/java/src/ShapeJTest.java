package src;

import org.junit.Test;
import src.shapes.*;

import static org.junit.Assert.*;

public class ShapeJTest {
    @Test
    public void draw_DrawingShapeJ_ArrayOfNumbers() {
        ShapeJ shapeJ = new ShapeJ(2, 2);
        boolean[][] actual = shapeJ.getShapeJ();
        boolean[][] expected = {{false, false, true},
                                {false, false, true},
                                {false, true, true}};
        assertArrayEquals(expected, actual);

    }

}