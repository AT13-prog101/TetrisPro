package src;

import org.junit.Test;

import static org.junit.Assert.*;

public class RandomShapeTest {

    @Test
    public void getShape_GetRandomNumber_ShapeI() {
        RandomShape randomShape = new RandomShape();
        ShapeI shapeI = new ShapeI();
        assertEquals(shapeI.getClass(),randomShape.getShape(0).getClass());
    }

    @Test
    public void getShape_GetRandomNumber_ShapeJ() {
        RandomShape randomShape = new RandomShape();
        ShapeJ shapeJ = new ShapeJ();
        assertEquals(shapeJ.getClass(),randomShape.getShape(1).getClass());
    }

    @Test
    public void getShape_GetRandomNumber_ShapeL() {
        RandomShape randomShape = new RandomShape();
        ShapeL shapeL = new ShapeL();
        assertEquals(shapeL.getClass(),randomShape.getShape(2).getClass());
    }

    @Test
    public void getShape_GetRandomNumber_ShapeO() {
        RandomShape randomShape = new RandomShape();
        ShapeO shapeO = new ShapeO();
        assertEquals(shapeO.getClass(),randomShape.getShape(3).getClass());
    }

    @Test
    public void getShape_GetRandomNumber_ShapeS() {
        RandomShape randomShape = new RandomShape();
        ShapeS shapeS = new ShapeS();
        assertEquals(shapeS.getClass(),randomShape.getShape(4).getClass());
    }

    @Test
    public void getShape_GetRandomNumber_ShapeT() {
        RandomShape randomShape = new RandomShape();
        ShapeT shapeT = new ShapeT();
        assertEquals(shapeT.getClass(),randomShape.getShape(5).getClass());
    }

    @Test
    public void getShape_GetRandomNumber_ShapeZ() {
        RandomShape randomShape = new RandomShape();
        ShapeZ shapeZ = new ShapeZ();
        assertEquals(shapeZ.getClass(),randomShape.getShape(6).getClass());
    }
}