package agh.ics.oop;

public interface IPositionChangeObserver {
    void positionChange(IMapElement elementToAdd,Vector2d oldPosition, Vector2d newPosition);
}
