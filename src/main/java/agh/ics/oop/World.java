package agh.ics.oop;
import static java.lang.System.out;

public class World {
    public static void main(String[] args){
        MoveDirection[] movement = OptionsParser.parse(args);
        Animal animal = new Animal();
        out.println(animal);
        for (MoveDirection move: movement){
            animal.move(move);
        }
        out.println(animal);
    }
}
