package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {

    @Test
    void testNext() {
        //given
        MapDirection east=MapDirection.EAST;
        MapDirection west=MapDirection.WEST;
        MapDirection north=MapDirection.NORTH;
        MapDirection south=MapDirection.SOUTH;

        //result
        MapDirection eastNext=MapDirection.EAST.next();
        MapDirection westNext=MapDirection.WEST.next();
        MapDirection northNext=MapDirection.NORTH.next();
        MapDirection southNext=MapDirection.SOUTH.next();

        //then
        assertEquals(east, northNext,"wrong result in north.next");
        assertEquals(west, southNext, "wrong result in south.next");
        assertEquals(north, westNext,"wrong result in west.next");
        assertEquals(south, eastNext,"wrong result in east.next");
    }

    @Test
    void testPrevious() {
        //given
        MapDirection east=MapDirection.EAST;
        MapDirection west=MapDirection.WEST;
        MapDirection north=MapDirection.NORTH;
        MapDirection south=MapDirection.SOUTH;

        //result
        MapDirection eastPrevious=MapDirection.EAST.previous();
        MapDirection westPrevious=MapDirection.WEST.previous();
        MapDirection northPrevious=MapDirection.NORTH.previous();
        MapDirection southPrevious=MapDirection.SOUTH.previous();

        //then
        assertEquals(east, southPrevious,"wrong result in south.previous");
        assertEquals(west, northPrevious,"wrong result in north.previous");
        assertEquals(north, eastPrevious,"wrong result in east.previous");
        assertEquals(south, westPrevious,"wrong result in west.previous");
    }
}