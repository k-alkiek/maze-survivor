package characters.states;

import characters.Player;
import game.Keyboard;
import game.Mouse;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import lib.NaturalOrderComparator;
import maze.drawer.MazeDrawer;

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

    protected synchronized void walk(Player player) {
        int speed = 5;
//      ImageView clone = new ImageView();
//      clone.setX(player.getX() + 10);
//      clone.setY(player.getY() + 10 );
//      //setting the fit height and width of the image view
//      clone.setFitHeight(player.getImageView().getFitHeight() - 40);
//      clone.setFitWidth(player.getImageView().getFitWidth() - 40);
//    //Setting the preserve ratio of the image view
//      clone.setPreserveRatio(true);
        if (keyboard.isPressed(KeyCode.W)) {
        	if(!player.isCollided()) {
        		player.setY(player.getY() - speed);
        	} else {
//        		while(player.isCollided()) {
        			player.setY(player.getY() + speed);
//        		}
        	}
        }
        if (keyboard.isPressed(KeyCode.S)) {
        	if(!player.isCollided()) {
        		player.setY(player.getY() + speed);
        	} else {
//        		while(player.isCollided()) {
            		player.setY(player.getY() - speed);
//        		}
        	}
        }
        if (keyboard.isPressed(KeyCode.A)) {
        	if(!player.isCollided()) {
        		player.setX(player.getX() - speed);
        	} else {
//        		while(player.isCollided()) {
            		player.setX(player.getX() + speed);
//        		}
        	}
        }
        if (keyboard.isPressed(KeyCode.D)) {
        	if(!player.isCollided()) {
        		player.setX(player.getX() + speed);
        	} else {
//        		while(player.isCollided()) {
            		player.setX(player.getX() - speed);
//        		}
        	}
        }
    }

}
