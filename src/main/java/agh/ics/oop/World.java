package agh.ics.oop;
import static java.lang.System.out;

public class World {
    public static void main(String[] args){
        MapDirection map = MapDirection.SOUTH;
        out.println(map);
        out.println(map.next());
        out.println(map.previous());
        out.println(map.toUnitVector());
        Vector2d position1 = new Vector2d(1,2);
        out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        out.println(position2);
        out.println(position1.add(position2));
    }
}
