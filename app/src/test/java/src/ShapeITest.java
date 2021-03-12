package src;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShapeITest {

    @Test
    public void draw_DrawingShapeI_ArrayOfNumbers() {
        ShapeI shapeI = new ShapeI(1, 1);
        int[][] actual = shapeI.draw();
        int[][] expected = {{ 1, 1, 1, 1}};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void itShouldMoveRight() {
        ShapeI shapeI = new ShapeI(4, 5);
        shapeI.moveRight();
        assertEquals(6, shapeI.getyPosition());
    }

    @Test
    public void itShouldMoveLeft() {
        ShapeI shapeI = new ShapeI(2, 3);
        shapeI.moveLeft();
        assertEquals(2, shapeI.getyPosition());
    }

    @Test
    public void itShouldMoveDown() {
        ShapeI shapeI = new ShapeI(7, 5);
        shapeI.moveDown();
        assertEquals(8, shapeI.getxPosition());
    }
}