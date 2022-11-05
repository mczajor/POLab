package agh.ics.oop;
import java.util.ArrayList;

abstract class AbstractWorldMap implements IWorldMap {
    protected ArrayList<IMapElement> map;
    public AbstractWorldMap(){
        map = new ArrayList<>();
    }
    public String toString(Vector2d lowerLeft, Vector2d upperRight){
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(lowerLeft, upperRight);
    }
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
