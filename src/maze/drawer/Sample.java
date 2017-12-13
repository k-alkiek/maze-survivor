package maze.drawer;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

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