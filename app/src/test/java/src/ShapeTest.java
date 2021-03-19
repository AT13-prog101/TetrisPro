package src;

import org.junit.Test;
import src.shapes.ShapeI;
import src.shapes.ShapeT;

import static org.junit.Assert.*;

public class ShapeTest {
    @Test
    public void moveRight_changePositionY5_y6() {
        ShapeI shapeI = new ShapeI(4, 5);
        shapeI.moveRight();
        assertEquals(6, 6);
    }

    @Test
    public void moveLeft_changePositionY3_y2() {
        ShapeI shapeI = new ShapeI(2, 3);
        shapeI.moveLeft();
        assertEquals(2, shapeI.getyPosition());
    }

    @Test
    public void moveDown_changePositionX7_x8() {
        ShapeI shapeI = new ShapeI(7, 5);
        shapeI.moveDown();
        assertEquals(8, shapeI.getxPosition());
    }

    @Test
    public void transposeMatrix_changePositionShapeI_shapeIHorizontal() {
        ShapeI shapeI = new ShapeI(7, 5);
        boolean[][] actual = shapeI.transposeMatrix(shapeI.getShapeI());
        boolean[][] expected = {{ true, true, true, true},
                                { false, false, false, false},
                                { false, false, false, false},
                                { false, false, false, false}};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void reverseMatrix_changePositionShapeI_shapeIVertical() {
        ShapeI shapeI = new ShapeI(7, 5);
        boolean[][] actual = shapeI.reverseMatrix(shapeI.getShapeI());
        boolean[][] expected = {{ true, false, false, false},
                                { true, false, false, false},
                                { true, false, false, false},
                                { true, false, false, false}};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void rotateShape_changePositionShapeT_shapeTVertical() {
        ShapeT shapeT = new ShapeT(7, 5);
        boolean[][] actual = shapeT.rotateShape(shapeT.getShapeT());
        boolean[][] expected = {{true, false, false},
                                {true, true, false},
                                {true, false, false}};
        assertArrayEquals(expected, actual);
    }
}