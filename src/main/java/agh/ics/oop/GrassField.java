package agh.ics.oop;
import java.lang.Math;
import java.util.HashMap;
import java.util.Map;

public class GrassField extends AbstractWorldMap {
    final private int grassCount;
    public GrassField(int n){
        super();
        this.grassCount = n;
        for (int i = 0; i < n; i++){
            this.placeGrass();
        }
    }

    //Choose only relevant parts of the map, shows every animal and patch of grass
    public String toString(){
        Vector2d entry = map.keySet().iterator().next();
        Vector2d upperBoundry = entry;
        Vector2d lowerBoundry = entry;
        for(Vector2d element: map.keySet()){
            upperBoundry = upperBoundry.upperRight(element);
            lowerBoundry = lowerBoundry.lowerLeft(element);
        }
        return super.toString(lowerBoundry, upperBoundry);
    }
    //Remove grass and place new one if animal steps on it
    public boolean place(Animal animal){
        if(objectAt(animal.getPosition()) instanceof Grass){
            map.remove(animal.getPosition());
            placeGrass();
        }
        return super.place(animal);
    }
    // Place grass randomly within (0,0) and (sqrt(grassCount*10), sqrt(grassCount*10))
    private boolean placeGrass(){
        Vector2d position;
        do{
            position = new Vector2d((int)(Math.random()*Math.sqrt(this.grassCount*10)), (int)(Math.random()*Math.sqrt(this.grassCount*10)));
        }while(isOccupied(position));
        return map.put(position, new Grass(position)) == null;
    }

}
