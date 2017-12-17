import characters.Player;
import game.GameEngine;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import maze.drawer.MazeDrawer;

/**
 * Created by khaled on 12/12/17.
 */
public class Game extends Application {
    GameEngine gameEngine;

    @Override
    public void start(Stage primaryStage) {
        gameEngine = GameEngine.getInstanceOf();
        Pane pane = gameEngine.getPane();
        MazeDrawer mazeDrawer = new MazeDrawer(pane, 10, 0.05, 0.01 /2);
        mazeDrawer.constructMaze();
        mazeDrawer.displayMaze();
        Scene scene = new Scene(pane, 900, 800);
        primaryStage.setScene(scene);

        new Player(gameEngine, 75, 75, null);
        primaryStage.show();
        pane.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
