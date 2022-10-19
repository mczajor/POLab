package agh.ics.oop;

import java.util.Arrays;


public class OptionsParser {
    public static MoveDirection[] parse(String[] args) {
        MoveDirection[] directions = new MoveDirection[args.length];
        int it = 0;
        for (String arg : args) {
            switch (arg.charAt(0)) {
                case 'f':
                    directions[it] = MoveDirection.FORWARD;
                    it += 1;
                    break;
                case 'b':
                    directions[it] = MoveDirection.BACKWARD;
                    it += 1;
                    break;
                case 'l':
                    directions[it] = MoveDirection.LEFT;
                    it += 1;
                    break;
                case 'r':
                    directions[it] = MoveDirection.RIGHT;
                    it += 1;
                    break;
                default:
                    break;
            }
        }
        directions = Arrays.stream(directions).filter(item -> (item != null)).toArray(MoveDirection[]::new);
        return directions;
    }
}
