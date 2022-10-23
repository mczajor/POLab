package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void parsetest() {
        String[] args = {"f", "b", "left", "right", "", "do a backflip", "take a nap", " ", "123123", "forward", "backward", "l", "r"};
        MoveDirection[] expected = {MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.RIGHT,
                MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.RIGHT};
        assertArrayEquals(expected, OptionsParser.parse(args));
    }
}