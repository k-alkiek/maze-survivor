package game;

import characters.Player;
import characters.PlayerBuilder;
import characters.Shadow;
import gun.Shotgun;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;
import objects.ClonedObject;
import objects.CollidableGameObject;
import objects.GameObject;
import sound.SoundHandler;

import java.util.ArrayList;
import java.util.List;


import gun.Weapon;

/**
 * Created by khaled on 12/12/17.
 */
public class GameEngine {
    private static GameEngine gameEngine;
    private Mouse mouse;
    private Keyboard keyboard;

    private SoundHandler soundHandler;

    private Player player;

    private Pane pane;
    private Pane HUDPane;

    private List<GameObject> gameObjects;

    private final long[] frameTimes = new long[100];
    private int frameTimeIndex = 0;
    private boolean arrayFilled = false;

    private GameEngine() {
        pane = new Pane();
        gameObjects = new ArrayList<>();
        initializeInput();
        createGameLoop();


//        player = new PlayerBuilder().preparePlayerWithShotgun(this, 75, 75, 6);



    }

    public Player getPlayer() {
		return this.player;
	}

    public void setPlayer(Player player) {
        this.player = player;
    }

	public static GameEngine getInstanceOf() {
        if (gameEngine == null) {
            gameEngine = new GameEngine();
        }
        return gameEngine;
    }

    private void createGameLoop() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                pane.requestFocus();
                GameObject gameObject;
                for (int i = gameObjects.size() - 1; i >= 0; i--) {
                    gameObject = gameObjects.get(i);
                    gameObject.update();
                }
                testAllInput();
                refreshInput();
                pane.requestFocus();
//                refreshFrameRate(now);
            }
        }.start();
    }

    public Pane getPane() {
        return pane;
    }


    public Mouse getMouse() {
        return mouse;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }


    public void addGameObject(GameObject gameObject) {
        gameObjects.add(gameObject);
    }

    private void initializeInput() {
        keyboard = Keyboard.getInstanceOf();
        mouse = Mouse.getInstanceOf();
        keyboard.initialize(pane);
        mouse.initialize(pane);
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
        //System.out.println("Mouse X: " + mouse.getX() + ", Mouse Y: " + mouse.getY());
        if (mouse.isScrollingUp()) System.out.println("Up");
        if (mouse.isScrollingDown()) System.out.println("Down");
        if (!mouse.getButtonsPressed().isEmpty()) System.out.println(mouse.getButtonsPressed());
        if (!keyboard.getKeysPressed().isEmpty()) System.out.println(keyboard.getKeysPressed());
    }

    /**
     * Unsubscribes the game object and removes it from the list of
     * regularly updated game objects.
     * 
     * @param destroyed
     */
    public void destroyGameObject(GameObject destroyed) {
    	gameObjects.remove(destroyed);
    	if (destroyed instanceof CollidableGameObject) {
    		pane.getChildren().remove(((CollidableGameObject) destroyed).getImageView());
    	}
    }

	public List<GameObject> getGameObjects() {
		return gameObjects;
	}

    public SoundHandler getSoundHandler() {
        return soundHandler;
    }

    public void setHUDPane(Pane HUDPane) {
        this.HUDPane = HUDPane;
        keyboard.initialize(HUDPane);
        mouse.initialize(HUDPane);
    }

    public void setSoundHandler(SoundHandler soundHandler) {
        this.soundHandler = soundHandler;
    }
}
