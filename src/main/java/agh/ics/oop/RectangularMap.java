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
    public Vector2d lowerLeftDraw() {
        return startOfMap;
    }

    @Override
    public Vector2d upperRightDraw() {
        return endOfMap;
    }
}
