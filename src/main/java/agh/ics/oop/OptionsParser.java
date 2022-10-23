package agh.ics.oop;
import java.util.ArrayList;


public class OptionsParser {
    public static MoveDirection[] parse(String[] args) {
        ArrayList<MoveDirection> directions = new ArrayList<>();
        for (String arg : args) {
            switch (arg) {
                case "f", "forward" -> directions.add(MoveDirection.FORWARD);
                case "b", "backward" -> directions.add(MoveDirection.BACKWARD);
                case "l", "left" -> directions.add(MoveDirection.LEFT);
                case "r", "right" -> directions.add(MoveDirection.RIGHT);
                default -> {
                }
            }
        }
        return directions.toArray(new MoveDirection[0]);
    }
}
