package agh.ics.oop;

import java.util.HashMap;

public class RectangularMap extends AbstractWorldMap{
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
    public void place(AbstractWorldMapElement animal) throws IllegalAccessException {
        if(!animal.getPosition().precedes(endOfMap)||!animal.getPosition().follows(startOfMap)){
            throw new IllegalArgumentException("Object can not be placed on position: " + animal.getPosition() + ". It is outside the map!");
        }
        super.place(animal);
        map.put(animal.getPosition(), animal);
    }
    public Vector2d lowerLeftDraw(){
        return startOfMap;
    }
    public Vector2d upperRightDraw(){
        return endOfMap;
    }
}
