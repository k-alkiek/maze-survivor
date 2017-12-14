package characters.states;

import characters.Player;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import lib.NaturalOrderComparator;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Arrays;
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
}
