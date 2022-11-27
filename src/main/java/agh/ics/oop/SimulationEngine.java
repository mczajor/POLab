package agh.ics.oop;
import java.util.ArrayList;
import agh.ics.oop.gui.MyGrid;
import javafx.application.Platform;

public class SimulationEngine implements IEngine, Runnable {
    private final MoveDirection[] directions;
    private int numOfAnimals = 0;
    private final ArrayList<Animal> animalsOnMap = new ArrayList<>();
    private final MyGrid grid;
    private final int move_delay;

    public SimulationEngine(MoveDirection[] directions, AbstractWorldMap map,  Vector2d[] positions, MyGrid grid, int move_delay){
        this.directions = directions;
        this.grid = grid;
        this.move_delay = move_delay;
        for (Vector2d position: positions){
            Animal animal = new Animal(map, position);
            if(map.place(animal)){
                this.animalsOnMap.add(animal);
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
            try {
                Thread.sleep(move_delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(direction.toString());
            animalsOnMap.get(i%numOfAnimals).move(direction);
            i++;
            Platform.runLater(grid::draw);

        }
    }
}
