package agh.ics.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    Animal animal;
    @BeforeEach
    void construct(){
        animal = new Animal();
    }

    @Test
    void turningTest(){
        ArrayList<MapDirection> output = new ArrayList<>();
        MapDirection[] expected = {MapDirection.NORTH, MapDirection.EAST, MapDirection.SOUTH, MapDirection.WEST, MapDirection.NORTH,
                MapDirection.EAST, MapDirection.NORTH, MapDirection.WEST, MapDirection.SOUTH, MapDirection.EAST};
        for(int i=0; i<5;i++){
            output.add(animal.getOrientation());
            animal.move(MoveDirection.RIGHT);
        }
        for(int i=0; i<5; i++){
            output.add(animal.getOrientation());
            animal.move(MoveDirection.LEFT);
        }
        System.out.println(output.size());
        assertArrayEquals(expected, output.toArray(new MapDirection[0]));
    }

    @Test
    void movementTest(){
        String[] args = {"f", "b", "left", "right", "forward", "backward", "l", "r", "forward", "forward", "right", "forward"};
        MoveDirection[] moves = OptionsParser.parse(args);
        for(MoveDirection direction: moves){
            animal.move(direction);
        }
        assertAll(
                () -> assertEquals(MapDirection.EAST, animal.getOrientation()),
                () -> assertTrue(animal.isAt(new Vector2d(3,4)))
        );
    }
    @Test
    void outOfBoundsTest(){
        for(int i=0; i<15; i++){
            animal.move(MoveDirection.FORWARD);
        }
        assertTrue(animal.isAt(new Vector2d(2,4)));
        for (int i=0; i<15; i++){
            animal.move(MoveDirection.BACKWARD);
        }
        assertTrue(animal.isAt((new Vector2d(2,0))));
    }
}