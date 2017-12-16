package characters.states;

import javafx.scene.image.Image;

import java.util.List;

/**
 * Created by khaledabdelfattah on 12/13/17.
 */
public class SpritesIterator {
    private List<Image> sprites;
    private int idx = 0;

    public SpritesIterator(List<Image> sprites) {
        this.sprites = sprites;
    }

    public Image getCurrentImage() {
        Image currentImage = sprites.get(idx);
        iterate();
        return currentImage;
    }

    private void iterate() {
        idx++;
        idx %= sprites.size();
    }
}
