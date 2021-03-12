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
        ShapeI shapeI = new ShapeI(posX, posY);
        assertEquals(shapeI.getClass(),randomShape.getShape(0, posX, posY).getClass());
    }

    @Test
    public void getShape_GetRandomNumber_ShapeJ() {
        RandomShape randomShape = new RandomShape();
        int posX = 2;
        int posY = 2;
        ShapeJ shapeJ = new ShapeJ(posX, posY);
        assertEquals(shapeJ.getClass(),randomShape.getShape(1, posX, posY).getClass());
    }

    @Test
    public void getShape_GetRandomNumber_ShapeL() {
        RandomShape randomShape = new RandomShape();
        int posX = 2;
        int posY = 2;
        ShapeL shapeL = new ShapeL(posX, posY);
        assertEquals(shapeL.getClass(),randomShape.getShape(2, posX, posY).getClass());
    }

    @Test
    public void getShape_GetRandomNumber_ShapeO() {
        RandomShape randomShape = new RandomShape();
        int posX = 2;
        int posY = 2;
        ShapeO shapeO = new ShapeO(posX, posY);
        assertEquals(shapeO.getClass(),randomShape.getShape(3, posX, posY).getClass());
    }

    @Test
    public void getShape_GetRandomNumber_ShapeS() {
        RandomShape randomShape = new RandomShape();
        int posX = 2;
        int posY = 2;
        ShapeS shapeS = new ShapeS(posX, posY);
        assertEquals(shapeS.getClass(),randomShape.getShape(4, posX, posY).getClass());
    }

    @Test
    public void getShape_GetRandomNumber_ShapeT() {
        RandomShape randomShape = new RandomShape();
        int posX = 2;
        int posY = 2;
        ShapeT shapeT = new ShapeT(posX, posY);
        assertEquals(shapeT.getClass(),randomShape.getShape(5, posX, posY).getClass());
    }

    @Test
    public void getShape_GetRandomNumber_ShapeZ() {
        RandomShape randomShape = new RandomShape();
        int posX = 2;
        int posY = 2;
        ShapeZ shapeZ = new ShapeZ(posX, posY);
        assertEquals(shapeZ.getClass(),randomShape.getShape(6, posX, posY).getClass());
    }
}