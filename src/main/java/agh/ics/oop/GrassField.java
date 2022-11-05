package agh.ics.oop;
import java.lang.Math;

public class GrassField extends AbstractWorldMap {

    // Grass is placed randomly withing (0,0) - (sqrt(n*10), sqrt(n*10)) bounds
    public GrassField(int n){
        super();
        Vector2d position = new Vector2d((int)(Math.random()*Math.sqrt(n*10)), (int)(Math.random()*Math.sqrt(n*10)));
        for (int i = 0; i < n; i++){
            map.add(new Grass(position));
            do{
                position = new Vector2d((int)(Math.random()*Math.sqrt(n*10)), (int)(Math.random()*Math.sqrt(n*10)));
            }while(isGrassAt(position));
        }
    }

    //Choose only relevant parts of the map, shows every animal and patch of grass
    public String toString(){
        Vector2d upperBoundry = map.get(0).getPosition();
        Vector2d lowerBoundry = map.get(0).getPosition();
        for(IMapElement element: map){
            upperBoundry = upperBoundry.upperRight(element.getPosition());
            lowerBoundry = lowerBoundry.lowerLeft(element.getPosition());
        }
        return super.toString(lowerBoundry, upperBoundry);
    }

    //Check just for grass so that they can't be placed on top of each other
    private boolean isGrassAt(Vector2d position){
        for (IMapElement element: map){
            if (element.getPosition().equals(position) && element instanceof Grass){
                return true;
            }
        }
        return false;
    }
}
