package characters.states;

import characters.Player;
import game.GameEngine;
import javafx.scene.media.AudioClip;

import java.io.File;

/**
 * Created by khaledabdelfattah on 12/13/17.
 */
public class ReloadingState extends State {
    private int currentFrame = 0;

    public ReloadingState(String character) {
        super();
        String path = "src/assets/player/" + character + "/reload";
        loadSprites(path);
        framePerState = 0;
    }

    @Override
    public void update(Player player) {
        walk(player);
        setSpritesPerFrame(player);
        currentFrame++;
        if (currentFrame >= 5) {
            player.getWeapon().reload();
            currentFrame = 0;
        }
        if (framePerState == sprites.size()) {
            framePerState = 0;
            if (walking()) {
                player.setCurrentState(StatesPool.getNextState("WalkingState"));
            } else {
                player.setCurrentState(StatesPool.getNextState("IdleState"));
            }
        }
    }
}
