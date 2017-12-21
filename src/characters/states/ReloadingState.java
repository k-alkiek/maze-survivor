package characters.states;

import characters.Player;
import game.GameEngine;
import javafx.scene.media.AudioClip;

import java.io.File;

/**
 * Created by khaledabdelfattah on 12/13/17.
 */
public class ReloadingState extends State {
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

        player.getWeapon().reload();

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
