package agh.ics.oop;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {
    @BeforeEach
    void setUp() {
        IWorldMap map = new GrassField(10);
    }
}