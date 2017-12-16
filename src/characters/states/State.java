package characters.states;

import characters.Player;
import game.Keyboard;
import game.Mouse;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import lib.NaturalOrderComparator;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;

/**
 * Created by khaled on 12/13/17.
 */
public abstract class State {
    protected List<Image> sprites;
    protected SpritesIterator spritesIterator;
    protected Keyboard keyboard;
    protected Mouse mouse;
    protected int perFrame = 4, currFrame = 0, framePerState = 0;

    public abstract void update(Player player);

    public State() {
        sprites = new ArrayList<>();
        spritesIterator = new SpritesIterator(sprites);
        keyboard = Keyboard.getInstanceOf();
        mouse = Mouse.getInstanceOf();
    }

    protected void loadSprites(String path) {
        sprites.clear();
        File directory = new File(path);
        List<File> spriteFiles = Arrays.asList(directory.listFiles());
        Collections.sort(spriteFiles, new NaturalOrderComparator());

        for (File spriteFile : spriteFiles) {
            try {
                sprites.add(new Image(new FileInputStream(spriteFile)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean walking() {
        boolean isPressed = false;
        isPressed |= keyboard.isPressed(KeyCode.W);
        isPressed |= keyboard.isPressed(KeyCode.D);
        isPressed |= keyboard.isPressed(KeyCode.S);
        isPressed |= keyboard.isPressed(KeyCode.A);
        return isPressed;
    }

    protected void setSpritesPerFrame(Player player) {
        currFrame++;
        if (currFrame >= perFrame) {
            player.setSprite(spritesIterator.getCurrentImage());
            framePerState ++;
            currFrame = 0;
        }
    }

    protected void walk(Player player) {
        int speed = 5;
        if (keyboard.isPressed(KeyCode.W)) {
            player.setY(player.getY() - speed);
        }
        if (keyboard.isPressed(KeyCode.S)) {
            player.setY(player.getY() + speed);
        }
        if (keyboard.isPressed(KeyCode.A)) {
            player.setX(player.getX() - speed);
        }
        if (keyboard.isPressed(KeyCode.D)) {
            player.setX(player.getX() + speed);
        }
    }
}
