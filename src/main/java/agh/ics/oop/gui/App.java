package agh.ics.oop.gui;
import agh.ics.oop.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    private final int CELL_SIZE = 30;
    private MyGrid grid;
    private Thread thread;
    public void init(){
        String[] args = getParameters().getRaw().toArray(new String[0]);
        MoveDirection[] directions;
        GrassField map = new GrassField(10);
        this.grid = new MyGrid(map, CELL_SIZE);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(2, 3)};
        SimulationEngine engine;
        try {
            directions = OptionsParser.parse(args);
            engine = new SimulationEngine(directions, map, positions, grid, 500);
            thread = new Thread(engine);
        } catch (IllegalArgumentException exeption) {
            System.err.println(exeption.getMessage());
            System.exit(1);
        }

    }

    public void start(Stage primaryStage){
        thread.start();
        Scene scene = new Scene(grid, grid.width*(CELL_SIZE), grid.height*(CELL_SIZE));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
