package game;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import objects.GameObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khaled on 12/12/17.
 */
public class GameEngine {
    private Mouse mouse;
    private Keyboard keyboard;

    private Pane pane;

    private List<GameObject> gameObjects;

    private final long[] frameTimes = new long[100];
    private int frameTimeIndex = 0;
    private boolean arrayFilled = false;

    public GameEngine(Pane pane) {
        this.pane = pane;
        gameObjects = new ArrayList<>();
        initializeInput();
        createGameLoop();
    }

    private void createGameLoop() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                for (GameObject gameObject : gameObjects) {
                    gameObject.update();
                }
                testAllInput();
                refreshInput();
                pane.requestFocus();
            }
        }.start();
    }

    public Pane getPane() {
        return pane;
    }


    public void addGameObject(GameObject gameObject) {
        gameObjects.add(gameObject);
    }

    public void removeGameObject(GameObject gameObject) {
        gameObjects.remove(gameObject);
    }

    private void initializeInput() {
        keyboard = new Keyboard(this);
        mouse = new Mouse(this);
    }

    private void refreshInput() {
        mouse.refresh();
        keyboard.refresh();
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

    private void testAllInput() {
        System.out.println("Mouse X: " + mouse.getX() + ", Mouse Y: " + mouse.getY());
        if (mouse.isScrollingUp()) System.out.println("Up");
        if (mouse.isScrollingDown()) System.out.println("Down");
        if (!mouse.getButtonsPressed().isEmpty()) System.out.println(mouse.getButtonsPressed());
        if (!keyboard.getKeysPressed().isEmpty()) System.out.println(keyboard.getKeysPressed());
    }
}
