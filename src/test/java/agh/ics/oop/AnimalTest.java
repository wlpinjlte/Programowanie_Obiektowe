package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    @Test
    void testToString(){
        //given
        RectangularMap map=new RectangularMap(5,5);
        Animal animal1 = new Animal(map);
        Animal animal2 = new Animal(map);
        Animal animal3 = new Animal(map);
        Animal animal4 = new Animal(map);
        //result
        animal2.move(MoveDirection.RIGHT);
        animal3.move(MoveDirection.LEFT);
        animal4.move(MoveDirection.LEFT);
        animal4.move(MoveDirection.LEFT);
        //then
        assertEquals(animal1.toString(),"N");
        assertEquals(animal2.toString(),"E");
        assertEquals(animal3.toString(),"W");
        assertEquals(animal4.toString(),"S");
    }

    @Test
    void testIsAtA(){
        //given
        Animal animal = new Animal(new RectangularMap(5,5),new Vector2d(2,2));
        //then
        assertTrue(animal.isAt(new Vector2d(2,2)));
        assertFalse(animal.isAt(new Vector2d(0,0)));
    }

    @Test
    void testIsAtB(){
        //given
        Animal animal = new Animal(new RectangularMap(5,5),new Vector2d(2,2));
        //result
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        //then
        assertTrue(animal.isAt(new Vector2d(2,4)));
    }

    @Test
    void testMoveA(){
        //given
        Animal animal = new Animal(new RectangularMap(5,5),new Vector2d(2,2));
        //result
        animal.move(MoveDirection.FORWARD);
        //then
        assertTrue(animal.isAt(new Vector2d(2,3)));
    }

    @Test
    void testMoveB(){
        //given
        Animal animal = new Animal(new RectangularMap(5,5),new Vector2d(2,2));
        //result
        animal.move(MoveDirection.BACKWARD);
        //then
        assertTrue(animal.isAt(new Vector2d(2,1)));
    }

    @Test
    void testMoveC(){
        //given
        Animal animal = new Animal(new RectangularMap(5,5),new Vector2d(2,2));
        //result
        animal.move(MoveDirection.LEFT);
        //then
        assertFalse(animal.isAt(new Vector2d(2,3)));
    }

    @Test
    void testMoveD(){
        //given
        Animal animal = new Animal(new RectangularMap(5,5),new Vector2d(2,2));
        //result
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.FORWARD);
        //then
        assertTrue(animal.isAt(new Vector2d(1,3)));
    }

    @Test
    void testMoveE(){
        //given
        Animal animal = new Animal(new RectangularMap(5,5),new Vector2d(2,2));
        //result
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        //then
        assertTrue(animal.isAt(new Vector2d(2,4)));
    }

    @Test
    void testMoveF(){
        //given
        Animal animal = new Animal(new RectangularMap(5,5),new Vector2d(2,2));
        //result
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        //then
        assertTrue(animal.isAt(new Vector2d(2,0)));
    }

    @Test
    void testMoveG(){
        //given
        Animal animal = new Animal(new RectangularMap(5,5),new Vector2d(2,2));
        //result
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        //then
        assertTrue(animal.isAt(new Vector2d(4,2)));
    }

    @Test
    void testMoveH(){
        //given
        Animal animal = new Animal(new RectangularMap(5,5),new Vector2d(2,2));
        //result
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        //then
        assertTrue(animal.isAt(new Vector2d(0,2)));
    }
}