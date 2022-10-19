package agh.ics.oop;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @org.junit.jupiter.api.Test
    void testToString() {
        assertAll(()-> assertEquals("(1,2)", new Vector2d(1,2).toString()),
                ()-> assertEquals("(-100,1000)", new Vector2d(-100, 1000).toString()));
    }

    @org.junit.jupiter.api.Test
    void precedes() {
        assertAll(()->assertTrue(new Vector2d(1,1).precedes(new Vector2d(2,2))),
                ()->assertTrue(new Vector2d(2,2).precedes(new Vector2d(2,3))),
                ()->assertFalse(new Vector2d(100,10000).precedes(new Vector2d(2,2))));
    }

    @org.junit.jupiter.api.Test
    void follows() {
        assertAll(()->assertFalse(new Vector2d(1,1).follows(new Vector2d(2,2))),
                ()->assertFalse(new Vector2d(2,2).follows(new Vector2d(2,3))),
                ()->assertTrue(new Vector2d(100,10000).follows(new Vector2d(2,2))));
    }

    @org.junit.jupiter.api.Test
    void add() {
        assertAll( ()-> assertEquals(new Vector2d(3, 3),new Vector2d(1,1).add(new Vector2d(2,2))),
                ()-> assertEquals(new Vector2d(0, 0), new Vector2d(-100,999).add(new Vector2d(100,-999))));
    }

    @org.junit.jupiter.api.Test
    void subtract() {
        assertAll( ()-> assertEquals(new Vector2d(-1, -1),new Vector2d(1,1).subtract(new Vector2d(2,2))),
                ()-> assertEquals(new Vector2d(-200, 1998), new Vector2d(-100,999).subtract(new Vector2d(100,-999)) ));
    }

    @org.junit.jupiter.api.Test
    void upperRight() {
        assertAll( ()-> assertEquals(new Vector2d(3, 3), new Vector2d(3, 2).upperRight(new Vector2d(2, 3))),
                () -> assertEquals(new Vector2d( 1, 1), new Vector2d(1, 1).upperRight(new Vector2d(0, 0))));
    }

    @org.junit.jupiter.api.Test
    void lowerLeft() {
        assertAll( ()-> assertEquals(new Vector2d(2, 2), new Vector2d(3, 2).lowerLeft(new Vector2d(2, 3))),
                () -> assertEquals(new Vector2d( 0, 0), new Vector2d(1, 1).lowerLeft(new Vector2d(0, 0))));
    }

    @org.junit.jupiter.api.Test
    void opposite() {
        assertAll( ()-> assertEquals(new Vector2d(-1,-1), new Vector2d(1,1).opposite()),
                ()-> assertEquals(new Vector2d(-100, 999), new Vector2d(100,  -999).opposite()));
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
        Vector2d temp = new Vector2d(1 ,1);
        assertAll ( ()-> assertTrue(temp.equals(new Vector2d(1,1))),
                () -> assertTrue( temp.equals(temp) ),
                () -> assertFalse( temp.equals(MapDirection.NORTH)),
                () -> assertFalse( temp.equals(new Vector2d(2, 2))));
    }
}