package src;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShapeITest {

    @Test
    public void draw() {
        ShapeI shapeI = new ShapeI();
        int[][] actual = shapeI.draw();
        int[][] expected = {{ 1, 1, 1, 1}};
        assertArrayEquals(expected, actual);
    }
}