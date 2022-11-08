package agh.ics.oop;

import java.util.Objects;

public class Vector2d {
    private final int x;
    private final int y;
    public Vector2d(int x, int y) {
        this.x=x;
        this.y=y;
    }

    @Override
    public String toString() {
        return "("+x+","+y+")";
    }

    public boolean precedes(Vector2d other){
        return x <= other.x && y <= other.y;
    }

    public boolean follows(Vector2d other){
        return x >= other.x && y >= other.y;
    }

    public Vector2d upperRight(Vector2d other){
        return new Vector2d(Math.max(other.x,x),Math.max(other.y,y));
    }

    public Vector2d lowerLeft(Vector2d other){
        return new Vector2d(Math.min(other.x,x),Math.min(other.y,y));
    }

    public Vector2d add(Vector2d other){
        return new Vector2d(x+other.x,y+other.y);
    }

    public Vector2d subtract(Vector2d other){
        return new Vector2d(x-other.x,y-other.y);
    }

    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;

        return x == that.x && y == that.y;
    }

    public Vector2d opposite(){
        return new Vector2d(-x,-y);
    }
    public int x(){
      return this.x;
    }
    public int y(){
        return this.y;
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
