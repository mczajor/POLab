package agh.ics.oop.gui;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import agh.ics.oop.*;
import javafx.scene.layout.VBox;
import java.io.FileNotFoundException;

public class GuiElementBox extends VBox {
    public GuiElementBox(IMapElement element) {
        try {
            ImageView imageView = new ImageView();
            imageView.setImage(element.getImage());
            imageView.setFitHeight(20);
            imageView.setFitWidth(20);
            Label label = new Label(element.getPosition().toString());
            this.getChildren().addAll(imageView, label);
            this.setAlignment(javafx.geometry.Pos.CENTER);
            this.setSpacing(0.005);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

