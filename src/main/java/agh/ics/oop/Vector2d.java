package agh.ics.oop;

public class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return String.format("(%d,%d)", this.x, this.y);
    }

    boolean precedes(Vector2d other) {
        return (this.x <= other.x && this.y <= other.y);
    }

    boolean follows(Vector2d other) {
        return (this.x >= other.x && this.y >= other.y);
    }

    Vector2d add(Vector2d other) {
        return new Vector2d(this.x + other.x, this.y + other.y);
    }

    Vector2d subtract(Vector2d other) {
        return new Vector2d(this.x - other.x, this.y - other.y);
    }

    Vector2d upperRight(Vector2d other) {
        int bx = Math.max(this.x, other.x);
        int by = Math.max(this.y, other.y);
        return new Vector2d(bx, by);
    }

    Vector2d lowerLeft(Vector2d other) {
        int lx = Math.min(this.x, other.x);
        int ly = Math.min(this.y, other.y);
        return new Vector2d(lx, ly);
    }

    Vector2d opposite() {
        return new Vector2d(-this.x, -this.y);
    }

    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;
        return (this.x == that.x && this.y == that.y);
    }
}