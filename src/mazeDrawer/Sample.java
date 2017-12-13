package mazeDrawer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import maze.generateAlgorithm.MazeGenerator;

/**
 * @web java-buddy.blogspot.com
 */
public class Sample extends Application {
    

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 1024, 650, Color.WHITE);

        primaryStage.setTitle("testMaze");
        primaryStage.setScene(scene);
        primaryStage.show();

        MazeDrawer mazeDrawer = new MazeDrawer(root, 30, 0.05, 0.01);
        mazeDrawer.drawMaze();                
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}