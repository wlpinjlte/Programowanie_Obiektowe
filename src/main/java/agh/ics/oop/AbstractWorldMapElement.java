package agh.ics.oop;

public abstract class AbstractWorldMapElement implements IMapElement{
    protected Vector2d position;
    @Override
    public Vector2d getPosition() {
        return position;
    }
    public abstract String toString();//?
}
