package agh.ics.oop;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver {
    SortedSet<Vector2d> xSortedElements= new TreeSet<Vector2d>(new Comparator<Vector2d>() {
        @Override
        public int compare(Vector2d cordinates1, Vector2d cordinates2) {
            if (cordinates1.x() != cordinates2.x()) {
                return cordinates1.x() - cordinates2.x();
            }

            if (cordinates1.y() != cordinates2.y()) {
                return cordinates1.y() - cordinates2.y();
            }
            return 0;
        }
    });

    SortedSet<Vector2d> ySortedElements= new TreeSet<Vector2d>(new Comparator<Vector2d>() {
        @Override
        public int compare(Vector2d cordinates1, Vector2d cordinates2) {
            if (cordinates1.y() != cordinates2.y()) {
                return cordinates1.y() - cordinates2.y();
            }

            if (cordinates1.x() != cordinates2.x()) {
                return cordinates1.x() - cordinates2.x();
            }
            return 0;
        }
    });

    public Vector2d getLowerLeftDraw() {
        return new Vector2d(xSortedElements.first().x(),ySortedElements.first().y());
    }

    public Vector2d getUpperRightDraw() {
        return new Vector2d(xSortedElements.last().x(),ySortedElements.last().y());
    }
    public void addPosition(IMapElement elementToAdd){
        Vector2d newPosition = elementToAdd.getPosition();
        xSortedElements.add(newPosition);
        ySortedElements.add(newPosition);
    }
    public void removePosition(IMapElement elementToAdd){
        Vector2d positionToDelete = elementToAdd.getPosition();
        xSortedElements.remove(positionToDelete);
        ySortedElements.remove(positionToDelete);
    }
    @Override
    public void positionChange(IMapElement elementToAdd,Vector2d oldPosition, Vector2d newPosition) {
        xSortedElements.remove(oldPosition);
        ySortedElements.remove(oldPosition);
        xSortedElements.add(newPosition);
        ySortedElements.add(newPosition);
    }
}
