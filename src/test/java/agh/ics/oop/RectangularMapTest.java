package agh.ics.oop;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    @BeforeEach
    void setUp() {
        IWorldMap map = new RectangularMap(10, 5);
    }

}