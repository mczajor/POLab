package agh.ics.oop.gui;
import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class App extends Application {
    private GrassField map;
    public void init(){
        String[] args = getParameters().getRaw().toArray(new String[0]);
        MoveDirection[] directions;
        map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(2, 3)};
        SimulationEngine engine;
        try {
            directions = OptionsParser.parse(args);
            engine = new SimulationEngine(directions, map, positions);
        } catch (IllegalArgumentException exeption){
            System.err.println(exeption.getMessage());
            return;
        }
        engine.run();
    }


    public void start(Stage primaryStage){
        IMapElement[] elements = map.getObjects();
        Vector2d[] corners = map.getBoundary();
        int width = corners[1].x - corners[0].x + 1;
        int height = corners[1].y - corners[0].y + 1;
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);
        for (int i=0; i<=width; i++){
            grid.getColumnConstraints().add(new ColumnConstraints(20));
        }
        for (int i=0; i<=height; i++){
            grid.getRowConstraints().add(new RowConstraints(20));
        }
        for (int i = 0; i < width; i++) {
            grid.add(new Label(" " + (corners[0].x+i)), i+1, 0);
        }
        for (int i = 0; i < height; i++){
            grid.add(new Label(" " + (corners[1].y-i)), 0, i+1);
        }
        grid.add(new Label("y/x"), 0 ,0);
        for (IMapElement element : elements){
            Label temp = new Label(element.toString());
            grid.add(temp, element.getPosition().x - corners[0].x + 1,
                    corners[1].y - element.getPosition().y + 1);
            GridPane.setHalignment(temp, HPos.CENTER);
            GridPane.setValignment(temp, VPos.CENTER);
        }
        Scene scene = new Scene(grid, width*40, height*40);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
