package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {

    @Test
    public void drawLimitsTest(){
        try{
            //given
            GrassField grassField=new GrassField(0);
            //result
            Vector2d position = new Vector2d(2, 2);
            //then
            grassField.place(new Animal(grassField));
            assertEquals(grassField.getBoundary().getLowerLeftDraw(),position);
            assertEquals(grassField.getBoundary().getUpperRightDraw(),position);

            grassField.place(new Animal(grassField,new Vector2d(5,1)));
            assertEquals(grassField.getBoundary().getLowerLeftDraw(),new Vector2d(2,1));
            assertEquals(grassField.getBoundary().getUpperRightDraw(),new Vector2d(5,2));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void isOccupiedTest(){
        try{
            //given
            GrassField grassField=new GrassField(0);
            Animal animal=new Animal(grassField);
            //result
            grassField.place(animal);
            //then
            assertTrue(grassField.isOccupied(animal.getPosition()));
            assertFalse(grassField.isOccupied(new Vector2d(0,0)));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void placeTest(){
        //given
        try{
            GrassField grassField= new GrassField(0);
            Vector2d position1 = new Vector2d(2, 2);
            Vector2d position2 = new Vector2d(-1, -1);
            Vector2d position3 = new Vector2d(5, 5);
            //then
            assertDoesNotThrow(()->grassField.place(new Animal(grassField,position1)));
            assertThrows(IllegalAccessException.class,()->grassField.place(new Animal(grassField,position1)));
            assertDoesNotThrow(()->grassField.place(new Animal(grassField,position2)));
            assertDoesNotThrow(()->grassField.place(new Animal(grassField,position3)));
        }catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


    }

    @Test
    public void canMoveToTest(){
        try{
            //given
            GrassField grassField= new GrassField(0);
            Vector2d position1 = new Vector2d(2, 2);
            Vector2d position2 = new Vector2d(-1, -1);
            //result
            grassField.place(new Animal(grassField,position1));
            //then
            assertTrue(grassField.canMoveTo(position2));
            assertFalse(grassField.canMoveTo(position1));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }
}
