package monsters.states;

import characters.states.SpritesIterator;
import game.Keyboard;
import game.Mouse;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import lib.NaturalOrderComparator;
import monsters.Monster;
import monsters.commands.*;

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
    private List<MoveCommand> moveCommands;
    private int commandIndex;
    public abstract void update(Monster monster);

    public MonsterState() {
        sprites = new ArrayList<>();
        spritesIterator = new SpritesIterator(sprites);
        keyboard = Keyboard.getInstanceOf();
        mouse = Mouse.getInstanceOf();
        initializeCommands();
    }

    private void initializeCommands() {
        commandIndex = 0;
        moveCommands = new ArrayList<>();
        moveCommands.add(new MoveUp());
        moveCommands.add(new MoveRight());
        moveCommands.add(new MoveDown());
        moveCommands.add(new MoveLeft());
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
        if (framePerState > 50) {
            commandIndex = new Random().nextInt(4);
            framePerState = 0;
        }
        int counter = 0;
        while (!moveCommands.get(commandIndex).execute(monster)) {
        	counter++;
            commandIndex = new Random().nextInt(4);
            if (counter == 20) {
            	break;
            }
        }
    }
}
