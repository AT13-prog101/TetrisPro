package src;
import src.shapes.*;
import src.utilities.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class RandomShapeTest {

    @Test
    public void getShape_GetRandomNumber_ShapeI() {
        RandomShape randomShape = new RandomShape();
        int posX = 2;
        int posY = 2;
        Shape shapeI = new Shape(posX, posY ,ShapeType.I);
        assertEquals(shapeI.getClass(),randomShape.getShape(0, posX, posY).getClass());
    }

    @Test
    public void getShape_GetRandomNumber_ShapeJ() {
        RandomShape randomShape = new RandomShape();
        int posX = 2;
        int posY = 2;
        Shape shapeJ = new Shape(posX, posY, ShapeType.J);
        assertEquals(shapeJ.getClass(),randomShape.getShape(1, posX, posY).getClass());
    }

    @Test
    public void getShape_GetRandomNumber_ShapeL() {
        RandomShape randomShape = new RandomShape();
        int posX = 2;
        int posY = 2;
        Shape shapeL = new Shape(posX, posY, ShapeType.L);
        assertEquals(shapeL.getClass(),randomShape.getShape(2, posX, posY).getClass());
    }

    @Test
    public void getShape_GetRandomNumber_ShapeO() {
        RandomShape randomShape = new RandomShape();
        int posX = 2;
        int posY = 2;
        Shape shapeO = new Shape(posX, posY, ShapeType.O);
        assertEquals(shapeO.getClass(),randomShape.getShape(3, posX, posY).getClass());
    }

    @Test
    public void getShape_GetRandomNumber_ShapeS() {
        RandomShape randomShape = new RandomShape();
        int posX = 2;
        int posY = 2;
        Shape shapeS = new Shape(posX, posY, ShapeType.S);
        assertEquals(shapeS.getClass(),randomShape.getShape(4, posX, posY).getClass());
    }

    @Test
    public void getShape_GetRandomNumber_ShapeT() {
        RandomShape randomShape = new RandomShape();
        int posX = 2;
        int posY = 2;
        Shape shapeT = new Shape(posX, posY, ShapeType.T);
        assertEquals(shapeT.getClass(),randomShape.getShape(5, posX, posY).getClass());
    }

    @Test
    public void getShape_GetRandomNumber_ShapeZ() {
        RandomShape randomShape = new RandomShape();
        int posX = 2;
        int posY = 2;
        Shape shapeZ = new Shape(posX, posY, ShapeType.Z);
        assertEquals(shapeZ.getClass(),randomShape.getShape(6, posX, posY).getClass());
    }
}