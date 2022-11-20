package agh.ics.oop;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {

    /* Storing all elements in HashMap */
    protected final Map<Vector2d, IMapElement> map;
    public AbstractWorldMap(){
        map = new HashMap<>();
    }

    /* Basic skeleton for toString() to print the map*/
    public String toString(Vector2d lowerLeft, Vector2d upperRight){
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(lowerLeft, upperRight);
    }

    /*Checking if the position is in bounds and whether it's occupied or not*/
    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupiedByAnimal(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (map.get(animal.getPosition()) instanceof Animal){
            return false;
        }
        return !(map.put(animal.getPosition(), animal) instanceof Animal);
    }

    // Mostly used in MapVisulaizer since an animal can walk over a grass patch
    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public IMapElement objectAt(Vector2d position) {
        return map.get(position);
    }

    /*Checking whether position has and animal and removing it, there can only be one animal in one spot*/
    @Override
    public void removeAnimal(Vector2d position){
        map.remove(position);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        IMapElement element = objectAt(oldPosition);
        map.remove(oldPosition);
        map.put(newPosition, element);
    }

    protected boolean isOccupiedByAnimal(Vector2d position){
        return objectAt(position) instanceof Animal;
    }
    public IMapElement[] getObjects(){
        List<IMapElement> objects = new ArrayList<>(map.values());
        return objects.toArray(new IMapElement[0]);
    }
}

