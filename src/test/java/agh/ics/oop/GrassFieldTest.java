package agh.ics.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {

    IWorldMap map;
    @BeforeEach
    void construct(){
        map = new GrassField(10);
    }

    @Test
    void IWorldMapTest(){
        Animal animal = new Animal(map, new Vector2d(2, 2));
        map.place(animal);
        map.place(new Animal(map, new Vector2d(100, 2)));
        assertTrue(map.isOccupied(new Vector2d(100, 2)));
        assertFalse(map.canMoveTo(new Vector2d(100, 2)));
        assertEquals(animal, map.objectAt(new Vector2d(2, 2)));
    }

}