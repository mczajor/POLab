package agh.ics.oop;
public class RectangularMap extends AbstractWorldMap {
    private final int width;
    private final int height;
    public RectangularMap(int width, int height){
        super();
        this.width = width;
        this.height = height;
    }

    // Overladed toString() so that it prints entire map within bounds
    public String toString() {
        return super.toString(new Vector2d(0, 0), new Vector2d(width, height));
    }

    // Need to check if position isn't "too big" for the map
    @Override
    public boolean canMoveTo(Vector2d position) {
        if (position.precedes(new Vector2d(width, height))){
            return super.canMoveTo(position);
        }
        return false;
    }
}
