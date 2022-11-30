package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import static java.lang.System.out;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        MoveDirection[] directions = new OptionsParser().parse(getParameters().getRaw());
        GrassField map= new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine enegine = new SimulationEngine(directions, map, positions);
        out.println(map.toString());
        enegine.run();
        out.println(map.toString());
        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        gridPane.setHgap(0);
        gridPane.setVgap(0);
        int cellWidth = 30;
        int cellHeight = 30;

        int minY = map.getBoundary().getLowerLeftDraw().y();
        int minX = map.getBoundary().getLowerLeftDraw().x();
        int maxY = map.getBoundary().getUpperRightDraw().y();
        int maxX = map.getBoundary().getUpperRightDraw().x();

        System.out.println("minX: " + minX + " minY: " + minY + " maxX: " + maxX + " maxY: " +maxY);

        Label xyLabel = new Label("y\\x");
        GridPane.setHalignment(xyLabel, HPos.CENTER);
        gridPane.getColumnConstraints().add(new ColumnConstraints(cellWidth));
        gridPane.getRowConstraints().add(new RowConstraints(cellHeight));
        gridPane.add(xyLabel, 0, 0, 1, 1);

        for (int i = minY; i <= maxY; i++) {
            Label label = new Label(Integer.toString(i));
            gridPane.add(label, 0, maxY - i + 1, 1, 1);
            gridPane.getRowConstraints().add(new RowConstraints(cellHeight));
            GridPane.setHalignment(label, HPos.CENTER);
        }

        for (int i = minX; i <= maxX; i++) {
            Label label = new Label(Integer.toString(i));
            gridPane.add(label, i - minX + 1, 0, 1, 1);
            gridPane.getColumnConstraints().add(new ColumnConstraints(cellWidth));
            GridPane.setHalignment(label, HPos.CENTER);
        }

        for (int x = minX; x <= maxX; x++) {
            for (int y = maxY+1; y >= minY-1; y--) {
                Vector2d position = new Vector2d(x, y);
                if (!map.isOccupied(position)) {
                    continue;
                }
                Object worldMapElement = map.objectAt(position);
                Label label = new Label(worldMapElement.toString());
                GridPane.setHalignment(label, HPos.CENTER);
                gridPane.add(label, position.x() - minX + 1, maxY - position.y()+1, 1, 1);
            }
        }

        Scene scene = new Scene(gridPane, (maxX-minX+2)*cellWidth, (maxY-minY+2)*cellHeight);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
