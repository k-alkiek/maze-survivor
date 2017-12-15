import game.GameEngine;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import objects.GameObject;
import objects.SampleGameObejct;

/**
 * Created by khaled on 12/12/17.
 */
public class Game extends Application {
    GameEngine gameEngine;

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 800, 600);
        primaryStage.setScene(scene);

        gameEngine = new GameEngine(pane);

        new SampleGameObejct(gameEngine);
        primaryStage.show();
        pane.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
