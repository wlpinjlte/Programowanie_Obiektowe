package agh.ics.oop;

import java.util.HashMap;

public abstract class AbstractWorldMap implements IWorldMap,IPositionChangeObserver {

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

    public void place(Animal animal) throws IllegalAccessException {
        if(objectAt(animal.getPosition())instanceof Animal){
            throw new IllegalAccessException("Object can not be placed on position: "+animal.getPosition()+" this position is occupied");
        }
        animal.addObserver(this);
    }
    @Override
    public void positionChange(Vector2d oldPosition, Vector2d newPosition){
        Object animal=map.get(oldPosition);
        map.remove(oldPosition);
        map.put(newPosition,animal);
    }
    public abstract Vector2d lowerLeftDraw();
    public abstract Vector2d upperRightDraw();
}
