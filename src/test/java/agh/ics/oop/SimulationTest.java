package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimulationTest {
    @Test
    void testA(){
        try{
            //given
            MoveDirection[] directions = {MoveDirection.FORWARD,MoveDirection.BACKWARD,MoveDirection.RIGHT,MoveDirection.LEFT,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.RIGHT,MoveDirection.RIGHT,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD};
            IWorldMap map = new RectangularMap(10, 5);
            Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
            IEngine enegine = new SimulationEngine(directions, map, positions);


            //result
            enegine.run();
            String result=map.toString();
            String expectResult= " y\\x  0 1 2 3 4 5 6 7 8 9\n" +
                    "  5: ---------------------\n" +
                    "  4: | | | |N| | | | | | |\n" +
                    "  3: | | | | | | | | | | |\n" +
                    "  2: | | | | | | | | | | |\n" +
                    "  1: | | | | | | | | | | |\n" +
                    "  0: | | |S| | | | | | | |\n" +
                    " -1: ---------------------\n";

            //then
            Assertions.assertLinesMatch(result.lines(),expectResult.lines());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testB(){
        try{
            //given
            MoveDirection[] directions ={MoveDirection.FORWARD,MoveDirection.LEFT,MoveDirection.RIGHT,MoveDirection.LEFT,MoveDirection.RIGHT,MoveDirection.BACKWARD,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.RIGHT,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD};
            IWorldMap map = new RectangularMap(3, 10);
            Vector2d[] positions = { new Vector2d(1,0), new Vector2d(2,9),new Vector2d(0,0) };
            IEngine enegine = new SimulationEngine(directions, map, positions);
            //result
            enegine.run();
            String result=map.toString();
            String expectResult=" y\\x  0 1 2\n" +
                    " 10: -------\n" +
                    "  9: | | |N|\n" +
                    "  8: | | | |\n" +
                    "  7: | | | |\n" +
                    "  6: | | | |\n" +
                    "  5: | | | |\n" +
                    "  4: | | | |\n" +
                    "  3: | | | |\n" +
                    "  2: | | | |\n" +
                    "  1: |W| | |\n" +
                    "  0: |S| | |\n" +
                    " -1: -------\n";

            //then
            Assertions.assertLinesMatch(result.lines(),expectResult.lines());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testC(){
        try{
            //given
            MoveDirection[] directions = {MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.LEFT,MoveDirection.RIGHT,MoveDirection.LEFT,MoveDirection.BACKWARD,MoveDirection.FORWARD,MoveDirection.BACKWARD,MoveDirection.LEFT,MoveDirection.FORWARD};
            IWorldMap map = new RectangularMap(1, 4);
            Vector2d[] positions = { new Vector2d(0,0), new Vector2d(0,1),new Vector2d(0,2),new Vector2d(0,3) };
            IEngine enegine = new SimulationEngine(directions, map, positions);

            //result
            enegine.run();
            String result=map.toString();
            String expectResult= " y\\x  0\n" +
                    "  4: ---\n" +
                    "  3: |N|\n" +
                    "  2: |S|\n" +
                    "  1: |E|\n" +
                    "  0: |W|\n" +
                    " -1: ---\n";

            //then
            Assertions.assertLinesMatch(result.lines(),expectResult.lines());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

}
