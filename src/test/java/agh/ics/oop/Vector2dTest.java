package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class Vector2dTest {
    @Test
    void testEquals(){
        //given
        Vector2d v1=new Vector2d(1,2);
        Vector2d v2=new Vector2d(2,3);
        Vector2d v3=new Vector2d(1,2);

        //result
        boolean v1_v2=v1.equals(v2);
        boolean v1_v3=v1.equals(v3);

        //then
        assertTrue(v1_v3,"wrong .equals method result");
        assertFalse(v1_v2);
    }

    @Test
    void testToString(){
        //given
        Vector2d v1=new Vector2d(100,300);

        //result
        String v1String=v1.toString();

        //then
        assertEquals(v1String,"(100,300)","wrong .toString method result");
    }

    @Test
    void testPrecedes(){
        //given
        Vector2d v1=new Vector2d(0,0);
        Vector2d v2 = new Vector2d(0, 1);

        //result
        boolean v1_v1=v1.precedes(v1);
        boolean v1_v2=v1.precedes(v2);
        boolean v2_v1=v2.precedes(v1);

        //then
        assertTrue(v1_v1,"wrong .precedes method result");
        assertTrue(v1_v2,"wrong .precedes method result");
        assertFalse(v2_v1,"wrong .precedes method result");
    }

    @Test
    void testFollows(){
        //given
        Vector2d v1=new Vector2d(0,0);
        Vector2d v2 = new Vector2d(0, 1);

        //result
        boolean v1_v1=v1.follows(v1);
        boolean v1_v2=v1.follows(v2);
        boolean v2_v1=v2.follows(v1);

        //then
        assertTrue(v1_v1,"wrong .follows method result");
        assertFalse(v1_v2,"wrong .follows method result");
        assertTrue(v2_v1,"wrong .follows method result");
    }

    @Test
    void testUpperRight(){
        //given
        Vector2d v1 = new Vector2d(50, 100);
        Vector2d v2 = new Vector2d(0, 200);
        Vector2d result1 = new Vector2d(50, 200);

        //result
        Vector2d v1_v2=v1.upperRight(v2);
        Vector2d v1_v1=v1.upperRight(v1);

        //then
        assertEquals(result1,v1_v2,"wrong .upperRight method result");
        assertEquals(v1,v1_v1,"wrong .upperRight method result");
    }

    @Test
    void testLowerLeft(){
        //given
        Vector2d v1 = new Vector2d(50, 100);
        Vector2d v2 = new Vector2d(0, 200);
        Vector2d result1 = new Vector2d(0, 100);

        //result
        Vector2d v1_v2=v1.lowerLeft(v2);
        Vector2d v1_v1=v1.lowerLeft(v1);

        //then
        assertEquals(result1,v1_v2,"wrong .lowerLeft method result");
        assertEquals(v1,v1_v1,"wrong .lowerLeft method result");
    }

    @Test
    void testAdd(){
        //given
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(-2,1);
        Vector2d result1 = new Vector2d(-1, 3);
        Vector2d result2 = new Vector2d(2, 4);

        //result
        Vector2d v1_v2=v1.add(v2);
        Vector2d v1_v1=v1.add(v1);

        //then
        assertEquals(v1_v2,result1,"wrong .add method result");
        assertEquals(v1_v1,result2,"wrong .aad method result");
    }

    @Test
    void testSubtract(){
        //given
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(-2,1);
        Vector2d result1 = new Vector2d(3, 1);
        Vector2d result2 = new Vector2d(0, 0);

        //result
        Vector2d v1_v2=v1.subtract(v2);
        Vector2d v1_v1=v1.subtract(v1);

        //then
        assertEquals(v1_v2,result1,"wrong .subtract method result");
        assertEquals(v1_v1,result2,"wrong .subtract method result");
    }

    @Test
    void testOpposite(){
        //given
        Vector2d v1 = new Vector2d(20, 30);
        Vector2d v2 = new Vector2d(0, 0);
        Vector2d result1 = new Vector2d(-20, -30);

        //result
        Vector2d v1Opposite=v1.opposite();
        Vector2d v2Opposite=v2.opposite();

        //then
        assertEquals(v1Opposite,result1);
        assertEquals(v2Opposite,v2);
    }

}
