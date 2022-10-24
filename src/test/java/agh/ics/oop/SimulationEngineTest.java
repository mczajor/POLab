package agh.ics.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimulationEngineTest {

    IWorldMap map;
    @BeforeEach
    void construct(){
        map = new RectangularMap(10, 5);
    }

    @Test
    void OneAnimalTest(){
        String[] args = {"f", "f", "f","f","f","f", "r", "f", "f", "r","b", "b"};
        MoveDirection[] directions = OptionsParser.parse(args);
        Vector2d[] positions = {new Vector2d(2, 2)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(4, 4)));
    }

    @Test
    void MultipleAnimalTest(){
        String[] args = {"r", "l", "f", "f", "f", "f", "f", "f", "r",
                        "r", "f", "b", "f", "b", "f", "b", "f", "b"};
        MoveDirection[] directions = OptionsParser.parse(args);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 2), new Vector2d(2,2)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue( map.isOccupied(new Vector2d(2, 0)));
        assertTrue( map.isOccupied(new Vector2d(3, 0)));
    }

}