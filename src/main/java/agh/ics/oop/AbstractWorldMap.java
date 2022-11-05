package agh.ics.oop;
import java.util.ArrayList;

abstract class AbstractWorldMap implements IWorldMap {

    /* Storing all elements in single array */
    protected ArrayList<IMapElement> map;
    public AbstractWorldMap(){
        map = new ArrayList<>();
    }

    /* Basic skeleton for toString() to print the map*/
    public String toString(Vector2d lowerLeft, Vector2d upperRight){
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(lowerLeft, upperRight);
    }


    /*Checking if the positon is in bounds and whether it's occupied or not*/
    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position) && position.follows(new Vector2d(0,0));
    }


    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())){
            map.add(animal);
            return true;
        }
        return false;
    }


    @Override
    public boolean isOccupied(Vector2d position) {
        Object object = objectAt(position);
        return (object instanceof Animal) || (object instanceof Grass);
    }


    @Override
    public Object objectAt(Vector2d position) {
        for (IMapElement element: map) {
            if (element.getPosition().equals(position)) {
                return element;
            }
        }
        return null;
    }

    /*Checking whether position has and animal and removing it, there can only by one animal in one spot*/
    @Override
    public void removeAnimal(Vector2d position){
        for (IMapElement element: map){
            if (element.getPosition().equals(position) && element instanceof Animal){
                map.remove(element);
                break;
            }
        }
    }

}
