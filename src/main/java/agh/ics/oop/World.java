package agh.ics.oop;
import static java.lang.System.out;

public class World {
    public static void run(Direction.Directions[] args){
        for (Direction.Directions arg: args){
            if (arg == null){
                break;
            }
            out.print("Zwierzak idzie ");
            switch(arg){
                case FORWARD:
                    out.print("do przodu\n");
                    break;
                case BACKWARD:
                    out.print("do tylu\n");
                    break;
                case LEFT:
                    out.print("w lewo\n");
                    break;
                case RIGHT:
                    out.print("w prawo\n");
                    break;
                default:
                    break;
            }
        }

    }
    public static void main(String[] args){
        out.println("System wystartowal");
        Direction.Directions[] newarr = new Direction.Directions[args.length];
        int it = 0;
        for(String arg: args){
            switch(arg){
                case "f":
                    newarr[it] = Direction.Directions.FORWARD;
                    it += 1;
                    break;
                case "b":
                    newarr[it] = Direction.Directions.BACKWARD;
                    it += 1;
                    break;
                case "l":
                    newarr[it] = Direction.Directions.LEFT;
                    it += 1;
                    break;
                case "r":
                    newarr[it] = Direction.Directions.RIGHT;
                    it += 1;
                    break;
                default:
                    break;
            }
        }
        run(newarr);
        out.println("System zakonczyl dzialanie");
    }
}
