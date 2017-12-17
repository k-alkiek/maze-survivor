package maze.drawer;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @web java-buddy.blogspot.com
 */
public class Sample extends Application {


    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, 1024, 650, Color.WHITE);

        primaryStage.setTitle("testMaze");
        primaryStage.setScene(scene);
        primaryStage.show();

        MazeDrawer mazeDrawer = new MazeDrawer(root, 10, 0.05, 0.01 /2);
        mazeDrawer.constructMaze();
        mazeDrawer.displayMaze();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}