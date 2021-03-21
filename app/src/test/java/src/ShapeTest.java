package src;

import org.junit.Test;
import src.shapes.Shape;
import src.shapes.ShapeType;

import static org.junit.Assert.*;

public class ShapeTest {
    @Test
    public void moveRight_changePositionX5_x6() {
        Shape shapeI = new Shape(5, 0, ShapeType.I);
        shapeI.moveRight();
        assertEquals(6, shapeI.getxPosition());
    }

    @Test
    public void moveRight_move3timesFromX5_x6() {
        Shape shapeI = new Shape(5, 0, ShapeType.I);
        shapeI.moveRight();
        shapeI.moveRight();
        shapeI.moveRight();
        assertEquals(6, shapeI.getxPosition());
    }

    @Test
    public void moveLeft_changePositionX2_x1() {
        Shape shapeI = new Shape(2, 3, ShapeType.S);
        shapeI.moveLeft();
        assertEquals(1, shapeI.getxPosition());
    }

    @Test
    public void moveLeft_move3timesFromX2_x0() {
        Shape shapeI = new Shape(2, 3, ShapeType.S);
        shapeI.moveLeft();
        shapeI.moveLeft();
        shapeI.moveLeft();
        assertEquals(0, shapeI.getxPosition());
    }

    @Test
    public void moveDown_changePositionY7_y8() {
        Shape shapeI = new Shape(5, 7, ShapeType.Z);
        shapeI.moveDown();
        assertEquals(8, shapeI.getyPosition());
    }

    @Test
    public void moveDown_moveShapeI4timesFromY16_y19() {
        Shape shapeI = new Shape(5, 16, 10, 20, ShapeType.I);
        shapeI.moveDown();
        shapeI.moveDown();
        shapeI.moveDown();
        shapeI.moveDown();
        assertEquals(19, shapeI.getyPosition());
    }
    @Test
    public void moveDown_moveShapeS3timesFromY16_y18() {
        Shape shapeI = new Shape(5, 16, 10, 20, ShapeType.S);
        shapeI.moveDown();
        shapeI.moveDown();
        shapeI.moveDown();
        assertEquals(18, shapeI.getyPosition());
    }

    @Test
    public void moveDown_moveShapeO2timesFromY17_y18() {
        Shape shapeI = new Shape(5, 17, 10, 20, ShapeType.O);
        shapeI.moveDown();
        shapeI.moveDown();
        assertEquals(18, shapeI.getyPosition());
    }

    @Test
    public void transposeMatrix_changePositionShapeI_shapeIHorizontal() {
        Shape shapeI = new Shape(7, 5, 10, 20, ShapeType.I);
        boolean[][] actual = shapeI.transposeMatrix(shapeI.getContainer());
        boolean[][] expected = {{ true, false, false, false},
                                { true, false, false, false},
                                { true, false, false, false},
                                { true, false, false, false}};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void reverseMatrix_changePositionShapeI_shapeIVertical() {
        Shape shapeI = new Shape(7, 5,10, 20, ShapeType.I);
        boolean[][] actual = shapeI.reverseMatrix(shapeI.getContainer());
        boolean[][] expected = {{ false, false, false, false},
                                { false, false, false, false},
                                { false, false, false, false},
                                { true, true, true, true}};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void rotateShape_changePositionShapeT_shapeTVertical() {
        Shape shapeT = new Shape(7, 5,10, 20, ShapeType.T);
        boolean[][] actual = shapeT.rotateShape();
        boolean[][] expected = {{true, false, false},
                                {true, true, false},
                                {true, false, false}};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void rotateShape_changePositionShapeSOneMove_shapeSVertical() {
        Shape shapeS = new Shape(7, 5,10, 20, ShapeType.S);
        boolean[][] actual = shapeS.rotateShape();
        boolean[][] expected = {{false, true, false},
                                {true, true, false},
                                {true, false, false}};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void rotateShape_changePositionShapeSTwoMoves_shapeSHorizontal() {
        Shape shapeS = new Shape(7, 5,10, 20, ShapeType.S);
        shapeS.rotateShape();
        boolean[][] actual = shapeS.rotateShape();
        boolean[][] expected = {{false, false, false},
                                 {true, true, false},
                                 {false, true, true}};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void rotateShape_changePositionShapeSThreeMoves_shapeSVertical() {
        Shape shapeS = new Shape(7, 5,10, 20, ShapeType.S);
        shapeS.rotateShape();
        shapeS.rotateShape();
        boolean[][] actual = shapeS.rotateShape();
        boolean[][] expected = {{false, true, false},
                                 {false, true, true},
                                 {false, false, true}};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void rotateShape_changePositionShapeSFourMoves_shapeSVertical() {
        Shape shapeS = new Shape(7, 5,10, 20, ShapeType.S);
        shapeS.rotateShape();
        shapeS.rotateShape();
        shapeS.rotateShape();
        boolean[][] actual = shapeS.rotateShape();
        boolean[][] expected = {{false, true, true},
                                {true, true, false},
                                {false, false, false}};
        assertArrayEquals(expected, actual);
    }
}