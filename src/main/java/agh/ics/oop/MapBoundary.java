package agh.ics.oop;
import java.util.TreeSet;

class compareX implements java.util.Comparator<Vector2d> {
    @Override
    public int compare(Vector2d o1, Vector2d o2) {
        if (o1.x == o2.x) {
            return o1.y - o2.y;
        }
        return o1.x - o2.x;
    }
}

class compareY implements java.util.Comparator<Vector2d> {
    @Override
    public int compare(Vector2d o1, Vector2d o2) {
        if (o1.y == o2.y) {
            return o1.x - o2.x;
        }
        return o1.y - o2.y;
    }
}

public class MapBoundary implements IPositionChangeObserver {
    private final TreeSet<Vector2d> xSorted = new TreeSet<>(new compareX());
    private final TreeSet<Vector2d> ySorted = new TreeSet<>(new compareY());

    public boolean add(Vector2d position){
        return xSorted.add(position) && ySorted.add(position);
    }

    public boolean remove(Vector2d position){
        return xSorted.remove(position) && ySorted.remove(position);
    }

    public Vector2d lowerLeft(){
        return xSorted.first().lowerLeft(ySorted.first());
    }
    public Vector2d upperRight(){
        return xSorted.last().upperRight(ySorted.last());
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        this.remove(oldPosition);
        this.add(newPosition);
    }
}
