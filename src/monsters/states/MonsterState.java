package monsters.states;

import characters.states.SpritesIterator;
import game.Keyboard;
import game.Mouse;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import lib.NaturalOrderComparator;
import maze.drawer.MazeDrawer;
import monsters.Monster;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

/**
 * Created by khaledabdelfattah on 12/17/17.
 */
public abstract class MonsterState {
    protected List<Image> sprites;
    protected SpritesIterator spritesIterator;
    protected Keyboard keyboard;
    protected Mouse mouse;
    protected int perFrame = 3, currFrame = 0, framePerState = 0;

    public abstract void update(Monster monster);

    public MonsterState() {
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

    protected void setSpritesPerFrame(Monster monster) {
        currFrame++;
        if (currFrame >= perFrame) {
            monster.setSprite(spritesIterator.getCurrentImage());
            framePerState++;
            currFrame = 0;
        }
    }

    protected void walk(Monster monster) {
        int speed = 3;
        char[][] maze = MazeDrawer.maze;

    }
}
