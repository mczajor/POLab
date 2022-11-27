package agh.ics.oop;
import java.util.ArrayList;
import agh.ics.oop.gui.MyGrid;

public class SimulationEngine implements IEngine {
    private final MoveDirection[] directions;
    private int numOfAnimals = 0;
    private final ArrayList<Animal> animalsOnMap = new ArrayList<>();
    private final MyGrid grid;

    public SimulationEngine(MoveDirection[] directions, AbstractWorldMap map,  Vector2d[] positions, MyGrid grid){
        this.directions = directions;
        this.grid = grid;
        for (Vector2d position: positions){
            Animal animal = new Animal(map, position);
            if(map.place(animal)){
                animal.addObserver(map);
                animalsOnMap.add(animal);
                numOfAnimals++;
            } else {
                throw new IllegalArgumentException("Position " + position + " is already occupied");
            }
        }
    }
    @Override
    public void run(){
        int i = 0;
        for (MoveDirection direction: directions){
            animalsOnMap.get(i%numOfAnimals).move(direction);
            i++;
        }
    }
}
