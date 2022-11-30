package agh.ics.oop;

import java.util.HashMap;
import java.util.Objects;

public abstract class AbstractWorldMap implements IWorldMap,IPositionChangeObserver {
    MapBoundary mapBoundary=new MapBoundary();
    protected final HashMap<Vector2d,Object> map=new HashMap<>();

    public boolean isOccupied(Vector2d position) {
        return map.containsKey(position);
    }

    public Object objectAt(Vector2d position) {
        return map.get(position);
    }

    public String toString(){
        MapVisualiser mapVisualiser = new MapVisualiser(this);
        return mapVisualiser.draw(mapBoundary.getLowerLeftDraw(),mapBoundary.getUpperRightDraw());
    }
    public MapBoundary getBoundary(){
        return mapBoundary;
    }
    public void place(AbstractWorldMapElement animal) throws IllegalAccessException {
        if(objectAt(animal.getPosition())instanceof Animal){
            throw new IllegalAccessException("Object can not be placed on position: "+animal.getPosition()+" this position is occupied");
        }
        animal.addObserver(this);
        animal.addObserver(mapBoundary);
        mapBoundary.addPosition(animal);
    }
    @Override
    public void positionChange(IMapElement element,Vector2d oldPosition, Vector2d newPosition){
        map.remove(oldPosition);
        map.put(newPosition,element);
    }
}
