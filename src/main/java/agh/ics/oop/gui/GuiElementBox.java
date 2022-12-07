package agh.ics.oop.gui;

import agh.ics.oop.IMapElement;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {
    protected IMapElement mapElement;
    protected Label label;
    protected VBox graphicalElement = new VBox(4);

    public GuiElementBox(IMapElement mapElement) throws FileNotFoundException {

        this.mapElement = mapElement;
        Image image = new Image(new FileInputStream(mapElement.getImageResource()));

        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);

        this.label = new Label(this.mapElement.toGuiString());
        this.label.setFont(Font.font(10d));

        this.graphicalElement.getChildren().add(imageView);
        this.graphicalElement.getChildren().add(label);
        this.graphicalElement.setAlignment(Pos.CENTER);
    }

    public VBox getGraphicalElement() {
        return this.graphicalElement;
    }

}
