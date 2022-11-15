package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class GrassFieldTest {

    @Test
    public void drawLimitsTest(){
        //given
        GrassField grassField=new GrassField(0);
        //result
        Vector2d position = new Vector2d(2, 2);

        //then
        grassField.place(new Animal(grassField));
        assertEquals(grassField.lowerLeftDraw(),position);
        assertEquals(grassField.upperRightDraw(),position);

        grassField.place(new Animal(grassField,new Vector2d(5,1)));
        assertEquals(grassField.lowerLeftDraw(),new Vector2d(2,1));
        assertEquals(grassField.upperRightDraw(),new Vector2d(5,2));
    }

    @Test
    public void isOccupiedTest(){
        //given
        GrassField grassField=new GrassField(0);
        Animal animal=new Animal(grassField);
        //result
        grassField.place(animal);
        //then
        assertTrue(grassField.isOccupied(animal.getPosition()));
        assertFalse(grassField.isOccupied(new Vector2d(0,0)));
    }

    @Test
    public void placeTest(){
        //given
        GrassField grassField= new GrassField(0);
        Vector2d position1 = new Vector2d(2, 2);
        Vector2d position2 = new Vector2d(-1, -1);
        Vector2d position3 = new Vector2d(5, 5);
        //then
        assertTrue(grassField.place(new Animal(grassField,position1)));
        assertFalse(grassField.place(new Animal(grassField,position1)));
        assertTrue(grassField.place(new Animal(grassField,position2)));
        assertTrue(grassField.place(new Animal(grassField,position3)));
    }

    @Test
    public void canMoveToTest(){
        //given
        GrassField grassField= new GrassField(0);
        Vector2d position1 = new Vector2d(2, 2);
        Vector2d position2 = new Vector2d(-1, -1);
        //result
        grassField.place(new Animal(grassField,position1));
        //then
        assertTrue(grassField.canMoveTo(position2));
        assertFalse(grassField.canMoveTo(position1));
    }
}
