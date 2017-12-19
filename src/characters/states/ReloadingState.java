package characters.states;

import characters.Player;
import game.GameEngine;
import javafx.scene.media.AudioClip;

import java.io.File;

/**
 * Created by khaledabdelfattah on 12/13/17.
 */
public class ReloadingState extends State {
    private static AudioClip reloadSound = new AudioClip(new File("src/assets/player/sounds/reload.wav").toURI().toString());

    public ReloadingState() {
        super();
        loadSprites("src/assets/player/handgun/reload");
        framePerState = 0;

        GameEngine.getInstanceOf().getSoundHandler().playSound(reloadSound, 0.5, true);
    }
    @Override
    public void update(Player player) {
        walk(player);
        setSpritesPerFrame(player);


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
