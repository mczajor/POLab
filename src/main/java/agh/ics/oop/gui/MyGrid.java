package agh.ics.oop.gui;
import agh.ics.oop.GrassField;
import agh.ics.oop.IMapElement;
import agh.ics.oop.Vector2d;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

public class MyGrid extends GridPane {
    private final int CELL_SIZE;
    private final GrassField map;
    public int width;
    public int height;

    public MyGrid(GrassField map, int CELL_SIZE){
        this.CELL_SIZE = CELL_SIZE;
        this.map = map;
    }
    public void draw(){
        this.getChildren().clear();
        IMapElement[] elements = map.getObjects();
        Vector2d[] corners = map.getBoundary();
        width = corners[1].x - corners[0].x + 1;
        height = corners[1].y - corners[0].y + 1;
        for (int i = 0; i < width; i++) {
            this.getColumnConstraints().add(new ColumnConstraints(CELL_SIZE));
            this.add(new Label(" " + (corners[0].x+i)), i+1, 0);
        }
        for (int i = 0; i < height; i++){
            this.getRowConstraints().add(new RowConstraints(CELL_SIZE));
            this.add(new Label(" " + (corners[1].y-i)), 0, i+1);
        }
        this.setGridLinesVisible(true);
        //this.getRowConstraints().add(new RowConstraints(CELL_SIZE));
        //this.getColumnConstraints().add(new ColumnConstraints(CELL_SIZE));
        this.add(new Label("y/x"), 0 ,0);
        for (IMapElement element : elements){
            VBox temp = new GuiElementBox(element);
            this.add(temp, element.getPosition().x - corners[0].x + 1,
                    corners[1].y - element.getPosition().y + 1);
        }

    }

}
