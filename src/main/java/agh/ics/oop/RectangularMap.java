package agh.ics.oop;

import java.util.HashMap;

public class RectangularMap implements IWorldMap{
    private HashMap<Vector2d,Animal> map=new HashMap<>();
    private final Vector2d endOfMap;

    private final Vector2d startOfMap=new Vector2d(0,0);

    public RectangularMap(int width,int height){
        endOfMap=new Vector2d(width-1,height-1);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (position.precedes(endOfMap)&&position.follows(startOfMap))&&!isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (!canMoveTo(animal.getPosition())){
            return false;
        }
        if(animal.getPreviousPosition()!=null){
            map.remove(animal.getPreviousPosition());
        }
        map.put(animal.getPosition(),animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return map.containsKey(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        return map.get(position);
    }

    public String toString(){
        MapVisualiser mapVisualiser = new MapVisualiser(this);
        return mapVisualiser.draw(startOfMap,endOfMap);
    }
}
