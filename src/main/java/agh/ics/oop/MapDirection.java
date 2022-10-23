package agh.ics.oop;

public enum MapDirection {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    public String toString(){
        return switch (this) {
            case NORTH -> "Polnoc";
            case SOUTH -> "Poludnie";
            case EAST -> "Wschod";
            case WEST -> "Zachod";
        };
    }
    public MapDirection next(){
        return switch (this) {
            case NORTH -> MapDirection.EAST;
            case SOUTH -> MapDirection.WEST;
            case EAST -> MapDirection.SOUTH;
            case WEST -> MapDirection.NORTH;
        };
    }
    public MapDirection previous(){
        return switch (this) {
            case NORTH -> MapDirection.WEST;
            case SOUTH -> MapDirection.EAST;
            case EAST -> MapDirection.NORTH;
            case WEST -> MapDirection.SOUTH;
        };
    }
    public Vector2d toUnitVector(){
        return switch (this) {
            case NORTH -> new Vector2d(0, 1);
            case SOUTH -> new Vector2d(0, -1);
            case EAST -> new Vector2d(1, 0);
            case WEST -> new Vector2d(-1, 0);
        };
    }

}
