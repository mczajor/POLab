package agh.ics.oop;


public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);
    private final Vector2d lowerlimit = new Vector2d(0,0);
    private final Vector2d upperlimit = new Vector2d(4,4);

    public String toString(){
        return "Pozycja: " + this.position.toString() + "\nOrientacja: " + this.orientation.toString();
    }
    public MapDirection getOrientation(){
        return this.orientation;
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
                if (lowerlimit.lowerLeft(newposition).equals(lowerlimit) &&
                        upperlimit.upperRight(newposition).equals(upperlimit)) {
                    position = newposition;
                }
            }
        }
    }
}
