package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.HPos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.io.FileNotFoundException;
import java.util.List;


public class App extends Application implements IMapRefreshObserver {
    private GridPane gridPane;
    private ThreadedSimulationEngine engine;
    private AbstractWorldMap map;

    @Override
    public void init() throws Exception {

        super.init();

        try {
            map= new GrassField(10);
            Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };

            engine = new ThreadedSimulationEngine(map, positions, 300);
            engine.addObserver(this);
        }
        catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setOnCloseRequest(e -> {
            Platform.exit();
            System.exit(0);
        });

        gridPane=new GridPane();
        gridPane.setHgap(0);
        gridPane.setVgap(0);
        gridPane.setGridLinesVisible(true);

        TextField textField = new TextField();
        Button button = new Button("START");
        button.setMaxWidth(800);

        button.setOnAction(event -> {
            List<String> moves = List.of(textField.getCharacters().toString().split(" "));
            MoveDirection[] directions = OptionsParser.parse(moves);

            engine.setMoves(directions);
            Thread engineThread = new Thread(engine);
            engineThread.start();
        });

        renderMap();

        VBox root = new VBox();
        root.getChildren().addAll(textField, button);
        root.getChildren().add(gridPane);

        Scene scene = new Scene(root, 800, 800);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void renderMap() throws FileNotFoundException {
        int cellWidth = 50;
        int cellHeight = 50;

        int minY = map.getBoundary().getLowerLeftDraw().y();
        int minX = map.getBoundary().getLowerLeftDraw().x();
        int maxY = map.getBoundary().getUpperRightDraw().y();
        int maxX = map.getBoundary().getUpperRightDraw().x();

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
                IMapElement worldMapElement = (IMapElement) map.objectAt(position);
                GuiElementBox element = new GuiElementBox(worldMapElement);
                VBox graphicalElement = element.getGraphicalElement();
                GridPane.setHalignment(graphicalElement, HPos.CENTER);
                gridPane.add(graphicalElement, position.x() - minX + 1, maxY - position.y()+1, 1, 1);
            }
        }
    }
    @Override
    public void refresh() {
        Platform.runLater(() -> {
            gridPane.setGridLinesVisible(false);
            gridPane.getColumnConstraints().clear();
            gridPane.getRowConstraints().clear();
            gridPane.getChildren().clear();
            gridPane.setGridLinesVisible(true);
            try {
                renderMap();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
