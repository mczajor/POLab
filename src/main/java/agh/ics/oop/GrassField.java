package agh.ics.oop;
import java.lang.Math;

public class GrassField extends AbstractWorldMap {
    final private int grassCount;
    final private MapBoundary boundary = new MapBoundary();
    public GrassField(int n){
        super();
        this.grassCount = n;
        for (int i = 0; i < n; i++){
            Vector2d position = placeGrass();
            map.put(position, new Grass(position));
            boundary.add(position);
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
            Vector2d position = placeGrass();
            this.positionChanged(animal.getPosition(), position);
            boundary.positionChanged(animal.getPosition(), position);
        }
        if (super.place(animal)){
            boundary.add(animal.getPosition());
            return true;
        }
        return false;
    }
    // Place grass randomly within (0,0) and (sqrt(grassCount*10), sqrt(grassCount*10))
    protected Vector2d placeGrass(){
        Vector2d position;
        do{
            position = new Vector2d((int)(Math.random()*Math.sqrt(this.grassCount*10)), (int)(Math.random()*Math.sqrt(this.grassCount*10)));
        }while(isOccupied(position));
        return position;
    }
    protected void moveGrass(Vector2d oldPosition){
        Vector2d newPosition = placeGrass();
        super.objectAt(oldPosition).changePosition(newPosition);
        this.positionChanged(oldPosition, newPosition);
    }
    public Vector2d[] getBoundary(){
        System.out.println(this.boundary.lowerLeft().toString() + " " + this.boundary.upperRight().toString());
        return new Vector2d[]{this.boundary.lowerLeft(), this.boundary.upperRight()};
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        super.positionChanged(oldPosition, newPosition);
        boundary.positionChanged(oldPosition, newPosition);
    }
}
