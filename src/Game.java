import characters.Player;
import characters.PlayerBuilder;
import characters.Shadow;
import game.GameEngine;
import game.HeadsUpDisplayUI;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import maze.drawer.EasyLevel;
import maze.drawer.LevelGenerator;
import objects.ClonedObject;
import sound.SoundHandler;

/**
 * Created by khaled on 12/12/17.
 */
public class Game extends Application {
    GameEngine gameEngine;

    @Override
    public void start(Stage primaryStage) {
        gameEngine = GameEngine.getInstanceOf();
        ClonedObject.initializeClonedObjectDimension(80);
        Player player = new PlayerBuilder().preparePlayerWithPistol(75, 75, 30);
        gameEngine.setPlayer(player);
        gameEngine.setSoundHandler(new SoundHandler(player));

        Pane pane = gameEngine.getPane();
        ScrollPane scrollPane = gameEngine.getScrollPane();
        scrollPane.setContent(pane);
        LevelGenerator mazeDrawer = new EasyLevel(pane, 50, 0.03, 0.01 /2);
        mazeDrawer.constructMaze();
        mazeDrawer.displayMaze();


        Pane HUDPane = new Pane();
        new HeadsUpDisplayUI(mazeDrawer.gameManager, HUDPane);
        gameEngine.setHUDPane(HUDPane);
        StackPane stackPane = new StackPane(scrollPane, HUDPane);
        

        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        Scene scene = new Scene(stackPane, 900, 800);
        primaryStage.setScene(scene);

        scrollPane.setOnMouseMoved(event -> System.out.println(event.getX()));
        primaryStage.show();
        pane.requestFocus();  
    }

    public static void main(String[] args) {
        launch(args);
    }
}
