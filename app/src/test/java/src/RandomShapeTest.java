package src;

import org.junit.Test;

import static org.junit.Assert.*;

public class RandomShapeTest {

    @Test
    public void itShouldGetShape() {
        RandomShape randomShape = new RandomShape();
        ShapeI shapeI = new ShapeI();
        ShapeJ shapeJ = new ShapeJ();
        ShapeL shapeL = new ShapeL();
        ShapeO shapeO = new ShapeO();
        ShapeS shapeS = new ShapeS();
        ShapeT shapeT = new ShapeT();
        ShapeZ shapeZ = new ShapeZ();
        assertEquals(shapeI.getClass(),randomShape.getShape(0).getClass());
        assertEquals(shapeJ.getClass(),randomShape.getShape(1).getClass());
        assertEquals(shapeL.getClass(),randomShape.getShape(2).getClass());
        assertEquals(shapeO.getClass(),randomShape.getShape(3).getClass());
        assertEquals(shapeS.getClass(),randomShape.getShape(4).getClass());
        assertEquals(shapeT.getClass(),randomShape.getShape(5).getClass());
        assertEquals(shapeZ.getClass(),randomShape.getShape(6).getClass());
    }
}