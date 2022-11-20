package agh.ics.oop;
import java.lang.Math;

public class GrassField extends AbstractWorldMap {
    final private int grassCount;
    final private MapBoundary boundary = new MapBoundary();
    public GrassField(int n){
        super();
        this.grassCount = n;
        for (int i = 0; i < n; i++){
            this.placeGrass();
        }
    }
    //Choose only relevant parts of the map, shows every animal and patch of grass
    public String toString(){
        Vector2d[] corners = this.getBoundary();
        return super.toString(corners[0], corners[1]);
    }
    //Remove grass and place new one if animal steps on it
    public boolean place(Animal animal){
        if(objectAt(animal.getPosition()) instanceof Grass){
            boundary.remove(animal.getPosition());
            placeGrass();
        }
        if (super.place(animal)){
            boundary.add(animal.getPosition());
            return true;
        }
        return false;
    }
    // Place grass randomly within (0,0) and (sqrt(grassCount*10), sqrt(grassCount*10))
    private boolean placeGrass(){
        Vector2d position;
        do{
            position = new Vector2d((int)(Math.random()*Math.sqrt(this.grassCount*10)), (int)(Math.random()*Math.sqrt(this.grassCount*10)));
        }while(isOccupied(position));
        boundary.add(position);
        return map.put(position, new Grass(position)) == null;
    }
    public Vector2d[] getBoundary(){
        return new Vector2d[]{this.boundary.lowerLeft(), this.boundary.upperRight()};
    }
}
