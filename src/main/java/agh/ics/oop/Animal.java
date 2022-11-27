package agh.ics.oop;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Animal implements IMapElement {
    AbstractWorldMap map;
    ArrayList<IPositionChangeObserver> observers = new ArrayList<>();
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position;
    public Animal(AbstractWorldMap map){
        this.map = map;
        this.addObserver(map);
        this.position = new Vector2d(0,0);
    }
    public Animal(AbstractWorldMap map, Vector2d initialPosition){
        this.position = initialPosition;
        this.map = map;
        this.addObserver(map);
    }
    @Override
    public void changePosition(Vector2d newPosition){
        this.position = newPosition;
    }
    public String toString(){
        return switch(this.orientation){
            case NORTH -> "N";
            case SOUTH -> "S";
            case WEST -> "W";
            case EAST -> "E";
        };
    }
    public MapDirection getOrientation(){
        return this.orientation;
    }
    //@Override
    public Vector2d getPosition(){
        return this.position;
    }
    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }
    public void move(MoveDirection direction){
        switch (direction) {
            case RIGHT -> this.orientation = this.orientation.next(); // rotate right
            case LEFT -> this.orientation = this.orientation.previous(); //rotate left
            default -> {
                Vector2d unitVector = orientation.toUnitVector();
                // need to go opposite of unitvector if direction backwart
                if (direction == MoveDirection.BACKWARD){
                    unitVector = unitVector.opposite();
                }
                // If new position is viable change the vector for a new one
                Vector2d newPosition = this.position.add(unitVector);
                if (map.objectAt(newPosition) instanceof Grass){
                    map.moveGrass(newPosition);
                }
                if (map.objectAt(newPosition) == null){
                    Vector2d oldPosition = this.position;
                    this.positionChanged(oldPosition, newPosition);
                    this.position = newPosition;
                }
            }
        }
    }
    @Override
    public Image getImage() throws FileNotFoundException {
        return new Image(new FileInputStream("src/main/resources/" + this.toString() + ".png"));
        }
    void addObserver(IPositionChangeObserver observer){
        this.observers.add(observer);
    }
    void removeObserver(IPositionChangeObserver observer){
        this.observers.remove(observer);
    }
    void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for (IPositionChangeObserver observer: observers){
            observer.positionChanged(oldPosition, newPosition);
        }
    }
}
