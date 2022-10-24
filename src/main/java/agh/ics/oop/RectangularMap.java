package agh.ics.oop;
import java.util.ArrayList;

public class RectangularMap implements IWorldMap {
    ArrayList<ArrayList<Animal>> map;
    public RectangularMap(int width, int height){
        map = new ArrayList<>();
        for (int i = 0; i < width; i++){
            map.add(new ArrayList<>());
            for (int j = 0; j < height; j++){
                map.get(i).add(null);
            }
        }
    }
    public String toString(){
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(new Vector2d(0,0), new Vector2d(map.size(), map.get(0).size()));
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(new Vector2d(0,0)) && position.precedes(new Vector2d(map.size(), map.get(0).size())) && isOccupied(position);
    }
    @Override
    public boolean place(Animal animal) {
        if (!isOccupied(animal.getPosition())){
            map.get(animal.getPosition().x).set(animal.getPosition().y, animal);
            return true;
        }
        return false;
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }
    @Override
    public Object objectAt(Vector2d position) {
        if (position.follows(new Vector2d(0,0)) && position.precedes(new Vector2d(map.size(), map.get(0).size()))){
            return map.get(position.x).get(position.y);
        }
        return null;
    }
}
