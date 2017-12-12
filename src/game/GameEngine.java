package game;

import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import objects.GameObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khaled on 12/12/17.
 */
public class GameEngine {
    private MouseEvent mouse;
    private KeyEvent key;

    private Pane pane;

    private List<GameObject> gameObjects;

    private final long[] frameTimes = new long[100];
    private int frameTimeIndex = 0;
    private boolean arrayFilled = false;

    public GameEngine(Pane pane) {
        this.pane = pane;
        gameObjects = new ArrayList<>();
        initializeEventHandlers();
        createGameLoop();
    }

    public void addGameObject(GameObject gameObject) {
        gameObjects.add(gameObject);
    }

    public void removeGameObject(GameObject gameObject) {
        gameObjects.remove(gameObject);
    }

    private void createGameLoop() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                for (GameObject gameObject : gameObjects) {
                    gameObject.update();
                }
                refreshFrameRate(now);
            }
        }.start();
    }

    private void initializeEventHandlers() {
        pane.setOnMouseMoved(event -> mouse = event);
        pane.setOnKeyPressed(event -> {
            key = event;
            System.out.println( key.getText());
        });

        pane.setOnKeyReleased(event -> {

            if (key != null && key.getCode() == event.getCode()) {
                key = null;
            }
        });
    }

    private void refreshFrameRate(long now) {
        long oldFrameTime = frameTimes[frameTimeIndex] ;
        frameTimes[frameTimeIndex] = now ;
        frameTimeIndex = (frameTimeIndex + 1) % frameTimes.length ;
        if (frameTimeIndex == 0) {
            arrayFilled = true ;
        }
        if (arrayFilled) {
            long elapsedNanos = now - oldFrameTime ;
            long elapsedNanosPerFrame = elapsedNanos / frameTimes.length ;
            double frameRate = 1_000_000_000.0 / elapsedNanosPerFrame ;
            System.out.println(String.format("Current frame rate: %.3f", frameRate));
        }
    }
}
