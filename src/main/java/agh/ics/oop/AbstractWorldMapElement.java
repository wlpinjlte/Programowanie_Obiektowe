package agh.ics.oop;

import java.util.ArrayList;

public abstract class AbstractWorldMapElement implements IMapElement{
    protected Vector2d position;
    protected final ArrayList<IPositionChangeObserver> positionObservers = new ArrayList<>();
    @Override
    public Vector2d getPosition() {
        return position;
    }
    public void addObserver(IPositionChangeObserver observer){
        positionObservers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        positionObservers.remove(observer);
    }

    protected void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for(IPositionChangeObserver observer:positionObservers){
            observer.positionChange(this,oldPosition, newPosition);
        }
    }
    public abstract String toString();
}
