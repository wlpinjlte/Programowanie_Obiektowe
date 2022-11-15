package agh.ics.oop;

import static agh.ics.oop.MoveDirection.FORWARD;
import static agh.ics.oop.MoveDirection.RIGHT;
import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
        MoveDirection[] directions = new OptionsParser().parse(args);
        GrassField map= new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine enegine = new SimulationEngine(directions, map, positions);
        out.println(map.toString());
        enegine.run();
        out.println(map.toString());
    }
}