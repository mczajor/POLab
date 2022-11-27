package agh.ics.oop.gui;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import agh.ics.oop.*;
import javafx.scene.layout.VBox;
import java.io.FileNotFoundException;

public class GuiElementBox {
    VBox vBox = new VBox();
    public GuiElementBox(IMapElement element) {
        try {
            ImageView imageView = new ImageView();
            imageView.setImage(element.getImage());
            imageView.setFitHeight(20);
            imageView.setFitWidth(20);
            Label label = new Label(element.getPosition().toString());
            vBox.getChildren().addAll(imageView, label);
            vBox.setAlignment(javafx.geometry.Pos.CENTER);
            vBox.setSpacing(0.005);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

