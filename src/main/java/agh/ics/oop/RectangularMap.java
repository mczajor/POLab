package agh.ics.oop;
public class RectangularMap extends AbstractWorldMap {
    private final int width;
    private final int height;
    public RectangularMap(int width, int height){
        super();
        this.width = width;
        this.height = height;
    }
    public String toString() {
        return super.toString(new Vector2d(0, 0), new Vector2d(width, height));
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(new Vector2d(0,0)) && position.precedes(new Vector2d(this.width-1, this.height-1)) && !isOccupied(position);
    }
}
