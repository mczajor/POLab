package agh.ics.oop;

import java.util.Map;

public enum MapDirection {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    public String toString(){
        switch (this){
            case NORTH: return "Polnoc";
            case SOUTH: return "Poludnie";
            case EAST: return "Wschod";
            case WEST: return "Zachod";
            default: return "Blad";
        }
    }
    public MapDirection next(){
        switch (this){
            case NORTH: return MapDirection.EAST;
            case SOUTH: return MapDirection.WEST;
            case EAST: return MapDirection.SOUTH;
            case WEST: return MapDirection.NORTH;
            default: return this;
        }
    }
    public MapDirection previous(){
        switch (this){
            case NORTH: return MapDirection.WEST;
            case SOUTH: return MapDirection.EAST;
            case EAST: return MapDirection.NORTH;
            case WEST: return MapDirection.SOUTH;
            default: return this;
        }
    }
    public Vector2d toUnitVector(){
        switch (this){
            case NORTH: return new Vector2d(0, 1);
            case SOUTH: return new Vector2d(0, -1);
            case EAST: return new Vector2d(1, 0);
            case WEST: return new Vector2d(-1, 0);
            default: return new Vector2d(0, 0);
        }
    }

}
