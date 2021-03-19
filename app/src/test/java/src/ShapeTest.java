package src;

import org.junit.Test;
import src.shapes.Shape;
import src.shapes.ShapeType;

import static org.junit.Assert.*;

public class ShapeTest {
    @Test
    public void moveRight_changePositionY5_y6() {
        Shape shapeI = new Shape(4, 5, ShapeType.I);
        shapeI.moveRight();
        assertEquals(5, shapeI.getyPosition());
    }

    @Test
    public void moveLeft_changePositionY3_y2() {
        Shape shapeI = new Shape(2, 3, ShapeType.I);
        shapeI.moveLeft();
        assertEquals(2, shapeI.getyPosition());
    }

    @Test
    public void moveDown_changePositionX7_x8() {
        Shape shapeI = new Shape(7, 5, ShapeType.I);
        shapeI.moveDown();
        assertEquals(8, shapeI.getxPosition());
    }

    @Test
    public void transposeMatrix_changePositionShapeI_shapeIHorizontal() {
        Shape shapeI = new Shape(7, 5, ShapeType.I);
        boolean[][] actual = shapeI.transposeMatrix(shapeI.getContainer());
        boolean[][] expected = {{ true, true, true, true},
                                { false, false, false, false},
                                { false, false, false, false},
                                { false, false, false, false}};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void reverseMatrix_changePositionShapeI_shapeIVertical() {
        Shape shapeI = new Shape(7, 5, ShapeType.I);
        boolean[][] actual = shapeI.reverseMatrix(shapeI.getContainer());
        boolean[][] expected = {{ true, false, false, false},
                                { true, false, false, false},
                                { true, false, false, false},
                                { true, false, false, false}};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void rotateShape_changePositionShapeT_shapeTVertical() {
        Shape shapeT = new Shape(7, 5, ShapeType.T);
        boolean[][] actual = shapeT.rotateShape(shapeT.getContainer());
        boolean[][] expected = {{true, false, false},
                                {true, true, false},
                                {true, false, false}};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void rotateShape_changePositionShapeS_shapeSHorizontal() {
        Shape shapeS = new Shape(7, 5, ShapeType.S);
        boolean[][] actual = shapeS.rotateShape(shapeS.rotateShape(shapeS.getContainer()));
        boolean[][] expected = {{true, false, false},
                                 {true, true, false},
                                 {false, true, false}};
        assertArrayEquals(expected, actual);
    }
}