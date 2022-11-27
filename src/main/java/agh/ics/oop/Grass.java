package agh.ics.oop;
import javafx.scene.image.Image;
import java.io.FileNotFoundException;

public class Grass implements IMapElement {
    final private Vector2d position;
    public Grass(Vector2d position){
        this.position = position;
    }
    public Vector2d getPosition(){
        return this.position;
    }
    public String toString(){
        return "*";
    }
    public Image getImage() throws FileNotFoundException {
        return new Image("file:src/main/resources/grass.png");
    }

}
