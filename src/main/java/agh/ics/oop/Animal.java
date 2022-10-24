package agh.ics.oop;


public class Animal {
    static IWorldMap map;
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position;
    public Animal(IWorldMap map, Vector2d initialPosition){
        this.position = initialPosition;
        this.map = map;
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
    public Vector2d getPosition(){
        return this.position;
    }
    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }
    public void move(MoveDirection direction){
        switch (direction) {
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            default -> {
                Vector2d unitVector = orientation.toUnitVector();
                if (direction == MoveDirection.BACKWARD){
                    unitVector = unitVector.opposite();
                }
                Vector2d newposition = this.position.add(unitVector);
                if (map.canMoveTo(newposition)){
                    this.position = newposition;
                }
            }
        }
    }
}
