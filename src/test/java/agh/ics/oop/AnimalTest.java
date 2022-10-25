package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    @Test
    void testToString(){
        //given
        Animal animal1 = new Animal();
        Animal animal2 = new Animal();
        //result
        animal2.move(MoveDirection.FORWARD);
        animal2.move(MoveDirection.FORWARD);
        animal2.move(MoveDirection.RIGHT);
        animal2.move(MoveDirection.BACKWARD);
        //then
        assertEquals(animal1.toString(),"Position:(2,2) Direction:Północ");
        assertEquals(animal2.toString(),"Position:(1,4) Direction:Wschód");
    }

    @Test
    void testIsAtA(){
        //given
        Animal animal = new Animal();
        //then
        assertTrue(animal.isAt(new Vector2d(2,2)));
        assertFalse(animal.isAt(new Vector2d(0,0)));
    }

    @Test
    void testIsAtB(){
        //given
        Animal animal = new Animal();
        //result
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        //then
        assertTrue(animal.isAt(new Vector2d(2,4)));
    }

    @Test
    void testMoveA(){
        //given
        Animal animal = new Animal();
        //result
        animal.move(MoveDirection.FORWARD);
        //then
        assertTrue(animal.isAt(new Vector2d(2,3)));
    }

    @Test
    void testMoveB(){
        //given
        Animal animal = new Animal();
        //result
        animal.move(MoveDirection.BACKWARD);
        //then
        assertTrue(animal.isAt(new Vector2d(2,1)));
    }

    @Test
    void testMoveC(){
        //given
        Animal animal = new Animal();
        //result
        animal.move(MoveDirection.LEFT);
        //then
        assertFalse(animal.isAt(new Vector2d(2,3)));
    }

    @Test
    void testMoveD(){
        //given
        Animal animal = new Animal();
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
        Animal animal = new Animal();
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
        Animal animal = new Animal();
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
        Animal animal = new Animal();
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
        Animal animal = new Animal();
        //result
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        //then
        assertTrue(animal.isAt(new Vector2d(0,2)));
    }
}