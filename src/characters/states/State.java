package characters.states;

import characters.Player;
import javafx.scene.image.Image;

import java.io.File;
import java.util.List;

/**
 * Created by khaled on 12/13/17.
 */
public abstract class State {
    protected List<Image> sprites;

    public abstract void update(Player player);

    protected void loadSprites(String path) {
        sprites.clear();
        File directory = new File(path);
        for (String spritePath : directory.list()) {
            sprites.add(new Image(spritePath));
        }
    }
}
