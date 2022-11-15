package agh.ics.oop;

import java.util.HashMap;

public abstract class AbstractWorldMap implements IWorldMap {

    protected final HashMap<Vector2d,Object> map=new HashMap<>();

    public boolean isOccupied(Vector2d position) {
        return map.containsKey(position);
    }

    public Object objectAt(Vector2d position) {
        return map.get(position);
    }

    public String toString(){
        MapVisualiser mapVisualiser = new MapVisualiser(this);
        return mapVisualiser.draw(this.lowerLeftDraw(),this.upperRightDraw());
    }

    public abstract Vector2d lowerLeftDraw();
    public abstract Vector2d upperRightDraw();
}
