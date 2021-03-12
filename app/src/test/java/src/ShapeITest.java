package src;
import static org.junit.Assert.*;
import org.junit.Test;
public class ShapeITest {

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
