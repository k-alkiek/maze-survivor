import characters.Player;
import game.GameEngine;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by khaled on 12/12/17.
 */
public class Game extends Application {
    GameEngine gameEngine;

    @Override
    public void start(Stage primaryStage) {
        gameEngine = GameEngine.getInstanceOf();
        Pane pane = gameEngine.getPane();
        Scene scene = new Scene(pane, 800, 600);
        primaryStage.setScene(scene);

        new Player(gameEngine, 0, 0, null);
        primaryStage.show();
        pane.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
