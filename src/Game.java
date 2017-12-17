import characters.Player;
import game.GameEngine;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import monsters.Monster;

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
        new Monster(gameEngine, 800, 800);
        new Monster(gameEngine, 1000, 1000);
        primaryStage.show();
        pane.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
