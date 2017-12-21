package game;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import objects.GameObject;

import java.util.Calendar;

/**
 * Created by khaled on 12/20/17.
 */
public class HeadsUpDisplay extends GameObject {
    private Canvas canvas;
    private GraphicsContext gc;
    private Pane pane;

    public HeadsUpDisplay(GameEngine gameEngine, Canvas canvas) {
        super(gameEngine);
    	DBLogger.getInstance().log.info(this.getClass().getSimpleName() + " created.");
        this.canvas = canvas;
        gc = canvas.getGraphicsContext2D();
        pane = GameEngine.getInstanceOf().getPane();
        canvas.toFront();
    }

    @Override
    public void update() {
        canvas.setWidth(pane.getWidth());
        canvas.setHeight(pane.getHeight());
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        System.out.println(canvas);

        gc.setFill(Color.FIREBRICK);
        gc.fillRect(20, canvas.getHeight() - 80, 200, 20);

        gc.setFill(Color.RED);
        gc.fillRect(20, canvas.getHeight() - 50, 200, 20);

        canvas.toFront();
    }

}
