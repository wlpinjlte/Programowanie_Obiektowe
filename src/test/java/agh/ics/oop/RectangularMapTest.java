package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RectangularMapTest {
    @Test
    public void drawLimitsTest(){
        //given
        RectangularMap rectangularMap = new RectangularMap(5,10);

        //result
        Vector2d lowerLeftDraw=new Vector2d(0,0);
        Vector2d upperRightDraw=new Vector2d(4,9);

        //then
        assertEquals(lowerLeftDraw,rectangularMap.lowerLeftDraw());
        assertEquals(upperRightDraw,rectangularMap.upperRightDraw());
    }

    @Test
    public void canMoveToTest(){
        //given
        RectangularMap rectangularMap = new RectangularMap(5,5);

        //result
        Vector2d result = new Vector2d(2, 2);
        Vector2d outOfMap=new Vector2d(-1,-1);
        rectangularMap.place(new Animal(rectangularMap,result));

        //then
        assertFalse(rectangularMap.canMoveTo(result));
        assertFalse(rectangularMap.canMoveTo(outOfMap));
        assertTrue(rectangularMap.canMoveTo(new Vector2d(0,0)));
    }

    @Test
    public void isOccupiedTest(){
        //given
        RectangularMap rectangularMap = new RectangularMap(5,5);

        //result
        Vector2d result = new Vector2d(2, 2);
        rectangularMap.place(new Animal(rectangularMap,result));

        //then
        assertTrue(rectangularMap.isOccupied(result));
        assertFalse(rectangularMap.isOccupied(new Vector2d(0,0)));
    }

    @Test
    public void placeTest(){
        //given
        RectangularMap rectangularMap = new RectangularMap(5,5);

        //result
        Vector2d positonToPlace = new Vector2d(2, 2);
        Vector2d outOfMap=new Vector2d(-1,-1);

        //then
        assertTrue(rectangularMap.place(new Animal(rectangularMap,positonToPlace)));
        assertFalse(rectangularMap.place(new Animal(rectangularMap,positonToPlace)));
        assertFalse(rectangularMap.place(new Animal(rectangularMap,outOfMap)));
    }

    @Test
    public void objectAtTest(){
        //given
        RectangularMap rectangularMap = new RectangularMap(5,5);
        Vector2d postionToPlace = new Vector2d(2, 2);
        Animal animal=new Animal(rectangularMap,postionToPlace);

        //result
        rectangularMap.place(animal);

        //then
        assertEquals(animal,rectangularMap.objectAt(postionToPlace));
        assertEquals(null,rectangularMap.objectAt(new Vector2d(0,0)));
    }
}
