package agh.ics.oop;

import static agh.ics.oop.MoveDirection.FORWARD;
import static agh.ics.oop.MoveDirection.RIGHT;
import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine enegine = new SimulationEngine(directions, map, positions);
        enegine.run();
        out.println(map.toString());
    }
}