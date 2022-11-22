package agh.ics.oop;

public interface IPositionChangeObserver {
    void positionChange(Vector2d oldPosition, Vector2d newPosition);
}
