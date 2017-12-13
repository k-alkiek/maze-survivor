package characters.states;

import characters.Player;
import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by khaled on 12/13/17.
 */
public abstract class State {
    protected List<Image> sprites;
    protected SpritesIterator spritesIterator;

    public abstract void update(Player player);

    public State() {
        sprites = new ArrayList<>();
        spritesIterator = new SpritesIterator(sprites);
    }

    protected void loadSprites(String path) {
        sprites.clear();
        File directory = new File(path);
        System.out.println(directory.getPath());
        System.out.println(directory.isDirectory());
        for (File spriteFile : directory.listFiles()) {
            try {
                sprites.add(new Image(new FileInputStream(spriteFile)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
