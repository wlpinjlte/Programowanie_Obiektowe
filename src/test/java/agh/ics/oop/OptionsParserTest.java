package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {
    @Test
     void testPraseA(){
        //given
        MoveDirection[] directions = OptionsParser.parse(new String[]{"f", "forward", "b", "backward", "r", "right", "l", "left"});

        //result
        int lenght=8;

        //then
        assertEquals(lenght, directions.length);
        assertEquals(MoveDirection.FORWARD, directions[0]);
        assertEquals(MoveDirection.FORWARD, directions[1]);
        assertEquals(MoveDirection.BACKWARD, directions[2]);
        assertEquals(MoveDirection.BACKWARD, directions[3]);
        assertEquals(MoveDirection.RIGHT, directions[4]);
        assertEquals(MoveDirection.RIGHT, directions[5]);
        assertEquals(MoveDirection.LEFT, directions[6]);
        assertEquals(MoveDirection.LEFT, directions[7]);
    }

    @Test
    void testPraseB(){
        //given
        String []toPrase= new String[]{"f", "forward", "b", "backward", "r", "fdfddf"};

        //then
        assertThrows(IllegalArgumentException.class, () -> OptionsParser.parse(toPrase));
    }
}